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
package org.tondeurh.fr.jbcdump.tools;

/**
 *
 * @author herve
 */
public class Opcodes {

    
    public Opcodes() {
    }
    
    public void decode_opcodes(byte[] code)
    {
        int compteur=1;
        for (int pc=0;pc<code.length;pc++)
        {
            switch(Int(code[pc]))
            {
                case 42 -> {System.out.println("#"+compteur+"("+pc+"):"+"aload_0");}
                case 183 -> {
                    System.out.println("#"+compteur+"("+pc+"):"+"invokespecial "+(code[(pc+1)]<<8+code[(pc+2)]));
                    pc=pc+2;
                }
                case 177 ->{System.out.println("#"+compteur+"("+pc+"):"+"return");}                
            }
        }
    }
    
    /**************************
     * convertir byte1 to Integer
     * @param hexa
     * @return 
     **************************/
    public int Int(byte hexa) {return hexa & 0xFF;}
 
}
