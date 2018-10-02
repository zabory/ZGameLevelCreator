import java.awt.Graphics;
import java.awt.event.MouseEvent;

public class Path {

	
	int x, y, height, width;
	Button[] buttons;
	Path[] subPaths;
	Boolean[] open, hasSub;
	
	public Path(int x, int y, int height, int width, String[] names) {
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		buttons = new Button[names.length];
		subPaths = new Path[names.length];
		open = new Boolean[names.length];
		hasSub = new Boolean[names.length];
		
		for(int i = 0; i < names.length; i++) {
			hasSub[i] = false;
		}
		
		closePaths();
		
		for(int i = 0; i < names.length; i++) {
			buttons[i] = new Button(x, y + (i * height), height, width, names[i]);
			hasSub[i] = false;
		}
		
		
	}
	
	
	
	public void update() {
		
	}
	
	public void paint(Graphics g) {
		for(int i = 0; i < buttons.length; i++) {
			buttons[i].paint(g);
		}

		for(int i = 0; i < open.length; i++) {
			if(open[i] && hasSub[i]) {
				subPaths[i].paint(g);
			}
		}
		
		
		
		
		
		
		
		
		
	}
	
	public void mousePressed(MouseEvent e) {
		
		for(int i = 0; i < buttons.length; i++) {
			if(buttons[i].inBounds(e.getX(), e.getY())) {
				if(open[i]) {
					open[i] = false;
				}else {
					closePaths();
					open[i] = true;
				}
			}
		}
	}
	
	public void subPathCreate(String parentPath, String[] subPaths) {
		int index = 0;
		//finds index of parentPath
		for(int i = 0; i < buttons.length; i++) {
			if(buttons[i].getName().equals(parentPath)) {
				index = i;
				hasSub[i] = true;
			}
		}
		this.subPaths[index] = new Path(buttons[index].getX() + buttons[index].getWidth(), buttons[index].getY(), buttons[index].getHeight(), buttons[index].getWidth(), subPaths);
	}
	
	
	
	
	public void openPath(String path) {
		for(int i = 0; i < subPaths.length; i++) {
			if(buttons[i].getName().equals(path)) {
				open[i] = true;
			}
		}
	}
	
	
	
	
	public void closePaths() {
		for(int i = 0; i < subPaths.length; i++) {
			open[i]= false;
		}
	}

	
	
	
	
	
	
}
