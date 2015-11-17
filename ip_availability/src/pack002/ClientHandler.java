package pack002;

import java.io.IOException; 
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler implements Runnable{

	private final Socket socket;
	private final Server server;
	
	private PrintStream out;
	private Scanner scanner;
	
	public ClientHandler(Server server, Socket socket){
		this.socket = socket;
		this.server = server;
	}
	
	@Override
	public void run(){
		try {
			IOInitializer();
			CommandsExecutor commandExecutor = new CommandsExecutor();
			out.print("Enter command: ");
			while(scanner.hasNextLine()){
				final String command = scanner.nextLine();
				final String[] splitedCommand = command.split(":");
				commandExecutor.execute(splitedCommand, out, server, Server.usersInfo);
				out.print("Enter command: ");
			}
			scanner.close();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			server.onClientStopped(this);
		}
	}
	
	private void IOInitializer() throws IOException {
		out = new PrintStream(socket.getOutputStream());
		scanner = new Scanner(socket.getInputStream());
	}
	
	public void stopClient() throws IOException{
		socket.close();
	}
}
