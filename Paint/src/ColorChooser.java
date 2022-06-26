import java.awt.Color;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.colorchooser.ColorSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ColorChooser extends JFrame implements ChangeListener{
	
	JColorChooser colorChooser = new JColorChooser();
	ColorSelectionModel model = colorChooser.getSelectionModel();
	static boolean colorChange;
	static Color color = Color.BLACK;
	   
	public ColorChooser(){

	     this.setTitle("색상 고르기");
	     this.setLocation(400, 200);
	     this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	     colorChooser.getSelectionModel().addChangeListener(this);
	     this.add(colorChooser);
	     this.pack();
	     this.setVisible(true);
	    
	  }
	   
	   @Override
	   public void stateChanged(ChangeEvent e) {
	      // TODO Auto-generated method stub
	      color = colorChooser.getColor();
	      colorChange = true;
	      MakeFrame.c.setBackground(color);
	      System.out.println(color);
	   }
	   
	   
}
