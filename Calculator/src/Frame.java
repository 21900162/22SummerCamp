import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class Frame extends JFrame{
	
	JFrame frame;
	JTextField tf;
	
	JButton[] jbtn = new JButton[21];
	String temp="";
	boolean opr=true;// -연산을 위한 flag
	boolean repeat = false;
	boolean comma = false;
	DecimalFormat formatter = new DecimalFormat("0.#####");
	int count =5;
	
	public Frame() {
		
		frame = new JFrame();
		frame.setBounds(100,100,450, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		JPanel panel = new JPanel(new GridLayout(2,1));
		frame.add(panel);
		
		JPanel panel_text = new JPanel(null);
		panel_text.setBackground((new Color(215,225,235)));

		
		JPanel panel_button = new JPanel(new GridLayout(1,1));

		panel.add(panel_text);
		panel.add(panel_button);
		
		tf = new JTextField();
		tf.setHorizontalAlignment(JTextField.RIGHT);
		tf.setFont(new Font("맑은 고딕", Font.PLAIN, 60));
		tf.setBounds(10,50,420,200);
		tf.setEditable(false);
		tf.setBackground((new Color(205,227,224)));
		panel_text.add(tf);
		
		
		JPanel b = new JPanel(new GridLayout(5,4,10,10));
		b.setBackground((new Color(215,225,235)));
		String[] title = 	{"AC","R","=","←",
								"1","2","3","-",
								"4","5","6","/",
								"7","8","9","*",
								"00","0",".","+"};
		
		 for (int i = 0; i < title.length; i++) {
			 jbtn[i] = new JButton(title[i]);
			 jbtn[i].setFont(new Font("SansSerif", Font.BOLD, 20));
			 jbtn[i].addActionListener(new MyListener());
			 jbtn[i].setBackground(new Color(217,225,236));
			 jbtn[i].setForeground(Color.BLACK);
			 b.add(jbtn[i]);
			 
		 }//button만들기
		 panel_button.add(b);
		 
		
		frame.setVisible(true);	
		
	}
	
	public class MyListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			
			 
			 
			if((e.getActionCommand().equals("+")) && (opr == false)) {
				comma = false;
				opr=true;
				repeat=false;
				temp=temp+"," + "+" + ",";
				tf.setText(tf.getText()+e.getActionCommand());
			}

			
			else if(e.getActionCommand().equals("R")) {
				
				comma = false;
				String s1 [] = tf.getText().split("\\.");
				count = s1[1].length();
				opr=false;
				count--;
				System.out.println(count);
				showc(count);
				repeat =true;
			
			}
			
			else if(e.getActionCommand().equals("-") && opr==false) {
				comma = false;
				opr=true;
				repeat=false;
				temp=temp+"," + "-" + ",";
				tf.setText(tf.getText()+e.getActionCommand());
			}
			else if(e.getActionCommand().equals("-") && opr == true) {
				comma = false;
				repeat=false;
				temp=temp+"-";
				tf.setText(tf.getText()+e.getActionCommand());
			
			}
			else if(e.getActionCommand().equals("*") && opr==false) {
				comma = false;
				opr=true;
				repeat=false;
				temp=temp+","+ "*" +",";
				tf.setText(tf.getText()+e.getActionCommand());
			}
			else if(e.getActionCommand().equals("/") && opr==false) {
				comma = false;
				opr=true;
				repeat=false;
				temp=temp+","+"/"+",";
				tf.setText(tf.getText()+e.getActionCommand());
			}
			
			else if(e.getActionCommand().equals(".")) {
				
				if(comma == true) return;
				else {
					if(repeat == true) {
						comma =true;
						temp = e.getActionCommand();
						tf.setText("0"+temp);
						repeat=false;
						
						
					}
					else {
						comma = true;
						temp += e.getActionCommand();
						tf.setText(tf.getText()+e.getActionCommand());
						opr=false;
					}
				}
			
			}

			else if(e.getActionCommand().equals("←")) {
				comma = false;
				repeat=false;
				opr=false;
				String str = tf.getText();
				if(str.isEmpty()) return;
				str = str.substring(0, str.length()-1);
				tf.setText(str);
				
				String str1 = temp;
				if(str1.charAt(str1.length()-1)==',') {
					str1 = str1.substring(0, str1.length()-3);
				}
				else {str1 = str1.substring(0, str1.length()-1);}
				temp = str1;
	
			}
			
			else if(e.getActionCommand().equals("AC")) {
				comma = false;
				opr=true;
				repeat=false;
				temp="";
				tf.setText("");
			}
			
			else if(e.getActionCommand().equals("=")) {
				comma = false;
				calculate(temp);
				repeat = true;

			}
			
			else{//operand입력시
				if(repeat == true) {
					count=10;
					temp = e.getActionCommand();
					tf.setText(temp);
					repeat=false;
					
					
				}
				else {
					count=10;
					temp += e.getActionCommand();
					tf.setText(tf.getText()+e.getActionCommand());
					opr=false;
				}
				
			}
			
			System.out.println("temp = "+temp);
			System.out.println("tf = "+tf.getText());
		
		}

	}
	
	void calculate(String s) {
		
		
		String[] tmp = s.split(",");//operand, operator
		double forcal1= 0;
		double forcal2= 0;
		double result=0;
		
		String val="";
		String save="";
		String forrstack="";
		
		for(int i=0; i<tmp.length; i++) {
			System.out.print("["+tmp[i]+"] ");
		}// 확인 
		System.out.println();
		
		//stack생성
		Stack<String> stack = new Stack<>();
		Stack<String> rstack = new Stack<>();
		
		stack.push(tmp[0]);
		stack.push(tmp[1]);
		
		System.out.println(tmp[0]);
		System.out.println(tmp[1]);
		
		//배열에 있는 값 stack에 넣어주기
		for(int i=2; i<tmp.length; i++) {
			if(tmp[i-1].equals("*")) {
				System.out.println(stack.peek()+"뺴고");
				stack.pop();
				System.out.println(stack.peek()+"뺴고");
				
				
				forcal1 = Double.parseDouble(stack.pop());
				forcal2 = Double.parseDouble(tmp[i]);
				result = forcal2 * forcal1;
				System.out.println("계산하면"+result);
				val = String.valueOf(result);
				stack.push(val);
				
				System.out.println(result+"추가");
				
			}
			
			else if(tmp[i-1].equals("/")) {
				System.out.println(stack.peek()+"뺴고");
				stack.pop();
				System.out.println(stack.peek()+"뺴고");
				
				
				forcal1 = Double.parseDouble(stack.pop());
				forcal2 = Double.parseDouble(tmp[i]);
				if(forcal2==0) {
					tf.setText("ERROR");
					return;
				}
				result = forcal1 / forcal2;
				System.out.println("계산하면"+result);
				val = String.valueOf(result);
				stack.push(val);
				
				System.out.println(result+"추가");
				
				
			}
			else{
				stack.push(tmp[i]);
				System.out.println(tmp[i]+"추가");
				}
		}//+,-로만 구성
		
		while(!stack.empty()) {
			forrstack = stack.pop();
			System.out.println("rstack에 "+forrstack+"추가");
			rstack.push(forrstack);
		}
		
		while(!(rstack.size()==1)) {
			forcal1 = Double.parseDouble(rstack.pop());
			System.out.println("pop하면 "+forcal1);
			val = rstack.pop();
			System.out.println("pop하면 "+val);
			forcal2 = Double.parseDouble(rstack.pop());
			System.out.println("pop하면 "+forcal2);
			
			if(val.equals("+")) {
				result = forcal1+forcal2;
				System.out.println(forcal1+"+"+forcal2+"="+result);
				rstack.push(Double.toString(result));
			}
			if(val.equals("-")) {
				result = forcal1-forcal2;
				System.out.println(forcal1+"-"+forcal2+"="+result);
				rstack.push(Double.toString(result));
			}
		}
		 
		save = rstack.pop();
		BigDecimal c = new BigDecimal(save);

		save = formatter.format(c);
		tf.setText(save);
		temp=save;
		
		System.out.println("마지막 temp = "+temp);
		System.out.println("마지막 temp = "+tf.getText());
	

	}
	
	void showc(int co) {
		String forshow = tf.getText();
		String forshow2 = "";
		String forshow3 = "";
		
		if(co<0) co=0;
		if(co>9) co=9;
		
		forshow2 = showc_cal(co);
		BigDecimal c = new BigDecimal(forshow2);
		forshow3 = formatter.format(c);
		tf.setText(forshow3);
		temp = forshow3;
		formatter = new DecimalFormat("0.#####");
		
	}
	
	String showc_cal(int c) {
		String forshow = tf.getText();
		String forshow2 = "";
		
		String f1="%";
		String f2="0";
		f1= f1+"."+Integer.toString(c)+"f";
		
		if(c!=0){
			f2+=".";
			for(int i=0; i<c; i++) 
				f2+="#";
		}
		
		forshow2 = String.format(f1,Double.parseDouble(forshow));
		formatter = new DecimalFormat(f2);
		
		return forshow2;
	}
	
	public static void main(String[] args) {
				
		new Frame();
	}



}

