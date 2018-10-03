import java.awt.Graphics;
import java.awt.event.MouseEvent;

public class objectHandler {
	
	Object[] objects;
	int objectCounter;
	
	public objectHandler() {
		objects = new Object[10000];
		objectCounter = 0;
	}
	
	
	public void addObject(Object o) {
		objects[objectCounter] = o;
		System.out.println("Object " + objectCounter + " created.");
		objectCounter++;
	}
	
	
	public void paint(Graphics g) {
		for(int i = 0; i < objectCounter; i++) {
			objects[i].paint(g);
		}
	}
	
	
	public void createObject(String input){
		
	}
	
	public void MousePressed(MouseEvent e) {
		for(int i = 0; i < objectCounter; i++) {
			objects[i].MousePressed(e);
		}
	}
	
	public void MouseReleased(MouseEvent e) {
		for(int i = 0; i < objectCounter; i++) {
			objects[i].MouseReleased(e);
		}
	}



}
