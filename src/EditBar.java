import java.awt.Graphics;
import java.awt.event.MouseEvent;

public class EditBar {
	
	Button[] buttons;
	
	public EditBar() {

		buttons = new Button[2];
		buttons[0] = new Button(10,10,25,100,"Objects");
		buttons[1] = new Button(110,10,25,100,"Tiles");
	}
	
	
	
	public void update() {
		
	}
	
	public void paint(Graphics g) {
		paintButtons(g);
	}
	
	public void mousePressed(MouseEvent e) {
		for(int i = 0; i < buttons.length; i++) {
			if(buttons[i].inBounds(e.getX(), e.getY())) {
				System.out.println(buttons[i].getName());
			}
		}
	}
	
	public void mouseReleased(MouseEvent e) {
		
	}
	
	public void paintButtons(Graphics g) {
		for(int i = 0; i < buttons.length; i++) {
			buttons[i].paint(g);
		}
	}
	
	
	

}
