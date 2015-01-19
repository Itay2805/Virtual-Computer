package Internet.Servers;

import Hardware.Computer;

public class WebStore extends Server{
	
	/*
	 * 
	 *Still Working on this! 
	 * 
	 */
	
	public String address;

	/**
	 * This will hold the code for the online store where you can to download some tools.
	 */
	public WebStore(String address, Index index) {
		super(address);
		this.address = address;
		index.addServerToIndex(address, this);
	}
	
	public void getData(Computer computer, String message) {
		if(message.equals("connect?=ID>index")) {
			super.sendData(computer, address, "Welcome to the online store!\nIn here you will be able to download free programs!\n- test.prog - (teat#1) Testing the download system :)\n\nNOTE! THIS IS STILL [WIP]\n");
		}
	}

}
