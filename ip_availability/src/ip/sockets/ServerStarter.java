package ip.sockets;

import java.io.IOException;

public class ServerStarter {
	private static final int SERVER_PORT = 31111;
	
	public static void main(String[] args) throws IOException{
		
		final Server server = new Server(SERVER_PORT);
		server.startServer();

	}

}
