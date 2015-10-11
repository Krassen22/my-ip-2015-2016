package pack.class_001;

public class Minecraft {

	public static void main(String[] args) {
		
		int cubeWidth = 4;
		int cubeLength = 4;
		int cubeHeight = 4;
		
		final Cube cube = new Cube();
		
		cube.setWidth(cubeWidth);
		cube.setLength(cubeLength);
		cube.setHeight(cubeHeight);
		
		System.out.print("Cube width:  ");
		System.out.println(cube.getWidth());
		
		System.out.print("Cube length: ");
		System.out.println(cube.getLength());
		
		System.out.print("Cube height: ");
		System.out.println(cube.getHeight());
		
		// Old version
		// System.out.printf("Cube volume: %d", cube.getWidth()*cube.getLength()*cube.getHeight());
		
		// New version
		System.out.printf("Cube volume: %d", cube.calculateVolume());
	}

}
