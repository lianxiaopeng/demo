import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;


public class Tank {
	private int x , y;
	public static final int xSpeed = 5;
	public static final int ySpeed = 5;
	public static final int width = 30;
	public static final int heigth = 30;
	private boolean bL = false,bU = false,bR = false,bD = false;
    enum Direction{L,LU,U,RU,R,RD,D,LD,STOP}
    private Direction direction = Direction.STOP;
    private Direction lastDir = Direction.R;
    TankClient tc = null;
    private boolean good;
	public Tank(int x, int y,boolean good ,TankClient tc) {
		super();
		this.x = x;
		this.y = y;
		this.good = good;
		this.tc = tc;
	}
	
	public void draw(Graphics g){
		
		Color c = g.getColor();
		if(good == true)
		g.setColor(Color.red);
		else g.setColor(Color.BLUE);
		g.fillOval(x, y, width, heigth);
		g.setColor(c);
		//x += 10;
		switch(lastDir){
		case L :g.drawLine(x+width/2, y+heigth/2, x, y+heigth/2); break;
		case LU :g.drawLine(x+width/2, y+heigth/2, x, y);break;
		case U :g.drawLine(x+width/2, y+heigth/2, x+width/2, y);break;
		case RU :g.drawLine(x+width/2, y+heigth/2, x+width, y);break;
		case R :g.drawLine(x+width/2, y+heigth/2, x+width, y+heigth/2);break;
		case RD :g.drawLine(x+width/2, y+heigth/2, x+width, y+heigth);break;
		case D:g.drawLine(x+width/2, y+heigth/2, x+width/2, y+heigth);break;
		case LD:g.drawLine(x+width/2, y+heigth/2, x, y+heigth);break;
		case STOP:break;
		}
		move();
		
	}
	public void loacation(){
		if(bL&&!bR&&!bU&&!bD) direction = Direction.L;
		else if(bL&&!bR&&bU&&!bD) direction = Direction.LU;
		else if(!bL&&!bR&&bU&&!bD) direction = Direction.U;
		else if(!bL&&bR&&bU&&!bD) direction = Direction.RU;
		else if(!bL&&bR&&!bU&&!bD) direction = Direction.R;
		else if(!bL&&bR&&!bU&&bD) direction = Direction.RD;
		else if(!bL&&!bR&&!bU&&bD) direction = Direction.D;
		else if(bL&&!bR&&!bU&&bD) direction = Direction.LD;
		else if(!bL&&!bR&&!bU&&!bD) direction = Direction.STOP;;
	}
	public void move(){
		switch(direction){
		case L :x -= xSpeed;	lastDir = Direction.L;break;
		case LU :x -= xSpeed; y -= ySpeed;lastDir = Direction.LU;break;
		case U :y -= ySpeed;lastDir = Direction.U;break;
		case RU :x += xSpeed; y -= ySpeed;lastDir = Direction.RU;break;
		case R :x += xSpeed;lastDir = Direction.R;break;
		case RD :x += xSpeed; y += ySpeed;lastDir = Direction.RD;break;
		case D:y += ySpeed;lastDir = Direction.D;break;
		case LD:x -= xSpeed; y += ySpeed;lastDir = Direction.LD;break;
		case STOP:break;
		}
		//一步到位
		/*if(bL&&!bR&&!bU&&!bD) x -= xSpeed;
		else if(bL&&!bR&&bU&&!bD) {x -= xSpeed; y -= ySpeed;}
		else if(!bL&&!bR&&bU&&!bD) y -= ySpeed;
		else if(!bL&&bR&&bU&&!bD) {x += xSpeed; y -= ySpeed;}
		else if(!bL&&bR&&!bU&&!bD) x += xSpeed;
		else if(!bL&&bR&&!bU&&bD) {x += xSpeed; y += ySpeed;}
		else if(!bL&&!bR&&!bU&&bD) y += ySpeed;
		else if(bL&&!bR&&!bU&&bD) {x -= xSpeed; y += ySpeed;}
		else if(!bL&&!bR&&!bU&&!bD) ;*/
	}
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		switch(keyCode){
		case KeyEvent.VK_CONTROL :
			tc.missiles.add(fire());
			break;
		case KeyEvent.VK_LEFT :
		
		 bL = true;
		 break;
		case KeyEvent.VK_RIGHT :
		 bR = true;
		 break;
		case KeyEvent.VK_UP :
		 bU = true;
		 break;
		case KeyEvent.VK_DOWN:
		 bD = true;
		break;
			
		}
		loacation();
	}
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		switch(keyCode){
		case KeyEvent.VK_LEFT :
		 bL = false;
		 break;
		case KeyEvent.VK_RIGHT :
		 bR = false;
		 break;
		case KeyEvent.VK_UP :
		 bU = false;
		 break;
		case KeyEvent.VK_DOWN:
		 bD = false;
		break;
			
		}
		loacation();
	}
	public Missile fire(){
		
		return new Missile(x+width/2-Missile.width/2,y+heigth/2-Missile.heigth/2,lastDir);
	}

}
