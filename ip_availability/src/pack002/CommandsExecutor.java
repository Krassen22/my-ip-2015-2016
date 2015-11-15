package pack002;

import java.io.PrintStream;
import java.util.Map;

import pack002.commands.*;
import pack002.user.User;

public class CommandsExecutor {
	private String userName;
	private String userName2; 
	private String commandWord;
	
	public synchronized void execute(String[] splittedCommand, PrintStream out, Server server, Map<String,User> usersInfo){
		if(splittedCommand.length == 2){
			userName = splittedCommand[0];
			commandWord = splittedCommand[1];
			if("login".equals(commandWord)){ 
				new LoginCommandHandler().executeCommand(userName, commandWord, null, out, usersInfo);
			}
		}
	}
}
