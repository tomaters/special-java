package ch15.sec02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class CalculatorClient {

	public static void main(String[] args) {
		// initialize variables
		BufferedReader input = null;
		BufferedWriter output = null;
		Socket socket = null;
		// use scanner to scan equation to send to server
		Scanner scan = new Scanner(System.in);
		// String to contain outgoing equation and incoming result
		String outputMessage = null;
		String inputMessage = null;
		
		try {
			// construct socket to connect to server. connected on same computer so IP is localhost
			socket = new Socket("localhost", 9988);
			// construct input and output stream for server/client exchange
			input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			// infinite loop requests an equation until the client enters "bye"
			while(true) {
				System.out.println("Enter arithmetic equation using integers | Example: \"12 + 34\" | "
						+ "Enter \"bye\" to close :");
				// store output as String
				outputMessage = scan.nextLine();
				// if "bye", close program
				if(outputMessage.equalsIgnoreCase("bye")) {
					// send "bye"
					output.write(outputMessage + "\n");
					// clear stream buffer
					output.flush();
					break;
				}
				// send message
				output.write(outputMessage + "\n");
				// clear stream buffer
				output.flush();
				// store input as String and print
				inputMessage = input.readLine();
				System.out.println("Result: " + inputMessage);
			}
			
		// print caught errors
		} catch(IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				// close scanner and socket
				scan.close();
				if(socket != null) socket.close();
			// print caught errors
			} catch(IOException e) {
				System.out.println(e.getMessage());				
			}
		}
	}
}
