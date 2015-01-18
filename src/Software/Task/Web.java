package Software.Task;

import java.util.Scanner;

import toolBox.Print;
import Error.ErrorTypes;
import Hardware.Computer;
import Internet.Servers.Server;
import Internet.Servers.WebStore;

public class Web extends Task{
	
	//NOTE! This web thing is still bugy and is not working!
	//NOTE! USING THIS WILL CUSE YOU TO CRASH!
	
	public WebStore store;
	public Server server = new Server();
	
	public Scanner reader = new Scanner(System.in);

	public Web(Computer computer, int minUsage, int space) {
		super(computer, "Browser", "exe", minUsage, space, true);
	}
	
	public void start() {
		if(!ErrorTypes.NO_RAM_FOR_TASK(computer.getRam(), minUsage) && computer.on) {
			if(computer.ROOT) {
				Print.info("Starting " + (computer.getOs().getName() + ".task.start.Browser.exe"));
			}
			computer.getRam().addUsedRAM(minUsage);
			main();
		}
	}
	
	public void stop() {
		if(computer.ROOT) {
			Print.info("Starting " + computer.getOs().getName() + ".task.kill.Browser.exe");
		}
		computer.getRam().addUsedRAM(-minUsage);
	}
	
	public void main() {
		Print.info("------------------------------------------------");
		Print.info("http://Browser.net/");
		Print.info("------------------------------------------------");
		Print.info(" ");
		Print.info(" ");
		Print.info("         Please type the IP to connect          ");
		Print.info(" ");
		Print.info(" ");
		Print.info("------------------------------------------------");
		String input = reader.next();
		if(input.equals("close")) {
			stop();
		}else {
			connect(input, "connect?=ID>");
		}
	}
	
	public void connect(String address, String message) {
		server.directToServer(computer, address, message);
		String data = computer.getMessage(address);
		Print.info(data);
	}
	
	public void send(Server server, Computer computer, String message) {
		server.getData(computer, message);
	}
	
}
