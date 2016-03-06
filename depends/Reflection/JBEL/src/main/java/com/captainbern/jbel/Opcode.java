/*
 *  CaptainBern-Reflection-Framework contains several utils and tools
 *  to make Reflection easier.
 *  Copyright (C) 2014  CaptainBern
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.captainbern.jbel;

public interface Opcode
{

    int JBEL_1 = 1 << 1;

    int JAVA_MAGIC = 0xCAFEBABE;

    /**
     * JDK versions
     */
    int JDK_1_1 = 0x2D; // Starting from 45 -> 52
    int JDK_1_2 = 0x2E;
    int JDK_1_3 = 0x2F;
    int JDK_1_4 = 0x30;
    int JDK_5 = 0x31;
    int JDK_6 = 0x32;
    int JDK_7 = 0x33;
    int JDK_8 = 0x34;

    /**
     * Opcodes
     */
    int NOP = 0;
    int ACONST_NULL = 1;
    int ICONST_M1 = 2;
    int ICONST_0 = 3;
    int ICONST_1 = 4;
    int ICONST_2 = 5;
    int ICONST_3 = 6;
    int ICONST_4 = 7;
    int ICONST_5 = 8;
    int LCONST_0 = 9;
    int LCONST_1 = 10;
    int FCONST_0 = 11;
    int FCONST_1 = 12;
    int FCONST_2 = 13;
    int DCONST_0 = 14;
    int DCONST_1 = 15;
    int BIPUSH = 16;
    int SIPUSH = 17;
    int LDC = 18;
    int LDC_W = 19;
    int LDC2_W = 20;
    int ILOAD = 21;
    int LLOAD = 22;
    int FLOAD = 23;
    int DLOAD = 24;
    int ALOAD = 25;
    int ILOAD_0 = 26;
    int ILOAD_1 = 27;
    int ILOAD_2 = 28;
    int ILOAD_3 = 29;
    int LLOAD_0 = 30;
    int LLOAD_1 = 31;
    int LLOAD_2 = 32;
    int LLOAD_3 = 33;
    int FLOAD_0 = 34;
    int FLOAD_1 = 35;
    int FLOAD_2 = 36;
    int FLOAD_3 = 37;
    int DLOAD_0 = 38;
    int DLOAD_1 = 39;
    int DLOAD_2 = 40;
    int DLOAD_3 = 41;
    int ALOAD_0 = 42;
    int ALOAD_1 = 43;
    int ALOAD_2 = 44;
    int ALOAD_3 = 45;
    int IALOAD = 46;
    int LALOAD = 47;
    int FALOAD = 48;
    int DALOAD = 49;
    int AALOAD = 50;
    int BALOAD = 51;
    int CALOAD = 52;
    int SALOAD = 53;
    int ISTORE = 54;
    int LSTORE = 55;
    int FSTORE = 56;
    int DSTORE = 57;
    int ASTORE = 58;
    int ISTORE_0 = 59;
    int ISTORE_1 = 60;
    int ISTORE_2 = 61;
    int ISTORE_3 = 62;
    int LSTORE_0 = 63;
    int LSTORE_1 = 64;
    int LSTORE_2 = 65;
    int LSTORE_3 = 66;
    int FSTORE_0 = 67;
    int FSTORE_1 = 68;
    int FSTORE_2 = 69;
    int FSTORE_3 = 70;
    int DSTORE_0 = 71;
    int DSTORE_1 = 72;
    int DSTORE_2 = 73;
    int DSTORE_3 = 74;
    int ASTORE_0 = 75;
    int ASTORE_1 = 76;
    int ASTORE_2 = 77;
    int ASTORE_3 = 78;
    int IASTORE = 79;
    int LASTORE = 80;
    int FASTORE = 81;
    int DASTORE = 82;
    int AASTORE = 83;
    int BASTORE = 84;
    int CASTORE = 85;
    int SASTORE = 86;
    int POP = 87;
    int POP2 = 88;
    int DUP = 89;
    int DUP_X1 = 90;
    int DUP_X2 = 91;
    int DUP2 = 92;
    int DUP2_X1 = 93;
    int DUP2_X2 = 94;
    int SWAP = 95;
    int IADD = 96;
    int LADD = 97;
    int FADD = 98;
    int DADD = 99;
    int ISUB = 100;
    int LSUB = 101;
    int FSUB = 102;
    int DSUB = 103;
    int IMUL = 104;
    int LMUL = 105;
    int FMUL = 106;
    int DMUL = 107;
    int IDIV = 108;
    int LDIV = 109;
    int FDIV = 110;
    int DDIV = 111;
    int IREM = 112;
    int LREM = 113;
    int FREM = 114;
    int DREM = 115;
    int INEG = 116;
    int LNEG = 117;
    int FNEG = 118;
    int DNEG = 119;
    int ISHL = 120;
    int LSHL = 121;
    int ISHR = 122;
    int LSHR = 123;
    int IUSHR = 124;
    int LUSHR = 125;
    int IAND = 126;
    int LAND = 127;
    int IOR = 128;
    int LOR = 129;
    int IXOR = 130;
    int LXOR = 131;
    int IINC = 132;
    int I2L = 133;
    int I2F = 134;
    int I2D = 135;
    int L2I = 136;
    int L2F = 137;
    int L2D = 138;
    int F2I = 139;
    int F2L = 140;
    int F2D = 141;
    int D2I = 142;
    int D2L = 143;
    int D2F = 144;
    int I2B = 145;
    int I2C = 146;
    int I2S = 147;
    int LCMP = 148;
    int FCMPL = 149;
    int FCMPG = 150;
    int DCMPL = 151;
    int DCMPG = 152;
    int IFEQ = 153;
    int IFNE = 154;
    int IFLT = 155;
    int IFGE = 156;
    int IFGT = 157;
    int IFLE = 158;
    int IF_ICMPEQ = 159;
    int IF_ICMPNE = 160;
    int IF_ICMPLT = 161;
    int IF_ICMPGE = 162;
    int IF_ICMPGT = 163;
    int IF_ICMPLE = 164;
    int IF_ACMPEQ = 165;
    int IF_ACMPNE = 166;
    int GOTO = 167;
    int JSR = 168;
    int RET = 169;
    int TABLESWITCH = 170;
    int LOOKUPSWITCH = 171;
    int IRETURN = 172;
    int LRETURN = 173;
    int FRETURN = 174;
    int DRETURN = 175;
    int ARETURN = 176;
    int RETURN = 177;
    int GETSTATIC = 178;
    int PUTSTATIC = 179;
    int GETFIELD = 180;
    int PUTFIELD = 181;
    int INVOKEVIRTUAL = 182;
    int INVOKESPECIAL = 183;
    int INVOKESTATIC = 184;
    int INVOKEINTERFACE = 185;
    int INVOKEDYNAMIC = 186;
    int NEW = 187;
    int NEWARRAY = 188;
    int ANEWARRAY = 189;
    int ARRAYLENGTH = 190;
    int ATHROW = 191;
    int CHECKCAST = 192;
    int INSTANCEOF = 193;
    int MONITORENTER = 194;
    int MONITOREXIT = 195;
    int WIDE = 196;
    int MULTIANEWARRAY = 197;
    int IFNULL = 198;
    int IFNONNULL = 199;
    int GOTO_W = 200;
    int JSR_W = 201;

    //Implementation - specific opcodes
    int BREAKPOINT = 202;
    int IMPDEP1 = 254;
    int IMPDEP2 = 255;

    /**
     * Types (for the newarray instruction)
     */
    int T_BOOLEAN = 4;
    int T_CHAR = 5;
    int T_FLOAT = 6;
    int T_DOUBLE = 7;
    int T_BYTE = 8;
    int T_SHORT = 9;
    int T_INT = 10;
    int T_LONG = 11;
    byte T_VOID = 12;
    byte T_ARRAY = 13;
    byte T_OBJECT = 14;
    byte T_REFERENCE = 14; // Deprecated
    byte T_UNKNOWN = 15;
    byte T_ADDRESS = 16;

    /**
     * Constant tags
     */
    byte CONSTANT_Utf8 = 1;
    byte CONSTANT_Integer = 3;
    byte CONSTANT_Float = 4;
    byte CONSTANT_Long = 5;
    byte CONSTANT_Double = 6;
    byte CONSTANT_Class = 7;
    byte CONSTANT_String = 8;
    byte CONSTANT_Fieldref = 9;
    byte CONSTANT_Methodref = 10;
    byte CONSTANT_InterfaceMethodref = 11;
    byte CONSTANT_NameAndType = 12;
    byte CONSTANT_MethodHandle = 15;
    byte CONSTANT_MethodType = 16;
    byte CONSTANT_InvokeDynamic = 18;
    String[] CONSTANT_NAMES = {
            "", "CONSTANT_Utf8", "", "CONSTANT_Integer",
            "CONSTANT_Float", "CONSTANT_Double", "CONSTANT_Class",
            "CONSTANT_Class", "CONSTANT_String", "CONSTANT_Fieldref",
            "CONSTANT_Methodref", "CONSTANT_InterfaceMethodref",
            "CONSTANT_NameAndType", "", "", "CONSTANT_MethodHandle",
            "CONSTANT_MethodType", "", "CONSTANT_InvokeDynamic"};

    /**
     * Attribute tags
     */
    String ATTR_SOURCE_FILE = "SourceFile";
    String ATTR_SOURCE_DEBUG_EXTENSION = "SourceDebugExtension";
    String ATTR_CONSTANT_VALUE = "ConstantValue";
    String ATTR_CODE = "Code";
    String ATTR_EXCEPTIONS = "Exceptions";
    String ATTR_LINE_NUMBER_TABLE = "LineNumberTable";
    String ATTR_LOCAL_VARIABLE_TABLE = "LocalVariableTable";
    String ATTR_INNER_CLASSES = "InnerClasses";
    String ATTR_SYNTHETIC = "Synthetic";
    String ATTR_DEPRECATED = "Deprecated";
    String ATTR_SIGNATURE = "Signature";
    String ATTR_STACK_MAP = "StackMap";
    String ATTR_RUNTIME_VISIBLE_ANNOTATIONS = "RuntimeVisibleAnnotations";
    String ATTR_RUNTIME_INVISIBLE_ANNOTATIONS = "RuntimeInvisibleAnnotations";
    String ATTR_RUNTIME_VISIBLE_PARAMETER_ANNOTATIONS = "RuntimeVisibleParameterAnnotations";
    String ATTR_RUNTIME_INVISIBLE_PARAMETER_ANNOTATIONS = "RuntimeInvisibleParameterAnnotations";
    String ATTR_ANNOTATION_DEFAULT = "AnnotationDefault";
    String ATTR_LOCAL_VARIABLE_TYPE_TABLE = "LocalVariableTypeTable";
    String ATTR_ENCLOSING_METHOD = "EnclosingMethod";
    String ATTR_BOOTSTRAP_METHODS = "BootstrapMethods";
    String ATTR_STACK_MAP_TABLE = "StackMapTable";
    String ATTR_METHOD_PARAMETERS = "MethodParameters";

    /**
     * StackMap types
     *
     * @see <a href="http://docs.oracle.com/javase/specs/jvms/se7/html/jvms-4.html#jvms-4.7.4">StackMap</a>
     */
    byte ITEM_Top = 0;
    byte ITEM_Integer = 1;
    byte ITEM_Float = 2;
    byte ITEM_Double = 3;
    byte ITEM_Long = 4;
    byte ITEM_Null = 5;
    byte ITEM_UninitializedThis = 6;
    byte ITEM_Object = 7;
    byte ITEM_Uninitialized = 8;

    /**
     * Values to detect Frame growth
     *
     * @see <a href="http://docs.oracle.com/javase/specs/jvms/se7/html/jvms-4.html#jvms-4.7.4">StackMap</a>
     */
    int SAME_FRAME = 0;
    int SAME_FRAME_MAX = 63;

    int SAME_LOCALS_1_STACK_ITEM = 64;
    int SAME_LOCALS_1_STACK_ITEM_MAX = 127;

    int SAME_LOCALS_1_STACK_ITEM_EXTENDED = 247;

    int CHOP_FRAME = 248;
    int CHOP_FRAME_MAX = 250;

    int SAME_FRAME_EXTENDED = 251;

    int APPEND_FRAME = 252;
    int APPEND_FRAME_MAX = 254;

    int FULL_FRAME = 255;


    //For invokedynamic opcodes
    int H_GETFIELD = 1;
    int H_GETSTATIC = 2;
    int H_PUTFIELD = 3;
    int H_PUTSTATIC = 4;
    int H_INVOKEVIRTUAL = 5;
    int H_INVOKESTATIC = 6;
    int H_INVOKESPECIAL = 7;
    int H_NEWINVOKESPECIAL = 8;
    int H_INVOKEINTERFACE = 9;

    //Credit: Javaassist
    int[] STACK_GROWTH = {
            0, // nop, 0
            1, // aconst_null, 1
            1, // iconst_m1, 2
            1, // iconst_0, 3
            1, // iconst_1, 4
            1, // iconst_2, 5
            1, // iconst_3, 6
            1, // iconst_4, 7
            1, // iconst_5, 8
            2, // lconst_0, 9
            2, // lconst_1, 10
            1, // fconst_0, 11
            1, // fconst_1, 12
            1, // fconst_2, 13
            2, // dconst_0, 14
            2, // dconst_1, 15
            1, // bipush, 16
            1, // sipush, 17
            1, // ldc, 18
            1, // ldc_w, 19
            2, // ldc2_w, 20
            1, // iload, 21
            2, // lload, 22
            1, // fload, 23
            2, // dload, 24
            1, // aload, 25
            1, // iload_0, 26
            1, // iload_1, 27
            1, // iload_2, 28
            1, // iload_3, 29
            2, // lload_0, 30
            2, // lload_1, 31
            2, // lload_2, 32
            2, // lload_3, 33
            1, // fload_0, 34
            1, // fload_1, 35
            1, // fload_2, 36
            1, // fload_3, 37
            2, // dload_0, 38
            2, // dload_1, 39
            2, // dload_2, 40
            2, // dload_3, 41
            1, // aload_0, 42
            1, // aload_1, 43
            1, // aload_2, 44
            1, // aload_3, 45
            -1, // iaload, 46
            0, // laload, 47
            -1, // faload, 48
            0, // daload, 49
            -1, // aaload, 50
            -1, // baload, 51
            -1, // caload, 52
            -1, // saload, 53
            -1, // istore, 54
            -2, // lstore, 55
            -1, // fstore, 56
            -2, // dstore, 57
            -1, // astore, 58
            -1, // istore_0, 59
            -1, // istore_1, 60
            -1, // istore_2, 61
            -1, // istore_3, 62
            -2, // lstore_0, 63
            -2, // lstore_1, 64
            -2, // lstore_2, 65
            -2, // lstore_3, 66
            -1, // fstore_0, 67
            -1, // fstore_1, 68
            -1, // fstore_2, 69
            -1, // fstore_3, 70
            -2, // dstore_0, 71
            -2, // dstore_1, 72
            -2, // dstore_2, 73
            -2, // dstore_3, 74
            -1, // astore_0, 75
            -1, // astore_1, 76
            -1, // astore_2, 77
            -1, // astore_3, 78
            -3, // iastore, 79
            -4, // lastore, 80
            -3, // fastore, 81
            -4, // dastore, 82
            -3, // aastore, 83
            -3, // bastore, 84
            -3, // castore, 85
            -3, // sastore, 86
            -1, // pop, 87
            -2, // pop2, 88
            1, // dup, 89
            1, // dup_x1, 90
            1, // dup_x2, 91
            2, // dup2, 92
            2, // dup2_x1, 93
            2, // dup2_x2, 94
            0, // swap, 95
            -1, // iadd, 96
            -2, // ladd, 97
            -1, // fadd, 98
            -2, // dadd, 99
            -1, // isub, 100
            -2, // lsub, 101
            -1, // fsub, 102
            -2, // dsub, 103
            -1, // imul, 104
            -2, // lmul, 105
            -1, // fmul, 106
            -2, // dmul, 107
            -1, // idiv, 108
            -2, // ldiv, 109
            -1, // fdiv, 110
            -2, // ddiv, 111
            -1, // irem, 112
            -2, // lrem, 113
            -1, // frem, 114
            -2, // drem, 115
            0, // ineg, 116
            0, // lneg, 117
            0, // fneg, 118
            0, // dneg, 119
            -1, // ishl, 120
            -1, // lshl, 121
            -1, // ishr, 122
            -1, // lshr, 123
            -1, // iushr, 124
            -1, // lushr, 125
            -1, // iand, 126
            -2, // land, 127
            -1, // ior, 128
            -2, // lor, 129
            -1, // ixor, 130
            -2, // lxor, 131
            0, // iinc, 132
            1, // i2l, 133
            0, // i2f, 134
            1, // i2d, 135
            -1, // l2i, 136
            -1, // l2f, 137
            0, // l2d, 138
            0, // f2i, 139
            1, // f2l, 140
            1, // f2d, 141
            -1, // d2i, 142
            0, // d2l, 143
            -1, // d2f, 144
            0, // i2b, 145
            0, // i2c, 146
            0, // i2s, 147
            -3, // lcmp, 148
            -1, // fcmpl, 149
            -1, // fcmpg, 150
            -3, // dcmpl, 151
            -3, // dcmpg, 152
            -1, // ifeq, 153
            -1, // ifne, 154
            -1, // iflt, 155
            -1, // ifge, 156
            -1, // ifgt, 157
            -1, // ifle, 158
            -2, // if_icmpeq, 159
            -2, // if_icmpne, 160
            -2, // if_icmplt, 161
            -2, // if_icmpge, 162
            -2, // if_icmpgt, 163
            -2, // if_icmple, 164
            -2, // if_acmpeq, 165
            -2, // if_acmpne, 166
            0, // goto, 167
            1, // jsr, 168
            0, // ret, 169
            -1, // tableswitch, 170
            -1, // lookupswitch, 171
            -1, // ireturn, 172
            -2, // lreturn, 173
            -1, // freturn, 174
            -2, // dreturn, 175
            -1, // areturn, 176
            0, // return, 177
            0, // getstatic, 178            depends on the type
            0, // putstatic, 179            depends on the type
            0, // getfield, 180             depends on the type
            0, // putfield, 181             depends on the type
            0, // invokevirtual, 182        depends on the type
            0, // invokespecial, 183        depends on the type
            0, // invokestatic, 184         depends on the type
            0, // invokeinterface, 185      depends on the type
            0, // invokedynamic, 186        depends on the type
            1, // new, 187
            0, // newarray, 188
            0, // anewarray, 189
            0, // arraylength, 190
            -1, // athrow, 191              stack is cleared
            0, // checkcast, 192
            0, // instanceof, 193
            -1, // monitorenter, 194
            -1, // monitorexit, 195
            0, // wide, 196                 depends on the following opcode
            0, // multianewarray, 197       depends on the dimensions
            -1, // ifnull, 198
            -1, // ifnonnull, 199
            0, // goto_w, 200
            1 // jsr_w, 201
    };
}