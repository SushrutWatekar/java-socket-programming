package level4_broadcast.level3_multithreaded_server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

// Shared client list + broadcast feature

public class ClientHandler extends Thread {

    static ArrayList<ClientHandler> clients = new ArrayList<>();

    Socket socket;
    PrintWriter out;
    BufferedReader in;

    public ClientHandler(Socket socket) {
        this.socket = socket;
        clients.add(this);
        System.out.println("Client connected: " + socket.getInetAddress());
    }

    public void broadcastMessage(String message){

        for(ClientHandler client : clients){

            if(client != this){
                client.out.println(message);
            }
        }
    }

    @Override
    public void run() {

        try {
            // comms setup
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            while (true) {
                String clientMessage = in.readLine();

                // client disconnected
                if (clientMessage == null) {
                    break;
                }

                // exit command
                if (clientMessage.equalsIgnoreCase("exit")) {
                    break;
                }

                //for server logs
                System.out.println("Received: " + clientMessage);

                // broadcast message
                broadcastMessage(clientMessage);
            }

        } catch (Exception e) {
            System.out.println("Client Disconnected");

        } finally {

            try {
                clients.remove(this);
                socket.close();
                System.out.println("Connection closed");

            } catch (Exception e) {
                System.out.println("Error closing socket");
            }
        }
    }


}
