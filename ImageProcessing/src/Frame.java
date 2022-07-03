import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Frame extends JFrame {
	
	static BufferedImage original_image;
	static BufferedImage change_image;
	static BufferedImage zoomImage;
	static BufferedImage bright_image;
	
	
	// JFrame image_choose = new JFrame();
	JPanel menu;
	JPanel call_image;
	
	int bright=0;
	int WIDTH = 1600;
	int HEIGHT = 1000;
	JButton button;
	JButton button1;
	JButton button2;
	JButton button3;
	ImagePanel newimage;
	JFileChooser chooser;
	JSlider slider = new JSlider(-255,100,0);;
	BrightImage brightimage;
	Scale scale;
	BlackWhite blackwhite;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frame mainFrame = new Frame();
		mainFrame.createFrame();
		// new GameFrame();
	}

	public Frame() {
		this.setTitle("Graphics Editor");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(WIDTH, HEIGHT);
		this.setLayout(null);
		this.setVisible(true);
		this.getContentPane().setBackground(Color.WHITE);
	}

	private void createFrame() {
		menu = new JPanel();

		button = new JButton("이미지 불러오기");
		button1 = new JButton("흑백 전환");
		button2 = new JButton("밝기 조절");
		button3 = new JButton("zoom");

		button.setBounds(0, 0, 100, 100);
		button1.setBounds(130, 0, 100, 100);
		button2.setBounds(260, 0, 100, 100);
		button3.setBounds(390, 0, 100, 100);

		menu.setBounds(0, 0, WIDTH, 100);
		menu.setBackground(Color.WHITE);
		menu.setLayout(null);
		menu.add(button);

		menu.add(button1);
		menu.add(button2);
		menu.add(button3);

		button.addActionListener(new MyListener());
		button1.addActionListener(new MyListener());
		button2.addActionListener(new MyListener());
		button3.addActionListener(new MyListener());
		
		scale = new Scale();
		
		
//		ImageIO.read(chooser.getSelectedFile())
			
		this.add(menu);
	}
	
	public static BufferedImage copyImage(BufferedImage source){
	    BufferedImage b = new BufferedImage(source.getWidth(), source.getHeight(), source.getType());
	    Graphics g = b.getGraphics();
	    g.drawImage(source, 0, 0, null);
	    g.dispose();
	    return b;
	}

	public class MyListener extends JPanel implements ActionListener, MouseListener, MouseMotionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getActionCommand().equals("이미지 불러오기")) {

				System.out.println("뿅");

				chooser = new JFileChooser();
				chooser.setFileFilter(new FileNameExtensionFilter("jpeg", "jpeg"));
				chooser.addChoosableFileFilter(new FileNameExtensionFilter("png", "png"));
				chooser.addChoosableFileFilter(new FileNameExtensionFilter("jpg", "jpg"));
				chooser.setSelectedFile(null);
				chooser.setMultiSelectionEnabled(false);
				chooser.setVisible(true);
				chooser.showOpenDialog(Frame.this);
				System.out.println(chooser.getSelectedFile());

				try {
					original_image =  ImageIO.read(chooser.getSelectedFile());
					change_image = ImageIO.read(chooser.getSelectedFile());
					bright_image = ImageIO.read(chooser.getSelectedFile());
					brightimage = new BrightImage(850, 200);
					newimage = new ImagePanel(50, 200);
					blackwhite = new BlackWhite(850, 200);
					
					newimage.repaint();
					newimage.setBounds(50, 200,700,700);
					Frame.this.add(newimage);
					Frame.this.add(blackwhite);
					Frame.this.add(brightimage);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

			
			if (e.getActionCommand().equals("흑백 전환")) {

				brightimage.setVisible(false);
				scale.setVisible(false);
				blackwhite.setVisible(true);
				blackwhite.repaint();
				
				System.out.println("뿅");

			}
			
			if (e.getActionCommand().equals("밝기 조절")) {
				System.out.println("클릭");
					
				bright_image = Frame.copyImage(Frame.change_image);
				
				brightimage.repaint();					
				brightimage.setVisible(true);
				blackwhite.setVisible(false);
				scale.setVisible(false);
				
				//slider 
				slider.setValue(0);
				slider.setBounds(260,100,300,50);
				slider.setMajorTickSpacing(20); //큰 눈금 간격 5로 설정
				slider.setMinorTickSpacing(10); //작은 눈금 간격 1로 설정
				slider.setPaintTicks(true); //눈금을 표시한다.
				slider.setPaintLabels(true); //값을 레이블로 표시한다.

				slider.setVisible(true);
				Frame.this.add(slider);
				slider.addChangeListener(new ChangeListener() {
					public void stateChanged(ChangeEvent e) {

						bright = slider.getValue();
						System.out.println(bright);
						for (int y = 0; y < bright_image.getHeight(); y++) {
							for (int x = 0; x < bright_image.getWidth(); x++) {
								int pixel = bright_image.getRGB(x, y);
								Color color = new Color(pixel, true);
								int red = color.getRed() + bright;
								if (red > 255)
									red = 255;
								else if (red < 0)
									red = 0;
								int green = color.getGreen() + bright;
								if (green > 255)
									green = 255;
								else if (green < 0)
									green = 0;
								int blue = color.getBlue() + bright;
								if (blue > 255)
									blue = 255;
								else if (blue < 0)
									blue = 0;
//								System.out.println("red:" + red);
//								System.out.println("green:" + green);
//								System.out.println("blue:" + blue);

								color = new Color(red, green, blue);
								change_image.setRGB(x, y, color.getRGB());
							}
						}
						brightimage.repaint();
						
		                
		                
		            }
		            
		        });
		
				
				System.out.println("뿅");

			}

		
			if (e.getActionCommand().equals("zoom")) {
				scale.setVisible(true);
				newimage.addMouseListener(new MyListener());
				newimage.addMouseMotionListener(new MyListener());
				Frame.this.add(scale);
				zoomImage = copyImage(change_image);
				
				System.out.println("뿅");

			}
		}
		

		@Override
		public void mouseDragged(MouseEvent e) {
			
				// TODO Auto-generated method stub
				int x = e.getX() * Frame.zoomImage.getWidth() / 699 - 190;
				int y = e.getY() * Frame.zoomImage.getHeight() / 699 - 190;
				if(e.getX() <= Frame.zoomImage.getWidth() && e.getY() <= Frame.zoomImage.getHeight()) {
					System.out.println("X: " + e.getX() + " Y: " + e.getY());
					System.out.println(Frame.zoomImage.getWidth());
					System.out.println(Frame.zoomImage.getHeight());
					change_image = zoomImage.getSubimage(x, y, 400, 400);	
				}
				Frame.this.scale.repaint();
			
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}

	
}

	
