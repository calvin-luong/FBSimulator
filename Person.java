package MicroVersionoFFacebook;

public class Person {
	private LinkedList friendsList;
	private String name;
	private int k;

	public Person(String name, LinkedList friendsList)
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
	
	public void addFriend(Person p)
	{
		friendsList.insert(p);
	}
	
	public void deleteFriend(Person p)
	{
		friendsList.delete(p);
	}
	
	public boolean searchFriend(Person p)
	{
		return friendsList.findNode(p);
	}
	
	public void printFriendsList()
	{
		System.out.print(name + "'s friends: ");
		friendsList.print();
		System.out.println();
	}
}
