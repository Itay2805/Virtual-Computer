package Internet.Servers;

import Hardware.Computer;
import toolBox.Print;

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
	
	public void dataToServer(Computer computer, String address, String data) {
		
	}
	
	public void dataToComputer(Computer computer, String address, String data) {
	}
	
}
