import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Client2 {
    public boolean alive = true;
    public String server_address;
    public int server_port;

    Client2(String server_address, int server_port) {
        this.server_address = server_address;
        this.server_port = server_port;
        ClientConnectionThread cct = new ClientConnectionThread(this);
        cct.start();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String cmd = scanner.nextLine();
            try {
                PrintStream ps = new PrintStream(cct.socket.getOutputStream());
                ps.println(cmd);
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }
    }
}
