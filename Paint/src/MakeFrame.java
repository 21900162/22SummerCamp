import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MakeFrame extends JFrame{
	//패널 만들기
	static JFrame f1 = new JFrame();
	static JPanel button_back = new JPanel();
	static JPanel b1 = new JPanel();
	static JPanel b2 = new JPanel();
	static JPanel b3 = new JPanel();
	static JPanel b4 = new JPanel();

	static JPanel in_b2 = new JPanel();
	static JPanel in_b3 = new JPanel();
	static JPanel in_b3_2 = new JPanel();
	static JPanel in_b4 = new JPanel();
	
	static Canvas_add for_draw = new Canvas_add();//그리기용 canvas
	
	
	Button_order bf = new Button_order("←");
	Button_order af = new Button_order("→");
	Button_shape[] sbtn = new Button_shape[5];
	
	Button_stroke m = new Button_stroke("+");
	Button_stroke p = new Button_stroke("-");
	Button_erase er = new Button_erase("erase");
	static Button_color c=new Button_color("색");

	public MakeFrame() {
		
		String[] shape = {"□","○","↗","~"};
		for(int i=0; i<shape.length; i++) {
			sbtn[i] = new Button_shape(shape[i]);
			sbtn[i].addActionListener(new MyListener());
		}
		
		for_draw.setBounds(110,0,1080,720);
		for_draw.setBackground(Color.WHITE);
		
		
		
		//f1.getContentPane().setBackground(Color.LIGHT_GRAY);

		//맨뒤 button panel설정

		button_back.setBounds(0,0,110,720);;
		button_back.setLayout(null);
		button_back.setBackground(Color.LIGHT_GRAY);
		
		//첫번째 Panel설정
		b1.setBounds(5,10,100,20);
		b1.setBackground(Color.LIGHT_GRAY);
		b1.setLayout(new GridLayout(1,2,10,10));
		b1.add(bf);
		b1.add(af);
		button_back.add(b1);
		
		//두번째 Panel설정
		b2.setBounds(5,50,100,100);
		b2.setLayout(new GridLayout(2,2,10,10));
		b2.setBackground(Color.LIGHT_GRAY);
		b2.add(sbtn[0]);
		b2.add(sbtn[1]);
		b2.add(sbtn[2]);
		b2.add(sbtn[3]);
		button_back.add(b2);
		
		//세번째 Panel설정
		b3.setBounds(5,180,100,110);
		b3.setLayout(new GridLayout(2,1,10,10));
		b3.setBackground(Color.LIGHT_GRAY);
		//3-1
		in_b3.setLayout(new GridLayout(1,2,10,10));
		in_b3.add(m);
		in_b3.add(p);
		//3-2
		in_b3_2.setLayout(new GridLayout(1,2,10,10));
		in_b3_2.setBackground(Color.lightGray);
		JLabel j = new JLabel("Color");
		j.setBackground(Color.LIGHT_GRAY);
		j.setOpaque(true);
		j.setHorizontalAlignment(JLabel.RIGHT);//오른쪽 정렬
		c.setBackground(Color.BLACK);
		c.setBounds(5,0,10,40);
		in_b3.setBackground(Color.LIGHT_GRAY);
		in_b3_2.add(j);
		in_b3_2.add(c);
		b3.add(in_b3);
		b3.add(in_b3_2);
		button_back.add(b3);
		
		//네번째 Panel설정
		b4.setBounds(5,300,100,60);
		b4.setBackground(Color.LIGHT_GRAY);
		b4.add(er);
		button_back.add(b4);
		
		f1.add(for_draw);
		f1.add(button_back);
		
		
		f1.setTitle("그림판");
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f1.setSize(1320,720);
		f1.setLayout(null);
		f1.setVisible(true);
		
	}
 
	

}
