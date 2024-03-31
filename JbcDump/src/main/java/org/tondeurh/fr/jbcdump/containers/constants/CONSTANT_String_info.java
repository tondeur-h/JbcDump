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
 * u2 string_index
 * @author herve
 */
public class CONSTANT_String_info {

private byte[] string_index;
private int istring_index;
public byte string_index_size=2;    

    public byte[] getString_index() {
        return string_index;
    }

    public void setString_index(byte[] string_index) {
        this.string_index = string_index;
    }

    public int getIstring_index() {
        return istring_index;
    }

    public void setIstring_index(int istring_index) {
        this.istring_index = istring_index;
    }

}
