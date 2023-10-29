/**
 * An echo server listening on port 6007. This server reads from the client
 * and echoes back the result. 
 */

import java.net.*;
import java.io.*;

public class  EchoServer
{
 //Your code is here
 public static void main(String[] args) {
    try {
        ServerSocket S = new ServerSocket(6007);
                    //making a new socket on port 6007
        while (true) {
            Socket Client = S.accept();
                            // this will be used to accept client request
            InputStream inst = Client.getInputStream();
                            // to get stream by client
            BufferedReader br = new BufferedReader(new InputStreamReader(inst));
                            // to save the stream got into the buffer
            String Clientreply = br.readLine();
                            //converted the stream into string
            System.out.println("\nClient: "+Clientreply); //printing the string
            PrintWriter pout = new PrintWriter(Client.getOutputStream(), true);
                            //send bytes to the client via the output stream
            String echoback;//to save the string which was echod back
            if(Clientreply.length() != 0)
            {
                echoback = Clientreply.replace("Client", "Server");
                pout.println(echoback);
            }    
            else
            {
                echoback  = "Client didn't say anything.";
                pout.println(echoback);
            }
            }
                        //checking is there is an empty string sent by the client, if not then server replaces client
            Client.close();//closing the connection until ran again
            }
        }
    
    //IOException handling
    catch (IOException ioe) {
        System.err.println(ioe);
        }
    }
}
