package Hardware;

public class RAM {
	
	public String name;
	public String companyName;
	
	public int price = 0;
	public int totalRAM;
	public int usedRAM = 0;
	
	public RAM(int totalRAM, String name, String companyName) {
		this.name = name;
		this.totalRAM = totalRAM;
		this.companyName = companyName;
	}
	
	/** Getters **/
	
	public String getName() {
		return name;
	}
	
	public int getTotalRam() {
		return totalRAM;
	}
	
	public int getUsedRAM() {
		return usedRAM;
	}
	
	/** Setters **/
	
	public void takeTotalRAM(int value) {
		totalRAM -= value;
	}
	
	public void addUsedRAM(int value) {
		usedRAM += value;
	}
	
	public void addPrice(int value) {
		price += value;
	}
	
	public void clearRam() {
		usedRAM = 0;
	}
	
}
