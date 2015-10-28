package pack.class_001.commandshandling;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CommandsHandler {

	private static Map<String, CommandHandler> HANDLERS =new HashMap<String, CommandHandler>();
	public static void main(String[] args) {
		HANDLERS.put("sum", new sumCommandHandler());
		// input:
		System.out.print("Enter command: ");
		final Scanner in = new Scanner(System.in);
		final String command = in.next();
		// processing:
		final CommandHandler handler = parse(command);
		final int result = handler.execute();
		// output:
		System.out.printf("Result, " + result);
		in.close();
	}
	
	private static CommandHandler parse(String command) {
		final String[] split = command.split(":");
		final CommandHandler result = HANDLERS.get(split[0]);
		if(result == null){
			throw new IllegalArgumentException("Unknown command: " + command);
		}
		return result;
//		if (("sum").equals(split[0])) {
//			return new SumCommandHandler(split);
//		}
	}
	
}
