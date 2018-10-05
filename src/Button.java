import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

public class Button {

	int x,y,height,width,startX,startY;
	String name;
	Font f;
	Button[] subPaths;
	boolean open, more;
	int subOpen;
	int type, subW, subH;
	int tickWait;
	/**
	 * constructor for normal button
	 * @param x
	 * @param y
	 * @param height
	 * @param width
	 * @param name
	 */
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

		System.out.println("Button <" + name + "> has been created.");
		type = 0;
	}
	/**
	 * constructor for top button graphicall of the buttons (aka main button)
	 * @param x
	 * @param y
	 * @param height
	 * @param width
	 * @param name
	 * @param n
	 */
	public Button(int x, int y, int height, int width, String name, int n) {
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		this.name = name;
		f = new Font("Courier New", Font.PLAIN, height - 2);
		open = false;
		more = false;
		if(n != 2) {
		startX = x - width;
				startY = y + height;
		}else {
			startX = x;
			startY = y;
		}
		type = n;
	}
	/**
	 * fake button, to make button object to return null if nothing is found
	 */
	public Button() {
		
	}
	
	public void update() {
		if(tickWait <= 0 && tickWait != 50) {
		open = false;
		tickWait = 50;
		}
		if(tickWait != 50){
			tickWait--;
		}
	}
	
	/**
	 * paint button, if open, pain the rest of the sub directory
	 * @param g
	 */
	public void paint(Graphics g) {
		if(type != 2) {
			g.setColor(Color.WHITE);
			g.fillRect(x, y, width, height);
			g.setColor(Color.BLACK);
			g.drawRect(x, y, width, height);
			g.setFont(f);
			g.drawString(name, x + 1, y + height - 3);
		}
		if(open && more) {
			for(int i = 0; i < subPaths.length; i++) {
				subPaths[i].paint(g);
			}
		}
	}
	
	/**
	 * If open and has a subD, open subD, else if open send a message of name of button
	 * @param e
	 */
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		
		if(open && more) {
			for(int i = 0; i < subPaths.length; i++) {
				if(subPaths[i].inBounds(mx, my) && subOpen != i) {
					closeSubOpen();
					subOpen = i;
				}
				subPaths[i].mousePressed(e);
			}
		}
		if(open && inBounds(mx, my)){
			Close();
		}else if(!open && inBounds(mx, my)) {
			Open();
		}
		
		boolean clickedOn = false;
		if(inBounds(mx,my)) {
			clickedOn = true;
		}else{
			if(more) {
				for(int i = 0; i < subPaths.length && !clickedOn; i++) {
					if(subPaths[i].inBounds(mx, my)) {
						clickedOn = true;
					}
				}
			}
		}
		
		if(!clickedOn) {
			Close();
		}
		
		
	}
	
	
	/**
	 * creates subDs based off of a string array
	 * @param paths
	 */
	public void createPath(String[] paths) {
		subOpen = paths.length;
		more = true;
		subPaths = new Button[paths.length];
		for(int i = 0; i < paths.length; i++) {
			if(type != 2) {
			subPaths[i] = new Button(startX + width, startY + (height * i), height, width, paths[i]);
			}else {
				subPaths[i] = new Button(startX + width, startY + (height * i), subH, subW, paths[i]);
			}
		}
	}

	
	
	
	
	/**
	 * close open sub paths if a new subpath is opened or if its clicked on again
	 * @param e
	 */
	private void closeSubOpen() {
		for(int i = 0; i < subPaths.length; i++) {
			subPaths[i].Close();
		}
	}
	
	
	
	
	
	/**
	 * returns button object of a button with the name of it as input
	 * @param name the name of the button
	 * @return button requested
	 */
	public Button getButton(String name) {
		Button yeet = new Button();
		boolean yote = true;
		for(int i = 0; i < subPaths.length && yote; i++) {
			if(subPaths[i].getName().equals(name)) {
				yeet = subPaths[i];
				yote = false;
			}
		}
		return yeet;
	}
	
	
	/**
	 * marks open as true to open subDs
	 */
	public void Open() {
		System.out.println("Button <" + name + "> has been opened.");
		open = true;
	}
	/**
	 * marks open to false, if it has subDs, closes them
	 */
	public void Close() {
		if(open)
		System.out.println("Button <" + name + "> has been closed.");
		open = false;
		if(more) {
			for(int i = 0; i < subPaths.length; i++) {
				subPaths[i].Close();
			}
		}
	}
	/**
	 * Tests if its the last in directory and if its pressed, returns name of button
	 * @return name of button
	 */
	public String getMessage() {
		String message = "";
		if(open && !more) {
			message = name;
		}else if(open && more) {
			for(int i = 0; i < subPaths.length && message.equals(""); i++) {
				message = subPaths[i].getMessage();
				if(!message.equals("")) {
					message = name + "," + message;
				}
			}
		}
		
		return message;
		
	}

	
	
	/**
	 * a method that returns true if the coordinates are inside of button bounds
	 * @param x mouse x
	 * @param y mouse y
	 * @return boolean in bounds of button
	 */
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
	public int getSubW() {
		return subW;
	}
	public void setSubW(int subW) {
		this.subW = subW;
	}
	public int getSubH() {
		return subH;
	}
	public void setSubH(int subH) {
		this.subH = subH;
	}
	
	
	
}
