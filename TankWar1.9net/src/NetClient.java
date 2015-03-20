import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;


public class NetClient {
	
	//传递UDP端口到服务器
	private static int UDP_PORT_START = 2233;
	private int udpPort;
	private TankClient tc;
	public NetClient(TankClient tc){
		udpPort = UDP_PORT_START ++;
		this.tc = tc;
		
	}
	public void connect(String IP,int port){
		Socket socket = null;
		DatagramSocket ds = null;
		try {
			socket = new Socket(IP,port);
		    DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
		    dataOutputStream.writeInt(udpPort);
		    int uid = new DataInputStream(socket.getInputStream()).readInt();
		    tc.myTank.uid = uid;
		    send(new DatagramSocket(udpPort));
		    
		    
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				socket.close();
				System.out.println(socket!=null);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public void send(DatagramSocket ds){
		 new DataNewPackage(tc.myTank).send(ds,"127.0.0.1",TankServer.Server_Port);
	}
	public void parse(){
		
	}
	
	private class udpThread implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true){
				try {
					new DatagramSocket(udpPort);
				} catch (SocketException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		
	}
	
	

}
