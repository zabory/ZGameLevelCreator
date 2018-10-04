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
			boolean n, e, s, w;
			n = false;
			e = false;
			s = false;
			w = false;
			//north testing
			for(int j = 0; j < tileCounter; j++) {
				if(tiles[j].inBounds(tiles[i].getX() + 8,tiles[i].getY() - 8)) {
					n = true;
				}
			}
			//east testing
			for(int j = 0; j < tileCounter; j++) {
				if(tiles[j].inBounds(tiles[i].getX() + 18,tiles[i].getY() + 8)) {
					e = true;
				}
			}
			//south testing
			for(int j = 0; j < tileCounter; j++) {
				if(tiles[j].inBounds(tiles[i].getX() + 8,tiles[i].getY() + 18)) {
					s = true;
				}
			}
			//west testing
			for(int j = 0; j < tileCounter; j++) {
				if(tiles[j].inBounds(tiles[i].getX() - 8,tiles[i].getY() + 8)) {
					w = true;
				}
			}
			tiles[i].paint(g, n, e, s, w);
		}
	}
	
	
	public void createObject(String input){
		
	}
	
	public void MousePressed(int x, int y) {
		for(int i = 0; i < tileCounter; i++) {
			tiles[i].MousePressed(x, y);
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
