package editor;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;

import elements.Object;
import elements.Tile;

public class Placeables {
	int size;
	int x, y;
	String type;
	int height = 16;
	int width = 16;
	int mouseX, mouseY;
	String oType;
	boolean canPlace;
	Color c;
	
	public Placeables(int x, int y, String type, String oType) {
		this.x = x;
		this.y = y;
		this.type = type;
		size = 1;
		this.oType = oType;
		canPlace = false;
		c = Color.RED;
	}
	
	public void keyPressed(KeyEvent e) {
		if(type.equals("Tile")) {
		if(e.getKeyCode() == 91 && size > 1) {
			size--;
		}else if(e.getKeyCode() == 93 && size < 5) {
			size++;
		}
		System.out.println(size);
	}
	}
	public void update() {		
		
	}
	
	public void paint(Graphics g) {
		if(type.equals("Tile")) {
		int size2 = ((size * 2) - 1) ;
		for(int i = 0; i < size2; i++) {
			for(int j = 0; j < size2; j++) {
				g.fillRect(x - (((size2 - 1) * width) / 2) + (((size2 - 1) - j) * width), y - (((size2 - 1) * height) / 2) + (((size2 - 1) - i) * height), height, width);
			}
		}
		}else if(type.equals("Object")) {
			g.setColor(c);
			g.fillOval(x, y, width, height);
			g.setColor(Color.BLACK);
		}
	}
	
	public void mousePressed(MouseEvent e) {
		
	}
	
	public void mouseReleased(MouseEvent e) {

	}
	
	public void mouseMoved(MouseEvent e, fieldHandler f) {
			mouseX = e.getX();
			mouseY = e.getY();
		x = (mouseX / width) * width;
		y = (mouseY / height) * height;
		
		if(type.equals("Object")) {
			if(f.canPlace(mouseX, mouseY)) {
				c = Color.GREEN;
				canPlace = true;
			}else {
				c = Color.RED;
				canPlace = false;
			}
		}
		
		
	}
	
	public boolean getValid() {
		System.out.println(canPlace);
		return canPlace;
	}
	
	
	
	public String getType() {
		return type;
	}
	
	
	public Object toObject() throws FileNotFoundException {
		Object o = new Object(x,y,-1,oType);
		return o;
	}
	
	public Tile[] toTile() {
		Tile[] t = new Tile[(size * 2 - 1) * (size * 2 - 1)];
		int counter = 0;
		int size2 = ((size * 2) - 1) ;
		for(int i = 0; i < size2; i++) {
			for(int j = 0; j < size2; j++) {
				t[counter] = new Tile(x - (((size2 - 1) * width) / 2) + (((size2 - 1) - j) * width), y - (((size2 - 1) * height) / 2) + (((size2 - 1) - i) * height));
				counter++;
			}
		}
		return t;
	}
	
}
