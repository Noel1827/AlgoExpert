import java.util.*;
public class NextGreaterElement {
    public static int[] nextGreaterElement(int[] array) {
        // Write your code here.
        int[] greater = new int[array.length];
        Stack<Integer> max = new Stack<Integer>();
        int prev = 0;
        // store in reverse order
        for(int i = array.length-1; i>=0; i--){
            max.push(array[i]);
        }
        int j = 1;
        while(max.size()>0){
            if(j >= array.length){
                j %= array.length;
            }

           if(array[j] > max.peek() ){
               greater[prev] = array[j];
               max.pop();
               prev++;
               j = prev+1;
           }else{
               j++;
               if(j == prev){
                   greater[prev] = -1;
                   prev++;
                   j=prev;
                   max.pop();
               }
           }

        }

        return greater;
    }
    public static void main(String[] args){
        int[] array = {2,5,-3,-4,6,7,2};
        int[] solution = nextGreaterElement(array);

    }
}
