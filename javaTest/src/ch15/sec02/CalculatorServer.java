package ch15.sec02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DecimalFormat;

public class CalculatorServer {
	// method to take String equation and return equation result
	public static String calculate(String inputEquation) {
		// equation has three elements: [num1, operator, num2]
		String[] equationArray = new String[3];
		String result = null;
		try {
			// take equation values and assign them into equationArray[]
			equationArray = inputEquation.split(" ");		
			// save String values as integers using Wrapper class method
			int num1 = Integer.parseInt(equationArray[0]);
			int num2 = Integer.parseInt(equationArray[2]);
			// class DecimalFormat to format result for division to two decimal points
			DecimalFormat decimalFormat = new DecimalFormat("0.00");
			// save operator, maintain as String
			String operator = equationArray[1];
			// apply arithmetics to input equation
			switch(operator){
				case "+": result = String.valueOf(num1 + num2); break;
				case "-": result = String.valueOf(num1 - num2); break;
				case "*": result = String.valueOf(num1 * num2); break;
				case "%": result = String.valueOf(num1 % num2); break;
				// change to double to return decimal point answer that uses decimalFormat, prevent dividing by 0
				case "/": if(num2 == 0) result = "Error (Cannot divide by zero)";
							else result = String.valueOf(decimalFormat.format((double)num1 / num2)); break;
				// return error if input is in incorrect format
				default : result = "Error (Incorrect operator)";
			}
		} catch(Exception e){
			result = "Error (Incorrect format)";
		}
		return result;
	}
	
	public static void main(String[] args) {
		//initialize variables
		BufferedReader input = null;
		BufferedWriter output = null;
		Socket socket = null;
		// create server side socket
		ServerSocket serverSocket = null;
		// String to contain incoming equation
		String inputMessage = null;
		
		try {
			// construct socket and designate port number for client to connect to
			serverSocket = new ServerSocket(9988);
			System.out.println("Waiting for connection...");
			// program waits for connection from client
			socket = serverSocket.accept();
			System.out.println("Connection complete");
			// construct input and output stream for server/client exchange
			input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			// infinite loop requests an equation until the client enters "bye"
			while(true) {
				// check input for "bye", condition to close program
				inputMessage = input.readLine();
				if(inputMessage.equalsIgnoreCase("bye")) {
					System.out.println("Client has closed the program");
					break;
				}
				// print input to client console
				System.out.println(inputMessage);
				// apply static method to calculate equation
				String result = calculate(inputMessage);
				// return result to client
				output.write(result + "\n");
				// clear stream buffer
				output.flush();
			}
		// print caught errors	
		} catch(IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				// close sockets
				if(socket != null) socket.close();
				if(serverSocket != null) serverSocket.close();
			// print caught errors
			} catch(IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
