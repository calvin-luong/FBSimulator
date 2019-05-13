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

		if (current.getPerson().getName().equals(n.getPerson().getName()))
		{
			head = current.getNext();
		}

		else
		{
			while (current != null)
			{
				if (current.getNext().getPerson().getName().equals(n.getPerson().getName()))
				{
					current.setNext(current.getNext().getNext());
				}

				current = current.getNext();
			}
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
}
