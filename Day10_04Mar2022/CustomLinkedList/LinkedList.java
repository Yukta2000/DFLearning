package CustomLinkedList;

public class LinkedList<L> {
    private Node<L> head;
    
    public LinkedList(Node<L> head){
        this.head=head;
    }
    
    public Node<L> getHead(){
        return this.head;
    }

    public void printLinkedList(){
      Node<L> nodeitr = getHead();
      while(nodeitr!=null)
      {
        System.out.print(nodeitr.getData()+" -> ");
        nodeitr=nodeitr.getNext(); 
      }
      System.out.print(" End\n");
    }
}
