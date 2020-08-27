import java.io.File;
import java.io.IOException;
import java.net.*;

/**
 * 该协议用于局域网内文件传输
 * 广播接收端口号：0xBBBB
 * 服务端口号：0xF3F3
 */

public class Protocol {
    public static final int SERVICE = 0xBBBB;
    public static final byte[] BROADCAST_ADDR = new byte[4];

    public class Host {
        InetAddress address;
        int port;
        public Host(InetAddress address, int port){
            this.address = address;
            this.port = port;
        }
    }

    static {
        for(int i = 0; i < BROADCAST_ADDR.length; ++i){
            BROADCAST_ADDR[i] = (byte) 0xff;
        }
    }

    public Protocol(){

    }

    public void _send_broadcast_() throws IOException {
        InetAddress adds = InetAddress.getByAddress(BROADCAST_ADDR);
        String message = "test";
        DatagramSocket ds = new DatagramSocket();
        DatagramPacket dp = new DatagramPacket(message.getBytes(),message.length(), adds, SERVICE);
        ds.send(dp);
        ds.close();
    }

    public void receive_broadcast(){
        DatagramSocket ds = null;
        DatagramPacket dp = null;
        byte[] buf = new byte[1024];
        StringBuffer sbuf = new StringBuffer();

    }

    public void getHosts(){

    }

    public void sendFile(InetAddress address, File file){

    }

    public void receiveFile(){
        
    }
}
