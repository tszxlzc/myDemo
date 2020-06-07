package com.union.util;

public class LongStr {

    final static char[] digits = {
            '0' , '1' , '2' , '3' , '4' , '5' ,
            '6' , '7' , '8' , '9' , 'a' , 'b' ,
            'c' , 'd' , 'e' , 'f' , 'g' , 'h' ,
            'i' , 'j' , 'k' , 'l' , 'm' , 'n' ,
            'o' , 'p' , 'q' , 'r' , 's' , 't' ,
            'u' , 'v' , 'w' , 'x' , 'y' , 'z'
    };
    public static void main(String[] args) {
         System.out.print(convert(128L));
    }

    private static String convert(long x){
        // assert shift > 0 && shift <=5 : "Illegal shift value";
        int mag = Long.SIZE - Long.numberOfLeadingZeros(x);
        int chars = Math.max(((mag + (4 - 1)) / 4), 1);
        char[] buf = new char[chars];

        formatUnsignedLong(x, 4, buf, 0, chars);
        return new String(buf);
    }

    private static int formatUnsignedLong(long val, int shift, char[] buf, int offset, int len){
        int charPos = len;
        int radix = 1 << shift;
        int mask = radix - 1;
        do {
            buf[offset + --charPos] = digits[((int) val) & mask];
            val >>>= shift;
        } while (val != 0 && charPos > 0);

        return charPos;
    }
}