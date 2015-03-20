import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;


public class DataNewPackage {
	public Tank tank;
	public DataNewPackage(Tank tank){
		this.tank = tank;
		
	}
	public void send(DatagramSocket ds ,String IP,int port){
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(baos);
		try {
			dos.writeInt(tank.x);
			dos.writeInt(tank.y);
			dos.writeBoolean(tank.good);
			dos.writeBoolean(tank.isLive());
			dos.writeInt(tank.uid);
			DatagramPacket dp = new DatagramPacket(baos.toByteArray(),baos.toByteArray().length,new InetSocketAddress("127.0.0.1", TankServer.udpPort));
			ds.send(dp);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	

}
