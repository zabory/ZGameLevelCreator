import java.awt.Graphics;
import java.awt.event.MouseEvent;

public class Path {

	
	int x, y, height, width;
	Button[] buttons;
	
	public Path(int x, int y, int height, int width, String[] names) {
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		buttons = new Button[names.length];
		
		for(int i = 0; i < names.length; i++) {
			buttons[i] = new Button(x, y + (i * height), height, width, names[i]);
		}
		
		
	}
	
	
	
	public void update() {
		
	}
	
	public void paint(Graphics g) {
		for(int i = 0; i < buttons.length; i++) {
			buttons[i].paint(g);
		}
	}
	
	public void mousePressed(MouseEvent e) {
		
	}
	
	
	
	
	
	
	
	
}
