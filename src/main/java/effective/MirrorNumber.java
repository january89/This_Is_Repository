package effective;

import static java.lang.System.out;

public class MirrorNumber{

    public static void main(String[] args) {

        int i = 11;

        while(true){

            if( String.valueOf(i).equals(ReverseInteger(i))
                    && Integer.toBinaryString(i).equals(ReverseInteger(Integer.toBinaryString(i)))
                    && Integer.toOctalString(i).equals(ReverseInteger(Integer.toOctalString(i))) ) break;

            i += 2;

        }

        out.println(i);

    }

    private static String ReverseInteger(int i){
        return new StringBuffer(String.valueOf(i)).reverse().toString();
    }
    private static String ReverseInteger(String i){
        return new StringBuffer(i).reverse().toString();
    }

}