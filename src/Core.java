import Hardware.CPU;
import Hardware.Computer;
import Hardware.HD;
import Hardware.RAM;
import Internet.Servers.Bank;
import Internet.Servers.Index;
import Internet.Servers.WebStore;
import Software.OS;
import Software.Task.Console;
import Software.Task.Info;
import Software.Task.Wallet;
import Software.Task.Web;

public class Core {
		
	//** CPU - Names + Procces Speed **//
	
	public static CPU cpu1 = new CPU(200, "BitCoin Miner", "Custom Chip CO."); // 200 MB
	public static CPU cpu2 = new CPU(500, "Family Core", "Fintel"); // 500 MB
	public static CPU cpu3 = new CPU(1000, "F5", "Fintel"); // 1 GB
	public static CPU cpu4 = new CPU(2000, "F7", "Fintel"); // 2 GB
	public static CPU cpu5 = new CPU(4000, "Super Storm Core", "Next Gen Computers CO."); // 4 GB
	
	//** Hardrive - Name + Storage Place + Company **//
	
	public static HD hd1 = new HD(100000, "small HD", "External and Internal Storage CO."); // 100 GB
	public static HD hd2 = new HD(250000, "Family Hardrive", "Fintel"); // 250 GB
	public static HD hd3 = new HD(500000, "Fintel Storage", "Fintel"); // 500 GB
	public static HD hd4 = new HD(1000000, "Gamer's Storage", "Gaming reasurce"); // 1 TB
	public static HD hd5 = new HD(2500000, "Super HD", "Next Gen Computers CO."); // 2.5 TB
	public static HD hd6 = new HD(5000000, "Super HD *Limit Edition*", "Next Gen Computers CO."); // 5 TB
	
	//** RAM - Name + Space **//
	
	public static RAM ram1 = new RAM(2000, "MiniRam", "Fintel CO."); // 2 GB
	public static RAM ram2 = new RAM(4000, "Family RAM", "Fintel CO."); // 4 GB
	public static RAM ram3 = new RAM(6000, "???", "???"); // 6 GB
	public static RAM ram4 = new RAM(8000, "???", "???"); // 8 GB
	public static RAM ram5 = new RAM(12000, "MindStormX", "Next Gen. Computers CO."); // 12 GB
	public static RAM ram6 = new RAM(24000, "Super Gamer", "Gaming reasurce"); // 24 GB 
	
	//** OS - Name + Company**//
	
	public static OS os1 = new OS(23552, 512, "Doors 8.1", "Minicream");
	public static OS os2 = new OS(27648, 512, "Jack OS X", "Grapple");
	public static OS os3 = new OS(5120, 128, "Droid", "Joojle");
	
	public static Computer computer1 = new Computer(os3, ram6, cpu5, hd6, "192.168.1.1");
	
	/** Setts the price of the Hardware(CPU, HD, etc...)**/
	
	public static void init() {		
		cpu1.addPrice(25);
		cpu2.addPrice(100);
		cpu4.addPrice(250);
		cpu4.addPrice(500);
		cpu5.addPrice(1200);
		
		hd1.addPrice(100);
		hd2.addPrice(200);
		hd3.addPrice(400);
		hd4.addPrice(750);
		hd5.addPrice(1590);
		hd6.addPrice(2000);
		
		ram1.addPrice(0);
		ram2.addPrice(0);
		ram4.addPrice(0);
		ram5.addPrice(0);
		ram6.addPrice(0);		
	}
	
	public static Index index = new Index();
	
	public static Bank bank1 = new Bank("First Bank", "FirstBank.gov", index);
	public static WebStore store1 = new WebStore("WebStore.net", index);
	
	public static Info info = new Info(computer1, "info", 16, 32, index);
	public static Wallet wallet = new Wallet(computer1, 32, 128, bank1, index);
	public static Console console = new Console(computer1, "console", 32, 128, index);
	public static Web web = new Web(computer1, 0, 0, index);
	
	public static void main(String[] args) {
		init();		
		computer1.boot();
		bank1.addAcc("Itay".trim(), "123456".trim());
		bank1.addAcc("Ron".trim(), "753".trim());
		bank1.addMoneyToAcc("Itay", 1000);
		while(computer1.on) {
			String action = computer1.getOs().GUI();
			if(action.equals("info")) {
				info.start();
			}else if(action.equals("wallet")) {
				wallet.start();
			}else if(action.equals("shutdown")) {
				System.exit(0);
			}else if(action.equals("console")) {
				console.start();
			}else if(action.equals("web")) {
				web.start();
			}
		}
	}
	
}
