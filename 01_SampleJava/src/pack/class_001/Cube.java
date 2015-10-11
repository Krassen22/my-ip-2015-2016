package pack.class_001;

public class Cube {
	
	private int width;
	private int length;
	private int height;
	
	// Sourse -> Generate Getters and Setters...
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
	public int calculateVolume() {
		
		return width * length * height;
	}
	
	// When overriding equals() consider overriding hashCode()
	@Override
	public boolean equals(Object obj) {
		// Optimization:
		if (obj == this) {
		 	return true;
		}
		if (obj instanceof Cube) {
			final Cube cube2 = (Cube) obj;
			return cube2.width == width && cube2.length == length && cube2.height == height; 
		}
		return false;
	}
	
}
