import java.util.LinkedList;

public class StackLL<E> {
	private LinkedList<E> stack;
	
	public StackLL()
	{
		stack = new LinkedList<E>();
	}
	
	public void push(E element)
	{
		stack.addFirst(element);
	}
	
	public E pop()
	{
		return stack.removeFirst();
	}
	
	public boolean isEmpty()
	{
		return stack.size() == 0;
	}
	
	@Override
	public String toString()
	{
		return stack.toString();
	}
}
