import java.io.IOException;
import java.net.*;

/**
 * 该协议用于局域网内文件传输
 * 广播接收端口号：0xBBBB
 * 服务端口号：0xF3F3
 */

public class Protocol {
    public static final int BROADCAST_PORT = 0xBBBB;
    public static final int SERVICE = 0xF3F3;
    public static final byte[] BROADCAST_ADDR = new byte[4];

    static {
        for(int i = 0; i < BROADCAST_ADDR.length; ++i){
            BROADCAST_ADDR[i] = (byte) 0xff;
        }
    }

    public Protocol(){

    }

    public void send_broadcast() throws IOException {
        InetAddress adds = InetAddress.getByAddress(BROADCAST_ADDR);
        String message = "test";
        DatagramSocket ds = new DatagramSocket();
        DatagramPacket dp = new DatagramPacket(message.getBytes(),message.length(), adds, BROADCAST_PORT);
        ds.send(dp);
        ds.close();
    }

    public void receive_broadcast(){
        DatagramSocket ds = null;
        DatagramPacket dp = null;
        byte[] buf = new byte[1024];
        StringBuffer sbuf = new StringBuffer();

    }
}
