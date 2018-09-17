package TOTS;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class HControlPanel extends JPanel implements  KeyListener{
	int herox;
	int heroy;
	Hero hero= new Hero(this);
	
	
	
	boolean substance=false;
	boolean Monster=false;
	boolean Staff=false;
	boolean oldEX=false;
	boolean storeM=false;
	boolean redSale=false;
	
	
	
	HControlPanel(){
		this.setOpaque(false);
		this.setSize(544,352);
		
	}

	public void paint(Graphics g) {
		
		
		hero.paint(g);
		hero.getBG().paint(g);
		
		
		File imageFile=new File("pic/hero.png");
        BufferedImage bi=null;
        try {
        bi = ImageIO.read(imageFile);
         } catch (IOException e) {
	// TODO Auto-generated catch block
	
        }BufferedImage pic1 = bi.getSubimage(herox,heroy,32,32);
        g.drawImage(pic1,hero.getX()*32+192,hero.getY()*32,this);
		if(substance)hero.drawSubstanceBar(g);
		if(Monster)hero.drawMonsterBar(g);
		if(Staff)hero.drawStaffBar(g);
	    if(oldEX)hero.drawEXSaleBar(g);
	    if(storeM) hero.drawStoreBar(g);
	    if(redSale)hero.drawRedSaleBar(g);
			
	}

	@SuppressWarnings("deprecation")
	@Override
	public void keyPressed(KeyEvent e) {
		
		if(!Monster&&!substance&&!Staff&&!oldEX&&!storeM&&!redSale){
		switch(e.getKeyCode()){
		case KeyEvent.VK_UP:hero.Move(0);heroShakeUp();break;
	    case KeyEvent.VK_LEFT:hero.Move(1);heroShakeLeft();break; 
	    case KeyEvent.VK_DOWN:hero.Move(2);heroShakeDown();break;
	    case KeyEvent.VK_RIGHT:hero.Move(3);heroShakeRight();break;
	    }
		
	   new heroshake(this).start();
	   }
		if(Staff)
			if(e.getKeyCode()==KeyEvent.VK_SPACE)
				hero.DS.resume();
		
		if(oldEX){
			if(e.getKeyCode()==KeyEvent.VK_UP){
				hero.SelectiveBar=(byte) (hero.SelectiveBar==0? 0:hero.SelectiveBar-1);
				this.repaint();
			}
			if(e.getKeyCode()==KeyEvent.VK_DOWN){
				hero.SelectiveBar=(byte) (hero.SelectiveBar==3? 3:hero.SelectiveBar+1);
				this.repaint();
			}
			if(e.getKeyCode()==KeyEvent.VK_SPACE){
		          hero.saleEX();
		    }
	    }
		
		if(storeM){
			if(e.getKeyCode()==KeyEvent.VK_UP){
				hero.SelectiveBar=(byte) (hero.SelectiveBar==0? 0:hero.SelectiveBar-1);
				this.repaint();
			}
			if(e.getKeyCode()==KeyEvent.VK_DOWN){
				hero.SelectiveBar=(byte) (hero.SelectiveBar==3? 3:hero.SelectiveBar+1);
				this.repaint();
			}
			if(e.getKeyCode()==KeyEvent.VK_SPACE){
		          hero.saleMoney();
		    }
			
			
	    }
		if(redSale){
			if(e.getKeyCode()==KeyEvent.VK_UP){
				hero.SelectiveBar=(byte) (hero.SelectiveBar==0? 0:hero.SelectiveBar-1);
				this.repaint();
			}
			if(e.getKeyCode()==KeyEvent.VK_DOWN){
				hero.SelectiveBar=(byte) (hero.SelectiveBar==3? 3:hero.SelectiveBar+1);
				this.repaint();
			}
			if(e.getKeyCode()==KeyEvent.VK_SPACE){
		          hero.saleRed();
		    }
		}
			
				
			
		
	   //this.repaint();
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	int herodown;int heroup;int heroleft;int heroright;
	private void heroShakeDown(){
		herodown++;heroup=0;heroleft=0;heroright=0;
		if(herodown==1){
			herox=0;
			heroy=0;
			this.repaint();
		}else{
			herox=herox==96?0:herox+32;
			heroy=0;
			this.repaint();
			
		}
	}
	private void heroShakeUp(){
		herodown=0;heroup++;heroleft=0;heroright=0;
		if(heroup==1){
			herox=0;
			heroy=98;
			this.repaint();
		}else{
			herox=herox==96?0:herox+32;
			heroy=98;
			this.repaint();
	}
   }
	private void heroShakeLeft(){
		herodown=0;heroup=0;heroleft++;heroright=0;
		if(heroleft==1){
			herox=0;
			heroy=32;
			this.repaint();
		}else{
			herox=herox==96?0:herox+32;
			heroy=32;
			this.repaint();
	}
   }
	private void heroShakeRight(){
		herodown=0;heroup=0;heroleft=0;heroright++;
		if(heroright==1){
			herox=0;
			heroy=65;
			this.repaint();
		}else{
			herox=herox==96?0:herox+32;
			heroy=65;
			this.repaint();
		    
	}
   }
	
	
	class heroshake extends Thread{
		HControlPanel a;
		heroshake (HControlPanel a){
			this.a=a;
		}
		public synchronized void run()
		  {
			      try
			      {
			        Thread.sleep(100L);
			      }
			      catch (Exception localException) {}
	          a.herox=0;
		      a.repaint();  
		  }
		
	}
	
	
	
			
		
	
}
