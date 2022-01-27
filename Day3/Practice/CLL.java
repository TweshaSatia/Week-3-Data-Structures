package Day3.Practice;
//Circular linked list insert,delete,find and traverse functions.
class Node {

    int value;   //data value
    Node nextNode;  // next node in list

    public Node(int value) {
        this.value = value;
    }
   
}
public class CLL {
    private Node head = null;
    private Node tail = null;
    public void addNode(int value) {         //inserting nodes
        Node newNode = new Node(value);
    
        if (head == null) {
            head = newNode;
        } else {
            tail.nextNode = newNode;
        }
    
        tail = newNode;
        tail.nextNode = head;
    }
    public void findNode(int searchValue) {       // searching for a node  
        Node currentNode = head;
    
        if (head == null) {    //if list is empty
            return;
        } else {
            do {
                if (currentNode.value == searchValue) {
                    System.out.println("The value "+searchValue+" is present");
                }
                currentNode = currentNode.nextNode;
            } while (currentNode != head);
            System.out.println("The value "+searchValue+" is not present");
        }
    }
    public void deleteNode(int valueToDelete) {  
        Node currentNode = head;
        if (head == null) { // the list is empty
            return;
        }
        do {
            Node nextNode = currentNode.nextNode;
            if (nextNode.value == valueToDelete) {
                if (tail == head) { // the list has only one single element
                    head = null;
                    tail = null;
                } else {
                    currentNode.nextNode = nextNode.nextNode;
                    if (head == nextNode) { //we're deleting the head
                        head = head.nextNode;
                    }
                    if (tail == nextNode) { //we're deleting the tail
                        tail = currentNode;
                    }
                }
                break;
            }
            currentNode = nextNode;
        } while (currentNode != head);
    }
    public void traverseList(){
    Node current = head;  
        if(head == null) {  
            System.out.println("List is empty");  
        }  
        else {  
            System.out.println("Nodes of the circular linked list: ");  
             do{  
                //Prints each node by incrementing pointer.  
                System.out.print(" "+ current.value);  
                current = current.nextNode;  
            }while(current != head);  
            System.out.println();  
        }  
    }  
 public static void main(String[] args) {
    CLL cll=new CLL();
    cll.addNode(11);
    cll.addNode(7);
    cll.addNode(24);
    cll.addNode(1);
    cll.traverseList();
    cll.findNode(24);
    cll.deleteNode(1);
    cll.traverseList();

  }
}
