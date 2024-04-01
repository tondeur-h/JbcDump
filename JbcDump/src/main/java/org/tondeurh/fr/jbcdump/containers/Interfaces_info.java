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

import org.tondeurh.fr.jbcdump.containers.constants.CONSTANT_Class_info;

/**
 *
 * @author herve
 */

/*
Each value in the interfaces array must be a valid index into
the constant_pool table. The constant_pool entry at each value
of interfaces[i], where 0 ≤ i < interfaces_count, must be a
CONSTANT_Class_info structure representing an interface that is a direct
superinterface of this class or interface type, in the left-to-right order given in
the source for the type.
*/

public class Interfaces_info {
 private byte[] tag;
private int itag;
public byte tag_size=1;
private String constant_name;
private CONSTANT_Class_info container;

//CONSTANT_Class    7   CONSTANT_Class_info {u2 name_index;}

    public CONSTANT_Class_info getContainer() {
        return container;
    }

    public void setContainer(CONSTANT_Class_info container) {
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
