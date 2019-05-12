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
	
	public static void main(String args[])
	{
		DivisionHashFunction divHashFunction = new DivisionHashFunction();
		Node divHashTable[] = new Node[13];
		Person p1 = new Person("calvin", null);
		Person p2 = new Person("jasmine", null);
		Person p3 = new Person("calvin", null);
		Person p4 = new Person(")", null);
		Person p5 = new Person("jasmine", null);
		
		divHashFunction.chainedHashInsert(divHashTable, p1);
		divHashFunction.chainedHashInsert(divHashTable, p2);
		//divHashFunction.chainedHashInsert(divHashTable, p3);
		divHashFunction.chainedHashInsert(divHashTable, p4);
		divHashFunction.chainedHashInsert(divHashTable, p5);
		
		divHashFunction.print(divHashTable);
		
		divHashFunction.chainedHashDelete(divHashTable, p1);
		divHashFunction.chainedHashDelete(divHashTable, p4);
		
		divHashFunction.print(divHashTable);
		
	}
}
