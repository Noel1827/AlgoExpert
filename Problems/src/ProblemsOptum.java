// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);
        int n = 1;
        int current = 0;
        int prev = 0;
        for(int i = 0; i < A.length; i++){
            // get rid of the negatives
            current = A[i];
            while(current <= 0){
                i++;
            }

            if(current == n) {
                current = A[i++];
            }else {
                if(current > n) return A[i--];
                else return n;
            }



        }
        return 0;
    }
    public int searchInsert(int[] nums, int target) {
        int index = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target) return i;
            if(target > nums[i]){
                index++;
            }
        }
        return index;
    }
}
