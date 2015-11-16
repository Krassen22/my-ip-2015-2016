package pack002.commands;

import java.io.PrintStream;
import java.util.Map;

import pack002.user.User;

public class InfoCommandHandler implements CommandHandler{

	@Override
	public void executeCommand(String userName, String userName2, PrintStream out,
			Map<String, User> usersInfo) {
		if(!usersInfo.containsKey(userName2)){
			out.println("ok" + ":" + userName2 + ":false:0");
		}
		else{
		out.print("ok" + ":" + userName2 + 
				":" + usersInfo.get(userName2).isCurrentlyLogStatus() + 
				":" + usersInfo.get(userName2).getLoginCount());
		}
		out.println(usersInfo.get(userName2).exportWholeActivity());
	}
}
