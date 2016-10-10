import java.util.ArrayList;

public class StackAL<E> {
	private ArrayList<E> stack;
	
	public StackAL()
	{
		stack = new ArrayList<E>();
	}
	
	public void push(E element)
	{
		stack.add(element);
	}
	
	public E pop()
	{
		return stack.remove(stack.size()-1);
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
