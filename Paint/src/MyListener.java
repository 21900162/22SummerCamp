import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.JFrame;


public class MyListener extends JFrame implements ActionListener {
		
			
		public void actionPerformed(ActionEvent e) {
			
			
				if(e.getActionCommand().equals("색")) {
					ColorChooser cc = new ColorChooser();
				}
				
				else if(e.getActionCommand().equals("□")) {
					Canvas_add.ss=true;
					Canvas_add.sc=false;
					Canvas_add.sl=false;
					Canvas_add.sp=false;

				}
				else if(e.getActionCommand().equals("↗")) {
					Canvas_add.ss=false;
					Canvas_add.sc=false;
					Canvas_add.sl=true;
					Canvas_add.sp=false;

				}
				else if(e.getActionCommand().equals("○")) {
					Canvas_add.ss=false;
					Canvas_add.sc=true;
					Canvas_add.sl=false;
					Canvas_add.sp=false;

				}
				else if(e.getActionCommand().equals("~")) {
					Canvas_add.ss=false;
					Canvas_add.sc=false;
					Canvas_add.sl=false;
					Canvas_add.sp=true;

				}
				else if(e.getActionCommand().equals("+")) {
					System.out.println("굵기 "+Button_stroke.stroke);
					Button_stroke.stroke++;
				}
				else if(e.getActionCommand().equals("-")) {
					System.out.println("굵기 "+Button_stroke.stroke);
					Button_stroke.stroke--;
				}
				
		}
}
		
		
		
		
