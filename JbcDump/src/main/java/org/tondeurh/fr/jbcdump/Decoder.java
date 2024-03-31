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

/****************
 *
 * @author herve
 ***************/
public class Decoder {
    
    ClassFile classFile;
    Tools tools;

    /***************
     * CONSTRUCTEUR
     * @param bcm
     ***************/
    public Decoder(byte[] bcm) {
    classFile=new ClassFile();
    tools=new Tools(bcm);
    }
   
    /************************
     * Decoder ClassFile
     * from memory 
     ************************/
    public void decodeClassFile()
    {
        //recuperer le nombre magique du fichier...
        classFile.setMagic(tools.getNextBytes(4));
        //tester le nbre magique avant de continuer est ce le bon format?
                if (!tools.testMagicNumber(tools.Hex(classFile.getMagic(),false,false)))
                {
                    tools.exit("Ce n'est pas le bon format de fichier...");
                }
        
        //decode les versions major et minor
        classFile.setMinor_version(tools.getNextBytes(2));//4-5
        classFile.setMajor_version(tools.getNextBytes(2));//6-7
        
        //nb of constant pool string ?
        classFile.setConstant_pool_count(tools.getNextBytes(2));//8-9
        
        System.out.println("Magic number : "+tools.Hex(classFile.getMagic(),false,true));
        System.out.println("Major version : "+tools.Integ(classFile.getMajor_version()));
        System.out.println(tools.MVTab(classFile.getMajor_version()));
        System.out.println("Minor version : "+tools.Integ(classFile.getMinor_version()));
        
        System.out.println("------------CONSTANTS POOL------------");
        System.out.println("constant pool count : "+tools.Integ(classFile.getConstant_pool_count()));
        
        //lire la table constant pool 
        constant_pool_read();
        constant_pool_print();
        
        System.out.println("------------------------");
        //access FLAGS
        classFile.setAccess_flags(tools.getNextBytes(2));
        System.out.println("Access FlagS : "+tools.AFTab(tools.Integ(classFile.getAccess_flags())));
        
        //this class
        classFile.setThis_class(tools.getNextBytes(2));
        System.out.println("This Class : #"+tools.Integ(classFile.getThis_class()));
        
        //super class
        classFile.setSuper_class(tools.getNextBytes(2));
        System.out.println("Super Class : #"+tools.Integ(classFile.getSuper_class()));
        
        
        System.out.println("------------INTERFACES------------");
        //Interfaces count
        classFile.setInterfaces_count(tools.getNextBytes(2));
        System.out.println("interfaces count : "+tools.Integ(classFile.getInterfaces_count()));
        
        //interfaces_info interfaces[interfaces_count];
       if (tools.Integ(classFile.getInterfaces_count())>0)
       {
           interfaces_infos_read();
           interfaces_infos_print();
       }
       
        System.out.println("------------FIELDS------------");
        //u2 fields_count;
        classFile.setFields_count(tools.getNextBytes(2));
        System.out.println("Fields count : "+tools.Integ(classFile.getFields_count()));
        
        //field_info fields[fields_count];
        if (tools.Integ(classFile.getFields_count())>0)
       {
           fields_infos_read();
           fields_infos_print();
       }
        
        System.out.println("------------METHODS------------");
        //u2 methods_count;
        classFile.setMethods_count(tools.getNextBytes(2));
        System.out.println("Methods count : "+tools.Integ(classFile.getMethods_count()));
        
        //method_info methods[methods_count];
        if (tools.Integ(classFile.getMethods_count())>0)
       {
           methods_infos_read();
           methods_infos_print();
       }

        System.out.println("------------ATTRIBUTES------------");
        //u2 attributes_count;
        classFile.setAttributes_count(tools.getNextBytes(2));
        System.out.println("Attributes count : "+tools.Integ(classFile.getAttributes_count()));

        //attribute_info attributes[attributes_count];
        if (tools.Integ(classFile.getAttributes_count())>0)
       {
           atributes_infos_read();
       }
        
     ////////////////////////
       System.exit(0);
     ///////////////////////
    }
                 
    /***************************
     * Lire la table constant pool
     ***************************/
    private void constant_pool_read() {
        
        String typecp="";
        String stringcp="";
        //alloc array constant_pool_strings
        String[] constant_pool_tab=new String[tools.Integ(classFile.getConstant_pool_count())-1];
        
    for (int count_pool=0;count_pool<tools.Integ(classFile.getConstant_pool_count())-1;count_pool++)
    {
       //lire le tag
        int tag=tools.Integ(tools.getNextBytes(1));
        switch(tag)
        {
            case 7 -> {
                typecp="CONSTANT_Class";stringcp=call_constant(tag);
                }
            case 9 -> {
                typecp="CONSTANT_Fieldref";stringcp=call_constant(tag);
                }
            case 10 -> {
                typecp="CONSTANT_Methodref";stringcp=call_constant(tag);
                }
            case 11 -> {
                typecp="CONSTANT_InterfaceMethodref";stringcp=call_constant(tag);
                }
            case 8 -> {
                typecp="CONSTANT_String";stringcp=call_constant(tag);
                }
            case 3 -> {
                typecp="CONSTANT_tools.Integer";stringcp=call_constant(tag);
                }
            case 4 -> {
                typecp="CONSTANT_Float";stringcp=call_constant(tag);
                }
            case 5 -> {
                typecp="CONSTANT_Long";stringcp=call_constant(tag);
                }
            case 6 -> {
                typecp="CONSTANT_Double";stringcp=call_constant(tag);
                }
            case 12 -> {
                typecp="CONSTANT_NameAndType";stringcp=call_constant(tag);
                }
            case 1 -> {
                typecp="CONSTANT_Utf8";stringcp=call_constant(tag);
                }
            case 15 -> {
                typecp="CONSTANT_MethodHandle";stringcp=call_constant(tag);
                }
            case 16 -> {
                typecp="CONSTANT_MethodType";stringcp=call_constant(tag);
                }
            case 17 -> {
                typecp="CONSTANT_Dynamic";stringcp=call_constant(tag);
                }
            case 18 -> {
                typecp="CONSTANT_InvokeDynamic";stringcp=call_constant(tag);
                }
            case 19 -> {
                typecp="CONSTANT_Module";stringcp=call_constant(tag);
                }
            case 20 -> {
                typecp="CONSTANT_Package";stringcp=call_constant(tag);
                }
        }
     
       constant_pool_tab[count_pool]="#"+(count_pool+1)+":"+typecp+" : "+stringcp;
        
    }
    classFile.setConstant_pool(constant_pool_tab);
    }

    /******************************
     * Read String constant pool
     * from typecp
     * @param typecp
     * @return 
     ******************************/
    private String call_constant(int typecp) {
    String result="";
    
        switch (typecp)
        {
            case 7->{ //CONSTANT_Class_info {u1 tag;u2 name_index;}
                        result="#"+tools.Integ(tools.getNextBytes(2));
                    }      
            case 1->{ //CONSTANT_Utf8_info {u1 tag;u2 length;u1 bytes[length];}
                        int lenstr=tools.Integ(tools.getNextBytes(2));
                        result=new String(tools.getNextBytes(lenstr), StandardCharsets.UTF_8);
                    }  
            case 10->{ //CONSTANT_Methodref_info {u1 tag;u2 class_index;u2 name_and_type_index;}
                        result="#"+tools.Integ(tools.getNextBytes(2))+"."+"#"+tools.Integ(tools.getNextBytes(2));
                    } 
            case 12->{ //CONSTANT_NameAndType_info {u1 tag;u2 name_index;u2 descriptor_index;}
                        result="#"+tools.Integ(tools.getNextBytes(2))+"."+"#"+tools.Integ(tools.getNextBytes(2));
                    } 
            case 9->{ //CONSTANT_Fieldref_info {u1 tag;u2 class_index;u2 name_and_type_index;}
                        result="#"+tools.Integ(tools.getNextBytes(2))+"."+"#"+tools.Integ(tools.getNextBytes(2));
                    } 
            case 11->{ //CONSTANT_InterfaceMethodref_info {u1 tag;u2 class_index;u2 name_and_type_index;}
                        result="#"+tools.Integ(tools.getNextBytes(2))+"."+"#"+tools.Integ(tools.getNextBytes(2));
                    } 
            case 8->{ //CONSTANT_String_info {u1 tag;u2 string_index;}
                        result="#"+tools.Integ(tools.getNextBytes(2));
                    } 
            case 3->{ //CONSTANT_tools.Integer_info {u1 tag;u4 bytes;}
                        result="I:"+tools.Integ(tools.getNextBytes(4));
                    } 
            case 4->{ //CONSTANT_Float_info {u1 tag;u4 bytes;}
                        result="F:"+tools.Integ(tools.getNextBytes(4));
                    }
            case 5->{ //CONSTANT_Long_info {u1 tag;u4 high_bytes;u4 low_bytes;}
                        result="L:hb"+tools.Integ(tools.getNextBytes(4))+"lb"+tools.Integ(tools.getNextBytes(4));
                    }
            case 6->{ //CONSTANT_Double_info {u1 tag;u4 high_bytes;u4 low_bytes;}
                        result="D:hb"+tools.Integ(tools.getNextBytes(4))+"lb"+tools.Integ(tools.getNextBytes(4));
                    }
            case 15->{ //CONSTANT_MethodHandle_info {u1 tag;u1 reference_kind;u2 reference_index;}
                        result="#"+tools.Integ(tools.getNextBytes(1))+"."+"#"+tools.Integ(tools.getNextBytes(2));
                    }
            case 16->{ //CONSTANT_MethodType_info {u1 tag;u2 descriptor_index;}
                        result="#"+tools.Integ(tools.getNextBytes(2));
                    }
            case 17->{ //CONSTANT_Dynamic_info {u1 tag;u2 bootstrap_method_attr_index;u2 name_and_type_index;}
                        result="#"+tools.Integ(tools.getNextBytes(2))+"."+"#"+tools.Integ(tools.getNextBytes(2));
                    }
            case 18->{ //CONSTANT_InvokeDynamic_info {u1 tag;u2 bootstrap_method_attr_index;u2 name_and_type_index;}
                        result="#"+tools.Integ(tools.getNextBytes(2))+"."+"#"+tools.Integ(tools.getNextBytes(2));
                    }
            case 19->{ //CONSTANT_Module_info {u1 tag;u2 name_index;}
                        result="#"+tools.Integ(tools.getNextBytes(2));
                    }
            case 20->{ //CONSTANT_Package_info {u1 tag;u2 name_index;}
                        result="#"+tools.Integ(tools.getNextBytes(2));
                    }
        }

        return result;
    }

    /*****************
     * Print constant pool
     *****************/
    private void constant_pool_print() {
         for (String str:classFile.getConstant_pool()) {System.out.println(str);}
    }
   

    /***********************
     * Print interfaces infos
     * String
     ***********************/
    private void interfaces_infos_print() {
         for (String str:classFile.getInterfaces()) {System.out.println(str);}
    }

    /**************************
     * alimenter le tableau
     * des interfaces_infos.
     **************************/
    private void interfaces_infos_read() {
        //must be a CONSTANT_Class_Info <=> Tag=7
                
        String typeii="";
        String stringii="";
        //alloc array constant_pool_strings
        String[] interfaces_infos_tab=new String[tools.Integ(classFile.getInterfaces_count())];
        
    for (int count_pool=0;count_pool<tools.Integ(classFile.getInterfaces_count());count_pool++)
    {
       //lire le tag
        int tag=tools.Integ(tools.getNextBytes(1));
        switch(tag)
        {
            case 7 -> {
                typeii="CONSTANT_Class";stringii=call_constant(tag);
                }
        }
       interfaces_infos_tab[count_pool]="#"+(count_pool+1)+":"+typeii+" : "+stringii;
    }
    classFile.setInterfaces(interfaces_infos_tab);
    }

    /**************************
     * alimenter le tableau
     * des fields_infos.
     **************************/
    private void fields_infos_read() {
        String[] fields=new String[tools.Integ(classFile.getFields_count())];//initier le tableau des fields
        
        for (int count_fields=0;count_fields<tools.Integ(classFile.getFields_count());count_fields++)
        {
        /*
        field_info {
            u2 access_flags;
            u2 name_index;
            u2 descriptor_index;
            u2 attributes_count;
            attribute_info attributes[attributes_count];
        }*/

        //convertir access_flags
        String access_flags_str=tools.Attributes_ACFTab(tools.Integ(tools.getNextBytes(2)));
        int name_index=tools.Integ(tools.getNextBytes(2));
        int descriptor_index=tools.Integ(tools.getNextBytes(2));
        int attributes_count=tools.Integ(tools.getNextBytes(2));
        
        //attribute_info attributes[attributes_count]
        //TODO a revoir...
        String attributes_infos_str=iterate_attributes(attributes_count);
        
        fields[count_fields]=access_flags_str+
                "#"+name_index+" "+extract_constant_pool_value(name_index)+"\r\n"+
                "#"+descriptor_index+" "+extract_constant_pool_value(descriptor_index)+"\r\n"+
                "["+attributes_infos_str+"]";
        }
        classFile.setFields(fields);
    }

    /***********************
     * Print fields infos
     * String
     ***********************/
    private void fields_infos_print() {
        for (String str:classFile.getFields()) {System.out.println(str);}
    }

    /**************************
     * alimenter le tableau
     * des methods_infos.
     **************************/
    private void methods_infos_read() {
          String[] methods=new String[tools.Integ(classFile.getMethods_count())];//initier le tableau des methods
        
        for (int count_methods=0;count_methods<tools.Integ(classFile.getMethods_count());count_methods++)
        {
        /*method_info {
			u2 access_flags;
			u2 name_index;
			u2 descriptor_index;
			u2 attributes_count;
			attribute_info attributes[attributes_count];
		}*/
        //convertir access_flags
        String access_flags_str=tools.Methodes_ACMTab(tools.Integ(tools.getNextBytes(2)));
        int name_index=tools.Integ(tools.getNextBytes(2));
        int descriptor_index=tools.Integ(tools.getNextBytes(2));
        int attributes_count=tools.Integ(tools.getNextBytes(2));
        
        //attribute_info attributes[attributes_count]
        String attributes_infos_str=iterate_attributes(attributes_count);
        
        methods[count_methods]=access_flags_str+"\r\n"+
                "#"+name_index+" "+extract_constant_pool_value(name_index)+"\r\n"+
                "#"+descriptor_index+" "+extract_constant_pool_value(descriptor_index)+"\r\n"+
                attributes_infos_str;
        }
        classFile.setMethods(methods);
    }

    /***********************
     * Print methods infos
     * String
     ***********************/
    private void methods_infos_print() {
        for (String str:classFile.getMethods()) {System.out.println(str);}
    }

    /**************************
     * alimenter le tableau
     * des attributes_infos.
     **************************/
    private void atributes_infos_read() {
        System.out.println(iterate_attributes_end_file(tools.Integ(classFile.getAttributes_count())));
    }
   
    /***************************
     * Itterer dans le code des
     * attributs (multi sources
     * @param attributes_count
     * @return 
     ***************************/
    private String iterate_attributes(int attributes_count) {
      String result="";
        /*
	attribute_info {
	u2 attribute_name_index;
	u4 attribute_length;
	u1 info[attribute_length];
	}
        */
        for (int attributes_count_counter=0;attributes_count_counter<attributes_count;attributes_count_counter++)
        {
        int attribute_name_index=tools.Integ(tools.getNextBytes(2));
        int attribute_length=tools.Integ(tools.getNextBytes(4));
        //get u1 info
        String code=tools.Hex(tools.getNextBytes(attribute_length),true,true);
                
        result="#"+attribute_name_index+" "+extract_constant_pool_value(attribute_name_index)+
        "["+code+"]";
        }
        return result;
    }

    /***************************
     * Itterer dans le code des
     * attributs (multi sources
     * @param attributes_count
     * @return 
     ***************************/
    private String iterate_attributes_end_file(int attributes_count) {
      String result="";
        /*
	attribute_info {
	u2 attribute_name_index;
	u4 attribute_length;
	u1 info[attribute_length];
	}
        */
        for (int attributes_count_counter=0;attributes_count_counter<attributes_count;attributes_count_counter++)
        {
        int attribute_name_index=tools.Integ(tools.getNextBytes(2));
        int attribute_length=tools.Integ(tools.getNextBytes(4));
        //get u1 info
        int code=tools.Integ(tools.getNextBytes(attribute_length));
                
        result="#"+attribute_name_index+".#"+code+"\r\n"+
        extract_constant_pool_value(attribute_name_index)+" "+
        extract_constant_pool_value(code);
        }
        return result;
    }

    
    /******************************
     * Extract vlaeur de CP
     * @param index_constant_pool
     * @return 
     ******************************/
    private String extract_constant_pool_value(int index_constant_pool)
    {
        String result;
        String[] constant_pool=classFile.getConstant_pool();
        
        result=constant_pool[index_constant_pool-1];
        
        return result;
    }
    
}
