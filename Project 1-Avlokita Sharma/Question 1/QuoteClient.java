/**
 * Modified DateClient so that it requests a quote
 * from the quote server.
 */
 
import java.net.*;
import java.io.*;

public class QuoteClient
{
	public static void main(String args[]) throws IOException{

		Socket S = new Socket(InetAddress.getLocalHost(), 6017);
					//6017 becomes the local host. socket is used to connect client to server
		InputStream i = S.getInputStream(); 
					//to catch the stream between server and client
		int input = i.available();
					//variable is created to see if any string is sent by the server
		byte BArray[] = new byte[input];
					//an array of bytes is created so that data can be converted into bytes
		for(int x = 0; x < input; x++){
			BArray[x] = (byte)i.read();
		}
					//this for loop is used to copy bytes into bearray
		for(int y = 0; y < BArray.length; y++){
			char var = (char)BArray[y];
			System.out.print(var);
		}
					//printing the bytes
		S.close();
					//closing the connection until ran again in the terminal
	}
}
