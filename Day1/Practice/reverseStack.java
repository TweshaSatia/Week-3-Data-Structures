//a method reverse that will reverse a given stack
package Day1.Practice;
////////////////////////////////////////////////////////////////
class reverseStack
 {
		public static void reverse(myStack s)
	  {
		if (s.isEmpty())  
		{   
			return;			
		}
	   long x = s.peek();
	   s.pop();
	   System.out.print(x + " ");
	   reverse(s);
	   s.push(x);
    }
   public static void main(String[] args)
   {
      myStack theStack = new myStack(10);  // make new stack
      theStack.push(20);               // push items onto stack
      theStack.push(40);
      theStack.push(60);
      theStack.push(80);
	   theStack.display();
      System.out.println(" ");
      System.out.println("Reversed Stack:");
      reverse(theStack);
     
   }  // end main()
}  // end class reverseStack
////////////////////////////////////////////////////////////////