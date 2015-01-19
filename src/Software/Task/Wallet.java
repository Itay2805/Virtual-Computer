package Software.Task;

import java.util.Scanner;

import toolBox.Print;
import Error.ErrorTypes;
import Hardware.Computer;
import Internet.Servers.Bank;
import Internet.Servers.Index;

/**
 * 
 * This task allows the user to connect to his bank account To see how much money they got,
 * Transfer money to another player, Register a new account. 
 * 
 * @author Itay Almog
 *
 */
public class Wallet extends Task{
	
	public Bank bank;
	
	/**
	 * 
	 * Sets up the task.
	 * 
	 * @param computer - The Computer To run on.
	 * @param minUsage - Min RAM usage to run the task.
	 * @param space - Min space needed.
	 * @param bank - The bank which the task is connected to.
	 */
	public Wallet(Computer computer, int minUsage, int space, Bank bank, Index index) {
		super(computer, "Wallet", "exe", minUsage, space, index);
		this.bank = bank;
	}
	
	public Scanner reader = new Scanner(System.in);
	
	public void start() {
		if(!ErrorTypes.NO_RAM_FOR_TASK(computer.getRam(), minUsage) && computer.on) {
			if(computer.ROOT) {
				Print.info("Starting " + (computer.getOs().getName() + ".task.start.wallet.exe"));
			}
			computer.getRam().addUsedRAM(minUsage);
			main();
		}
	}
	
	
	public void stop() {
		if(computer.ROOT) {
			Print.info("Starting " + (computer.getOs().getName() + ".task.kill.info.exe"));
		}
		computer.getRam().addUsedRAM(-minUsage);
	}
	
	public void main() {
		Print.info("-------------------------------------");
		Print.info("Choose action:");
		Print.info("Login(login)");
		Print.info("Register(register)");
		Print.info("-------------------------------------");
		String action = reader.next();
		
		if(action.equals("login")) {
			login();
		}else if(action.equals("close")){
			stop();
		}else if(action.equals("register")) {
			register();
		}else{
			Print.info("Unknown action: " + action);
			main();			
		}
	}
	
	/**
	 * Takes the Username and Password to login to a exciting account, The data will be sent to the server.
	 */
	public void login() {
		Print.info("-------------------------------------");
		Print.info("Login:");
		Print.info("Account name: ");
		String acc = reader.next().trim();
		Print.info("Password: ");
		String pass = reader.next().trim();
		Print.info("-------------------------------------");
		send(acc, pass);
	}
	
	/**
	 * Takes the Username and Password to register a new account, The data will be sent to the server.
	 */
	public void register() {
		Print.info("-------------------------------------");
		Print.info("Please enter your information:");
		Print.info("Account name: ");
		String acc = reader.next().trim();
		Print.info("Password: ");
		String pass = reader.next().trim();
		Print.info("-------------------------------------");
		bank.addAcc(acc, pass);
		main();
	}
	
	/**
	 * 
	 * This shows to the user his account information (Name and Balance).
	 * 
	 * @param acc - The account name.
	 */
	public void acc(String acc) {
		bank.getAccMoney(computer, acc);
		if(computer.ROOT) {
			Print.info("Output from " + computer.getOs().getName() + ".net.connection.sendData.sys | [198-162-0-1] a!=null~?ID=" + acc);
		}
		Print.info("-------------------------------------");
		Print.info("Account name: " + acc);
		Print.info("Total Money: $" + getData());
		Print.info("-------------------------------------");
		String action = reader.next();
		
		if(action.equals("close")) {
			stop();
		}else if(action.equals("transfare")) {
			transfare(acc);
		}
	}
	
	/**
	 * 
	 * This take the amount of money and the reciever of the money, The data will be sent to the server.
	 * 
	 * @param acc - The account name of the sender.
	 */
	public void transfare(String acc) {
		Print.info("-------------------------------------");
		Print.info("To: ");
		String to = reader.next();
		Print.info("Amount: ");
		int value = reader.nextInt();
		Print.info("-------------------------------------");
		if(computer.ROOT) {
			Print.info("Output from " + (computer.getOs().getName() + ".net.connection.IP." + bank.getAddress() + ".sendData.sys | " + acc + "=5&ie=" + to + "=93&ie=" + value));
		}
		bank.transfareMoney(acc, value, to);
		login();
	}
	
	/**
	 * 
	 * This sends to the server the Account name and password to the server to check if the details are ok.
	 * 
	 * @param acc - This is the account name.
	 * @param pass - This is the password.
	 */
	public void send(String acc, String pass) {
		bank.getData(computer, "a?=" + acc + ";" + pass + ";");
		if(computer.ROOT) {
			Print.info("Output from " + computer.getOs().getName() + ".net.connection.sendData.sys | " + bank.getAddress() + " a?=" + acc + "p?=" + pass);	
		}
		String data = getData();
		if(data.equals("true")) {
			acc(acc);
		}else {
			main();
		}
	}
	
	/**
	 * 
	 * This takes the data from the server and initialize it.
	 * 
	 * @return String of data
	 */
	public String getData() {
		String data = computer.getMessage("FirstBank.gov");
		if(!data.equals(null)) {
			if(data.startsWith("$=")) {
				return data.replace("$=", "");
			}else if(data.equals("true")) {
				return "true";
			}else if(data.equals("false")) {
				return "false";
			}
		}
		return "unknown input";
	}
}
