package Internet.Servers;

import java.util.HashMap;

import Hardware.Computer;

/**
 * 
 * This includes the HashMap and the way to connect to the server
 * 
 * @author Itay Almog
 *
 */
public class Index {
	
	
	public HashMap<String, Server> index = new HashMap<String, Server>();
		
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
	 * 
	 * @param computer - The Computer to direct
	 * @param address - The address to connect
	 * @param message - The connecting message
	 */
	public void directToServer (Computer computer, String address, String message) {
		index.get(address).getData(computer, message);
	}
	
	/**
	 * 
	 * Gets a server using a key(address). 
	 * 
	 * @param address - The address of the server to get 
	 * @return and server
	 */
	public Server getServer(String address) {
		return index.get(address);
	}
		
}
