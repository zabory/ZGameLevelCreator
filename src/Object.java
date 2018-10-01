import java.awt.Graphics;
import java.awt.event.MouseEvent;

public class Object {

	int x, y, width, height;
	boolean moving;
	
	
	public Object(int x, int y, int height, int width) {
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		moving = false;
	}
	
	
	
	public void update() {
		
	}
	
	public void paint(Graphics g) {
		g.fillOval(x, y, height, width);
	}
	
	public void mousePressed(MouseEvent e) {
		if (e.getX() >= this.x && e.getX() <= this.x + width && 
				e.getY() >= this.y && e.getY() <= this.y + height) {
			moving = true;
		}
	}
	
	public void mouseReleased(MouseEvent e) {
		if(moving) {
			x = e.getX();
			y = e.getY();
			moving = false;
		}
	}
	
}
