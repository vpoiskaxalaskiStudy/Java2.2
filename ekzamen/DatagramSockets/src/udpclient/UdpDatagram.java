package udpclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Scanner;

public class UdpDatagram implements Runnable {
    private DatagramSocket datagramSocket;
    private String clientName;

    public UdpDatagram() throws SocketException {
        datagramSocket=new DatagramSocket();
    }

    public DatagramSocket getDatagramSocket() {
        return datagramSocket;
    }

    public void sendDatagram() throws IOException {
        System.out.print("Введите своё имя для регистрации вас на сервере: ");
        Scanner scanner=new Scanner(System.in);
        String name="<name>"+scanner.nextLine();
        clientName=name;

        byte[] buffer;
        buffer=name.getBytes();
        DatagramPacket datagramPacket=new DatagramPacket(buffer,buffer.length, InetAddress.getLocalHost(),10000);
        datagramSocket.send(datagramPacket);







    }
    public void getClients() throws IOException {
        Scanner scanner=new Scanner(System.in);
        String name="<starttexting>"+scanner.nextLine();

        byte[] buffer;
        buffer=name.getBytes();
        DatagramPacket datagramPacket=new DatagramPacket(buffer,buffer.length, InetAddress.getLocalHost(),10000);
        datagramSocket.send(datagramPacket);
    }



    public void receiveDatagram() throws IOException {
        byte[] buffer=new byte[10000];
        DatagramPacket datagramPacket=new DatagramPacket(buffer,buffer.length);
        datagramSocket.receive(datagramPacket);
        System.out.println(new String(datagramPacket.getData()));
    }

    @Override
    public void run() {
        System.out.println("Введите отправителя и сообщение: ");
        Scanner scanner=new Scanner(System.in);
        String receiver="<receiver>"+scanner.nextLine();

        byte[] buffer;
        buffer=(clientName+ receiver).getBytes();
        DatagramPacket datagramPacket= null;
        try {
            datagramPacket = new DatagramPacket(buffer,buffer.length, InetAddress.getLocalHost(),10000);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        try {
            datagramSocket.send(datagramPacket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
