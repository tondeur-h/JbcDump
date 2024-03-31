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
 * u2 class_index;u2 name_and_type_index
 * @author herve
 */
public class CONSTANT_NameAndType_info {

private byte[] class_index;
private int iclass_index;
public byte class_index_size=2;    
private byte[] name_and_type_index;
private int iname_and_type_index;
public byte name_and_type_index_size=2;

    public int getIclass_index() {
        return iclass_index;
    }

    public void setIclass_index(int iclass_index) {
        this.iclass_index = iclass_index;
    }

    public byte[] getName_and_type_index() {
        return name_and_type_index;
    }

    public void setName_and_type_index(byte[] name_and_type_index) {
        this.name_and_type_index = name_and_type_index;
    }

    public int getIname_and_type_index() {
        return iname_and_type_index;
    }

    public void setIname_and_type_index(int iname_and_type_index) {
        this.iname_and_type_index = iname_and_type_index;
    }
 
}
