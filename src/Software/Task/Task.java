package Software.Task;

import toolBox.Print;
import Hardware.Computer;
import Error.ErrorTypes;

public class Task {
	
	public String name;
	public String format;
	
	public Computer computer;
	
	public int minUsage;
	public int space;
	
	public boolean needIntenet = false;
	
	public Task(Computer computer, String name, String format, int minUsage, int space ,boolean needIntenet) {
		this.name = name;
		this.computer = computer;
		this.format = format;
		this.minUsage = minUsage;
		this.space = space;
		this.needIntenet = needIntenet;
		if(ErrorTypes.NO_MEMORY_FOR_SOFTWARE(computer.getHd(), space)) {
			Print.info("---------------------------------------------------");
			Print.info("Error when trying to start: " + (computer.getOs().getName() + ".task." + name + "." + format));
			Print.info("---------------------------------------------------");
			Print.info("ERROR Type:  NO_MEMORY_FOR_SOFTWARE");
			Print.info("ERROR Info:  Total  space: " + computer.getHd().getTotalSpace() + "MB" + "(" + (computer.getHd().getTotalSpace() / 1024) + " GB)");
			Print.info("             Used   space: " + computer.getHd().getUsedSpase() + "MB" + "(" + (computer.getHd().getUsedSpase() / 1024) + " GB)");
			Print.info("             Needed space: " + space);
			Print.info("---------------------------------------------------");
			Print.info("Error happendes when the computer doesn't have");
			Print.info("enoght Memory to download a software! Upgrade");
			Print.info(" your HD or delete unneeded softwares!");
			Print.info("---------------------------------------------------");
		}else {
			computer.getHd().addUsedSpace(space);
		}
	}
	
	/** Getters**/

	public String getName() {
		return name;
	}

	public String getFormat() {
		return format;
	}

	public int getMinUsage() {
		return minUsage;
	}
	
	public int getMinSpace(){
		return space;
	}
	
}
