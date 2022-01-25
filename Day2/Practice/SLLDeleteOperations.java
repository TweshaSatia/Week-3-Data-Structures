package Day2.Practice;
//code to delete first node from SLL
//code to delete a node with given value from SLL.
class SLLDeleteOperations
{
    private static SLLDeleteOperations head; // ref to first link on list
	private int data;
	private SLLDeleteOperations next;

	public SLLDeleteOperations(int data,SLLDeleteOperations previous)              // constructor
	{
		this.data = data;
		this.next=null;
		if(previous==null)
		{
		  head = this;
		}
		else
		{
			previous.next = this;
		}
	}
	public static void displayList()      // display the list
    {
		System.out.print("List (first-->last): ");
		SLLDeleteOperations temp = head;       // start at beginning of list
		while(temp != null)      // until end of list,
		{
			System.out.print("{" + temp.data + "} ");
			temp = temp.next;  // move to next link
		}
		System.out.println("");
    }
	  
	public static void deleteFirstNode() //deletion of first node
	{
		if(head == null)
		{
			System.out.println("List is empty");
			return;
		}
        System.out.println("First node deleted");
		head = head.next;
	}
	public static void deleteSpecificNode(int val)
	{
		if(head==null)           // List is empty
		{
			System.out.println("List is empty");
			return;
		}
		else if(head.data==val)  //Value present at first node
		{
			head=head.next;
			System.out.println("Node with data :"+val+" deleted");
			return;
		}
		SLLDeleteOperations node = head;
		while(node.next!=null)
		{
			if(node.next.data == val)
			{
				node.next = node.next.next;
				System.out.println("Node with data :"+val+" deleted");
				return;
			}
			node = node.next;
		}
		System.out.println("Node with data :"+val+" not found");
	}
	
	
    public static void main(String[] args) {
	
		SLLDeleteOperations L = new SLLDeleteOperations(7,null);
		L = new SLLDeleteOperations(11,L);
		L = new SLLDeleteOperations(18,L);
		L = new SLLDeleteOperations(23,L);
		L = new SLLDeleteOperations(2,L);
		L = new SLLDeleteOperations(67,L);
		displayList();
		deleteFirstNode();
        displayList();
        deleteSpecificNode(2);
		displayList();
		
	}
}