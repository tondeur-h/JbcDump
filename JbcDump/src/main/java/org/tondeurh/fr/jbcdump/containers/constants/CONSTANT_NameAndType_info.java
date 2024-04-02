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
package org.tondeurh.fr.jbcdump.containers.constants;

/**
 *
 * u2 name_index;u2 descriptor_index
 * @author herve
 */
public class CONSTANT_NameAndType_info {

private byte[] name_index;
private int iname_index;   
private byte[] descriptor_index;
private int idescriptor_index;

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



}
