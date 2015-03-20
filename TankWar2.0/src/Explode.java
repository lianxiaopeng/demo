import java.awt.Color;
import java.awt.Graphics;


public class Explode {

	private int x , y;
	
	public   int width = 10;
	public   int heigth = 10;
	
	private boolean live = true;
    private TankClient tc;
	private Tank.Direction direction = Tank.Direction.STOP;
	public Explode(int x, int y ,Tank.Direction direction,TankClient tc) {
		super();
		this.x = x;
		this.y = y;
		this.direction = direction;
		this.tc = tc;
	}
	public void draw(Graphics g){
		Color c = g.getColor();
		g.setColor(Color.black);
		width -= 2;
		heigth -= 2;
		
		g.fillOval(x, y, width, heigth);
		g.setColor(c);
		if(width <=0 || heigth <= 0){
			live = false;
			
		}
			
	}
	public boolean isLive() {
		return live;
	}
	public void setLive(boolean live) {
		this.live = live;
	}
	
	
}
