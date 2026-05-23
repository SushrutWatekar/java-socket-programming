package level3_multithreaded_server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class ClientHandler extends Thread {
    Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            //comm logic here
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

            String clientMessage = "";

            while (!clientMessage.equalsIgnoreCase("exit")) {

                // read messages from client
                clientMessage = in.readLine();
                System.out.println("Server Received: " + clientMessage);

                // Client disconnected
                if (clientMessage == null) {
                    break;
                }

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

            System.out.println("Connection closed");
        } catch (Exception e){
            System.out.println("Client Disconnected");
        }
    }


}
