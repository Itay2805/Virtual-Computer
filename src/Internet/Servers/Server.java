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
	
	/**
	 * 
	 * Sets up the server.
	 * 
	 * @param address - The address of the server
	 */
	public Server(String address) {
		this.address = address;
	}
	
	public Server() {
	}
	
	/**
	 * Starts the server.
	 */
	public void start() {
		on = true;
		Print.info("Starting server on " + address);
	}
	
	/**
	 * Stops the server
	 */
	public void stop() {
		on = false;
		Print.info("Shuting down the server!");
	}
	
	//**********************[WIP]*****************************//
	
	/**
	 * 
	 * Adds a server to the games database, 
	 * The server will be stored in a HashMap - address is the value and the server is the key.
	 * 
	 * @param address - The servers address
	 * @param server - The server
	 */
	public void addServerToIndex(String address, Server server) {
		index.put(address, server);
	}
	
	/**
	 * 
	 * Removes a server from an address.
	 * 
	 * @param address - The address to remove data from
	 */
	public void removeServerFromIndex(String address) {
		index.put(address, null);
	}
	
	/**
	 * 
	 * Routs to a server.
	 * NOTE! THIS IS STILL BUGGY AND MIGHT CUSE YOU TO CRASH WHEN TRYING TO USE THIS METHOD!!!
	 * 
	 * @param computer - The Computer to direct
	 * @param address - The address to connect
	 * @param message - The connecting message
	 */
	public void directToServer (Computer computer, String address, String message) {
		Server server = index.get(address);
		server.getData(computer, message);
	}
	
	/**
	 * 
	 * Gets a server using a key(address). 
	 * NOTE! THIS IS STILL BUGGY AND MIGHT CUSE YOU TO CRASH WHEN TRYING TO USE THIS METHOD!!!
	 * 
	 * @param address - The address of the server to get 
	 * @return and server
	 */
	public Server getServer(String address) {
		return index.get(address);
	}
	
	//********************************************************//
	
	/**
	 * 
	 * This method send data to the computer
	 * 
	 * @param computer - The computer to send the data to
	 * @param address - The address of the server
	 * @param message - The message to send
	 */
	public void sendData(Computer computer, String address, String message) {
		computer.addData(address, message);
	}
	
	/**
	 * 
	 * This method gets data from the computer.
	 * It his different between every server.
	 * 
	 * @param computer - The computer to send the message to
	 * @param message - The message to send
	 */
	public void getData(Computer computer, String message) {
	}
}
