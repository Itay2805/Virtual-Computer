package Software.Task;

import Hardware.Computer;

public class Web extends Task{

	public Web(Computer computer, int minUsage,
			int space) {
		super(computer, "Browser", "exe", minUsage, space, true);
	}
	

}
