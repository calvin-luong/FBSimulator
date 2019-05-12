package MicroVersionoFFacebook;

public class LinkedList {

	private Node head;

	public void insert(Person p)
	{
		Node n = new Node(p);

		if (head == null)
		{
			head = n;
			n.setNext(null);
		}
		else
		{
			n.setNext(head);
			head = n;
		}

	}

	public boolean findNode(Person p)
	{

		Node n = new Node(p);

		Node current = head;

		while (current != null)
		{
			if (current.getPerson().getName().equals(n.getPerson().getName()))
			{
				return true;
			}

			current = current.getNext();
		}

		return false;

	}

	public void delete(Person p)
	{
		Node n = new Node(p);

		Node current = head;

		while (current != null)
		{
			if (current.getNext().getPerson().getName().equals(n.getPerson().getName()))
			{
				current.setNext(current.getNext().getNext());
			}

			current = current.getNext();
		}
	}

	public void print()
	{
		Node current = head;

		while (current != null)
		{
			System.out.print(current.getPerson().getName() + " ");

			current = current.getNext();
		}
	}

	public static void main (String args[])
	{
		LinkedList list = new LinkedList();

		Person p1 = new Person("Jasmine", new LinkedList());
		Person p2 = new Person("Calvin", new LinkedList());
		Person p3 = new Person("Ashley", new LinkedList());

		list.insert(p1);
		list.insert(p2);
		list.insert(p3);

		list.print();
	}
}
