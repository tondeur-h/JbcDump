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
import java.nio.charset.StandardCharsets;
import org.tondeurh.fr.jbcdump.tools.Tools;
import org.tondeurh.fr.jbcdump.containers.CP_info;
import org.tondeurh.fr.jbcdump.containers.constants.CONSTANT_Class_info;
import org.tondeurh.fr.jbcdump.containers.constants.CONSTANT_Double_info;
import org.tondeurh.fr.jbcdump.containers.constants.CONSTANT_Dynamic_info;
import org.tondeurh.fr.jbcdump.containers.constants.CONSTANT_Fieldref_info;
import org.tondeurh.fr.jbcdump.containers.constants.CONSTANT_Float_info;
import org.tondeurh.fr.jbcdump.containers.constants.CONSTANT_Integer_info;
import org.tondeurh.fr.jbcdump.containers.constants.CONSTANT_InterfaceMethodref_info;
import org.tondeurh.fr.jbcdump.containers.constants.CONSTANT_InvokeDynamic_info;
import org.tondeurh.fr.jbcdump.containers.constants.CONSTANT_Long_info;
import org.tondeurh.fr.jbcdump.containers.constants.CONSTANT_MethodHandle_info;
import org.tondeurh.fr.jbcdump.containers.constants.CONSTANT_MethodType_info;
import org.tondeurh.fr.jbcdump.containers.constants.CONSTANT_Methodref_info;
import org.tondeurh.fr.jbcdump.containers.constants.CONSTANT_Module_info;
import org.tondeurh.fr.jbcdump.containers.constants.CONSTANT_NameAndType_info;
import org.tondeurh.fr.jbcdump.containers.constants.CONSTANT_Package_info;
import org.tondeurh.fr.jbcdump.containers.constants.CONSTANT_String_info;
import org.tondeurh.fr.jbcdump.containers.constants.CONSTANT_Utf8_info;
/****************
 *
 * @author herve
 ***************/
public class Decoder {
    
    ClassFile classFile;
    Tools t;

    /***************
     * CONSTRUCTEUR
     * @param bcm
     ***************/
    public Decoder(byte[] bcm) {
    classFile=new ClassFile();
    t=new Tools(bcm);
    }
   
    /************************
     * Decoder ClassFile
     * from memory 
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
        constant_pool_read();
        constant_pool_print();
        
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
        
    /*    
        System.out.println("------------INTERFACES------------");
        //Interfaces count
        classFile.setInterfaces_count(t.getNextBytes(2));
        System.out.println("interfaces count : "+t.Int(classFile.getInterfaces_count()));
        
        //interfaces_info interfaces[interfaces_count];
       if (t.Int(classFile.getInterfaces_count())>0)
       {
           interfaces_infos_read();
           interfaces_infos_print();
       }
       
        System.out.println("------------FIELDS------------");
        //u2 fields_count;
        classFile.setFields_count(t.getNextBytes(2));
        System.out.println("Fields count : "+t.Int(classFile.getFields_count()));
        
        //field_info fields[fields_count];
        if (t.Int(classFile.getFields_count())>0)
       {
           fields_infos_read();
           fields_infos_print();
       }
        
        System.out.println("------------METHODS------------");
        //u2 methods_count;
        classFile.setMethods_count(t.getNextBytes(2));
        System.out.println("Methods count : "+t.Int(classFile.getMethods_count()));
        
        //method_info methods[methods_count];
        if (t.Int(classFile.getMethods_count())>0)
       {
           methods_infos_read();
           methods_infos_print();
       }

        System.out.println("------------ATTRIBUTES------------");
        //u2 attributes_count;
        classFile.setAttributes_count(t.getNextBytes(2));
        System.out.println("Attributes count : "+t.Int(classFile.getAttributes_count()));

        //attribute_info attributes[attributes_count];
        if (t.Int(classFile.getAttributes_count())>0)
       {
           atributes_infos_read();
       }
     */   
     ////////////////////////
       System.exit(0);
     ///////////////////////
     
    }
                 
    /***************************
     * Lire la table constant pool
     ***************************/
    private void constant_pool_read() {
          
    for (int count_pool=0;count_pool<t.Int(classFile.getConstant_pool_count())-1;count_pool++)
    {
        //alloc array constant_pool object
        CP_info cp_info=new CP_info(); 
        //lire le tag
        cp_info.setTag(t.getNextBytes(cp_info.tag_size));
        cp_info.setItag(t.Int(cp_info.getTag()));
        switch(cp_info.getItag())
        {
            case 7 -> {
                cp_info.setConstant_name("CONSTANT_Class");//afecter le type de cp_info
                cp_info.setContainer(call_constant(cp_info.getItag()));//affecter l'objet
                }
            case 9 -> {
                cp_info.setConstant_name("CONSTANT_Fieldref");//afecter le type de cp_info
                cp_info.setContainer(call_constant(cp_info.getItag()));//affecter l'objet
                }
            case 10 -> {
                cp_info.setConstant_name("CONSTANT_Methodref");//afecter le type de cp_info
                cp_info.setContainer(call_constant(cp_info.getItag()));//affecter l'objet
                }
            case 11 -> {
                cp_info.setConstant_name("CONSTANT_InterfaceMethodref");//afecter le type de cp_info
                cp_info.setContainer(call_constant(cp_info.getItag()));//affecter l'objet
                }
            case 8 -> {
                cp_info.setConstant_name("CONSTANT_String");//afecter le type de cp_info
                cp_info.setContainer(call_constant(cp_info.getItag()));//affecter l'objet
                }
            case 3 -> {
                cp_info.setConstant_name("CONSTANT_tools.Integer");//afecter le type de cp_info
                cp_info.setContainer(call_constant(cp_info.getItag()));//affecter l'objet
                }
            case 4 -> {
                cp_info.setConstant_name("CONSTANT_Float");//afecter le type de cp_info
                cp_info.setContainer(call_constant(cp_info.getItag()));//affecter l'objet
                }
            case 5 -> {
                cp_info.setConstant_name("CONSTANT_Long");//afecter le type de cp_info
                cp_info.setContainer(call_constant(cp_info.getItag()));//affecter l'objet
                }
            case 6 -> {
                cp_info.setConstant_name("CONSTANT_Double");//afecter le type de cp_info
                cp_info.setContainer(call_constant(cp_info.getItag()));//affecter l'objet
                }
            case 12 -> {
                cp_info.setConstant_name("CONSTANT_NameAndType");//afecter le type de cp_info
                cp_info.setContainer(call_constant(cp_info.getItag()));//affecter l'objet
                }
            case 1 -> {
                cp_info.setConstant_name("CONSTANT_Utf8");//afecter le type de cp_info
                cp_info.setContainer(call_constant(cp_info.getItag()));//affecter l'objet
                }
            case 15 -> {
                cp_info.setConstant_name("CONSTANT_MethodHandle");//afecter le type de cp_info
                cp_info.setContainer(call_constant(cp_info.getItag()));//affecter l'objet
                }
            case 16 -> {
                cp_info.setConstant_name("CONSTANT_MethodType");//afecter le type de cp_info
                cp_info.setContainer(call_constant(cp_info.getItag()));//affecter l'objet
                }
            case 17 -> {
                cp_info.setConstant_name("CONSTANT_Dynamic");//afecter le type de cp_info
                cp_info.setContainer(call_constant(cp_info.getItag()));//affecter l'objet
                }
            case 18 -> {
                cp_info.setConstant_name("CONSTANT_InvokeDynamic");//afecter le type de cp_info
                cp_info.setContainer(call_constant(cp_info.getItag()));//affecter l'objet
                }
            case 19 -> {
                cp_info.setConstant_name("CONSTANT_Module");//afecter le type de cp_info
                cp_info.setContainer(call_constant(cp_info.getItag()));//affecter l'objet
                }
            case 20 -> {
                cp_info.setConstant_name("CONSTANT_Package");//afecter le type de cp_info
                cp_info.setContainer(call_constant(cp_info.getItag()));//affecter l'objet
                }
        }

        classFile.getConstant_pool().add(cp_info);
    } //fin for
    }

    /******************************
     * Read String constant pool
     * from typecp
     * @param typecp
     * @return 
     ******************************/
    private Object call_constant(int typecp) {
    //String result="";
    
        switch (typecp)
        {
            case 7->{ //CONSTANT_Class_info {u2 name_index;}
                        CONSTANT_Class_info cci=new CONSTANT_Class_info();
                        cci.setName_index(t.getNextBytes(2));
                        cci.setIname_index(t.Int(cci.getName_index()));
                        return cci;
                    }      
            case 1->{ //CONSTANT_Utf8_info {u2 length;u1 bytes[length];}
                        CONSTANT_Utf8_info cci=new CONSTANT_Utf8_info();
                        //recup length
                        cci.setLength(t.getNextBytes(cci.length_size));
                        cci.setIlength(t.Int(cci.getLength()));
                        //recup String
                        cci.setBytesString(t.getNextBytes(cci.getIlength()));
                        cci.setSbytesString(t.Str(cci.getBytesString()));
                        return cci;
                    }  
            case 10->{ //CONSTANT_Methodref_info {u2 class_index;u2 name_and_type_index;}
                        CONSTANT_Methodref_info cci=new CONSTANT_Methodref_info();
                        cci.setClass_index(t.getNextBytes(cci.class_index_size));
                        cci.setIclass_index(t.Int(cci.getClass_index()));
                        cci.setName_and_type_index(t.getNextBytes(cci.name_and_type_index_size));
                        cci.setIname_and_type_index(t.Int(cci.getName_and_type_index()));
                        return cci;
                    } 
            case 12->{ //CONSTANT_NameAndType_info {u2 name_index;u2 descriptor_index;}
                        result="#"+t.Int(t.getNextBytes(2))+"."+"#"+t.Int(t.getNextBytes(2));
                    } 
            case 9->{ //CONSTANT_Fieldref_info {u2 class_index;u2 name_and_type_index;}
                        result="#"+t.Int(t.getNextBytes(2))+"."+"#"+t.Int(t.getNextBytes(2));
                    } 
            case 11->{ //CONSTANT_InterfaceMethodref_info {u2 class_index;u2 name_and_type_index;}
                        result="#"+t.Int(t.getNextBytes(2))+"."+"#"+t.Int(t.getNextBytes(2));
                    } 
            case 8->{ //CONSTANT_String_info {u2 string_index;}
                        result="#"+t.Int(t.getNextBytes(2));
                    } 
            case 3->{ //CONSTANT_tools.Integer_info {u4 bytes;}
                        result="I:"+t.Int(t.getNextBytes(4));
                    } 
            case 4->{ //CONSTANT_Float_info {u4 bytes;}
                        result="F:"+t.Int(t.getNextBytes(4));
                    }
            case 5->{ //CONSTANT_Long_info {u4 high_bytes;u4 low_bytes;}
                        result="L:hb"+t.Int(t.getNextBytes(4))+"lb"+t.Int(t.getNextBytes(4));
                    }
            case 6->{ //CONSTANT_Double_info {u4 high_bytes;u4 low_bytes;}
                        result="D:hb"+t.Int(t.getNextBytes(4))+"lb"+t.Int(t.getNextBytes(4));
                    }
            case 15->{ //CONSTANT_MethodHandle_info {u1 reference_kind;u2 reference_index;}
                        result="#"+t.Int(t.getNextBytes(1))+"."+"#"+t.Int(t.getNextBytes(2));
                    }
            case 16->{ //CONSTANT_MethodType_info {u2 descriptor_index;}
                        CONSTANT_MethodType_info cci=new CONSTANT_MethodType_info();
                        cci.setDescriptor_index(t.getNextBytes(cci.descriptor_index_size));
                        cci.setIdescriptor_index(t.Int(cci.getDescriptor_index()));
                        return cci;
                    }
            case 17->{ //CONSTANT_Dynamic_info {u2 bootstrap_method_attr_index;u2 name_and_type_index;}
                        result="#"+t.Int(t.getNextBytes(2))+"."+"#"+t.Int(t.getNextBytes(2));
                    }
            case 18->{ //CONSTANT_InvokeDynamic_info {u2 bootstrap_method_attr_index;u2 name_and_type_index;}
                        result="#"+t.Int(t.getNextBytes(2))+"."+"#"+t.Int(t.getNextBytes(2));
                    }
            case 19->{ //CONSTANT_Module_info {u2 name_index;}
                        CONSTANT_Module_info cci=new CONSTANT_Module_info();
                        cci.setName_index(t.getNextBytes(cci.name_index_size));
                        cci.setIname_index(t.Int(cci.getName_index()));
                        return cci;
                    }
            case 20->{ //CONSTANT_Package_info {u2 name_index;}
                        CONSTANT_Package_info cci=new CONSTANT_Package_info();
                        cci.setName_index(t.getNextBytes(cci.name_index_size));
                        cci.setIname_index(t.Int(cci.getName_index()));
                        return cci;
                    }

        }

        return null;
    }

    /*****************
     * Print constant pool
     *****************/
    private void constant_pool_print() {
        for (CP_info cp_info:classFile.getConstant_pool())
        {
            //afficher le niveau cp_info
            System.out.print("#tag type : "+cp_info.getItag()+" ("+t.Hex(cp_info.getTag(), false, true)+")");
            System.out.println(" : "+cp_info.getConstant_name());
            
            //afficher le contenu selon le type d'objet.
            if (cp_info.getContainer() instanceof CONSTANT_Class_info)
            {
               
            }
            if (cp_info.getContainer() instanceof CONSTANT_Double_info)
            {
                
            }
            if (cp_info.getContainer() instanceof CONSTANT_Dynamic_info)
            {
                
            }
            if (cp_info.getContainer() instanceof CONSTANT_Fieldref_info)
            {
                
            }
            if (cp_info.getContainer() instanceof CONSTANT_Float_info)
            {
                
            }
            if (cp_info.getContainer() instanceof CONSTANT_Integer_info)
            {
                
            }
            if (cp_info.getContainer() instanceof CONSTANT_InterfaceMethodref_info)
            {
                
            }
            if (cp_info.getContainer() instanceof CONSTANT_InvokeDynamic_info)
            {
                
            }
            if (cp_info.getContainer() instanceof CONSTANT_Long_info)
            {
                
            }
            if (cp_info.getContainer() instanceof CONSTANT_MethodHandle_info)
            {
                
            }
            if (cp_info.getContainer() instanceof CONSTANT_MethodType_info)
            {
                
            }
            if (cp_info.getContainer() instanceof CONSTANT_Methodref_info)
            {
                
            }
            if (cp_info.getContainer() instanceof CONSTANT_Module_info)
            {
                
            }
            if (cp_info.getContainer() instanceof CONSTANT_NameAndType_info)
            {
                
            }
            if (cp_info.getContainer() instanceof CONSTANT_Package_info)
            {
                
            }
            if (cp_info.getContainer() instanceof CONSTANT_String_info)
            {
                
            }
            if (cp_info.getContainer() instanceof CONSTANT_Utf8_info cONSTANT_Utf8_info)
            {   
                System.out.println(cONSTANT_Utf8_info.getSbytesString());
            }
           
        }
    }
}
