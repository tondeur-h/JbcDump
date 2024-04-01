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
package org.tondeurh.fr.jbcdump;

import org.tondeurh.fr.jbcdump.containers.CP_info;
import org.tondeurh.fr.jbcdump.containers.ClassFile;
import org.tondeurh.fr.jbcdump.containers.constants.CONSTANT_Class_info;
import org.tondeurh.fr.jbcdump.containers.constants.CONSTANT_Double_info;
import org.tondeurh.fr.jbcdump.containers.constants.CONSTANT_Dynamic_info;
import org.tondeurh.fr.jbcdump.containers.constants.CONSTANT_Fieldref_info;
import org.tondeurh.fr.jbcdump.containers.constants.CONSTANT_Float_info;
import org.tondeurh.fr.jbcdump.containers.constants.CONSTANT_Integer_info;
import org.tondeurh.fr.jbcdump.containers.constants.CONSTANT_InterfaceMethodref_info;
import org.tondeurh.fr.jbcdump.containers.constants.CONSTANT_InvokeDynamic_info;
import org.tondeurh.fr.jbcdump.containers.constants.CONSTANT_Long_info;
import org.tondeurh.fr.jbcdump.containers.constants.CONSTANT_MethodHandle_info;
import org.tondeurh.fr.jbcdump.containers.constants.CONSTANT_MethodType_info;
import org.tondeurh.fr.jbcdump.containers.constants.CONSTANT_Methodref_info;
import org.tondeurh.fr.jbcdump.containers.constants.CONSTANT_Module_info;
import org.tondeurh.fr.jbcdump.containers.constants.CONSTANT_NameAndType_info;
import org.tondeurh.fr.jbcdump.containers.constants.CONSTANT_Package_info;
import org.tondeurh.fr.jbcdump.containers.constants.CONSTANT_String_info;
import org.tondeurh.fr.jbcdump.containers.constants.CONSTANT_Utf8_info;
import org.tondeurh.fr.jbcdump.tools.Tools;

/**
 *
 * @author herve
 */
public class ConstantPool {
ClassFile classFile;
Tools t;
    
    /**
     *CONSTRUCTEUR
     * @param classFile
     * @param t
     */
    public ConstantPool(ClassFile classFile,Tools t) { 
        this.classFile=classFile;
        this.t=t;
    }

    /***************************
     * Lire la table constant pool
     ***************************/
    public void constant_pool_read() {
          
    for (int count_pool=0;count_pool<t.Int(classFile.getConstant_pool_count())-1;count_pool++)
    {
        //alloc array constant_pool object
        CP_info cp_info=new CP_info(); 
        //lire le tag
        cp_info.setTag(t.getNextBytes(cp_info.tag_size));
        cp_info.setItag(t.Int(cp_info.getTag()));
        switch(cp_info.getItag())
        {
            case 7 -> {
                cp_info.setConstant_name("CONSTANT_Class");//afecter le type de cp_info
                cp_info.setContainer(call_constant(cp_info.getItag()));//affecter l'objet
                }
            case 9 -> {
                cp_info.setConstant_name("CONSTANT_Fieldref");//afecter le type de cp_info
                cp_info.setContainer(call_constant(cp_info.getItag()));//affecter l'objet
                }
            case 10 -> {
                cp_info.setConstant_name("CONSTANT_Methodref");//afecter le type de cp_info
                cp_info.setContainer(call_constant(cp_info.getItag()));//affecter l'objet
                }
            case 11 -> {
                cp_info.setConstant_name("CONSTANT_InterfaceMethodref");//afecter le type de cp_info
                cp_info.setContainer(call_constant(cp_info.getItag()));//affecter l'objet
                }
            case 8 -> {
                cp_info.setConstant_name("CONSTANT_String");//afecter le type de cp_info
                cp_info.setContainer(call_constant(cp_info.getItag()));//affecter l'objet
                }
            case 3 -> {
                cp_info.setConstant_name("CONSTANT_tools.Integer");//afecter le type de cp_info
                cp_info.setContainer(call_constant(cp_info.getItag()));//affecter l'objet
                }
            case 4 -> {
                cp_info.setConstant_name("CONSTANT_Float");//afecter le type de cp_info
                cp_info.setContainer(call_constant(cp_info.getItag()));//affecter l'objet
                }
            case 5 -> {
                cp_info.setConstant_name("CONSTANT_Long");//afecter le type de cp_info
                cp_info.setContainer(call_constant(cp_info.getItag()));//affecter l'objet
                }
            case 6 -> {
                cp_info.setConstant_name("CONSTANT_Double");//afecter le type de cp_info
                cp_info.setContainer(call_constant(cp_info.getItag()));//affecter l'objet
                }
            case 12 -> {
                cp_info.setConstant_name("CONSTANT_NameAndType");//afecter le type de cp_info
                cp_info.setContainer(call_constant(cp_info.getItag()));//affecter l'objet
                }
            case 1 -> {
                cp_info.setConstant_name("CONSTANT_Utf8");//afecter le type de cp_info
                cp_info.setContainer(call_constant(cp_info.getItag()));//affecter l'objet
                }
            case 15 -> {
                cp_info.setConstant_name("CONSTANT_MethodHandle");//afecter le type de cp_info
                cp_info.setContainer(call_constant(cp_info.getItag()));//affecter l'objet
                }
            case 16 -> {
                cp_info.setConstant_name("CONSTANT_MethodType");//afecter le type de cp_info
                cp_info.setContainer(call_constant(cp_info.getItag()));//affecter l'objet
                }
            case 17 -> {
                cp_info.setConstant_name("CONSTANT_Dynamic");//afecter le type de cp_info
                cp_info.setContainer(call_constant(cp_info.getItag()));//affecter l'objet
                }
            case 18 -> {
                cp_info.setConstant_name("CONSTANT_InvokeDynamic");//afecter le type de cp_info
                cp_info.setContainer(call_constant(cp_info.getItag()));//affecter l'objet
                }
            case 19 -> {
                cp_info.setConstant_name("CONSTANT_Module");//afecter le type de cp_info
                cp_info.setContainer(call_constant(cp_info.getItag()));//affecter l'objet
                }
            case 20 -> {
                cp_info.setConstant_name("CONSTANT_Package");//afecter le type de cp_info
                cp_info.setContainer(call_constant(cp_info.getItag()));//affecter l'objet
                }
        }

        classFile.getConstant_pool().add(cp_info);
    } //fin for
    }

    /******************************
     * Read String constant pool
     * from typecp
     * @param typecp
     * @return 
     ******************************/
    private Object call_constant(int typecp) {
    //String result="";
    
        switch (typecp)
        {
            case 7->{ //CONSTANT_Class_info {u2 name_index;}
                        CONSTANT_Class_info cci=new CONSTANT_Class_info();
                        cci.setName_index(t.getNextBytes(2));
                        cci.setIname_index(t.Int(cci.getName_index()));
                        return cci;
                    }      
            case 1->{ //CONSTANT_Utf8_info {u2 length;u1 bytes[length];}
                        CONSTANT_Utf8_info cci=new CONSTANT_Utf8_info();
                        //recup length
                        cci.setLength(t.getNextBytes(cci.length_size));
                        cci.setIlength(t.Int(cci.getLength()));
                        //recup String
                        cci.setBytesString(t.getNextBytes(cci.getIlength()));
                        cci.setSbytesString(t.Str(cci.getBytesString()));
                        return cci;
                    }  
            case 10->{ //CONSTANT_Methodref_info {u2 class_index;u2 name_and_type_index;}
                        CONSTANT_Methodref_info cci=new CONSTANT_Methodref_info();
                        cci.setClass_index(t.getNextBytes(cci.class_index_size));
                        cci.setIclass_index(t.Int(cci.getClass_index()));
                        cci.setName_and_type_index(t.getNextBytes(cci.name_and_type_index_size));
                        cci.setIname_and_type_index(t.Int(cci.getName_and_type_index()));
                        return cci;
                    } 
            case 12->{ //CONSTANT_NameAndType_info {u2 name_index;u2 descriptor_index;}
                        CONSTANT_NameAndType_info cci=new CONSTANT_NameAndType_info();
                        cci.setName_index(t.getNextBytes(cci.name_index_size));
                        cci.setIname_index(t.Int(cci.getName_index()));
                        cci.setDescriptor_index(t.getNextBytes(cci.descriptor_index_size));
                        cci.setIdescriptor_index(t.Int(cci.getDescriptor_index()));
                        return cci;
                    } 
            case 9->{ //CONSTANT_Fieldref_info {u2 class_index;u2 name_and_type_index;}
                        CONSTANT_Fieldref_info cci=new CONSTANT_Fieldref_info();
                        cci.setClass_index(t.getNextBytes(cci.class_index_size));
                        cci.setIclass_index(t.Int(cci.getClass_index()));
                        cci.setName_and_type_index(t.getNextBytes(cci.name_and_type_index_size));
                        cci.setIname_and_type_index(t.Int(cci.getName_and_type_index()));
                        return cci;
                    } 
            case 11->{ //CONSTANT_InterfaceMethodref_info {u2 class_index;u2 name_and_type_index;}
                        CONSTANT_InterfaceMethodref_info cci=new CONSTANT_InterfaceMethodref_info();
                        cci.setClass_index(t.getNextBytes(cci.class_index_size));
                        cci.setIclass_index(t.Int(cci.getClass_index()));
                        cci.setName_and_type_index(t.getNextBytes(cci.name_and_type_index_size));
                        cci.setIname_and_type_index(t.Int(cci.getName_and_type_index()));
                        return cci;
                    } 
            case 8->{ //CONSTANT_String_info {u2 string_index;}
                        CONSTANT_String_info cci=new CONSTANT_String_info();
                        cci.setString_index(t.getNextBytes(cci.string_index_size));
                        cci.setIstring_index(t.Int(cci.getString_index()));
                        return cci;
                    } 
            case 3->{ //CONSTANT_Integer_info {u4 bytes;}
                        CONSTANT_Integer_info cci=new CONSTANT_Integer_info();
                        cci.setBytes(t.getNextBytes(cci.bytes_size));
                        cci.setIbytes(t.Int(cci.getBytes()));
                        return cci;
                    } 
            case 4->{ //CONSTANT_Float_info {u4 bytes;}
                        CONSTANT_Float_info cci=new CONSTANT_Float_info();
                        cci.setBytes(t.getNextBytes(cci.bytes_size));
                        cci.setIbytes(t.Int(cci.getBytes()));
                        return cci;
                    }
            case 5->{ //CONSTANT_Long_info {u4 high_bytes;u4 low_bytes;}
                        CONSTANT_Long_info cci=new CONSTANT_Long_info();
                        cci.setHigh_bytes(t.getNextBytes(cci.high_bytes_size));
                        cci.setIhigh_bytes(t.Int(cci.getHigh_bytes()));
                        cci.setLow_bytes(t.getNextBytes(cci.low_bytes_size));
                        cci.setIlow_bytes(t.Int(cci.getLow_bytes()));
                        return cci;
                    }
            case 6->{ //CONSTANT_Double_info {u4 high_bytes;u4 low_bytes;}
                        CONSTANT_Double_info cci=new CONSTANT_Double_info();
                        cci.setHigh_bytes(t.getNextBytes(cci.high_bytes_size));
                        cci.setIhigh_bytes(t.Int(cci.getHigh_bytes()));
                        cci.setLow_bytes(t.getNextBytes(cci.low_bytes_size));
                        cci.setIlow_bytes(t.Int(cci.getLow_bytes()));
                        return cci;
                    }
            case 15->{ //CONSTANT_MethodHandle_info {u1 reference_kind;u2 reference_index;}
                        CONSTANT_MethodHandle_info cci=new CONSTANT_MethodHandle_info();
                        cci.setReference_kind(t.getNextBytes(cci.reference_kind_size));
                        cci.setIreference_kind(t.Int(cci.getReference_kind()));
                        cci.setReference_index(t.getNextBytes(cci.reference_index_size));
                        cci.setIreference_index(t.Int(cci.getReference_index()));
                        return cci;
                    }
            case 16->{ //CONSTANT_MethodType_info {u2 descriptor_index;}
                        CONSTANT_MethodType_info cci=new CONSTANT_MethodType_info();
                        cci.setDescriptor_index(t.getNextBytes(cci.descriptor_index_size));
                        cci.setIdescriptor_index(t.Int(cci.getDescriptor_index()));
                        return cci;
                    }
            case 17->{ //CONSTANT_Dynamic_info {u2 bootstrap_method_attr_index;u2 name_and_type_index;}
                        CONSTANT_Dynamic_info cci=new CONSTANT_Dynamic_info();
                        cci.setBootstrap_method_attr_index(t.getNextBytes(cci.bootstrap_method_attr_index_size));
                        cci.setIbootstrap_method_attr_index(t.Int(cci.getBootstrap_method_attr_index()));
                        cci.setName_and_type_index(t.getNextBytes(cci.name_and_type_index_size));
                        cci.setIname_and_type_index(t.Int(cci.getName_and_type_index()));
                        return cci;
                    }
            case 18->{ //CONSTANT_InvokeDynamic_info {u2 bootstrap_method_attr_index;u2 name_and_type_index;}
                        CONSTANT_InvokeDynamic_info cci=new CONSTANT_InvokeDynamic_info();
                        cci.setBootstrap_method_attr_index(t.getNextBytes(cci.bootstrap_method_attr_index_size));
                        cci.setIbootstrap_method_attr_index(t.Int(cci.getBootstrap_method_attr_index()));
                        cci.setName_and_type_index(t.getNextBytes(cci.name_and_type_index_size));
                        cci.setIname_and_type_index(t.Int(cci.getName_and_type_index()));
                        return cci;
                    }
            case 19->{ //CONSTANT_Module_info {u2 name_index;}
                        CONSTANT_Module_info cci=new CONSTANT_Module_info();
                        cci.setName_index(t.getNextBytes(cci.name_index_size));
                        cci.setIname_index(t.Int(cci.getName_index()));
                        return cci;
                    }
            case 20->{ //CONSTANT_Package_info {u2 name_index;}
                        CONSTANT_Package_info cci=new CONSTANT_Package_info();
                        cci.setName_index(t.getNextBytes(cci.name_index_size));
                        cci.setIname_index(t.Int(cci.getName_index()));
                        return cci;
                    }

        }
        
        return "vide";
    }

    /*
constant_name               tag classe
CONSTANT_Utf8               1   CONSTANT_Utf8_info {u2 length;u1 bytes[length];}
CONSTANT_Integer            3   CONSTANT_Integer_info {u4 bytes;}
CONSTANT_Float              4   CONSTANT_Float_info {u4 bytes;}
CONSTANT_Long               5   CONSTANT_Long_info {u4 high_bytes;u4 low_bytes;}
CONSTANT_Double             6   CONSTANT_Double_info {u4 high_bytes;u4 low_bytes;}
CONSTANT_Class              7   CONSTANT_Class_info {u2 name_index;}
CONSTANT_String             8   CONSTANT_String_info {u2 string_index;}
CONSTANT_Fieldref           9   CONSTANT_Fieldref_info {u2 class_index;u2 name_and_type_index;} 
CONSTANT_Methodref          10  CONSTANT_Methodref_info {u2 class_index;u2 name_and_type_index;}
CONSTANT_InterfaceMethodref 11  CONSTANT_InterfaceMethodref_info {u2 class_index;u2 name_and_type_index;}
CONSTANT_NameAndType        12  CONSTANT_NameAndType_info {u2 name_index;u2 descriptor_index;}
CONSTANT_MethodHandle       15  CONSTANT_MethodHandle_info {u1 reference_kind;u2 reference_index;}
CONSTANT_MethodType         16  CONSTANT_MethodType_info {u2 descriptor_index;}
CONSTANT_Dynamic            17  CONSTANT_Dynamic_info {u2 bootstrap_method_attr_index;u2 name_and_type_index;}
CONSTANT_InvokeDynamic      18  CONSTANT_InvokeDynamic_info {u2 bootstrap_method_attr_index;u2 name_and_type_index;}
CONSTANT_Module             19  CONSTANT_Module_info {u2 name_index;}
CONSTANT_Package            20  CONSTANT_Package_info {u2 name_index;}
*/
   /*****************
    * Print constant pool
    *****************/
    public void constant_pool_print() {
        int compteur=1;
        boolean DEBUG=false;
        for (CP_info cp_info:classFile.getConstant_pool())
        {
            //afficher le niveau cp_info
            if (DEBUG) System.out.print(" tag type : "+cp_info.getItag()+" ");
            System.out.print("#"+compteur+"("+cp_info.getConstant_name()+") : ");
            
            //afficher le contenu selon le type d'objet.
            //Classes
            if (cp_info.getContainer() instanceof CONSTANT_Class_info c)
            {
               System.out.println("#"+c.getIname_index()+" ["+resolve_constant_pool(c.getIname_index())+"]");
            }
            //Type Double Value
            if (cp_info.getContainer() instanceof CONSTANT_Double_info c)
            {
               System.out.println("#"+c.getIhigh_bytes()+"."+c.getIlow_bytes()); 
            }
            //type Dynamic
            if (cp_info.getContainer() instanceof CONSTANT_Dynamic_info c)
            {
               System.out.println("#"+c.getIbootstrap_method_attr_index()+"."+
                       "#"+c.getIname_and_type_index()+
                       " ["+resolve_constant_pool(c.getIbootstrap_method_attr_index())+" "+
                       resolve_constant_pool(c.getIname_and_type_index())+"]");   
            }
            //réference de champs
            if (cp_info.getContainer() instanceof CONSTANT_Fieldref_info c)
            {
                System.out.println("#"+c.getIclass_index()+"."+
                        "#"+c.getIname_and_type_index()+
                " ["+resolve_constant_pool(c.getIclass_index())+" "+
                       resolve_constant_pool(c.getIname_and_type_index())+"]");
            }
            //constante de valeur
            if (cp_info.getContainer() instanceof CONSTANT_Float_info c)
            {
               System.out.println("#"+c.getIbytes()); 
            }
            //constante de valeur
            if (cp_info.getContainer() instanceof CONSTANT_Integer_info c)
            {
               System.out.println("#"+c.getIbytes()); 
            }
            //interface et Methode
            if (cp_info.getContainer() instanceof CONSTANT_InterfaceMethodref_info c)
            {
               System.out.println("#"+c.getIclass_index()+"."+"#"+c.getIname_and_type_index()+
                " ["+resolve_constant_pool(c.getIclass_index())+" "+
                       resolve_constant_pool(c.getIname_and_type_index())+"]");
            }
            //Invoke Dynamic
            if (cp_info.getContainer() instanceof CONSTANT_InvokeDynamic_info c)
            {
               System.out.println("#"+c.getIbootstrap_method_attr_index()+"."+
                       "#"+c.getIname_and_type_index()+
                       " ["+resolve_constant_pool(c.getIbootstrap_method_attr_index())+" "+
                       resolve_constant_pool(c.getIname_and_type_index())+"]");
            }
            //constante de valeur
            if (cp_info.getContainer() instanceof CONSTANT_Long_info c)
            {
               System.out.println("#"+c.getIhigh_bytes()+"."+c.getIlow_bytes());                 
            }
            //Method Handle
            if (cp_info.getContainer() instanceof CONSTANT_MethodHandle_info c)
            {
               System.out.println("#"+c.getIreference_kind()+"."+"#"+c.getIreference_index()+
                       " ["+resolve_constant_pool(c.getIreference_kind())+" "+
                       resolve_constant_pool(c.getIreference_index())+"]");
            }
            //MethodType
            if (cp_info.getContainer() instanceof CONSTANT_MethodType_info c)
            {
               System.out.println("#"+c.getIdescriptor_index()+
               " ["+resolve_constant_pool(c.getIdescriptor_index())+"]"); 
            }
            //Method Ref
            if (cp_info.getContainer() instanceof CONSTANT_Methodref_info c)
            {
               System.out.println("#"+c.getIclass_index()+"."+
                       "#"+c.getIname_and_type_index()+
                " ["+resolve_constant_pool(c.getIclass_index())+" "+
                       resolve_constant_pool(c.getIname_and_type_index())+"]"); 
            }
            //Module 
            if (cp_info.getContainer() instanceof CONSTANT_Module_info c)
            {
                System.out.println("#"+c.getIname_index()+
                        " ["+resolve_constant_pool(c.getIname_index())+"]");
            }
            //Name and Type
            if (cp_info.getContainer() instanceof CONSTANT_NameAndType_info c)
            {
                System.out.println("#"+c.getIname_index()+"."+
                        "#"+c.getIdescriptor_index()+
                        " ["+resolve_constant_pool(c.getIname_index())+" "+
                       resolve_constant_pool(c.getIdescriptor_index())+"]");
            }
            //package
            if (cp_info.getContainer() instanceof CONSTANT_Package_info c)
            {
                System.out.println("#"+c.getIname_index()+
                        " ["+resolve_constant_pool(c.getIname_index())+"]");
            }
            //String
            if (cp_info.getContainer() instanceof CONSTANT_String_info c)
            {
                System.out.println("#"+c.getIstring_index()+" ["+resolve_constant_pool(c.getIstring_index())+"]");
            }
            //Terminaux Utf8
            if (cp_info.getContainer() instanceof CONSTANT_Utf8_info c)
            {   
                System.out.println(c.getSbytesString());
            }
           compteur++; 
        }
    }
   
    /********************************
     * Recuperer la valeur texte de
     * l'index du constant pool
     * @param index
     * @return
     ********************************/
    public String resolve_constant_pool(int index){
        CP_info cpi=classFile.getConstant_pool().get(index-1);
                    //recuperer la chaine
            if (cpi.getContainer() instanceof CONSTANT_Class_info c)
            {resolve_constant_pool(c.getIname_index());}
            if (cpi.getContainer() instanceof CONSTANT_Double_info)
            {return "";}
            if (cpi.getContainer() instanceof CONSTANT_Dynamic_info c)
            {resolve_constant_pool(c.getIname_and_type_index());}
            if (cpi.getContainer() instanceof CONSTANT_Fieldref_info c)
            {resolve_constant_pool(c.getIclass_index());}
            if (cpi.getContainer() instanceof CONSTANT_Float_info)
            {return "";}
            if (cpi.getContainer() instanceof CONSTANT_Integer_info)
            {return "";}
            if (cpi.getContainer() instanceof CONSTANT_InterfaceMethodref_info c)
            {resolve_constant_pool(c.getIclass_index());}
            if (cpi.getContainer() instanceof CONSTANT_InvokeDynamic_info c)
            {resolve_constant_pool(c.getIbootstrap_method_attr_index());}
            if (cpi.getContainer() instanceof CONSTANT_Long_info)
            {return "";}
            if (cpi.getContainer() instanceof CONSTANT_MethodHandle_info c)
            {resolve_constant_pool(c.getIreference_index());}
            if (cpi.getContainer() instanceof CONSTANT_MethodType_info c)
            {resolve_constant_pool(c.getIdescriptor_index());}
            if (cpi.getContainer() instanceof CONSTANT_Methodref_info c)
            {resolve_constant_pool(c.getIclass_index());}
            if (cpi.getContainer() instanceof CONSTANT_Module_info c)
            {resolve_constant_pool(c.getIname_index());}
            if (cpi.getContainer() instanceof CONSTANT_NameAndType_info c)
            {resolve_constant_pool(c.getIname_index());}
            if (cpi.getContainer() instanceof CONSTANT_Package_info c)
            {resolve_constant_pool(c.getIname_index());}
            if (cpi.getContainer() instanceof CONSTANT_String_info c)
            {resolve_constant_pool(c.getIstring_index());}
            
            if (cpi.getContainer() instanceof CONSTANT_Utf8_info c)
            {
        //si aucun cas ci dessus alors c'est un terminal
        return ((CONSTANT_Utf8_info)cpi.getContainer()).getSbytesString();
            }
            return cpi.getConstant_name();
    }
    
}
