package Hardware;

import Software.OS;
import toolBox.Print;
import Error.ErrorTypes;

public class Computer {
		
	public OS os;
	public RAM ram;
	public CPU cpu;
	public HD hd;
	
	public String ip;
	
	public boolean on = false;
	public boolean ROOT = false;
	
	public Computer(OS os,RAM ram, CPU cpu, HD hd, String ip) {
		this.os = os;
		this.ram = ram;
		this.cpu = cpu;
		this.hd = hd;
		hd.addUsedSpace(os.getbasicSpace());
	}
	
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
	
	public void shutdown() {
		if(on) {
			Print.info("Starting " + (os.getName().trim() + ".shutdown.sys"));
			on = false;
			ram.clearRam();
		}
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
	
	public void openConnection(String adddress, String data) {
		
	}
	
}
