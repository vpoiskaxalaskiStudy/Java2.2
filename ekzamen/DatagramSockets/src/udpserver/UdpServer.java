package udpserver;

import java.io.IOException;

public class UdpServer {
    public static void main(String[] args) throws IOException {
        UdpDatagramServer udpDatagramServer=new UdpDatagramServer();
        (new Thread(udpDatagramServer)).start();


    }
}
