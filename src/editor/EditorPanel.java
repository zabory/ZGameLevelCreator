package editor;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.io.FileNotFoundException;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * The game panel. controls everything
 * @author Ben Shabowski
 *
 */
public class EditorPanel extends JPanel implements ActionListener, KeyListener, MouseListener, MouseMotionListener, MouseWheelListener {
	private static final long serialVersionUID = 1L;
	//private GameHead game;
	EditorHead game;
	static EditBar topBar;
	String message, lastMessage;
	fieldHandler FH;
	boolean field, placing, grid, moving, zView;
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
		addMouseWheelListener(this);
		setFocusable(true);
		message = "";
		lastMessage = "";
		field = false;
		test = true;
		placing = false;
		moving = false;
		zView = false;
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
		g.translate(-origX, -origY);
		if(grid) {
			for(int i = -8000; i < 8000; i += 16) {
				g.drawLine(i, -8000, i, 8000);
			}
			for(int i = -8000; i < 8000; i += 16) {
				g.drawLine(-8000, i, 8000, i);
			}
		}
		
		if(field) {	
			FH.paint(g);
		}
		if(placing) {
			toPlace.paint(g);
		}
		
		
		
		
		
		g.setColor(Color.BLACK);
		g.translate(origX, origY);
		topBar.paint(g);
		if(zView) {
			g.setColor(new Color(0,0,0,50));
			g.fillRect(((MX/16) * 16) - (16 * 9), ((MY/16) * 16) - (16 * 9), 16 * 18, 16 * 18);
			g.setColor(Color.BLACK);
		}
		
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
			//monster tree
				if(message.contains("Monsters")) {
					toPlace = new Placeables(MX,MY,"Object", message);
					placing = true;
				}
			
			}
		//Tile tree
		else if(message.contains("Tiles")) {
				if(message.contains("Floor")) {
					toPlace = new Placeables(50,50,"Tile",message);
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
				}else if(message.contains("Return")) {
					origX = 0;
					origY = 0;
				}else if(message.contains("Move view")) {
					if(moving) {
						moving = false;
					}else {
						moving = true;
					}
				}
			}
		//object handler tree
		else if(message.contains("object")) {
				if(message.contains("Delete")) {
					String man = message;
					int id = -1;
					man = message.substring(7, message.length() - 8);
					System.out.println(man);
					id = Integer.parseInt(man);
					
					FH.deleteObject(id);
					
				}else if(message.contains("Attributes")) {
					
						
					
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
		MX = arg0.getX();
		MY = arg0.getY();
		
		//left click
		
		if(arg0.getButton() == 1) {
			if(!placing && !zView && !moving) {
				if(test) {
					test = false;
						topBar.mousePressed(arg0);
						if(field) {
							arg0.translatePoint(origX, origY);
							FH.MousePressed(arg0);
							arg0.translatePoint(-origX, -origY);
						}
				}
			}else if(placing){
				arg0.translatePoint(origX, origY);
				
				if(toPlace.getType().equals("Object") && toPlace.getValid()) {
					System.out.println("Adding object");
					try {
						FH.addObject(toPlace.toObject());
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else if(toPlace.getType().equals("Tile")){
					System.out.println("Adding tile");
					FH.addTile(toPlace.toTile());
				}
				arg0.translatePoint(-origX, -origY);
			}else if(zView) {
				zView = false;
			}
		}//end left click
		//right click
		if(zView) {
			zView = false;
		}
		if(arg0.getButton() == 3) {
			if(field) {
				arg0.translatePoint(origX, origY);
				FH.MousePressed(arg0);
				arg0.translatePoint(-origX, -origY);
			}
			if(moving) {
				moving = false;
			}
			if(placing) {
				placing = false;
			}
			
			
		}//end right click
		
		if(placing) {
			arg0.translatePoint(origX, origY);
			toPlace.mousePressed(arg0);
			arg0.translatePoint(-origX, -origY);
		}
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		test = true;
		if(field) {
			arg0.translatePoint(origX, origY);
			FH.MouseReleased(arg0);
			arg0.translatePoint(-origX, -origY);
		}
		if(moving) {
			origX = origX - (arg0.getX() - MX);
			origY = origY - (arg0.getY() - MY);
			System.out.println("Shift X: " + origX);
			System.out.println("Shift Y: " + origY);
		}
		
		
		message = topBar.getMessage();
		if(field) {
			if(!FH.getMessage().equals("")) {
				arg0.translatePoint(origX, origY);
				message = FH.getMessage();
				arg0.translatePoint(-origX, -origY);
			}
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
			arg0.translatePoint(origX, origY);
			toPlace.mouseMoved(arg0, FH);
			arg0.translatePoint(-origX, -origY);
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
	public fieldHandler getField() {
		return FH;
	}
	@Override
	public void mouseWheelMoved(MouseWheelEvent arg0) {
		// TODO Auto-generated method stub
	}
	
	
	
	
	
	

}
