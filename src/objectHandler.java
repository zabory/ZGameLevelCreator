import java.awt.Graphics;
import java.awt.event.MouseEvent;

public class objectHandler {
	
	Object[] objects;
	String name;
	
	
	public objectHandler() {
		objects = new Object[10000];
		name = "Un-named Level";
	}
	
	
	
	
	public void paint(Graphics g) {
		g.drawString(name, 1700, 50);
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
