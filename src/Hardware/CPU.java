package Hardware;

public class CPU {
	
	public String name;
	public String companyName;
	
	public int price = 0;
	public int speed;
	
	public CPU(int MHz, String name, String companyName) {
		this.speed = MHz;
		this.name = name;
		this.companyName = companyName;
	}
	
	/** Getters **/
	
	public String getName() {
		return name;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	/** Setters **/
	
	public static void takeSpeed(int speed) {
		speed -= speed;
	}
	
	public void addPrice(int value) {
		price += value;
	}
	
}
