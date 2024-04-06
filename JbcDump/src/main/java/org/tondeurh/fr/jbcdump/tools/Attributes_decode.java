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

import org.tondeurh.fr.jbcdump.containers.attributes.Attributes_Code;

/**
 *
 * @author herve
 */
public class Attributes_decode {

    Tools t;
    
    public Attributes_decode(Tools t) 
    {
        this.t=t;
    }
  
    /*******************************
     * Decoder l'attribut CODE.
     * @param info 
     *******************************/
    public void decode_CODE(byte[] info) 
    {
        int idxLoc=0;
        /*
    Code_attribute {
            u2 attribute_name_index;
            u4 attribute_length;
            u2 max_stack;
            u2 max_locals;
            u4 code_length;
            u1 code[code_length];
            u2 exception_table_length;
            { 
                u2 start_pc;
                u2 end_pc;
                u2 handler_pc;
                u2 catch_type;
            } exception_table[exception_table_length];
            u2 attributes_count;
            attribute_info attributes[attributes_count];}
    */
        System.out.println("["+t.Hex(info, true, true)+"]"); //<= traduire la séquence "info" en bytecode
        
        Attributes_Code ac=new Attributes_Code();
        //attribute_name_index
        //ac.setAttribute_name_index(t.getNextBytesFrom(info,idxLoc,2, "Attribute Name index"));
        //ac.setIattribute_name_index(t.Int(ac.getAttribute_name_index()));
        //idxLoc=idxLoc+2;
        //attribute_length
        //ac.setAttribute_length(t.getNextBytesFrom(info,idxLoc,4, "Attribute length"));
        //ac.setIattribute_length(t.Int4(ac.getAttribute_length()));
        //idxLoc=idxLoc+4;
        //max_stack
        ac.setMax_stack(t.getNextBytesFrom(info,idxLoc,2, "max_stack"));
        ac.setImax_stack(t.Int(ac.getMax_stack()));
        idxLoc=idxLoc+2;
        //max_locals
        ac.setMax_locals(t.getNextBytesFrom(info,idxLoc,2, "max_locals"));
        ac.setImax_locals(t.Int(ac.getMax_locals()));
        idxLoc=idxLoc+2;
        //code_length
        ac.setCode_length(t.getNextBytesFrom(info,idxLoc,4, "code_length"));
        ac.setIcode_length(t.Int(ac.getCode_length()));
        idxLoc=idxLoc+4;
        //ByteCode
        ac.setCode(t.getNextBytesFrom(info,idxLoc,ac.getIcode_length(), "BYTECODE"));
        System.out.println("OPCODE HEX : "+t.Hex(ac.getCode(),true,true));
        Opcodes opcodes=new Opcodes();
        opcodes.decode_opcodes(ac.getCode());
        
        idxLoc=idxLoc+ac.getIcode_length();
       //  u2 exception_table_length;
       ac.setException_table_length(t.getNextBytesFrom(info, idxLoc, 2, "Exception length"));
       ac.setIexception_table_length(t.Int(ac.getException_table_length()));
       //Ne pas lire les exceptions pour l'instant...
       idxLoc=idxLoc+(ac.getIexception_table_length()*8);
       ac.setAttributes_count(t.getNextBytesFrom(info, idxLoc, 2, "Attributes Count"));
       
    }
    
}
