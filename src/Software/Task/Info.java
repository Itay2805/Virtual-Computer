package Software.Task;

import java.util.Scanner;

import toolBox.Print;
import Hardware.Computer;

public class Info extends Task{
	
	public Scanner reader = new Scanner(System.in);

	public Info(Computer computer, String name, int minUsage, int space) {
		super(computer, name, "exe", minUsage, space, false);
	}
	
	public void start() {
		if(computer.getRam().getTotalRam() - computer.getRam().getUsedRAM() > minUsage && computer.on) {
			Print.info("Starting " + (computer.getOs().getName() + ".task.start.info.exe"));
			computer.getRam().addUsedRAM(minUsage);
			task();
		} else {
			if (computer.on) {
				Print.info("---------------------------------------------------");
				Print.info("Error when trying to start: " + (computer.getOs().getName() + ".task.start.info.exe"));
				Print.info("---------------------------------------------------");
				Print.info("ERROR Type:  NO_RAM_FOR_TASK");
				Print.info("ERROR Info:  Total  RAM: " + computer.getRam().getTotalRam());
				Print.info("             Used   RAM: " + computer.getRam().getUsedRAM());
				Print.info("             Needed RAM: " + minUsage);
				Print.info("---------------------------------------------------");
				Print.info("Error happendes when the computer doesn't have");
				Print.info("enoght RAM to run an task! Upgrade your RAM or");
				Print.info("stop unused tasks to avoid getting the error! ");
				Print.info("---------------------------------------------------");
			} else {
				Print.info("Coul'd not load task! Computer is not turned on!");
			}
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
		Print.info("Starting " + (computer.getOs().getName() + ".task.kill.info.exe"));
		computer.getRam().addUsedRAM(-minUsage);
	}
	
}
