package editor;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

import elements.Object;

public class objectHandler {
	
	Object[] objects;
	int objectCounter;
	
	public objectHandler() {
		objects = new Object[10000];
		objectCounter = 0;
	}
	
	
	public void addObject(Object o) {
		objects[objectCounter] = o;
		if(o.getID() == -1) {
			o.setID(objectCounter);
		}
		System.out.println("Object " + objectCounter + " created.");
		objectCounter++;
	}
	
	public void deleteObject(int id) {
		Object temp[] = new Object[10000];
		int ocHolder =  0;
		int counter = 0;
		
		for(int i = 0; i < objectCounter; i++) {
			if(objects[i].getID() != id) {
				temp[counter] = objects[i];
				counter++;
			}
		}
		
		for(int i = 0; i < counter; i++) {
			temp[i].setID(i);
		}
		
		
		
		objects = temp;
		objectCounter = counter;
	}
	
	public String getMessage() {
		String message = "";
		for(int i = 0; i < objectCounter && message.equals(""); i++) {
			message = objects[i].getMessage();
		}
		return message;
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
	
	public void MousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
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
