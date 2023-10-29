/**
 * Quote server listening to port 6017.
 *
 */
import java.net.*;
import java.io.*;

public class QuoteServer
{
  public static void main(String[] args) {
	//quotes
		String Quotes[] = {"The best preparation for tomorrow is doing your best today!",
						   "Be faithful to that which exists within yourself!",
						   "Don't judge everyday by harvest you reap, but by the seeds you plant!",
						   "When the sun is shining you can do anything; no mountain is too high, no trouble too difficult to overcome! ",
						   "Happiness is not something you postpone for future, its somthing you design for your present! ",
						   "One book, One pencil, One child and One Teacher can change the world!",
						   "If you accept the expectations of others, espicially the negative ones, then you will never change the outcome!",
						   "Remember! Today is the onl day, Yesterday is gone!",
						   "When the love of power becomes power of love, the world will know peace!",
						};

		try {
			
			ServerSocket socket = new ServerSocket(6017);
							//new socket made on port 6017

			/*now listen for connections */					
			while (true) {
				Socket client = socket.accept();
				PrintWriter pout = new PrintWriter(client.getOutputStream(), true);
							//send bytes to the client
				int random_quote = (int)(Math.random()*(Quotes.length));
							//used to generate random quote from the string of quotes up there
				pout.println("Quote of The Day:\n"+Quotes[random_quote]); //prints the quote
				pout.println("/n");

				client.close(); //closing the connection until ran again in the terminal
				}
			}

		catch (IOException ioe) {
			System.err.println(ioe);
			}
		}
}