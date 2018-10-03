import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

public class Object {

	int x, y, width, height;
	boolean moving;
	
	
	public Object(int x, int y) {
		this.x = x;
		this.y = y;
		moving = false;
		height = 16;
		width = 16;
	}
	
	
	
	
	
	

	public void paint(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillOval(x, y, height, width);
	}
	
	public void MousePressed(MouseEvent e) {
		if(inBounds(e.getX(), e.getY())) {
			moving = true;
		}
	}
	
	public void MouseReleased(MouseEvent e) {
		
		if(moving) {
			x = e.getX() - width / 2;
			y = e.getY() - height / 2;
			moving = false;
		}
	}
	
	
	public boolean inBounds(int x, int y) {
		return (x >= this.x && x <= this.x + width && 
				y >= this.y && y <= this.y + height);
	}
	
	
}
