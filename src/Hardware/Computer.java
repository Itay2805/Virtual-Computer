package Hardware;

import java.util.HashMap;

import toolBox.Print;
import Error.ErrorTypes;
import Software.OS;

/**
 * 
 * This class includes the basic code of the computer itself,
 * it has the data of the hardware(RAM, CPU...) And the data of the OS with some other things like ROOT access.
 * 
 * @author Itay Almog
 *
 */
public class Computer {
		
	public OS os;
	public RAM ram;
	public CPU cpu;
	public HD hd;
	
	public HashMap<String, String> data = new HashMap<String, String>();
	
	public String ip;
	
	public boolean on = false;
	public boolean ROOT = false;
	
	/**
	 * 
	 * this sets the computers specs and takes the basic space thats the OS needs to run.
	 * 
	 * @param os - The os thats the computer is running
	 * @param ram - The computers RAM
	 * @param cpu - The computers CPU
	 * @param hd - The computers Hard Drive
	 * @param ip - The computers public IP address
	 */
	public Computer(OS os,RAM ram, CPU cpu, HD hd, String ip) {
		this.os = os;
		this.ram = ram;
		this.cpu = cpu;
		this.hd = hd;
		hd.addUsedSpace(os.getbasicSpace());
	}
	
	/**
	 * This boots the computer
	 */
	public void boot() {
		if(!ErrorTypes.NO_MEMORY_FOR_SOFTWARE(hd, os.getbasicSpace()) && !ErrorTypes.NO_RAM_FOR_TASK(ram, os.getBasicUsage())) {
			on = true;
			Print.info("Starting " + (os.getName().trim() + ".boot.sys"));
			ram.addUsedRAM(os.getBasicUsage());
		}else if(ErrorTypes.NO_RAM_FOR_TASK(ram, os.getBasicUsage()) && on){
			Print.info("---------------------------------------------------");
			Print.info("Error when trying to start: " + (getOs().getName() + ".boot.sys"));
		}else if(ErrorTypes.NO_MEMORY_FOR_SOFTWARE(hd, os.getbasicSpace()) && on){
			Print.info("---------------------------------------------------");
			Print.info("Error when trying to start: " + (getOs().getName() + ".boot.sys"));
		}
	}
	
	/**
	 * This shutdown the computer
	 */
	public void shutdown() {
		if(on) {
			Print.info("Starting " + (os.getName().trim() + ".shutdown.sys"));
			on = false;
			ram.clearRam();
		}
	}
	
	/**
	 * 
	 * This stores data thats the computer gets from an server. It stores the data in a HashMap, 
	 * The key is the address of the server wand the value is the message thats the server has sent.
	 * 
	 * @param address - The server IP address
	 * @param message - The message from the server
	 */
	public void addData(String address, String message) {
		if(ROOT) {
			if(message.length() > 25) {
				Print.info("Input from " + address + " | Data is too big / Encrypted!");
			}else {
				Print.info("Input from " + address + " | " + message);
			}
		}
		data.put(address, message);
	}
	
	/**
	 * 
	 * Removes the data from the servers spot in the HashList(Memory Manegment).
	 * 
	 * @param address - The server the clear the data from.
	 */
	public void removeData(String address) {
		if(ROOT) {
			Print.info("[PLACE_HOLDER]");
		}
		data.put(address, null);
	}
	
	/** Getters **/
	
	public CPU getCpu() {
		return cpu;
	}
	
	public HD getHd() {
		return hd;
	}
	
	public OS getOs() {
		return os;
	}
	
	public RAM getRam() {
		return ram;
	}
	
	/**
	 * 
	 * Finds the message thats a server sent to the computer
	 * 
	 * @param address - The address of the server
	 * @return A string of data (What the server has sent to the computer).
	 */
	public String getMessage(String address) {
		return data.get(address).toString();
	}
	
	/** Setters **/
	
	public void setCpu(CPU cpu) {
		this.cpu = cpu;
	}
	
	public void setHd(HD hd) {
		this.hd = hd;
	}
	
	public void setOs(OS os) {
		this.os = os;
	}
	
	public void setRam(RAM ram) {
		this.ram = ram;
	}
	
}
