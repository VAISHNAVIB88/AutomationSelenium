package inheritance;


class RBI
{
	int getRateinterest() {
		return 0;
	}


}
class SBI extends RBI
{
	int getRateinterest() {
		return 10;
	}
}

class ICICI extends RBI
{
	int getRateinterest() {
		return 15;
	}
}
class AXIS extends RBI
{
	int getRateinterest() {
		return 20;
	}
}


public class Overridding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    SBI sbiint= new SBI();
    System.out.println(sbiint.getRateinterest());
    
    ICICI iciciint= new ICICI();
    System.out.println(iciciint.getRateinterest());
    
    AXIS axisint= new AXIS();
    System.out.println(axisint.getRateinterest());
	}
	
	

}

