/**
 * 自己实现 字符串的匹配
 * @author Jiekun.Cui
 *
 */
public class SString {

    public static void main(String[] args) {
        System.out.println(indexOf("ccncccccccccccccccc","n",0));
    }


    /**
     * 字符串匹配算法  -- 查找s2 在s1 中的位置
     * @param s1
     * @param s2
     * @param pos 开始匹配的位置
     * @return
     */
    public static int indexOf(String s1,String s2,int pos){

        int l1 = s1.length();
        int l2 = s2.length();

        if (l2==0) {
            return -1;
        }

        int i1=pos,i2=0;

        while ( i1 < l1 && i2 < l2 ) {
            if (s1.charAt(i1) == s2.charAt(i2)) {
                i1 ++ ;
                i2 ++ ;
            } else {
                i1 = i1 - i2 + 1; //回到开始匹配且没有匹配成功的下一个位置，开始下一次匹配；
                i2 = 0;
            }
        }

        if( i2 <= l2 )  {
            return i1-i2;
        }

        return -1;
    }

}