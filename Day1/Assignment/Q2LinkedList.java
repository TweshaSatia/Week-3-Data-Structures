package Day1.Assignment;

import java.io.*;
import java.util.Scanner;

public class Q2LinkedList {

	Node head; // head of list

	// Linked list Node.
	static class Node {

		int data;
		Node next;

		// Constructor
		Node(int d)
		{
			data = d;
			next = null;
		}
	}


	public static Q2LinkedList insert(Q2LinkedList list,
									int data)
	{
		Node new_node = new Node(data);
		new_node.next = null;

		// If the Linked List is empty, then make the new node as head
		if (list.head == null) {
			list.head = new_node;
		}
		else {
			// Else traverse till the last node and insert the new_node there
			Node last = list.head;
			while (last.next != null) {
				last = last.next;
			}

			// Insert the new_node at last node
			last.next = new_node;
		}

		// Return the list by head
		return list;
	}

	// Method to print the LinkedList.
	public static void printLinkedList(Q2LinkedList list)
	{
		Node currNode = list.head;

		System.out.print("LinkedList: ");

		// Traverse through the LinkedList
		while (currNode != null) {
		
			System.out.println(currNode.data + " ");

			currNode = currNode.next;
		}
	}

	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int ll=sc.nextInt();
		//Constraint Handling
				if(ll<1 || ll>Math.pow(10, 3)) {
					System.out.println("You need to enter the linked list entries between 1 and 1000");
					System.exit(1);
				}
				
		Q2LinkedList list = new Q2LinkedList();

			for(int i=0;i<ll;i++) {
			list.insert(list, sc.nextInt());
		}
		
		printLinkedList(list);
	}
}

