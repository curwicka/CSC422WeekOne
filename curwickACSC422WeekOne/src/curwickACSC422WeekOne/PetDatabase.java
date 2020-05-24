package curwickACSC422WeekOne;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

public class PetDatabase {
	
	// Class Variables
	public static Scanner input = new Scanner(System.in);
	public static List<Pet> petList = new ArrayList<Pet>();
	public static String fileName = "petDB.bin";
	
	public static void main(String[] args) {
		// Method Variables
		int selection;
		boolean exit = false;
		File petDB = new File(fileName);
		
		// Check if file exists before creating file
		if(!petDB.exists()) {
			try {
				// Create file if it doesn't exist
				FileOutputStream file = new FileOutputStream(fileName);
				ObjectOutputStream out = new ObjectOutputStream(file);
				
				// Close output streams
				out.close();
				file.close();
			} catch(IOException ex) {
				System.out.println("IO exception caught.");
			}
		}
		
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
					// View pets
					display();
					break;
					
				case 2: 
					// Add pets
					add();
					break;
				
				case 3:
					// Update pets
					update();
					break;
					
				case 4:
					// Remove pets
					remove();
					break;
					
				case 5:
					// Search pets by name
					nameSearch();
					break;
					
				case 6:
					// Search pets by age
					ageSearch();
					break;
					
				case 7:
					// Exit program
					System.out.println("Good-bye!");
					exit = true;
					break;
				
				default:
					System.out.println("Invalid selection. Please make another selection.");
			}
		}
	}
	
	/*********************************
	 * Display pets in formatted table
	 *********************************/
	public static void display() {
		int count = 0;
		
		/*try {
			// Input Streams for petDB.bin
			FileInputStream file = new FileInputStream(fileName);
			ObjectInputStream objInput = new ObjectInputStream(file);
			
			// Read petList from petDB.bin and assign to temp list
			petList = (ArrayList<Pet>) objInput.readObject();
			
			// Loop through tempPetList, cast all objects to Pet, add to new displayList
			for(int i =0; i < petList.size(); i++) {
				Pet pet = (Pet) petList.get(i);
				petList.set(i, pet);
			}
			
			// Close input streams
			objInput.close();
			file.close();
		} catch(IOException ex) {
			System.out.println("IOException caught.");
			ex.printStackTrace();
		} catch(ClassNotFoundException ex) {
			System.out.println("ClassNotFoundException caught.");
			ex.printStackTrace();
		}*/
		
		// Read from petDB.bin
		read();
		
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
	
	/**********************
	 * Add pets to database
	 **********************/
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
		
		try {
			// Clear contents of file to write new data
			PrintWriter writer = new PrintWriter(fileName);
			writer.close();
			
			// Output Streams for petDB.bin file
			FileOutputStream file = new FileOutputStream(fileName);
			ObjectOutputStream output = new ObjectOutputStream(file);
			
			// Write list to petDB.bin
			output.writeObject(petList);
			
			// Close output streams
			output.close();
			file.close();
		} catch(IOException ex) {
			System.out.println("IO exception caught.");
			ex.printStackTrace();
		}
	}
	
	/*****************
	 * Update pet data
	 *****************/
	public static void update() {
		int count = 0;
		
		/*try {
			// Input Streams for petDB.bin
			FileInputStream file = new FileInputStream(fileName);
			ObjectInputStream objInput = new ObjectInputStream(file);
			
			// Read petList from petDB.bin and assign to temp list
			petList = (ArrayList<Pet>) objInput.readObject();
			
			// Loop through tempPetList, cast all objects to Pet, add to new displayList
			for(int i =0; i < petList.size(); i++) {
				Pet pet = (Pet) petList.get(i);
				petList.set(i, pet);
			}
			
			// Close input streams
			objInput.close();
			file.close();
		} catch(IOException ex) {
			System.out.println("IOException caught.");
			ex.printStackTrace();
		} catch(ClassNotFoundException ex) {
			System.out.println("ClassNotFoundException caught.");
			ex.printStackTrace();
		}*/
		
		// Read from petDB.bin
		read();
		
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
		
		// Prompt for pet to update
		System.out.println("Enter the ID of the pet you want to update: ");
		int selection = input.nextInt();
		input.nextLine();
		Pet updatePet = petList.get(selection);
		String oldName = updatePet.getName();
		int oldAge = updatePet.getAge();
		
		// Prompt for new pet data
		System.out.println("Enter new name and age of pet: ");
		String petData = input.nextLine();
		
		// Parse input
		String[] splitter;
		String delimiter = " ";
		splitter = petData.split(delimiter);
		String name = splitter[0];
		int age = Integer.parseInt(splitter[1]);
		
		// Update Pet object
		updatePet.setName(name);
		updatePet.setAge(age);
		
		// Display changes
		System.out.println(oldName + " " + oldAge + " changed to " + name + " " + age);
		
		try {
			// Clear contents of file to write new data
			PrintWriter writer = new PrintWriter(fileName);
			writer.close();
			
			// Output Streams for petDB.bin file
			FileOutputStream file = new FileOutputStream(fileName);
			ObjectOutputStream output = new ObjectOutputStream(file);
			
			// Write list to petDB.bin
			output.writeObject(petList);
			
			// Close output streams
			output.close();
			file.close();
		} catch(IOException ex) {
			System.out.println("IO exception caught.");
			ex.printStackTrace();
		}
	}
	
	/**************************
	 * Remove pet from database
	 **************************/
	public static void remove() {
		int count = 0;

		/*try {
			// Input Streams for petDB.bin
			FileInputStream file = new FileInputStream(fileName);
			ObjectInputStream objInput = new ObjectInputStream(file);
			
			// Read petList from petDB.bin and assign to temp list
			petList = (ArrayList<Pet>) objInput.readObject();
			
			// Loop through tempPetList, cast all objects to Pet, add to new displayList
			for(int i =0; i < petList.size(); i++) {
				Pet pet = (Pet) petList.get(i);
				petList.set(i, pet);
			}
			
			// Close input streams
			objInput.close();
			file.close();
		} catch(IOException ex) {
			System.out.println("IOException caught.");
			ex.printStackTrace();
		} catch(ClassNotFoundException ex) {
			System.out.println("ClassNotFoundException caught.");
			ex.printStackTrace();
		}*/
		
		// Read from petDB.bin
		read();
		
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
		
		// Prompt for pet to remove
		System.out.println("Enter the ID of the pet you wish to remove: ");
		int selection = input.nextInt();
		input.nextLine();
		Pet updatePet = petList.get(selection);
		String name = updatePet.getName();
		int age = updatePet.getAge();
		
		// Remove pet object from list
		petList.remove(selection);
		System.out.println(name + " " + age + " has been removed.");
		
		try {
			// Clear contents of file to write new data
			PrintWriter writer = new PrintWriter(fileName);
			writer.close();
			
			// Output Streams for petDB.bin file
			FileOutputStream file = new FileOutputStream(fileName);
			ObjectOutputStream output = new ObjectOutputStream(file);
			
			// Write list to petDB.bin
			output.writeObject(petList);
			
			// Close output streams
			output.close();
			file.close();
		} catch(IOException ex) {
			System.out.println("IO exception caught.");
			ex.printStackTrace();
		}
	}
	
	/*********************
	 * Search pets by name
	 *********************/
	public static void nameSearch() {
		/*try {
			// Input Streams for petDB.bin
			FileInputStream file = new FileInputStream(fileName);
			ObjectInputStream objInput = new ObjectInputStream(file);
			
			// Read petList from petDB.bin and assign to temp list
			petList = (ArrayList<Pet>) objInput.readObject();
			
			// Loop through tempPetList, cast all objects to Pet, add to new displayList
			for(int i =0; i < petList.size(); i++) {
				Pet pet = (Pet) petList.get(i);
				petList.set(i, pet);
			}
			
			// Close input streams
			objInput.close();
			file.close();
		} catch(IOException ex) {
			System.out.println("IOException caught.");
			ex.printStackTrace();
		} catch(ClassNotFoundException ex) {
			System.out.println("ClassNotFoundException caught.");
			ex.printStackTrace();
		}*/
		
		// Read from petDB.bin
		read();
		
		// Prompt for search parameter
		System.out.println("Enter name to search: ");
		String searchName = input.nextLine();
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
			
			if(name.equalsIgnoreCase(searchName)) {
				// Print formatted row
				System.out.printf("| %-3d | %-10s | %-4d |%n", id, name, age);
				count++;
			}
		}
		
		// Footer
		System.out.println("+-------------------------+");
		System.out.println(count + " rows in set.");
		System.out.println("\n");
	}
	
	/********************
	 * Search pets by age
	 ********************/
	public static void ageSearch() {
		/*try {
			// Input Streams for petDB.bin
			FileInputStream file = new FileInputStream(fileName);
			ObjectInputStream objInput = new ObjectInputStream(file);
			
			// Read petList from petDB.bin and assign to temp list
			petList = (ArrayList<Pet>) objInput.readObject();
			
			// Loop through tempPetList, cast all objects to Pet, add to new displayList
			for(int i =0; i < petList.size(); i++) {
				Pet pet = (Pet) petList.get(i);
				petList.set(i, pet);
			}
			
			// Close input streams
			objInput.close();
			file.close();
		} catch(IOException ex) {
			System.out.println("IOException caught.");
			ex.printStackTrace();
		} catch(ClassNotFoundException ex) {
			System.out.println("ClassNotFoundException caught.");
			ex.printStackTrace();
		}*/
		
		// Read from petDB.bin
		read();
		
		// Prompt for search parameter
		System.out.println("Enter age to search: ");
		int searchAge = input.nextInt();
		input.nextLine();
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
			
			if(age == searchAge) {
				// Print formatted row
				System.out.printf("| %-3d | %-10s | %-4d |%n", id, name, age);
				count++;
			}
		}
		
		// Footer
		System.out.println("+-------------------------+");
		System.out.println(count + " rows in set.");
		System.out.println("\n");
	}
	
	/*********************************
	 * Read list object from petDB.bin
	 *********************************/
	public static void read() {
		try {
			// Input Streams for petDB.bin
			FileInputStream file = new FileInputStream(fileName);
			ObjectInputStream objInput = new ObjectInputStream(file);
			
			// Read petList from petDB.bin and assign to temp list
			petList = (ArrayList<Pet>) objInput.readObject();
			
			// Loop through tempPetList, cast all objects to Pet, add to new displayList
			for(int i =0; i < petList.size(); i++) {
				Pet pet = (Pet) petList.get(i);
				petList.set(i, pet);
			}
			
			// Close input streams
			objInput.close();
			file.close();
		} catch(IOException ex) {
			System.out.println("IOException caught.");
			ex.printStackTrace();
		} catch(ClassNotFoundException ex) {
			System.out.println("ClassNotFoundException caught.");
			ex.printStackTrace();
		}
	}
}