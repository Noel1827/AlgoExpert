import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;


public class Solution {
    public static int solution(int N) {
        int max = N;
        int copy;
        ArrayList<Integer> number = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        while(N>0){
            stack.add(N%10);
            N/=10;
        }
        while(!stack.isEmpty())
            number.add(stack.pop());

        // 1st forloop to get the first pointer, second for loop to get the second pointer and reverse subsets
        for(int start = 0; start < number.size()-1; start++){
            for(int end = start+1; end < number.size(); end++){
                // reverse Subset
                ReverseSubset(start,end,number);
                // get the number from the array list
                copy = ArrayAsNumber(number);
                if(copy > max) {
                    max = copy;
                }
                // reverse it to it's original state to keep checking other subsets
                ReverseSubset(start,end,number);
            }
        }
        return max;
    }

    private static int ArrayAsNumber(ArrayList<Integer> number) {
        int copy = 0;
        for (Integer integer : number) {
            copy += integer;
            copy *= 10;
        }
        copy/=10;
        return copy;
    }

    private static void ReverseSubset(int start, int end, ArrayList<Integer> number) {
        int aidx = start;
        int bidx = end;
        while(aidx< bidx){
            int temp = number.get(aidx);
            number.set(aidx,number.get(bidx));
            number.set(bidx,temp);
            aidx++;
            bidx--;
        }
    }
public static int solution(int[] A) {
    System.err.println("Tip: Use System.err.println() to write debug messages on the output tab.");
    Set<Integer> set = new HashSet<>();
    for (int number : A) {
        if (set.contains(number)) {
            int reversed = 0;
            while (number > 0) {
                reversed += number % 10;
                reversed *= 10;
                number /= 10;
            }
            reversed/=10;
            set.add(reversed);
        } else
            set.add(number);

    }
    return set.size();
}

    public static void main(String[] args){
    int[] arr = {10, 10, 20,20,30,30,40,40,50,50,60,60,70,70,80,80,90,90};
      System.out.print(solution(arr));
    }
}
