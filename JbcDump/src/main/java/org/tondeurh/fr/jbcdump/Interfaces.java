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

import org.tondeurh.fr.jbcdump.containers.ClassFile;
import org.tondeurh.fr.jbcdump.tools.Tools;
import org.tondeurh.fr.jbcdump.containers.Interfaces_info;
import org.tondeurh.fr.jbcdump.containers.constants.CONSTANT_Class_info;

/**
 *
 * @author tondeur-h
 */
public class Interfaces {
ClassFile classFile;
Tools t;

    public Interfaces(ClassFile classFile,Tools t) {
        this.classFile=classFile;
        this.t=t;  
    }
  
    /***********************
     * Print interfaces infos
     * String
     ***********************/
    public void interfaces_infos_print() {
    int compteur=1;        
    boolean DEBUG=false;
    
        for (Interfaces_info int_info:classFile.getInterfaces())
        {
            //afficher le niveau cp_info
            if (DEBUG) System.out.print(" tag type : "+int_info.getItag()+" ");
            System.out.print("#"+compteur+"("+int_info.getConstant_name()+") : ");
            
            //afficher le contenu selon le type d'objet.
            //Classes
               System.out.println("#"+int_info.getContainer().getIname_index());

           compteur++; 
        }         
    }
                 
                 
    /**************************
     * alimenter le tableau
     * des interfaces_infos.
     **************************/
    public void interfaces_infos_read() {
        //must be a CONSTANT_Class_Info <=> Tag=7
                
    for (int count_pool=0;count_pool<t.Int(classFile.getInterfaces_count());count_pool++)
    {
        //alloc array constant_pool object
        Interfaces_info int_info=new Interfaces_info();
       //lire le tag
       int_info.setTag(t.getNextBytes(int_info.tag_size));
        int_info.setItag(t.Int(int_info.getTag()));
        switch(int_info.getItag())
        {
            case 7 -> 
            {
                int_info.setConstant_name("CONSTANT_Class");//afecter le type de cp_info
                int_info.setContainer(call_constant(int_info.getItag()));//affecter l'objet
            }
        }
        classFile.getInterfaces().add(int_info);
    } //fin for
    }
 
    
    /******************************
     * Read String constant pool
     * from typecp
     * @param typecp
     * @return 
     ******************************/
    private CONSTANT_Class_info call_constant(int typecp) {
        //CONSTANT_Class_info {u2 name_index;}
        CONSTANT_Class_info cci=new CONSTANT_Class_info();
        cci.setName_index(t.getNextBytes(2));
        cci.setIname_index(t.Int(cci.getName_index()));
        return cci;
    }

    
}
