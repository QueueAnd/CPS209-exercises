import java.util.Arrays;

public class P2J1 {
    public static long fallingPower(int n, int k){
        long result=1;
        for(int i=n; i>n-k; i--){
            result*=i;
        }
        return result;
    }
    public static int[] everyOther(int[] arr){
        if(arr.length<=1){
            return arr;
        }
        int[] result = new int[arr.length/2+arr.length%2];
        for(int i=0; i<arr.length; i+=2){
            result[i/2]=arr[i];
        }
        return result;
    }
    public static int[][] createZigZag(int rows, int cols, int start){
        int[][]result=new int[rows][cols];
        for(int i=0; i<rows; i++){
            if(i%2!=0){
                for(int j=cols-1; j>=0; j--){
                    result[i][j]=start++;
                }
            } else {
                for(int j=0; j<cols; j++){
                    result[i][j]=start++;
                }
            }
        }
        return result;
    }
    public static int countInversions(int[] arr){
        int count=0;
        for(int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){
                if(arr[i]>arr[j]){
                    count++;
                }
            }
        }
        return count;
    }
}