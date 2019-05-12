package MicroVersionoFFacebook;

public class DivisionHashFunction {

	public int hashCode(Person name)
	{
		return name.getK() % 13;
	}

	public void chainedHashInsert(Node A[], Person name)
	{
		Node person = new Node(name);
		
		int i = hashCode(name);

		if (A[i] == null)
		{
			person.setNext(null);
			A[i] = person;
		}
		else
		{
			person.setNext(A[i]);
			A[i] = person;
		}
	}
	
	public void chainedHashSearch(Node A[], String name)
	{
		Person person = new Person(name, null);
		int i = hashCode(person);
		
		Node current = A[i];
		while (current != null)
		{
			if (current.getPerson().getName().equals(person.getName()))
			{
				System.out.println("Found");
				return;
			}

			current = current.getNext();
		}
		
		System.out.println("Not found");
	}

	public void chainedHashDelete(Node A[],Person name)
	{
		int i = hashCode(name);
		
		Node current = A[i];
		while (current != null)
		{
			if (current.getPerson().getName().equals(name.getName()))
			{
				break;
			}

			current = current.getNext();
		}
		current.deleteNode();
	}

	public void print(Node A[])
	{
		
		for (int i = 0; i < 13; i++)
		{
			System.out.print("Bucket " + i + ": ");
			Node current = A[i];
			
			while (current != null)
			{
				System.out.print(current.getPerson().getName() + " >> ");
				current = current.getNext();
			}
			
			System.out.println();
		}
	}
}
