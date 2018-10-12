import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Random;

public class ClientThread extends Thread {

    BufferedReader in ;
    PrintStream out ;
    String name;
    Random random;

    public ClientThread(Socket s, String name){
        try {
            in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            out = new PrintStream(s.getOutputStream());
            this.name = name;
        }catch (Exception ex){
            System.err.println(ex);
        }
    }

    @Override
    public void run() {
        try {
            random = new Random();
            int num = random.nextInt(2);
            out.println(num);
            System.out.println(name + " send number " + num);
            System.out.println("Server's response: "  + in.readLine());
        }catch(Exception ex){
            System.err.println(ex);
        }
    }




}