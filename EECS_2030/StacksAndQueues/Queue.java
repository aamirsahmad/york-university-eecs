import java.util.LinkedList;

public class Queue<E> {
	private LinkedList<E> queue;
	
	public Queue()
	{
		queue = new LinkedList<E>();
	}
	
	public void enqueue(E element)
	{
		queue.addLast(element);
	}
	
	public E dequeue()
	{
		return queue.removeFirst();
	}
	
	public boolean isEmpty()
	{
		return queue.size() == 0;
	}
	
	@Override
	public String toString()
	{
		return queue.toString();
	}
}
