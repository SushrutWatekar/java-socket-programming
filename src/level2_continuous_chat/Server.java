package level2_continuous_chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String args[]) throws Exception{
        int port = 5000;

        ServerSocket serverSocket = new ServerSocket(port);

        System.out.println("Server has started on: "+port);
        System.out.println("Waiting on client");

        //accept connection
        Socket socket = serverSocket.accept();
        System.out.println("Client connected");

        /*
        .getInputStream - > to get data in raw format (bytes)
        InputStreamReader - > converts raw data into characters
        BufferReader - > adds buffering, makes things look good, and line parsing functions
         */
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String message = in.readLine();
        System.out.println("Sever Received: "+message);

        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        String clientMessage = "";

        while(!clientMessage.equalsIgnoreCase("exit")){

            // read messages from client
            clientMessage = in.readLine();
            System.out.println("Server Received: " + clientMessage);

            // Stop if client exits
            if (clientMessage.equalsIgnoreCase("exit")) {
                break;
            }

            // Server response through terminal
            System.out.print("Server's Terminal: ");
            String serverResponse = console.readLine();

            // Send response to client
            out.println(serverResponse);
            System.out.println("Server Sent: " + serverResponse);
        }
        socket.close();
        serverSocket.close();

        System.out.println("Connection closed");

    }
}
