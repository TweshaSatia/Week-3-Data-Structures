package Day2.Practice;
//Linked list use case instead of array to store elements and perform operations in queue.
class LinkedQueue {
	// -------------------------------------------------------------
	class Link {
		public int data;
		public Link next;
		public Link(int dt) {
			this.data = dt;
			next = null;
		}
		
	public void displayLink()      // display ourself
    {
      System.out.print("{" + data + "} ");
    }
	}
	// -------------------------------------------------------------
	private Link front, rear;
	private int currSize;
	public LinkedQueue() {
		front = rear = null;
	}

	public void insert(int d) {
		Link newLink = new Link(d);
		if (front == null) {
			front = newLink;
			rear = newLink;
		} else {
			rear.next = newLink;
			rear = newLink;
		}
		currSize++;
	}

	public int remove() {
		int temp = -1;
		if (!isEmpty()) {
			temp = front.data;
			front = front.next;
		}
		currSize--;
		return temp;
	}

	public static void reverse(LinkedQueue que) {
		if (!que.isEmpty()) {
			int curr = que.remove();
			reverse(que);
			que.insert(curr);
		}
	}

	public Queue toArrayQueue() {
		Queue q = new Queue(currSize);
		int i = 0;
		Link curr = front;
		while (curr != null) {
			q.insert(curr.data);
			curr = curr.next;
		}
		return q;
	}

	public int peek() {
		return front.data;
	}

	public boolean isEmpty() {
		return currSize == 0;
	}

	public int size() {
		return currSize;
	}
	public void display()
	{
		if(isEmpty())
		{
			System.out.println("Queue is empty");
			return;
		}
		System.out.println("Elements in queue:");
		Link current = front;       // start at beginning of list
		while(current != null)      // until end of list,
		{
			current.displayLink();   // print data
			current = current.next;  // move to next link
		}
      System.out.println("");
	}
}

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
	public void insert(int item) { // put item at rear of queue
		if (rear == maxSize - 1)      // deal with wraparound
			rear = -1;

		queArray[++rear] = item;         // increment rear and insert
		nItems++;                     // one more item
	}
	public int remove() {       // take item from front of queue
		int temp = queArray[front++]; // get value and incr front
		if (front == maxSize)          // deal with wraparound
			front = 0;
		nItems--;                      // one less item
		return temp;
	}
	public static void reverse(Queue q) {

		if (!q.isEmpty()) {
			int temp = q.remove();
			reverse(q);
			q.insert(temp);
		}
		System.out.println("Reversed queue:");
	}
	public int peek() {    // peek at front of queue
		return queArray[front];
	}
	public boolean isEmpty() {  // true if queue is empty
		return (nItems == 0);
	}
	public boolean isFull() {   // true if queue is full
		return (nItems == maxSize);
	}
	public int size() {         // number of items in queue
		return nItems;
	}
}
class LinkedQueueApp {
	public static void main(String[] args) {
		LinkedQueue q = new LinkedQueue();
		q.insert(10);
		q.insert(20);
		q.insert(30);
		q.insert(40);
		q.display();
		q.remove();
		q.insert(50);
		q.insert(60);
		q.remove();
		q.remove();
		System.out.println("After removal:");
		q.display();

		System.out.println("size : " + q.size());
		System.out.println("peek : " + q.peek());

		Queue qArr = q.toArrayQueue();
		while ( !qArr.isEmpty() ) {
			long n = qArr.remove();
			System.out.print(n);
			System.out.print(" ");
		}
		System.out.println(" ");
		System.out.println("Reversed queue:");
		LinkedQueue.reverse(q);
		Queue qArr2 = q.toArrayQueue();
		while ( !qArr2.isEmpty() ) {
			long n = qArr2.remove();
			System.out.print(n);
			System.out.print(" ");
		}
		System.out.println(" ");
	}
}