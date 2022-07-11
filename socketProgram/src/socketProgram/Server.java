package socketProgram;

import java.net.*;
import java.io.*;


public class Server {
	private ServerSocket serverSocket;
	
	public void start(int port) throws IOException {
		serverSocket = new ServerSocket(port);
		System.out.println("Server started...");
		while (true) {
			new ClientHandler(serverSocket.accept()).start();
		}
            
		
	}
	
	public void stop() throws IOException {
		serverSocket.close();
	}
	
	private static class ClientHandler extends Thread{
		private Socket clientSocket;
		private PrintWriter out;
		private BufferedReader in;
		
		
		
		public ClientHandler(Socket socket) {
			System.out.println("Client " + socket.toString() + " connected.");
			this.clientSocket = socket;
		}
		
		public void run()  {
            try {
				out = new PrintWriter(clientSocket.getOutputStream(), true);
				in = new BufferedReader(
			              new InputStreamReader(clientSocket.getInputStream())
			         );
			            
	            String inputLine;
	            while ((inputLine = in.readLine()) != null) {
	                if (".".equals(inputLine)) {
	                    out.println("bye");
	                    break;
	                }
	                System.out.println(this.clientSocket.getPort() + ": " + inputLine );
	                out.println(inputLine);
	            }

	            in.close();
	            out.close();
	            clientSocket.close();
	            
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
           
    }
	}
	
}