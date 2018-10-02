import java.awt.Font;
import java.awt.Graphics;

public class Button {

	int x,y,height,width;
	String name;
	Font f;
	
	public Button(int x, int y, int height, int width, String name) {
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		this.name = name;
		f = new Font("Courier New", Font.PLAIN, height - 2);
	}
	
	
	public void update() {
		
	}
	
	public void paint(Graphics g) {
		g.drawRect(x, y, width, height);
		g.setFont(f);
		g.drawString(name, x + 1, y + height - 3);
	}
	
	public boolean inBounds(int x, int y) {
		return (x >= this.x && x <= this.x + width && 
				y >= this.y && y <= this.y + height);
	}
	
	
	public String getName() {
		return name;
	}


	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}


	public int getHeight() {
		return height;
	}


	public void setHeight(int height) {
		this.height = height;
	}


	public int getWidth() {
		return width;
	}


	public void setWidth(int width) {
		this.width = width;
	}


	public Font getF() {
		return f;
	}


	public void setF(Font f) {
		this.f = f;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
