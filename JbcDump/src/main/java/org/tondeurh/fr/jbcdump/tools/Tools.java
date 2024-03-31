/*
 * Copyright (C) 2024 tondeur-h
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
package org.tondeurh.fr.jbcdump.tools;

import java.nio.charset.StandardCharsets;

/**
 *
 * @author tondeur-h
 */
public class Tools {

    int idxP=0; //index de position dans le fichier.
    static byte[] gbcm; 

    public Tools(byte[] bcm) {
    gbcm=bcm; //copier la mem class en globale
    }
    
    /***************************
     * detect Access Flags for class
     * @param flags
     * @return 
     ***************************/
    public String AFTab(int flags) {
        String result="";
        if ((flags & 0x8000)==0x8000) {result+="ACC_MODULE ";}
        if ((flags & 0x4000)==0x4000){result+="ACC_ENUM ";}
        if ((flags & 0x2000)==0x2000){result+="ACC_ANNOTATION ";}
        if ((flags & 0x1000)==0x1000){result+="ACC_SYNTHETIC ";}
        if ((flags & 0x0400)==0x0400){result+="ACC_ABSTRACT ";}
        if ((flags & 0x0200)==0x0200){result+="ACC_INTERFACE ";}
        if ((flags & 0x0020)==0x0020){result+="ACC_SUPER ";}
        if ((flags & 0x0010)==0x0010){result+="ACC_FINAL ";}
        if ((flags & 0x0001)==0x0001){result+="ACC_PUBLIC ";}
        return result;
        }    
 
    /********************
     * Conflagsertir le format 
     * numerique access_flags
     * des attributes en String
     * @param flags
     * @return 
     ********************/
    public String Attributes_ACFTab(int flags) {
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
    
    /**********************
     * convert vers hex string
     * @param magic
     * @param space
     * @param upcase
     * @return 
     **********************/
    public String Hex(byte[] magic, boolean space,boolean upcase) {
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

    /**************************
     * convertir byte2 to Integer
     * @param major_version
     * @return 
     **************************/
    public int Int(byte[] major_version) {
         int value = 0;
         for (byte b : major_version) {value = (value << 8) + (b & 0xFF);}
         return value;
    }

     /**************************
     * convertir bytes to String
     * @param str
     * @return 
     **************************/
    public String Str(byte[] str) {
       return new String(str,StandardCharsets.UTF_8);
    }
    
    /********************************
     * Table de conversion version majeure
     * @param major_version
     * @return 
     *********************************/
    public String MVTab(byte[] major_version) {
        String result;
       int value =Int(major_version);
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

        /********************
     * Convertir le format 
     * numerique access_flags
     * des attributes en String
     * @param flags
     * @return 
     ********************/
    public String Methodes_ACMTab(int flags) {
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

    /*******************
     * Get Next size bytes
     * @param size
     * @return 
     *******************/
    public byte[] getNextBytes(int size){
        byte[] local=new byte[size];
        System.arraycopy(gbcm, idxP, local, 0, size);
        idxP=idxP+size;
        //System.out.println("idxP pos : "+idxP);
        return local;
    }
    
    /*******************
    * getmagic number to test
     * @param magic
    * @return
    *******************/
    public String getFileMagicNumber(byte[] magic){
        //getmagic 0-3
        return Hex(magic,false,false);
    }
    
    /*************************
     * Test magic number from file
     * @param fileMagicNumber
     * @return 
     ************************/
    public boolean testMagicNumber(String fileMagicNumber) {
        return fileMagicNumber.compareToIgnoreCase("cafebabe")==0; 
    }
    
    /********************************************
     * Sortie de l'application.
     * @param message
     ********************************************/
    public void exit(String message) 
    {
        System.out.println(message);
        System.exit(0);
    }
}
