package Internet.Servers;

import toolBox.Print;
import Hardware.Computer;

public class Bank extends Server{
	
	public String name;
	public String address;
	
	public String[] accounts = new String[1000000];
	public String[] passwords = new String[1000000];
	
	public int[] money = new int[1000000];
	
	public static int existingAcc = 0;
	
	public boolean exist = false;
	
	public Bank(String name, String address) {
		super(address);
		this.address = address;
		this.name = name;
	}
	
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
	
	public boolean isOk(Computer computer, String acc, String pass) {
		for(int i = 0; i < existingAcc; i++) {
			if(accounts[i].equals(acc.trim())  && passwords[i].equals(pass.trim())) {
				super.sendData(computer, address, "true");
				return true;
			}else {
				continue;
			}
		}
		super.sendData(computer, address, "false");
		return false;
	}
	
	public void getAccMoney(Computer computer, String acc) {
		for(int i = 0; i < existingAcc; i++) {
			if(accounts[i].equals(acc.trim())) {
				super.sendData(computer, address, ("$=" + Integer.toString(money[i])));
			}
		}
	}
	
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
	
	public void addMoneyToAcc(String acc, int value) {
		for(int i = 0; i < existingAcc; i++) {
			if(accounts[i].equals(acc)) {
				money[i] += value;
			}
		}
	}
	
	/** Getters **/

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}
	
	public void getAccounts() {
		for(int a = 0; a < existingAcc; a++) {
			System.out.println("Acount " + a + " name: " + accounts[a]);
		}
		for(int a = 0; a < existingAcc; a++) {
			System.out.println("Acount " + a + " password: " + passwords[a]);
		}
	}
	
	public void getData(Computer c, String message) {
		if(message.startsWith("a?=")) {
			String data[] = message.split(";");
			isOk(c, data[0].toString().replace("a?=", ""), data[1].toString());
		}
	}
	
}
