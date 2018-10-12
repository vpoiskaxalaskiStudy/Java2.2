package udpserver;

import java.net.InetAddress;

public class Client {
    private String name;
    private InetAddress inetAddress;
    private int port;

    public Client(String Name,InetAddress address,int Port)
    {
        name=Name;
        inetAddress=address;
        port=Port;
    }

    public InetAddress getInetAddress() {
        return inetAddress;
    }

    public String getName() {

        return name;
    }

    public int getPort() {
        return port;
    }
}
