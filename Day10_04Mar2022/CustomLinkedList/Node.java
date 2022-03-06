package CustomLinkedList;

public class Node<D> {
    private Node<D> next;
    private D data;
    
    public Node(D data){
        this.data=data;
        this.next=null;
    }
      
    public void setNext(Node<D> next){
        this.next = next;
    }
    
    
    public Node<D> getNext(){
        return this.next;
    }
    
    public D getData(){
        return this.data;
    }
}
