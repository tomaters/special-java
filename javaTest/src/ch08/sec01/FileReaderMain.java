package ch08.sec01;

import java.io.FileReader;
import java.io.IOException;

// program that reads a file (javaText.txt)
public class FileReaderMain {

	public static void main(String[] args) {
	try {
		FileReader fr = new FileReader("C:/testsept27/javaText.txt");
		while(true) {
			int data = fr.read();
			if(data == -1) {
				break;
			}
			System.out.print((char)data);
		}
		fr.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
	System.out.println("Close");
	}
}
