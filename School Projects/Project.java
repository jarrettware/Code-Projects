/* Title: Final Project
 * Name: Jarrett Ware
 * Date: 8/9/2021
 * Description: Program to take in multiple values for employee input and return
 * values within different menus
 */

import java.util.*; //Import Scanner object

public class Project { //Establish class
	
	//Create global variables to be called in the methods
	public String[] nameList = new String[100]; 
	public int[] id = new int[100]; 
	public float[] salary = new float[100]; 
	
	public Project() { //Establish constructor
		this.nameList = nameList;
		this.id = id;
		this.salary = salary;
	} //close constructor
	
	public void loadEmployee() { //Establish method to load employee data
		Scanner scan = new Scanner(System.in); //Establish scanner object
		Scanner stdin = new Scanner(System.in);
		Scanner stdflt = new Scanner(System.in);
		
		System.out.print("How many employees will you like to enter: ");
		int num = scan.nextInt();
		int i;
		for (i = 0; i < num; i++) { //Start for loop
			System.out.print("Enter the name for employee "+(i+1)+": ");
			this.nameList[i] = scan.next();
			System.out.print("Enter their id number: ");
			this.id[i] = stdin.nextInt();
			System.out.print("Enter their salary: ");
			this.salary[i] = stdflt.nextFloat(); 
			
		} //close for loop
	} //close method 
	
	public void addEmployee() { //Establish method to add employee data
		
		Scanner scan = new Scanner(System.in); //Establish scanner object
		Scanner stdin = new Scanner(System.in);
		Scanner stdflt = new Scanner(System.in);
		
		//Input new employee data
		int size = 0;
		//Count how many elements are currently in array
		for (int i = 0; i < this.nameList.length; i++)
			if (this.nameList[i] != null) {
				size++;
			}
		System.out.print("Enter the employee's name: ");
		this.nameList[size] = scan.nextLine();
		System.out.print("Enter the employee's id number: ");
		this.id[size] = stdin.nextInt();
		System.out.print("Enter the employee's salary: ");
		this.salary[size] = stdflt.nextFloat();
		
	} //close method
	
	public void displayEmployee () { //Establish method to display employee data
		int size = 0;
		//Count how many elements are currently in array
		for (int i = 0; i < this.nameList.length; i++) 
			if (this.nameList[i] != null) {
				size++;
			}
		for (int a = 0; a < size; a++) { //start loop to display data
			System.out.print(this.nameList[a]+", ");
			System.out.print("id # "+this.id[a]+", ");
			System.out.println("$"+this.salary[a]);
			System.out.println(" ");
		} //close loop
	} //close method
	
	public void retrieveSpecific() { //Establish method to pull specific data 
		Scanner stdin = new Scanner(System.in); //Establish scanner object
		
		System.out.println("Enter the id # for the employee's data you want: ");
		int num = stdin.nextInt();
		int size = 0;
		//Count how many elements are currently in array
		for (int i = 0; i < this.nameList.length; i++) 
			if (this.nameList[i] != null) {
				size++;
			}
		int a = 0;
		for (int i = 0; i < size; i++) { //start loop
			if (num == this.id[i]) { //start if
				a = i;
			} //close if statement
		} //close loop
		System.out.print(this.nameList[a]+", ");
		System.out.print("id # "+this.id[a]+", ");
		System.out.println("$"+this.salary[a]);
	} //close method
	
	public void retrieveSalary() { //Establish method to display salaries 
		
		Scanner stdflt = new Scanner(System.in); //Establish scanner object
		
		System.out.print("Enter the lowest salary: ");
		float low = stdflt.nextFloat();
		System.out.print("Enter the highest salary: ");
		float high = stdflt.nextFloat();
		
		int size = 0;
		//Count how many elements are currently in array
		for (int i = 0; i < this.nameList.length; i++) 
			if (this.nameList[i] != null) {
				size++;
			}
		for ( int i = 0; i < size; i++) { //start for loop
			if (this.salary[i] > low && this.salary[i] < high) { //start if
				System.out.print(this.nameList[i]+" ");
				System.out.print("id # "+this.id[i]+" ");
				System.out.println("$ "+this.salary[i]);
			} //close if 
		} //close for loop
		
	} //close method
	
	public static void exit() { //Establish method to exit program
		System.out.println("Thank you for using the employee data input center.");
		System.out.print("Have a good day!");
	} //close method



	public static void main(String[] args) { //Establish main method
		
		Project project = new Project();
		
		Scanner scan = new Scanner(System.in); //Establish scanner object
		int count = 0;
		while (count != 1) { //Start loop for menu choices
			System.out.println("Welcome to the employee data input center.");
			System.out.println("1. Load employee data");
			System.out.println("2. Add new employee");
			System.out.println("3. Display all employees");
			System.out.println("4. Display specific employee");
			System.out.println("5. Display salary ranges");
			System.out.println("6. Exit program");
			System.out.print("What would you like to do: ");
			int choice = scan.nextInt();
			if (choice == 1) { //start if 1
				project.loadEmployee();
			} //end if 1
			else if (choice == 2) { //start if 2
				project.addEmployee();
			} //end if 2
			else if (choice == 3) { //start if 3
				project.displayEmployee();
			} //end if 3
			else if (choice == 4) { //start if 4
				project.retrieveSpecific();
			} //end if 4
			else if (choice == 5) { //start if 5
				project.retrieveSalary();
			} //end if 5
			else {
				Project.exit();
				count = 1;
			} //end if statements
		} //end while loop
		
	
	} //Close main method

} //Close class
