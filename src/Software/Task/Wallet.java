package Software.Task;

import java.util.Scanner;

import toolBox.Print;
import Error.ErrorTypes;
import Hardware.Computer;
import Internet.Servers.Bank;

public class Wallet extends Task{
	
	public Bank bank;

	public Wallet(Computer computer, int minUsage, int space, Bank bank) {
		super(computer, "Wallet", "exe", minUsage, space, true);
		this.bank = bank;
	}
	
	public Scanner reader = new Scanner(System.in);
	
	public void start() {
		if(!ErrorTypes.NO_RAM_FOR_TASK(computer.getRam(), minUsage) && computer.on) {
			if(computer.ROOT) {
				Print.info("Starting " + (computer.getOs().getName() + ".task.start.wallet.exe"));
				Print.info("Starting " + (computer.getOs().getName() + ".net.connection.open.IP.sys | " + bank.getAddress()));
			}
			computer.getRam().addUsedRAM(minUsage);
			main();
		}
	}
	
	
	public void stop() {
		if(computer.ROOT) {
			Print.info("Starting " + (computer.getOs().getName() + ".net.connection.close.IP.sys | 198-168-0-1"));
			Print.info("Starting " + (computer.getOs().getName() + ".task.kill.info.exe"));
		}
		computer.getRam().addUsedRAM(-minUsage);
	}
	
	/** The App itself **/
	
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
	
	public void acc(String acc) {
		Print.info("-------------------------------------");
		Print.info("Account name: " + acc);
		Print.info("Total Money: $" + bank.getAccMoney(computer, acc));
		Print.info("Total Money(DEBUG): $" + getData());
		Print.info("-------------------------------------");
		String action = reader.next();
		
		if(action.equals("close")) {
			stop();
		}else if(action.equals("transfare")) {
			transfare(acc);
		}
	}
	
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
	
	public void send(String acc, String pass) {
		if(bank.isOk(computer, acc, pass)) {
			acc(acc);
		}else {
			main();
		}
	}
	
	public String getData() {
		String data = computer.getMessage("198-162-0-1");
		while(true) {
			if(!data.equals(null)) {
				if(data.startsWith("$=")) {
					return data.replace("$=", "");
				}
			}
		}
	}

}
