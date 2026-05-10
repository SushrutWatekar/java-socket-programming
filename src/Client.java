import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception{
        String ip= "127.0.0.1";
        int port = 5000;

        Socket socket = new Socket(ip,port);
        System.out.println("Client connected to server");
    }
}
