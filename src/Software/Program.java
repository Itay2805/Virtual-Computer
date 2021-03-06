package Software;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import toolBox.Print;
import Hardware.Computer;

/**
 * This includes the code for the CP(Custom Program) to work, 
 * To test your program just run the game and use "run;[name];" in the console.
 * 
 * @author Itay Almog
 *
 */
public class Program {
	
	public String format;
	public String name;
	public Computer computer;
		
	public int RAM;
	
	public boolean done = false;
	public boolean inti = false;
	public boolean inLoop = false;
	public boolean ok = true;
	
	public static Scanner in = new Scanner(System.in);
	
	/**
	 * 
	 * This reads the code from the file and do what the code in the file should do(for eg. %os%.IO.out.print; means to print something to the console).
	 * 
	 * @param name(String) - The name of the program(File).
	 * @param computer(Computer) - The Computer the run the game on
	 */
	
	public Program(String name, Computer computer) {
		this.name = name;
		this.computer = computer;
		done = false;
		inti = false;
		FileReader isr = null;
        File File = new File("res/" + name + ".prog");
        try {
            isr = new FileReader(File);
        } catch (FileNotFoundException e) {
            System.err.println("File not found!");
            System.exit(0);
        }
        BufferedReader reader = new BufferedReader(isr);
        String line;
        String input;
        try{
        	while(!done) {
            	line = reader.readLine();
            	if(line.startsWith("# ")){
            		String[] currentLine = line.split(";");
            		if(currentLine[0].equals("# form")) {
            			format = currentLine[1];
            		}else if(currentLine[0].equals("# fin") && inti) {
            			stop();
            			Print.info("---------------------------------------------------");
            			Print.info("       Welcome to Command Line by Minicream!");
            			Print.info("---------------------------------------------------");
            		}else if(currentLine[0].equals("# prop") && format != null) {
            			if(currentLine[1].equals("Ram.take")) {
            				if (computer.ROOT) {
                				Print.info("Starting " + computer.getOs().getName() + ".task.start." + name + "." + format);
            				}
            				RAM = Character.getNumericValue(currentLine[2].charAt(0));
                			computer.getRam().addUsedRAM(RAM);
                			inti = true;
            			}
            		}
            	}else if(line.startsWith(computer.getOs().getName().toString()) && inti) {
            		String[] currentLine = line.split(";");
            		if(currentLine[0].equals(computer.getOs().getName() + ".IO.out.print")) {
            			if(currentLine[1].equals(computer.getOs().getName() + ".IO.in.getData.sys")) {
            				input = in.next();
            				Print.info(input.replace("_", " "));
            			}else {
                			Print.info(currentLine[1].replace("_", " "));
            			}
            		}else if(currentLine[0].equals(computer.getOs().getName() + ".IO.in.getData.sys")) {
            			input = in.next();
            		}
            	}else if(line.startsWith("- ") && inti) {
            		String[] currentLine = line.split(";");
            		if(currentLine[0].equals("- if")) {
            			if(currentLine[2].equals("=")){
            				if(currentLine[1].equals(currentLine[3])) {
                				inLoop = true;
                				if(computer.ROOT) {
                					Print.info("Output From " + computer.getOs().getName() + ".task.runtime." + name + "." + format + " | TRUE [BIN:1]");
                				}
            				}else {
            					if(computer.ROOT) {
                					Print.info("Output From " + computer.getOs().getName() + ".task.runtime." + name + "." + format + " | FALSE [BIN:0]");
                				}
            				}
            			}else if (currentLine[2].equals(">")) {
            				ok = true;
            				try {
            					if (Integer.parseInt(currentLine[1]) > Integer.parseInt(currentLine[3]) && ok){
                    				inLoop = true;
                    				if(computer.ROOT) {
                    					Print.info("Output From " + computer.getOs().getName() + ".task.runtime." + name + "." + format + " | TRUE [BIN:1]");
                    				}
                				}else {
                					if(computer.ROOT) {
                						Print.info("Output From " + computer.getOs().getName() + ".task.runtime." + name + "." + format + " | FALSE [BIN:0]");
                    				}
                				}
            				} catch (Exception e) {
                				Print.info("[ERROR/runtime] CAN NOT USE '>' WITH STRINGS! ONLY WITH INTS!");
            				}
            			}else {
            				Print.info("[ERROR/runtime] UNKNOW COMMAND!");
            			}
            		}
            	}else if(line.startsWith("*") && inLoop) {
            		if(line.startsWith("* " + computer.getOs().getName().toString()) && inti) {
                		String[] currentLine = line.split(";");
                		if(currentLine[0].equals("* " + computer.getOs().getName() + ".IO.out.print")) {
                			if(currentLine[1].equals(computer.getOs().getName() + ".IO.in.getData.sys")) {
                				input = in.next();
                				Print.info(input.replace("_", " "));
                			}else {
                    			Print.info(currentLine[1].replace("_", " "));
                			}
                		}else if(currentLine[0].equals(computer.getOs().getName() + ".IO.in.getData.sys")) {
                			input = in.next();
                		}
            		}
            	}else if(line.startsWith("*") && !inLoop){
    				continue;
            	}else {
            		Print.info("[ERROR/runtime] UNKNOW COMMAND!");
            	}
        	}
            reader.close();
        }catch(Exception e) {
        	e.printStackTrace();
        }
	}
	
	/**
	 * Stops the program.
	 */
	public void stop() {
		if(computer.ROOT) {
			Print.info("Starting " + computer.getOs().getName() + ".task.kill." + name + "." + format);
		}
		computer.getRam().addUsedRAM(-RAM);
		done = true;
	}
	
}
