
import java.util.NoSuchElementException;
import java.util.AbstractSequentialList;
import java.util.List;
import java.util.ListIterator;

public class SimpleLinkedList<T> extends AbstractSequentialList<T> implements List<T> {

	
	///////////////////////////////////////////////////////////////////
	private static final class Node<T> {
		private T data; //data holder for the node
		private Node<T> next; //link to the next node
		private Node<T> previous; //link to the previous node

		public Node(T data) { 
			this.data = data;
			this.next = null;
		}
		
		@Override public String toString() { 
			return super.toString() + " [data: " + data.toString() + "]"; 
		}
		
	}
	///////////////////////////////////////////////////////////////////
	private final class LinkedListItr<I> implements ListIterator<I> {
		private Node<I> next;
		private Node<I> previous;
		// Node that will be affected by remove() or set().
		private Node<I> lastReturned;
		// Index of next
		private int position;

		// Initialize the iterator at the given index
		LinkedListItr(int index) {
			if (index == size) {
				next = null;
				previous = (Node<I>) last;
			} else {
				next = (Node<I>) getNode(index);
				previous = next.previous;
			}
			position = index;
		}

		// Returns the index of the next element.
		public int nextIndex() {
			return position;
		}

		// Returns the index of the previous element.
		public int previousIndex() {
			return position - 1;
		}

		// Returns true if more elements exist via next.
		public boolean hasNext() {
			return (next != null);
		}

		// Returns true if more elements exist via previous.
		public boolean hasPrevious() {
			return (previous != null);
		}

		// Returns the next element.
		public I next() {
			if (next == null)
				throw new NoSuchElementException();
			position++;
			lastReturned = previous = next;
			next = lastReturned.next;
			return lastReturned.data;
		}

		// Returns the previous element.
		public I previous() {
			if (previous == null)
				throw new NoSuchElementException();
			position--;
			lastReturned = next = previous;
			previous = lastReturned.previous;
			return lastReturned.data;
		}

		// Remove the most recently returned element from the list.
		public void remove() {
			if (lastReturned == null)
				throw new IllegalStateException();

			// Adjust the position to before the removed element, if the element
			// being removed is behind the cursor.
			if (lastReturned == previous)
				position--;

			next = lastReturned.next;
			previous = lastReturned.previous;
			removeNode((Node<T>) lastReturned);

			lastReturned = null;
		}

		// Adds an element between the previous and next, and move to next
		public void add(I o) {
			size++;
			position++;
			Node<I> e = new Node<I>(o);
			e.previous = previous;
			e.next = next;

			if (previous != null)
				previous.next = e;
			else
				head = (Node<T>) e;

			if (next != null)
				next.previous = e;
			else
				last = (Node<T>) e;

			previous = e;
			lastReturned = null;
		}

		// Changes the contents of the element most recently returned.
		public void set(I o) {
			if (lastReturned == null)
				throw new IllegalStateException();
			lastReturned.data = o;
		}
	} // inner class LinkedListItr ends
    //////////////////////////////////////////////////////////////////////


	//get the Node at the given index 
	Node<T> getNode(int index) {
		Node<T> e = head;
	
		while (index-- > 0)
			e = e.next;
		
		return e;
	}

	

	@Override
	public ListIterator<T> listIterator(int index) {
		return new LinkedListItr<T>(index);
	}

	@Override
	public int size() {
		return size;
	}
	
	//size of the list
	private int size = 0;
	//head node in the list (e.g. first node) 
	private Node<T> head = null;
	//last node in the list
	private Node<T> last = null;

	//add a new node to end of the list
	public boolean add(T data) {
		Node<T> newNode = new Node<T>(data);
		
		if(size == 0)
		{
			head = last = newNode;
		}
		else
		{
			newNode.previous = last;
			last.next = newNode;
			last = newNode;
		}
		size++;
		return true;
	}
	
	public void removeNode(Node<T> e) {	
		if(size == 0)
			throw new NoSuchElementException();
		
		size--;
		if(size == 0)
		{
			head = last = null;
		}
		else
		{
			if(e == head)
			{
				head = e.next;
				head.previous = null;
			}
			else if(e == last)
			{
				last = e.previous;
				last.next = null;
			}
			else
			{
				Node<T> n = e.next;
				Node<T> p = e.previous;
				n.previous = p;
				p.next = n;
			}
		}
		
	}


	//You are given a partial implementation for a very SimpleLinkedList class (first in first out style).
	//-SimpleLinkedList class has a fully implemented inner Node class. No need to change it.
	//-SimpleLinkedList class has a fully implemented inner LinkedListItr class. No need to change it.
	//-Your task is to implement the "public  boolean add(T data) method without changing the other codes.
	//-This method adds an element to the end of the list with a generic data of type T. It return true on a successful add.
	//-Make sure to update all the links to the previous node and next node upon adding a new node. Also update the head and last nodes in the list (if needed).
	//-Your other task is to implement the "public  void removeNode(Node<T> e) method without changing the other codes.
	//-This method removes an element from the list. "e" is the node to be removed from the list.
	//-You can safely assume that the given node "e" does exist in the list.
	//-Make sure to cover cases that the given node is located at the head of the list (e.g. first node).
	//-Make sure to cover cases that the given node is located at the end of the list (e.g. last node).
	//-Make sure to cover cases that the given node is located in an arbitrary location in the list (e.g. any place other than head and last nodes).
	//-Please make sure your code compiles, otherwise you will get zero.
	
}
