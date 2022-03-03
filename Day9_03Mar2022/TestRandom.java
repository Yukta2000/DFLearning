
import java.util.Scanner;
import java.lang.Math;

public class TestRandom {
    public static void  main(String[] args){
       System.out.println("Enter a number: ");
       Scanner sc = new Scanner(System.in);
       Double num1 = sc.nextDouble();
       sc.close();
       Integer itr = 1;
      Double randomNumber;
     
       do{
        //Generate random number between 1 to 10
       randomNumber = 1 + (Math.random() * 10);
      // System.out.println(randomNumber);
       System.out.println("Iteration: "+itr);
       itr++;
       }
       while(num1!=randomNumber);
       //System.out.println("Iterations required: "+itr);
    }
}
