import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.*;

public class Scale extends JPanel{ 
	Scale(){
		this.setBounds(850, 200, 700, 700);
	}
	public void paintComponent(Graphics g) {
		Graphics2D g2=(Graphics2D)g;
		if(Frame.zoomImage!= null) {
			g2.drawImage(Frame.zoomImage,0,0,700,700,this);
		}
	}
}