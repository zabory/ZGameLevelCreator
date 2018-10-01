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
	
}
