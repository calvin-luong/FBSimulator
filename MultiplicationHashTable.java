package MicroVersionoFFacebook;

public class MultiplicationHashTable {
	private Node hashTable[];

	public MultiplicationHashTable()
	{
		hashTable = new Node[13];

		for (int i = 0; i < 13; i++)
		{
			hashTable[i] = null;
		}
	}
	
	public int hashCode(Person name)
	{
		double A = (Math.sqrt(5) - 1) / 2;
		int i = (int) (13 * ((name.getK() * A) % 1));
		return i;
	}

	public void chainedHashInsert(Person name)
	{
		Node person = new Node(name);
		
		int i = hashCode(name);

		if (hashTable[i] == null)
		{
			person.setNext(null);
			hashTable[i] = person;
		}
		else
		{
			person.setNext(hashTable[i]);
			hashTable[i] = person;
		}
	}
	
	public void chainedHashSearch(String name)
	{
		Person person = new Person(name, null);
		int i = hashCode(person);
		
		Node current = hashTable[i];
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

	public void chainedHashDelete(Person name)
	{
		int i = hashCode(name);
		
		Node current = hashTable[i];
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

	public void print()
	{
		
		for (int i = 0; i < 13; i++)
		{
			System.out.print("Bucket " + i + ": ");
			Node current = hashTable[i];
			
			while (current != null)
			{
				System.out.print(current.getPerson().getName() + " >> ");
				current = current.getNext();
			}
			
			System.out.println();
		}
	}
}
