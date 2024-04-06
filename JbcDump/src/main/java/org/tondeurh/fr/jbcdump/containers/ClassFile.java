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

import java.util.ArrayList;

/**
 * @author herve
 */
/*
ClassFile {
u4 magic;
u2 minor_version;
u2 major_version;
u2 constant_pool_count;
cp_info constant_pool[constant_pool_count-1];
u2 access_flags;
u2 this_class;
u2 super_class;
u2 interfaces_count;
u2 interfaces[interfaces_count];
u2 fields_count;
field_info fields[fields_count];
u2 methods_count;
method_info methods[methods_count];
u2 attributes_count;
attribute_info attributes[attributes_count];
}
*/
public class ClassFile {
 
private byte[] magic; //u4
private byte[] minor_version; //u2
private byte[] major_version; //u2
private byte[] constant_pool_count; //u2
private ArrayList<CP_info> constant_pool; //cp_info constant_pool[constant_pool_count-1]
private byte[] access_flags; //u2
private byte[] this_class; //u2
private byte[] super_class; //u2
private byte[] interfaces_count; //u2
private ArrayList<Interfaces_info> interfaces; //interfaces_info interfaces[interfaces_count]
private byte[] fields_count; //u2
private ArrayList<Fields_info> fields; //field_info fields[fields_count] 
private byte[] methods_count; //u2
private ArrayList<Methods_info> methods; //method_info methods[methods_count]
private byte[] attributes_count; //u2
private ArrayList<Attribute_info> attributes; //attribute_info attributes[attributes_count]

/************************
 * Construire les listes
 * des sections
 ************************/
    public ClassFile() {
    constant_pool=new ArrayList<>();
    interfaces=new ArrayList<>();
    fields=new ArrayList<>();
    methods=new ArrayList<>();
    attributes=new ArrayList<>();
    }

    /******************************/
    // queslques getters & setters
     /*****************************/
    
    public byte[] getMagic() {
        return magic;
    }

    public void setMagic(byte[] magic) {
        this.magic = magic;
    }

    public byte[] getMinor_version() {
        return minor_version;
    }

    public void setMinor_version(byte[] minor_version) {
        this.minor_version = minor_version;
    }

    public byte[] getMajor_version() {
        return major_version;
    }

    public void setMajor_version(byte[] major_version) {
        this.major_version = major_version;
    }

    public byte[] getConstant_pool_count() {
        return constant_pool_count;
    }

    public void setConstant_pool_count(byte[] constant_pool_count) {
        this.constant_pool_count = constant_pool_count;
    }

    public ArrayList<CP_info> getConstant_pool() {
        return constant_pool;
    }

    public void setConstant_pool(ArrayList<CP_info> constant_pool) {
        this.constant_pool = constant_pool;
    }

    public byte[] getAccess_flags() {
        return access_flags;
    }

    public void setAccess_flags(byte[] access_flags) {
        this.access_flags = access_flags;
    }

    public byte[] getThis_class() {
        return this_class;
    }

    public void setThis_class(byte[] this_class) {
        this.this_class = this_class;
    }

    public byte[] getSuper_class() {
        return super_class;
    }

    public void setSuper_class(byte[] super_class) {
        this.super_class = super_class;
    }

    public byte[] getInterfaces_count() {
        return interfaces_count;
    }

    public void setInterfaces_count(byte[] interfaces_count) {
        this.interfaces_count = interfaces_count;
    }

    public ArrayList<Interfaces_info> getInterfaces() {
        return interfaces;
    }

    public void setInterfaces(ArrayList<Interfaces_info> interfaces) {
        this.interfaces = interfaces;
    }

    public byte[] getFields_count() {
        return fields_count;
    }

    public void setFields_count(byte[] fields_count) {
        this.fields_count = fields_count;
    }

    public ArrayList<Fields_info> getFields() {
        return fields;
    }

    public void setFields(ArrayList<Fields_info> fields) {
        this.fields = fields;
    }

    public byte[] getMethods_count() {
        return methods_count;
    }

    public void setMethods_count(byte[] methods_count) {
        this.methods_count = methods_count;
    }

    public ArrayList<Methods_info> getMethods() {
        return methods;
    }

    public void setMethods(ArrayList<Methods_info> methods) {
        this.methods = methods;
    }

    public byte[] getAttributes_count() {
        return attributes_count;
    }

    public void setAttributes_count(byte[] attributes_count) {
        this.attributes_count = attributes_count;
    }

    public ArrayList<Attribute_info> getAttributes() {
        return attributes;
    }

    public void setAttributes(ArrayList<Attribute_info> attributes) {
        this.attributes = attributes;
    }
    
}
