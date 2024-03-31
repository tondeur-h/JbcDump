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
 * u4 high_bytes;u4 low_bytes
 * @author herve
 */
public class CONSTANT_Long_info {

private byte[] high_bytes;
private int ihigh_bytes;
public byte high_bytes_size=4;    
private byte[] low_bytes;
private int ilow_bytes;
public byte low_bytes_size=4; 

    public byte[] getHigh_bytes() {
        return high_bytes;
    }

    public void setHigh_bytes(byte[] high_bytes) {
        this.high_bytes = high_bytes;
    }

    public int getIhigh_bytes() {
        return ihigh_bytes;
    }

    public void setIhigh_bytes(int ihigh_bytes) {
        this.ihigh_bytes = ihigh_bytes;
    }

    public byte[] getLow_bytes() {
        return low_bytes;
    }

    public void setLow_bytes(byte[] low_bytes) {
        this.low_bytes = low_bytes;
    }

    public int getIlow_bytes() {
        return ilow_bytes;
    }

    public void setIlow_bytes(int ilow_bytes) {
        this.ilow_bytes = ilow_bytes;
    }



}
