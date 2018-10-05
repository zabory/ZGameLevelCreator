import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Object {

	int x, y, width, height, startX, startY, MX, MY;
	boolean moving, gridMove;
	BufferedImage icon;
	Button options;
	
	public Object(int x, int y) {
		this.x = x;
		this.y = y;
		moving = false;
		height = 16;
		width = 16;
		try {
		    icon = ImageIO.read(new File("WizardHat.png"));
		} catch (IOException e) {
			
		}
		options = new Button(x,y,height,width,"",2);
		options.setSubH(16);
		options.setSubW(100);
		String[] opts = {"Delete" , "Attributes"};
		options.createPath(opts);
	}
	
	
	
	
	public void move(int x, int y) {
		gridMove = true;
		startX = x;
		startY = y;
	}
	

	public void paint(Graphics g) {
		g.setColor(Color.BLACK);
		//g.fillOval(x, y, height, width);
		g.drawImage(icon, x, y, null);
		options.paint(g);
	}
	
	public void MousePressed(int x, int y, MouseEvent e) {
		if(inBounds(x, y)) {
			moving = true;
		}
		options.mousePressed(e);
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
	
	public void update() {
		options.update();
	}
	
}
