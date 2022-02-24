//Find nth highest number
import java.util.*;

public class Nhighest {
    private static String nhighest(Integer[] arr,Integer n){
      if(n <= arr.length && n > 0){
        Arrays.sort(arr, Collections.reverseOrder());
        System.out.println(Arrays.toString(arr));
        return "The "+ n +" highest number is " + arr[n-1];
        
      }
      else
        return "Invalid value of n";
    }
    
    public static void main(String[] args) {
        Integer[] arr = { 13, 7, 6, 45, 21, 9, 2, 100 };
        System.out.println(nhighest(arr,4));
        System.out.println(nhighest(arr,0));
        System.out.println(nhighest(arr,9));
    }
}
