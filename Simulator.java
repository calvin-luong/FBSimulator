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
		
		// Adding users into the data base
		String user = "";
		while (!user.equals("q"))
		{
			System.out.println("Which friend would you like to add?");
			user = scan.next();

			if (!user.equals("q"))
			{
				Person p = new Person(user, new LinkedList());
				divHashFunction.chainedHashInsert(divHashTable, p);
				multiHashFunction.chainedHashInsert(multiHashTable, p);
			}
		}

		// Looking at the Hash Tables
		System.out.println("Enter 'd' to see the Division Hash Table.");
		System.out.println("Enter 'm' to see the Multiplication Hash Table.");
		String tableInput = scan.next().toLowerCase();

		if (tableInput.equals("d"))
		{
			divHashFunction.print(divHashTable);
		}
		else if (tableInput.equals("m"))
		{
			multiHashFunction.print(multiHashTable);
		}
		
		// Adding friends
		System.out.println("Which person would you like to add friends to?");
		String person = scan.next();
		System.out.println("Who would you like to add?");
		String person2 = scan.next();
		
		divHashFunction.chainedHashSearch(divHashTable, person).addFriend(divHashFunction.chainedHashSearch(divHashTable, person2));
		divHashFunction.chainedHashSearch(divHashTable, person2).addFriend(divHashFunction.chainedHashSearch(divHashTable, person));
		
		divHashFunction.chainedHashSearch(divHashTable, person).printFriendsList();
		divHashFunction.chainedHashSearch(divHashTable, person2).printFriendsList();
		
		// Deleting 
		System.out.println("Which user would you like to delete?");
		String deletedUser = scan.next();
		
		divHashFunction.chainedHashDelete(divHashTable, divHashFunction.chainedHashSearch(divHashTable, deletedUser));
		divHashFunction.print(divHashTable);
	}

}
