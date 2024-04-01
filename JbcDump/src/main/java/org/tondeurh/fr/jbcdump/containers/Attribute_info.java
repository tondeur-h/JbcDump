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
Attributes are used in the ClassFile, field_info, method_info,
Code_attribute, and record_component_info structures of the class file format.

attribute_info {
u2 attribute_name_index;
u4 attribute_length;
u1 info[attribute_length];
}
*/
public class Attribute_info {

private byte[] name_index;
private int iname_index;
public byte name_index_size=2;

private byte[] attribute_length;
private int iattribute_length;
public byte attribute_length_size=4;
private byte[] info;

    public byte[] getInfo() {
        return info;
    }

    public void setInfo(byte[] info) {
        this.info = info;
    }

    public byte[] getName_index() {
        return name_index;
    }

    public void setName_index(byte[] name_index) {
        this.name_index = name_index;
    }

    public int getIname_index() {
        return iname_index;
    }

    public void setIname_index(int iname_index) {
        this.iname_index = iname_index;
    }

    public byte[] getAttribute_length() {
        return attribute_length;
    }

    public void setAttribute_length(byte[] attribute_length) {
        this.attribute_length = attribute_length;
    }

    public int getIattribute_length() {
        return iattribute_length;
    }

    public void setIattribute_length(int iattribute_length) {
        this.iattribute_length = iattribute_length;
    }


}
