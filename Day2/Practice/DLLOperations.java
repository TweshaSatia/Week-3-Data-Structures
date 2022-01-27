package Day2.Practice;
//building a sorted DLL
import java.io.*; 
import java.util.*; 
  

class Node  
{ 
    int data; 
    Node next, previous; 
} 
  
class DLLOperations
{ 
  
    static Node getNode(int data)  
    { 
            // allocate node  
            Node newNode = new Node(); 
  
            // put in the data  
            newNode.data = data;  
            newNode.previous = newNode.next = null;  
            return newNode;  
  
    } 
  
    // function to insert a new node in sorted way in  
    // a sorted doubly linked list  
    static Node sortedInsert(Node head, Node newNode) 
    { 
            Node temp; 
  
            // if list is empty  
            if (head == null) 
                head = newNode;  
  
            // if the node is to be inserted at the beginning  
            // of the doubly linked list  
            else if (head.data >= newNode.data) 
            { 
                newNode.next = head; 
                newNode.next.previous = newNode; 
                head = newNode; 
            } 
  
            else 
            { 
                temp = head; 
  
                // locate the node after which the new node  
                // is to be inserted  
                while (temp.next != null &&  
                        temp.next.data < newNode.data)  
                    temp = temp.next; 
  
                /* Make the appropriate links */
                newNode.next = temp.next; 
  
                // if the new node is not inserted  
                // at the end of the list 
                if (temp.next != null)  
                    newNode.next.previous = newNode;  
  
                temp.next = newNode;  
                newNode.previous = temp;  
              
            } 
            return head; 
    } 
    static Node delFirst(Node head){   //deleting first node
        if(head != null) {
            Node temp = head;        
            head = head.next;
            temp = null;       //free temp
            if(head != null) 
              head.previous = null;
          }
          return head;
    }
    static Node delLast(Node head){          //deleting last node
        Node temp=head;
        Node temp2;
        while(temp.next!=null)
        {
            temp=temp.next;
        }
        temp2=temp.previous;
        temp2.next=null;
        temp=null;        //free temp
        return head;
        
    }

    static Node delInter(Node head,int position){     //deleting intermediate node
        Node temp=head;
        Node temp2=null;
        if(position==1){                //deleting first node
            head=delFirst(head);
            return head;
        }
        while(position>1){
            temp=temp.next;
            position--;
        }
        if(temp.next==null){             //reached null
            head=delLast(head);          //delete last node
        }
        else{
            temp2=temp.previous;
            temp2.next=temp.next;
            temp.next.previous=temp2;
            temp=null;

        }
        return head;

    }
   
     static Node reverse(Node head){
         Node ptr1=head;
         Node ptr2=ptr1.next;

         ptr1.next=null;
         ptr1.previous=ptr2;

         while(ptr2!=null){
             ptr2.previous=ptr2.next;
             ptr2.next=ptr1;
             ptr1=ptr2;
             ptr2=ptr2.previous;
         }
         head=ptr1;
         return head;

     }
    static void printList(Node head) 
    { 
            while (head != null)  
            { 
                    System.out.print(head.data + " "); 
                    head = head.next; 
            } 
  
    } 
  
    // Driver code 
    public static void main(String args[]) 
    { 
            
            Node head = null; 
  
            
            Node new_node = getNode(10); 
            head = sortedInsert(head, new_node);  
            new_node = getNode(20);  
            head = sortedInsert(head, new_node);  
            new_node = getNode(3);  
            head = sortedInsert(head, new_node);  
            new_node = getNode(11);  
            head = sortedInsert(head, new_node);  
            new_node = getNode(2);  
            head = sortedInsert(head, new_node);  
            new_node = getNode(9);  
            head = sortedInsert(head, new_node); 
			new_node = getNode(6);  
            head = sortedInsert(head, new_node); 
			new_node = getNode(22);  
            head = sortedInsert(head, new_node); 
  
            System.out.println("Sorted Doubly Linked List"); 
            printList(head); 

            System.out.println("\nAfter deletion of first node");
            head=delFirst(head);
            printList(head); 

            System.out.println("\nAfter deletion of last node");
            head=delLast(head);
            printList(head); 

            System.out.println("\nAfter deletion of intermediate node");
            head=delInter(head,3);
            printList(head); 

            System.out.println("\nReverse DLL");
            head=reverse(head);
            printList(head);
    } 
}
// The time complexity of the above algorithm is f(n)=O(n).