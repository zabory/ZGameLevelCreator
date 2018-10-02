import java.awt.Graphics;
import java.awt.event.MouseEvent;

public class EditBar {
	
	Button[] buttons;
	
	
	public EditBar() {
		String[] objects = {"Monsters" , "Towers"};
		String[] tiles = {"Objectives" , "Traps" , "Floor" , "Wall"};
		String[] areas = {"Monster spawn" , "Threat spawn"};
		
		String[] trapSub = {"Spikes" , "Arrow" , "Fake chest"};
		String[] objectiveSub = {"P spawn" , "Exit"};
		String[] monsterSub = {"Skeleton" , "Wizard" , "Alchemist", "Archer" , "knight" , "warrior"};
		String[] towerSub = {"Archer" , "Wizard"};
		
		String[] skeletonSub = {"Grunt","Boss"};
		
		String[] sSub = {"Giant" , "Large" , "Medium" , "Small"};

		buttons = new Button[3];
		buttons[0] = new Button(10,10,25,125,"Objects", 1);
		buttons[1] = new Button(135,10,25,150,"Tiles", 1);
		buttons[2] = new Button(285,10,25,185,"Areas", 1);
		
		
		
		buttons[0].createPath(objects);
		buttons[1].createPath(tiles);
		buttons[2].createPath(areas);
		
		buttons[0].getButton("Monsters").createPath(monsterSub);
		
		buttons[0].getButton("Monsters").getButton("Skeleton").createPath(skeletonSub);
		buttons[0].getButton("Monsters").getButton("Skeleton").getButton("Boss").createPath(sSub);
		
		buttons[0].getButton("Towers").createPath(towerSub);
		
		buttons[1].getButton("Objectives").createPath(objectiveSub);
		buttons[1].getButton("Traps").createPath(trapSub);

	}
	
	
	
	public void update() {
	
	}
	
	public void paint(Graphics g) {
		
		paintButtons(g);
		
		
		
		
	}
	
	public void mousePressed(MouseEvent e) {
		boolean[] oldStatus, newStatus;
		
		oldStatus = new boolean[buttons.length];
		
		for(int i = 0; i < buttons.length; i++) {
			oldStatus[i] = buttons[i].isOpen();
		}
		
		for(int i = 0; i < buttons.length; i++) {
			buttons[i].mousePressed(e);
		}
		
		newStatus = new boolean[buttons.length];
		
		for(int i = 0; i < buttons.length; i++) {
			newStatus[i] = buttons[i].isOpen();
		}
		
		for(int i = 0; i < buttons.length; i++) {
			if(oldStatus[i] && newStatus[i]) {
				boolean close = false;
				for(int j = 0; j < buttons.length; j++) {
					if(newStatus[j] && j != i) {
						close = true;
					}
				}
				if(close) {
					buttons[i].Close();
				}
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
		for(int i = 0; i < buttons.length; i++) {
			buttons[i].Close();
		}
	}
	
	

}
