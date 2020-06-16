import java.util.Scanner;

public class shixianzifutongpeifu {
    public static void main(String[] args) {
        String type=getString();
        String str=getString();
        char[] shuruStr=str.toCharArray();
        String[] strings=type.split("\\*");
        if (strings.length==1){
            char[] chars=strings[0].toCharArray();
            for (int i=0;i<shuruStr.length;i++){
                check(shuruStr,chars);
            }

        }else {
            char[] chars=strings[0].toCharArray();
            char[] chars2=strings[1].toCharArray();
            for (int i=0;i<shuruStr.length;i++){

            }
        }

    }
    public static String getString(){
        Scanner scanner=new Scanner(System.in);
        return scanner.next();
    }


    public static int check(char[] strChars,char[] typeChars){
        int l1 = strChars.length;
        int l2 = typeChars.length;

        if (l2==0) {
            return -1;
        }

        int i1=0,i2=0;

        while ( i1 < l1 && i2 < l2 ) {
            if (strChars[i1] == typeChars[i2]) {
                i1 ++ ;
                i2 ++ ;
            } else {
                i1 = i1 - i2 + 1;
                i2 = 0;
            }
        }

        if( i2 <= l2 )  {
            return i1-i2;
        }

        return -1;
    }



}
