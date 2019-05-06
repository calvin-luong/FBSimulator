package MicroVersionoFFacebook;

public class Person {
	private DivisionHashTable friendsList;
	private String name;
	private int k;
	
	public static void main (String args[])
	{
		DivisionHashTable table = new DivisionHashTable();
		Person calvin = new Person("calvin", table);
		System.out.println(calvin.k);
	}
	
	public Person(String name, DivisionHashTable friendsList)
	{
		this.name = name;
		this.friendsList = friendsList;
		nameToInt();
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getK()
	{
		return k;
	}
	
	public void nameToInt()
	{
		int result = 0;
		for (int i = 0; i < name.length(); i++)
		{
			char character = name.charAt(i);
			result = result + character;
		}
		
		k = result;
	}
}
