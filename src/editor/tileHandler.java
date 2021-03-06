package editor;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

import elements.Tile;

public class tileHandler {
	
	Tile[] tiles;
	int tileCounter;
	
	public tileHandler() {
		tiles = new Tile[10000];
		tileCounter = 0;
	}
	
	

	
	public void addTile(Tile[] o) {
		for(int i = 0; i < o.length; i++) {
			boolean add = true;
			for(int j = 0; j < tileCounter; j++) {
				if(tiles[j].inBounds(o[i].getX() + 8, o[i].getY() + 8)) {
					add = false;
				}
			}
			if(add) {
			tiles[tileCounter] = o[i];
			tileCounter++;
			}
		}
	}
	
	public void update() {
		for(int i = 0; i < tileCounter; i++) {
			tiles[i].update();
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
	
	public void MousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
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


	public boolean hasTile(int x, int y) {
		boolean answer = false;
		for(int i = 0; i < tileCounter && ! answer; i++) {
			answer = tiles[i].inBounds(x, y);
		}
		return answer;
	}
	
	
	public Tile getTile(int x, int y) {
		Tile answer = null;
		for(int i = 0; i < tileCounter; i++) {
			if(tiles[i].inBounds(x, y)) {
				answer = tiles[i];
			}
		}
		return answer;
	}
	
	public boolean canPlace(int x, int y) {
		boolean answer = false;
		
		for(int i = 0; i < tileCounter && !answer; i++) {
			answer = tiles[i].inBounds(x, y);
		}
		
		
		
		return answer;
	}


}
