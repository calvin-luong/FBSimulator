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

		int command = 0;

		while (command != 8)
		{
			// Adding users into the data base
			if (command == 1)
			{
				String user = "";
				while (!user.equals("q"))
				{
					System.out.println("Which friend would you like to add?");
					System.out.println("Enter 'q' to stop adding users.");
					user = scan.next();

					if (!user.equals("q"))
					{
						Person p = new Person(user, new LinkedList());
						Person p2 = new Person(user, new LinkedList());
						divHashFunction.chainedHashAdd(divHashTable, p);
						multiHashFunction.chainedHashInsert(multiHashTable, p2);
					}
				}
			}

			if (command == 3)
			{
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
			}

			if (command == 4)
			{
				System.out.println("Which person would you like to add friends to?");
				String user1 = scan.next();
				System.out.println("Who would you like to add?");
				String user2 = scan.next();

				divHashFunction.chainedHashInsert(divHashTable, user1, user2);
				divHashFunction.chainedHashInsert(divHashTable, user2, user1);
			}

			if (command == 5)
			{
				System.out.println("Which person would you like to remove friends from?");
				String user1 = scan.next();
				Person temp1 = new Person(user1, null);
				System.out.println("Who would you like to delete?");
				String user2 = scan.next();
				Person temp2 = new Person(user2, null);
				
				divHashFunction.chainedHashDelete(divHashTable, temp1, temp2);
				divHashFunction.findPerson(divHashTable, user1).printFriendsList();
			}

			if (command == 6)
			{
				System.out.println("Who's friend list would you like to look at?");
				String user = scan.next();
				divHashFunction.findPerson(divHashTable, user).printFriendsList();
			}

			if (command == 7)
			{
				System.out.println("Please enter person 1.");
				String user1 = scan.next();
				System.out.println("Please enter person 2.");
				String user2 = scan.next(); 

				if (divHashFunction.findPerson(divHashTable, user1) != null && divHashFunction.findPerson(divHashTable, user2) != null)
				{
					divHashFunction.chainedHashSearch(divHashTable, user1, user2);

				}
				else
				{
					System.out.println("One of the inputed users does not exist.");
				}

			}

			System.out.println("----------------------------------------");
			System.out.println("Welcome to the Micro Version of Facebook");
			System.out.println("----------------------------------------");
			System.out.println("Press 1 to add users into the data base.");
			System.out.println("Press 2 to delete users from the data base.");
			System.out.println("Press 3 to look at the users in the data base.");

			System.out.println("Press 4 to add friends into a user's friend list.");
			System.out.println("Press 5 to delete friends from a user's friend list.");
			System.out.println("Press 6 to look at a user's friend list.");
			System.out.println("Press 7 to check if two users are friends with each other.");

			System.out.println("Press 8 to exit");

			command = scan.nextInt();
		}
	}
}
