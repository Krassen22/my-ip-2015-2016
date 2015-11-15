package pack002.commands;

import java.io.PrintStream;
import java.util.Map;

import pack002.user.User;

public class LoginCommandHandler implements CommandHandler{

	@Override
	public void executeCommand(String userName, String commandWord, String userName2, PrintStream out, Map<String, User> usersInfo) {
		if(!usersInfo.containsKey(userName))
			usersInfo.put(userName, new User(userName));
		usersInfo.get(userName).login();
		out.println("ok");
	}
}
