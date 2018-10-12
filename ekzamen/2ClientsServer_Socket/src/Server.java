
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class Server {

    static ArrayList<String> list = new ArrayList<String>();

    public static void main(String[] args) {
        ReentrantLock locker = new ReentrantLock(); // создаем заглушку
        list.add("Savchuk");list.add("Ermakov");list.add("Pitalenko");
        try{
            ServerSocket  serverSocket = new ServerSocket(8030);
            System.out.println("Server Socket wait ...");
            Socket clientSocket = serverSocket.accept();
            while(true){
            ServerThread  thread = new ServerThread(clientSocket, list, locker);
            thread.run();
            }
        }catch(Exception ex){
            System.err.println(ex);
        }
    }
}
