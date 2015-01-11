package Software.Task;

import java.util.Scanner;

import toolBox.Print;
import Hardware.Computer;
import Software.Program;

public class Console extends Task{
	
	public Program program;
	public boolean ROOT = false;

	public Console(Computer computer, String name, int minUsage,
			int space) {
		super(computer, name, "exe", minUsage, space, false);
	}
	
	public Scanner reader = new Scanner(System.in);
	
	public void start() {
		if(computer.getRam().getTotalRam() - computer.getRam().getUsedRAM() > minUsage && computer.on) {
			Print.info("Starting " + (computer.getOs().getName() + ".task.start.console.exe"));
			computer.getRam().addUsedRAM(minUsage);
			Print.info("---------------------------------------------------");
			Print.info("       Welcome to Command Line by Minicream!");
			Print.info("---------------------------------------------------");
			if (ROOT) {
				Print.info("test at Console/line 29");
			}
			main();
		} else {
			if (computer.on) {
				Print.info("---------------------------------------------------");
				Print.info("Error when trying to start: " + (computer.getOs().getName() + ".task.start.console.exe"));
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
	
	public void stop() {
		if(ROOT) {
			Print.info("Starting " + (computer.getOs().getName() + ".task.kill.console.exe"));
		}
		computer.getRam().addUsedRAM(-minUsage);
	}
	
	/** The App Itself **/
	
	public void main() {
		String[] action = reader.next().split(";");
		
		if(action[0].equals("close")) {
			stop();
		}else if(action[0].equals("run") && !action[1].equals("console") && !action[1].equals("os")){
			program = new Program(action[1], computer);
			main();
		}else if(action[0].equals("ROOT_OUTPUT")) {
			if(action[1].equals("true")) {
				computer.ROOT = true;
				Print.info("ROOT_OUTPUT have enabled!");
				Print.info(computer.getOs().getName() + ".root.IO.out.coreInfo.sys | TRUE [BIN: 0]");
			}else if(action[1].equals("false")){
				Print.info("ROOT_OUTPUT have disabled!");
				computer.ROOT = false;
			}else {
				Print.info("Usage: ROOT_OUTPUT[true/false]! The input " + action[1].toString() + " is invalid!");
			}
		}else {
			Print.info("Problem while trying to run command: Not have permmition/not excist!");
			main();
		}
	}
	
	public boolean isROOT() {
		if(ROOT) {
			return true;
		}else {
			return false;
		}
	}
	
	public void init() {
		ROOT = false;
	}

}
