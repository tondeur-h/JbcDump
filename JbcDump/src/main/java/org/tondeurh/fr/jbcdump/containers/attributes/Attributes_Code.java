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
package org.tondeurh.fr.jbcdump.containers.attributes;

import java.util.ArrayList;
import org.tondeurh.fr.jbcdump.containers.Attribute_info;

/**
 *
 * @author herve
 */
public class Attributes_Code {
   /*
    Code_attribute {
        u2 attribute_name_index;
        u4 attribute_length;
        u2 max_stack;
        u2 max_locals;
        u4 code_length;
        u1 code[code_length];
        u2 exception_table_length;
        { u2 start_pc;
        u2 end_pc;
        u2 handler_pc;
        u2 catch_type;
        } exception_table[exception_table_length];
        u2 attributes_count;
        attribute_info attributes[attributes_count];
    }
*/
    
    private byte[] attribute_name_index;
    private int Iattribute_name_index;
    private byte[] attribute_length;
    private int Iattribute_length;
    private byte[] max_stack;
    private int Imax_stack;
    private byte[] max_locals;
    private int Imax_locals;
    private byte[] code_length;
    private int Icode_length;
    private byte[]code;
    private byte[] exception_table_length;
    private int Iexception_table_length;
    private ArrayList<Exception_table> exception_table;
    private byte[] attributes_count;
    private int Iattributes_count;
    private ArrayList<Attribute_info> attributes;

    public byte[] getAttribute_name_index() {
        return attribute_name_index;
    }

    public void setAttribute_name_index(byte[] attribute_name_index) {
        this.attribute_name_index = attribute_name_index;
    }

    public int getIattribute_name_index() {
        return Iattribute_name_index;
    }

    public void setIattribute_name_index(int Iattribute_name_index) {
        this.Iattribute_name_index = Iattribute_name_index;
    }

    public byte[] getAttribute_length() {
        return attribute_length;
    }

    public void setAttribute_length(byte[] attribute_length) {
        this.attribute_length = attribute_length;
    }

    public int getIattribute_length() {
        return Iattribute_length;
    }

    public void setIattribute_length(int Iattribute_length) {
        this.Iattribute_length = Iattribute_length;
    }

    public byte[] getMax_stack() {
        return max_stack;
    }

    public void setMax_stack(byte[] max_stack) {
        this.max_stack = max_stack;
    }

    public int getImax_stack() {
        return Imax_stack;
    }

    public void setImax_stack(int Imax_stack) {
        this.Imax_stack = Imax_stack;
    }

    public byte[] getMax_locals() {
        return max_locals;
    }

    public void setMax_locals(byte[] max_locals) {
        this.max_locals = max_locals;
    }

    public int getImax_locals() {
        return Imax_locals;
    }

    public void setImax_locals(int Imax_locals) {
        this.Imax_locals = Imax_locals;
    }

    public byte[] getCode_length() {
        return code_length;
    }

    public void setCode_length(byte[] code_length) {
        this.code_length = code_length;
    }

    public int getIcode_length() {
        return Icode_length;
    }

    public void setIcode_length(int Icode_length) {
        this.Icode_length = Icode_length;
    }

    public byte[] getCode() {
        return code;
    }

    public void setCode(byte[] code) {
        this.code = code;
    }

    public byte[] getException_table_length() {
        return exception_table_length;
    }

    public void setException_table_length(byte[] exception_table_length) {
        this.exception_table_length = exception_table_length;
    }

    public int getIexception_table_length() {
        return Iexception_table_length;
    }

    public void setIexception_table_length(int Iexception_table_length) {
        this.Iexception_table_length = Iexception_table_length;
    }

    public ArrayList<Exception_table> getException_table() {
        return exception_table;
    }

    public void setException_table(ArrayList<Exception_table> exception_table) {
        this.exception_table = exception_table;
    }

    public byte[] getAttributes_count() {
        return attributes_count;
    }

    public void setAttributes_count(byte[] attributes_count) {
        this.attributes_count = attributes_count;
    }

    public int getIattributes_count() {
        return Iattributes_count;
    }

    public void setIattributes_count(int Iattributes_count) {
        this.Iattributes_count = Iattributes_count;
    }

    public ArrayList<Attribute_info> getAttributes() {
        return attributes;
    }

    public void setAttributes(ArrayList<Attribute_info> attributes) {
        this.attributes = attributes;
    }
    
    
}

class Exception_table{
   /*
    {   u2 start_pc;
        u2 end_pc;
        u2 handler_pc;
        u2 catch_type;
    } exception_table[exception_table_length];
    */ 
    private byte[] start_pc;
    private int Istart_pc;
    private byte[] end_pc;
    private int Iend_pc;
    private byte[] handler_pc;
    private int Ihandler_pc;
    private byte[] catch_type;
    private int Icatch_type;
    
    public byte[] getStart_pc() {
        return start_pc;
    }

    public void setStart_pc(byte[] start_pc) {
        this.start_pc = start_pc;
    }

    public int getIstart_pc() {
        return Istart_pc;
    }

    public void setIstart_pc(int Istart_pc) {
        this.Istart_pc = Istart_pc;
    }

    public byte[] getEnd_pc() {
        return end_pc;
    }

    public void setEnd_pc(byte[] end_pc) {
        this.end_pc = end_pc;
    }

    public int getIend_pc() {
        return Iend_pc;
    }

    public void setIend_pc(int Iend_pc) {
        this.Iend_pc = Iend_pc;
    }

    public byte[] getHandler_pc() {
        return handler_pc;
    }

    public void setHandler_pc(byte[] handler_pc) {
        this.handler_pc = handler_pc;
    }

    public int getIhandler_pc() {
        return Ihandler_pc;
    }

    public void setIhandler_pc(int Ihandler_pc) {
        this.Ihandler_pc = Ihandler_pc;
    }

    public byte[] getCatch_type() {
        return catch_type;
    }

    public void setCatch_type(byte[] catch_type) {
        this.catch_type = catch_type;
    }

    public int getIcatch_type() {
        return Icatch_type;
    }

    public void setIcatch_type(int Icatch_type) {
        this.Icatch_type = Icatch_type;
    }
    
    
}


