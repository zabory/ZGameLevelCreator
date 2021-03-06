package editor;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

import elements.Button;

public class EditBar {
	
	Button[] buttons;
	
	public EditBar() {
		String[] objects = {"Monsters", "Towers", "Misc"};
		String[] tiles = {"Objectives", "Traps", "Floor", "Wall"};
		String[] areas = {"Monster spawn", "Threat spawn", "Shop", "Send back", "Obelisk"};
		
		String[] trapSub = {"Spikes", "Arrow", "Fake chest"};
		String[] objectiveSub = {"P spawn", "Exit"};
		String[] monsterSub = {"Beasts", "Ghosts", "Undead", "Mechs", "Arthropods", "Slime"};
		
		String[] beastSub = {"Wolf", "Bat", "Snake", "Rat"};
		String[] ghostSub = {"Knight", "Wizard"};
		String[] UndeadSub = {"Zombies", "Skeletons", "Vampire"};
		String[] undeadZombieSub = {"Knight" , "Wizard", "Wolf"};
		String[] undeadSkeletonSub = {"Knight", "Archer" , "Wizard", "Wolf", "Bat"};
		String[] mechSub = {"Spider", "Flying"};
		String[] arthSub = {"Spider", "Bug", "Wasp"};
		
		String[] towerSub = {"Archer" , "Wizard"};
		
		String[] threats = {"Major" , "Minor"};
		
	
		
		String[] views = {"Grid", "Move view", "Return"};
		
		String[] files = {"New" , "Open" , "Export", "Rename" ,"Auto-Complete" ,"Verify"};
		
		String[] misc = {"Barrel" , "Crate" , "Statue"};

		buttons = new Button[5];
		buttons[0] = new Button(10,10,25,180,"File", 1);
		buttons[1] = new Button(190,10,25,150,"Objects", 1);
		buttons[2] = new Button(340,10,25,185,"Tiles", 1);
		buttons[3] = new Button(525,10,25,185,"Areas" , 1);
		
		buttons[0].createPath(files);
		
		
		
		buttons[4] = new Button(800,10,25,185,"View", 1);
		
		
		buttons[1].createPath(objects);
		buttons[2].createPath(tiles);
		buttons[3].createPath(areas);
		
		buttons[1].getButton("Monsters").createPath(monsterSub);
		buttons[1].getButton("Misc").createPath(misc);
		buttons[1].getButton("Towers").createPath(towerSub);
		
		buttons[1].getButton("Monsters").getButton("Beasts").createPath(beastSub);
		buttons[1].getButton("Monsters").getButton("Ghosts").createPath(ghostSub);
		buttons[1].getButton("Monsters").getButton("Undead").createPath(UndeadSub);
		buttons[1].getButton("Monsters").getButton("Undead").getButton("Zombies").createPath(undeadZombieSub);
		buttons[1].getButton("Monsters").getButton("Undead").getButton("Skeletons").createPath(undeadSkeletonSub);
		buttons[1].getButton("Monsters").getButton("Mechs").createPath(mechSub);
		buttons[1].getButton("Monsters").getButton("Arthropods").createPath(arthSub);
		
		
		buttons[2].getButton("Objectives").createPath(objectiveSub);
		buttons[2].getButton("Traps").createPath(trapSub);
		
		buttons[4].createPath(views);
		
		buttons[3].getButton("Threat spawn").createPath(threats);

	}
	
	
	
	public void update() {
		for(int i = 0; i < buttons.length; i++) {
			buttons[i].update();
		}
	}
	
	public void paint(Graphics g) {
		
		paintButtons(g);
		
	}
	
	/**
	 * Passes through mouse event to buttons
	 * Change open and closed status based off of what's open
	 * @param e
	 */
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
	 * method to get any open buttons string path if clicked on and it does not have a subpath linked
	 * @return message string of the directories of the path
	 */
	public String getMessage() {
		String message = "";
		for(int i = 0; i < buttons.length && message.equals(""); i++) {
			message = buttons[i].getMessage();
		}
		
		return message;
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
