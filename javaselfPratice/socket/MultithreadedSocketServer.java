package socket;


import java.net.*;

public class MultithreadedSocketServer {
	public static void main(String[] args) throws Exception {
		try{
			ServerSocket server=new ServerSocket(8888);
			int counter=0;
			System.out.println("Server Started ....");
			while(true){
				System.out.println("loop");

				counter++;
				Socket serverClient=server.accept();  //server accept the client connection request+
				System.out.println("loop: " + serverClient);
				System.out.println(" >> " + "Client No:" + counter + " started!");
//				ServerClientThread sct = new ServerClientThread(serverClient,counter); //send  the request to a separate thread
//				sct.start();
			}
		}catch(Exception e){
			System.out.println(e);
		}
	}
}


