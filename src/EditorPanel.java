import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

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
	String message;
	/**
	 * constructor for the game
	 * @param game is the game object. 
	 */
	public EditorPanel(EditorHead game){
		topBar = new EditBar();
		this.game = game;
		Timer timer = new Timer(5, this);
		timer.start();
		addMouseListener(this);
		addMouseMotionListener(this);
		addKeyListener(this);
		setFocusable(true);
		message = "";
	}
	/**
	 * an update method for updating everything in the game, it goes down through all the classes and updates everything 
	 */
	public void update(){
		topBar.update();
		message = topBar.getMessage();
		
		}
	
	/**
	 * a paint method for painting everything, it goes down through all the classes and paints everything
	 */
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		
		
		
		
	
		
		
		
		
		
		g.setColor(Color.BLACK);
		//last thing to paint so it appears over all
		topBar.paint(g);
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
		// TODO Auto-generated method stub
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
		topBar.mousePressed(arg0);

		System.out.println("Message: " + message);
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}
	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}
	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
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
