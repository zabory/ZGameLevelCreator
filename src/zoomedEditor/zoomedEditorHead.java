package zoomedEditor;

import java.awt.Color;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;



public class zoomedEditorHead extends JFrame{
	private static final long serialVersionUID = 1L;
	private zoomedEditorPanel editor;
	
	public zoomedEditorHead(){
		setSize(500, 500);
		setTitle("ZGame level editor");
		setBackground(Color.WHITE);
		//setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		editor = new zoomedEditorPanel(this);
		add(editor);
		setVisible(true);
		
		
		
		addWindowListener(new WindowListener() {

			@Override
			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("Activated");
			}

			@Override
			public void windowClosed(WindowEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("Zoomed closed");
			}

			@Override
			public void windowClosing(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeactivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowIconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		
		
		
	}

}
