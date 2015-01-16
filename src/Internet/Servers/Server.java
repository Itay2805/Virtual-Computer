package Internet.Servers;

import toolBox.Print;
import Hardware.Computer;

public class Server {
	
	/*
	 * 
	 *Still Working on this! 
	 * 
	 */
	
	public String address;
	
	public boolean on = false;
	
	public Server(String address) {
		this.address = address;
	}
	
	public void start() {
		on = true;
		Print.info("Starting server on " + address);
	}
	
	public void stop() {
		on = false;
		Print.info("Shuting down the server!");
	}
	
	public void sendData(Computer computer, String address, String message) {
		computer.addData(address, message);
	}
	
	public void getData(Computer computer, Server server, String message) {
		
	}
	
}
