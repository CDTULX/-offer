
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
class Point{
    private int x;
    private int y;
    public Point(){}
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public int getDistance(Point p){
        return Math.abs(this.x - p.x) + Math.abs(this.y - p.y);
    }
    public static Object findMin(Object[] nums){
        Arrays.sort(nums);
        return nums[0];
    }
}
public class Main{
    public static Boolean isBuild(int[][] nums){
        int i,j;
        for(i = 0 ; i < nums.length ; i ++){
            for(j = 0 ; j < nums[i].length ; j ++){
                if(nums[i][j] == 0){
                    return true;
                }
            }
        }
        return false;
    }
    public static int getMin(int[][] nums){
        int i;
        int j;
        int sum;
        ArrayList<Point> stations = new ArrayList<Point>();
        ArrayList<Point> houses = new ArrayList<Point>();
        ArrayList<Integer> distances = new ArrayList<Integer>();
        if(isBuild(nums) == true){
            for(i = 0 ; i < nums.length ; i ++){
                for( j = 0 ; j < nums[i].length ; j ++){
                    if(nums[i][j] == 0){
                        stations.add(new Point(i,j));
                    }else if(nums[i][j] == 1){
                        houses.add(new Point(i,j));
                    }
                }
            }
            for(i = 0 ; i < stations.size() ; i ++){
                sum = 0;
                for(j = 0; j < houses.size() ; j ++){
                    sum += stations.get(i).getDistance(houses.get(j));
                }
                distances.add(sum);
            }
            int tempNum =Integer.parseInt(Point.findMin(distances.toArray()).toString());
            return tempNum;
        }
        return -1;
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[][] nums = new int[n][];
        for(int i = 0 ; i < n ; i ++){
            nums[i] = new int[n];
            for(int j = 0 ; j < n ; j ++){
                nums[i][j] = scan.nextInt();
            }
        }
        int result = getMin(nums);
        System.out.println(result);
    }
}