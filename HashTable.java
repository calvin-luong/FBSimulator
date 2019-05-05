package MicroVersionoFFacebook;

public class HashTable {

	private LinkedList hashTable[];
	
	public HashTable()
	{
		hashTable = new LinkedList[13];

		for(int i = 0; i < hashTable.length; i++)
		{
			hashTable[i] = new LinkedList();
		}
	}

	public int divisionHashCode(Person name)
	{
		return name.getK() % 13;
	}
	
	public void chainedHashInsert(Person name)
	{
		int j = divisionHashCode(name);
		hashTable[j].add(name);
	}
	
	public void chainedHashDelete(Person name)
	{
		int j = divisionHashCode(name);
		hashTable[j].delete(name);
	}
	
	public Node chainedHashSearch(Person name)
	{
		int j = divisionHashCode(name);
		Node found = hashTable[j].findPerson(name);
		System.out.println(found.getPerson().getName());
		return found;
	}
	
	public void printElements()
	{
		for (int i = 0; i < 5; i++)
		{
			hashTable[i].print();
		}
	}
	
	public static void main (String args[])
	{
		Person test = new Person("a");
		Person test1 = new Person("b");
		Person test2 = new Person("a");
		
		HashTable table = new HashTable();
		table.chainedHashInsert(test);
		table.chainedHashInsert(test1);
		table.chainedHashInsert(test2);
		
		//table.printElements();
		
		System.out.println(table.divisionHashCode(test1));
	}
}
