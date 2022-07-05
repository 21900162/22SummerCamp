import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Board extends JPanel{
	
	Ellipse2D.Double [][] point = new Ellipse2D.Double[19][19];
	int [][] check = new int[19][19];
	
	ArrayList<Integer> x = new ArrayList<Integer>();//행
	ArrayList<Integer> y = new ArrayList<Integer>();//열
	
	int newX = 0;
	int newY = 0;
	
	String result;
	
	int no = Integer.parseInt(Frame.no);
	

	
	public Board() {
		this.setBackground(new Color(248,207,117));
		this.setBounds(150,150,700,700);
		this.addMouseListener(new MyListener());
		this.setLayout(null);
	}
	public int checkFinishGo(int y, int x) {
		
//		System.out.println("check["+x+"]["+y+"] : " + check[x][y]);
		if(checkHorizontal(x, y, check[x][y]) >= 6) {
			System.out.println(check[x][y]+"승리");
			if(check[x][y] ==2) result = "백돌";
			if(check[x][y] ==1) result = "흑돌";
			JOptionPane.showMessageDialog(null, result + "승리!", "결과",JOptionPane.INFORMATION_MESSAGE);
			return check[x][y];
			
		}
		else if(checkVertical(x, y, check[x][y]) >= 6) {
			System.out.println(check[x][y]+"승리");
			if(check[x][y] ==2) result = "백돌";
			if(check[x][y] ==1) result = "흑돌";
			JOptionPane.showMessageDialog(null, result + "승리!", "결과",JOptionPane.INFORMATION_MESSAGE);
			return check[x][y];
		}
		else if(checkLRDiagonal(x, y, check[x][y]) >= 6) {
			System.out.println(check[x][y]+"승리");
			if(check[x][y] ==2) result = "백돌";
			if(check[x][y] ==1) result = "흑돌";
			JOptionPane.showMessageDialog(null, result + "승리!", "결과",JOptionPane.INFORMATION_MESSAGE);
			return check[x][y];
		}
		else if(checkRLDiagonal(x, y, check[x][y]) >= 6) {
			System.out.println(check[x][y]+"승리");
			if(check[x][y] ==2) result = "백돌";
			if(check[x][y] ==1) result = "흑돌";
			JOptionPane.showMessageDialog(null, result + "승리!", "결과",JOptionPane.INFORMATION_MESSAGE);
			return check[x][y];
		}

		return 0;
	}

	private int checkHorizontal(int row, int col, int rock) {
		try {
			if (check[row][col] != rock)
				return 0;
			else {
				return checkLeft(row - 1, col, rock) + 1 + checkRight(row + 1, col, rock);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			return 0;
		}
	}
	
	private int checkLeft(int row, int col, int rock) {
		try {
			if (check[row][col] != rock)
				return 0;
			else {
				return 1 + checkLeft(row - 1, col, rock);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			return 0;
		}
	}
	
	private int checkRight(int row, int col, int rock) {
		try {
			if (check[row][col] != rock)
				return 0;
			else {
				return 1 + checkRight(row + 1, col, rock);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			return 0;
		}
	}
	
	private int checkVertical(int row, int col, int rock) {
		try {
			if (check[row][col] != rock)
				return 0;
			else {
				return checkUp(row, col - 1, rock) + 1 + checkDown(row, col + 1, rock);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			return 0;
		}
	}
	
	private int checkUp(int row, int col, int rock) {
		try {
			if (check[row][col] != rock)
				return 0;
			else {
				return 1 + checkUp(row, col - 1, rock);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			return 0;
		}
	}
	
	private int checkDown(int row, int col, int rock) {
		try {
			if (check[row][col] != rock)
				return 0;
			else {
				return 1 + checkDown(row, col + 1, rock);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			return 0;
		}
	}
	
	private int checkLRDiagonal(int row, int col, int rock) {
		try {
			if (check[row][col] != rock)
				return 0;
			else {
				return checkLRDiagonalUp(row - 1, col - 1, rock) + 1 + checkLRDiagonalDown(row + 1, col + 1, rock);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			return 0;
		}
	}
	
	private int checkLRDiagonalUp(int row, int col, int rock) {
		try {
			if (check[row][col] != rock)
				return 0;
			else {
				return 1 + checkLRDiagonalUp(row - 1, col - 1, rock);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			return 0;
		}
	}
	
	private int checkLRDiagonalDown(int row, int col, int rock) {
		try {
			if (check[row][col] != rock)
				return 0;
			else {
				return 1 + checkLRDiagonalDown(row + 1, col + 1, rock);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			return 0;
		}
	}

	private int checkRLDiagonal(int row, int col, int rock) {
		try {
			if (check[row][col] != rock)
				return 0;
			else {
				return checkRLDiagonalUp(row + 1, col - 1, rock) + 1 + checkRLDiagonalDown(row - 1, col + 1, rock);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			return 0;
		}
	}
	
	private int checkRLDiagonalUp(int row, int col, int rock) {
		try {
			if (check[row][col] != rock)
				return 0;
			else {
				return 1 + checkRLDiagonalUp(row + 1, col - 1, rock);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			return 0;
		}
	}
	
	private int checkRLDiagonalDown(int row, int col, int rock) {
		try {
			if (check[row][col] != rock)
				return 0;
			else {
				return 1 + checkRLDiagonalDown(row - 1, col + 1, rock);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			return 0;
		}
	}

	
	public void paintComponent(Graphics g){

		super.paintComponent(g); // 부모 페인트호출
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setColor(Color.BLACK);
		
		
		for(int i = 35; i<700; i+=35) {
			g2d.drawLine(i, 35, i, 665);
			g2d.drawLine(35, i, 665, i);			
			
		}
		
		
		for(int i = 0; i<19; i++) {
			for(int j = 0; j<19; j++) {
				point[i][j] = new Ellipse2D.Double((i+1)*35-15,(j+1)*35-15 ,30,30);	
				if(i%3 == 0 && j%3 == 0 && i%6 != 0 && j%6 != 0) g2d.fill(new Ellipse2D.Double((i+1)*35-3, (j+1)*35-3, 6, 6));
				
			}	
		}
		
		
		for (int k = 0; k < x.size(); k++) {
			
			if(k<no) {
				check[y.get(k)][x.get(k)] = 3;
				g2d.setColor(Color.RED);
			}
			else if(k-no==0) {
				check[y.get(k)][x.get(k)] = 1;
				g2d.setColor(Color.BLACK);
			}
			else if((k+1-no)/2%2==1) {
				check[y.get(k)][x.get(k)] = 2;
				g2d.setColor(Color.WHITE);
			}
			else if((k+1-no)/2%2==0) {
				check[y.get(k)][x.get(k)] = 1;
				g2d.setColor(Color.BLACK);
			}
			g2d.fill(point[x.get(k)][y.get(k)]);
			
//			System.out.println("x_arraylist = "+ x.get(k));
//			System.out.println("y_arraylist = "+ y.get(k));
		}
		
		for(int i = 0; i<19; i++) {
			for(int j = 0; j<19; j++) {
				System.out.print(check[i][j] +" ");
				
			}	
			System.out.println();
		}
		System.out.println("check["+newY+"]["+newX+"] : " + check[newY][newX]);
		if(check[newY][newX] != 0)
			checkFinishGo(newX, newY);
		//System.out.println("check["+x.get(x.size()-1)+"] ")
		
	}
	
	public class MyListener extends JPanel implements ActionListener, MouseListener, MouseMotionListener {

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseClicked(MouseEvent e) {

			// TODO Auto-generated method stub
			for (int i = 0; i < point.length; i++) {
				for (int j = 0; j < point[0].length; j++) {//열
					if(point[i][j].contains(e.getPoint())) {
						System.out.println("i = "+ i);
						System.out.println("j = " +j);
						x.add(i);//열저장
						y.add(j);//행저장
						newX= i;
						newY = j;
						System.out.println("newX : "+newX+" newY: "+newY);
						
						
					}
				}
			}
			
			Board.this.repaint();
			
			
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

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	
}
