package Day3.Practice;
import java.io.*;
////////////////////////////////////////////////////////////////
//enable having both int and string data to be stored,find,delete and show in the same HashTable.
class Link
{ // (could be other items)
	private int iData; // data item
	private String sData;
	public Link next; // next link in list
	// -------------------------------------------------------------
	public Link(int it) // constructor
	{ iData= it; }
	public Link(String st) // constructor
	{ sData= st; }
	// -------------------------------------------------------------
	public int getIntKey()
	{ return iData; }
	
	public String getStringKey()
	{ return sData; }
	// -------------------------------------------------------------
	public void displayLink() // display this link
	{ 
		if(sData!=null)
			System.out.print(sData + " "); 
		else
			System.out.print(iData + " ");
	}
} // end class Link
////////////////////////////////////////////////////////////////
class SortedList
{
	private Link first; // ref to first list item
	// -------------------------------------------------------------
	public void SortedList() // constructor
	{ first = null; }
	// -------------------------------------------------------------
	public void insert(Link theLink) // insert link, in order
	{
		if(theLink.getStringKey()!=null)
		{
			String key = theLink.getStringKey();
			Link previous = null; // start at first
			Link current = first;
			// until end of list,
			while( current != null && current.getStringKey() != null && key.compareTo(current.getStringKey()) >= 0)
			{ // or current > key,
				if(key.equals(current.getStringKey()))
				{
					System.out.println("Key already present");
					return;
				}
				previous = current;
				current = current.next; // go to next item
			}
			if(previous==null) // if beginning of list,
				first = theLink; // first --> new link
			else // not at beginning,
				previous.next = theLink; // prev --> new link
			theLink.next = current;
			//System.out.println("Key "+key+" inserted" );
		}
		else
		{
			int key = theLink.getIntKey();
			Link previous = null; // start at first
			Link current = first;
			// until end of list,
			while( current != null && key >= current.getIntKey() )
			{ // or current > key,
				if(key == current.getIntKey())
				{
					System.out.println("Key already present");
					return;
				}
				previous = current;
				current = current.next; // go to next item
			}
			if(previous==null) // if beginning of list,
				first = theLink; // first --> new link
			else // not at beginning,
				previous.next = theLink; // prev --> new link
			theLink.next = current; // new link --> current
			//System.out.println("Key "+key+" inserted" );
		}
	} // end insert()
	// -------------------------------------------------------------
	public void delete(int key)
	{
		if(first!=null)
		{
			if(first.getIntKey() == key) //first link
			{
				first = first.next;
				System.out.println("Deleted");
				return;
			}
			Link previous = first;
			Link current = first.next; // start at second link
			// until end of list,
			while(current != null && current.getIntKey() <= key)
			{ // or key too small,
				if(current.getIntKey() == key) // is this the link?
				{
					previous.next = current.next;
					System.out.println("Deleted");
					return;
				}
				previous = current;
				current = current.next; // go to next item
			}
		}
		System.out.println("Key not found"); // didn't find it
	}
	
	public void delete(String key) // delete 
	{ 
		if(first!=null)
		{
			if(key.equals(first.getStringKey())) //first link
			{
				first = first.next;
				System.out.println("Deleted");
				return;
			}
			Link previous = first;
			Link current = first.next; // start at second link
			// until end of list,
			while(current != null && current.getStringKey()!=null && key.compareTo(current.getStringKey()) >=0)
			{ // or key too small,
				if(key.equals(current.getStringKey())) // is this the link?
				{
					previous.next = current.next;
					System.out.println("Deleted");
					return;
				}
				previous = current;
				current = current.next; // go to next item
			}
		}
		System.out.println("Key not found"); // didn't find it
	} // end delete()
	// -------------------------------------------------------------
	public Link find(int key) // find link
	{
	Link current = first; // start at first
	// until end of list,
	while(current != null && current.getIntKey() <= key)
	{ // or key too small,
		if(current.getIntKey() == key) // is this the link?
			return current; // found it, return link
		current = current.next; // go to next item
	}
	return null; // didn't find it
	} // end find()
	// -------------------------------------------------------------
	public Link find(String key) // find link
	{
	Link current = first; // start at first
	// until end of list,
	while(current != null && current.getStringKey()!=null && key.compareTo(current.getStringKey()) >=0 )
	{ // or key too small,
		if(key.equals(current.getStringKey())) // is this the link?
			return current; // found it, return link
		current = current.next; // go to next item
	}
	return null; // didn't find it
	} // end find()
	// -------------------------------------------------------------
	public void displayList()
	{
		System.out.print("List (first-->last): ");
		Link current = first; // start at beginning of list
		while(current != null) // until end of list,
		{
			current.displayLink(); // print data
			current = current.next; // move to next link
		}
		System.out.println("");
	}
} // end class SortedList
////////////////////////////////////////////////////////////////
class HashTable
{
	private SortedList[] hashArray; // array of lists
	private int arraySize;
	// -------------------------------------------------------------
	public HashTable(int size) // constructor
	{
		arraySize = size;
		hashArray = new SortedList[arraySize]; // create array
		for(int j=0; j<arraySize; j++) // fill array
			hashArray[j] = new SortedList(); // with lists
	}
	// -------------------------------------------------------------
	public void displayTable()
	{
		for(int j=0; j<arraySize; j++) // for each cell,
		{
			System.out.print(j + ". "); // display cell number
			hashArray[j].displayList(); // display list
		}
	}
	// -------------------------------------------------------------
	public int hashFunc(int key) // hash function
	{
		return key % arraySize;
	}
	// -------------------------------------------------------------
	public void insert(Link theLink) // insert a link
	{
		int key;
		if(theLink.getStringKey()!=null)
		{
			key = theLink.getStringKey().hashCode();
		}
		else
		{
			key = theLink.getIntKey();
		}
		int hashVal = hashFunc(key); // hash the key
		hashArray[hashVal].insert(theLink); // insert at hashVal
	} // end insert()
	// -------------------------------------------------------------
	public void delete(Link theLink) // delete a link
	{
		int key;
		if(theLink.getStringKey()!=null)
		{
			key = theLink.getStringKey().hashCode();
			int hashVal = hashFunc(key); // hash the key
			hashArray[hashVal].delete(theLink.getStringKey()); // delete link
		}
		else
		{
			key = theLink.getIntKey();
			int hashVal = hashFunc(key); // hash the key
			hashArray[hashVal].delete(theLink.getIntKey()); // delete link
		}
		
	} // end delete()
	// -------------------------------------------------------------
	public Link find(Link theLink) // find link
	{
		int key;
		Link link;
		if(theLink.getStringKey()!=null)
		{
			key = theLink.getStringKey().hashCode();
			int hashVal = hashFunc(key); // hash the key
			link = hashArray[hashVal].find(theLink.getStringKey()); // find link
		}
		else
		{
			key = theLink.getIntKey();
			int hashVal = hashFunc(key); // hash the key
			link = hashArray[hashVal].find(theLink.getIntKey()); // find link
		}
		return link; // return link
	}
	// -------------------------------------------------------------
} // end class HashTable
////////////////////////////////////////////////////////////////
class HashTable_Int_String
{
	public static void main(String[] args) throws IOException
	{
		int aKey;
		Link aDataItem;
		int size, n, keysPerCell = 100,ch;
		// get sizes
		System.out.print("Enter size of hash table: ");
		size = getInt();
		System.out.print("Enter initial number of items: ");
		n = getInt();
		// make table
		HashTable theHashTable = new HashTable(size);
		for(int j=0; j<n; j++) // insert data
		{
			aKey = (int)(java.lang.Math.random() *
			keysPerCell * size);
			aDataItem = new Link(aKey);
			theHashTable.insert(aDataItem);
		}
		while(true) // interact with user
		{
			System.out.print("Enter first letter of ");
			System.out.print("show, insert, delete, or find: ");
			char choice = getChar();
			switch(choice)
			{
			case 's':
				theHashTable.displayTable();
				break;
			case 'i':
				System.out.print("Enter 1 for integer and 2 for string: ");
				ch= getInt();
				if(ch==1)
				{
					System.out.println("Enter key value to insert:");
					aKey = getInt();
					aDataItem = new Link(aKey);
				}
				else if(ch == 2)
				{
					System.out.println("Enter key value to insert:");
					String skey = getString();
					aDataItem = new Link(skey);
				}
				else
				{
					System.out.println("Invalid input");
					break;
				}
				theHashTable.insert(aDataItem);
				break;
			case 'd':
				System.out.print("Enter 1 for integer and 2 for string: ");
				ch= getInt();
				if(ch==1)
				{
					System.out.println("Enter key value to delete:");
					aKey = getInt();
					aDataItem = new Link(aKey);
				}
				else if(ch == 2)
				{
					System.out.println("Enter key value to delete:");
					String skey = getString();
					aDataItem = new Link(skey);
				}
				else
				{
					System.out.println("Invalid input");
					break;
				}
				theHashTable.delete(aDataItem);
				break;
			case 'f':
				System.out.print("Enter 1 for integer and 2 for string: ");
				ch= getInt();
				if(ch==1)
				{
					System.out.println("Enter key value to find:");
					aKey = getInt();
					aDataItem = new Link(aKey);
				}
				else if(ch == 2)
				{
					System.out.println("Enter key value to find:");
					String skey = getString();
					aDataItem = new Link(skey);
				}
				else
				{
					System.out.println("Invalid input");
					break;
				}
				Link dataItem = theHashTable.find(aDataItem);
				if(dataItem != null)
					System.out.println("Found ");
				else
					System.out.println("Could not find ");
				break;
			default:
				System.out.print("Invalid entry\n");
			} // end switch
		} // end while
	} // end main()
	//--------------------------------------------------------------
	public static String getString() throws IOException
	{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}
	//-------------------------------------------------------------
	public static char getChar() throws IOException
	{
		String s = getString();
		return s.charAt(0);
	}
	//-------------------------------------------------------------
	public static int getInt() throws IOException
	{
		String s = getString();
		return Integer.parseInt(s);
	}
//--------------------------------------------------------------
}