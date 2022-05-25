import java.util.*;
public class ThreeNumberSum {
    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        // Write your code here.
        Arrays.sort(array);
        for(int i = 1; i < array.length-2; i++){
            int R = array.length-1;
            int L = i+1;
            while(L<R){
                int sum = array[L] + array[i] + array[R];
                if(sum == targetSum){
                    System.out.println(array[L] +" "+ array[i] + " "+ array[R]);
                }
                if(sum < targetSum){
                    L++;
                }else R--;
            }
        }
        return new ArrayList<Integer[]>();
    }
    public static void main(String[] args){
        int[] arr = {12,3,1,2,-6,5,-8,6};
        threeNumberSum(arr,0);
    }
}
