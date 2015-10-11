package pack.class_001;

public class ControlFlowStatements {

	public static void main(String[] args) {
		
		// only 'if'
		if(true) {
			System.out.println("called");
		}
		
		// 'if' and 'else'
		int firstNumber = 3;
		int secondNumber = 2;
		
		// Select statements that should be extracted to method, press Ctrl+1
		forExtracted();
		
		// Select statements that should be extracted to method, press Ctrl+1
		ifExample(firstNumber, secondNumber);
		
		int myAge = 18;
		ageRestriction(myAge);
		
	}

	private static void forExtracted() {
		for (int i = 0; i < 10; i++) {
			// 0..9
			System.out.println(i);
		}
		System.out.println();
	}

	private static void ifExample(int firstNumber, int secondNumber) {
		if(firstNumber>=secondNumber) {
			System.out.println("3 is greater or equal then 2");
		} else {
			System.out.println("3 is less then 2");
		}
	}
	
	
	private static void ageRestriction(int age){
		if(age < 18) {
			System.out.println("You have no business here!");
		} else {
			System.out.println("Hey, you are welcome!");
		}
	}

}
