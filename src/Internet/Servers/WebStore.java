package Internet.Servers;

import toolBox.Print;
import Hardware.Computer;


public class WebStore extends Server{
	
	/*
	 * 
	 *Still Working on this! 
	 * 
	 */
	
	public String address = "WebStore.net";

	public WebStore() {
		super("WebStore.net");
		super.addServerToIndex("WebStore.net", this);
		Print.info("test");
		main();
	}
	
	public void main() {
		
	}
	
	public void getData(Computer computer, String message) {
		if(message.equals("connect?=ID>")) {
			super.sendData(computer, address, "test\nnewline\ntest");
		}
	}

}
