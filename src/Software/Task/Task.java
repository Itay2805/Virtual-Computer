package Software.Task;

import toolBox.Print;
import Error.ErrorTypes;
import Hardware.Computer;
import Internet.Servers.Index;

/**
 * Includes the basic code wich run the Tasks(such as Info).
 * 
 * 
 * @author Itay Almog
 *
 */
public class Task {
	
	public String name;
	public String format;
	
	public Computer computer;
	public Index index;
	
	public int minUsage;
	public int space;
	
	public boolean needIntenet = false;
	
	/**
	 * This is the basic information needed to rn the task.
	 * 
	 * @param computer - The Computer To run on.
	 * @param name - The name of the task.
	 * @param format - The Format of the task(.exe, .prog(CP), .app).
	 * @param minUsage - Min RAM usage to run the task.
	 * @param space - Min space needed.
	 * @param needIntenet - If the Task need internet.
	 */
	public Task(Computer computer, String name, String format, int minUsage, int space ,Index index) {
		this.name = name;
		this.computer = computer;
		this.format = format;
		this.minUsage = minUsage;
		this.space = space;
		this.index = index;
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
	
	/**
	 * The code wich runs when starting the Task.
	 */
	public void start() {}
	
	/**
	 * The code wich runs when stoping the task.
	 */
	public void stop() {}
	
	/**
	 * Usually used as the main code of the task.
	 */
	public void main() {}
	
	
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
