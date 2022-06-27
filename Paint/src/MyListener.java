import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
					Canvas_add.erase_pixel=false;
					Canvas_add.redo = false;
					Canvas_add.collection_redo.clear();
					Canvas_add.spoid = false;

				}
				else if(e.getActionCommand().equals("↗")) {
					Canvas_add.ss=false;
					Canvas_add.sc=false;
					Canvas_add.sl=true;
					Canvas_add.sp=false;
					Canvas_add.erase_pixel=false;
					Canvas_add.redo = false;
					Canvas_add.collection_redo.clear();
					Canvas_add.spoid = false;

				}
				else if(e.getActionCommand().equals("○")) {
					Canvas_add.ss=false;
					Canvas_add.sc=true;
					Canvas_add.sl=false;
					Canvas_add.sp=false;
					Canvas_add.erase_pixel=false;
					Canvas_add.redo = false;
					Canvas_add.collection_redo.clear();
					Canvas_add.spoid = false;

				}
				else if(e.getActionCommand().equals("~")) {
					Canvas_add.ss=false;
					Canvas_add.sc=false;
					Canvas_add.sl=false;
					Canvas_add.sp=true;
					Canvas_add.erase_pixel=false;
					Canvas_add.redo = false;
					Canvas_add.collection_redo.clear();
					Canvas_add.spoid = false;

				}
				else if(e.getActionCommand().equals("+")) {
					
					Button_stroke.stroke++;
					MakeFrame.num.setText(""+Button_stroke.stroke);
					System.out.println("굵기 "+Button_stroke.stroke);
				}
				
				else if(e.getActionCommand().equals("-")) {
					
					Button_stroke.stroke--;
					if(Button_stroke.stroke<=0) Button_stroke.stroke=1;
					MakeFrame.num.setText(""+Button_stroke.stroke);
					System.out.println("굵기 "+Button_stroke.stroke);
					
					
				}
				
				else if(e.getActionCommand().equals("←")) {
					
					Canvas_add.startP=null;
					Canvas_add.endP=null;
					Canvas_add.redo = true;
					
					if(Canvas_add.collection.isEmpty()==false) {
						Canvas_add.collection_redo.add(Canvas_add.collection.peek()); 
						Canvas_add.collection.pop();
					}
					MakeFrame.for_draw.repaint();
					
					
				}
				
				else if(e.getActionCommand().equals("→")) {
					if (Canvas_add.redo == true && Canvas_add.collection_redo.isEmpty()==false) {
						Canvas_add.collection.add(Canvas_add.collection_redo.pop());
						MakeFrame.for_draw.repaint();
					}
				}
				
				else if(e.getSource()==MakeFrame.big || e.getSource()==MakeFrame.normal || e.getSource()==MakeFrame.small) {
					Canvas_add.ss=false;
					Canvas_add.sc=false;
					Canvas_add.sl=false;
					Canvas_add.sp=false;
					
					if(e.getSource()==MakeFrame.big) Button_erase.stroke =20;
					else if(e.getSource()==MakeFrame.normal) Button_erase.stroke =8;
					else if(e.getSource()==MakeFrame.small) Button_erase.stroke =2;
					
					
					
					Canvas_add.erase_pixel=true;
					System.out.println("Canvas_add.erase_pixel ="+Canvas_add.erase_pixel);

				}
				else if(e.getSource()==MakeFrame.spoid) {
					
					Canvas_add.ss=false;
					Canvas_add.sc=false;
					Canvas_add.sl=false;
					Canvas_add.sp=false;
					Canvas_add.erase_pixel=false;
					
					System.out.println("zmfflr!");
					if(Canvas_add.spoid == false)Canvas_add.spoid = true;
					else if(Canvas_add.spoid == true)Canvas_add.spoid = false;
					MakeFrame.for_draw.repaint();

				}
				
				
		}
}
		
		
		
		
