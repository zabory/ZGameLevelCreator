import java.awt.Graphics;
import java.awt.event.MouseEvent;

public class EditBar {
	
	Button[] buttons;
	Button[] objectButtons;
	Button[] tileButtons;
	Boolean objectOpen, tileOpen;
	
	
	public EditBar() {
		
		objectOpen = false;
		tileOpen = false;

		buttons = new Button[2];
		buttons[0] = new Button(10,10,25,100,"Objects");
		buttons[1] = new Button(110,10,25,100,"Tiles");
		
		objectButtons = new Button[3];
		objectButtons[0] = new Button(10,35,25,100,"object 1");
		objectButtons[1] = new Button(10,60,25,100,"object 2");
		objectButtons[2] = new Button(10,85,25,100,"object 3");
		
		
	}
	
	
	
	public void update() {
		
	}
	
	public void paint(Graphics g) {
		
		paintButtons(g);
		
		if(objectOpen) {
			paintObjectButtons(g);
		}
		
	}
	
	public void mousePressed(MouseEvent e) {
		for(int i = 0; i < buttons.length; i++) {
			if(buttons[i].inBounds(e.getX(), e.getY())) {
				System.out.println(buttons[i].getName());
				if(buttons[i].getName().equals("Objects")) {
					objectOpen = true;
				}
				
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
	
	public void paintObjectButtons(Graphics g) {
		for(int i = 0; i < objectButtons.length; i++) {
			objectButtons[i].paint(g);
		}
	}
	

}
