import java.awt.Color;
import java.awt.Graphics;


public class Missile {
	private int x , y;
	public static final int xSpeed = 5;
	public static final int ySpeed = 5;
	public static final int width = 10;
	public static final int heigth = 10;
	
	private boolean live = true;
    private TankClient tc;
	private Tank.Direction direction = Tank.Direction.STOP;
	public Missile(int x, int y ,Tank.Direction direction,TankClient tc) {
		super();
		this.x = x;
		this.y = y;
		this.direction = direction;
		this.tc = tc;
	}
	public void draw(Graphics g){
		Color c = g.getColor();
		g.setColor(Color.black);
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
		if(tc.robotTank!=null){
			if(getRect().isMeet(tc.robotTank.getRect())){
				
				hitTank(tc.robotTank);
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
		if(t != null){
		//����̹������
			t.setLive(false);
			//�����ӵ�����
			setLive(false);
			return true;
		}else return false;
		
	}
	

}
