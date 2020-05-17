package curwickACSC422WeekOne;

import java.util.*;

public class PetDatabase {
	
	// Class Variables
	public static Scanner input = new Scanner(System.in);
	public static List<Pet> petList = new ArrayList<Pet>();
	
	public static void main(String[] args) {
		// Method Variables
		int selection;
		boolean exit = false;
		
		// Program Start
		System.out.println("Pet Database Program");
		System.out.println("\n");
		
		// Menu Infinite Loop
		while(exit == false) {
			System.out.println("What would you like to do?");
			System.out.println("1) View All Pets");
			System.out.println("2) Add More Pets");
			System.out.println("3) Update a Pet");
			System.out.println("4) Remove a Pet");
			System.out.println("5) Search Pets by Name");
			System.out.println("6) Search Pets by Age");
			System.out.println("7) Exit Program");
			System.out.println("Your choice: ");
			selection = input.nextInt();
			input.nextLine();
			
			// Switch Statement Menu Selection
			switch(selection) {
				case 1:
					display();
					break;
					
				case 2: 
					add();
					break;
				
				case 3:
					update();
					break;
					
				case 4:
					remove();
					break;
					
				case 5:
					searchName();
					break;
					
				case 6:
					searchAge();
					break;
					
				case 7:
					System.out.println("Good-bye!");
					exit = true;
					break;
				
				default:
					System.out.println("Invalid selection. Please make another selection.");
			}
		}
	}
	
	public static void display() {
		int count = 0;
		
		// Header
		System.out.println("+-------------------------+");
		System.out.printf("| %-3s | %-10s | %-4s |%n", "ID", "NAME", "AGE");
		System.out.println("+-------------------------+");
		
		// Loop through list
		for(int i = 0; i < petList.size(); i++) {
			int id = i;
			String name = petList.get(i).name;
			int age = petList.get(i).age;
			count++;
			
			// Print formatted row
			System.out.printf("| %-3d | %-10s | %-4d |%n", id, name, age);
		}
		
		// Footer
		System.out.println("+-------------------------+");
		System.out.println(count + " rows in set.");
		System.out.println("\n");
	}
	
	public static void add() {
		String petData = "";
		String name;
		int age;
		
		// Infinite loop to collect multiple pets
		while(!petData.equalsIgnoreCase("done")) {
			System.out.println("Add Pet (Name, Age): ");
			petData = input.nextLine();
			
			if(!petData.equalsIgnoreCase("done")) {
				// Parse input
				String[] splitter;
				String delimiter = " ";
				splitter = petData.split(delimiter);
				name = splitter[0];
				age = Integer.parseInt(splitter[1]);
				
				// Construct Pet object
				Pet pet = new Pet(name, age);
				
				// Add Pet to list
				petList.add(pet);
			}
			else {
				break;
			}
		}
	}
	
	public static void update() {
		System.out.println("This function has not yet been written.");
	}
	
	public static void remove() {
		System.out.println("This function has not yet been written.");
	}
	
	public static void searchName() {
		System.out.println("This function has not yet been written.");
	}
	
	public static void searchAge() {
		System.out.println("This function has not yet been written.");
	}
}