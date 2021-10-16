package inheritance;

public class ChildClass extends ParentClass {
	
	public void sayHello() {
		super.sayHello();
		System.out.println("Hello Child");
	}

	public static void main(String[] args) {
		ChildClass cc = new ChildClass();
		cc.sayHello();

	}

}
