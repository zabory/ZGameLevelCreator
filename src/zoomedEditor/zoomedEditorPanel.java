package zoomedEditor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


import javax.swing.JPanel;
import javax.swing.Timer;

import editor.fieldHandler;




public class zoomedEditorPanel extends JPanel implements ActionListener, KeyListener, MouseListener, MouseMotionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static zoomedEditorHead game;
	static fieldHandler FH;
	static int x,y;
	
	public zoomedEditorPanel(zoomedEditorHead zoomedEditorHead){
		zoomedEditorPanel.game = zoomedEditorHead;
		Timer timer = new Timer(5, this);
		timer.start();
		addMouseListener(this);
		addMouseMotionListener(this);
		addKeyListener(this);
		setFocusable(true);
	}

	
	
	
	
	
	
	
	
	
	
	
	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	public void setField(fieldHandler FH, int x, int y) {
		this.x = x;
		this.y = y;
		
		
		
		
		
		
		
	}


	
	
	
	
}
