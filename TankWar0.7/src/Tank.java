import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;


public class Tank {
	int x , y;

	public Tank(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public void draw(Graphics g){
		Color c = g.getColor();
		g.setColor(Color.red);
		g.fillOval(x, y, 30, 30);
		g.setColor(c);
		//x += 10;
	}
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyCode = e.getKeyCode();
		switch(keyCode){
		case KeyEvent.VK_LEFT :
		 x -= 10;
		 break;
		case KeyEvent.VK_RIGHT :
		 x += 10;
		 break;
		case KeyEvent.VK_UP :
		 y -= 10;
		 break;
		case KeyEvent.VK_DOWN:
		y += 10;
		break;
			
		}
				
				
	}

}
