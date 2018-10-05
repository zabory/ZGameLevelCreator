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
	
	
	public void move(int x, int y) {
		for(int i = 0; i < objectCounter; i++) {
			objects[i].move(x, y);
		}
	}
	
	public void stopMove() {
		for(int i = 0; i < objectCounter; i++) {
			objects[i].stopMove();
		}
	}
	
	public void update() {
		for(int i = 0; i < objectCounter; i++) {
			objects[i].update();
		}
	}
	
	public void createObject(String input){
		
	}
	
	public void MousePressed(int x, int y, MouseEvent e) {
		for(int i = 0; i < objectCounter; i++) {
			objects[i].MousePressed(x,y,e);
		}
	}
	
	public void MouseReleased(MouseEvent e) {
		for(int i = 0; i < objectCounter; i++) {
			objects[i].MouseReleased(e);
		}
	}

	

}
