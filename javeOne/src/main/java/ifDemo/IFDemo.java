package ifDemo;

public class IFDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 21;

		if (num % 3 == 0 && num % 5 == 0) {
			System.out.println("TRIZZ-FIZZZZ");
		} else if (num % 3 == 0) {
			System.out.println("TRIZZ");
		} else if (num % 5 == 0) {
			System.out.println("FIZZ");
		}

	}
}
