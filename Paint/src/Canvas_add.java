import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JPanel;

public class Canvas_add extends JPanel {
	static Point startP=null;
	static Point endP=null;

	ArrayList<Point> for_pen;
	
	static Stack<Collect_pen> collection = new Stack<Collect_pen>();
	static Stack<Collect_pen> collection_redo = new Stack<Collect_pen>();
	
	int for_pen_count =0;
	Point a = null;
	Point b = null;
	
	static boolean ss = false;
	static boolean sc = false;
	static boolean sl = false;
	static boolean sp = false;
	static boolean erase_pixel = false;
	static boolean redo = false;
	static boolean spoid = false;

	
	Canvas_add(){
		super();//부모 생성자
		MyMouseListener a = new MyMouseListener();//마우스 리스터 생성
		this.addMouseListener(a); // 마우스리스너 넣어주기
		this.addMouseMotionListener(a);// 마우스 리스너 넣기
		
	}
	
	
		public void paintComponent(Graphics g){
			super.paintComponent(g); // 부모 페인트호출
			Graphics2D g2d = (Graphics2D) g.create();
	        
			if(collection.size() != 0){
				for(int i=0;i<collection.size();i++){ 
					//넣은 리스트 크기만큼
					Point sp = collection.get(i).sv; // 시작점
					Point ep = collection.get(i).se; // 끝점
					String on = collection.get(i).name; // 이름
					Color tmp = collection.get(i).co; // 색깔
					Integer s = collection.get(i).st;//굵기
					
					System.out.println("-----------------저장------------");
					System.out.println("i = "+i);
					System.out.println("시작점 = "+collection.get(i).sv);
					System.out.println("끝점 = "+collection.get(i).se);
					System.out.println("이름 = "+collection.get(i).name);
					System.out.println("색깔 = "+collection.get(i).co);
					System.out.println("굻기 = "+collection.get(i).st);
					System.out.println("-------------------------------");
					//꺼내서 도형 그려주기
					
					g2d.setColor(tmp); //그릴 색깔 지정
					g2d.setStroke(new BasicStroke(s));// 그리굵기 지정
					
					if (Canvas_add.spoid == false) {
						// 새로운 도형 그릴 때 불러오기
						if (on.equals("rect")) {
							g2d.drawRect(Math.min(sp.x, ep.x), Math.min(sp.y, ep.y), Math.abs(sp.x - ep.x),
									Math.abs(sp.y - ep.y));

						} else if (on.equals("line")) {
							g2d.drawLine(sp.x, sp.y, ep.x, ep.y);
						} else if (on.equals("circle")) {
							g2d.drawOval(Math.min(sp.x, ep.x), Math.min(sp.y, ep.y), Math.abs(sp.x - ep.x),
									Math.abs(sp.y - ep.y));
						}

						else if (on.equals("pen")) {

							for (int j = 0; j < collection.get(i).collect_point.size() - 1; j++) {

								b = collection.get(i).collect_point.get(j);
								a = collection.get(i).collect_point.get(j + 1);
								g2d.drawLine(b.x, b.y, a.x, a.y);
							}

						} else if (on.equals("erase")) {

							for (int j = 0; j < collection.get(i).collect_point.size() - 1; j++) {

								b = collection.get(i).collect_point.get(j);
								a = collection.get(i).collect_point.get(j + 1);
								g2d.drawLine(b.x, b.y, a.x, a.y);
							}

						}
					}
					
					else if (Canvas_add.spoid == true) {
						// 새로운 도형 그릴 때 불러오기
						if (on.equals("rect")) {
							g2d.fillRect(Math.min(sp.x, ep.x), Math.min(sp.y, ep.y), Math.abs(sp.x - ep.x),
									Math.abs(sp.y - ep.y));

						} else if (on.equals("line")) {
							g2d.drawLine(sp.x, sp.y, ep.x, ep.y);
						} else if (on.equals("circle")) {
							g2d.fillOval(Math.min(sp.x, ep.x), Math.min(sp.y, ep.y), Math.abs(sp.x - ep.x),
									Math.abs(sp.y - ep.y));
						}

						else if (on.equals("pen")) {

							for (int j = 0; j < collection.get(i).collect_point.size() - 1; j++) {

								b = collection.get(i).collect_point.get(j);
								a = collection.get(i).collect_point.get(j + 1);
								g2d.drawLine(b.x, b.y, a.x, a.y);
							}

						} else if (on.equals("erase")) {

							for (int j = 0; j < collection.get(i).collect_point.size() - 1; j++) {

								b = collection.get(i).collect_point.get(j);
								a = collection.get(i).collect_point.get(j + 1);
								g2d.drawLine(b.x, b.y, a.x, a.y);
							}

						}
					}
					
					
					
				}
			}
			
			//마우스로 클릭하면서 연속적으로 그려지는 도형
			if(startP != null) {
				g2d.setColor(ColorChooser.color);
				g2d.setStroke(new BasicStroke(Button_stroke.stroke));
				//라인그리기
				if(sl==true) {
					g2d.drawLine(startP.x, startP.y, endP.x, endP.y);
				}
				//사각형 그리기
				else if(ss==true) {
					g2d.drawRect(Math.min(startP.x,endP.x), Math.min(startP.y,endP.y), Math.abs(startP.x-endP.x), Math.abs(startP.y-endP.y));//그리다
				}
				//원 그리기
				else if(sc==true) {
					
					g2d.drawOval(Math.min(startP.x,endP.x), Math.min(startP.y,endP.y), Math.abs(startP.x-endP.x), Math.abs(startP.y-endP.y));//그리다
			
				}
			}
		}
		
		class MyMouseListener extends MouseAdapter implements MouseMotionListener{
			
			public void mousePressed(MouseEvent e){// 클릭한부분을 시작점으로
				
				if(ss==true) {
					startP = e.getPoint();//사각형_시작점
					System.out.println("rect 추가");
					
				}
				
				else if(sl==true) {
					startP = e.getPoint();//사각형_시작점
					System.out.println("line 추가");
				}
				else if(sc==true) {
					startP = e.getPoint();//원_시작점
					System.out.println("circle 추가");
				}
				else if(sp==true) {
					startP = e.getPoint();//펜_시작점
					System.out.println("pen 추가");
					a = e.getPoint();
					for_pen= new ArrayList<Point>();
					for_pen.add(new Point(e.getX(), e.getY()));
				}
				else if(erase_pixel==true) {
					startP = e.getPoint();//원_시작점
					System.out.println("지우개 추가");
					a = e.getPoint();
					for_pen= new ArrayList<Point>();
					for_pen.add(new Point(e.getX(), e.getY()));
					
				}
//				else if(spoid ==true) {
//		               Shape shape = null;
//		               
//		               for(int i=collection.size()-1;i>=0;i--){ 
//
//		                  Point sp = collection.get(i).sv; // 시작점
//		                  Point ep = collection.get(i).se; // 끝점
//		                  String on = collection.get(i).name; // 이름
//		                  Color tmp = collection.get(i).co; // 색깔
//		                  Integer s = collection.get(i).st;//굵기
//		                  
//		                  if(on.equals("rect")) {
//		                     shape = new Rectangle2D.Double(sp.x, sp.y, ep.x, ep.y);
//		                  }
//		                  else if(on.equals("line")) {
//		                     shape = new Line2D.Double(sp.x, sp.y, ep.x, ep.y);
//		                  }
//		                  else if(on.equals("circle")) {
//		                     shape = new Ellipse2D.Double(sp.x, sp.y, ep.x, ep.y);
//		                  }
//		                  
//		                  else if(on.equals("pen")) {
//
//		                	  for (int j = 0; j < collection.get(i).collect_point.size() - 1; j++) {
//
//									b = collection.get(i).collect_point.get(j);
//									a = collection.get(i).collect_point.get(j + 1);
//									shape = new Line2D.Double(b.x, b.y, a.x, a.y);
//								}
//
//		                  }
//		                  else if(on.equals("erase")) {
//		                	  for (int j = 0; j < collection.get(i).collect_point.size() - 1; j++) {
//
//									b = collection.get(i).collect_point.get(j);
//									a = collection.get(i).collect_point.get(j + 1);
//									shape = new Line2D.Double(b.x, b.y, a.x, a.y);
//								}
//
//		                  }
//		                  if(shape.contains(e.getPoint().x, e.getPoint().y)) {
//		                     ColorChooser.color = tmp;
//		                     MakeFrame.c.setBackground(tmp);
//		                     break;
//		                     //repaint();
//		                  }
//		                  
//		                     
//		                  
//		               }
//
//		            }
				
	
				

				
			}
			
			
			public void mouseDragged(MouseEvent e){
				if(erase_pixel==true) {
					b =a;
					a = e.getPoint();

					endP = e.getPoint();
							
					Graphics g = getGraphics();
					Graphics2D g2d = (Graphics2D) g;
					g2d.setColor(Color.WHITE);
					g2d.setStroke(new BasicStroke(Button_erase.stroke));
					g2d.drawLine(b.x, b.y, a.x, a.y);//그리다
					for_pen.add(new Point(e.getX(), e.getY()));
				}
				
				else if(sp==true) {
					b=a;
					a=e.getPoint();
					endP = e.getPoint();				
					
					Graphics g = getGraphics();
					Graphics2D g2d = (Graphics2D) g;
					g2d.setColor(ColorChooser.color);
					g2d.setStroke(new BasicStroke(Button_stroke.stroke));
					g2d.drawLine(b.x, b.y, a.x, a.y);//그리다
					
					for_pen.add(new Point(e.getX(), e.getY()));
					
					
				}
				else if(ss==true||sl==true||sc==true){
				
				endP = e.getPoint();
				repaint();
				}
				
				else if(spoid ==true) {
		               Shape shape = null;
		               
		               for(int i=collection.size()-1;i>=0;i--){ 

		                  Point sp = collection.get(i).sv; // 시작점
		                  Point ep = collection.get(i).se; // 끝점
		                  String on = collection.get(i).name; // 이름
		                  Color tmp = collection.get(i).co; // 색깔
		                  Integer s = collection.get(i).st;//굵기
		                  
		                  if(on.equals("rect")) {
		                     shape = new Rectangle2D.Double( Math.min(sp.x, ep.x),Math.min(sp.y, ep.y), Math.abs(sp.x - ep.x), Math.abs(sp.y - ep.y));
		                  }
		                  else if(on.equals("line")) {
		                     shape = new Line2D.Double(sp.x, sp.y, ep.x, ep.y);
		                  }
		                  else if(on.equals("circle")) {
		                     shape = new Ellipse2D.Double(Math.min(sp.x, ep.x),Math.min(sp.y, ep.y), Math.abs(sp.x - ep.x), Math.abs(sp.y - ep.y));
		                  }
		                  
		                  else if(on.equals("pen")) {

		                	  for (int j = 0; j < collection.get(i).collect_point.size() - 1; j++) {

									b = collection.get(i).collect_point.get(j);
									a = collection.get(i).collect_point.get(j);
									System.out.println("------------------------------");
									System.out.println(a);
									System.out.println(e.getPoint());
									System.out.println("------------------------------");
									if(e.getPoint().equals(a)) {
										System.out.println("같음");
										ColorChooser.color = tmp;
					                    MakeFrame.c.setBackground(tmp);
										
									}
									shape = new Line2D.Double(b.x, b.y, a.x, a.y);	
									
									
								}
		                	  

		                  }
		                  else if(on.equals("erase")) {
		                	  for (int j = 0; j < collection.get(i).collect_point.size() - 1; j++) {

									b = collection.get(i).collect_point.get(j);
									a = collection.get(i).collect_point.get(j + 1);
									shape = new Line2D.Double(b.x, b.y, a.x, a.y);
									System.out.println("같음");
									ColorChooser.color = tmp;
				                    MakeFrame.c.setBackground(tmp);
				                    if(shape.contains(e.getPoint().x, e.getPoint().y)) {
					                     ColorChooser.color = tmp;
					                     MakeFrame.c.setBackground(tmp);
					                     break;
					                     //repaint();
					                  }
								}

		                  }
		                  if(shape.contains(e.getPoint().x, e.getPoint().y)) {
			                     ColorChooser.color = tmp;
			                     MakeFrame.c.setBackground(tmp);
			                     break;
			                     //repaint();
			                  }
		                  
		                  

		               }

		            }
				
			}
			
			public void mouseReleased(MouseEvent e){
				if(ss==true||sl==true||sc==true) {
					
					endP = e.getPoint();
					String temp_name="";
					repaint(); // 다시그려라

					if(ss==true) temp_name = "rect";
					else if(sl==true) temp_name ="line";
					else if(sc==true) temp_name ="circle";
					
					collection.add(new Collect_pen(startP, endP,temp_name,ColorChooser.color,Button_stroke.stroke));
					
					System.out.println("도형: "+temp_name);
					System.out.println("시작점: "+startP);
					System.out.println("끝점: "+endP);
					System.out.println("색깔: "+ColorChooser.color);
					System.out.println("굵기: "+Button_stroke.stroke);
					System.out.println("추가");
					System.out.println("-------------------");
					
					System.out.println("collection size = "+collection.size());
					
				}
				
				
				else if(sp==true) {
					
					endP = e.getPoint();
					for_pen.add(new Point(e.getX(), e.getY()));
					collection.add(new Collect_pen(startP, endP,"pen",ColorChooser.color, Button_stroke.stroke, for_pen));
					a=e.getPoint();
					
				}
				else if(erase_pixel==true) {
					
					endP = e.getPoint();
					for_pen.add(new Point(e.getX(), e.getY()));
					collection.add(new Collect_pen(startP, endP,"erase",Color.WHITE, Button_erase.stroke, for_pen));
					a=e.getPoint();
					
				}
				

			}
		}
		
		class Collect_shape{
			Point sv; // 시작
			Point se; // 끝점
			String name;//도형이름 저장
			Color co;
			int st;
			
			public Collect_shape() {
				sv=null;
				se=null;
				name="";
				co = Color.BLACK;
				st=0;
			}
			
			public Collect_shape(Point start, Point finish, String n, Color color, int stroke) {
				sv = start;
				se = finish;
				name = n;
				co = color;
				st = stroke;
			}
		}
		
		class Collect_pen extends Collect_shape{
			ArrayList<Point> collect_point = new ArrayList<Point>();
			
			public Collect_pen() {
				super();
				
			}
			
			public Collect_pen(Point start, Point finish, String n, Color color, int stroke) {
				super(start, finish, n, color, stroke);
				
			}
			
			public Collect_pen(Point start, Point finish, String n, Color color, int stroke, ArrayList<Point> b) {
				super(start, finish, n, color, stroke);
				for(int i=0; i<b.size(); i++) 
					collect_point.add(b.get(i));
				
			}
			
			
		}
		
		
		

}
