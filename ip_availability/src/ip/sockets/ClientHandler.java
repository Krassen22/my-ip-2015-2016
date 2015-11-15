package ip.sockets;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler {
	private static final String COMMAND_STOP_SERVER = "stopServer";
	private final Socket socket;
	
	public ClientHandler(Socket socket){
		this.socket = socket;
	}
	
	public void run() throws IOException{
		final PrintStream out = new PrintStream(socket.getOutputStream());
		final Scanner scanner = new Scanner(socket.getInputStream());
		while(scanner.hasNextLine()){
			final String command = scanner.nextLine();
			if(COMMAND_STOP_SERVER.equals(command)){
				break;
			}
			out.println(command);
		}
		scanner.close();
		out.close();
	}
}
