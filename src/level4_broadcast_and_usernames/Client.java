package level4_broadcast_and_usernames;

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

        //listener thread
        Thread listener = new Thread(() -> {

            try {

                String serverMessage;

                while ((serverMessage = in.readLine()) != null) {

                    System.out.println(serverMessage);

                }

            } catch (Exception e) {

                System.out.println("Disconnected from server");

            }

        });

        listener.start();

        //loop for continuous chat
        while (true) {

            clientMessage = console.readLine();

            if (clientMessage.equalsIgnoreCase("exit")) {
                break;
            }
            out.println(clientMessage);
        }


        socket.close();

        System.out.println("Connection closed");
    }

}
