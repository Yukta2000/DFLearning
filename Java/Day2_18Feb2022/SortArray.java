//Sort integer array
import java.util.Arrays;
public class SortArray {
    private static int[] sort_intarr(int[] numarr){
        Arrays.sort(numarr);
        return numarr;
    }
    public static void main(String args[]) {
      int [] numarr ={13, 7, 6, 45, 21, 9, 2, 100 };
      
      System.out.println(Arrays.toString(sort_intarr(numarr)));
    }
}
