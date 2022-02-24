//Capitalize first letter of each word for given string

public class FirstLetterCapital {
   
   private static String convert_first_letter_upper(String input){
       String input_str = input ;
        String result_str = "";
        String[] words = input_str.split(" ");
        for(String word:words){
            result_str += word.substring(0,1).toUpperCase() + word.substring(1) + " ";
            
        }
        return result_str;
   }
    public static void main(String args[]) {
        System.out.println(convert_first_letter_upper("This sentence contains first letter of every word in uppercase"));
    }
}
