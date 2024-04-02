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
 * u2 length;u1 bytes[length]
 * @author herve
 */
public class CONSTANT_Utf8_info {

private byte[] length;
private int ilength;
private byte[] bytesString;
private String sbytesString;

    public byte[] getLength() {
        return length;
    }

    public void setLength(byte[] length) {
        this.length = length;
    }

    public int getIlength() {
        return ilength;
    }

    public void setIlength(int ilength) {
        this.ilength = ilength;
    }

    public byte[] getBytesString() {
        return bytesString;
    }

    public void setBytesString(byte[] bytesString) {
        this.bytesString = bytesString;
    }

    public String getSbytesString() {
        return sbytesString;
    }

    public void setSbytesString(String sbytesString) {
        this.sbytesString = sbytesString;
    }

}
