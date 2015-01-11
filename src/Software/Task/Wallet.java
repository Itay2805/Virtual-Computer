package Software.Task;

import java.util.Scanner;

import toolBox.Print;
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
		if(computer.getRam().getTotalRam() - computer.getRam().getUsedRAM() > minUsage && computer.on) {
			if(computer.ROOT) {
				Print.info("Starting " + (computer.getOs().getName() + ".task.start.wallet.exe"));
				Print.info("Starting " + (computer.getOs().getName() + ".net.connection.open.IP.sys | " + bank.getAddress()));
			}
			computer.getRam().addUsedRAM(minUsage);
			main();
		} else {
			if (computer.on) {
				Print.info("---------------------------------------------------");
				Print.info("Error when trying to start: " + (computer.getOs().getName() + ".task.start.wallet.exe"));
				Print.info("---------------------------------------------------");
				Print.info("ERROR Type:  NO_RAM_FOR_TASK");
				Print.info("ERROR Info:  Total  RAM: " + computer.getRam().getTotalRam());
				Print.info("             Used   RAM: " + computer.getRam().getUsedRAM());
				Print.info("             Needed RAM: " + minUsage);
				Print.info("---------------------------------------------------");
				Print.info("Error happendes when the computer doesn't have");
				Print.info("enoght RAM to run an task! Upgrade your RAM or");
				Print.info("stop unused tasks to avoid getting the error! ");
				Print.info("---------------------------------------------------");
			} else {
				Print.info("Coul'd not load task! Computer is not turned on!");
			}
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
		Print.info("Total Money: $" + bank.getAccMoney(acc));
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
		if(computer.ROOT) {
			Print.info("Output from " + (computer.getOs().getName() + ".net.connection.IP." + bank.getAddress() + ".sendData.sys | " + acc + "=2&ie=" + pass));
		}
		if(bank.isOk(acc, pass)) {
			if(computer.ROOT) {
				Print.info("Input from " + (computer.getOs().getName() + ".net.connection.IP." + bank.getAddress() + ".getData.sys | " + bank.getAccMoney(acc)));
			}
			acc(acc);
		}else {
			if(computer.ROOT) {
				Print.info("Input from " + (computer.getOs().getName() + ".net.connection.IP." + bank.getAddress() + ".getData.sys | unknown"));
			}
			main();
		}
	}

}
