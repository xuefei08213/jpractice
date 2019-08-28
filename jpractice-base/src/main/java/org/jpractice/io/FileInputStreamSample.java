/**
 * 
 */
package org.jpractice.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author xuefei
 *
 */
public class FileInputStreamSample {
	
	public static void read() {
		
		try {
			InputStream inputStream = new FileInputStream(new File("/Users/xuefei/test/hello.txt"));
			byte[] b = new byte[10];
//			inputStream.skip(2);
//			inputStream.read(b);
			OutputStream outputStream = new FileOutputStream(new File("/Users/xuefei/test/hello1.txt"));
			while(inputStream.read(b)>0) {
				outputStream.write(b);
			}
			
			outputStream.flush();
			outputStream.close();
			inputStream.close();
//			System.out.println(inputStream.read());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		read();
	}

}
