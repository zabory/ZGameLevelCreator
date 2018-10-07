package editor;
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

import elements.Button;

public class Object {
	String type;
	int x, y, width, height, startX, startY, MX, MY, id;
	boolean moving, gridMove;
	BufferedImage icon;
	Button options;
	String[] opts = {"Delete" , "Attributes", "Count"};
	
	public Object(int x, int y, int id, String type) {
		this.x = x;
		this.y = y;
		moving = false;
		height = 16;
		width = 16;
		this.type = type;
		System.out.println("Type: " + type);
		try {
			if(type.equals("Wizard")) {
				icon = ImageIO.read(new File("WizardHat.png"));
			}else if(type.equals("Skeleton")) {
				icon = ImageIO.read(new File("Skeleton.png"));	
			}else if(type.equals("Alchemist")) {
				icon = ImageIO.read(new File("Alchemist.png"));	
			}else if(type.equals("Archer")) {
				icon = ImageIO.read(new File("Archer.png"));	
			}else if(type.equals("Knight")) {
				icon = ImageIO.read(new File("Knight.png"));	
			}
		} catch (IOException e) {
			
		}
		options = new Button(x,y,height,width,"",2);
		options.setSubH(16);
		options.setSubW(100);
		options.createPath(opts);
		this.id = id;
		
	}
	
	public int getID() {
		return id;
	}
	
	
	public void move(int x, int y) {
		gridMove = true;
		startX = x;
		startY = y;
	}
	
	public String getMessage() {
		String message = "";
		String oMessage = options.getMessage();
		if(!oMessage.equals("")) {
			message = "object " + id + " " + oMessage;
		}
		return message;
	}

	public void paint(Graphics g) {
		g.setColor(Color.BLACK);
		//g.fillOval(x, y, height, width);
		g.drawImage(icon, x, y, null);
		options.paint(g);
	}
	
	public void MousePressed(int x, int y, MouseEvent e) {
		if(inBounds(x, y) && e.getButton() == 1) {
			moving = true;
		}
		if(e.getButton() == 3 && !options.isOpen()) {
			options.mousePressed(e);
		}else if(options.isOpen()) {
			options.mousePressed(e);
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

		options = new Button(x,y,height,width,"",2);
		options.setSubH(16);
		options.setSubW(100);
		options.createPath(opts);
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
	}
	
	public void setID(int id) {
		this.id = id;
	}
	
}
