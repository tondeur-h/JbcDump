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

import java.util.ArrayList;

/**
 *
 * @author herve
 */

/*
each value in the fields table must be a field_info structure giving
a complete description of a field in this class or interface. The fields table
includes only those fields that are declared by this class or interface. It does
not include items representing fields that are inherited from superclasses or
superinterfaces.

field_info {
u2 access_flags;
u2 name_index;
u2 descriptor_index;
u2 attributes_count;
attribute_info attributes[attributes_count];
}
*/
public class Fields_info {
private byte[] access_flags;
private int iaccess_flags;
public byte access_flags_size=2;

private byte[] name_index;
private int iname_index;
public byte name_index_size=2;

private byte[] descriptor_index;
private int idescriptor_index;
public byte descriptor_index_size=2;

private byte[] attributes_count;
private int iattributes_count;
public byte attributes_count_size=2;
private ArrayList <Attribute_info> attributes;

    public Fields_info() {
        attributes=new ArrayList<>();
    }
    
    public byte[] getAccess_flags() {
        return access_flags;
    }

    public void setAccess_flags(byte[] access_flags) {
        this.access_flags = access_flags;
    }

    public int getIaccess_flags() {
        return iaccess_flags;
    }

    public void setIaccess_flags(int iaccess_flags) {
        this.iaccess_flags = iaccess_flags;
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

    public byte[] getDescriptor_index() {
        return descriptor_index;
    }

    public void setDescriptor_index(byte[] descriptor_index) {
        this.descriptor_index = descriptor_index;
    }

    public int getIdescriptor_index() {
        return idescriptor_index;
    }

    public void setIdescriptor_index(int idescriptor_index) {
        this.idescriptor_index = idescriptor_index;
    }

    public byte[] getAttributes_count() {
        return attributes_count;
    }

    public void setAttributes_count(byte[] attributes_count) {
        this.attributes_count = attributes_count;
    }

    public int getIattributes_count() {
        return iattributes_count;
    }

    public void setIattributes_count(int iattributes_count) {
        this.iattributes_count = iattributes_count;
    }

    public ArrayList<Attribute_info> getAttributes() {
        return attributes;
    }

    public void setAttributes(ArrayList<Attribute_info> attributes) {
        this.attributes = attributes;
    }

}
