package pack.class_001;

import java.util.Scanner;

public class TextInput {

	public static void main(String[] args) {
		System.out.print("Enter your name: ");
		final Scanner in = new Scanner(System.in);
		final String name = in.next();
		System.out.printf("Hello, " + name);
		in.close();
		
	}
	
}
