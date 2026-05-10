import java.net.*;
import java.io.*;
public class Server {

    public static void main(String args[]) throws Exception{
        int port = 5000;

        ServerSocket serverSocket = new ServerSocket(port);

        System.out.println("Server has started on: "+port);
        System.out.println("Waiting on client");

        Socket socket = serverSocket.accept();
        System.out.println("Client connected");

    }
}
