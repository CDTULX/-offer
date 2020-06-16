/*
* 输入一个整形数组（可能有正数和负数），求数组中连续子数组（最少有一个元素）的最大和。要求时间复杂度为O(n)。
* */
public class theMaxOfNumber {
    public static int test1(int[] a){
        int sum=0;
        int theSize=a.length;
        int mai=0;
        for (int i=0;i<theSize;i++){
            if (a[i]>0){
                if (sum<0){
                    sum=0;
                }
                sum+=a[i];
            }
           else {
               if (sum>0){
                   sum+=a[i];

               }else sum=a[i];
            }
        }
        if (mai<sum){
            mai=sum;
        }
        return mai;
    }





    static int maxSubArraySum(int[] a)
    {
        int frameSetSum = a[0];
        int biggestSum = a[0];
        for (int i = 1; i < a.length; i++)
        {
            frameSetSum = Math.max(a[i], frameSetSum + a[i]); //第一个变量大则框集前移，第二个变量大则框集扩增
            biggestSum = Math.max(biggestSum, frameSetSum); //记录遍历过程中最大的子数组和
        }
        return biggestSum;
    }

    public static int test2(int[] a){
        int maxNumber=0;
        int maxIndex=0;
        for (int i=0;i<a.length;i++){
            if (a[i]>maxNumber){
                maxNumber=a[i];
                maxIndex=i;
            }
        }
        return 1;
    }

    public  static int findMax(int a[]){
        int nowMax=a[0];
        int lastMax=a[0];
        for (int i=1;i<a.length;i++){
            nowMax=Math.max(a[i],nowMax+a[i]);
            lastMax=Math.max(nowMax,lastMax);
        }
        return lastMax;
    }
    public static void main(String[] args) {
        int[] a={8,1,-2,3,10,-4,7,2,-5};
        System.out.println(maxSubArraySum(a));
    }
}
