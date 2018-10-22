package elements;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class Object {
	String type;
	int x, y, width, height, startX, startY, MX, MY, id, ix, iy, rotation;
	boolean moving, gridMove;
	BufferedImage[] icon;
	Button options;
	String[] opts = {"Delete"};
	int health, speed;
	double manaResist, physicalResist, frostResist, fireResist, piercingResist, blugeoningResist, soundAggro, sightAggro;
	
	//health,speed, mana resistance, physical resistance, frost:fire resistance, piercing:blugeoning resistance, sound:sight aggro range
	
	public Object(int x, int y, int id, String type) throws FileNotFoundException {
		
		
		Scanner OC = new Scanner(new File("config\\objectConfig.txt"));
		String fileIn;
		
		
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
		
		while(OC.hasNextLine()) {
			fileIn = OC.nextLine();
			if(fileIn.contains("Name:")) {
				fileIn = fileIn.substring(6, fileIn.length());
				if(type.contains(fileIn)) {
					String in = OC.nextLine();
					health = Integer.parseInt(in.substring(8, in.length()));

					in = OC.nextLine();
					speed = Integer.parseInt(in.substring(7, in.length()));
					
					in = OC.nextLine();
					manaResist = Double.parseDouble(in.substring(17, in.length()));
					
					in = OC.nextLine();
					physicalResist = Double.parseDouble(in.substring(21, in.length()));
				
					in = OC.nextLine();
					frostResist = Double.parseDouble(in.substring(18, in.length()));
					
					in = OC.nextLine();
					fireResist = Double.parseDouble(in.substring(17, in.length()));
					
					in = OC.nextLine();
					piercingResist = Double.parseDouble(in.substring(21, in.length()));
					
					in = OC.nextLine();
					blugeoningResist = Double.parseDouble(in.substring(23, in.length()));
					
					in = OC.nextLine();
					soundAggro = Double.parseDouble(in.substring(19, in.length()));
					
					in = OC.nextLine();
					sightAggro = Double.parseDouble(in.substring(19, in.length()));
				}
			}
		}
		
		
		
		
		
		
		
		OC.close();
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
			message = "object " + id + oMessage;
		}
		
		
		if(message.contains("Attributes")) {
			System.out.println(outputObject());
		}
		
		
		return message;
	}

	public void paint(Graphics g) {
		g.setColor(Color.BLACK);
		/**
		 * plain graphics doesn't have a rotate, but graphics2d does, so we make 
		 * our graphics into a second graphics2d and work with that. 
		 * 
		 * Very simply, rotating the image at the center of the image, and a rotation changed by radians, and then rotating it
		 * back so we don't rotate other images. 
		 *  
		 */
		
		Graphics2D g2d = (Graphics2D)g;
		g2d.rotate(Math.toRadians(rotation), x + (icon[0].getWidth()/2),y + (icon[0].getHeight() / 2));
		
		g.drawImage(icon[0], x, y, null);
		g.drawImage(icon[1], x + ix, y + iy, null);
		options.paint(g);
		
		
		g2d.rotate(Math.toRadians(-rotation), x + (icon[0].getWidth()/2),y + (icon[0].getHeight() / 2));
		
		

		//rotation++;
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
	
	public String outputObject() {
		String output = "";
		
		output = type + "," + health + "," + speed + "," + manaResist + "," + physicalResist + "," + frostResist + "," + fireResist + "," + piercingResist + "," + 
				blugeoningResist + "," + soundAggro + "," + sightAggro;
		return output;
	}
	
	
	
	
	
	
}
