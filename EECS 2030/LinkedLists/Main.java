
public class Main {
	public static void main(String[] args)
	{
		SimpleLinkedList<Character> s = new SimpleLinkedList<Character>();
		s.add('a');
		s.add('b');
		s.add('c');
		s.add('d');
		s.removeNode(s.getNode(2));
		
		System.out.println(s);
		
	}
}
