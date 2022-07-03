import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

public class BlackWhite extends JPanel {
	int startx;
	int starty;
	
	public BlackWhite(int startx, int starty) throws IOException {
		this.startx = startx;
		this.starty = starty;
		
		this.setBounds(startx,starty,700,700);
		this.setBackground(Color.WHITE);
		for (int y = 0; y < Frame.change_image.getHeight(); y++) {
	         for (int x = 0; x < Frame.change_image.getWidth(); x++) {
	            int pixel = Frame.change_image.getRGB(x,y);
	            Color color = new Color(pixel, true);
	            int red = color.getRed();
	            int green = color.getGreen();
	            int blue = color.getBlue();
	            int average = (red+green+blue)/3;

	            //Creating new Color object
	            color = new Color(average, average, average);
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
        Image resizeImage  = Frame.change_image.getScaledInstance(w, h, Image.SCALE_SMOOTH);      
        BufferedImage newImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);

        
		Graphics2D g2d = (Graphics2D) g.create();
		if(Frame.change_image.getWidth(null)>Frame.change_image.getHeight(null)) {
            g2d.drawImage(resizeImage,0,700/2 - h/2,this);            
         }else {
            g2d.drawImage(resizeImage,700/2 - w/2,0,this);   
         }
	}
}
