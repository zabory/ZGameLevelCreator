package editor;
import java.awt.Color;
import javax.swing.JFrame;

public class EditorHead extends JFrame{
	private static final long serialVersionUID = 1L;
	private EditorPanel editor;
	
	public EditorHead(){
		setSize(750, 500);
		setTitle("ZGame Level Editor");
		setBackground(Color.BLACK);
		//setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		editor = new EditorPanel(this);
		add(editor);
		setVisible(true);
	}

}