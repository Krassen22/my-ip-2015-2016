package pack002.commands;

import java.io.PrintStream;
import java.util.Map;

import pack002.user.User;

public class LogoutCommandHandler implements CommandHandler{

	@Override
	public void executeCommand(String userName, String userName2, PrintStream out,
			Map<String, User> usersInfo) {
		usersInfo.get(userName).logout();
		out.println("ok");
	}
}
