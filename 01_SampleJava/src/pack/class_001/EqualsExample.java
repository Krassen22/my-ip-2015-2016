package pack.class_001;

public class EqualsExample {

	private static final int WIDTH = 4;
	private static final int LENGTH = 4;
	private static final int HEIGHT = 4;
	
	public static void main(String[] args) {
		
		final Cube cube1 = new Cube();
		final Cube cube2 = new Cube();
		
		cube1.setWidth(WIDTH);
		cube1.setLength(LENGTH);
		cube1.setHeight(HEIGHT);
		
		cube2.setWidth(WIDTH);
		cube2.setLength(LENGTH);
		cube2.setHeight(HEIGHT);
		
		System.out.println("cube1 == cube2");
		// false
		System.out.println(cube1 == cube2);

		System.out.println("cube1.equals(cube2)");
		// false
		System.out.println(cube1.equals(cube2));
		

		System.out.println("cube1 == cube1");
		// true
		System.out.println(cube1 == cube1);

		System.out.println("cube1.equals(cube1)");
		// true
		System.out.println(cube1.equals(cube1));

	}

}
