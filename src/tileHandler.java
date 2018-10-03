import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

public class tileHandler {
	
	Tile[] tiles;
	int tileCounter;
	
	public tileHandler() {
		tiles = new Tile[10000];
		tileCounter = 0;
	}
	
	

	
	public void addTile(Tile[] o) {
		for(int i = 0; i < o.length; i++) {
			tiles[tileCounter] = o[i];
			tileCounter++;
		}
	}
	
	public void stopMove() {
		for(int i = 0; i < tileCounter; i++) {
			tiles[i].stopMove();
		}
	}
	
	public void paint(Graphics g) {
		for(int i = 0; i < tileCounter; i++) {
			tiles[i].paint(g);
		}
	}
	
	
	public void createObject(String input){
		
	}
	
	public void MousePressed(MouseEvent e) {
		for(int i = 0; i < tileCounter; i++) {
			tiles[i].MousePressed(e);
		}
	}
	
	public void MouseReleased(MouseEvent e) {
		for(int i = 0; i < tileCounter; i++) {
			tiles[i].MouseReleased(e);
		}
	}

	public void move(int x, int y) {
		for(int i = 0; i < tileCounter; i++) {
			tiles[i].move(x, y);
		}
	}


	
	
	
	



}
