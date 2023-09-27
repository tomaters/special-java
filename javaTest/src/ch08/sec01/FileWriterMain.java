package ch08.sec01;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

// program that writes what is input and saves into a file (into testsept27, as javaTestWrite.txt)
public class FileWriterMain {

	public static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
	try {
		FileWriter fw = new FileWriter("C:/testsept27/javaTestWrite.txt");
		while(true) {
			String inputData = scan.nextLine();
			if(inputData.length() == 0) break;
			fw.write(inputData, 0, inputData.length());
			fw.write("\r\n", 0 , 2);
		}
		fw.close();
		scan.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
	System.out.println("Close");
	}
}
