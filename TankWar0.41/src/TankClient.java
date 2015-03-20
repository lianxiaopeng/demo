import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Box.Filler;


public class TankClient extends Frame{

	int x = 0,y = 30;
	Image imageSreen = null;
	public void lauchFrame(){
		setLocation(200, 100);
		setSize(800, 600);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		setResizable(false);
		setBackground(Color.GREEN);
		setVisible(true);
		new Thread(new PaintThread()).start();
	}
	@Override
	public void paint(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.red);
		g.fillOval(x, y, 30, 30);
		g.setColor(c);
		x += 10;
		
	}
	@Override
	public void update(Graphics g) {
		// TODO Auto-generated method stub
		if (imageSreen == null) {
			imageSreen = this.createImage(800, 600);
			
			
		}
		Graphics imageG = imageSreen.getGraphics();
		Color c = imageG.getColor();
		imageG.setColor(Color.GREEN);
		imageG.fillRect(0, 0, 800, 600);
		
		imageG.setColor(c);
		
		paint(imageG);
		g.drawImage(imageSreen, 0, 0, null);
		
		
	}
	
	private class PaintThread implements Runnable{

		@Override
		public void run() {
            try{
			while(true){
				repaint();
				Thread.sleep(100);
				
			}
			}catch(Exception e){
				e.printStackTrace();
				
			}
			
		}
		
	}

	public static void main(String[] args) {

		TankClient tc = new TankClient();
		tc.lauchFrame();
	}

}
