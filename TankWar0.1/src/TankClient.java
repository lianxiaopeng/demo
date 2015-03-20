import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class TankClient extends Frame{

	
	public void lauchFrame(){
		setLocation(200, 100);
		setSize(800, 600);
				
		setVisible(true);
	}
	
	

	public static void main(String[] args) {

		TankClient tc = new TankClient();
		tc.lauchFrame();
	}

}
