/**
 * An echo client. The client enters data to the server, and the
 * server echoes the data back to the client.
 */

import java.net.*;
import java.io.*;
import java.util.*;

public class EchoClient
{
	public static void main(String args[]) throws IOException{

		Socket S = new Socket(InetAddress.getLocalHost(), 6007);
					//creating a new socket at the port 6007
		PrintWriter pout = new PrintWriter(S.getOutputStream(), true);
					//send bytes to the server
		Scanner scan = new Scanner(System.in);
					//allows the user to enter a message
		System.out.print("\nEnter message to send to Server: ");
		String input = scan.nextLine(); //takes string as an input and prints it later
		pout.println(input);

		
		InputStream inst = S.getInputStream();
					//to catch the stream sent by the server
		BufferedReader br = new BufferedReader(new InputStreamReader(inst));
					//this helps to save the Stream into the the buffer
		String output = br.readLine();
					//converts stream to string
		System.out.println("\nServer: "+output+"\n");
					//printing the string
		scan.close(); // closing the connection unless ran again
	}
}
