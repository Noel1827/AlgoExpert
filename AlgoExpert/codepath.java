import java.util.*;
public class codepath {
    public static List<Integer> merge(List<Integer> nums1, List<Integer> nums2) {
        int a_pointer = 0;
        int b_pointer = 0;
        List<Integer> sorted = new ArrayList<>();

        while(a_pointer < nums1.size() && b_pointer < nums2.size()){

            if(nums1.get(a_pointer)<= nums2.get(b_pointer)){
                sorted.add(nums1.get(a_pointer));
                a_pointer++;
            }else {
                sorted.add(nums2.get(b_pointer));
                b_pointer++;
            }
        }
        if(a_pointer < nums1.size()){
            for(int x: nums1){
                sorted.add(x);
            }
        }else {
            for(int x: nums2){
                sorted.add(x);
            }
        }
        return sorted;
    }
    public static void main(String[] args) {
        List<Integer> sorted = new ArrayList<>();
        //System.out.println(merge(arr,a));
    }
}
