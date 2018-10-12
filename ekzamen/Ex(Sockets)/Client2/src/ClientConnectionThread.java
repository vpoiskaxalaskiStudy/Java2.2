import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientConnectionThread extends Thread {
    Client2 client;
    Socket socket;

    ClientConnectionThread(Client2 client) {
        this.client = client;
    }

    public void run() {
        try {
            System.out.println("Подключение к серверу " + this.client.server_address + " порт:"+this.client.server_port);
            socket = new Socket(this.client.server_address, this.client.server_port);
            BufferedReader dis = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (this.client.alive) {
                String msg = dis.readLine();
                if (msg == null) return;
                System.out.println(msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
            new Client2("127.0.0.3" , Integer.parseInt("3350"));
    }
}
