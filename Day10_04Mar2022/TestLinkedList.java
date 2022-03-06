import CustomLinkedList.Node;
import CustomLinkedList.LinkedList;

public class TestLinkedList {
    public static void main(String[] args){
    Node<Integer> n1 = new Node<>(1);
    LinkedList<Integer> list1 = new LinkedList<>(n1);
    Node<Integer> n2 = new Node<>(2);
    n1.setNext(n2);
    
    Node<Integer> n3 = new Node<>(3);
    n2.setNext(n3);

    list1.printLinkedList();

    Node<String> str1 = new Node<>("This"); 
    LinkedList<String> strlist = new LinkedList<>(str1);
    Node<String> str2 = new Node<>("is a ");
    str1.setNext(str2);
    Node<String> str3 = new Node<>("linked list");
    str2.setNext(str3);
    Node<String> str4 = new Node<>("of string.");
    str3.setNext(str4);

    strlist.printLinkedList();

    }
}
