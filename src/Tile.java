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
	
	
	
	
	public void paint(Graphics g, boolean n, boolean e, boolean s, boolean w) {
		g.setColor(Color.BLACK);
	
		if(!n) {
			paintLine(g, x, y, x + width, y, 2);
		}
		if(!e) {
			paintLine(g, x + width, y, x + width, y + height, 2);
		}
		if(!s) {
			paintLine(g, x + width, y + height, x, y + height, 2);
		}
		if(!w) {
			paintLine(g, x, y + height, x, y, 2);
		}
		g.drawLine(x, y, x + width, y + height);
	}
	
	public void MousePressed(int x, int y) {
		if(inBounds(x, y)) {
			moving = true;
		}
	}
	
	public void update() {
		
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
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void paintLine(Graphics g, int x, int y, int x2, int y2, int thickness) {
		thickness /= 2;
		int[] xPoints = {x + thickness,x2 + thickness, x2 - thickness, x - thickness};
		int[] yPoints = {y - thickness, y2 - thickness, y2 + thickness, y + thickness};
		g.fillPolygon(xPoints, yPoints, 4);
	}
	
	
	
}
