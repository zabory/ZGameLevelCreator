import java.awt.Graphics;
import java.awt.event.MouseEvent;

public class EditBar {
	
	Button[] buttons;
	Boolean objectOpen, tileOpen, areaOpen;
	Path objectPath, tilePath, areaPath;
	
	
	public EditBar() {
		String[] objects = {"Monsters" , "Towers"};
		String[] tiles = {"Objectives" , "Traps" , "Floor" , "Wall"};
		String[] areas = {"Monster spawn" , "Threat spawn"};
		
		String[] trapSub = {"Spikes" , "Arrow" , "Fake chest"};
		String[] objectiveSub = {"P spawn" , "Exit"};
		String[] monsterSub = {"Skeleton" , "Wizard" , "Alchemist", "Archer" , "knight" , "warrior"};
		String[] towerSub = {"Archer" , "Wizard"};
		
		
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
		
		
		tilePath.subPathCreate("Traps", trapSub);
		tilePath.subPathCreate("Objectives", objectiveSub);
		objectPath.subPathCreate("Monsters", monsterSub);
		objectPath.subPathCreate("Towers", towerSub);
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
		boolean mainButton = false;
		//goes through all buttons
		for(int i = 0; i < buttons.length; i++) {
			//if a mouse click is on a main button
			if(buttons[i].inBounds(e.getX(), e.getY())) {
				mainButton = true;
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
		
		if(!mainButton) {
		
			if(tileOpen) {
				tilePath.mousePressed(e);
			}else if(objectOpen) {
				objectPath.mousePressed(e);
			}else if(areaOpen){
				areaPath.mousePressed(e);
			}
			
		}
		
		
		
		
		
		
		
		
		
	}
	
	public void mouseReleased(MouseEvent e) {
		
	}
	
	
	
	/**
	 * paints main task buttons
	 * @param g graphics screen
	 */
	public void paintButtons(Graphics g) {
		for(int i = 0; i < buttons.length; i++) {
			buttons[i].paint(g);
		}
	}
	
	
	/**
	 * closes all menus
	 */
	public void resetMenus() {
		objectOpen = false;
		areaOpen = false;
		tileOpen = false;
		objectPath.closePaths();
		areaPath.closePaths();
		tilePath.closePaths();
	}
	
	

}
