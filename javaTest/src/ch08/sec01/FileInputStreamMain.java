package ch08.sec01;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

// program that reads a file (javaTest10.txt) and prints via byte stream
public class FileInputStreamMain {

	public static void main(String[] args) {
	try {
	//  differing results when you have Korean text in the file; Korean uses two bytes instead of one
	//	FileReader fr = new FileReader("C:/testsept27/javaText.txt");
		FileInputStream fis = new FileInputStream("C:/testsept27/javatest10.txt");
		InputStreamReader isr = new InputStreamReader(fis, "US-ASCII");
		
		while(true) {
			int data = isr.read();
			if(data == -1) {
				break;
			}
			System.out.print((char)data);
		}
		fis.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
	System.out.println("Close");
	}
}
