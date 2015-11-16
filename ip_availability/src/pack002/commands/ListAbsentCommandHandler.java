package pack002.commands;

import java.io.PrintStream;
import java.util.Map;

import pack002.user.User;

public class ListAbsentCommandHandler implements CommandHandler{

	@Override
	public void executeCommand(String userName, String userName2, PrintStream out, 
			Map<String, User> usersInfo) {
		out.print("ok");
		for (String absentUser : usersInfo.keySet()){
			if(usersInfo.get(absentUser).isCurrentlyLogStatus() == false)
				out.print(":" + absentUser);
		}
		out.println();
	}
}
