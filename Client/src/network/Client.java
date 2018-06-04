package network;

import java.io.*;
import java.net.*; 

public class Client {

    static final int serverPort = 6543;
    static InetAddress serverAddr;
	public static void main(String[] args) throws IOException {
		try {
	    serverAddr = InetAddress.getByName("172.20.10.2"); //server address 
		Socket sockfd = new Socket(serverAddr,serverPort);
		System.out.println("Local connection" + serverAddr);
		BufferedReader in = new BufferedReader( new InputStreamReader(sockfd.getInputStream()));
		PrintWriter out = new PrintWriter(new BufferedWriter (new OutputStreamWriter(sockfd.getOutputStream())), true);
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
		String userInput; //Keyboard input
		while ((userInput = stdIn.readLine()) != null) 
			{
			if (userInput.equals("0")) break; // ends with “.”
				out.println(userInput); //write socket
				System.out.println("echo: " + in.readLine()); //read socket
			}
		out.close();
		in.close();
		stdIn.close();
		sockfd.close();
		}
		catch (UnknownHostException e) {
			System.err.println("Unknown: " + serverAddr);
			System.exit(1);
			} 
		catch (IOException e) {
			System.err.println("Error I/O for " + serverAddr); System.exit(1);
			} 
		} 
	}
