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

import org.tondeurh.fr.jbcdump.containers.ClassFile;
import org.tondeurh.fr.jbcdump.tools.Tools;
/****************
 *
 * @author herve
 ***************/
public class Decode {
    
    Tools t; //transmis
    ClassFile classFile;
    ConstantPool cp;
    Interfaces it;
    Fields fi;
    Methodes me;
    Attributes at;
    
    /***************
     * CONSTRUCTEUR
     * @param t
     ***************/
    public Decode(Tools t) {
    //construire les objets des classes du classFile
    classFile=new ClassFile();
    cp=new ConstantPool(classFile,t);
    it=new Interfaces(classFile,t);
    fi=new Fields(classFile,t);
    me=new Methodes(classFile, t);
    at=new Attributes(classFile, t);
    this.t=t; //transmettre le pointeur des tools
    }
   
    /************************
     * Decode ClassFile
     * a partir du tab de byte 
     * en mémoire.
     ************************/
    public void decodeClassFile()
    {
        //recuperer le nombre magique du fichier, les 4 premiers octets
        classFile.setMagic(t.getNextBytes(4,"Magic number"));
        //tester le nbre magique avant de continuer est ce le bon format?
        //c'est la seule vérificaton que l'on fait ici, bien que la documentation
        //indique d'autres éléments à checker!
                if (!t.testMagicNumber(t.Hex(classFile.getMagic(),false,false)))
                {
                    t.exit("Ce n'est pas le bon format de fichier..."); //bye bye
                }
        
        //decode les versions majeure et mineure
        //on ne fra pas de contrôles de cohérences du contenu.
        //sur 2 octets pour chacun
        classFile.setMinor_version(t.getNextBytes(2,"minor version"));
        classFile.setMajor_version(t.getNextBytes(2,"major version"));

        //un peut d'affichages
        System.out.println("Magic number : "+t.Hex(classFile.getMagic(),false,true));
        //System.out.println("Major version : "+t.Int2(classFile.getMajor_version()));
        //convertir le numero de version majeur en chaine explicative.
        System.out.println(t.Versions_VTab(classFile.getMajor_version()));
        System.out.println("Minor version : "+t.Int2(classFile.getMinor_version()));
        
        System.out.println("------------CONSTANTS POOL------------");
        //nombre d'elements CONSTANT_Pool
        classFile.setConstant_pool_count(t.getNextBytes(2,"CP count"));
        System.out.println("constant pool count : "+t.Int2(classFile.getConstant_pool_count()));
        
        //Decoder la table CONSTANT_pool 
        cp.constant_pool_read();
        cp.constant_pool_print();
        
        System.out.println("------------------------");
        //access FLAGS
        classFile.setAccess_flags(t.getNextBytes(2,"Access flags"));
        System.out.println("Access FlagS : "+t.Class_AFTab(t.Int2(classFile.getAccess_flags())));
        
        //this class
        classFile.setThis_class(t.getNextBytes(2,"This Class"));
        System.out.print("This Class : #"+t.Int2(classFile.getThis_class())+" ");
        System.out.println(cp.resolve_constant_pool(t.Int2(classFile.getThis_class())));
        
        //super class
        classFile.setSuper_class(t.getNextBytes(2,"Super Class"));
        System.out.print("Super Class : #"+t.Int2(classFile.getSuper_class())+" ");
        System.out.println(cp.resolve_constant_pool(t.Int2(classFile.getSuper_class())));  
        
        System.out.println("------------INTERFACES------------");
        //Interfaces count
        classFile.setInterfaces_count(t.getNextBytes(2,"Interfaces count"));
        System.out.println("interfaces count : "+t.Int2(classFile.getInterfaces_count()));
        
        //interfaces_info interfaces[interfaces_count];
       if (t.Int2(classFile.getInterfaces_count())>0)
       {
           it.interfaces_infos_read();
           it.interfaces_infos_print(cp);
       }
        
        System.out.println("------------FIELDS------------");
        //u2 fields_count;
        classFile.setFields_count(t.getNextBytes(2,"Fields count"));
        System.out.println("Fields count : "+t.Int2(classFile.getFields_count()));
        
        //field_info fields[fields_count];
        if (t.Int2(classFile.getFields_count())>0)
       {
           fi.fields_infos_read();
           fi.fields_infos_print();
       }
  
        System.out.println("------------METHODS------------");
        //u2 methods_count;
        classFile.setMethods_count(t.getNextBytes(2,"Methods count"));
        System.out.println("Methods count : "+t.Int2(classFile.getMethods_count()));
        
        //method_info methods[methods_count];
        if (t.Int2(classFile.getMethods_count())>0)
       {
           me.methodes_infos_read();
           me.methodes_infos_print();
       }

        System.out.println("------------ATTRIBUTES------------");
        //u2 attributes_count;
        classFile.setAttributes_count(t.getNextBytes(2,"Attributes count"));
        System.out.println("Attributes count : "+t.Int2(classFile.getAttributes_count()));


        //attribute_info attributes[attributes_count];
        if (t.Int2(classFile.getAttributes_count())>0)
       {
           at.attributes_infos_read();
           at.attributes_infos_print();
       }  
     //////////////////////
     System.exit(0);
     /////////////////////   
    }
                 

}
