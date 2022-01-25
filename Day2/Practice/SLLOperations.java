package Day2.Practice;
//It provides following methods: insertFirst, find, delete,size,sum,removelast,append
//displayList, insertLast, clear, element, get, removeFirst,copy,sublist,concate
class Link
   {
   public int iData;              // data item (key)
   public Link next;              // next link in list
// -------------------------------------------------------------
   public Link(int id, Link newNext) // constructor
      {
      iData = id;
      next = newNext;
      }
// -------------------------------------------------------------
   public void displayLink()      // display ourself
      {
      System.out.print("{" + iData + "} ");
      }
   }  // end class Link
   
class SLLOperations
   {
   private Link first;            // ref to first link on list

// -------------------------------------------------------------
   public SLLOperations()              // constructor
      {
      first = null;               // no links on list yet
      }
// -------------------------------------------------------------
   public void insertFirst(int id)
      {                           // make new link and make it point to
				  // the old first
      Link newLink = new Link(id, first);
      first = newLink;            // now first points to this
      }
// -------------------------------------------------------------
   public Link find(int key)      // find link with given key
      {                          
      // if empty linked list, then return null
      if(first == null)
	return null;

      // otherwise scan list until a node with key is found
      Link current = first;              // start at 'first'
      while(current.iData != key)        // while no match,
         {
         if(current.next == null)        // if end of list,
            return null;                 // didn't find it
         else                            // not end of list,
            current = current.next;      // go to next link
         }
      return current;                    // found it
      }
// -------------------------------------------------------------
   public Link delete(int key)    // delete link with given key
      {                           // (assumes non-empty list)
      Link current = first;              // search for link
      Link previous = first;
      while(current.iData != key)
         {
         if(current.next == null)
            return null;                 // didn't find it
         else
            {
            previous = current;          // go to next link
            current = current.next;
            }
         }                               // found it
      if(current == first)               // if first link,
         first = first.next;             //    change first
      else                               // otherwise,
         previous.next = current.next;   //    bypass it
      return current;
      }
// -------------------------------------------------------------
   public void displayList()      // display the list
      {
      System.out.print("List (first-->last): ");
      Link current = first;       // start at beginning of list
      while(current != null)      // until end of list,
         {
         current.displayLink();   // print data
         current = current.next;  // move to next link
         }
      System.out.println("");
      }
// -------------------------------------------------------------
    void insertLast(int x)
	{
		// Make a new node containing x
		Link newNode = new Link(x, null);
		
		// If list is empty, then make first point to the new node
		if(first == null)
		{
			first = newNode;
			return;
		}

		// otherwise scan to the end of the list
		Link current = first;
		while(current.next != null)
			current = current.next;

		// connect the new node after current
		current.next = newNode;

	}
// -------------------------------------------------------------
// Removes all of the elements from this list.
	void clear()
	{
		first = null;
	}
// -------------------------------------------------------------
// Retrieves, but does not remove, the first (first element) of this list.
	int element()
	{
		if(first != null)
			return first.iData;

		return 0;
	}
// -------------------------------------------------------------
// Returns the element at the specified position in this list.
	int get(int index)
	{
	
		// Initialize current and initialize a counter
		Link current = first;
		int count = 0;

		// Scan as many nodes as specified by index
		while(count < index)
		{
			// check to make sure that we have not scanned
			// past the end of the list; if not move 
			// current and increment counter
			if(current != null)
			{
				current = current.next;
				count++;
			}
			else
				return 0;
		}

		// We have reached index
       		if(current != null)
			return current.iData;
                else
                	return 0;
	}	
// -------------------------------------------------------------
	int removeFirst()
	{
		Link temp = first;

		if(first != null)
		{
			first = first.next;
			return temp.iData;
		}
		else
			return 0;
	}

	int size()
	{
		Link curr = first;
		int count = 0;
		
		while (curr != null)
		{
			count++;
			curr = curr.next;
		}
		return count;
	}
	
	int sum()
	{
		Link curr = first;
		int sum = 0;
		
		while (curr != null)
		{
			sum+=curr.iData;
			curr = curr.next;
		}
		return sum;
	}
	
	void removelast()
	{
		if(this.size()<2)
		{
			System.out.println("List should have atleast two elements");
			return;
		}
		Link curr = first;
		
		while (curr.next.next != null)
		{
			curr = curr.next;
			
		}
		curr.next=null;
		System.out.println("Last node deleted");
		
		
	}
	
	public void append(SLLOperations list2)
	{
		if(this.size()<1)
		{
			System.out.println("List should have atleast one element");
			return;
		}
			
      Link current = this.first;       // start at beginning of list
      while(current.next != null)      // until end of list,
      {
        current = current.next;  // move to next link
      }
	  current.next=list2.first;
      System.out.println("");
	}
	
	SLLOperations copy()
	{
		SLLOperations copy=new SLLOperations();
		Link current = first;       // start at beginning of list
		while(current != null)      // until end of list,
         {
			copy.insertLast(current.iData);
			current = current.next;  // move to next link
         }
		System.out.println("");
		return copy;
	}
	SLLOperations sublist(int p,int q)
	{
		int s=this.size();
		if(p>=0 && p<=(s-1) && (q-p)>0 && (q-p)<=(s-3))
		{
			
		SLLOperations sublist=new SLLOperations();
		Link current = first;  
		for(int i=p;i<q;i++)
		{
			sublist.insertLast(this.get(i));
		}
		return sublist;
		}
		return null;
		
	}
	
	SLLOperations concate(SLLOperations list2)
	{
		SLLOperations concate=new SLLOperations();
		Link current = first;       // start at beginning of list
		while(current!= null)      // until end of list,
         {
			concate.insertLast(current.iData);
			current = current.next;  // move to next link
         }
		 //concat.insertLast(current.iData);
		 current=list2.first;
		 while(current!= null)      // until end of list,
         {
			concate.insertLast(current.iData);
			current = current.next;  // move to next link
         }
		System.out.println("");
		return concate;
	}
			
// -------------------------------------------------------------
        public static void main(String[] args) {
	
		SLLOperations L = new SLLOperations();
		
		L.insertFirst(5);
		L.insertFirst(15);
		L.insertFirst(25);
		L.insertFirst(50);
		L.insertLast(30);
		L.insertLast(22);
		
		L.displayList();
		
		//size of list
		System.out.println("Size of the list is:"+L.size());
		
		//sum of elements
		System.out.println("Sum of all the elemtns in the list is:"+L.sum());
		
		//remove last
		L.removelast();

		L.displayList();

		//appendinglist
		SLLOperations L1 = new SLLOperations();
		L1.insertFirst(22);
		L1.insertLast(33);
		L1.insertLast(44);
		L1.insertLast(55);
		System.out.println("List 1:");
		L1.displayList();
		
		SLLOperations L2 = new SLLOperations();
		L2.insertFirst(66);
		L2.insertLast(77);
		L2.insertLast(88);
		L2.insertLast(99);
		System.out.println("List 2:");
		L2.displayList();
		
		System.out.println("New list after concatenation of L1 and L2:");
		SLLOperations concateList=L1.concate(L2);
		concateList.displayList();
		
		System.out.println("Copy of L1:");
		SLLOperations copyList=L1.copy();
		copyList.displayList();
	
		System.out.println("Appended List(L1 and L2):");
		L1.append(L2);
		L1.displayList();
	
		System.out.println("SubList of L1:");
		SLLOperations sublist=L1.sublist(2,4);
		sublist.displayList();
		
		
	}
   }  // end class SLLOperations