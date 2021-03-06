package Day1.Practice;

public class myStack {
	private int maxSize;        // size of stack array
	   private long[] stackArray;
	   private int top;            // top of stack
	//--------------------------------------------------------------
	// This is the constructor that takes as an argument the maximum size
	// s that it ever needs to be
	   public myStack(int s)         // constructor
	      {
	      maxSize = s;             // set array size
	      stackArray = new long[maxSize];  // create array
	      top = -1;                // no items yet
	      }
	//--------------------------------------------------------------
	   public void push(long j)    // put item on top of stack
	      {
	      stackArray[++top] = j;     // increment top, insert item
	      }
	//--------------------------------------------------------------
	   public long pop()           // take item from top of stack
	      {
	      return stackArray[top--];  // access item, decrement top
	      }
	//--------------------------------------------------------------
	   public long peek()          // peek at top of stack
	      {
	      return stackArray[top];
	      }
	//--------------------------------------------------------------
	   public boolean isEmpty()    // true if stack is empty
	      {
	      return (top == -1);
	      }
	//--------------------------------------------------------------
	   public boolean isFull()     // true if stack is full
	      {
	      return (top == maxSize-1);
	      }
		  
	//--------------------------------------------------------------
	   
	   //get top of stack
	   public int getTop()
	   {
		   return top;
	   }
	   // fetch element of stack Array at a particular index
	   public long getItem(int index)
	   {
		   return stackArray[index];
	   }
	   public void display()
		{
		   if(this.isEmpty())
		   {
				System.out.println("\nStack is Empty");  
				return;
		   }
		   int top = this.getTop();
		   System.out.println("\nElements in Stack:");
		   for(int i=0;i<=top;i++)
				System.out.print(this.getItem(i) + " ");
		   
		}
}
