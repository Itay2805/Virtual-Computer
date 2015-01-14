package Software.Task;

import java.util.Scanner;

import toolBox.Print;
import Error.ErrorTypes;
import Hardware.Computer;

public class Info extends Task{
	
	public Scanner reader = new Scanner(System.in);

	public Info(Computer computer, String name, int minUsage, int space) {
		super(computer, name, "exe", minUsage, space, false);
	}
	
	public void start() {
		if(!ErrorTypes.NO_RAM_FOR_TASK(computer.getRam(), minUsage) && computer.on) {
			if(computer.ROOT) {
				Print.info("Starting " + (computer.getOs().getName() + ".task.start.info.exe"));
			}
			computer.getRam().addUsedRAM(minUsage);
			task();
		}
	}
	
	public void task() {
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
		Print.info("HD total space: " + computer.getHd().getTotalSpace() + "MB ( " + (computer.getHd().getTotalSpace() / 1024) + "GB )");
		Print.info("HD used space: " + computer.getHd().getUsedSpase() + "MB ( " + (computer.getHd().getUsedSpase() / 1024) + "GB )");
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
