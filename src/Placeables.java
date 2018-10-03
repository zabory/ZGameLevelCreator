import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Placeables {
	int size;
	int x, y;
	String type;
	int height = 16;
	int width = 16;
	
	public Placeables(int x, int y, String type) {
		this.x = x;
		this.y = y;
		this.type = type;
		size = 1;
	}
	
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == 91 && size > 1) {
			size--;
		}else if(e.getKeyCode() == 93 && size < 5) {
			size++;
		}
		System.out.println(size);
	}
	
	public void update() {
		
	}
	
	public void paint(Graphics g) {
		g.fillOval(x, y, height, width);
	}
	
	public void mousePressed(MouseEvent e) {
		
	}
	
	public void mouseReleased(MouseEvent e) {

	}
	
	public void mouseMoved(MouseEvent e) {
			x = e.getX() - width / 2;
			y = e.getY() - height / 2;
		
	}
	
	public String getType() {
		return type;
	}
	
	
	public Object toObject() {
		Object o = new Object(x,y);
		return o;
	}
	
	public Tile[] toTile() {
		Tile[] t = new Tile[(size * 2 - 1) * (size * 2 - 1)];
		for(int i = 0; i < t.length; i++) {
			t[i] = new Tile(x,y);
		}
		return t;
	}
	
}
