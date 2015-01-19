package Software.Task;

import java.util.Scanner;

import toolBox.Print;
import Error.ErrorTypes;
import Hardware.Computer;
import Internet.Servers.Index;
import Software.Program;

public class Console extends Task{
	
	public Program program;

	public Console(Computer computer, String name, int minUsage,
			int space, Index index) {
		super(computer, name, "exe", minUsage, space, index);
	}
	
	public Scanner reader = new Scanner(System.in);
	
	public void start() {
		if(!ErrorTypes.NO_RAM_FOR_TASK(computer.getRam(), minUsage )&& computer.on) {
			if(computer.ROOT) {
				Print.info("Starting " + (computer.getOs().getName() + ".task.start.console.exe"));
			}
			computer.getRam().addUsedRAM(minUsage);
			Print.info("---------------------------------------------------");
			Print.info("       Welcome to Command Line by Minicream!");
			Print.info("---------------------------------------------------");
			main();
		}
	}
	
	public void stop() {
		if(computer.ROOT) {
			Print.info("Starting " + (computer.getOs().getName() + ".task.kill.console.exe"));
		}
		computer.getRam().addUsedRAM(-minUsage);
	}
	
	//** The App Itself **//
	
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
				Print.info(computer.getOs().getName() + ".root.IO.out.coreInfo.sys | TRUE [BIN: 1]");
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
	


}
