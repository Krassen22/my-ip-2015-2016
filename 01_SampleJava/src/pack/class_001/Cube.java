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
	
}
