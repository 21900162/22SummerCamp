import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Button_erase extends JButton{
	
	static int stroke = 5; 
	
	public Button_erase() {
		super();
		decorate();
	}

	public Button_erase(String string) {
		super(string);
		decorate();
	}
	public Button_erase(ImageIcon erase_small) {
		
		super(erase_small);
		decorate();
	}

	protected void decorate() {
        setBorderPainted(false);
        setOpaque(false);
    }
	
	protected void paintComponent(Graphics g) {
	    int width = getWidth();
	    int height = getHeight();
	    this.setBackground(new Color(234,221,194));

	    Graphics2D graphics = (Graphics2D) g;

	    graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

	    if (getModel().isArmed()) {
	        graphics.setColor(getBackground().darker());
	    } else if (getModel().isRollover()) {
	        graphics.setColor(getBackground().brighter());
	    } else {
	        graphics.setColor(getBackground());
	    }

	    graphics.fillRoundRect(0, 0, width, height, 10, 10);

	    FontMetrics fontMetrics = graphics.getFontMetrics();
	    Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();

	    int textX = (width - stringBounds.width) / 2;
	    int textY = (height - stringBounds.height) / 2 + fontMetrics.getAscent();

	    graphics.setColor(getForeground());
	    graphics.setFont(getFont());
	    graphics.drawString(getText(), textX, textY);
	    //graphics.dispose();

	    super.paintComponent(g);
	}
}
