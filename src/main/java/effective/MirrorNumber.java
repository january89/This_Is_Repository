package effective;

import static java.lang.System.out;

public class MirrorNumber{

    public static void main(String[] args) {

        long i = 11l;

        while(true){

            if( String.valueOf(i).equals((new StringBuffer(String.valueOf(i)).reverse()).toString())
                    && Long.toBinaryString(i).equals((new StringBuffer(Long.toBinaryString(i)).reverse()).toString())
                    && Long.toOctalString(i).equals((new StringBuffer(Long.toOctalString(i)).reverse()).toString()) ) break;

            i += 2;
        }

        out.println(i);

    }

}
