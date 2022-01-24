//Java code to implement Queue using Stack(s).
package Day1.Practice;
import java.util.*;

//Universal Declaration


class QueueUsingStack  
{  
	
    myStack s1; 
	myStack s2;
	
	public QueueUsingStack()
	{
		s1 = new myStack(10);
		s2 = new myStack(10);
	}
    void enQueue(int x)  
    {  
		if(s1.isFull())
		{
			System.out.println("Q is Full");  
            return;
		}
        // Move all elements from s1 to s2  
        while (!s1.isEmpty()) 
        {  
            s2.push(s1.pop());  
             
        }  
  
        // Push item into s1  
        s1.push(x);  
  
        // Push everything back to s1  
        while (!s2.isEmpty())  
        {  
            s1.push(s2.pop());  
              
        }  
    }  
  
    // Dequeue an item from the queue  
    void deQueue()  
    {  
        // if first stack is empty  
        if (s1.isEmpty())  
        {  
            System.out.println("Q is Empty");  
            return; 
        }  
  
        // Return top of s1  
        long x = s1.peek();  
        s1.pop();  
        System.out.println("Deleted element:"+x);  
    } 
	
public void display()
   {
		
	   if (s1.isEmpty())  
       {   
			return;			
       }
	   long x = s1.peek();
	   s1.pop();
	   System.out.print(x + " ");
	   display();
	   s1.push(x);
   }
	public static void main(String[] args)
	{
	QueueUsingStack q = new QueueUsingStack();
	
	q.enQueue(2);              
	q.enQueue(4);
	q.enQueue(6);
	q.enQueue(8);
	System.out.println("Elements in Queue:");
	q.display(); 
	q.deQueue();
	System.out.println("Elements in Queue after Dequed:");
	q.display();
}  

};
 

   
   