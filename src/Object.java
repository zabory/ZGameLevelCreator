import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

public class Object {

	int x, y, width, height, startX, startY, MX, MY;
	boolean moving, gridMove;
	
	
	public Object(int x, int y) {
		this.x = x;
		this.y = y;
		moving = false;
		height = 16;
		width = 16;
	}
	
	
	
	
	public void move(int x, int y) {
		gridMove = true;
		startX = x;
		startY = y;
	}
	

	public void paint(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillOval(x, y, height, width);
	}
	
	public void MousePressed(int x, int y) {
		if(inBounds(x, y)) {
			moving = true;
		}
	}
	
	public void MouseReleased(MouseEvent e) {
		MX = e.getX();
		MY = e.getY();
		if(moving) {
			int mouseX, mouseY;
			mouseX = e.getX();
			mouseY = e.getY();
		x = (mouseX / width) * width;
		y = (mouseY / height) * height;
			moving = false;
		}
	}
	
	
	public boolean inBounds(int x, int y) {
		return (x >= this.x && x <= this.x + width && 
				y >= this.y && y <= this.y + height);
	}
	
	public void stopMove() {
		gridMove = false;
		x = x + (startX - MX);
		y = y + (startY - MY);
	}
	
}
