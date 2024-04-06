/*
 * Copyright (C) 2024 herve
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.tondeurh.fr.jbcdump;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.tondeurh.fr.jbcdump.tools.Tools;

/**
 *
 * @author herve
 */
public class JbcDump {

    //bytecode de la classe 
    //espace mémoire pour le chargement
    byte[] byteCodeClassMem;
    //les options de la CLI
    Options options = new Options();
    Tools t; //initialiser les tools des maintenant car utilisé ici 
    
    
    /***************
     * MAIN
     * @param args
     ***************/
    public static void main(String[] args) {
        JbcDump jbcDump = new JbcDump(args); //pas d'appel statiques
    }

    /******************
     * Gerer la ligne des
     * options de le CLI
     * @param args 
     ******************/
    private void ligneOptions(String[] args)
    {
        try {
        //path du fichier class option obligatoire
        Option fichierClass=Option.builder("f")
                .hasArg(true)
                .numberOfArgs(1)
                .argName("file")
                .desc("Chemin du fichier de la classe...")
                .required(true)       
                .build();
        options.addOption(fichierClass);
        
        //show Bytes Permet d'afficher le fichier sous format octets
        //selon une largeur d'octet au choix de l'utilisateur.
        //bloquer a max 64
        //option optionnelle
        Option showByte=Option.builder("sb")
                .hasArg(true)
                .desc("Afficher les octets sur l'écran, entre 8 et 64 octets de largeur.")
                .required(false)
                .numberOfArgs(1)
                .argName("nbbytes")
                .build();
        options.addOption(showByte);
        
        //decompiler la classe 
        //option optionnelle
        Option decompiler=Option.builder("d")
                .hasArg(false)
                .desc("Decompiler la classe.")
                .required(false)
                .numberOfArgs(0)
                .build();
        options.addOption(decompiler);
        
        
        //traiter la ligne de commande
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(options, args);
        
        //traiter l'option file
        if (cmd.hasOption("f"))
            {
                String path=cmd.getOptionValue("f");
                if (!chargerClasse(path)){exitAndHelp("Chemin de la classe incorrect.");}
                else {
                    //obligatoire ici car le fichier doit être chargé avant avec l'option f.
                    //la classe est chargée, creer le pack tools
                    t=new Tools(byteCodeClassMem);
                    //quelques calculs de ccksum pour le fun...
                    System.out.println("CHECKSUM MD5     : "+hashFileCode("MD5"));
                    System.out.println("CHECKSUM SHA 1   : "+hashFileCode("SHA-1"));
                    System.out.println("CHECKSUM SHA 256 : "+hashFileCode("SHA-256"));
                    System.out.println("CHECKSUM SHA 512 : "+hashFileCode("SHA-512"));
                } 
            }
        
        //traiter l'option sb pour l'affichage du fichiers en hexdécimal
        if (cmd.hasOption("sb"))
            {
                int nbOctets=Integer.parseInt(cmd.getOptionValue("sb"),10); //nboctets demandés
                if (nbOctets>64) exitAndHelp("Largeur de l'affichage en octets trop large, réduite la valeur");
                if (nbOctets<8) exitAndHelp("Largeur de l'affichage en octets trop étroit, réduite la valeur");
                //ok on affiche...
                System.out.println(showBytes(nbOctets));
            }
        
        //traiter l'option d => decomiler
        if (cmd.hasOption("d"))
            {
                //decoder le fichier class => parser le fichier en objets 
                Decode decoder=new Decode(t);
                //decode le fichier...
                decoder.decodeClassFile();
            }
        
        //futures options ???
        
        } catch (ParseException ex) {
             //DEFAUT : une erreur s'est produite car option inconnue ou mal rédigée.
            exitAndHelp(ex.getMessage());
        }
    }
    
    
    /****************
     * CONSTRUCTEUR 
     * @param args
     ****************/
    public JbcDump(String[] args) 
    {
        ligneOptions(args); //appeler la ligne d'options de la CLI
    }
    
    /************************************
     * chargeur du bytecode de la classe
     * @param path
     * @return boolean 
     ************************************/
    public boolean chargerClasse(String path)
    {
        //verifier que le fichier existe
        if (!new File(path).exists())
        {
            exitAndHelp("fichier "+path+" non trouvé. Verifiez le chemin!");
        }
        //ok existe => GO
        DataInputStream dis=null; //recomandé dans la documentation
        try {
            //chargement
            dis = new DataInputStream(new FileInputStream(path));
            System.out.println("Chargement en memoire : "+path);
            byteCodeClassMem=dis.readAllBytes();
            System.out.println("Taille du byteCode lu : "+byteCodeClassMem.length+" octets");
        } catch (FileNotFoundException ex) {
            exitAndHelp(ex.getMessage()); //si fichier non trouvé
        } catch (IOException ex) {
            exitAndHelp(ex.getMessage()); //si problème de lecture du fichier
        } finally {
            try {
                dis.close();
            } catch (IOException ex) {
            exitAndHelp(ex.getMessage()); //si problème de fermeture du fichier...
            }
        }
        return true;        
    }

    /********************************************
     * Sortie de l'application et message d'aide.
     * @param message
     ********************************************/
    private void exitAndHelp(String message) 
    {
        System.out.println(message);
        syntaxe();
        System.exit(0);
    }

    /************************************
    * Syntaxe de l'application.
    *************************************/
    private void syntaxe() {
        HelpFormatter hp=new HelpFormatter();
        hp.printHelp(this.getClass().getSimpleName(), "Options :", options, "------------------", true);  
    }

    /******************************
     * Afficher les octets à l'écran
     ******************************/
    private String showBytes(int nbbytes) {
        int i;
        String result="";
        for (i=0; i < byteCodeClassMem.length; i++) 
        {
            //affichage du compteur d'octets
            if ((i % nbbytes)==0){System.out.println(result);result=formatBCCounter(i,12)+" : ";}
            //construire chaque lignes
            result += Integer.toString((byteCodeClassMem[i] & 0xff)+0x100,16)
                    .substring( 1 )+" "; //espace séparateur entre chaque octet
        }
       return result;
    }

    /**********************
     * formater le compteur
     * lateral gauche sur x digits
     * @param compteur
     * @param size
     * @return 
     **********************/
    private String formatBCCounter(int compteur,int size) {
    StringBuilder sb = new StringBuilder();
    //construire une chaine de size de longeur de 0
    //concatener la valeur du compteur et couper la chaine a la taille=size
    for(int cpt=0; cpt<size; cpt++){sb.append("0");} //bourrage de 0 par la gauche
     String chaine=sb.toString()+Integer.toString(compteur, 10);
     int len=chaine.length();
     chaine=chaine.substring(len-size);
     return chaine;
    }

    /********************************
     * calcule le HASH de l'encodage
     * @param encodage
     * @return
     ********************************/
    private String hashFileCode(String encodage){
       byte[] hash = null; 
       try {
            MessageDigest digest = MessageDigest.getInstance(encodage);
            hash = digest.digest(byteCodeClassMem);
        } catch (NoSuchAlgorithmException ex) {
            exitAndHelp(ex.getMessage()); //si problème de calcul du hash
          }
        return t.Hex(hash, false, true); //hexa séparépar un espace et en majuscules
   }
    
}