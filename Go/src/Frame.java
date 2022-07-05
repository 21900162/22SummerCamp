import java.awt.Color;
import java.awt.Point;
import java.awt.geom.Ellipse2D;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Frame extends JFrame{
	
	static String no;
	
	public Frame() {
		this.setTitle("Go");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1000, 1000);
		this.setLayout(null);
		this.setVisible(true);
		this.getContentPane().setBackground(Color.WHITE);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		no = JOptionPane.showInputDialog(null, "원하시는 착수금지점의 갯수를 입력하세요.(0~5)", "");
		Frame frame = new Frame();
		Board board = new Board();
		
		frame.add(board);
		board.repaint();
		
	}
	


}
