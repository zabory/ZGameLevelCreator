import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Button {

	int x,y,height,width,startX,startY;
	String name;
	Font f;
	Button[] subPaths;
	boolean open, more;
	
	
	public Button(int x, int y, int height, int width, String name) {
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		this.name = name;
		f = new Font("Courier New", Font.PLAIN, height - 2);
		open = false;
		more = false;
		startX = x;
		startY = y;
	}
	
	public Button(int x, int y, int height, int width, String name, int n) {
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		this.name = name;
		f = new Font("Courier New", Font.PLAIN, height - 2);
		open = false;
		more = false;
		startX = x - width;
		startY = y + height;
	}
	
	public Button() {
		
	}
	
	public void update() {
		
	}
	
	public void paint(Graphics g) {
		g.drawRect(x, y, width, height);
		g.setFont(f);
		g.drawString(name, x + 1, y + height - 3);
		if(open && more) {
			for(int i = 0; i < subPaths.length; i++) {
				subPaths[i].paint(g);
			}
		}
	}
	
	
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		
		if(open && more) {
			for(int i = 0; i < subPaths.length; i++) {
				subPaths[i].mousePressed(e);
				closeSubOpen(e);
			}
		}
		if(open && inBounds(mx, my)){
			Close();
		}else if(inBounds(mx, my)) {
			Open();
		}
	}
	
	public void createPath(String[] paths) {
		more = true;
		subPaths = new Button[paths.length];
		for(int i = 0; i < paths.length; i++) {
			subPaths[i] = new Button(startX + width, startY + (height * i), height, width, paths[i]);
		}
	}

	
	
	
	
	
	private void closeSubOpen(MouseEvent e) {
		boolean[] oldStatus, newStatus;
		
		oldStatus = new boolean[subPaths.length];
		
		for(int i = 0; i < subPaths.length; i++) {
			oldStatus[i] = subPaths[i].isOpen();
		}
		
		for(int i = 0; i < subPaths.length; i++) {
			subPaths[i].mousePressed(e);
		}
		
		newStatus = new boolean[subPaths.length];
		
		for(int i = 0; i < subPaths.length; i++) {
			newStatus[i] = subPaths[i].isOpen();
		}
		
		for(int i = 0; i < subPaths.length; i++) {
			if(oldStatus[i] && newStatus[i]) {
				boolean close = false;
				for(int j = 0; j < subPaths.length; j++) {
					if(newStatus[j] && j != i) {
						close = true;
					}
				}
				if(close) {
					subPaths[i].Close();
				}
			}
		}
	}
	
	
	
	
	
	
	public Button getButton(String name) {
		Button yeet = new Button();
		for(int i = 0; i < subPaths.length; i++) {
			if(subPaths[i].getName().equals(name)) {
				yeet = subPaths[i];
			}
		}
		return yeet;
	}
	
	
	
	public void Open() {
		open = true;
	}
	
	public void Close() {
		open = false;
		if(more) {
			for(int i = 0; i < subPaths.length; i++) {
				subPaths[i].Close();
			}
		}
	}
	
	

	
	
	
	public boolean inBounds(int x, int y) {
		return (x >= this.x && x <= this.x + width && 
				y >= this.y && y <= this.y + height);
	}	
	
	public boolean isOpen() {
		return open;
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
