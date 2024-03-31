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
 * u2 bootstrap_method_attr_index;u2 name_and_type_index
 * @author herve
 */
public class CONSTANT_Dynamic_info {

private byte[] bootstrap_method_attr_index;
private int ibootstrap_method_attr_index;
public byte bootstrap_method_attr_index_size=2;    
private byte[] name_and_type_index;
private int iname_and_type_index;
public byte name_and_type_index_size=2; 

    public byte[] getBootstrap_method_attr_index() {
        return bootstrap_method_attr_index;
    }

    public void setBootstrap_method_attr_index(byte[] bootstrap_method_attr_index) {
        this.bootstrap_method_attr_index = bootstrap_method_attr_index;
    }

    public int getIbootstrap_method_attr_index() {
        return ibootstrap_method_attr_index;
    }

    public void setIbootstrap_method_attr_index(int ibootstrap_method_attr_index) {
        this.ibootstrap_method_attr_index = ibootstrap_method_attr_index;
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
