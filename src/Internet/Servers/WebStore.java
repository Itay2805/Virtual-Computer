package Internet.Servers;

import Hardware.Computer;


public class WebStore extends Server{
	
	/*
	 * 
	 *Still Working on this! 
	 * 
	 */
	
	public String address = "WebStore.net";

	/**
	 * This will hold the code for the online store where you can to download some tools.  [WIP]
	 */
	public WebStore() {
		super("WebStore.net");
		super.addServerToIndex("WebStore.net", this);
	}
	
	public void getData(Computer computer, String message) {
		if(message.equals("connect?=ID>")) {
			super.sendData(computer, address, "test\nnewline\ntest");
		}
	}

}
