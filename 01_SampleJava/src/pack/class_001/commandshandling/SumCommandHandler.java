package pack.class_001.commandshandling;

public class SumCommandHandler implements CommandHandler {

	private final String[] args;
	
	public SumCommandHandler(String[] args) {
		this.args = args;
	}
	@Override
	public int execute() {
		return Integer.valueOf(args[1]) + Integer.valueOf(args[2]);

	}

}
