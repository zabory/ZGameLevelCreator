package editor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

import elements.Object;
import elements.Tile;

public class fieldHandler {

	objectHandler OH;
	tileHandler TH;
	int xOrig, yOrig;
	
	String name;
	Font f;

	public fieldHandler() {
		OH = new objectHandler();
		TH = new tileHandler();
		name = "Un-named Level";
		f = new Font("Old English Text MT", Font.PLAIN, 40);
		xOrig = 0;
		yOrig = 0;
	}
	
	
	public String getName() {
		return name;
	}
	
	public String getMessage() {
		return OH.getMessage();
	}
	
	public void deleteObject(int id) {
		OH.deleteObject(id);
	}
	
	
	public void stopMove() {
		OH.stopMove();
		TH.stopMove();
	}
	
	public void move(int x, int y) {
		OH.move(x, y);
		TH.move(x, y);
	}
	
	public void MouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		OH.MouseReleased(e);
		TH.MouseReleased(e);
	}

	public void addObject(Object object) {
		OH.addObject(object);
	}
	
	public void addTile(Tile[] tiles) {
		TH.addTile(tiles);
	}

	public void MousePressed(MouseEvent e) {
		OH.MousePressed(e);
		TH.MousePressed(e);
		
	}
	
	public void update() {
		OH.update();
		TH.update();
	}

	public void changeName(String newName) {
		name = newName;
	}

	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		g.setFont(f);
		g.drawString(name, 1500, 50);
		TH.paint(g);
		OH.paint(g);
	}
	
	public boolean hasTile(int x, int y) {
		return TH.hasTile(x,y);
	}
	
	
	public Tile getTile(int x, int y) {
		return TH.getTile(x,y);
	}
	
	public boolean canPlace(int x, int y) {
		boolean answer = false;
		
		answer = TH.canPlace(x,y);
		
		
		return answer;
	}
	
	

}
