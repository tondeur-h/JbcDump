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
                case 00 -> {System.out.println("#"+compteur+"("+pc+"):"+"nop");} //no parameters
                case 01 -> {System.out.println("#"+compteur+"("+pc+"):"+"aconst_null");} //no parameters
                case 02 -> {System.out.println("#"+compteur+"("+pc+"):"+"iconst_m1");} //no parameters
                case 03 -> {System.out.println("#"+compteur+"("+pc+"):"+"iconst_0");} //no parameters
                case 04 -> {System.out.println("#"+compteur+"("+pc+"):"+"iconst_1");} //no parameters
                case 05 -> {System.out.println("#"+compteur+"("+pc+"):"+"iconst_2");} //no parameters
                case 06 -> {System.out.println("#"+compteur+"("+pc+"):"+"iconst_3");} //no parameters
                case 07 -> {System.out.println("#"+compteur+"("+pc+"):"+"iconst_4");} //no parameters
                case 8 -> {System.out.println("#"+compteur+"("+pc+"):"+"iconst_5");} //no parameters
                case 9 -> {System.out.println("#"+compteur+"("+pc+"):"+"lconst_0");} //no parameters
                case 10 -> {System.out.println("#"+compteur+"("+pc+"):"+"lconst_1");} //no parameters
                case 11 -> {System.out.println("#"+compteur+"("+pc+"):"+"fconst_0");} //no parameters
                case 12 -> {System.out.println("#"+compteur+"("+pc+"):"+"fconst_1");} //no parameters
                case 13 -> {System.out.println("#"+compteur+"("+pc+"):"+"fconst_2");} //no parameters
                case 14 -> {System.out.println("#"+compteur+"("+pc+"):"+"dconst_0");} //no parameters
                case 15 -> {System.out.println("#"+compteur+"("+pc+"):"+"dconst_1");} //no parameters
                case 16 -> {System.out.println("#"+compteur+"("+pc+"):"+"bipush");}//TODO
                case 17 -> {System.out.println("#"+compteur+"("+pc+"):"+"sipush");}//TODO
                case 18 -> {System.out.println("#"+compteur+"("+pc+"):"+"ldc");}//TODO
                case 19 -> {System.out.println("#"+compteur+"("+pc+"):"+"ldc_w");}//TODO
                case 20 -> {System.out.println("#"+compteur+"("+pc+"):"+"ldc2_w");}//TODO
                //load
                case 21 -> {System.out.println("#"+compteur+"("+pc+"):"+"iload");}//TODO
                case 22 -> {System.out.println("#"+compteur+"("+pc+"):"+"lload");}//TODO
                case 23 -> {System.out.println("#"+compteur+"("+pc+"):"+"fload");}//TODO
                case 24 -> {System.out.println("#"+compteur+"("+pc+"):"+"dload");}//TODO
                case 25 -> {System.out.println("#"+compteur+"("+pc+"):"+"aload");}//TODO
                case 26 -> {System.out.println("#"+compteur+"("+pc+"):"+"iload_0");} //no parameters
                case 27 -> {System.out.println("#"+compteur+"("+pc+"):"+"iload_1");} //no parameters
                case 28 -> {System.out.println("#"+compteur+"("+pc+"):"+"iload_2");} //no parameters
                case 29 -> {System.out.println("#"+compteur+"("+pc+"):"+"iload_3");} //no parameters
                case 30 -> {System.out.println("#"+compteur+"("+pc+"):"+"lload_0");}//TODO
                case 31 -> {System.out.println("#"+compteur+"("+pc+"):"+"lload_1");}//TODO
                case 32 -> {System.out.println("#"+compteur+"("+pc+"):"+"lload_2");}//TODO
                case 33 -> {System.out.println("#"+compteur+"("+pc+"):"+"lload_3");}//TODO
                case 34 -> {System.out.println("#"+compteur+"("+pc+"):"+"fload_0");} //no parameters
                case 35 -> {System.out.println("#"+compteur+"("+pc+"):"+"fload_1");} //no parameters
                case 36 -> {System.out.println("#"+compteur+"("+pc+"):"+"fload_2");} //no parameters
                case 37 -> {System.out.println("#"+compteur+"("+pc+"):"+"fload_3");} //no parameters
                case 38 -> {System.out.println("#"+compteur+"("+pc+"):"+"dload_0");} //no parameters
                case 39 -> {System.out.println("#"+compteur+"("+pc+"):"+"dload_1");} //no parameters
                case 40 -> {System.out.println("#"+compteur+"("+pc+"):"+"dload_2");} //no parameters
                case 41 -> {System.out.println("#"+compteur+"("+pc+"):"+"dload_3");} //no parameters
                case 42 -> {System.out.println("#"+compteur+"("+pc+"):"+"aload_0");} //no parameters
                case 43 -> {System.out.println("#"+compteur+"("+pc+"):"+"aload_1");} //no parameters
                case 44 -> {System.out.println("#"+compteur+"("+pc+"):"+"aload_2");} //no parameters
                case 45 -> {System.out.println("#"+compteur+"("+pc+"):"+"aload_3");} //no parameters
                case 46 -> {System.out.println("#"+compteur+"("+pc+"):"+"iaload");} //no parameters
                case 47 -> {System.out.println("#"+compteur+"("+pc+"):"+"laload");} //no parameters
                case 48 -> {System.out.println("#"+compteur+"("+pc+"):"+"faload");} //no parameters
                case 49 -> {System.out.println("#"+compteur+"("+pc+"):"+"daload");} //no parameters
                case 50 -> {System.out.println("#"+compteur+"("+pc+"):"+"aaload");} //no parameters
                case 51 -> {System.out.println("#"+compteur+"("+pc+"):"+"baload");} //no parameters
                case 52 -> {System.out.println("#"+compteur+"("+pc+"):"+"caload");} //no parameters
                case 53 -> {System.out.println("#"+compteur+"("+pc+"):"+"saload");} //no parameters
                //store
                case 54 -> {System.out.println("#"+compteur+"("+pc+"):"+"istore");}//TODO
                case 55 -> {System.out.println("#"+compteur+"("+pc+"):"+"lstore");}//TODO
                case 56 -> {System.out.println("#"+compteur+"("+pc+"):"+"fstore");}//TODO
                case 57 -> {System.out.println("#"+compteur+"("+pc+"):"+"dstore");}//TODO
                case 58 -> {System.out.println("#"+compteur+"("+pc+"):"+"astore");}//TODO
                case 59 -> {System.out.println("#"+compteur+"("+pc+"):"+"istore_0");} //no parameters
                case 60 -> {System.out.println("#"+compteur+"("+pc+"):"+"istore_1");} //no parameters
                case 61 -> {System.out.println("#"+compteur+"("+pc+"):"+"istore_2");} //no parameters
                case 62 -> {System.out.println("#"+compteur+"("+pc+"):"+"istore_3");} //no parameters
                case 63 -> {System.out.println("#"+compteur+"("+pc+"):"+"lstore_0");} //no parameters
                case 64 -> {System.out.println("#"+compteur+"("+pc+"):"+"lstore_1");} //no parameters
                case 65 -> {System.out.println("#"+compteur+"("+pc+"):"+"lstore_2");} //no parameters
                case 66 -> {System.out.println("#"+compteur+"("+pc+"):"+"lstore_3");} //no parameters
                case 67 -> {System.out.println("#"+compteur+"("+pc+"):"+"fstore_0");} //no parameters
                case 68 -> {System.out.println("#"+compteur+"("+pc+"):"+"fstore_1");} //no parameters
                case 69 -> {System.out.println("#"+compteur+"("+pc+"):"+"fstore_2");} //no parameters
                case 70 -> {System.out.println("#"+compteur+"("+pc+"):"+"fstore_3");} //no parameters
                case 71 -> {System.out.println("#"+compteur+"("+pc+"):"+"dstore_0");} //no parameters
                case 72 -> {System.out.println("#"+compteur+"("+pc+"):"+"dstore_1");} //no parameters
                case 73 -> {System.out.println("#"+compteur+"("+pc+"):"+"dstore_2");} //no parameters
                case 74 -> {System.out.println("#"+compteur+"("+pc+"):"+"dstore_3");} //no parameters
                case 75 -> {System.out.println("#"+compteur+"("+pc+"):"+"astore_0");} //no parameters
                case 76 -> {System.out.println("#"+compteur+"("+pc+"):"+"astore_1");} //no parameters
                case 77 -> {System.out.println("#"+compteur+"("+pc+"):"+"astore_2");} //no parameters
                case 78 -> {System.out.println("#"+compteur+"("+pc+"):"+"astore_3");} //no parameters
                case 79 -> {System.out.println("#"+compteur+"("+pc+"):"+"iastore");} //no parameters
                case 80 -> {System.out.println("#"+compteur+"("+pc+"):"+"lastore");} //no parameters
                case 81 -> {System.out.println("#"+compteur+"("+pc+"):"+"fastore");} //no parameters
                case 82 -> {System.out.println("#"+compteur+"("+pc+"):"+"dastore");} //no parameters
                case 83 -> {System.out.println("#"+compteur+"("+pc+"):"+"aastore");} //no parameters
                case 84 -> {System.out.println("#"+compteur+"("+pc+"):"+"bastore");} //no parameters
                case 85 -> {System.out.println("#"+compteur+"("+pc+"):"+"castore");} //no parameters
                case 86 -> {System.out.println("#"+compteur+"("+pc+"):"+"sastore");} //no parameters
                //stack
                case 87 -> {System.out.println("#"+compteur+"("+pc+"):"+"pop");} //no parameters
                case 88 -> {System.out.println("#"+compteur+"("+pc+"):"+"pop2");} //no parameters
                case 89 -> {System.out.println("#"+compteur+"("+pc+"):"+"dup");} //no parameters
                case 90 -> {System.out.println("#"+compteur+"("+pc+"):"+"dup_x1");} //no parameters
                case 91 -> {System.out.println("#"+compteur+"("+pc+"):"+"dup_x2");} //no parameters
                case 92 -> {System.out.println("#"+compteur+"("+pc+"):"+"dup2");} //no parameters
                case 93 -> {System.out.println("#"+compteur+"("+pc+"):"+"dup2_x1");} //no parameters
                case 94 -> {System.out.println("#"+compteur+"("+pc+"):"+"dup2_x2");} //no parameters
                case 95 -> {System.out.println("#"+compteur+"("+pc+"):"+"swap");} //no parameters
                //Math
                case 96 -> {System.out.println("#"+compteur+"("+pc+"):"+"iadd");} //no parameters
                case 97 -> {System.out.println("#"+compteur+"("+pc+"):"+"ladd");} //no parameters
                case 98 -> {System.out.println("#"+compteur+"("+pc+"):"+"fadd");} //no parameters
                case 99 -> {System.out.println("#"+compteur+"("+pc+"):"+"dadd");} //no parameters
                case 100 -> {System.out.println("#"+compteur+"("+pc+"):"+"isub");} //no parameters
                case 101 -> {System.out.println("#"+compteur+"("+pc+"):"+"lsub");} //no parameters
                case 102 -> {System.out.println("#"+compteur+"("+pc+"):"+"fsub");} //no parameters
                case 103 -> {System.out.println("#"+compteur+"("+pc+"):"+"dsub");} //no parameters
                case 104 -> {System.out.println("#"+compteur+"("+pc+"):"+"imul");} //no parameters
                case 105 -> {System.out.println("#"+compteur+"("+pc+"):"+"lmul");} //no parameters
                case 106 -> {System.out.println("#"+compteur+"("+pc+"):"+"fmul");} //no parameters
                case 107 -> {System.out.println("#"+compteur+"("+pc+"):"+"dmul");} //no parameters
                case 108 -> {System.out.println("#"+compteur+"("+pc+"):"+"idiv");} //no parameters
                case 109 -> {System.out.println("#"+compteur+"("+pc+"):"+"ldiv");} //no parameters
                case 110 -> {System.out.println("#"+compteur+"("+pc+"):"+"fdiv");} //no parameters
                case 111 -> {System.out.println("#"+compteur+"("+pc+"):"+"ddiv");} //no parameters
                case 112 -> {System.out.println("#"+compteur+"("+pc+"):"+"irem");} //no parameters
                case 113 -> {System.out.println("#"+compteur+"("+pc+"):"+"lrem");} //no parameters
                case 114 -> {System.out.println("#"+compteur+"("+pc+"):"+"frem");} //no parameters
                case 115 -> {System.out.println("#"+compteur+"("+pc+"):"+"drem");} //no parameters
                case 116 -> {System.out.println("#"+compteur+"("+pc+"):"+"ineg");} //no parameters
                case 117 -> {System.out.println("#"+compteur+"("+pc+"):"+"lneg");} //no parameters
                case 118 -> {System.out.println("#"+compteur+"("+pc+"):"+"fneg");} //no parameters
                case 119 -> {System.out.println("#"+compteur+"("+pc+"):"+"dneg");} //no parameters
                case 120 -> {System.out.println("#"+compteur+"("+pc+"):"+"ishl");} //no parameters
                case 121 -> {System.out.println("#"+compteur+"("+pc+"):"+"lshl");} //no parameters
                case 122 -> {System.out.println("#"+compteur+"("+pc+"):"+"ishr");} //no parameters
                case 123 -> {System.out.println("#"+compteur+"("+pc+"):"+"lshr");} //no parameters
                case 124 -> {System.out.println("#"+compteur+"("+pc+"):"+"iushr");} //no parameters
                case 125 -> {System.out.println("#"+compteur+"("+pc+"):"+"lushr");} //no parameters
                case 126 -> {System.out.println("#"+compteur+"("+pc+"):"+"iand");} //no parameters
                case 127 -> {System.out.println("#"+compteur+"("+pc+"):"+"land");} //no parameters
                case 128 -> {System.out.println("#"+compteur+"("+pc+"):"+"ior");} //no parameters
                case 129 -> {System.out.println("#"+compteur+"("+pc+"):"+"lor");} //no parameters
                case 130 -> {System.out.println("#"+compteur+"("+pc+"):"+"ixor");} //no parameters
                case 131 -> {System.out.println("#"+compteur+"("+pc+"):"+"lxor");} //no parameters
                case 132 -> {System.out.println("#"+compteur+"("+pc+"):"+"iinc");}//TODO
                //conversions
                case 133 -> {System.out.println("#"+compteur+"("+pc+"):"+"i2l");} //no parameters
                case 134 -> {System.out.println("#"+compteur+"("+pc+"):"+"i2f");} //no parameters
                case 135 -> {System.out.println("#"+compteur+"("+pc+"):"+"i2d");} //no parameters
                case 136 -> {System.out.println("#"+compteur+"("+pc+"):"+"l2i");} //no parameters
                case 137 -> {System.out.println("#"+compteur+"("+pc+"):"+"l2f");} //no parameters
                case 138 -> {System.out.println("#"+compteur+"("+pc+"):"+"l2d");} //no parameters
                case 139 -> {System.out.println("#"+compteur+"("+pc+"):"+"f2i");} //no parameters
                case 140 -> {System.out.println("#"+compteur+"("+pc+"):"+"f2l");} //no parameters
                case 141 -> {System.out.println("#"+compteur+"("+pc+"):"+"f2d");} //no parameters
                case 142 -> {System.out.println("#"+compteur+"("+pc+"):"+"d2i");} //no parameters
                case 143 -> {System.out.println("#"+compteur+"("+pc+"):"+"d2l");} //no parameters
                case 144 -> {System.out.println("#"+compteur+"("+pc+"):"+"d2f");} //no parameters
                case 145 -> {System.out.println("#"+compteur+"("+pc+"):"+"i2b");} //no parameters
                case 146 -> {System.out.println("#"+compteur+"("+pc+"):"+"i2c");} //no parameters
                case 147 -> {System.out.println("#"+compteur+"("+pc+"):"+"i2s");} //no parameters
                //comparisons
                case 148 -> {System.out.println("#"+compteur+"("+pc+"):"+"lcmp");} //no parameters
                case 149 -> {System.out.println("#"+compteur+"("+pc+"):"+"fcmpl");} //no parameters
                case 150 -> {System.out.println("#"+compteur+"("+pc+"):"+"fcmpg");} //no parameters
                case 151 -> {System.out.println("#"+compteur+"("+pc+"):"+"dcmpl");} //no parameters
                case 152 -> {System.out.println("#"+compteur+"("+pc+"):"+"dcmpg");} //no parameters
                case 153 -> {System.out.println("#"+compteur+"("+pc+"):"+"ifeq");}//TODO
                case 154 -> {System.out.println("#"+compteur+"("+pc+"):"+"ifne");}//TODO
                case 155 -> {System.out.println("#"+compteur+"("+pc+"):"+"iflt");}//TODO
                case 156 -> {System.out.println("#"+compteur+"("+pc+"):"+"ifge");}//TODO
                case 157 -> {System.out.println("#"+compteur+"("+pc+"):"+"ifgt");}//TODO
                case 158 -> {System.out.println("#"+compteur+"("+pc+"):"+"ifle");}//TODO
                case 159 -> {System.out.println("#"+compteur+"("+pc+"):"+"if_icmpeq");}//TODO
                case 160 -> {System.out.println("#"+compteur+"("+pc+"):"+"if_icmpne");}//TODO
                case 161 -> {System.out.println("#"+compteur+"("+pc+"):"+"if_icmplt");}//TODO
                case 162 -> {System.out.println("#"+compteur+"("+pc+"):"+"if_icmpge");}//TODO
                case 163 -> {System.out.println("#"+compteur+"("+pc+"):"+"if_icmpgt");}//TODO
                case 164 -> {System.out.println("#"+compteur+"("+pc+"):"+"if_icmple");}//TODO
                case 165 -> {System.out.println("#"+compteur+"("+pc+"):"+"if_acmpeq");}//TODO
                case 166 -> {System.out.println("#"+compteur+"("+pc+"):"+"if_acmpne");}//TODO
                //controls
                case 167 -> {System.out.println("#"+compteur+"("+pc+"):"+"goto");}//TODO
                case 168 -> {System.out.println("#"+compteur+"("+pc+"):"+"jsr");}//TODO
                case 169 -> {System.out.println("#"+compteur+"("+pc+"):"+"ret");}//TODO
                case 170 -> {System.out.println("#"+compteur+"("+pc+"):"+"tableswitch");}//TODO
                case 171 -> {System.out.println("#"+compteur+"("+pc+"):"+"lookupswitch");}//TODO
                case 172 -> {System.out.println("#"+compteur+"("+pc+"):"+"ireturn");} //no parameters
                case 173 -> {System.out.println("#"+compteur+"("+pc+"):"+"lreturn");} //no parameters
                case 174 -> {System.out.println("#"+compteur+"("+pc+"):"+"freturn");} //no parameters
                case 175 -> {System.out.println("#"+compteur+"("+pc+"):"+"dreturn");} //no parameters
                case 176 -> {System.out.println("#"+compteur+"("+pc+"):"+"areturn");} //no parameters
                case 177 -> {System.out.println("#"+compteur+"("+pc+"):"+"return");}  //no parameters
                //references
                case 178 -> {System.out.println("#"+compteur+"("+pc+"):"+"getstatic");}//TODO
                case 179 -> {System.out.println("#"+compteur+"("+pc+"):"+"putstatic");}//TODO
                case 180 -> {System.out.println("#"+compteur+"("+pc+"):"+"getfield");}//TODO
                case 181 -> {System.out.println("#"+compteur+"("+pc+"):"+"putfield");}//TODO
                case 182 -> {System.out.println("#"+compteur+"("+pc+"):"+"invokevirtual");}//TODO
                case 183 -> {
                    System.out.println("#"+compteur+"("+pc+"):"+"invokespecial "+(code[(pc+1)]<<8+code[(pc+2)]));
                    pc=pc+2;
                }
                case 184 -> {System.out.println("#"+compteur+"("+pc+"):"+"invokestatic");}//TODO
                case 185 -> {System.out.println("#"+compteur+"("+pc+"):"+"invokeinterface");}//TODO
                case 186 -> {System.out.println("#"+compteur+"("+pc+"):"+"invokedynamic");}//TODO
                case 187 -> {System.out.println("#"+compteur+"("+pc+"):"+"new");}//TODO
                case 188 -> {System.out.println("#"+compteur+"("+pc+"):"+"newarray");}//TODO
                case 189 -> {System.out.println("#"+compteur+"("+pc+"):"+"anewarray");}//TODO
                case 190 -> {System.out.println("#"+compteur+"("+pc+"):"+"arraylength");} //no parameters
                case 191 -> {System.out.println("#"+compteur+"("+pc+"):"+"athrow");} //no parameters
                case 192 -> {System.out.println("#"+compteur+"("+pc+"):"+"checkcast");}//TODO
                case 193 -> {System.out.println("#"+compteur+"("+pc+"):"+"instanceof");}//TODO
                case 194 -> {System.out.println("#"+compteur+"("+pc+"):"+"monitorenter");} //no parameters
                case 195 -> {System.out.println("#"+compteur+"("+pc+"):"+"monitorexit");} //no parameters
                //extended
                case 196 -> {System.out.println("#"+compteur+"("+pc+"):"+"wide");}//TODO
                case 197 -> {System.out.println("#"+compteur+"("+pc+"):"+"multianewarray");}//TODO
                case 198 -> {System.out.println("#"+compteur+"("+pc+"):"+"ifnull");}//TODO
                case 199 -> {System.out.println("#"+compteur+"("+pc+"):"+"ifnonnull");}//TODO
                case 200 -> {System.out.println("#"+compteur+"("+pc+"):"+"goto_w");}//TODO
                case 201 -> {System.out.println("#"+compteur+"("+pc+"):"+"jsr_w");}//TODO
                //reserved
                case 202 -> {System.out.println("#"+compteur+"("+pc+"):"+"breakpoint");}//no parameters
                case 254 -> {System.out.println("#"+compteur+"("+pc+"):"+"impdep1");}//no parameters
                case 255 -> {System.out.println("#"+compteur+"("+pc+"):"+"impdep");}//no parameters
            }
                compteur++;
        }
    }
    
    /**************************
     * convertir byte1 to Integer
     * @param hexa
     * @return 
     **************************/
    public int Int(byte hexa) {return hexa & 0xFF;}
 
}
