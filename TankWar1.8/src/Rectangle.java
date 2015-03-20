
public class Rectangle {

	int x,y;
	int width,height;
	public Rectangle(int x, int y, int width, int height) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	public boolean isMeet(Rectangle rect){
		    int dis = (x - rect.x)*(x - rect.x) + (y - rect.y)*(y - rect.y);
			if(dis<(width+rect.width)*(width+rect.width))
				return true; 
			else return false;
		
	}
	
}
