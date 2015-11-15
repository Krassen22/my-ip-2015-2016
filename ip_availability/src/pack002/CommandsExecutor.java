package pack002;

import java.io.PrintStream;
import java.util.Map;

import pack002.user.User;

public class CommandsExecutor {
	
	public synchronized void execute(String[] splittedCommand, PrintStream out, Server server, Map<String,User> usersInfo){
		System.out.println("hello");
	}
}
