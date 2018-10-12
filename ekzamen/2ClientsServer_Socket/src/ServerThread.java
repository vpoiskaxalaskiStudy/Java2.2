import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class ServerThread extends  Thread {

    PrintStream out;
    BufferedReader in;
    Socket socket;
    List<String> serverResourse;
    ReentrantLock loker;

    public ServerThread(Socket s, List<String> res, ReentrantLock lock){
        try {
            out = new PrintStream(s.getOutputStream());
            in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            socket = s;
            serverResourse = res;
            loker=lock;
        }catch (Exception ex){
            System.out.println(ex);
        }
    }

    @Override
    public void run() {
        loker.lock();
        try{
            int clientNumber  =  new Integer(in.readLine());
            out.println(serverResourse.get(clientNumber));
        }catch(Exception ex){
            System.out.println(ex);
        }finally {
            loker.unlock();
        }

    }
}
