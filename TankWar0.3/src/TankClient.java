import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Box.Filler;


public class TankClient extends Frame{

	int x = 50,y = 100;
	public void lauchFrame(){
		setLocation(200, 100);
		setSize(800, 600);
		addWindowListener(new WindowAdapter() {@Override
		public void windowClosing(WindowEvent e) {
                   System.exit(0);
		}
		});
		setResizable(false);
		setBackground(Color.GREEN);
		setVisible(true);
		new Thread(new Move()).start();
	}
	@Override
	public void paint(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.red);
		g.fillOval(x, y, 50, 50);
		g.setColor(c);
		  x += 10;
		
	}
	private class Move implements Runnable{

		@Override
		public void run() {
			 try {
          while(true){
        	
             
   		   repaint();
   		  
			Thread.sleep(200);
		
          }
          
			 } catch (InterruptedException e) {
					e.printStackTrace();
				}
		}
		
	}
	

	public static void main(String[] args) {

		TankClient tc = new TankClient();
		tc.lauchFrame();
	}

}
