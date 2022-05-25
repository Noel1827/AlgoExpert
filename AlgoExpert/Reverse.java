import java.util.*;
class Reverse {
    public static int solution(int N) {
        int max = N;
        int copy = N;
        ArrayList<Integer> number = new ArrayList<>();
       while(N>0){
           number.add(N%10);
           N/=10;
       }

       for(int i = 0; i < number.size()-1; i++){
           for(int j = i+1; j < number.size(); j++){
               int temp = number.get(i);
               number.add(j,number.get(i));
               number.add(i,temp);
           }
       }

        System.err.println("Tip: Use System.err.println() to write debug messages on the output tab.");
        return 0;
    }

    public static void main(String[] args){
        solution(2043);
    }
}
