// a method queue that will reverse given queue
package Day1.Practice;

class Queue {
  private int maxSize;
  private int [] queArray;
  private int front;
  private int rear;
  private int nItems;

  public Queue(int s) {
    maxSize = s;
    queArray = new int[maxSize];
    front = 0;
    rear = -1;
    nItems = 0;
  }
//--------------------------------------------------------------
  public void insert(int item) { // put item at rear of queue
    if (rear == maxSize - 1)      // deal with wraparound
      rear = -1;

    queArray[++rear] = item;         // increment rear and insert
    nItems++;                     // one more item
  }
//--------------------------------------------------------------
  public int remove() {       // take item from front of queue
    int temp = queArray[front++]; // get value and incr front
    if (front == maxSize)          // deal with wraparound
      front = 0;
    nItems--;                      // one less item
    return temp;
  }
//--------------------------------------------------------------
  public static void reverse(Queue q) {
    if(!q.isEmpty()){
      int temp = q.remove();
      reverse(q);
      q.insert(temp);
    }
  }
//--------------------------------------------------------------
  public int peek() {    // peek at front of queue
    return queArray[front];
  }
//--------------------------------------------------------------
  public boolean isEmpty() {  // true if queue is empty
    return (nItems == 0);
  }
//--------------------------------------------------------------
  public boolean isFull() {   // true if queue is full
    return (nItems == maxSize);
  }
//--------------------------------------------------------------
  public int size() {         // number of items in queue
    return nItems;
  }
  public void display()
  {
  		if(isEmpty())
  		  {
  			  System.out.println("Queue is empty");
  			  return;
  		  }
  		if(front<=rear)
  		{
  			for(int i=front;i<=rear;i++)
  			{
  				System.out.print(queArray[i]+" ");
  			}
  		}
  	else
  	{
  		for(int i=front;i<maxSize;i++)
  		{
  			System.out.print(queArray[i]+" ");
  		}
  		for(int i=0;i<=rear;i++)
  		{
  			System.out.print(queArray[i]+" ");
  		}
  	}
  }
//--------------------------------------------------------------
}  // end class Queue
class reverseQueue{
  public static void main(String[] args) {
    Queue theQueue = new Queue(5); // queue holds 5 items
    theQueue.insert(10); // insert 4 items
    theQueue.insert(20);
    theQueue.insert(30);
    theQueue.insert(40);
    System.out.println("Queue:");
    theQueue.display();
    theQueue.remove(); // remove 3 items
    theQueue.remove(); // (10, 20, 30)
    theQueue.remove();
    System.out.println("\nItems removed from Queue:");
    theQueue.display();
    theQueue.insert(50); // insert 4 more items
    theQueue.insert(60); // (wraps around)
    theQueue.insert(70);
    theQueue.insert(80);
    System.out.println("\nItems inserted in Queue:");
    theQueue.display();
    System.out.println("\nReverse Queue:");
    Queue.reverse(theQueue);
    while ( !theQueue.isEmpty() ) { // remove and display
      // all items

      long n = theQueue.remove(); // (40, 50, 60, 70, 80)
      System.out.print(n);
      System.out.print(" ");
    }
    System.out.println(" ");
  } // end main()
} // end class reverseQueue
