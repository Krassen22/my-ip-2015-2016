package ip.sockets;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private final int port;
	private boolean running;
	public Server(int port){
		this.port = port;
	}
	
	public void startServer() throws IOException{
		setRunning();
		final ServerSocket serverSocket = new ServerSocket(port);
		while(isRunning()){
			final Socket socket = serverSocket.accept();
			final ClientHandler client = new ClientHandler(this, socket);
			new Thread(client).start();
		}
		serverSocket.close();
	}
	
	private synchronized void setRunning(){
		if(running){
			throw new IllegalStateException("Already running");
		}
		running = true;
	}
	
	private synchronized boolean isRunning(){
		return running;
	}
	
	public synchronized void stopServer(){
		running = false;
	}
}
