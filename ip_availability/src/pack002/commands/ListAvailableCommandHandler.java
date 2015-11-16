package pack002.commands;

import java.io.PrintStream;
import java.util.Map;

import pack002.user.User;

public class ListAvailableCommandHandler implements CommandHandler{

	@Override
	public void executeCommand(String userName, String userName2, PrintStream out,
			Map<String, User> usersInfo) {
		out.print("ok");
		for (String availableUser : usersInfo.keySet()){
			if(usersInfo.get(availableUser).isCurrentlyLogStatus() == true){
				out.print(":" + availableUser);
			}
		}
		out.println();
	}
}
