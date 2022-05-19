public class squareSort {
    public static int[] sortedSquaredArray(int[] array) {
        // Write your code here.
        int start = 0;
        int end = 0;
        for(int i = 0; i < array.length; i++){
            if(array[i]<0){
                end++;
            }else if(array[i] >=0){
                end--;
                break;
            }
        }
        int[] negatives = new int[end+1];
        int[] positives = new int[array.length-end+1];
        for(int i = end; i >= start; i--){
            negatives[start] = array[i] * array[i];
        }
        for(int i = 0; i < positives.length; i++){
            positives[i] = array[end+i+1]*array[end+i+1];
        }

        for(int x: positives){
            System.out.print(x + " ");
        }
        return array;
    }

    public static void main(String[] args){
        int[] arr = {-3,-2, 1, 2, 4, 5};
        sortedSquaredArray(arr);
    }
}
