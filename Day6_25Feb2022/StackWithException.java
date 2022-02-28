
enum Message {
    STACK_UNDERFLOW("Stack is empty"),
    STACK_OVERFLOW("Stack is full");

    private String description;

    Message(String description){
        this.description=description;
    }

    public String getDescription(){
        return this.description;
    }
}

class StackException extends Exception{   
    Message message;
    StackException(Message message){
        this.message = message;
    }
    public String toString(){
        return "Custom Exception: "+this.message.getDescription();
    }
}

class StackInt{
    private int ARRAY_SIZE;
    private int head = -1;
    private int[] stack;

    StackInt(){
        this.ARRAY_SIZE = 20;
        this.stack = new int[this.ARRAY_SIZE];
    }

    StackInt(int ARRAY_SIZE){
        this.ARRAY_SIZE = ARRAY_SIZE;
        this.stack = new int[this.ARRAY_SIZE];
    }

    Boolean isStackOverflow(){
      if(this.head >= this.ARRAY_SIZE){
          return true;
      }
      return false;
    }

    Boolean isStackUnderflow(){
        if(this.head == -1){
          return true;
        }
        return false;  
    }

    public int pop() throws Exception{
        if(isStackUnderflow())
            throw new StackException(Message.STACK_UNDERFLOW);
        else 
            return stack[head--];
           
    }
    
    public int peek() throws Exception{
        if(isStackUnderflow())
            throw new StackException(Message.STACK_UNDERFLOW);
        else    
          return stack[head];}

    public void push(int num) throws Exception{
        this.head ++;
        if(isStackOverflow())
            //throw new Exception("Stack Overflow");
            throw new StackException(Message.STACK_OVERFLOW);
        else 
            this.stack[this.head]=num;
            
    }

    public void printStack() throws Exception{
        if(isStackUnderflow())
            throw new StackException(Message.STACK_UNDERFLOW);
        else {
            System.out.print("Stack: [");
            for(int i=0;i<=head;i++){
             System.out.print(this.stack[i]+" ");
            }
            System.out.println("]");
        }
            
    }
}

public class StackWithException{
    public static void main(String[] args) throws Exception{
        StackInt stk1 = new StackInt(5);
        stk1.push(10);
        stk1.push(20);
        stk1.push(30);
        stk1.push(40);
        stk1.push(50);
        stk1.push(60);
        stk1.printStack();
        System.out.println("Pop operation:"+stk1.pop());
        System.out.println("Pop operation:"+stk1.pop());
        System.out.println("Pop operation:"+stk1.pop());
        System.out.println("Pop operation:"+stk1.pop());
       // System.out.println("Pop operation:"+stk1.pop());
        // System.out.println("Pop operation:"+stk1.pop());
        System.out.println("Peek operation:"+stk1.peek());
        stk1.printStack();
    }
}