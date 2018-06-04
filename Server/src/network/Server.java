package network;
import java.io.*;
import java.net.*;
public	class Server {
	// ip address 192.168.166.7 , port 12345
		//check in the client what is the code, how the connection is established, how is the server providing the provision
	public static void main(String args[]) {
		String line;
			try {
					ServerSocket sockfd = new ServerSocket(6543);
					System.out.println("Server initialization ..."+sockfd);
			while (true) {
					Socket newsockfd = sockfd.accept();
					System.out.println("New client, socket "+newsockfd);
					BufferedReader in = new BufferedReader(new InputStreamReader( newsockfd.getInputStream()));
					PrintWriter out = new PrintWriter(new BufferedWriter (new OutputStreamWriter (newsockfd.getOutputStream())),true);
					boolean salir = false;
		    while(!salir) {
		    		line = in.readLine(); //read client socket
		    		if (line!=null) {
		    			out.println(line);
		    			} //write client socket
		    		else {
		    			salir = true;
		    		} // close client socket
		    }
		    newsockfd.close();
			}
			
			} catch (Exception e) {
				e.printStackTrace();
			}
			}
	}