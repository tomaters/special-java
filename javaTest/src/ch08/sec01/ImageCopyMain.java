package ch08.sec01;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

// program that copies image file (this-is-fine.jpg) and pastes it (into testsept27 as this-is-fine-copy)
public class ImageCopyMain {

	public static void main(String[] args) throws IOException {
		
		FileInputStream fis = new FileInputStream("C:/testsept27/this-is-fine.jpg");
		FileOutputStream fos = new FileOutputStream("C:/testsept27/this-is-fine-copy.jpg");
		
		int data = 0;
		while((data = fis.read()) != -1) {
			fos.write(data);
		}
	
		System.out.println("Copy complete");
		fis.close();
		fos.close();
		System.out.println("Close");
	}
}	
