import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;


public class Tank {
	private int x , y;
	public static final int xSpeed = 5;
	public static final int ySpeed = 5;
	private boolean bL = false,bU = false,bR = false,bD = false;
    enum Direction{L,LU,U,RU,R,RD,D,LD,STOP}
    private Direction direction = Direction.STOP;
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

}
