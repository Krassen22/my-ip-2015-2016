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
			if("login".equals(commandWord))
				new LoginCommandHandler().executeCommand(userName, commandWord, null, out, usersInfo);
			else if(!usersInfo.containsKey(userName) || 
					usersInfo.get(userName).isCurrentlyLogStatus() != true)
				out.println("error:notlogged");
			else if("logout".equals(commandWord))
				new LogoutCommandHandler().executeCommand(userName, commandWord, null, out, usersInfo);
			else if("listavailable".equals(commandWord))
				new ListAvailableCommandHandler().executeCommand(null, commandWord, null, out, usersInfo);
			else if ("listabsent".equals(commandWord))
				new ListAbsentCommandHandler().executeCommand(null, commandWord, null, out, usersInfo);
		}
	}
}
