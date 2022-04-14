public class ReverseString {
   private static String get_reverse(String input){
        String input_str = input;
        String reverse_str = "";
 
        for(int idx=input_str.length()-1;idx>=0;idx-=1){
            reverse_str+=input_str.charAt(idx); 
        }
 
        return reverse_str;
   }
 
    public static void main(String args[]) {
        
        System.out.println("Reversed string: "+get_reverse("Hello world!"));
 
    }
}

