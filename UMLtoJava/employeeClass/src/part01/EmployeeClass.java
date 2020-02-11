package part01;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeClass {
	static ArrayList<Employee> empData;
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		String data[] = { "Add Employee", "Select Employee", "List All", "Quit" };
		String title = "Employee Management";

		empData = new ArrayList<Employee>();

		Menu myMenu = new Menu(title, data);

		myMenu.display();
		int choice = myMenu.getChoice();

		while (choice != 4) {
			processChoice(choice);
			myMenu.display();
			choice = myMenu.getChoice();
		}
		System.out.println("Goodbye");
	}

	static void processChoice(int choice) {
		switch (choice) {
		case 1:
			addEmployee();
			break;
		case 2:
			selectEmployee();
			break;
		case 3:
			listAll();
			break;
		default:
		}
	}

	static void addEmployee() {
		System.out.println("Add Employee");
		System.out.println("++++++++++++\n");
		System.out.print("Enter Name:");
		String name = input.nextLine();
		
		System.out.print("Enter Address:");
		String address = input.nextLine();
		
		System.out.print("Enter Salary:");
		double salary = input.nextDouble();
		input.nextLine();
		
		Employee e = new Employee(name, address, salary);
		empData.add(e);
	}

	static void selectEmployee() {
		String names[] = getAllNames();
		if (names.length == 0) {
			System.out.println("No employees to select from.");
			return;
		}
		Menu men = new Menu("Select an Employee", names);
		men.display();
		int choice = men.getChoice();
		while (choice<1 || choice>names.length) {
			choice = men.getChoice();
		}
		Employee emp = empData.get(choice-1);
		System.out.println("Employee Details");
		System.out.println("++++++++++++++++\n");
		System.out.println(emp.getDetails());
		System.out.println();
	}

	static String[] getAllNames() {
		String data[] = new String[empData.size()];
		int count = 0;
		for (Employee e : empData) {
			data[count] = e.getName();
			count++;
		}
		return data;
	}

	static void listAll() {
		System.out.println("List All");
		System.out.println("++++++++\n");

		String names[] = getAllNames();

		if (names.length == 0) {
			System.out.println("There are no employees.");
		} else {
			int count = 1;
			for (String str : names) {
				System.out.println(count + ". " + str);
				count++;
			}
		}

		System.out.println();
	}
}
