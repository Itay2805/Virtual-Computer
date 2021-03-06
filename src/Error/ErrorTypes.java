package Error;

import Hardware.HD;
import Hardware.RAM;
import toolBox.Print;

public class ErrorTypes{
	
	public boolean NO_MEMORY_FOR_SOFTWARE = false;
	public boolean NO_RAM_FOR_TASK = false;
	
	public static boolean NO_MEMORY_FOR_SOFTWARE(HD hd, int minSpace){
		if(hd.getTotalSpace() - hd.getUsedSpase() < minSpace) {
			Print.info("---------------------------------------------------");
			Print.info("ERROR Type:  NO_MEMORY_FOR_SOFTWARE");
			Print.info("ERROR Info:  Total  space: " + hd.getTotalSpace() + "MB");
			Print.info("             Used   space: " + hd.getUsedSpase() + "MB");
			Print.info("             Needed space: " + minSpace);
			Print.info("---------------------------------------------------");
			Print.info("Error happendes when the computer doesn't have");
			Print.info("enoght Memory to download a software! Upgrade");
			Print.info(" your HD or delete unneeded softwares!");
			Print.info("---------------------------------------------------");
			return true;
		}
		return false;
	}
	
	public static boolean NO_RAM_FOR_TASK(RAM ram, int minUsage) {
		if((ram.getTotalRam() - ram.getUsedRAM()) < minUsage) {
			Print.info("---------------------------------------------------");
			Print.info("ERROR Type:  NO_RAM_FOR_TASK");
			Print.info("ERROR Info:  Total  RAM: " + ram.getTotalRam() + "MB");
			Print.info("             Used   RAM: " + ram.getUsedRAM() + "MB");
			Print.info("             Needed RAM: " + minUsage);
			Print.info("---------------------------------------------------");
			Print.info("Error happendes when the computer doesn't have");
			Print.info("enoght RAM to run an task! Upgrade your RAM or");
			Print.info("stop unused tasks to avoid getting the error! ");
			Print.info("---------------------------------------------------");
			return true;
		}
		return false;
	}
	
}
