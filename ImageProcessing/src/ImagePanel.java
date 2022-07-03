import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {

	private byte[] pixels;
	public ImagePanel(int startx, int starty) throws IOException{

		
		
		this.setBackground(Color.WHITE);

		
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		double ratio = 0.0;
        int w = 0;
        int h = 0;
        if(Frame.original_image.getWidth(null)>Frame.original_image.getHeight(null)) {
           ratio = ((double)700)/((double)Frame.original_image.getWidth(null));
           w = (int)(Frame.original_image.getWidth(null) * ratio);
           h = (int)(Frame.original_image.getHeight(null) * ratio);
        }else {
           ratio = ((double)700)/((double)Frame.original_image.getHeight(null));
           w = (int)(Frame.original_image.getWidth(null) * ratio);
           h = (int)(Frame.original_image.getHeight(null) * ratio);
        }
        Image resizeImage = Frame.original_image.getScaledInstance(w, h, Image.SCALE_SMOOTH);      
        BufferedImage newImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);

        
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.drawImage(resizeImage,0,700/2 - h/2,this);
	}
	

	
	

}
