import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

public class objectHandler {
	
	Object[] objects;
	String name;
	Font f;
	
	public objectHandler() {
		objects = new Object[10000];
		name = "Un-named Level";
		f = new Font("Courier New", Font.PLAIN, 40);
	}
	
	
	
	
	public void paint(Graphics g) {
		g.setFont(f);
		g.drawString(name, 1500, 50);
	}
	
	
	public void createObject(String input){
		
	}
	
	public void MousePressed(MouseEvent e) {
		
	}
	
	public void MouseReleased(MouseEvent e) {
		
	}

	public void changeName(String newName) {
		name = newName;
	}

}
