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
						divHashFunction.chainedHashInsert(divHashTable, p);
						multiHashFunction.chainedHashInsert(multiHashTable, p);
					}
				}
			}

			if (command == 2)
			{
				System.out.println("Which user would you like to delete?");
				String user = scan.next();

				if (divHashFunction.chainedHashSearch(divHashTable, user) != null)
				{
					divHashFunction.chainedHashDelete(divHashTable, divHashFunction.chainedHashSearch(divHashTable, user));
					multiHashFunction.chainedHashDelete(multiHashTable, multiHashFunction.chainedHashSearch(multiHashTable, user));
				}
				else
				{
					System.out.println("No such user exists.");
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

				divHashFunction.chainedHashSearch(divHashTable, user1).addFriend(divHashFunction.chainedHashSearch(divHashTable, user2));
				divHashFunction.chainedHashSearch(divHashTable, user2).addFriend(divHashFunction.chainedHashSearch(divHashTable, user1));
				
				multiHashFunction.chainedHashSearch(multiHashTable, user1).addFriend(multiHashFunction.chainedHashSearch(multiHashTable, user2));
				multiHashFunction.chainedHashSearch(multiHashTable, user2).addFriend(multiHashFunction.chainedHashSearch(multiHashTable, user1));

				divHashFunction.chainedHashSearch(divHashTable, user1).printFriendsList();
				divHashFunction.chainedHashSearch(divHashTable, user2).printFriendsList();
			}

			if (command == 5)
			{
				System.out.println("Which person would you like to remove friends from?");
				String user1 = scan.next();
				Person temp1 = new Person(user1, null);
				divHashFunction.chainedHashSearch(divHashTable, user1).printFriendsList();
				System.out.println("Who would you like to delete?");
				String user2 = scan.next();
				Person temp2 = new Person(user2, null);

				divHashFunction.chainedHashSearch(divHashTable, user1).deleteFriend(temp2);
				divHashFunction.chainedHashSearch(divHashTable, user2).deleteFriend(temp1);

				divHashFunction.chainedHashSearch(divHashTable, user1).printFriendsList();
				divHashFunction.chainedHashSearch(divHashTable, user2).printFriendsList();
			}

			if (command == 6)
			{
				System.out.println("Who's friend list would you like to look at?");
				String user = scan.next();
				divHashFunction.chainedHashSearch(divHashTable, user).printFriendsList();
			}

			if (command == 7)
			{
				System.out.println("Please enter person 1.");
				String user1 = scan.next();
				Person temp1 = new Person(user1, null);
				System.out.println("Please enter person 2.");
				String user2 = scan.next(); 
				Person temp2 = new Person(user2, null);

				if (divHashFunction.chainedHashSearch(divHashTable, user1) != null && divHashFunction.chainedHashSearch(divHashTable, user2) != null)
				{
					boolean found1 = divHashFunction.chainedHashSearch(divHashTable, user1).searchFriend(temp2);
					boolean found2 = divHashFunction.chainedHashSearch(divHashTable, user2).searchFriend(temp1);

					if (found1 == true && found2 == true)
					{
						System.out.println("Yes");
					}
					else
					{
						System.out.println("No");
					}

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
