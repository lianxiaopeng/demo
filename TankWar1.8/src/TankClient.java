import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box.Filler;


public class TankClient extends Frame{

	public static final int Game_Width = 800;
	public static final int Game_Height = 600;
	
	Tank myTank = new Tank(50,50,true,Tank.Direction.STOP,this);
	List<Tank> robotTanks = new ArrayList<Tank>();
	
	//Missile myMissile = null;
	List<Missile> missiles = new ArrayList<Missile>();
	List<Explode> explodes = new ArrayList<Explode>();
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
		robotTanks.add(new Tank(50,150,false,Tank.Direction.L,this));
		robotTanks.add(new Tank(150,50,false,Tank.Direction.R,this));
		robotTanks.add(new Tank(250,50,false,Tank.Direction.D,this));
		robotTanks.add(new Tank(250,100,false,Tank.Direction.RD,this));
		robotTanks.add(new Tank(150,350,false,Tank.Direction.R,this));
		
	
	}
	@Override
	public void paint(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.black);
		g.drawString("Missile:" + missiles.size(), 15, 40);
		g.setColor(c);
		myTank.draw(g);
		
		for (int i = 0; i < robotTanks.size(); i++) {
			if(robotTanks.get(i).isLive()==false)
				robotTanks.remove(i);
			else
			robotTanks.get(i).draw(g);
		}
		
		for (int i = 0; i < missiles.size(); i++) {
			if(missiles.get(i).isLive() == false){
				missiles.remove(i);
			}else {
				missiles.get(i).draw(g);
			}
		}
		for (int i = 0; i < explodes.size(); i++) {
			if(explodes.get(i).isLive() == false){
				explodes.remove(i);
			}else {
				explodes.get(i).draw(g);
			}
		}
		
		
		
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
		@Override
		public void keyReleased(KeyEvent e) {
			    myTank.keyReleased(e);
		}
	}

	public static void main(String[] args) {

		TankClient tc = new TankClient();
		tc.lauchFrame();
	}

}
