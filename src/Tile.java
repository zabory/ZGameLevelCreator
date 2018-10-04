import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

public class Tile {

	int x, y, width, height, startX, startY, MX, MY;
	boolean moving, gridMove;
	
	public Tile(int x, int y) {
		this.x = x;
		this.y = y;
		width = 16;
		height = 16;
		moving = false;
		gridMove = false;
	}
	
	
	
	
	public void paint(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(x, y, height, width);
	}
	
	public void MousePressed(int x, int y) {
		if(inBounds(x, y)) {
			moving = true;
		}
	}
	
	public void MouseReleased(MouseEvent e) {
		MX = e.getX();
		MY = e.getY();
		int mouseX, mouseY;
		if(moving) {
			mouseX = e.getX();
			mouseY = e.getY();
		x = (mouseX / width) * width;
		y = (mouseY / height) * height;
			moving = false;
		}
	}
	
	public void move(int x, int y) {
		gridMove = true;
		startX = x;
		startY = y;
	}
	
	public boolean inBounds(int x, int y) {
		return (x >= this.x && x <= this.x + width && 
				y >= this.y && y <= this.y + height);
	}	
	public void stopMove() {
		gridMove = false;
		moving = false;
		x = x + (startX - MX);
		y = y + (startY - MY);
		System.out.println("Moved");
	}	
	
}
