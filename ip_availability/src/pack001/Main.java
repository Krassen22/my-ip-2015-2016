package pack001;

import java.util.Scanner;
//import java.util.*; // possible decision

public class Main {

	public static void main(String[] args) {
		
		CommandsHandler cmdsHandler = new CommandsHandler();
		Scanner in = new Scanner(System.in);
		
		do{
			System.out.print("въведете команда: ");
			String command = in.nextLine();
			final String[] split = command.split(":");
			cmdsHandler.execute(split);
		}while(cmdsHandler.exitFlag == false);
		
		in.close();
	}

}
