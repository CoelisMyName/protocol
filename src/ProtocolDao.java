import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import java.util.Arrays;

/**
 * 该协议用于局域网内文件传输
 * 广播接收端口号：0xBBBB
 * 服务端口号：0xF3F3
 */

public class ProtocolDao {
    public static final int SERVICE_PORT = 0xBBBB;

    public static final byte[] BROADCAST_ADDR = new byte[4];

    static {
        Arrays.fill(BROADCAST_ADDR, (byte) 0xff);
    }

    private int port;

    byte[] udp_rcv_buffer = new byte[2000];

    byte[] udp_snd_buffer = new byte[2000];

    byte[] tcp_buffer = new byte[2000];

    DatagramSocket udp_socket = new DatagramSocket(port);

    ServerSocket tcp_socket = new ServerSocket(port);

    public static class Host {
        public InetAddress address;
        public int port;
        public Host(InetAddress address, int port){
            this.address = address;
            this.port = port;
        }
    }


    public static class FileDescriptor {
        public String filename;
    }



    public ProtocolDao() throws IOException {
        port = SERVICE_PORT;
    }

    public ProtocolDao(int port) throws IOException {
        this.port = port;
    }

    public void send_broadcast() throws IOException {
        InetAddress adds = InetAddress.getByAddress(BROADCAST_ADDR);
        String message = "test";
        DatagramSocket ds = new DatagramSocket();
        DatagramPacket dp = new DatagramPacket(message.getBytes(),message.getBytes().length, adds, SERVICE_PORT);
        ds.send(dp);
        ds.close();
    }

    public void receive_broadcast() throws IOException {
        DatagramSocket ds = new DatagramSocket(SERVICE_PORT);
        DatagramPacket dp = new DatagramPacket(udp_rcv_buffer, udp_rcv_buffer.length);
        ds.receive(dp);

    }

    public void getHosts(){

    }

    public void sendFile(InetAddress address, File file){

    }

    public void sendFile(InetAddress address, int port, File file){

    }

    /**
     *
     * @return 网络文件输入流
     * @throws IOException
     * ssdasd
     */

    public InputStream receiveFile() throws IOException {
        Socket socket = tcp_socket.accept();
        InputStream inputStream = socket.getInputStream();
        int length = inputStream.read(tcp_buffer);
        return null;
        
    }
}
