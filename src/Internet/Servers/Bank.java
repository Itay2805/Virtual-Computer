package Internet.Servers;

import toolBox.Print;
import Hardware.Computer;

/**
 * 
 * This is the server which handles all the bank events, such as transferring money and registering new accounts.
 * 
 * @author Itay Almog
 *
 */
public class Bank extends Server{
	
	public String name;
	public String address;
	
	public String[] accounts = new String[1000000];
	public String[] passwords = new String[1000000];
	
	public int[] money = new int[1000000];
	
	public static int existingAcc = 0;
	
	public boolean exist = false;
	
	/**
	 * 
	 * This sets up the Bank server
	 * 
	 * @param name - The banks name
	 * @param address - The address of the bank server
	 */
	public Bank(String name, String address) {
		super(address);
		this.address = address;
		this.name = name;
	}
	
	/**
	 * 
	 * This method adds a accounts to the database, 
	 * It first check if the account exist in the data base and only registering the account if he isn't.
	 * 
	 * @param name - The username to register
	 * @param password - The password of the new account
	 */
	public void addAcc(String name, String password) {
		for(int i = 0; i < existingAcc; i++) {
			if(!accounts[i].equals(name)){
				continue;
			} else{
				Print.info("[Bank] the name of the account is already exist!");
				exist = true;
			}
		}
		if(!exist) {
			accounts[existingAcc] = name.trim();
			passwords[existingAcc] = password.trim();
			money[existingAcc] = 0;
			existingAcc++;
			Print.info("[Bank] created!");
		}
		exist = false;
	}
	
	/**
	 * 
	 * Checks if the username and password are matching.
	 * 
	 * @param computer - The Computer to send the data too
	 * @param acc - The account to check
	 * @param pass - The password to check
	 * @return If the password and username are matching, returns by sending it to the copmputer using the Server class send method
	 */
	public void isOk(Computer computer, String acc, String pass) {
		for(int i = 0; i < existingAcc; i++) {
			if(accounts[i].equals(acc.trim())  && passwords[i].equals(pass.trim())) {
				super.sendData(computer, address, "true");
			}else {
				continue;
			}
		}
		super.sendData(computer, address, "false");
	}
	
	/**
	 * 
	 * This will check and send to the computer how much money the user got
	 * 
	 * @param computer - The Computer the send the data
	 * @param acc - The account to check
	 * 
	 * @return The amount of money the account have(String), This will return it by sending it to the computer using the Server class send method
	 */
	public void getAccMoney(Computer computer, String acc) {
		for(int i = 0; i < existingAcc; i++) {
			if(accounts[i].equals(acc.trim())) {
				super.sendData(computer, address, ("$=" + Integer.toString(money[i])));
			}
		}
	}
	
	/**
	 * 
	 * This transfers money from one account to another
	 * 
	 * @param from - The account name of the sender
	 * @param value - The amount of money to transfer
	 * @param to - The account name of the receiver
	 */
	public void transfareMoney(String from, int value, String to) {
		for(int i = 0; i < existingAcc; i++) {
			if(accounts[i].equals(from.trim())) {
				if(money[i] >= value) {
					for(int j = 0; j < existingAcc; j++) {
						if(accounts[j].equals(to.trim())) {
							addMoneyToAcc(from, -value);
							addMoneyToAcc(to, value);
							Print.info("[Bank] Transfared!");
							break;
						}else if(j == existingAcc-1){
							Print.info("[Bank] Unknown Account!");
						}
					}
				}else {
					Print.info("[Bank] Not enoght money!");
				}
			}
		}
	}
	
	/**
	 * 
	 * Adds money to an account
	 * 
	 * @param acc - The account name
	 * @param value - The amount of money to add to the account
	 */
	public void addMoneyToAcc(String acc, int value) {
		for(int i = 0; i < existingAcc; i++) {
			if(accounts[i].equals(acc)) {
				money[i] += value;
			}
		}
	}
	
	//** Getters **//

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}
	
	/**
	 * Prints the accounts name and the password
	 */
	public void getAccounts() {
		for(int a = 0; a < existingAcc; a++) {
			System.out.println("Acount " + a + " name: " + accounts[a]);
		}
	}

	public void getData(Computer computer, String message) {
		if(message.startsWith("a?=")) {
			String data[] = message.split(";");
			isOk(computer, data[0].toString().replace("a?=", ""), data[1].toString());
		}
	}
	
}
