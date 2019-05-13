package MicroVersionoFFacebook;

public class Node {
	
	private Person person;
	private Node next;
	
	public Node(Person name)
	{
		this.person = name;
		setNext(null);
	}
	
	public Node getNext()
	{
		return next;
	}
	
	public void setNext(Node next)
	{
		this.next = next;
	}
	
	public Person getPerson()
	{
		return person;
	}
	
	public void setNode(Person name)
	{
		this.person = name;
	}
}
