
import java.net.*;
import java.io.*;
import java.util.*;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.Executors;


public class GuessNumberHandlerServer {
	
	private static ThreadPoolExecutor _ex;
	private static final long MAXWAIT = 120L;
	
	
	public static void main (String[] args) {
		if (args.length != 1) {
			System.err.println("Usage: java GuessNumberHandlerServer <port>");
			System.exit(1);
		}
		int port = Integer.parseInt(args[0]);
		
		try (ServerSocket server = new ServerSocket(port)) {
			
			while (true) {
				
				try {
					System.out.println("Waiting for client.....");
					Socket client = server.accept();
					InetAddress clientAddress = client.getInetAddress();
					System.out.printf("Client from %s connected%n",clientAddress);
					GuessNumberHandler gnh = new GuessNumberHandler(client);
					_ex.execute(gnh);
				} catch (IOException e) {
					System.err.println(e);
				}
				
				
			} 
			
		} catch (IOException e) {
			System.err.println(e);
		
	}
	
}
}