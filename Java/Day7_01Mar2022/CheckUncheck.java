//Convert checked exception to unchecked exception
//https://www.linuxtopia.org/online_books/programming_books/thinking_in_java/TIJ311_022.htm

class CheckedException extends Exception{
    CheckedException(String msg){
        super("Checked Exception: "+msg);
    }
}

class UncheckedException extends RuntimeException{
    UncheckedException(String msg){
        super("Unchecked Exception: "+msg);
    }
}

public class CheckUncheck {
    public static void main(String[] args){
        try{
        throw new CheckedException("check");
        }catch(CheckedException e){
            throw new UncheckedException("uncheck");
        }
    }
}
