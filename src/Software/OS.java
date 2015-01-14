package Software;

import java.util.Scanner;

import toolBox.Print;

public class OS {
	
	public String name;
	public String companyName;
	
	public int basicSpace;
	public int basicUsage;
	
	public Scanner reader = new Scanner(System.in);
	
	public OS(int basicSpace, int basicUsage, String name, String companyName) {
		this.name = name;
		this.companyName = companyName;
		this.basicSpace = basicSpace;
		this.basicUsage = basicUsage;
	}
	
	public String GUI() {
		Print.info("---------------Welcome to " + name + " OS!---------------");
		Print.info("Choose an action(Type): ");
		Print.info("Info(info) - Computer Info");
		Print.info("Wallet(wallet) - Bank Account info");
		Print.info("Console(console) - opens the console!");
		Print.info("Shtdown(shutdown) - Shuts down the computer");
		Print.info("Browser (web) - browse the web! [WIP]");
		Print.info("---------------------------------------------------------");
		String action = reader.next();
		return action;
	}
	
	/** Getters**/

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
