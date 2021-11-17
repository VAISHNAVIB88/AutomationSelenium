package week2.day1;

import org.testng.annotations.Test;

public class Laptoppriority {

	@Test(priority=1)
	public void getMouse() {
		System.out.println("Mouse");
	}
	
	@Test(priority=2)
	public void getKeyboard() {
		System.out.println("Keyboard");
	}
    
	@Test(priority=3)
	public void getMonitor() {
	System.out.println("Monitor");
	}
}

//if not provided with priority ASCII order execution takes place
// default priority is "0"
//if two @Test have same priority ASCII order will be taken
//negative values also can be given