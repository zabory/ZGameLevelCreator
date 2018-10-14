package elements;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Object {
	String type;
	int x, y, width, height, startX, startY, MX, MY, id, ix, iy;
	boolean moving, gridMove;
	BufferedImage[] icon;
	Button options;
	String[] opts = {"Delete" , "Attributes"};
	
	//health,speed,mana resistance, physical resistance, frost:fire resistance, piercing:blugeoning resistance, sound:sight aggro range
	
	public Object(int x, int y, int id, String type) {
		icon = new BufferedImage[2];
		this.x = x;
		this.y = y;
		moving = false;
		height = 16;
		width = 16;
		this.type = type;
		System.out.println("Type: " + type);
		try {
			//main one
			if(type.contains("Undead")) {
				if(type.contains("Skeletons")) {
					if(!type.contains("Bat")) {
						icon[0] = ImageIO.read(new File("icons\\Skeleton.png"));
					}else {
						icon[0] = ImageIO.read(new File("icons\\SBat.png"));
					}
				}else if(type.contains("Zombies")) {
					icon[0] = ImageIO.read(new File("icons\\Zombie.png"));
				}else if(type.contains("Vampire")) {
					icon[0] = ImageIO.read(new File("icons\\Vampire.png"));
				}
				//secondary
				if(type.contains("Wolf")) {
					icon[1] = ImageIO.read(new File("icons\\WolfEars.png"));
					iy = -6;
				}
			}
			
			if(type.contains("Beast")) {
				if(type.contains("Bat")) {
					icon[0] = ImageIO.read(new File("icons\\Bat.png"));
				}else if(type.contains("Snake")) {
					icon[0] = ImageIO.read(new File("icons\\Snake.png"));
				}else if(type.contains("Wolf")) {
					icon[0] = ImageIO.read(new File("icons\\Wolf.png"));
				}else if(type.contains("Rat")) {
					icon[0] = ImageIO.read(new File("icons\\Rat.png"));
				}
			}
			
			if(type.contains("Ghost")) {
				icon[0] = ImageIO.read(new File("icons\\Ghost.png"));
			}
			
			if(type.contains("Mechs,Spider")) {
				icon[0] = ImageIO.read(new File("icons\\MechSpider.png"));
			}
			if(type.contains("Mechs,Flying")) {
				icon[0] = ImageIO.read(new File("icons\\MechBat.png"));
			}
			
			if(type.contains("Arthropods")) {
				if(type.contains("Spider")) {
					icon[0] = ImageIO.read(new File("icons\\Spider.png"));
				}else if(type.contains("Bug")) {
					icon[0] = ImageIO.read(new File("icons\\Bug.png"));
				}else if(type.contains("Wasp")) {
					icon[0] = ImageIO.read(new File("icons\\Wasp.png"));
				}
			}
			
			
			if(type.contains("Slime")){
				icon[0] = ImageIO.read(new File("icons\\Slime.png"));
			}
			
			
			
			
			
			
			//secondary type 
			if(type.contains("Wizard")) {
				icon[1] = ImageIO.read(new File("icons\\WizardHat.png"));
				iy = -13;
			}else if(type.contains("Knight")) {
				icon[1] = ImageIO.read(new File("icons\\Knight.png"));
			}else if(type.contains("Archer")) {
				ix = -5;
				icon[1] = ImageIO.read(new File("icons\\Archer.png"));	
			}else if(type.contains("Alchemist")) {
				icon[1] = ImageIO.read(new File("icons\\Alchemist.png"));	
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
		g.drawImage(icon[0], x, y, null);
		g.drawImage(icon[1], x + ix, y + iy, null);
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
