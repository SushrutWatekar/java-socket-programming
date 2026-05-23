package level3_multithreaded_server.level2_echo_and_continuous_chat;


import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {

    public static void main(String args[]) throws Exception{
        int port = 5000;

        ServerSocket serverSocket = new ServerSocket(port);

        while(true) {
            Socket socket = serverSocket.accept();

            ClientHandler clientHandler = new ClientHandler(socket);

            clientHandler.start();
        }


    }
}
