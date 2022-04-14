
class Node{
    private Node previous;
    private Node next;
    private int data;
    
    Node(int data){
        this.data=data;
        this.previous=null;
        this.next=null;
    }
    
    public void setPrevious(Node previous){
        this.previous=previous;
    }
    
    public void setNext(Node next){
        this.next = next;
    }
    
    public Node getPrevious(){
        return this.previous;
    }
    
    public Node getNext(){
        return this.next;
    }
    
    public int getData(){
        return this.data;
    }
}

class LinkedList{
    private Node head;
    
    LinkedList(Node head){
        this.head=head;
    }
    
    public Node getHead(){
        return this.head;
    }
    
}
public class LinkedListMain
{
	public static void main(String[] args) {
	    Node n1 = new Node(1);
		LinkedList list1 = new LinkedList(n1);
		Node n2 = new Node(2);
		n1.setNext(n2);
		n2.setPrevious(n1);
		Node n3 = new Node(3);
		n2.setNext(n3);
		n3.setPrevious(n2);
		
		Boolean run=true;
		Node n = list1.getHead();
		System.out.println("LinkedList \n Start-> ");
		while(run){
		  if(n.getNext() == null){
		      run = false;
		  }
		  System.out.println(n.getData());
		  n=n.getNext();
		}
		System.out.println(" --------End");
		
	}
}
