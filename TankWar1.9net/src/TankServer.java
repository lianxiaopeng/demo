import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class TankServer {
	public static final int Server_Port = 8888;
	public static int uid = 100;
	public static final int udpPort = 9999;
	public List<Client> clients = new ArrayList<Client>(); 
	 public  void start() {
		try {
			ServerSocket serverSocket = new ServerSocket(Server_Port);
			new Thread(new UDPThread()).start();
		    while(true){
				Socket socket = serverSocket.accept();
				System.out.println("conection addr-" + socket.getInetAddress()+":"+socket.getPort());
				DataInputStream dis = new DataInputStream(socket.getInputStream());
				int udpPort = dis.readInt();
				clients.add(new Client(socket.getLocalAddress().getHostAddress(),udpPort));
                for(Client value : clients){
                	System.out.println(value.IP + ":" +value.udpPort);
                	
                }
                new DataOutputStream(socket.getOutputStream()).writeInt(uid++);
		    }
		    
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		 
	}
	 public static void main(String[] args) {
		new TankServer().start();
	}
	 private class Client{
		 public Client(String IP , int udpPort){
			 this.IP = IP;
			 this.udpPort = udpPort;
			 
		 }
		 String IP;
		 int udpPort;
		 
	 }
	 private class UDPThread implements Runnable{

		@Override
		public void run() {
			try {
			DatagramSocket datagramSocket = new DatagramSocket(udpPort);
			byte[] b = new byte[1024];

			while(true){
				DatagramPacket p = new DatagramPacket(b, b.length);
				
				
					
				datagramSocket.receive(p);
				System.out.println("already accept pack");
				
				
			}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		 
	 }

}
