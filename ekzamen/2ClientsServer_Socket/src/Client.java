import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Client  {


    public static void main(String[] args) {

        try {
            Socket clientSocket = new Socket(InetAddress.getLocalHost(), 8030);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintStream out = new PrintStream(clientSocket.getOutputStream());
            ClientThread client1 = new ClientThread(clientSocket,"client1");
            ClientThread client2 = new ClientThread(clientSocket,"client2");
            client1.start();
            client1.sleep(1000);
            client2.start();
        }catch(Exception ex){
            System.err.println(ex);
        }
    }

}
