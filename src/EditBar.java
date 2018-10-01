import java.awt.Graphics;
import java.awt.event.MouseEvent;

public class EditBar {
	
	Button[] buttons;
	Boolean objectOpen, tileOpen, areaOpen;
	Path objectPath, tilePath, areaPath;
	
	
	public EditBar() {
		String[] objects = {"Monsters" , "Towers"};
		String[] tiles = {"Objectives" , "Traps" , "Floor" , "Wall"};
		String[] areas = {"Monster spawn"};
		
		
		objectOpen = false;
		tileOpen = false;
		areaOpen = false;

		buttons = new Button[3];
		buttons[0] = new Button(10,10,25,125,"Objects");
		buttons[1] = new Button(135,10,25,150,"Tiles");
		buttons[2] = new Button(285,10,25,185,"Areas");
		
		objectPath = new Path(10,35,25,125,objects);  
		tilePath = new Path(135,35,25,150,tiles);
		areaPath = new Path(285,35,25,185,areas);
	}
	
	
	
	public void update() {
		
	}
	
	public void paint(Graphics g) {
		
		paintButtons(g);
		
		if(objectOpen) {
			objectPath.paint(g);
		}else if(tileOpen) {
			tilePath.paint(g);
		}else if(areaOpen) {
			areaPath.paint(g);
		}
		
		
	}
	
	public void mousePressed(MouseEvent e) {
		for(int i = 0; i < buttons.length; i++) {
			if(buttons[i].inBounds(e.getX(), e.getY())) {
				System.out.println(buttons[i].getName());
				//objects menu open logic
				if(i == 0) {
					if(objectOpen) {
						resetMenus();
					}else{
						resetMenus();
						objectOpen = true;
					}
				}
				//tiles menu open logic
				if(i == 1) {
					if(tileOpen) {
						resetMenus();
					}else{
						resetMenus();
						tileOpen = true;
					}
				}
				//area menu open logic
				if(i == 2) {
					if(areaOpen) {
						resetMenus();
					}else{
						resetMenus();
						areaOpen = true;
					}
				}
				
				
				
				
			}
		}
		
		
		
		
		
		
		
		
		
		
	}
	
	public void mouseReleased(MouseEvent e) {
		
	}
	
	public void paintButtons(Graphics g) {
		for(int i = 0; i < buttons.length; i++) {
			buttons[i].paint(g);
		}
	}
	
	
	
	public void resetMenus() {
		objectOpen = false;
		areaOpen = false;
		tileOpen = false;
	}
	
	

}
