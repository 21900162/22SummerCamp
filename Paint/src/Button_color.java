import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Button_color extends JButton{
	
	
	
	public Button_color() {
		super();
		
		
	}
	public Button_color(String string) {
		super(string);
		super.addActionListener(new MyListener());
		
	}
	

	

}
