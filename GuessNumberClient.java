
import java.net.*;
import java.io.*;
import java.lang.*;

public class GuessNumberClient {	
	public static void main (String args[]) {
		
		if (args.length != 3) {
			System.err.println("Usage: java MessageSendClient <host> <port> <name>");
			System.exit(1);
		}
		String servername = args[0];
		int port = Integer.parseInt(args[1]);
		String UserName = args[2];

		try (Socket server = new Socket(servername,port)) {
			
			System.out.println("Connected to " + server.getInetAddress());
			
			BufferedReader input = new BufferedReader (new InputStreamReader(server.getInputStream(), "UTF-8"));
			Writer output = new OutputStreamWriter(server.getOutputStream());
			BufferedReader localinput = new BufferedReader (new InputStreamReader(System.in));
			
			int CurrentGuess;
			String ServerOutput = "";
			Boolean GameOver = new Boolean(false);
			output.write(UserName);
			output.flush();
			
			
			do {
				System.out.println("Key in a guess number:");
				CurrentGuess = Integer.parseInt(localinput.readLine());
				output.write(String.format("%d%n", CurrentGuess));
				output.flush();
				ServerOutput = input.readLine();
				System.out.println("The server said: " + ServerOutput);
				if (ServerOutput.contains("game over")) {
					GameOver = true;
				}
				
				
			} while (GameOver = false);
			
			server.close();
			
		}
		catch (UnknownHostException e) {
			System.err.println("Unknown host: "+servername);
			System.err.println(e);
			System.exit(1);
		}
		catch (IOException e) {
			System.err.println(e);
			System.exit(1);
		}
	}
}