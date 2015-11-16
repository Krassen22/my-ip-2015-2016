package pack002;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import pack002.user.User;

public class ClientHandler implements Runnable{

	private final Socket socket;
	private final Server server;
	Map<String,User> usersInfo = Collections.synchronizedMap(new HashMap<String,User>());
	
	public ClientHandler(Server server, Socket socket){
		this.socket = socket;
		this.server = server;
	}
	
	@Override
	public void run(){
		try {
			final PrintStream out = new PrintStream(socket.getOutputStream());
			final Scanner scanner = new Scanner(socket.getInputStream());
			CommandsExecutor commandExecutor = new CommandsExecutor();
			
			while(scanner.hasNextLine()){
				final String command = scanner.nextLine();
				final String[] splitedCommand = command.split(":");
				commandExecutor.execute(splitedCommand, out, server, usersInfo);
			}
			scanner.close();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			server.onClientStopped(this);
		}
	}
	
	public void stopClient() throws IOException{
		socket.close();
	}
}
