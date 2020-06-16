import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
* Shopee物流会有很多个中转站。在选址的过程中，会选择离用户最近的地方建一个物流中转站。

假设给你一个二维平面网格，每个格子是房子则为1，或者是空地则为0。找到一个空地修建一个物流中转站，使得这个物流中转站到所有的房子的距离之和最小。 能修建，则返回最小的距离和。如果无法修建，则返回 -1。


若范围限制在100*100以内的网格，如何计算出最小的距离和？

当平面网格非常大的情况下，如何避免不必要的计算？
* */
public class wuliuzhongzhuanzhan {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int aa=0;
        int bb=0;
        int min=99999;
        int size=0;
        ArrayList<Node> nodeNullList=new ArrayList<Node>();
        ArrayList<Node> nodeList=new ArrayList<Node>();
        ArrayList<Integer> all=new ArrayList<Integer>();

        int N=scanner.nextInt();

        int[][] a=new int[N][];
        for (int i=0;i<N;i++){
            a[i] = new int[N];
            for (int j=0;j<N;j++){
                a[i][j]=scanner.nextInt();

                if (a[i][j]==0){
                    nodeNullList.add(new Node(i,j));
                }else nodeList.add(new Node(i,j));

            }

        }

        for (Node n:nodeNullList) {

            size=0;
            for (Node node1:nodeList){
                size+=Math.abs(n.x-node1.x)+Math.abs(n.y-node1.y);
            }


            all.add(size);
        }
        Object[] szzz=all.toArray();
        Arrays.sort(szzz);
        System.out.println(szzz[0].toString());


    }

}/*
运行时间：749ms

占用内存：23548k*/
 class Node{
    int x;
    int y;

    @Override
    public String toString() {
        return "Node{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

     public Node() {

     }
}
/*
import java.util.*;

public class Main{
public static void main(String[] args) {
    Scanner s=new Scanner(System.in);
    int N=s.nextInt();
    int[] a=new int[N];
    for(int i=0;i<N;i++){
        a[i]=s.nextInt();
    }

        int nowMax=a[0];
        int lastMax=a[0];
        for (int i=1;i<N;i++){
            nowMax=Math.max(a[i],nowMax+a[i]);
            lastMax=Math.max(nowMax,lastMax);
        }
    System.out.print(lastMax);
    }
}*/
