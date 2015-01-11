package Hardware;

public class HD {
	
	public String name;
	public String companyName;
	
	public int price = 0;
	public int totalSpace;
	public int usedSpace = 0;
	
	public HD(int totalSpace, String name, String companyName) {
		this.name = name;
		this.totalSpace = totalSpace;
		this.companyName = companyName;
	}
	
	/** Getters **/
	
	public String getName() {
		return name;
	}
	
	public int getTotalSpace() {
		return totalSpace;
	}
	
	public int getUsedSpase() {
		return usedSpace;
	}
	
	/** Setters **/
	
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
