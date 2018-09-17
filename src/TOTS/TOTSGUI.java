package TOTS;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TOTSGUI extends JFrame {

	HControlPanel Hero=new HControlPanel();
	shakeMoster shake=new shakeMoster(Hero);
	
	TOTSGUI() {
		 this.setResizable(false);
		 this.setLayout(null);
		 Backgroundpanle d=new Backgroundpanle();
	     d.setBounds(0,0, 864, 576);
         
	     
	     heroPanel h=new heroPanel();
	     h.setBounds(32,32,128,192);
	     h.setOpaque(false);
	     
	     
	     keyPanel k=new keyPanel();
	     k.setBounds(32, 224, 128, 160);
	     
	     
	    gamePanel g=new gamePanel();
	    g.setBounds(222, 31, 356, 356);

	    Hero.setBounds(32, 32, 544, 352);
        
	    this.add(Hero);this.add(h);this.add(k);
	    this.add(g);
	
	    this.addKeyListener(Hero);
	     
         this.add(d);
         
         
         
         shake.start();
		 this.setBounds(100,100,608,450);
		 this.setVisible(true);
		 this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		}
	
	
	public static void main(String[] args) {
	new TOTSGUI();
	
	
	}




	class Backgroundpanle extends JPanel{
		 /*File imageFile=new File("E:/a/floor.png");
		  * BufferedImage bi = ImageIO.read(imageFile);
		BufferedImage cbi = bi.getSubimage(10,20,30,40);
		Graphics g = tarImage.getGraphics();
		g.drawImage(cbi,50,60,null);*/
	
		protected void paintComponent(Graphics g){
          File imageFile=new File("pic/floor.png");
		  BufferedImage bi=null;
		try {
			bi = ImageIO.read(imageFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  BufferedImage cbi = bi.getSubimage(0,0,32,32);
			for(int i=0;i<864;i=i+32){
				for(int j=0;j<576;j=j+32 ){
					g.drawImage(cbi,i,j,this);
				}
			}
			
		}
	}
	
    class gamePanel extends JPanel{

		gamePanel(){
			this.setSize(356,356);
			  
			  }
			
			protected void paintComponent(Graphics g){
				for(int i=0;i<356;i=i+32){
						for(int j=0;j<356;j=j+32 ){
							g.drawImage(new ImageIcon("pic/0.png").getImage(),i,j,this);
						}
					}
				
				
				
				Graphics2D g2d= (Graphics2D)g;
				g2d.setColor(Color.orange);
				g2d.setStroke(new BasicStroke(4f));
				g2d.drawLine(0, 0, 0, 356);
				g2d.drawLine(0, 0, 356, 0);
				g2d.drawLine(356, 0, 356, 356);
				g2d.drawLine(0, 356, 356, 356);
				
			}
				  
	}
	
	class keyPanel extends JPanel{
		keyPanel(){
			this.setSize(128,160);
			  
			  }
			
			protected void paintComponent(Graphics g){
				for(int i=0;i<128;i=i+32){
						for(int j=0;j<160;j=j+32 ){
							g.drawImage(new ImageIcon("pic/0.png").getImage(),i,j,this);
						}
					}
				
				
				
				Graphics2D g2d= (Graphics2D)g;
				g2d.setColor(Color.orange);
				g2d.setStroke(new BasicStroke(4f));
				g2d.drawLine(0, 0, 0, 160);
				g2d.drawLine(0, 0, 128, 0);
				g2d.drawLine(128, 0, 128, 160);
				g2d.drawLine(0, 160, 128, 160);
				g2d.setStroke(new BasicStroke(3f));
				g2d.drawLine(0, 102, 128,102);
				g2d.drawLine(0, 132, 128,132);
				
				  g2d.drawImage(new ImageIcon("pic/-2.png").getImage(),10,5,this);
				  g2d.drawImage(new ImageIcon("pic/-3.png").getImage(),10,37,this);
				  g2d.drawImage(new ImageIcon("pic/-4.png").getImage(),10,69,this);
				  
				  /*g2d.drawString("Level", 64, 48);
				  g2d.drawString("1", 128, 48);
				  g2d.drawString("HP", 32, 96);
				  
				  g2d.drawString("Defence", 32, 128);
				  
				  g2d.drawString("Money",32,160);
				  
				  g2d.drawString("EX", 32, 192);*/
					
				
			}
	}
	
	class heroPanel extends JPanel{
		 /*BufferedImage bi = (BufferedImage)srcImage;
	BufferedImage cbi = bi.getSubimage(10,20,30,40);
	Graphics g = tarImage.getGraphics();
	g.drawImage(cbi,50,60,null);*/
		heroPanel(){
		this.setSize(128,192);
		  
		  }
		
		protected void paintComponent(Graphics g){
			for(int i=0;i<128;i=i+32){
					for(int j=0;j<192;j=j+32 ){
						g.drawImage(new ImageIcon("pic/0.png").getImage(),i,j,this);
					}
				}
			File imageFile=new File("pic/hero.png");
			  BufferedImage bi=null;
			try {
				bi = ImageIO.read(imageFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Graphics2D g2d= (Graphics2D)g;
			g2d.setColor(Color.orange);
			g2d.setStroke(new BasicStroke(4f));
			g2d.drawLine(0, 0, 0, 192);
			g2d.drawLine(0, 0, 128, 0);
			g2d.drawLine(128, 0, 128, 192);
			g2d.drawLine(0, 192, 128, 192);
			BufferedImage pic1 = bi.getSubimage(0,0,32,32);
			  g2d.drawImage(new ImageIcon("pic/h1.png").getImage(),5,5,this);
			  
			  g.setFont(new Font(null,Font.BOLD ,15));
			  g.drawString("Level", 58, 32);
			  

			  g.drawString("HP", 16, 60);
			  g.drawString("Attack", 16, 90);
			  
			  g.drawString("Defence", 16, 120);
			  
			  g.drawString("Money",16,150);
			  
			  g.drawString("EX", 16, 180);
				
			
		}
		
	}
	
		

	
		
	

	
	

}
