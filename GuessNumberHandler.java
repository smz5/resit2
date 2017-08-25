
import java.net.*;
import java.io.*;
import java.util.*;
import java.lang.*;

public class GuessNumberHandler extends Thread {
	Socket client;
	Writer output;
	BufferedReader input;
	String Username;
	MagicNumber mn;
	
	public GuessNumberHandler(Socket newClient) throws IOException {
		
			client = newClient;
			try {
				Writer output = new OutputStreamWriter(client.getOutputStream());
				BufferedReader input = new BufferedReader(new InputStreamReader(client.getInputStream(),"UTF-8"));
				
			} catch (IOException e) {
				System.err.printf("Failed to create Data streams to %s%n",newClient.getInetAddress());
			}
		}
	
		
		
	public void run() {
		try {
			int CurrentGuess;
			Username = input.readLine();
			System.out.println("Client "+Username+"wants to start a game.");
			do {
				CurrentGuess = Integer.parseInt(input.readLine());
				System.out.println("Client "+Username+"makes a guess with number: "+CurrentGuess);
				output.write(mn.guess(CurrentGuess));
			
			} while (mn.getFinished() == false);
			
	} catch (IOException e) {
		System.err.println(e);
		System.exit(1);
	}
		
	}
	
}