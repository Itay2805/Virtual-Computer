package Software.Task;

import java.util.Scanner;

import toolBox.Print;
import Error.ErrorTypes;
import Hardware.Computer;
import Internet.Servers.Index;
import Internet.Servers.Server;
import Internet.Servers.WebStore;

public class Web extends Task{
	
	//NOTE! This web thing is still bugy and is not working!
	//NOTE! USING THIS WILL CUSE YOU TO CRASH!
	
	public WebStore store;
	
	public Scanner reader = new Scanner(System.in);

	public Web(Computer computer, int minUsage, int space, Index index) {
		super(computer, "Browser", "exe", minUsage, space, index);
	}
	
	public void start() {
		if(!ErrorTypes.NO_RAM_FOR_TASK(computer.getRam(), minUsage) && computer.on) {
			if(computer.ROOT) {
				Print.info("Starting " + (computer.getOs().getName() + ".task.start.Browser.exe"));
			}
			computer.getRam().addUsedRAM(minUsage);
			Print.info("------------------------------------------------");
			Print.info("http://Browser.net/");
			Print.info("------------------------------------------------");
			Print.info(" ");
			Print.info(" ");
			Print.info("         Please type the IP to connect");
			Print.info(" ");
			Print.info(" ");
			Print.info("------------------------------------------------");
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
		String input = reader.next();
		if(input.equals("close")) {
			stop();
		}else {
			String[] action = input.split("/");
			if(action.length == 1) {
				connect(action[0], "index");
			}else {
				connect(action[0], action[1]);
			}
		}
	}
	
	public void connect(String address, String message) {
		if(computer.ROOT) {
			Print.info("Output from " + computer.getOs().getName() + ".net.connection.sendData.sys | " + address + " connect?=ID>" + message + " ");	
		}
		try {
			index.directToServer(computer, address.trim(),  "connect?=ID>" + message);
			String data = computer.getMessage(address);
			Print.info("------------------------------------------------");
			Print.info("http://" + address + "/" + message + "/");
			Print.info("------------------------------------------------");
			Print.info(data);
			Print.info("------------------------------------------------");
			main();
		}catch (Exception e){
			Print.info("------------------------------------------------");
			Print.info("http://" + address + "/");
			Print.info("------------------------------------------------");
			Print.info(" ");
			Print.info("                404 Error");
			Print.info("                Page not exist");
			Print.info(" ");
			Print.info(" ");
			Print.info("------------------------------------------------");
			main();
		}
	}
	
	public void send(Server server, Computer computer, String message) {
		server.getData(computer, message);
	}
	
}
