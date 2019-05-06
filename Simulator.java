package MicroVersionoFFacebook;

import java.util.Scanner;

public class Simulator {

	
	public static void main (String args[])
	{
		
		Scanner scan = new Scanner(System.in);
		String friend = "";

		DivisionHashTable userTable = new DivisionHashTable();

		while (!friend.equals("q"))
		{
			System.out.println("Which friend would you like to add?");
			friend = scan.next();

			Person p = new Person(friend, null);
			userTable.chainedHashInsert(p);
		}
		
		userTable.print();
	}

}
