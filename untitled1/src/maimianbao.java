
import java.util.Scanner;

public class maimianbao {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int pricep[]=new int[100];
        for (int i=0;i<n;i++){
            pricep[i]=scanner.nextInt();
        }
        int m=scanner.nextInt();
        int sum=0;
        int type=0;
        int number=0;
        for (int i=0;i<m;i++){
            type=scanner.nextInt();
            number=scanner.nextInt();
            sum +=pricep[type-1]*number;
        }
        System.out.println(sum);
    }
}
