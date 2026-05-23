package level3_multithreaded_server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception {
        String ip = "127.0.0.1";
        int port = 5000;

        Socket socket = new Socket(ip, port);
        System.out.println("Client connected to server");

        /*
        .getOutputStream -> to send raw data
        PrintWriter -> converts characters into bytes and gives us functions like println
        true (2nd arg) -> for autoflush, to not store in memory and send it to the server without delay
         */
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        // Receive messages from server
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        //Read Terminal
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        String clientMessage = "";

        //loop for continuous chat
        while (!clientMessage.equalsIgnoreCase("exit")) {

            // client types msg
            clientMessage = console.readLine(); //type msg in terminal
            System.out.println("Client Sent: " + clientMessage); //print it in client terminal
            out.println(clientMessage); //send it to server

            // Stop if client exits, stop immediately
            if (clientMessage.equalsIgnoreCase("exit")) {
                socket.close();
                System.out.println("Connection closed");
                break;
            }

            // Wait for server reply
            String serverReply = in.readLine();
            System.out.println("Server: " + serverReply);

        }
        socket.close();

        System.out.println("Connection closed");
    }

}
