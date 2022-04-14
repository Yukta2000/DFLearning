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

class StackGen<T>{
    private int ARRAY_SIZE;
    private int head = -1;
    private Object[] stack;

    StackGen(){
        this.ARRAY_SIZE = 20;
        this.stack = new Object[this.ARRAY_SIZE];
    }

    StackGen(int ARRAY_SIZE){
        this.ARRAY_SIZE = ARRAY_SIZE;
        this.stack = new Object[this.ARRAY_SIZE];
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

    public T pop() throws Exception{
        if(isStackUnderflow())
            throw new StackException(Message.STACK_UNDERFLOW);
        else 
            return (T) stack[head--];
           
    }
    
    public T peek() throws Exception{
        if(isStackUnderflow())
            throw new StackException(Message.STACK_UNDERFLOW);
        else    
          return (T) stack[head];}

    public void push(T data) throws Exception{
        this.head ++;
        if(isStackOverflow())
            //throw new Exception("Stack Overflow");
            throw new StackException(Message.STACK_OVERFLOW);
        else 
            this.stack[this.head]=data;
            
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

public class GenericStack{
    public static void main(String[] args) throws Exception{
        StackGen<Integer> stk1 = new StackGen<>(5);
        stk1.push(10);
        stk1.push(20);
        stk1.push(30);
        stk1.push(40);
        stk1.push(50);
        //stk1.push(60);
        stk1.printStack();
        System.out.println("Pop operation:"+stk1.pop());
        System.out.println("Pop operation:"+stk1.pop());
        System.out.println("Pop operation:"+stk1.pop());
        System.out.println("Pop operation:"+stk1.pop());
       // System.out.println("Pop operation:"+stk1.pop());
        // System.out.println("Pop operation:"+stk1.pop());
        System.out.println("Peek operation:"+stk1.peek());
        stk1.printStack();
        
        
        StackGen<String> stk2 = new StackGen<>(5);
        stk2.push("Hello");
        stk2.push("World");
        stk2.push("Have");
        stk2.push("A");
        stk2.push("Good");
        //stk2.push("Day");
        stk2.printStack();
        System.out.println("Pop operation:"+stk2.pop());
        System.out.println("Pop operation:"+stk2.pop());
        System.out.println("Pop operation:"+stk2.pop());
        System.out.println("Pop operation:"+stk2.pop());
       // System.out.println("Pop operation:"+stk2.pop());
        // System.out.println("Pop operation:"+stk2.pop());
        System.out.println("Peek operation:"+stk2.peek());
        stk2.printStack();
    }
}

