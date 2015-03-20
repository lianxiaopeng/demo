import java.awt.Color;
import java.awt.Graphics;


public class Missile {
	private int x , y;
	public static final int xSpeed = 5;
	public static final int ySpeed = 5;
	public static final int width = 10;
	public static final int heigth = 10;
	private boolean good ;
	private boolean live = true;
    private TankClient tc;
	private Tank.Direction direction = Tank.Direction.STOP;
	public Missile(int x, int y ,Tank.Direction direction,boolean good,TankClient tc) {
		super();
		this.x = x;
		this.y = y;
		this.direction = direction;
		this.good = good;
		this.tc = tc;
	}
	public void draw(Graphics g){
		Color c = g.getColor();
		if(good == true){
			g.setColor(Color.RED);
		}else g.setColor(Color.BLUE);
		
		g.fillOval(x, y, width, heigth);
		g.setColor(c);
		move();	
	}
	
	
	public void move(){
		switch(direction){
		case L :x -= xSpeed;break;
		case LU :x -= xSpeed; y -= ySpeed;break;
		case U :y -= ySpeed;break;
		case RU :x += xSpeed; y -= ySpeed;break;
		case R :x += xSpeed;break;
		case RD :x += xSpeed; y += ySpeed;break;
		case D:y += ySpeed;break;
		case LD:x -= xSpeed; y += ySpeed;break;
		case STOP:break;
		}
		if(x<0||y<0||x>TankClient.Game_Width||y>TankClient.Game_Height){
			setLive(false);
		}
		for (int i = 0; i < tc.robotTanks.size(); i++) {
			if(tc.robotTanks.get(i).isLive()==true){
				if(getRect().isMeet(tc.robotTanks.get(i).getRect())){
					tc.explodes.add(new Explode(x, y, direction, tc));
					hitTank(tc.robotTanks.get(i));
				}
			}
		}
		
		
	}
	public boolean isLive() {
		return live;
	}
	public void setLive(boolean live) {
		this.live = live;
	}
	public Rectangle getRect(){
		return new Rectangle(x,y,width,heigth);
	}
	public boolean hitTank(Tank t){
		if(t != null&&t.isLive()==good){
		//ÉèÖÃÌ¹¿ËËÀÍö
			t.setLive(false);
			//ÉèÖÃ×Óµ¯ËÀÍö
			setLive(false);
			return true;
		}else return false;
		
	}
	

}
