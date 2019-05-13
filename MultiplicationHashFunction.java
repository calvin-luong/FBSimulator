package MicroVersionoFFacebook;

public class MultiplicationHashFunction {

	public int hashCode(Person name)
	{
		double A = (Math.sqrt(5) - 1) / 2;
		int i = (int) (13 * ((name.getK() * A) % 1));
		return i;
	}

	public void chainedHashAdd(Node A[], Person name)
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

	public void chainedHashInsert(Node A[], String name, String friend)
	{
		Person person = new Person(name, null);
		Person targetFriend = new Person(friend, null);
		
		int i = hashCode(person);

		Node current = A[i];
		while (current != null)
		{
			if (current.getPerson().getName().equals(person.getName()))
			{
				current.getPerson().addFriend(targetFriend);
			}

			current = current.getNext();
		}
	}

	public void chainedHashSearch(Node A[], String user, String friend)
	{
		Person person = new Person(user, null);
		Person targetFriend = new Person(friend, null);

		int i = hashCode(person);
		int j = hashCode(targetFriend);

		boolean found1 = false;
		boolean found2 = false;

		Node current = A[i];
		while (current != null)
		{
			if (current.getPerson().getName().equals(person.getName()))
			{
				if (current.getPerson().searchFriend(targetFriend) == true)
				{
					found1 = true;
				}
			}

			current = current.getNext();
		}
		
		current = A[j];
		
		while (current != null)
		{
			if (current.getPerson().getName().equals(targetFriend.getName()))
			{
				if (current.getPerson().searchFriend(person) == true)
				{
					found2 = true;
				}
			}

			current = current.getNext();
		}
		
		if (found1 == true && found2 == true)
		{
			System.out.println("Yes.");
		}
		else
		{
			System.out.println("No.");
		}
	}

	public void chainedHashDelete(Node A[], String name, String friend)
	{
		Person person = new Person(name, null);
		Person targetFriend = new Person(friend, null);
		
		int i = hashCode(person);

		Node current = A[i];
		while (current != null)
		{
			if (current.getPerson().getName().equals(person.getName()))
			{
				current.getPerson().deleteFriend(targetFriend);
			}

			current = current.getNext();
		}
	}
	
	public Person findPerson(Node A[], String name)
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
