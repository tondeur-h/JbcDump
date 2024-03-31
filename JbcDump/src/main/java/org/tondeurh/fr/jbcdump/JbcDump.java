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
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

/**
 *
 * @author herve
 */
public class JbcDump {

    //bytecode de la classe
    byte[] byteCodeClassMem;
    //les options de la CLI
    Options options = new Options();
    /***************
     * MAIN
     * @param args
     ***************/
    public static void main(String[] args) {
        new JbcDump(args);
    }

    /******************
     * Gerer la ligne des
     * options de le CLI
     * @param args 
     ******************/
    private void ligneOptions(String[] args)
    {
        try {
        //path du fichier class
        Option fichierClass=Option.builder("f")
                .hasArg(true)
                .numberOfArgs(1)
                .argName("file")
                .desc("Chemin du fichier de la classe...")
                .required(true)       
                .build();
        options.addOption(fichierClass);
        
        //show Bytes
        Option showByte=Option.builder("sb")
                .hasArg(false)
                .desc("Afficher les octets sur l'écran.")
                .required(true)
                .numberOfArgs(1)
                .argName("nbbytes")
                .build();
        options.addOption(showByte);
        
        
        //traiter ligne de commande
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(options, args);
          
        if (cmd.hasOption("f"))
            {
                String path=cmd.getOptionValue("f");
                if (!chargerClasse(path)){exitAndHelp("Chemin de la classe incorrect. option f");}
            }
        
        if (cmd.hasOption("sb"))
            {
                int nb=Integer.parseInt(cmd.getOptionValue("sb"),10);
                showBytes(nb);
            }
          
        
        //decoder le fichier class
        Decoder decoder=new Decoder(byteCodeClassMem);
        if (!testMagicNumber(decoder.getFileMagicNumber()))
        {
            exitAndHelp("Ce n'est pas le bon format de fichier...");
        }
        //ok decode le fichier...
        decoder.decodeClassFile();
        
        } catch (ParseException ex) {
             //DEFAUT
            exitAndHelp(ex.getMessage());
        }
    }
    
    
    /****************
     * CONSTRUCTEUR 
     * @param args
     ****************/
    public JbcDump(String[] args) 
    {
        ligneOptions(args);
    }
    
    /************************************
     * chargeur du bytecode de la classe
     * @param path
     * @return
     ************************************/
    public boolean chargerClasse(String path)
    {
        //verifier que le fichier existe
        if (!new File(path).exists())
        {
            exitAndHelp("fichier "+path+" non trouvé.");
        }
        
        DataInputStream dis=null;
        try {
            //TODO
            dis = new DataInputStream(new FileInputStream(path));
            System.out.println("Upload in memory : "+path);
            byteCodeClassMem=dis.readAllBytes();
            System.out.println("Bycode Size : "+byteCodeClassMem.length+" octets");
        } catch (FileNotFoundException ex) {
            exitAndHelp(ex.getMessage());
        } catch (IOException ex) {
            exitAndHelp(ex.getMessage());
        } finally {
            try {
                dis.close();
            } catch (IOException ex) {
            exitAndHelp(ex.getMessage());
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
        hp.printHelp("XXXX", "Options :", options, "------------------", true);
        
    }

    /******************************
     * Afficher les octets à l'écran
     ******************************/
    private void showBytes(int nbbytes) {
        int i;
        String result="";
        for (i=0; i < byteCodeClassMem.length; i++) 
        {
            if ((i % nbbytes)==0){System.out.println(result);result=formatBCCounter(i,12)+" : ";}
            result += Integer.toString((byteCodeClassMem[i] & 0xff)+0x100,16)
                    .substring( 1 )+" ";
        }
        System.out.println(result);
    }

    /**********************
     * formater le compteur
     * @param i
     * @param size
     * @return 
     **********************/
    private String formatBCCounter(int i,int size) {
    StringBuilder sb = new StringBuilder();
    for(int cpt=0; cpt<size; cpt++){sb.append("0");}
     String chaine=sb.toString()+Integer.toString(i, 10);
     int len=chaine.length();
     chaine=chaine.substring(len-size);
     return chaine;
    }

    /*************************
     * Test magic number from file
     * @param fileMagicNumber
     * @return 
     ************************/
    private boolean testMagicNumber(String fileMagicNumber) {
        return fileMagicNumber.compareToIgnoreCase("cafebabe")==0; 
    }
    
}