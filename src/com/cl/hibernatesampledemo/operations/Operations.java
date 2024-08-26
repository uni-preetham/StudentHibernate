package com.cl.hibernatesampledemo.operations;

import java.util.Scanner;

public class Operations {
	public void BladeRunner() {
		Scanner in = new Scanner(System.in);
		Functions fn = new Functions();
		String choice = "";

		while(true) {
			System.out.println("_______________________________________\n\t\tOperations\n_______________________________________\n");
			System.out.println("insert: Insert values");
			System.out.println("delete: Delete all");
			System.out.println("deleteunique: Delete using id");
			System.out.println("show: Show all rows");
			System.out.println("exit: Exit");
			System.out.print("Enter choice: ");
			choice = in.next();
			
			if("exit".equals(choice)) {
				System.out.println("Exited!");
				break;
			}

			switch (choice) {
			case "insert":
				System.out.println("Enter name: ");
				String name = in.next();
				System.out.println("Enter email: ");
				String email = in.next();
				fn.insertValues(name, email);
				break;

			case "delete":
				fn.deleteAll();
				break;
				
			case "show":
				fn.showStudents();
				break;

			case "deleteunique":
				System.out.println("Enter id to delete: ");
				int nid = in.nextInt();
				fn.deleteOne(nid);
				break;

			default:
				System.out.println("Enter valid choice.");
			}
			
			

		}
	}
}
