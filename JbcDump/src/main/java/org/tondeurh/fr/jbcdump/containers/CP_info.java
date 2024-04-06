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
package org.tondeurh.fr.jbcdump.containers;

/**
 *
 * @author herve
 */
/*
The constant_pool is a table of structures representing various string
constants, class and interface names, field names, and other constants that are
referred to within the ClassFile structure and its substructures. The format of
each constant_pool table entry is indicated by its first "tag" byte.
The constant_pool table is indexed from 1 to constant_pool_count - 1.
*/
/*
cp_info {
u1 tag;
u1 info[];
}
*/
public class CP_info {
    
private byte[] tag;
private int itag;
private String constant_name;
private Object container;
private String translateString; //pas dans la documentation mais permet de resoudre la notion de terminal

//selon le type de tag la valeur a collecter va changer
/*
Ex  constant_name               tag classe
X   CONSTANT_Utf8               1   CONSTANT_Utf8_info {u2 length;u1 bytes[length];}
X   CONSTANT_Integer            3   CONSTANT_Integer_info {u4 bytes;}
X   CONSTANT_Float              4   CONSTANT_Float_info {u4 bytes;}
X   CONSTANT_Long               5   CONSTANT_Long_info {u4 high_bytes;u4 low_bytes;}
X   CONSTANT_Double             6   CONSTANT_Double_info {u4 high_bytes;u4 low_bytes;}
X   CONSTANT_Class              7   CONSTANT_Class_info {u2 name_index;}
X   CONSTANT_String             8   CONSTANT_String_info {u2 string_index;}
X   CONSTANT_Fieldref           9   CONSTANT_Fieldref_info {u2 class_index;u2 name_and_type_index;} 
X   CONSTANT_Methodref          10  CONSTANT_Methodref_info {u2 class_index;u2 name_and_type_index;}
X   CONSTANT_InterfaceMethodref 11  CONSTANT_InterfaceMethodref_info {u2 class_index;u2 name_and_type_index;}
X   CONSTANT_NameAndType        12  CONSTANT_NameAndType_info {u2 name_index;u2 descriptor_index;}
X   CONSTANT_MethodHandle       15  CONSTANT_MethodHandle_info {u1 reference_kind;u2 reference_index;}
X   CONSTANT_MethodType         16  CONSTANT_MethodType_info {u2 descriptor_index;}
X   CONSTANT_Dynamic            17  CONSTANT_Dynamic_info {u2 bootstrap_method_attr_index;u2 name_and_type_index;}
X   CONSTANT_InvokeDynamic      18  CONSTANT_InvokeDynamic_info {u2 bootstrap_method_attr_index;u2 name_and_type_index;}
X   CONSTANT_Module             19  CONSTANT_Module_info {u2 name_index;}
X   CONSTANT_Package            20  CONSTANT_Package_info {u2 name_index;}
*/

    public String getTranslateString() {
        return translateString;
    }

    public void setTranslateString(String translateString) {
        this.translateString = translateString;
    }

    public Object getContainer() {
        return container;
    }

    public void setContainer(Object container) {
        this.container = container;
    }

    public byte[] getTag() {
        return tag;
    }

    public void setTag(byte[] tag) {
        this.tag = tag;
    }

    public int getItag() {
        return itag;
    }

    public void setItag(int itag) {
        this.itag = itag;
    }

    public String getConstant_name() {
        return constant_name;
    }

    public void setConstant_name(String constant_name) {
        this.constant_name = constant_name;
    }
    
}
