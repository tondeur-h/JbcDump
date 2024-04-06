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
                //constants
                case 00 -> {System.out.println("#"+compteur+"("+pc+"):"+"nop");}
                case 01 -> {System.out.println("#"+compteur+"("+pc+"):"+"aconst_null");}
                case 02 -> {System.out.println("#"+compteur+"("+pc+"):"+"iconst_m1");}
                case 03 -> {System.out.println("#"+compteur+"("+pc+"):"+"iconst_0");}
                case 04 -> {System.out.println("#"+compteur+"("+pc+"):"+"iconst_1");}
                case 05 -> {System.out.println("#"+compteur+"("+pc+"):"+"iconst_2");}
                case 06 -> {System.out.println("#"+compteur+"("+pc+"):"+"iconst_3");}
                case 07 -> {System.out.println("#"+compteur+"("+pc+"):"+"iconst_4");}
                case 8 -> {System.out.println("#"+compteur+"("+pc+"):"+"iconst_5");}
                case 9 -> {System.out.println("#"+compteur+"("+pc+"):"+"lconst_0");}
                case 10 -> {System.out.println("#"+compteur+"("+pc+"):"+"lconst_1");}
                case 11 -> {System.out.println("#"+compteur+"("+pc+"):"+"fconst_0");}
                case 12 -> {System.out.println("#"+compteur+"("+pc+"):"+"fconst_1");}
                case 13 -> {System.out.println("#"+compteur+"("+pc+"):"+"fconst_2");}
                case 14 -> {System.out.println("#"+compteur+"("+pc+"):"+"dconst_0");}
                case 15 -> {System.out.println("#"+compteur+"("+pc+"):"+"dconst_1");}
                case 16 -> {System.out.println("#"+compteur+"("+pc+"):"+"bipush");}
                case 17 -> {System.out.println("#"+compteur+"("+pc+"):"+"sipush");}
                case 18 -> {System.out.println("#"+compteur+"("+pc+"):"+"ldc");}
                case 19 -> {System.out.println("#"+compteur+"("+pc+"):"+"ldc_w");}
                case 20 -> {System.out.println("#"+compteur+"("+pc+"):"+"ldc2_w");}
                //load
                case 21 -> {System.out.println("#"+compteur+"("+pc+"):"+"iload");}
                case 22 -> {System.out.println("#"+compteur+"("+pc+"):"+"lload");}
                case 23 -> {System.out.println("#"+compteur+"("+pc+"):"+"fload");}
                case 24 -> {System.out.println("#"+compteur+"("+pc+"):"+"dload");}
                case 25 -> {System.out.println("#"+compteur+"("+pc+"):"+"aload");}
                case 26 -> {System.out.println("#"+compteur+"("+pc+"):"+"iload_0");}
                case 27 -> {System.out.println("#"+compteur+"("+pc+"):"+"iload_1");}
                case 28 -> {System.out.println("#"+compteur+"("+pc+"):"+"iload_2");}
                case 29 -> {System.out.println("#"+compteur+"("+pc+"):"+"iload_3");}
                case 30 -> {System.out.println("#"+compteur+"("+pc+"):"+"lload_0");}
                case 31 -> {System.out.println("#"+compteur+"("+pc+"):"+"lload_1");}
                case 32 -> {System.out.println("#"+compteur+"("+pc+"):"+"lload_2");}
                case 33 -> {System.out.println("#"+compteur+"("+pc+"):"+"lload_3");}
                case 34 -> {System.out.println("#"+compteur+"("+pc+"):"+"fload_0");}
                case 35 -> {System.out.println("#"+compteur+"("+pc+"):"+"fload_1");}
                case 36 -> {System.out.println("#"+compteur+"("+pc+"):"+"fload_2");}
                case 37 -> {System.out.println("#"+compteur+"("+pc+"):"+"fload_3");}
                case 38 -> {System.out.println("#"+compteur+"("+pc+"):"+"dload_0");}
                case 39 -> {System.out.println("#"+compteur+"("+pc+"):"+"dload_1");}
                case 40 -> {System.out.println("#"+compteur+"("+pc+"):"+"dload_2");}
                case 41 -> {System.out.println("#"+compteur+"("+pc+"):"+"dload_3");}
                case 42 -> {System.out.println("#"+compteur+"("+pc+"):"+"aload_0");}
                case 43 -> {System.out.println("#"+compteur+"("+pc+"):"+"aload_1");}
                case 44 -> {System.out.println("#"+compteur+"("+pc+"):"+"aload_2");}
                case 45 -> {System.out.println("#"+compteur+"("+pc+"):"+"aload_3");}
                case 46 -> {System.out.println("#"+compteur+"("+pc+"):"+"iaload");}
                case 47 -> {System.out.println("#"+compteur+"("+pc+"):"+"laload");}
                case 48 -> {System.out.println("#"+compteur+"("+pc+"):"+"faload");}
                case 49 -> {System.out.println("#"+compteur+"("+pc+"):"+"daload");}
                case 50 -> {System.out.println("#"+compteur+"("+pc+"):"+"aaload");}
                case 51 -> {System.out.println("#"+compteur+"("+pc+"):"+"baload");}
                case 52 -> {System.out.println("#"+compteur+"("+pc+"):"+"caload");}
                case 53 -> {System.out.println("#"+compteur+"("+pc+"):"+"saload");}
                //store
                case 54 -> {System.out.println("#"+compteur+"("+pc+"):"+"istore");}
                case 55 -> {System.out.println("#"+compteur+"("+pc+"):"+"lstore");}
                case 56 -> {System.out.println("#"+compteur+"("+pc+"):"+"fstore");}
                case 57 -> {System.out.println("#"+compteur+"("+pc+"):"+"dstore");}
                case 58 -> {System.out.println("#"+compteur+"("+pc+"):"+"astore");}
                case 59 -> {System.out.println("#"+compteur+"("+pc+"):"+"istore_0");}
                case 60 -> {System.out.println("#"+compteur+"("+pc+"):"+"istore_1");}
                case 61 -> {System.out.println("#"+compteur+"("+pc+"):"+"istore_2");}
                case 62 -> {System.out.println("#"+compteur+"("+pc+"):"+"istore_3");}
                case 63 -> {System.out.println("#"+compteur+"("+pc+"):"+"lstore_0");}
                case 64 -> {System.out.println("#"+compteur+"("+pc+"):"+"lstore_1");}
                case 65 -> {System.out.println("#"+compteur+"("+pc+"):"+"lstore_2");}
                case 66 -> {System.out.println("#"+compteur+"("+pc+"):"+"lstore_3");}
                case 67 -> {System.out.println("#"+compteur+"("+pc+"):"+"fstore_0");}
                case 68 -> {System.out.println("#"+compteur+"("+pc+"):"+"fstore_1");}
                case 69 -> {System.out.println("#"+compteur+"("+pc+"):"+"fstore_2");}
                case 70 -> {System.out.println("#"+compteur+"("+pc+"):"+"fstore_3");}
                case 71 -> {System.out.println("#"+compteur+"("+pc+"):"+"dstore_0");}
                case 72 -> {System.out.println("#"+compteur+"("+pc+"):"+"dstore_1");}
                case 73 -> {System.out.println("#"+compteur+"("+pc+"):"+"dstore_2");}
                case 74 -> {System.out.println("#"+compteur+"("+pc+"):"+"dstore_3");}
                case 75 -> {System.out.println("#"+compteur+"("+pc+"):"+"astore_0");}
                case 76 -> {System.out.println("#"+compteur+"("+pc+"):"+"astore_1");}
                case 77 -> {System.out.println("#"+compteur+"("+pc+"):"+"astore_2");}
                case 78 -> {System.out.println("#"+compteur+"("+pc+"):"+"astore_3");}
                case 79 -> {System.out.println("#"+compteur+"("+pc+"):"+"iastore");}
                case 80 -> {System.out.println("#"+compteur+"("+pc+"):"+"lastore");}
                case 81 -> {System.out.println("#"+compteur+"("+pc+"):"+"fastore");}
                case 82 -> {System.out.println("#"+compteur+"("+pc+"):"+"dastore");}
                case 83 -> {System.out.println("#"+compteur+"("+pc+"):"+"aastore");}
                case 84 -> {System.out.println("#"+compteur+"("+pc+"):"+"bastore");}
                case 85 -> {System.out.println("#"+compteur+"("+pc+"):"+"castore");}
                case 86 -> {System.out.println("#"+compteur+"("+pc+"):"+"sastore");}
                //stack
                case 87 -> {System.out.println("#"+compteur+"("+pc+"):"+"pop");}
                case 88 -> {System.out.println("#"+compteur+"("+pc+"):"+"pop2");}
                case 89 -> {System.out.println("#"+compteur+"("+pc+"):"+"dup");}
                case 90 -> {System.out.println("#"+compteur+"("+pc+"):"+"dup_x1");}
                case 91 -> {System.out.println("#"+compteur+"("+pc+"):"+"dup_x2");}
                case 92 -> {System.out.println("#"+compteur+"("+pc+"):"+"dup2");}
                case 93 -> {System.out.println("#"+compteur+"("+pc+"):"+"dup2_x1");}
                case 94 -> {System.out.println("#"+compteur+"("+pc+"):"+"dup2_x2");}
                case 95 -> {System.out.println("#"+compteur+"("+pc+"):"+"swap");}   
                //Math
                case 96 -> {System.out.println("#"+compteur+"("+pc+"):"+"iadd");}
                case 97 -> {System.out.println("#"+compteur+"("+pc+"):"+"ladd");}
                case 98 -> {System.out.println("#"+compteur+"("+pc+"):"+"fadd");}
                case 99 -> {System.out.println("#"+compteur+"("+pc+"):"+"dadd");}
                case 100 -> {System.out.println("#"+compteur+"("+pc+"):"+"isub");}
                case 101 -> {System.out.println("#"+compteur+"("+pc+"):"+"lsub");}
                case 102 -> {System.out.println("#"+compteur+"("+pc+"):"+"fsub");}
                case 103 -> {System.out.println("#"+compteur+"("+pc+"):"+"dsub");}
                case 104 -> {System.out.println("#"+compteur+"("+pc+"):"+"imul");}
                case 105 -> {System.out.println("#"+compteur+"("+pc+"):"+"lmul");}
                case 106 -> {System.out.println("#"+compteur+"("+pc+"):"+"fmul");}
                case 107 -> {System.out.println("#"+compteur+"("+pc+"):"+"dmul");}
                case 108 -> {System.out.println("#"+compteur+"("+pc+"):"+"idiv");}
                case 109 -> {System.out.println("#"+compteur+"("+pc+"):"+"ldiv");}
                case 110 -> {System.out.println("#"+compteur+"("+pc+"):"+"fdiv");}
                case 111 -> {System.out.println("#"+compteur+"("+pc+"):"+"ddiv");}
                case 112 -> {System.out.println("#"+compteur+"("+pc+"):"+"irem");}
                case 113 -> {System.out.println("#"+compteur+"("+pc+"):"+"lrem");}
                case 114 -> {System.out.println("#"+compteur+"("+pc+"):"+"frem");}
                case 115 -> {System.out.println("#"+compteur+"("+pc+"):"+"drem");}
                case 116 -> {System.out.println("#"+compteur+"("+pc+"):"+"ineg");}
                case 117 -> {System.out.println("#"+compteur+"("+pc+"):"+"lneg");}
                case 118 -> {System.out.println("#"+compteur+"("+pc+"):"+"fneg");}
                case 119 -> {System.out.println("#"+compteur+"("+pc+"):"+"dneg");}
                case 120 -> {System.out.println("#"+compteur+"("+pc+"):"+"ishl");}
                case 121 -> {System.out.println("#"+compteur+"("+pc+"):"+"lshl");}
                case 122 -> {System.out.println("#"+compteur+"("+pc+"):"+"ishr");}
                case 123 -> {System.out.println("#"+compteur+"("+pc+"):"+"lshr");}
                case 124 -> {System.out.println("#"+compteur+"("+pc+"):"+"iushr");}
                case 125 -> {System.out.println("#"+compteur+"("+pc+"):"+"lushr");}
                case 126 -> {System.out.println("#"+compteur+"("+pc+"):"+"iand");}
                case 127 -> {System.out.println("#"+compteur+"("+pc+"):"+"land");}
                case 128 -> {System.out.println("#"+compteur+"("+pc+"):"+"ior");}
                case 129 -> {System.out.println("#"+compteur+"("+pc+"):"+"lor");}
                case 130 -> {System.out.println("#"+compteur+"("+pc+"):"+"ixor");}
                case 131 -> {System.out.println("#"+compteur+"("+pc+"):"+"lxor");}
                case 132 -> {System.out.println("#"+compteur+"("+pc+"):"+"iinc");}
                //conversions
                case 133 -> {System.out.println("#"+compteur+"("+pc+"):"+"i2l");}
                case 134 -> {System.out.println("#"+compteur+"("+pc+"):"+"i2f");}
                case 135 -> {System.out.println("#"+compteur+"("+pc+"):"+"i2d");}
                case 136 -> {System.out.println("#"+compteur+"("+pc+"):"+"l2i");}
                case 137 -> {System.out.println("#"+compteur+"("+pc+"):"+"l2f");}
                case 138 -> {System.out.println("#"+compteur+"("+pc+"):"+"l2d");}
                case 139 -> {System.out.println("#"+compteur+"("+pc+"):"+"f2i");}
                case 140 -> {System.out.println("#"+compteur+"("+pc+"):"+"f2l");}
                case 141 -> {System.out.println("#"+compteur+"("+pc+"):"+"f2d");}
                case 142 -> {System.out.println("#"+compteur+"("+pc+"):"+"d2i");}
                case 143 -> {System.out.println("#"+compteur+"("+pc+"):"+"d2l");}
                case 144 -> {System.out.println("#"+compteur+"("+pc+"):"+"d2f");}
                case 145 -> {System.out.println("#"+compteur+"("+pc+"):"+"i2b");}
                case 146 -> {System.out.println("#"+compteur+"("+pc+"):"+"i2c");}
                case 147 -> {System.out.println("#"+compteur+"("+pc+"):"+"i2s");}
                //comparisons
                case 148 -> {System.out.println("#"+compteur+"("+pc+"):"+"lcmp");}
                case 149 -> {System.out.println("#"+compteur+"("+pc+"):"+"fcmpl");}
                case 150 -> {System.out.println("#"+compteur+"("+pc+"):"+"fcmpg");}
                case 151 -> {System.out.println("#"+compteur+"("+pc+"):"+"dcmpl");}
                case 152 -> {System.out.println("#"+compteur+"("+pc+"):"+"dcmpg");}
                case 153 -> {System.out.println("#"+compteur+"("+pc+"):"+"ifeq");}
                case 154 -> {System.out.println("#"+compteur+"("+pc+"):"+"ifne");}
                case 155 -> {System.out.println("#"+compteur+"("+pc+"):"+"iflt");}
                case 156 -> {System.out.println("#"+compteur+"("+pc+"):"+"ifge");}
                case 157 -> {System.out.println("#"+compteur+"("+pc+"):"+"ifgt");}
                case 158 -> {System.out.println("#"+compteur+"("+pc+"):"+"ifle");}
                case 159 -> {System.out.println("#"+compteur+"("+pc+"):"+"if_icmpeq");}
                case 160 -> {System.out.println("#"+compteur+"("+pc+"):"+"if_icmpne");}
                case 161 -> {System.out.println("#"+compteur+"("+pc+"):"+"if_icmplt");}
                case 162 -> {System.out.println("#"+compteur+"("+pc+"):"+"if_icmpge");}
                case 163 -> {System.out.println("#"+compteur+"("+pc+"):"+"if_icmpgt");}
                case 164 -> {System.out.println("#"+compteur+"("+pc+"):"+"if_icmple");}
                case 165 -> {System.out.println("#"+compteur+"("+pc+"):"+"if_acmpeq");}
                case 166 -> {System.out.println("#"+compteur+"("+pc+"):"+"if_acmpne");}
                //controls
                case 167 -> {System.out.println("#"+compteur+"("+pc+"):"+"goto");}
                case 168 -> {System.out.println("#"+compteur+"("+pc+"):"+"jsr");}
                case 169 -> {System.out.println("#"+compteur+"("+pc+"):"+"ret");}
                case 170 -> {System.out.println("#"+compteur+"("+pc+"):"+"tableswitch");}
                case 171 -> {System.out.println("#"+compteur+"("+pc+"):"+"lookupswitch");}
                case 172 -> {System.out.println("#"+compteur+"("+pc+"):"+"ireturn");}
                case 173 -> {System.out.println("#"+compteur+"("+pc+"):"+"lreturn");}
                case 174 -> {System.out.println("#"+compteur+"("+pc+"):"+"freturn");}
                case 175 -> {System.out.println("#"+compteur+"("+pc+"):"+"dreturn");}
                case 176 -> {System.out.println("#"+compteur+"("+pc+"):"+"areturn");}
                case 177 -> {System.out.println("#"+compteur+"("+pc+"):"+"return");} 
                //references
                case 178 -> {System.out.println("#"+compteur+"("+pc+"):"+"getstatic");}
                case 179 -> {System.out.println("#"+compteur+"("+pc+"):"+"putstatic");}
                case 180 -> {System.out.println("#"+compteur+"("+pc+"):"+"getfield");}
                case 181 -> {System.out.println("#"+compteur+"("+pc+"):"+"putfield");}
                case 182 -> {System.out.println("#"+compteur+"("+pc+"):"+"invokevirtual");}
                case 183 -> {
                    System.out.println("#"+compteur+"("+pc+"):"+"invokespecial "+(code[(pc+1)]<<8+code[(pc+2)]));
                    pc=pc+2;
                }
                case 184 -> {System.out.println("#"+compteur+"("+pc+"):"+"invokestatic");}
                case 185 -> {System.out.println("#"+compteur+"("+pc+"):"+"invokeinterface");}
                case 186 -> {System.out.println("#"+compteur+"("+pc+"):"+"invokedynamic");}
                case 187 -> {System.out.println("#"+compteur+"("+pc+"):"+"new");}
                case 188 -> {System.out.println("#"+compteur+"("+pc+"):"+"newarray");}
                case 189 -> {System.out.println("#"+compteur+"("+pc+"):"+"anewarray");}
                case 190 -> {System.out.println("#"+compteur+"("+pc+"):"+"arraylength");}
                case 191 -> {System.out.println("#"+compteur+"("+pc+"):"+"athrow");}
                case 192 -> {System.out.println("#"+compteur+"("+pc+"):"+"checkcast");}
                case 193 -> {System.out.println("#"+compteur+"("+pc+"):"+"instanceof");}
                case 194 -> {System.out.println("#"+compteur+"("+pc+"):"+"monitorenter");}
                case 195 -> {System.out.println("#"+compteur+"("+pc+"):"+"monitorexit");}
                //extended
                case 196 -> {System.out.println("#"+compteur+"("+pc+"):"+"wide");}
                case 197 -> {System.out.println("#"+compteur+"("+pc+"):"+"multianewarray");}
                case 198 -> {System.out.println("#"+compteur+"("+pc+"):"+"ifnull");}
                case 199 -> {System.out.println("#"+compteur+"("+pc+"):"+"ifnonnull");}
                case 200 -> {System.out.println("#"+compteur+"("+pc+"):"+"goto_w");}
                case 201 -> {System.out.println("#"+compteur+"("+pc+"):"+"jsr_w");}
                //reserved
                case 202 -> {System.out.println("#"+compteur+"("+pc+"):"+"breakpoint");}
                case 254 -> {System.out.println("#"+compteur+"("+pc+"):"+"impdep1");}
                case 255 -> {System.out.println("#"+compteur+"("+pc+"):"+"impdep");}
                

              
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
