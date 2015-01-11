package Internet.Servers;

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
		
	}

}
