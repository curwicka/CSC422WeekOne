package curwickACSC422WeekOne;

import java.io.*;

public class Pet implements java.io.Serializable {
	
	String name;
	int age;
	
	public Pet() {
		
	}
	
	// Pet object constructor
	public Pet(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	// Getter/Setter Methods
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getAge() {
		return age;
	}
}