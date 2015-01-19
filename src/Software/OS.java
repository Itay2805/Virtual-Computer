package Software;

import java.util.Scanner;

import toolBox.Print;

/**
 * 
 * This class includes the GUI of the OS, in the future it will have some more stuff...
 * 
 * @author Itay Almog
 *
 */
public class OS {
	
	public String name;
	public String companyName;
	
	public int basicSpace;
	public int basicUsage;
	
	public Scanner reader = new Scanner(System.in);
	
	/**
	 * 
	 * Sets up the data for the computer(such as OS name).
	 * 
	 * @param basicSpace - The space thats the OS files need
	 * @param basicUsage - The RAM needed for the OS to work
	 * @param name - The OS name
	 * @param companyName - The Company who made the OS
	 */
	public OS(int basicSpace, int basicUsage, String name, String companyName) {
		this.name = name;
		this.companyName = companyName;
		this.basicSpace = basicSpace;
		this.basicUsage = basicUsage;
	}
	
	/**
	 * 
	 * This handles the user input to the OS and the basic GUI.
	 * 
	 * @return String of data - the users input.
	 */
	public String GUI() {
		Print.info("---------------Welcome to " + name + " OS!---------------");
		Print.info("Choose an action(Type): ");
		Print.info("Info(info) - Computer Info");
		Print.info("Wallet(wallet) - Bank Account info");
		Print.info("Console(console) - opens the console!");
		Print.info("Shtdown(shutdown) - Shuts down the computer");
		Print.info("Browser (web) - browse the web!");
		Print.info("---------------------------------------------------------");
		String action = reader.next();
		return action;
	}
	
	//** Getters**//

	public String getName() {
		return name;
	}

	public String getCompanyName() {
		return companyName;
	}

	public int getBasicUsage() {
		return basicUsage;
	}
	
	public int getbasicSpace() {
		return basicSpace;
	}

}
