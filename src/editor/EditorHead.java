package editor;
import java.awt.Color;
import javax.swing.JFrame;

public class EditorHead extends JFrame{
	private static final long serialVersionUID = 1L;
	private EditorPanel editor;
	
	public EditorHead(){
		setSize(500, 500);
		setTitle("ZGame level editor");
		setBackground(Color.WHITE);
		//setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		editor = new EditorPanel(this);
		add(editor);
		setVisible(true);
	}


}