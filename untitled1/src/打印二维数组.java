import java.util.Scanner;

public class 打印二维数组 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int x=scanner.nextInt();
        int y=scanner.nextInt();
        int [][] number=new int[x][y];
        number[0][0]=1;
        number[x-1][y-1]=x*y;
        for (int j=0;j<x;j++){
            if (j!=0) {
                number[j][0]=number[j-1][0]+1+j;
                number[j-1][1]=number[j][0]-1;
            }

        }
        for (int j=y-1;j>=0;j--){
            if (j!=y-1) {
                number[j][y - 1] = number[j + 1][y - 1] - y + j;
                number[j+1][y - 2]=number[j][y - 1]+1;
            }
        }

        for (int i=0;i<x;i++){
            for (int j=0;j<y;j++){
                if (number[i][j]==0){
                    number[i][j]=number[i][j-1]+y-j;
                }
                System.out.print(number[i][j]+" ");
            }
            System.out.println();
        }
    }
}

