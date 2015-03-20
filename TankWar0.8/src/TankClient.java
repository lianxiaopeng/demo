import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Box.Filler;


public class TankClient extends Frame{

	public static final int Game_Width = 800;
	public static final int Game_Height = 600;
	Tank myTank = new Tank(0,30);
	Image imageSreen = null;
	public void lauchFrame(){
		setLocation(200, 100);
		setSize(Game_Width, Game_Height);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		setResizable(false);
		setBackground(Color.GREEN);
		addKeyListener(new KeyListener());
		setVisible(true);
		new Thread(new PaintThread()).start();
		
	
	}
	@Override
	public void paint(Graphics g) {
		myTank.draw(g);
		
	}
	//双缓冲机制
	@Override
	public void update(Graphics g) {
		// TODO Auto-generated method stub
		if (imageSreen == null) {
			imageSreen = this.createImage(Game_Width, Game_Height);
			
			
		}
		Graphics imageG = imageSreen.getGraphics();
		Color c = imageG.getColor();
		imageG.setColor(Color.GREEN);
		imageG.fillRect(0, 0, Game_Width, Game_Height);
		
		imageG.setColor(c);
		
		paint(imageG);
		g.drawImage(imageSreen, 0, 0, null);
		
		
	}
	//启动一个线程，不断地重画
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
	private class KeyListener extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e) {
				myTank.keyPressed(e);
					
		}
	}

	public static void main(String[] args) {

		TankClient tc = new TankClient();
		tc.lauchFrame();
	}

}
