package Hardware;

/**
 * 
 * This class includes the code for the CPU, right now only contains basic stuff,
 * in the future the CPU will handle processing of things.
 * 
 * @author Itay Almog
 *
 */
public class CPU {
	
	public String name;
	public String companyName;
	
	public int price = 0;
	public int speed;
	
	/**
	 * 
	 * 
	 * 
	 * @param MHz - The computers processing speed(MB)
	 * @param name - The name of the CPU
	 * @param companyName - The Company name
	 */
	public CPU(int MHz, String name, String companyName) {
		this.speed = MHz;
		this.name = name;
		this.companyName = companyName;
	}
	
	//** Getters **//
	
	public String getName() {
		return name;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	//** Setters **//
	
	public static void takeSpeed(int speed) {
		speed -= speed;
	}
	
	public void addPrice(int value) {
		price += value;
	}
	
}
