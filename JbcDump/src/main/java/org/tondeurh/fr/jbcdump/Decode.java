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
    
    ClassFile classFile;
    Tools t;
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
    classFile=new ClassFile();
    cp=new ConstantPool(classFile,t);
    it=new Interfaces(classFile,t);
    fi=new Fields(classFile,t);
    me=new Methodes(classFile, t);
    at=new Attributes(classFile, t);
    this.t=t;
    }
   
    /************************
     * Decode ClassFile
 from memory 
     ************************/
    public void decodeClassFile()
    {
        //recuperer le nombre magique du fichier...
        classFile.setMagic(t.getNextBytes(4));
        //tester le nbre magique avant de continuer est ce le bon format?
                if (!t.testMagicNumber(t.Hex(classFile.getMagic(),false,false)))
                {
                    t.exit("Ce n'est pas le bon format de fichier...");
                }
        
        //decode les versions major et minor
        classFile.setMinor_version(t.getNextBytes(2));//4-5
        classFile.setMajor_version(t.getNextBytes(2));//6-7
        
        //nb of constant pool string ?
        classFile.setConstant_pool_count(t.getNextBytes(2));//8-9
        
        System.out.println("Magic number : "+t.Hex(classFile.getMagic(),false,true));
        System.out.println("Major version : "+t.Int(classFile.getMajor_version()));
        System.out.println(t.MVTab(classFile.getMajor_version()));
        System.out.println("Minor version : "+t.Int(classFile.getMinor_version()));
        
        System.out.println("------------CONSTANTS POOL------------");
        System.out.println("constant pool count : "+t.Int(classFile.getConstant_pool_count()));
        
        //lire la table constant pool 
        cp.constant_pool_read();
        cp.constant_pool_print();
        
        System.out.println("------------------------");
        //access FLAGS
        classFile.setAccess_flags(t.getNextBytes(2));
        System.out.println("Access FlagS : "+t.AFTab(t.Int(classFile.getAccess_flags())));
        
        //this class
        classFile.setThis_class(t.getNextBytes(2));
        System.out.println("This Class : #"+t.Int(classFile.getThis_class()));
        
        //super class
        classFile.setSuper_class(t.getNextBytes(2));
        System.out.println("Super Class : #"+t.Int(classFile.getSuper_class()));
          
        System.out.println("------------INTERFACES------------");
        //Interfaces count
        classFile.setInterfaces_count(t.getNextBytes(2));
        System.out.println("interfaces count : "+t.Int(classFile.getInterfaces_count()));
        
        //interfaces_info interfaces[interfaces_count];
       if (t.Int(classFile.getInterfaces_count())>0)
       {
           it.interfaces_infos_read();
           it.interfaces_infos_print();
       }
        
        System.out.println("------------FIELDS------------");
        //u2 fields_count;
        classFile.setFields_count(t.getNextBytes(2));
        System.out.println("Fields count : "+t.Int(classFile.getFields_count()));
        
        //field_info fields[fields_count];
        if (t.Int(classFile.getFields_count())>0)
       {
           fi.fields_infos_read();
           fi.fields_infos_print();
       }
  
        System.out.println("------------METHODS------------");
        //u2 methods_count;
        classFile.setMethods_count(t.getNextBytes(2));
        System.out.println("Methods count : "+t.Int(classFile.getMethods_count()));
        
        //method_info methods[methods_count];
        if (t.Int(classFile.getMethods_count())>0)
       {
           me.methodes_infos_read();
           me.methodes_infos_print();
       }

        System.out.println("------------ATTRIBUTES------------");
        //u2 attributes_count;
        classFile.setAttributes_count(t.getNextBytes(2));
        System.out.println("Attributes count : "+t.Int(classFile.getAttributes_count()));


        //attribute_info attributes[attributes_count];
        if (t.Int(classFile.getAttributes_count())>0)
       {
           at.attributes_infos_read();
           at.attributes_infos_print();
       }  
     //////////////////////
     System.exit(0);
     /////////////////////   
    }
                 

}
