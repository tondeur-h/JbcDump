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
 * u1 reference_kind;u2 reference_index
 * @author herve
 */
public class CONSTANT_MethodHandle_info {

private byte[] reference_kind;
private int ireference_kind;
public byte reference_kind_size=1;    
private byte[] reference_index;
private int ireference_index;
public byte reference_index_size=2;

    public byte[] getReference_kind() {
        return reference_kind;
    }

    public void setReference_kind(byte[] reference_kind) {
        this.reference_kind = reference_kind;
    }

    public int getIreference_kind() {
        return ireference_kind;
    }

    public void setIreference_kind(int ireference_kind) {
        this.ireference_kind = ireference_kind;
    }

    public byte[] getReference_index() {
        return reference_index;
    }

    public void setReference_index(byte[] reference_index) {
        this.reference_index = reference_index;
    }

    public int getIreference_index() {
        return ireference_index;
    }

    public void setIreference_index(int ireference_index) {
        this.ireference_index = ireference_index;
    }

 
}
