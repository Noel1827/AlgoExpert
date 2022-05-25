import java.util.*;
import java.util.stream.Stream;

class Row {

    static int solution(Integer[] A) {
        // Your solution goes here
        ArrayList<PriorityQueue<Integer>> list = new ArrayList<>();

            PriorityQueue<Integer> L = new PriorityQueue<>();
            L.add(A[0]);
            list.add(L);

        for(int i = 1; i < A.length; i++){
            if(A[i] <=0) throw new IllegalArgumentException("Illegal input");
            for(int j = 0; j < list.size(); j++){
                if (A[i] >list.get(j).peek()) {
                        PriorityQueue<Integer> temp = new PriorityQueue<>();
                        temp.add(A[i]);
                        list.add(temp);
                    } else {
                        list.get(j).add(A[i]);
                    }
            }
        }
        return list.size();

    }

    public static void main(String[] args) {
        // Read from stdin, solve the problem, write answer to stdout.
        Scanner in = new Scanner(System.in);
        // Integer[] A = getIntegerArray(in.next());
        Integer[] arr = {5,4,3,6,1};
        System.out.print(solution(arr));
    }

    private static Integer[] getIntegerArray(String str) {
        return Stream.of(str.split("\\,"))
                .map(Integer::valueOf)
                .toArray(Integer[]::new);
    }
}