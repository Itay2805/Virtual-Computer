package Software.Task;

import java.util.Scanner;

import toolBox.Print;
import Error.ErrorTypes;
import Hardware.Computer;

/**
 * 
 * This Task prints the computer specs.
 * 
 * @author Itay Almog
 *
 */
public class Info extends Task{
	
	public Scanner reader = new Scanner(System.in);
	
	/**
	 * 
	 * Sets up the task.
	 * 
	 * @param computer - The Computer To run on.
	 * @param name - The name of the task.
	 * @param minUsage - Min RAM usage to run the task.
	 * @param space - Min space needed.
	 */
	public Info(Computer computer, String name, int minUsage, int space) {
		super(computer, name, "exe", minUsage, space, false);
	}
	
	public void start() {
		if(!ErrorTypes.NO_RAM_FOR_TASK(computer.getRam(), minUsage) && computer.on) {
			if(computer.ROOT) {
				Print.info("Starting " + (computer.getOs().getName() + ".task.start.info.exe"));
			}
			computer.getRam().addUsedRAM(minUsage);
			main();
		}
	}
	
	public void main() {
		Print.info("------------Computer info------------");
		Print.info("OS name: " + computer.getOs().getName());
		Print.info("-------------------------------------");
		Print.info("RAM name: " + computer.getRam().getName());
		Print.info("RAM total space: " + computer.getRam().getTotalRam() + "MB");
		Print.info("RAM used space: " + computer.getRam().getUsedRAM() + "MB");
		Print.info("-------------------------------------");
		Print.info("CPU name: " + computer.getCpu().getName());
		Print.info("CPU speed: " + computer.getCpu().getSpeed() + "MHz");
		Print.info("-------------------------------------");
		Print.info("HD name: " + computer.getHd().getName());
		Print.info("HD total space: " + computer.getHd().getTotalSpace() + "MB ( " + (computer.getHd().getTotalSpace() / 1000) + "GB )");
		Print.info("HD used space: " + computer.getHd().getUsedSpase() + "MB ( " + (computer.getHd().getUsedSpase() / 1000) + "GB )");
		Print.info("-------------------------------------");
		reader.next();
		stop();
	}
	
	public void stop() {
		if(computer.ROOT) {
			Print.info("Starting " + (computer.getOs().getName() + ".task.kill.info.exe"));
		}
		computer.getRam().addUsedRAM(-minUsage);
	}
	
}
