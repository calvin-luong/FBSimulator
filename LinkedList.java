package MicroVersionoFFacebook;

public class LinkedList {
	
	private static Node head;
	private Node tail;
	
	public void add(Person name)
	{
		Node person = new Node(name);
		
		if (head == null)
		{
			head = person;
		}
		else
		{
			Node empty = head;
			while (empty.getNext() != null)
			{
				empty = empty.getNext();
			}
			
			empty.setNext(person);
		}
	}
	
	public Node findPerson(Person name)
	{
		Node current = head;
		
		while (current != null)
		{
			if (current.getPerson().getName().equals(name.getName()))
			{
				return current;
			}
			
			current = current.getNext();
		}
		
		return null;
	}
	
	public void delete(Person name)
	{
		Node delete = findPerson(name);
		delete.deleteNode();
	}
	
	public static void print()
	{
		Node current = head;
		
		while (current != null)
		{
			System.out.println(current.getPerson().getName());
			current = current.getNext();
		}
	}
	
	public static void main(String args[])
	{
		LinkedList test = new LinkedList();
		Person brian = new Person("Brian");
		Person calvin = new Person("calvin");
		Person tuyen = new Person("tuyen");
		
		test.add(brian);
		test.add(calvin);
		test.add(tuyen);
		
		test.print();
		
		test.delete(brian);
		test.print();
	}
}
