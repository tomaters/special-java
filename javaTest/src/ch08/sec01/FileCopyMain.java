package ch08.sec01;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// program that copies a file (system.ini) and writes a new one (into testsept27, as mysystem.txt)
public class FileCopyMain {

	public static void main(String[] args) {
		File src = new File("C:/Windows/system.ini");
		File test = new File("C:/testsept27/mysystem.txt");
		
		try {
			FileReader fr = new FileReader(src);
			FileWriter fw = new FileWriter(test);
			
			while(true) {
				int data = fr.read();
				if(data == -1) break;
				fw.write((char)data);
			}
			fr.close();
			fw.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	System.out.println("Copy complete");
	}
}
