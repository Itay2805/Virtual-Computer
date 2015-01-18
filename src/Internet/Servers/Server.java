package Internet.Servers;

import java.util.HashMap;

import toolBox.Print;
import Hardware.Computer;

public class Server {
	
	/*
	 * 
	 *Still Working on this! 
	 * 
	 */
	
	public HashMap<String, Server> index = new HashMap<String, Server>();
	
	public String address;
	
	public boolean on = false;
	
	public Server(String address) {
		this.address = address;
	}
	
	public Server() {
	}
	
	public void start() {
		on = true;
		Print.info("Starting server on " + address);
	}
	
	public void stop() {
		on = false;
		Print.info("Shuting down the server!");
	}
	
	//**********************[WIP]*****************************//
	
	public void addServerToIndex(String address, Server server) {
		index.put(address, server);
	}
	
	public void removeServerFromIndex(String address) {
		index.put(address, null);
	}
	
	public void directToServer (Computer computer, String address, String message) {
		Print.info("test3");
		Server server = index.get(address);
		Print.info("test");
		server.getData(computer, message);
	}
	
	public Server getServer(String address) {
		return index.get(address);
	}
	
	//********************************************************//
	
	public void sendData(Computer computer, String address, String message) {
		computer.addData(address, message);
	}
	
	public void getData(Computer computer, String message) {
	}
}
