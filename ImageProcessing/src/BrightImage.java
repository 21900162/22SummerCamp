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
		for (int y = 0; y < Frame.bright_image.getHeight(); y++) {
	         for (int x = 0; x < Frame.bright_image.getWidth(); x++) {

	            int pixel = Frame.bright_image.getRGB(x,y);
	            Color color = new Color(pixel, true);
	            
	            int red = color.getRed();
	            if(red>255) red = 255;
	            int green = color.getGreen();
	            if(green>255) green = 255;
	            int blue = color.getBlue();
	            if(blue>255) blue = 255;

	            color = new Color(red, green, blue);
	            //Setting new Color object to the image
	            Frame.change_image.setRGB(x, y, color.getRGB());
	         }
	      }
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
        Image temp_resizeImage = Frame.bright_image.getScaledInstance(w, h, Image.SCALE_SMOOTH);   
        BufferedImage newImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);

        
		Graphics2D g2d = (Graphics2D) g.create();
		if(Frame.change_image.getWidth(null)>Frame.change_image.getHeight(null)) {
			if(check == true) {
				g2d.drawImage(resizeImage,0,700/2 - h/2,this);  
				check = false;
			}
			
			if(check == false)
				g2d.drawImage(resizeImage,0,700/2 - h/2,this);
         }else {
        	if(check == true) {
        		g2d.drawImage(resizeImage,700/2 - w/2,0,this);   
        		check = false;
        	}
        	if(check == false)
        		g2d.drawImage(resizeImage,700/2 - w/2,0,this);   
         }
	}
}
