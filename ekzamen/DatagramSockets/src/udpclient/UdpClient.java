package udpclient;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpClient {

    public static void main(String[] args) throws IOException {
        UdpDatagram udpDatagram=new UdpDatagram();
        udpDatagram.sendDatagram();
        udpDatagram.receiveDatagram();
        System.out.println("Начать переписку (да или нет)?");
        udpDatagram.getClients();
        udpDatagram.receiveDatagram();

        (new Thread(udpDatagram)).start();
        udpDatagram.receiveDatagram();


    }
}
