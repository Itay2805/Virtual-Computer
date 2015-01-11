package Hardware;

import Software.OS;
import toolBox.Print;
import Error.Error;

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
		if(!Error.NO_MEMORY_FOR_SOFTWARE(hd, os.getbasicSpace()) && !Error.NO_RAM_FOR_TASK(ram, os.getBasicUsage())) {
			on = true;
			Print.info("Starting " + (os.getName().trim() + ".boot.sys"));
			ram.addUsedRAM(os.getBasicUsage());
		}else if(Error.NO_RAM_FOR_TASK(ram, os.getBasicUsage())){
			Print.info("---------------------------------------------------");
			Print.info("Error when trying to start: " + (getOs().getName() + ".boot.sys"));
			Print.info("---------------------------------------------------");
			Print.info("ERROR Type:  NO_RAM_FOR_TASK");
			Print.info("ERROR Info:  Total  RAM: " + getRam().getTotalRam() + "MB");
			Print.info("             Used   RAM: " + getRam().getUsedRAM() + "MB");
			Print.info("             Needed RAM: " + os.basicUsage);
			Print.info("---------------------------------------------------");
			Print.info("Error happendes when the computer doesn't have");
			Print.info("enoght RAM to run an task! Upgrade your RAM or");
			Print.info("stop unused tasks to avoid getting the error! ");
			Print.info("---------------------------------------------------");
		}else if(Error.NO_MEMORY_FOR_SOFTWARE(hd, os.getbasicSpace())){
			Print.info("---------------------------------------------------");
			Print.info("Error when trying to start: " + (getOs().getName() + ".boot.sys"));
			Print.info("---------------------------------------------------");
			Print.info("ERROR Type:  NO_MEMORY_FOR_SOFTWARE");
			Print.info("ERROR Info:  Total  space: " + getHd().getTotalSpace() + "MB");
			Print.info("             Used   space: " + getHd().getUsedSpase() + "MB");
			Print.info("             Needed space: " + os.basicSpace);
			Print.info("---------------------------------------------------");
			Print.info("Error happendes when the computer doesn't have");
			Print.info("enoght Memory to download a software! Upgrade");
			Print.info(" your HD or delete unneeded softwares!");
			Print.info("---------------------------------------------------");
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
	
	/** Stats **/
	
	public void info() {
		if(on) {
			Print.info("Starting " + (os.getName().trim() + ".task.start.info"));
			Print.info("------------Computer info------------");
			Print.info("OS name: " + getOs().getName());
			Print.info("-------------------------------------");
			Print.info("RAM name: " + getRam().getName());
			Print.info("RAM total space: " + getRam().getTotalRam() + "MB");
			Print.info("RAM used space: " + getRam().getUsedRAM() + "MB");
			Print.info("-------------------------------------");
			Print.info("CPU name: " + getCpu().getName());
			Print.info("CPU speed: " + getCpu().getSpeed() + "MHz");
			Print.info("-------------------------------------");
			Print.info("HD name: " + getHd().getName());
			Print.info("HD total space: " + getHd().getTotalSpace() + "MB ( " + (getHd().getTotalSpace() / 1024) + "GB )");
			Print.info("HD used space: " + getHd().getUsedSpase() + "MB ( " + (getHd().getUsedSpase() / 1024) + "GB )");
			Print.info("-------------------------------------");
			Print.info("Starting " + (os.getName().trim() + ".task.kill.info"));
		}else {
			Print.info("Coul'd not load data! Computer is not turned on!");
		}
	}
	
}
