import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
/**
 * The game panel. controls everything
 * @author Ben Shabowski
 *
 */
public class EditorPanel extends JPanel implements ActionListener, KeyListener, MouseListener, MouseMotionListener {
	private static final long serialVersionUID = 1L;
	//private GameHead game;
	EditorHead game;
	static EditBar topBar;
	String message, lastMessage;
	fieldHandler FH;
	boolean field, placing, grid, moving;
	boolean test;
	Placeables toPlace;
	int MX, MY, startX, startY, origX, origY;
	
	/**
	 * constructor for the game
	 * @param game is the game object. 
	 */
	public EditorPanel(EditorHead game){
		grid = false;
		topBar = new EditBar();
		this.game = game;
		Timer timer = new Timer(5, this);
		timer.start();
		addMouseListener(this);
		addMouseMotionListener(this);
		addKeyListener(this);
		setFocusable(true);
		message = "";
		lastMessage = "";
		field = false;
		test = true;
		placing = false;
		moving = false;
		origX = 0;
		origY = 0;
	}
	/**
	 * an update method for updating everything in the game, it goes down through all the classes and updates everything 
	 */
	public void update(){
		if(!message.equals(lastMessage) && !message.equals("")) {
			System.out.println("Checking for message");
			System.out.println("Message: " + message);
			messageHandler(message);
			topBar.resetMenus();
			message = "";
			lastMessage = message;
		}

		
	}
	
	/**
	 * a paint method for painting everything, it goes down through all the classes and paints everything
	 */
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.translate(origX, origY);
		if(field) {	
			FH.paint(g);
		}
		if(placing) {
			toPlace.paint(g);
		}
		
		if(grid) {
			for(int i = 0; i < 1920; i += 16) {
				g.drawLine(i, 0, i, 1080);
			}
			for(int i = 0; i < 1080; i += 16) {
				g.drawLine(0, i, 1920, i);
			}
		}
	
		
		g.translate(-origX,-origY);
		
		
		
		g.setColor(Color.BLACK);
		topBar.paint(g);
		
		
	}
	
	
	
	
	private void messageHandler(String message) {
		//File tree
		if(message.contains("File")) {
			if(message.contains("New")) {
				field = true;
				System.out.println("New Field Handler");
				FH = new fieldHandler();
				origX = 0;
				origY = 0;
				}else if(message.contains("Rename") && field) {
				String newName = JOptionPane.showInputDialog("Enter new name:");
				FH.changeName(newName);
			}
		}else if(field) {
		//Object tree
		if(message.contains("Objects")) {
				if(message.contains("Wizard") && message.contains("Monsters")) {
					toPlace = new Placeables(50,50,"Object");
					placing = true;
				}
			
			}
		//Tile tree
		else if(message.contains("Tiles")) {
				if(message.contains("Floor")) {
					toPlace = new Placeables(50,50,"Tile");
					placing = true;
				}
			}
		//View tree
		else if(message.contains("View")) {
				if(message.contains("Grid")) {
					if(grid) {
						grid = false;
					}else {
						grid = true;
					}
				}else if(message.contains("Move view")) {
					if(moving) {
						moving = false;
					}else {
						moving = true;
					}
				}
			}
		}
	}
	
	
	
	
	@Override
	/**
	 * updates and repaints everything every tick
	 */
	public void actionPerformed(ActionEvent e) {
		update();
		repaint();	
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if(placing) {
			toPlace.keyPressed(e);
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		//System.out.println("(" + arg0.getX() + "," + arg0.getY() + ")");
		// TODO Auto-generated method stub
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if(moving) {
			MX = arg0.getX();
			MY = arg0.getY();
		}
		//left click
		
		if(arg0.getButton() == 1) {
			if(!placing) {
				if(test) {
					test = false;
						topBar.mousePressed(arg0);
						if(field) {
							FH.MousePressed(arg0.getX(), arg0.getY(), arg0);
						}
				}
			}else{
				
				if(toPlace.getType().equals("Object")) {
					System.out.println("Adding object");
					FH.addObject(toPlace.toObject());
				}else if(toPlace.getType().equals("Tile")){
					System.out.println("Adding tile");
					FH.addTile(toPlace.toTile());
				}
			}
		}//end left click
		//right click
		if(arg0.getButton() == 3) {
			if(field) {
				FH.MousePressed(arg0.getX(), arg0.getY(), arg0);
			}
			if(moving) {
				moving = false;
			}
			if(placing) {
				placing = false;
			}
			
			
		}//end right click
		
		if(placing) {
			toPlace.mousePressed(arg0);
		}
		message = topBar.getMessage();
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		test = true;
		if(field) {
			FH.MouseReleased(arg0);
		}
		if(moving) {
			origX = origX - (MX - arg0.getX());
			origY = origY - (MY - arg0.getY());
			System.out.println("Shift X: " + origX);
			System.out.println("Shift Y: " + origY);
		}
	}
	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}
	@Override
	public void mouseMoved(MouseEvent arg0) {
		MX = arg0.getX();
		MY = arg0.getY();
		if(placing) {
			toPlace.mouseMoved(arg0);
		}
	}
	
	
	/**
	 * Creates a line based off of given variables
	 * @param g graphics library
	 * @param x X-cord of first point
	 * @param y Y-cord of first point
	 * @param x2 X-cord of second point
	 * @param y2 Y-cord of second point
	 * @param thickness How thick the line should be
	 */
	public void paintLine(Graphics g, int x, int y, int x2, int y2, int thickness) {
		thickness /= 2;
		int[] xPoints = {x + thickness,x2 + thickness, x2 - thickness, x - thickness};
		int[] yPoints = {y - thickness, y2 - thickness, y2 + thickness, y + thickness};
		g.fillPolygon(xPoints, yPoints, 4);
	}
	

}
