package MicroVersionoFFacebook;

public class MultiplicationHashFunction {

	public int hashCode(Person name)
	{
		double A = (Math.sqrt(5) - 1) / 2;
		int i = (int) (13 * ((name.getK() * A) % 1));
		return i;
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

	public Person chainedHashSearch(Node A[], String name)
	{
		Person person = new Person(name, null);
		int i = hashCode(person);

		Node current = A[i];
		while (current != null)
		{
			if (current.getPerson().getName().equals(person.getName()))
			{
				return current.getPerson();
			}

			current = current.getNext();
		}
		
		return null;
	}

	public void chainedHashDelete(Node A[],Person name)
	{
		int i = hashCode(name);

		Node prev = A[i];
		Node current = A[i].getNext();

		// If there is only one user
		if (prev.getPerson().getName().equals(name.getName()))
		{
			A[i] = current;
		}
		
		else
		{
			while (current != null)
			{
				if (current.getPerson().getName().equals(name.getName()))
				{
					prev.setNext(current.getNext());
				}

				prev = prev.getNext();
				current = current.getNext();
			}
		}
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
