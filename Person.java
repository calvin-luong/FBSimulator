package MicroVersionoFFacebook;

public class Person {
	private LinkedList friendsList;
	private String name;
	private int k;
	
	public static void main (String args[])
	{
		Person calvin = new Person("calvin");
		System.out.println(calvin.k);
	}
	
	public Person(String name)
	{
		this.name = name;
		friendsList = new LinkedList();
		nameToInt();
	}
	
	public void getFriends()
	{
		friendsList.print();
	}
	
	public void addFriend(Person name)
	{
		friendsList.add(name);
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
