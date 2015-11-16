package pack002;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Map;

import pack002.commands.*;
import pack002.user.User;

public class CommandsExecutor {
	private String userName;
	private String userName2; 
	private String commandWord;
	
	public synchronized void execute(String[] splittedCommand, PrintStream out, Server server, Map<String,User> usersInfo) throws IOException{
		if(splittedCommand.length == 2){
			commandsComposedByTwoParts(splittedCommand, out, server, usersInfo);
		}else if(splittedCommand.length == 3 && "info".equals(splittedCommand[1])){
			commandsComposedByThreeParts(splittedCommand, out, usersInfo);
		}
	}
	
	public void commandsComposedByTwoParts(String[] splittedCommand, PrintStream out, Server server, Map<String,User> usersInfo) throws IOException{
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
		else if("shutdown".equals(commandWord))
			server.stopServer();
	}
	
	public void commandsComposedByThreeParts(String[] splittedCommand, PrintStream out, Map<String,User> usersInfo){
		userName = splittedCommand[0];
		userName2 = splittedCommand[2];
		if(!usersInfo.containsKey(userName) ||
				usersInfo.get(userName).isCurrentlyLogStatus() != true){
			out.println("error:notlogged");
			return;
		}
		new InfoCommandHandler().executeCommand(null, null, userName2, out, usersInfo);
	}
}


