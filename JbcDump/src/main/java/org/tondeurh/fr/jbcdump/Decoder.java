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

import java.nio.charset.StandardCharsets;

/****************
 *
 * @author herve
 ***************/
public class Decoder {
    
    static byte[] gbcm; 
    byteCodeFF bcFF=new byteCodeFF();
    int pc=0;

    /***************
     * CONSTRUCTEUR
     * @param bcm
     ***************/
    public Decoder(byte[] bcm) {
    gbcm=bcm; //copier la mem class en globale
    //getmagic 0-3
    bcFF.setMagic(getNextBytes(4)); 
    }

    /*******************
     * getmagic number to test
     * @return
     *******************/
    public String getFileMagicNumber(){
        return Hex(bcFF.getMagic(),false,false);
    }
    
    /************************
     * Decoder ClassFile
     * from memory 
     ************************/
    public void decodeClassFile()
    {
        //getmagic 0-3
        //bcFF.setMagic(getNextBytes(4)); //déporté vers le constructeur
        
        //decode major et minor version
        bcFF.setMinor_version(getNextBytes(2));//4-5
        bcFF.setMajor_version(getNextBytes(2));//6-7
        
        //nb of constant pool string ?
        bcFF.setConstant_pool_count(getNextBytes(2));//8-9
        
        System.out.println("Magic number : "+Hex(bcFF.getMagic(),false,true));
        System.out.println("Major version : "+Integ(bcFF.getMajor_version()));
        System.out.println(MVTab(bcFF.getMajor_version()));
        System.out.println("Minor version : "+Integ(bcFF.getMinor_version()));
        
        System.out.println("------------CONSTANTS POOL------------");
        System.out.println("constant pool count : "+Integ(bcFF.getConstant_pool_count()));
        
        //lire la table constant pool 
        constant_pool_read();
        constant_pool_print();
        
        System.out.println("------------------------");
        //access FLAGS
        bcFF.setAccess_flags(getNextBytes(2));
        System.out.println("Access FlagS : "+AFTab(bcFF.getAccess_flags()));
        
        //this class
        bcFF.setThis_class(getNextBytes(2));
        System.out.println("This Class : #"+Integ(bcFF.getThis_class()));
        
        //super class
        bcFF.setSuper_class(getNextBytes(2));
        System.out.println("Super Class : #"+Integ(bcFF.getSuper_class()));
        
        
        System.out.println("------------INTERFACES------------");
        //Interfaces count
        bcFF.setInterfaces_count(getNextBytes(2));
        System.out.println("interfaces count : "+Integ(bcFF.getInterfaces_count()));
        
        //interfaces_info interfaces[interfaces_count];
       if (Integ(bcFF.getInterfaces_count())>0)
       {
           interfaces_infos_read();
           interfaces_infos_print();
       }
       
        System.out.println("------------FIELDS------------");
        //u2 fields_count;
        bcFF.setFields_count(getNextBytes(2));
        System.out.println("Fields count : "+Integ(bcFF.getFields_count()));
        
        //field_info fields[fields_count];
        if (Integ(bcFF.getFields_count())>0)
       {
           fields_infos_read();
           fields_infos_print();
       }
        
        System.out.println("------------METHODS------------");
        //u2 methods_count;
        bcFF.setMethods_count(getNextBytes(2));
        System.out.println("Methods count : "+Integ(bcFF.getMethods_count()));
        
        //method_info methods[methods_count];
        if (Integ(bcFF.getMethods_count())>0)
       {
           methods_infos_read();
           methods_infos_print();
       }

        System.out.println("------------ATTRIBUTES------------");
        //u2 attributes_count;
        bcFF.setAttributes_count(getNextBytes(2));
        System.out.println("Attributes count : "+Integ(bcFF.getAttributes_count()));

        //attribute_info attributes[attributes_count];
        if (Integ(bcFF.getAttributes_count())>0)
       {
           atributes_infos_read();
       }
        
     ////////////////////////
       System.exit(0);
     ///////////////////////
    }
        
    /*******************
     * Get Next size bytes
     * @return 
     *******************/
    private  byte[] getNextBytes(int size){
        byte[] local=new byte[size];
        System.arraycopy(gbcm, pc, local, 0, size);
        pc=pc+size;
        //System.out.println("pc pos : "+pc);
        return local;
    }
    
    /**********************
     * convert vers hex string
     * @param magic
     * @return 
     **********************/
    private String Hex(byte[] magic, boolean space,boolean upcase) {
        String result="";
        for (int i=0; i < magic.length; i++) 
        {
        result += Integer.toString((magic[i] & 0xff)+0x100,16)
                    .substring( 1 );
        if (space) result+=" ";
        if (upcase) result=result.toUpperCase();
        }
        return result;
    }

    /********************************
     * Table de conversion version majeure
     * @param major_version
     * @return 
     *********************************/
    private String MVTab(byte[] major_version) {
        String result;
       int value =Integ(major_version);
    switch (value){
        case 45 -> result="Major version 45 : (1.1) February 1997 support V45 only";
        case 46 -> result="Major version 46 : (1.2) December 1998 support V45 to V46";
        case 47 -> result="Major version 47 : (1.3) May 2000 support V45 to V47";
        case 48 -> result="Major version 48 : (1.4) February 2002 support V45 to V48";
        case 49 -> result="Major version 49 : (5.0) September 2004 support V45 to V49";
        case 50 -> result="Major version 50 : (6) December 2006 support V45 to V50";
        case 51 -> result="Major version 51 : (7) July 2011 support V45 to V51";
        case 52 -> result="Major version 52 : (8) March 2014 support V45 to V52";
        case 53 -> result="Major version 53 : (9) September 2017 support V45 to V53";
        case 54 -> result="Major version 54 : (10) March 2018 support V45 to V54";
        case 55 -> result="Major version 55 : (11) September 2018 support V45 to V55";
        case 56 -> result="Major version 56 : (12) March 2019 support V45 to V56";
        case 57 -> result="Major version 57 : (13) September 2019 support V45 to V57";
        case 58 -> result="Major version 58 : (14) March 2020 support V45 to V58";
        case 59 -> result="Major version 59 : (15) September 2020 support V45 to V59";
        case 60 -> result="Major version 60 : (16) March 2021 support V45 to V60";
        case 61 -> result="Major version 61 : (17) September 2021 support V45 to V61";
        case 62 -> result="Major version 62 : (18) March 2022 support V45 to V62";
        case 63 -> result="Major version 63 : (19) September 2022 support V45 to V63";
        case 64 -> result="Major version 64 : (20) March 2023 support V45 to V64";
        case 65 -> result="Major version 65 : (21) September 2023 support V45 to V65";
        case 66 -> result="Major version 66 : (22) March 2024 support V45 to V66";
        default ->result="Major version Unknown";
    }
    return result;
    }

    /**************************
     * convertir byte2 to Integer
     * @param major_version
     * @return 
     **************************/
    private int Integ(byte[] major_version) {
         int value = 0;
         for (byte b : major_version) {value = (value << 8) + (b & 0xFF);}
         return value;
    }
        
    /***************************
     * Lire la table constant pool
     ***************************/
    private void constant_pool_read() {
        
        String typecp="";
        String stringcp="";
        //alloc array constant_pool_strings
        String[] constant_pool_tab=new String[Integ(bcFF.getConstant_pool_count())-1];
        
    for (int count_pool=0;count_pool<Integ(bcFF.getConstant_pool_count())-1;count_pool++)
    {
       //lire le tag
        int tag=Integ(getNextBytes(1));
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
                typecp="CONSTANT_Integer";stringcp=call_constant(tag);
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
    bcFF.setConstant_pool(constant_pool_tab);
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
                        result="#"+Integ(getNextBytes(2));
                    }      
            case 1->{ //CONSTANT_Utf8_info {u1 tag;u2 length;u1 bytes[length];}
                        int lenstr=Integ(getNextBytes(2));
                        result=new String(getNextBytes(lenstr), StandardCharsets.UTF_8);
                    }  
            case 10->{ //CONSTANT_Methodref_info {u1 tag;u2 class_index;u2 name_and_type_index;}
                        result="#"+Integ(getNextBytes(2))+"."+"#"+Integ(getNextBytes(2));
                    } 
            case 12->{ //CONSTANT_NameAndType_info {u1 tag;u2 name_index;u2 descriptor_index;}
                        result="#"+Integ(getNextBytes(2))+"."+"#"+Integ(getNextBytes(2));
                    } 
            case 9->{ //CONSTANT_Fieldref_info {u1 tag;u2 class_index;u2 name_and_type_index;}
                        result="#"+Integ(getNextBytes(2))+"."+"#"+Integ(getNextBytes(2));
                    } 
            case 11->{ //CONSTANT_InterfaceMethodref_info {u1 tag;u2 class_index;u2 name_and_type_index;}
                        result="#"+Integ(getNextBytes(2))+"."+"#"+Integ(getNextBytes(2));
                    } 
            case 8->{ //CONSTANT_String_info {u1 tag;u2 string_index;}
                        result="#"+Integ(getNextBytes(2));
                    } 
            case 3->{ //CONSTANT_Integer_info {u1 tag;u4 bytes;}
                        result="I:"+Integ(getNextBytes(4));
                    } 
            case 4->{ //CONSTANT_Float_info {u1 tag;u4 bytes;}
                        result="F:"+Integ(getNextBytes(4));
                    }
            case 5->{ //CONSTANT_Long_info {u1 tag;u4 high_bytes;u4 low_bytes;}
                        result="L:hb"+Integ(getNextBytes(4))+"lb"+Integ(getNextBytes(4));
                    }
            case 6->{ //CONSTANT_Double_info {u1 tag;u4 high_bytes;u4 low_bytes;}
                        result="D:hb"+Integ(getNextBytes(4))+"lb"+Integ(getNextBytes(4));
                    }
            case 15->{ //CONSTANT_MethodHandle_info {u1 tag;u1 reference_kind;u2 reference_index;}
                        result="#"+Integ(getNextBytes(1))+"."+"#"+Integ(getNextBytes(2));
                    }
            case 16->{ //CONSTANT_MethodType_info {u1 tag;u2 descriptor_index;}
                        result="#"+Integ(getNextBytes(2));
                    }
            case 17->{ //CONSTANT_Dynamic_info {u1 tag;u2 bootstrap_method_attr_index;u2 name_and_type_index;}
                        result="#"+Integ(getNextBytes(2))+"."+"#"+Integ(getNextBytes(2));
                    }
            case 18->{ //CONSTANT_InvokeDynamic_info {u1 tag;u2 bootstrap_method_attr_index;u2 name_and_type_index;}
                        result="#"+Integ(getNextBytes(2))+"."+"#"+Integ(getNextBytes(2));
                    }
            case 19->{ //CONSTANT_Module_info {u1 tag;u2 name_index;}
                        result="#"+Integ(getNextBytes(2));
                    }
            case 20->{ //CONSTANT_Package_info {u1 tag;u2 name_index;}
                        result="#"+Integ(getNextBytes(2));
                    }
        }

        return result;
    }

    /*****************
     * Print constant pool
     *****************/
    private void constant_pool_print() {
         for (String str:bcFF.getConstant_pool()) {System.out.println(str);}
    }
   
    /***************************
     * detect Access Flags for class
     * @param nextBytes
     * @return 
     ***************************/
    private String AFTab(byte[] nextBytes) {
        String result="";
        int v=Integ(nextBytes);
        if ((v & 0x8000)==0x8000) {result+="ACC_MODULE ";}
        if ((v & 0x4000)==0x4000){result+="ACC_ENUM ";}
        if ((v & 0x2000)==0x2000){result+="ACC_ANNOTATION ";}
        if ((v & 0x1000)==0x1000){result+="ACC_SYNTHETIC ";}
        if ((v & 0x0400)==0x0400){result+="ACC_ABSTRACT ";}
        if ((v & 0x0200)==0x0200){result+="ACC_INTERFACE ";}
        if ((v & 0x0020)==0x0020){result+="ACC_SUPER ";}
        if ((v & 0x0010)==0x0010){result+="ACC_FINAL ";}
        if ((v & 0x0001)==0x0001){result+="ACC_PUBLIC ";}
        return result;
        }

    /***********************
     * Print interfaces infos
     * String
     ***********************/
    private void interfaces_infos_print() {
         for (String str:bcFF.getInterfaces()) {System.out.println(str);}
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
        String[] interfaces_infos_tab=new String[Integ(bcFF.getInterfaces_count())];
        
    for (int count_pool=0;count_pool<Integ(bcFF.getInterfaces_count());count_pool++)
    {
       //lire le tag
        int tag=Integ(getNextBytes(1));
        switch(tag)
        {
            case 7 -> {
                typeii="CONSTANT_Class";stringii=call_constant(tag);
                }
        }
       interfaces_infos_tab[count_pool]="#"+(count_pool+1)+":"+typeii+" : "+stringii;
    }
    bcFF.setInterfaces(interfaces_infos_tab);
    }

    /**************************
     * alimenter le tableau
     * des fields_infos.
     **************************/
    private void fields_infos_read() {
        String[] fields=new String[Integ(bcFF.getFields_count())];//initier le tableau des fields
        
        for (int count_fields=0;count_fields<Integ(bcFF.getFields_count());count_fields++)
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
        String access_flags_str=Attributes_ACFTab(Integ(getNextBytes(2)));
        int name_index=Integ(getNextBytes(2));
        int descriptor_index=Integ(getNextBytes(2));
        int attributes_count=Integ(getNextBytes(2));
        
        //attribute_info attributes[attributes_count]
        //TODO a revoir...
        String attributes_infos_str=iterate_attributes(attributes_count);
        
        fields[count_fields]=access_flags_str+
                "#"+name_index+" "+extract_constant_pool_value(name_index)+"\r\n"+
                "#"+descriptor_index+" "+extract_constant_pool_value(descriptor_index)+"\r\n"+
                "["+attributes_infos_str+"]";
        }
        bcFF.setFields(fields);
    }

    /***********************
     * Print fields infos
     * String
     ***********************/
    private void fields_infos_print() {
        for (String str:bcFF.getFields()) {System.out.println(str);}
    }

    /**************************
     * alimenter le tableau
     * des methods_infos.
     **************************/
    private void methods_infos_read() {
          String[] methods=new String[Integ(bcFF.getMethods_count())];//initier le tableau des methods
        
        for (int count_methods=0;count_methods<Integ(bcFF.getMethods_count());count_methods++)
        {
        /*method_info {
			u2 access_flags;
			u2 name_index;
			u2 descriptor_index;
			u2 attributes_count;
			attribute_info attributes[attributes_count];
		}*/
        //convertir access_flags
        String access_flags_str=Methodes_ACMTab(Integ(getNextBytes(2)));
        int name_index=Integ(getNextBytes(2));
        int descriptor_index=Integ(getNextBytes(2));
        int attributes_count=Integ(getNextBytes(2));
        
        //attribute_info attributes[attributes_count]
        String attributes_infos_str=iterate_attributes(attributes_count);
        
        methods[count_methods]=access_flags_str+"\r\n"+
                "#"+name_index+" "+extract_constant_pool_value(name_index)+"\r\n"+
                "#"+descriptor_index+" "+extract_constant_pool_value(descriptor_index)+"\r\n"+
                attributes_infos_str;
        }
        bcFF.setMethods(methods);
    }

    /***********************
     * Print methods infos
     * String
     ***********************/
    private void methods_infos_print() {
        for (String str:bcFF.getMethods()) {System.out.println(str);}
    }

    /**************************
     * alimenter le tableau
     * des attributes_infos.
     **************************/
    private void atributes_infos_read() {
        System.out.println(iterate_attributes_end_file(Integ(bcFF.getAttributes_count())));
    }

    /********************
     * Convertir le format 
     * numerique access_flags
     * des attributes en String
     * @return 
     ********************/
    private String Attributes_ACFTab(int flags) {
        String result="";
        /*
        ACC_PUBLIC 0x0001
        ACC_PRIVATE 0x0002 
        ACC_STATIC 0x0008
        ACC_FINAL 0x0010
        ACC_VOLATILE 0x0040
        ACC_TRANSIENT 0x0080 
        ACC_SYNTHETIC 0x1000
        ACC_ENUM 0x4000
        */
        if ((flags & 0x0001)==0x0001) result+="ACC_PUBLIC ";
        if ((flags & 0x0002)==0x0002) result+="ACC_PRIVATE ";
        if ((flags & 0x0008)==0x0008) result+="ACC_STATIC ";
        if ((flags & 0x0010)==0x0010) result+="ACC_FINAL ";
        if ((flags & 0x0040)==0x0040) result+="ACC_VOLATILE ";
        if ((flags & 0x0080)==0x0080) result+="ACC_TRANSIENT ";
        if ((flags & 0x1000)==0x1000) result+="ACC_SYNTHETIC ";
        if ((flags & 0x4000)==0x4000) result+="ACC_ENUM ";
        
        return result;
    }
    
        /********************
     * Convertir le format 
     * numerique access_flags
     * des attributes en String
     * @return 
     ********************/
    private String Methodes_ACMTab(int flags) {
        String result="";
        /*
		ACC_PUBLIC 0x0001
		ACC_PRIVATE 0x0002
		ACC_PROTECTED 0x0004
		ACC_STATIC 0x0008
		ACC_FINAL 0x0010
		ACC_SYNCHRONIZED 0x0020
		ACC_BRIDGE 0x0040
		ACC_VARARGS 0x0080
		ACC_NATIVE 0x0100
		ACC_ABSTRACT 0x0400
		ACC_STRICT 0x0800
		ACC_SYNTHETIC 0x1000
        */
        if ((flags & 0x0001)==0x0001) result+="ACC_PUBLIC ";
        if ((flags & 0x0002)==0x0002) result+="ACC_PRIVATE ";
        if ((flags & 0x0004)==0x0004) result+="ACC_PROTECTED ";		
        if ((flags & 0x0008)==0x0008) result+="ACC_STATIC ";
        if ((flags & 0x0010)==0x0010) result+="ACC_FINAL ";
	if ((flags & 0x0020)==0x0020) result+="ACC_SYNCHRONIZED ";
        if ((flags & 0x0040)==0x0040) result+="ACC_BRIDGE ";
        if ((flags & 0x0080)==0x0080) result+="ACC_VARARGS ";
        if ((flags & 0x0100)==0x0100) result+="ACC_NATIVE ";
	if ((flags & 0x0400)==0x0400) result+="ACC_ABSTRACT ";
	if ((flags & 0x0800)==0x0800) result+="ACC_STRICT ";
        if ((flags & 0x1000)==0x1000) result+="ACC_SYNTHETIC ";
        
        return result;
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
        int attribute_name_index=Integ(getNextBytes(2));
        int attribute_length=Integ(getNextBytes(4));
        //get u1 info
        String code=Hex(getNextBytes(attribute_length),true,true);
                
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
        int attribute_name_index=Integ(getNextBytes(2));
        int attribute_length=Integ(getNextBytes(4));
        //get u1 info
        int code=Integ(getNextBytes(attribute_length));
                
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
        String[] constant_pool=bcFF.getConstant_pool();
        
        result=constant_pool[index_constant_pool-1];
        
        return result;
    }
    
}
