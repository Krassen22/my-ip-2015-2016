package ip.sockets;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler implements Runnable{
	private static final String COMMAND_STOP_SERVER = "stopServer";
	private final Socket socket;
	private final Server server;
	
	public ClientHandler(Server server, Socket socket){
		this.socket = socket;
		this.server = server;
	}
	
	@Override
	public void run(){
		try {
			final PrintStream out = new PrintStream(socket.getOutputStream());
			final Scanner scanner = new Scanner(socket.getInputStream());
			while(scanner.hasNextLine()){
				final String command = scanner.nextLine();
				if(COMMAND_STOP_SERVER.equals(command)){
					server.startServer();
					break;
				}
				out.println(command);
			}
			scanner.close();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
