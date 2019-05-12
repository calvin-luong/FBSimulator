package MicroVersionoFFacebook;

import java.util.Scanner;

public class Simulator {

	
	
	public static void main (String args[])
	{
		DivisionHashFunction divHashFunction = new DivisionHashFunction();
		MultiplicationHashFunction multiHashFunction = new MultiplicationHashFunction();
		Node divHashTable[] = new Node[13];
		Node multiHashTable[] = new Node[13];
		
		Scanner scan = new Scanner(System.in);
		String friend = "";

		while (!friend.equals("q"))
		{
			System.out.println("Which friend would you like to add?");
			friend = scan.next();

			Person p = new Person(friend, null);
			divHashFunction.chainedHashInsert(divHashTable, p);
			multiHashFunction.chainedHashInsert(multiHashTable, p);
		}
		
		divHashFunction.print(divHashTable);
		multiHashFunction.print(multiHashTable);
	}

}
