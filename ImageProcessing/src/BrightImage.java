import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

public class BrightImage extends JPanel {

	int startx;
	int starty;
	boolean check = true;
	
	
	public BrightImage(int startx, int starty) throws IOException {
		
		
		this.startx = startx;
		this.starty = starty;
		
		this.setBounds(startx,starty,700,700);
		
		this.setBackground(Color.WHITE);
	
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		double ratio = 0.0;
        int w = 0;
        int h = 0;
        if(Frame.change_image.getWidth(null)>Frame.change_image.getHeight(null)) {
           ratio = ((double)700)/((double)Frame.change_image.getWidth(null));
           w = (int)(Frame.change_image.getWidth(null) * ratio);
           h = (int)(Frame.change_image.getHeight(null) * ratio);
        }else {
           ratio = ((double)700)/((double)Frame.change_image.getHeight(null));
           w = (int)(Frame.change_image.getWidth(null) * ratio);
           h = (int)(Frame.change_image.getHeight(null) * ratio);
        }
        Image resizeImage = Frame.change_image.getScaledInstance(w, h, Frame.change_image.SCALE_SMOOTH);   
        BufferedImage newImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);

        
		Graphics2D g2d = (Graphics2D) g.create();
		if(Frame.change_image.getWidth(null)>Frame.change_image.getHeight(null)) {
            g2d.drawImage(resizeImage,0,700/2 - h/2,this);            
         }else {
            g2d.drawImage(resizeImage,700/2 - w/2,0,this);   
         }
	}
}
