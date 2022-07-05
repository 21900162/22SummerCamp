import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Frame extends JFrame{
	
	static String no;
	static JLabel turn;
	
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
		JButton reset = new JButton("reset");
		turn = new JLabel();
		Font f = new Font("궁서",Font.BOLD,45);
		turn.setFont(f);
		turn.setHorizontalAlignment(JLabel.CENTER);
		
		reset.addActionListener(new ActionListener() {
	         @Override
	         public void actionPerformed(ActionEvent e) {
	        	System.out.println("클릭");
	        	Board.check = new int[19][19];
	            Board.x.clear();
	            Board.y.clear();
	            board.repaint();
	            turn.setText("");

	         }
	      });
		reset.setBounds(850,10,100,100);
		turn.setBounds(300,10,400,100);
		
		frame.add(board);
		frame.add(reset);
		frame.add(turn);
		board.repaint();
		
	}
	


}
