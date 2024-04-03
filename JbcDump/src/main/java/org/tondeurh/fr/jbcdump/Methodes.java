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
package org.tondeurh.fr.jbcdump;

import java.util.ArrayList;
import org.tondeurh.fr.jbcdump.containers.Attribute_info;
import org.tondeurh.fr.jbcdump.containers.ClassFile;
import org.tondeurh.fr.jbcdump.tools.Tools;
import org.tondeurh.fr.jbcdump.containers.Methods_info;
import org.tondeurh.fr.jbcdump.containers.constants.CONSTANT_Utf8_info;

/**
 *
 * @author tondeur-h
 */
public class Methodes {
ClassFile classFile;
Tools t;

    /**************************
     * alimenter le tableau
     * des methodes_infos.
     **************************/
    public void methodes_infos_read() {
        for (int count_pool=0;count_pool<t.Int(classFile.getMethods_count());count_pool++)
    {
       /*method_info {
			u2 access_flags;
			u2 name_index;
			u2 descriptor_index;
			u2 attributes_count;
			attribute_info attributes[attributes_count];
        }*/
       //alloc array constant_pool object
        Methods_info method_info=new Methods_info();
        //convertir access_flags
        method_info.setAccess_flags(t.getNextBytes(2));
        method_info.setIaccess_flags(t.Int(method_info.getAccess_flags()));
        method_info.setName_index(t.getNextBytes(2));
        method_info.setIname_index(t.Int(method_info.getName_index()));
        method_info.setDescriptor_index(t.getNextBytes(2));
        method_info.setIdescriptor_index(t.Int(method_info.getDescriptor_index()));
        method_info.setAttributes_count(t.getNextBytes(2));
        method_info.setIattributes_count(t.Int(method_info.getAttributes_count()));
  
        //attribute_info attributes[attributes_count] renseigner  
        method_info.setAttributes(iterate_attributes(method_info.getIattributes_count()));
    
        //ajouter a la classe file
        classFile.getMethods().add(method_info);
    }
    }
    
    /**
     * CONSTRUCTEUR
     * @param classFile
     * @param t
     */
    public Methodes(ClassFile classFile,Tools t) {
        this.classFile=classFile;
        this.t=t;  
    }
  
    /***********************
     * Print interfaces infos
     * String
     ***********************/
    public void methodes_infos_print() {            
        for (Methods_info method_info:classFile.getMethods())
        {
            System.out.println(" Access Flags : "+t.Methodes_AFTab(method_info.getIaccess_flags()));
            System.out.print(extract_constant_pool_value(method_info.getIname_index()));
            System.out.println(extract_constant_pool_value(method_info.getIdescriptor_index()));
            
            for (Attribute_info ai:method_info.getAttributes())
            {
                System.out.print(extract_constant_pool_value(ai.getIname_index())+" ");
                System.out.println("["+t.Hex(ai.getInfo(), true, true)+"]"); //<= traduire la séquence "info" en bytecode
                System.out.println("");
            }
        }         
    }
                       
    /***************************
     * Itterer dans le code des
     * attributs (multi sources
     * @param attributes_count
     * @return 
     ***************************/
    private ArrayList <Attribute_info> iterate_attributes(int attributes_count) {
        /*
	attribute_info {
	u2 attribute_name_index;
	u4 attribute_length;
	u1 info[attribute_length];
	}
        */
        //Liste des attribute_info de 
        ArrayList <Attribute_info> attributes=new ArrayList<>();
        
        for (int attributes_count_counter=0;attributes_count_counter<attributes_count;attributes_count_counter++)
        {
            Attribute_info ai=new Attribute_info(); //1 attribute_info
            ai.setName_index(t.getNextBytes(2));
            ai.setIname_index(t.Int(ai.getName_index()));
            ai.setAttribute_length(t.getNextBytes(4));
            ai.setIattribute_length(t.Int(ai.getAttribute_length()));
            
        //get u1 info
        ai.setInfo(t.getNextBytes(ai.getIattribute_length()));
        attributes.add(ai);
        }
        return attributes;
    }
    
    /******************************
     * Extract valeur de CP
     * @param index_constant_pool
     * @return 
     ******************************/
    private String extract_constant_pool_value(int index_constant_pool)
    {
        return ((CONSTANT_Utf8_info)classFile.getConstant_pool().get(index_constant_pool-1).getContainer()).getSbytesString();
    }
   
}
