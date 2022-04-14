public class Palindrome {
   private static String get_reverse(String input){
        String input_str = input;
        String reverse_str = "";
 
        for(int idx=input_str.length()-1;idx>=0;idx-=1){
            reverse_str+=input_str.charAt(idx); 
        }
 
        return reverse_str;
   }
 
    private static String check_palindrome(String input){
        String reverse_str = get_reverse(input);
        if(input.equals(reverse_str))
            return input + " is a palindrome";
        else
            return input + " is not a palindrome";
    }
    public static void main(String args[]) {
        System.out.println(check_palindrome("MOM"));
        System.out.println(check_palindrome("Hello"));
    }
}
