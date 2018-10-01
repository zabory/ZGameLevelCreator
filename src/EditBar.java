import java.awt.Graphics;
import java.awt.event.MouseEvent;

public class EditBar {
	
	Button[] buttons, objectButtons, tileButtons, areaButtons;
	Boolean objectOpen, tileOpen, areaOpen;
	
	
	public EditBar() {
		
		objectOpen = false;
		tileOpen = false;
		areaOpen = false;

		buttons = new Button[3];
		buttons[0] = new Button(10,10,25,125,"Objects");
		buttons[1] = new Button(135,10,25,150,"Tiles");
		buttons[2] = new Button(285,10,25,185,"Areas");
		
		objectButtons = new Button[2];
		objectButtons[0] = new Button(10,35,25,125,"Monsters");
		objectButtons[1] = new Button(10,60,25,125,"Towers");
		
		tileButtons = new Button[4];
		tileButtons[0] = new Button(135,35,25,150,"Objectives");
		tileButtons[1] = new Button(135,60,25,150,"Traps");
		tileButtons[2] = new Button(135,85,25,150,"Floor");
		tileButtons[3] = new Button(135,110,25,150,"Wall");
		
		areaButtons = new Button[1];
		areaButtons[0] = new Button(285,35,25,185,"Monster spawn");
		
	}
	
	
	
	public void update() {
		
	}
	
	public void paint(Graphics g) {
		
		paintButtons(g);
		
		if(objectOpen) {
			paintObjectButtons(g);
		}else if(tileOpen) {
			paintTileButtons(g);
		}else if(areaOpen) {
			paintAreaButtons(g);
		}
		
		
	}
	
	public void mousePressed(MouseEvent e) {
		for(int i = 0; i < buttons.length; i++) {
			if(buttons[i].inBounds(e.getX(), e.getY())) {
				System.out.println(buttons[i].getName());
				
				if(buttons[i].getName().equals("Objects")) {
					if(objectOpen){
						objectOpen = false;
					}else{
					resetMenus();
					objectOpen = true;
					}
				}else if(buttons[i].getName().equals("Tiles")) {
					if(tileOpen) {
						tileOpen = false;
					}else {
						resetMenus();
						tileOpen = true;
					}
				}else if(buttons[i].getName().equals("Areas")) {
					if(areaOpen) {
						areaOpen = false;
					}else {
						resetMenus();
						areaOpen = true;
					}
				}
				
			}
		}
		
		if(objectOpen) {
			for(int i = 0; i < objectButtons.length; i++) {
				if(objectButtons[i].inBounds(e.getX(), e.getY())) {
					System.out.println(objectButtons[i].getName());
				}
			}
		}
		
		if(tileOpen) {
			for(int i = 0; i < tileButtons.length; i++) {
				if(tileButtons[i].inBounds(e.getX(), e.getY())) {
					System.out.println(tileButtons[i].getName());
				}
			}
		}
		
		if(areaOpen) {
			for(int i = 0; i < areaButtons.length; i++) {
				if(areaButtons[i].inBounds(e.getX(), e.getY())) {
					System.out.println(areaButtons[i].getName());
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
	
	public void paintObjectButtons(Graphics g) {
		for(int i = 0; i < objectButtons.length; i++) {
			objectButtons[i].paint(g);
		}
	}
	
	public void paintTileButtons(Graphics g) {
		for(int i = 0; i < tileButtons.length; i++) {
			tileButtons[i].paint(g);
		}
	}	
	
	public void paintAreaButtons(Graphics g) {
		for(int i = 0; i < areaButtons.length; i++) {
			areaButtons[i].paint(g);
		}
	}	
	
	
	public void resetMenus() {
		objectOpen = false;
		areaOpen = false;
		tileOpen = false;
	}
	
	

}
