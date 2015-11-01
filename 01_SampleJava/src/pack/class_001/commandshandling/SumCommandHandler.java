package pack.class_001.commandshandling;

public class SumCommandHandler implements CommandHandler {

	@Override
	public int execute(String[] args) {
		return Integer.valueOf(args[1]) + Integer.valueOf(args[2]);
	}
}
