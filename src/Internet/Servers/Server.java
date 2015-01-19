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
