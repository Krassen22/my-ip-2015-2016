package pack002.commands;

import java.io.PrintStream;
import java.util.Map;

import pack002.user.User;

public interface CommandHandler {
	public void executeCommand(String userName, String commandWord, String userName2, PrintStream out, Map<String, User> usersInfo);
}
