package udpserver;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.ArrayList;


public  class UdpDatagramServer implements Runnable  {

    private static ArrayList<Client> clients=new ArrayList<Client>();
    static DatagramSocket datagramSocket;

    static {
        try {
            datagramSocket = new DatagramSocket(10000);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void run() {
        byte[] buffer=new byte[1024];
        DatagramPacket datagramPacket=new DatagramPacket(buffer,buffer.length);

        try {
            datagramSocket.receive(datagramPacket);
            if(new String(datagramPacket.getData()).contains("<receiver>"))
            {
                String recieveContent=new String(datagramPacket.getData()).replaceAll("<name>","");
               String name=recieveContent.substring(0,recieveContent.indexOf('<'));
                String receiver=recieveContent.substring(recieveContent.indexOf('>')+1,recieveContent.indexOf('|'));
                String content=recieveContent.substring(recieveContent.indexOf('|')+1);

                for(int i=0;i<clients.size();i++)
                {
                    if(clients.get(i).getName().contains(receiver))
                    {
                        String resultMessage="Сообщение от "+name+": \n"+content;
                        byte[] sendBytes=resultMessage.getBytes();
                        DatagramPacket sendToReceiver=new DatagramPacket(sendBytes,sendBytes.length,clients.get(i).getInetAddress(),clients.get(i).getPort());
                        datagramSocket.send(sendToReceiver);
                        (new Thread(new UdpDatagramServer())).start();
                        return;

                    }
                }


            }
            if(new String(datagramPacket.getData()).contains("<name>"))
            {

                String name=new String(datagramPacket.getData()).replace("<name>","");
                System.out.println(name);
                byte[] bufferSend;
                bufferSend="Вы зарегистрированы!".getBytes();
                DatagramPacket sendPacket=new DatagramPacket(bufferSend,bufferSend.length,datagramPacket.getAddress(),datagramPacket.getPort());
                datagramSocket.send(sendPacket);
                clients.add(new Client(name,datagramPacket.getAddress(),datagramPacket.getPort()));
                (new Thread(new UdpDatagramServer())).start();
                return;
            }
            if(new String(datagramPacket.getData()).contains("<starttexting>"))
            {
                if(new String(datagramPacket.getData()).contains("да"))
                {
                    String allclients="";
                    for(int i=0;i<clients.size();i++)
                    {
                         allclients+=clients.get(i).getName()+"|";
                    }
                    byte[] sendBytes=allclients.getBytes();
                    DatagramPacket sendDGP=new DatagramPacket(sendBytes,sendBytes.length,datagramPacket.getAddress(),datagramPacket.getPort());
                    datagramSocket.send(sendDGP);
                    (new Thread(new UdpDatagramServer())).start();
                    return;
                }

            }


        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
