package Hardware;

/**
 * 
 * This class has the code which handles the storage space of the computer.
 * 
 * @author Itay Almog
 *
 */
public class HD {
	
	public String name;
	public String companyName;
	
	public int price = 0;
	public int totalSpace;
	public int usedSpace = 0;
	
	/**
	 * 
	 * This sets up the HD (name total storage space...).
	 * 
	 * @param totalSpace - Total storage space
	 * @param name - The name of the Hard Drive
	 * @param companyName - The company who created the HD
	 * 
	 */
	public HD(int totalSpace, String name, String companyName) {
		this.name = name;
		this.totalSpace = totalSpace;
		this.companyName = companyName;
	}
	
	//** Getters **//
	
	public String getName() {
		return name;
	}
	
	public int getTotalSpace() {
		return totalSpace;
	}
	
	public int getUsedSpase() {
		return usedSpace;
	}
	
	//** Setters **//
	
	public void takeTotalSpace(int space) {
		totalSpace -= space;
	}
	
	public void addUsedSpace(int space) {
		usedSpace += space;
	}
	
	public void addPrice(int value) {
		price += value;
	}
	
	
}
