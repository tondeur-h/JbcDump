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
import org.tondeurh.fr.jbcdump.containers.constants.CONSTANT_Utf8_info;

/**
 *
 * @author tondeur-h
 */
public class Attributes {
ClassFile classFile;
Tools t;

    /**************************
     * alimenter le tableau
     * des methodes_infos.
     **************************/
    public void attributes_infos_read() {
       /*
        attribute_info {
        u2 attribute_name_index;
        u4 attribute_length;
        u1 info[attribute_length];
        }
        */
        classFile.setAttributes(iterate_attributes(t.Int(classFile.getAttributes_count())));
    }
    
    /**
     * CONSTRUCTEUR
     * @param classFile
     * @param t
     */
    public Attributes(ClassFile classFile,Tools t) {
        this.classFile=classFile;
        this.t=t;  
    }
  
    /***********************
     * Print interfaces infos
     * String
     ***********************/
    public void attributes_infos_print() {            
            for (Attribute_info ai:classFile.getAttributes())
            {
                System.out.print(extract_constant_pool_value(ai.getIname_index())+" ");
                //System.out.println("["+t.Hex(ai.getInfo(), true, true)+"]");
                System.out.println(extract_constant_pool_info(t.Int(ai.getInfo())));
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
   
    /******************************
     * Extract valeur de in
     * @param index_constant_pool
     * @return 
     ******************************/
    private String extract_constant_pool_info(int index_constant_pool)
    {
        return ((CONSTANT_Utf8_info)classFile.getConstant_pool().get(index_constant_pool-1).getContainer()).getSbytesString();
    }
     
}
