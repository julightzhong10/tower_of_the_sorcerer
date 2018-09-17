package TOTS;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Hero extends JPanel{
   private int level=1;
   private int HP=10000;
   private int Money=1000;
   private int attack=1001;
   private int defence=1000;
   private int EX=1000;
   private int pX=4;
   private int pY=10;
   private int floor=0;
   private int rKey=100;
   private int bKey=100;
   private int yKey=100;
   
   
   private Maps m=new Maps();
   private Map BG=m.AllMaps[floor];
  
   HControlPanel HC;

   Hero(){	
	   this.setOpaque(false);
	   this.setSize(128,352);
   }
   Hero(HControlPanel a){
	   HC=a;	
	   this.setOpaque(false);
	   this.setSize(128,352);
	   
   }
   
   Hero(int level,int HP,int Money,int attack,int defence, int EX,int x,int y){
	   this.level=level;
	   this.HP=HP;
	   this.Money=Money;
	   this.attack=attack;
	   this.defence=defence;
	   this.EX=EX;
	   this.pX=x;
	   this.pY=y;
	   this.setOpaque(false);
	   this.setSize(128,352);
   }
   public void setLevel(int l){
	   level=l;
   }
   
   public void setHP(int HP){
	   this.HP=HP;
   }
   
   public void setMoney(int Money){
	   this.Money=Money;
   }
   
   public void setAttack(int a){
	   attack=a;
   }
   
   public void setDefence(int d){
	   defence=d;
   }
   
   public void setEX(int ex){
	   EX=ex;
   }
   
   public void setX(int x){
	   pX=x;
   }
   
   public void setY(int y){
	   pY=y;
   }

   public int getLevel(){
	   return level;
   }
   public int getHP(){
	   return HP;
   }
   
   public int getMoney(){
	   return Money;
   }
   
   public int getAttack(){
	   return attack;
   }
   
   public int getDefence(){
	   return defence;
   }
   
   public int getEX(){
	   return defence;
   }
   public int getX(){
	   return pX;
   }
   
   public int getY(){
	   return pY;
   }
   public Map getBG(){
	   return BG;
   }
   /*wall*/
   private void isStair(boolean a/*Tup,Fdown */){
	   floor= a==true? floor+1:floor-1;
	  int[][] c=m.AllMaps[floor].wallinf;
	   int x1=0,y1=0;//i y,j x

	   if(a){
		  for(int i=0 ;i<11;i++){
		    for(int j=0;j<11;j++)if(c[i][j]==5){x1=j;y1=i;i=11;break;}
		  }
	   }else {
		   for(int i=0;i<11;i++){
		     for(int j=0;j<11;j++)if(c[i][j]==4){x1=j;y1=i;i=11;break;}
		   
		   }
	   
	   }
       pX=x1;
       pY=y1;
	   BG=m.AllMaps[floor];
      /*
	   if(i==0){System.out.println("1y");
		   if(j==0){pX= c[i][j+1]!=0?j:j+1;
		            pY= c[i][j+1]!=0?i+1:i;
		   }
		   else if(j==10){
			   pX= c[i][j-1]!=0?j:j-1;
               pY= c[i][j-1]!=0?i+1:i;
			   
		   }
		   else{if(c[i+1][j]!=0){
			         if(c[i][j+1]!=0){
				         pX=j-1;pY=i;
			         }else {pX=j+1;pY=i;}
		        }else{pX=j;pY=i+1;}
			   
		   }
	   }else if(i==10){System.out.println("2y");
		        if(j==0){pX= c[i][j+1]!=0?j:j+1;
                         pY= c[i][j+1]!=0?i-1:i;
			    }else if(j==10){
			    	pX= c[i][j-1]!=0?j:j-1;
                    pY= c[i][j-1]!=0?i-1:i;
			    }else{
			    	if(c[i-1][j]!=0){
			    		if(c[i][j+1]!=0){
			    			pX=j-1;pY=i;
			    		}else{pX=j+1;pY=i;}
			    	}else{pX=j;pY=i-1;}
			    }
	   }else{System.out.println("3y");
		   if(c[i][j+1]!=0){
			   if(c[i+1][j]!=0){
				   if(c[i][j-1]!=0){
					   pX=j;pY=i-1;
				   }else{pX=j-1;pY=i;}
			   }else{pX=j;pY=i+1;}
		   }else{pX=j+1;pY=i;}
	   }
*/
	   
   }
   private boolean isWall(int s){
	   int[][] a=m.AllMaps[floor].wallinf;
	   switch(s){
	   case 0:{if(a[pY-1][pX]==4){isStair(true);return true;}
	          else if(a[pY-1][pX]==5){isStair(false);return true;}
	          else if(a[pY-1][pX]!=0)return true; 
	          else return false;
	          }
	   case 1:{if(a[pY][pX-1]==4){isStair(true);return true;}
               else if(a[pY][pX-1]==5){isStair(false);return true;}
               else if(a[pY][pX-1]!=0)return true;
	           else return false;
	          }
	   case 2:{if(a[pY+1][pX]==4){isStair(true);return true;}
               else if(a[pY+1][pX]==5){isStair(false);return true;}
		       if(a[pY+1][pX]!=0)return true;
	           else return false;
		      }
	   case 3:{if(a[pY][pX+1]==4){isStair(true);return true;}
               else if(a[pY][pX+1]==5){isStair(false);return true;}
		       if(a[pY][pX+1]!=0)return true;
	           else return false;
		   }
	   default:return true;
	   }   
   }
   /*wall*/
   
   
   
   /*Door*/
   private void removeDoor(int x, int y,int type ){
	   m.AllMaps[floor].doorinf[x][y]=type;
	   m.AllMaps[floor].mapsinf[x][y]=0;
	   new shakeDoor(HC).start();
	   printDetail();
   }
   private boolean openDoor(int door,int x,int y ){
	   switch(door){
	   case 1: {if(rKey==0)return true;
	            else {rKey--;removeDoor(x,y,6);return true;}
	   }
	   case 2:{if(bKey==0)return true;
               else {bKey--;removeDoor(x,y,7);return true;}
	   }
	   case 3:{if(yKey==0)return true;
               else {yKey--;removeDoor(x,y,8);return true;}
       }
	   default:return true;
	   }
	   
   }
   private boolean isDoor(int s){
	   int[][] a=m.AllMaps[floor].doorinf;
	   switch(s){
	   case 0:{if(a[pY-1][pX]==1){ return openDoor(1,pY-1,pX);}
	          else if(a[pY-1][pX]==2){ return openDoor(2,pY-1,pX);}
	          else if(a[pY-1][pX]==3){ return openDoor(3,pY-1,pX);}
	          else if(a[pY-1][pX]==4)return true; 
	          else return true;
	          }
	   case 1:{if(a[pY][pX-1]==1){ return openDoor(1,pY,pX-1);}
               else if(a[pY][pX-1]==2){ return openDoor(2,pY,pX-1);}
               else if(a[pY][pX-1]==3){ return openDoor(3,pY,pX-1);}
               else if(a[pY][pX-1]==4)return true;
	           else return true;
	          }
	   case 2:{if(a[pY+1][pX]==1){ return openDoor(1,pY+1,pX);}
               else if(a[pY+1][pX]==2){ return openDoor(2,pY+1,pX);}
               else if(a[pY+1][pX]==3){ return openDoor(3,pY+1,pX);}
               else if(a[pY+1][pX]==4)return true;
	           else return true;
		      }
	   case 3:{if(a[pY][pX+1]==1){ return openDoor(1,pY,pX+1);}
               else if(a[pY][pX+1]==2){ return openDoor(2,pY,pX+1);}
               else if(a[pY][pX+1]==3){ return openDoor(3,pY,pX+1);}
               else if(a[pY][pX+1]==4)return true;
	           else return true;
		   }
	   default:return true;
	   }
	   
   }
   /*Door*/
   
   /*Monster*/
   Monster fightProccess;
   private int mHP;
   private int mdefence;
   private int mattack;
   private int mx;
   private int my;
   class drawMonster extends Thread{
		HControlPanel a;

		drawMonster (HControlPanel a){
			this.a=a;
		}
		
			public synchronized void run()
			  {   boolean f=true; 
			      boolean t=true;
				  mHP=fightProccess.getHP();
			      mdefence=fightProccess.getDefence();
			      mattack=fightProccess.getAttack();
			      int m1=(attack-mdefence)<0?0:(attack-mdefence);
			      int m2=(mattack-defence)<0?0:(mattack-defence);
				  a.Monster=true;
				  a.repaint();
				  while(f){
				      if(t){
				    	  mHP=mHP-m1;
				    	  if(mHP<=0){mHP=0;f=false;}
				    	  t=!t;
				      }else{
				    	  HP=HP-m2;
				    	  t=!t;
				      }
				      
					  try
				      {
				        Thread.sleep(500L);
				      }
				      catch (Exception localException) {}
					  a.repaint();    
				  }
				  Money=Money+fightProccess.getMoney();
				  EX=EX+fightProccess.getEX();
				  removeMonster(mx,my);
				  a.Monster=false;
			      a.repaint();  
			  }
			
		}
   
   
   BufferedImage MonsterImage;
   
   
   public void drawMonsterBar(Graphics g){
	   Graphics2D g2= (Graphics2D)g;
		g2.setColor(Color.orange);
		g2.setStroke(new BasicStroke(4f));
		g2.drawLine(32, 50, 512, 50);
		g2.drawLine(32, 306, 512, 306);
		g2.drawLine(32, 50, 32, 306);
		g2.drawLine(512, 50, 512, 306);
		
		
		File imageFile=new File("pic/0.png");
		  BufferedImage bi=null;
		try {
			bi = ImageIO.read(imageFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  BufferedImage cbi = bi.getSubimage(0,0,32,32);
		  for(int i=32;i<512;i=i+32){
				for(int j=50;j<306;j=j+32 ){
					g.drawImage(cbi,i,j,(ImageObserver) this);
				}
			}
		
		  g.drawImage(MonsterImage, 210, 70, (ImageObserver) this);
		  g.drawImage(new ImageIcon("pic/h1.png").getImage(), 310, 70, (ImageObserver) this);
		  g.setFont(new Font(null,Font.ITALIC ,15));
		  g.drawString( "HP",80,150);
		  g.drawString( "HP",430,150);
		  g.drawString( "Attack",80,200);
		  g.drawString( "Attack",410,200);
		  g.drawString( "Defence",80,250);
		  g.drawString( "Defence",398,250);
		  
		  g.setFont(new Font(null,Font.BOLD ,20));
		  g2.setColor(Color.CYAN);
		  g.drawString( ""+defence,340,250);
		  g.drawString( ""+mdefence,150,250);
		  g.drawString( ""+HP,340,150);
		  g.drawString( ""+mHP,150,150); 
		  g.drawString( ""+attack,340,200);
		  g.drawString( ""+mattack,150,200);
		  g2.setColor(Color.WHITE);
		  g.setFont(new Font(null,Font.ITALIC ,80));
		  g.drawString( "VS",210,210);
   }
   
   
   
   private BufferedImage pickMonsterImage(int a){
	   String address = null;int x = 0,y = 0;
	   switch(a){
	   case 0: address=null;break;
	   case 50:address="pic/m1.png"; x=0;y=0;break;
	   case 1:address="pic/m1.png"; x=0;y=32;break;
	   case 2:address="pic/m2.png"; x=0;y=0;break;
	   case 3:address="pic/m3.png"; x=0;y=0;break;
	   case 4:address="pic/m1.png"; x=0;y=64;break;
	   case 5:address="pic/m3.png"; x=0;y=32;break;
	   case 6:address="pic/m5.png"; x=0;y=0;break;
	   case 7:address="pic/m2.png"; x=0;y=32;break;
	   case 8:address="pic/m4.png"; x=0;y=0;break;
	   case 9:address="pic/m3.png"; x=0;y=64;break;
	   case 10:address="pic/m4.png"; x=0;y=64;break;
	   
	   
	   case 11:address="pic/m5.png"; x=0;y=64;break;
	   case 12:address="pic/m6.png"; x=0;y=0;break;
	   case 13:address="pic/m2.png"; x=0;y=64;break;
	   case 14:address="pic/m5.png"; x=0;y=32;break;
	   case 15:address="pic/m1.png"; x=0;y=96;break;
	   case 16:address="pic/m8.png"; x=0;y=32;break;
	   case 17:address="pic/m7.png"; x=0;y=32;break;
	   case 18:address="pic/m5.png"; x=0;y=96;break;
	   case 19:address="pic/m4.png"; x=0;y=32;break;
	   case 20:address="pic/m6.png"; x=0;y=32;break;
	  
	   
	   case 21:address="pic/m6.png"; x=0;y=64;break;
	   case 22:address="pic/m6.png"; x=0;y=96;break;
	   case 23:address="pic/m7.png"; x=0;y=0;break;
	   case 24:address="pic/m7.png"; x=0;y=64;break;
	   case 25:address="pic/m8.png"; x=0;y=64;break;
	   case 26:address="pic/m3.png"; x=0;y=96;break;
	   case 27:address="pic/m7.png"; x=0;y=96;break;
	   case 28:address="pic/m4.png"; x=0;y=96;break;
	   case 29:address="pic/m8.png"; x=0;y=0;break;
	   case 30:address="pic/m8.png"; x=0;y=0;break;
	   
	   case 40:address="pic/m2.png"; x=0;y=96;break;
	   case 41:
	   case 42:
	   case 43:
	   case 44:
	   case 45:
	   case 46:
	   case 47:
	   case 48:
	   case 49:

	 }
	 if(address!=null){
	 File imageFile=new File(address);
        BufferedImage bi=null;
    try {
    bi = ImageIO.read(imageFile);
    } catch (IOException e) { }
    return (BufferedImage)bi.getSubimage(x,y,32,32);
	 }
	return null;
   }
   
   
   private boolean isMonster(int s){
	   int[][] a=m.AllMaps[floor].monsterinf;
		   
	   switch(s){
	       case 0:{ fightProccess=Monster.getMonster(a[pY-1][pX]);
	                mx=pY-1;my=pX;
	       return fight(fightProccess,pY-1,pX);
	       }
           
           case 1:{ fightProccess=Monster.getMonster(a[pY][pX-1]);
                    mx=pY;my=pX-1;
           return fight(fightProccess,pY,pX-1);
           }
           
           case 2:{fightProccess=Monster.getMonster(a[pY+1][pX]);
                   mx=pY+1;my=pX;
                  return fight(fightProccess,pY+1,pX);
           }
           case 3:{fightProccess=Monster.getMonster(a[pY][pX+1]);
                   mx=pY;my=pX+1;
           return fight(fightProccess,pY,pX+1);
           }
           
           default: return true;
	   }
   }
	   

   private boolean fight(Monster m,int x, int y){
	   int mHP=m.getHP();
	   int HP=this.HP;
	   boolean turn=true;
	 
	   if(m.getDefence()>=attack){
		   System.out.println("Your can't beat it");
	       return true;
	   }

	   while(true){
		  
		   if(turn){
			   mHP=mHP-(attack-m.getDefence());
			   turn=false;
			   if(mHP<=0){
				  
				   break;
			   }
		   }else {
			   HP=HP-(m.getAttack()-defence);
			   turn=true;
			   if(HP<=0){
				   System.out.println("Your can't beat it");
                    return true;
		       }
	       }
	   }
	   MonsterImage=pickMonsterImage(fightProccess.getMT());
	   new drawMonster(HC).start();
	   /*
	   removeMonster(x,y);
	   this.HP=HP;
	   EX=EX+m.getEX();
	   Money=Money+m.getMoney();
	   printDetail();*/
	   return true;
	}
   
   private void removeMonster(int x, int y ){
	   m.AllMaps[floor].monsterinf[x][y]=0;
	   m.AllMaps[floor].mapsinf[x][y]=0;
	   
   }
   /*Monster*/
   
   /*Substance*/
   private int substancebar=0;
   
   class drawSubstance extends Thread{
		HControlPanel a;
		drawSubstance (HControlPanel a){
			this.a=a;
		}
			public synchronized void run()
			  {       
				   a.substance=true;
				   a.repaint();
				      try
				      {
				        Thread.sleep(500L);
				      }
				      catch (Exception localException) {}
				  a.substance=false;
			      a.repaint();  
			  }
			
		}
   
   public void drawSubstanceBar(Graphics g){
	   Graphics2D g2= (Graphics2D)g;
		g2.setColor(Color.orange);
		g2.setStroke(new BasicStroke(4f));
		g2.drawLine(32, 120, 512, 120);
		g2.drawLine(32, 185, 512, 185);
		g2.drawLine(32, 120, 32, 185);
		g2.drawLine(512, 120, 512, 185);
		File imageFile=new File("pic/0.png");
		  BufferedImage bi=null;
		try {
			bi = ImageIO.read(imageFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  BufferedImage cbi = bi.getSubimage(0,0,32,32);
		  for(int i=32;i<512;i=i+32){
				for(int j=120;j<64+120;j=j+32 ){
					g.drawImage(cbi,i,j,(ImageObserver) this);
				}
			}
		  g.setFont(new Font(null,Font.BOLD ,20));
		  g.drawString( Substance.getSubstanceMessage(substancebar),40,150);
   }


   private boolean isSubstance(int s){
	   new drawSubstance(HC).start();
	   switch(s){
	   
	   case 0:return WhatSubstance(pY-1,pX);
	   case 1:return WhatSubstance(pY,pX-1);
	   case 2:return WhatSubstance(pY+1,pX);
	   case 3:return WhatSubstance(pY,pX+1);
	   default:return true;
	   }
	   
   }
   
   private boolean holychecklist=false;
   private boolean WhatSubstance(int x,int y){
	   int[][] a=m.AllMaps[floor].substanceinf;
	   substancebar=a[x][y];
	   switch(a[x][y]){
	case 1:this.rKey++;break;
   	case 2:this.yKey++;break;
   	case 3:this.bKey++ ;break;
   	case 4:this.HP=this.HP+200;break;
   	case 5:this.HP=this.HP+500;break;
   	case 6:this.attack=this.attack+3;break;
   	case 7:this.defence=this.defence+3;break;
   	case 8:this.attack=this.attack+10;break;
   	case 9:this.defence=this.defence+10;break;
   	case 10:this.attack=this.attack+20;break;
   	case 11:this.defence=this.defence+20;break;
   	case 12:this.attack=this.attack+40;break;
   	case 13:this.defence=this.defence+40;break;
   	case 14:this.attack=this.attack+50;break;
   	case 15:this.defence=this.defence+50;break;
   	case 16:this.attack=this.attack+100;break;
   	case 17:this.defence=this.defence+100;break;
   	default:return true;
	   }
	   removeSubstance(x,y);
	   printDetail();
	   return true;
	   
   }
   
   private void removeSubstance(int x, int y ){
	   m.AllMaps[floor].substanceinf[x][y]=0;
	   m.AllMaps[floor].mapsinf[x][y]=0;
	   
   }
   
   /*Substance*/
   
   
   
   /*Staff*/
   private String[] ConContent;
  private byte Page=0;
  public boolean p=true;;
  public drawStaff DS;
   class drawStaff extends Thread{
		HControlPanel a;
		drawStaff (HControlPanel a){
			this.a=a;
		}
			@SuppressWarnings("deprecation")
			public synchronized void run()
			  {    
				   a.Staff=true;
				   a.repaint();
				   boolean o=true;
				   while(o){
					   if(Page==(ConContent.length-1))o=false;
					    this.suspend();
					   //while(p){System.out.println(11);}
					   Page++;
					   a.repaint(); 
					   
					   p=true;
				   }
                  Page=0;
				  a.Staff=false;
			      a.repaint(); 
			     
			  }
			
		}
   
   public void drawStaffBar(Graphics g){
	   Graphics2D g2= (Graphics2D)g;
		g2.setColor(Color.orange);
		g2.setStroke(new BasicStroke(4f));
		g2.drawLine(32, 120, 512, 120);
		g2.drawLine(32,248, 512, 248);
		g2.drawLine(32, 120, 32, 248);
		g2.drawLine(512, 120, 512, 248);
		File imageFile=new File("pic/0.png");
		  BufferedImage bi=null;
		try {
			bi = ImageIO.read(imageFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  BufferedImage cbi = bi.getSubimage(0,0,32,32);
		  for(int i=32;i<512;i=i+32){
				for(int j=120;j<248;j=j+32 ){
					g.drawImage(cbi,i,j,(ImageObserver) this);
				}
			}
		  g.setFont(new Font(null,Font.BOLD ,20));
		  g.drawString(ConContent[Page],40,150);
   }
   
   
   //old EX NPC
   public drawOldEXNPC OE;
   private boolean old5or13=floor==4?true:false;
   class drawOldEXNPC extends Thread{
		HControlPanel a;
		drawOldEXNPC (HControlPanel a){
			this.a=a;
		}
			@SuppressWarnings("deprecation")
			public synchronized void run()
			  {    
				   a.oldEX=true;
				   a.repaint();
				   
					    this.suspend();
					   //while(p){System.out.println(11);}		   

				  a.oldEX=false;
			      a.repaint(); 
			     
			  }
			
		}
   public byte SelectiveBar=3;
   public void drawEXSaleBar(Graphics g){
	   Graphics2D g2= (Graphics2D)g;
		g2.setColor(Color.orange);
		g2.setStroke(new BasicStroke(4f));
		g2.drawLine(236, 60, 525, 60);
		g2.drawLine(236,317, 525, 317);
		g2.drawLine(236, 60, 236, 317);
		g2.drawLine(525, 60, 525, 317);
		File imageFile=new File("pic/0.png");
		  BufferedImage bi=null;
		try {
			bi = ImageIO.read(imageFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  BufferedImage cbi = bi.getSubimage(0,0,32,32);
		  for(int i=236;i<512;i=i+32){
				for(int j=60;j<312;j=j+32 ){
					g.drawImage(cbi,i,j,(ImageObserver) this);
				}
			}
		  g.setFont(new Font(null,Font.BOLD ,15));
		  if(old5or13){
		  g.drawString("Stroe",360,80);
		  g.drawString("Pay 30 EX to  choose one",300,110);
		  g.drawString("HP +800",350,150);
		  g.drawString("Attack +5",350,200);
		  g.drawString("Defence +5",350,250);
		  g.drawString("Exit",350,300);
		  }else {
			  g.drawString("Stroe",360,80);
			  g.drawString("Pay 120 Ex to choose one",300,110);
			  g.drawString("HP +3500",350,150);
			  g.drawString("Attack +25",350,200);
			  g.drawString("Defence +25",350,250);
			  g.drawString("Exit",350,300);
			  
		  }
		  g2.setColor(Color.magenta);
		  g2.drawLine(250, 130+SelectiveBar*50,498, 130+SelectiveBar*50);
		  g2.drawLine(250,160+SelectiveBar*50, 498, 160+SelectiveBar*50);
		  g2.drawLine(250, 130+SelectiveBar*50, 250, 160+SelectiveBar*50);
		  g2.drawLine(498, 130+SelectiveBar*50, 498, 160+SelectiveBar*50);
		  
		  
   }
   
   @SuppressWarnings("deprecation")
public void saleEX(){
      if(SelectiveBar==3)OE.resume();
      else if(old5or13){
        if(SelectiveBar==0){
    	   if(EX<30)return;
    	   EX=EX-30;
    	   HP=HP+800;
       }
       else if(SelectiveBar==1){
    	   if(EX<30)return;
    	   EX=EX-30;
    	   attack=attack+5;
       }
       else if(SelectiveBar==2){
    	   if(EX<30)return;
    	   EX=EX-30;
    	   defence=defence+5;
       }
        
      }else {
    	  if(SelectiveBar==0){
       	   if(EX<150)return;
       	   EX=EX-150;
       	   HP=HP+3500;
          }
          else if(SelectiveBar==1){
       	   if(EX<150)return;
       	   EX=EX-150;
       	   attack=attack+25;
          }
          else if(SelectiveBar==2){
       	   if(EX<150)return;
       	   EX=EX-150;
       	   defence=defence+25;
          }
       }
       HC.repaint();
       
   }
   
   //old EX NPC
  
   /*-------------*/
   
   // Store

   public drawStore Store;
   private boolean store3or11=floor==2?true:false;
   class drawStore extends Thread{
		HControlPanel a;
		drawStore(HControlPanel a){
			this.a=a;
		}
			@SuppressWarnings("deprecation")
			public synchronized void run()
			  {    
				   a.storeM=true;
				   a.repaint();
				   
					    this.suspend();
					   //while(p){System.out.println(11);}		   

				  a.storeM=false;
			      a.repaint(); 
			     
			  }
			
		}
   public void drawStoreBar(Graphics g){
	   Graphics2D g2= (Graphics2D)g;
		g2.setColor(Color.orange);
		g2.setStroke(new BasicStroke(4f));
		g2.drawLine(236, 60, 525, 60);
		g2.drawLine(236,317, 525, 317);
		g2.drawLine(236, 60, 236, 317);
		g2.drawLine(525, 60, 525, 317);
		File imageFile=new File("pic/0.png");
		  BufferedImage bi=null;
		try {
			bi = ImageIO.read(imageFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  BufferedImage cbi = bi.getSubimage(0,0,32,32);
		  for(int i=236;i<512;i=i+32){
				for(int j=60;j<312;j=j+32 ){
					g.drawImage(cbi,i,j,(ImageObserver) this);
				}
			}
		  g.setFont(new Font(null,Font.BOLD ,15));
		  if(store3or11){
		  g.drawString("Stroe",360,80);
		  g.drawString("Pay E to  choose one",300,110);
		  g.drawString("HP +800",350,150);
		  g.drawString("Attack +4",350,200);
		  g.drawString("Defence +4",350,250);
		  g.drawString("Exit",350,300);
		  }else {
			  g.drawString("Stroe",360,80);
			  g.drawString("Pay 100 Money to choose one",300,110);
			  g.drawString("HP +3500",350,150);
			  g.drawString("Attack +25",350,200);
			  g.drawString("Defence +25",350,250);
			  g.drawString("Exit",350,300);
			  
		  }
		  g2.setColor(Color.magenta);
		  g2.drawLine(250, 130+SelectiveBar*50,498, 130+SelectiveBar*50);
		  g2.drawLine(250,160+SelectiveBar*50, 498, 160+SelectiveBar*50);
		  g2.drawLine(250, 130+SelectiveBar*50, 250, 160+SelectiveBar*50);
		  g2.drawLine(498, 130+SelectiveBar*50, 498, 160+SelectiveBar*50);
		  
		  
   }
   
   @SuppressWarnings("deprecation")
public void saleMoney(){
      if(SelectiveBar==3)Store.resume();
      else if(store3or11){
        if(SelectiveBar==0){
    	   if(Money<25)return;
    	   Money=Money-25;
    	   HP=HP+800;
       }
       else if(SelectiveBar==1){
    	   if(Money<25)return;
    	   Money=Money-25;
    	   attack=attack+4;
       }
       else if(SelectiveBar==2){
    	   if(Money<25)return;
    	   Money=Money-25;
    	   defence=defence+4;
       }
      }else {
    	  if(SelectiveBar==0){
       	   if(Money<100)return;
       	Money=Money-100;
       	   HP=HP+3500;
          }
          else if(SelectiveBar==1){
       	   if(Money<100)return;
       	Money=Money-100;
       	   attack=attack+25;
          }
          else if(SelectiveBar==2){
       	   if(Money<100)return;
       	   Money=Money-100;
       	   defence=defence+25;
          }
       }
       HC.repaint();
       
   }
   

   //Store
   
   
   
   
   //Red sale
   public drawRedSale RedSale;
   private boolean red5or8=floor==4?true:false;
   
   class drawRedSale extends Thread{
		HControlPanel a;
		drawRedSale(HControlPanel a){
			this.a=a;
		}
			@SuppressWarnings("deprecation")
			public synchronized void run()
			  {    
				   a.redSale=true;
				   a.repaint();
				   System.out.println(11);
					    this.suspend();
					   //while(p){System.out.println(11);}		   

			      a.redSale=false;
			      a.repaint(); 
			     
			  }
			
		}
   public void drawRedSaleBar(Graphics g){
	   Graphics2D g2= (Graphics2D)g;
		g2.setColor(Color.orange);
		g2.setStroke(new BasicStroke(4f));
		g2.drawLine(236, 60, 525, 60);
		g2.drawLine(236,317, 525, 317);
		g2.drawLine(236, 60, 236, 317);
		g2.drawLine(525, 60, 525, 317);
		File imageFile=new File("pic/0.png");
		  BufferedImage bi=null;
		try {
			bi = ImageIO.read(imageFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  BufferedImage cbi = bi.getSubimage(0,0,32,32);
		  for(int i=236;i<512;i=i+32){
				for(int j=60;j<312;j=j+32 ){
					g.drawImage(cbi,i,j,(ImageObserver) this);
				}
			}
		  g.setFont(new Font(null,Font.BOLD ,15));
		  if(red5or8){
		  g.drawString("Stroe",360,80);
		  g.drawString("If you have money, I can give you key",300,110);
		  g.drawString("Yellow Key($10)",350,150);
		  g.drawString("Blue Key($50)",350,200);
		  g.drawString("Red Key($100)",350,250);
		  g.drawString("Exit",350,300);
		  }else {
			  g.drawString("Stroe",360,80);
			  g.drawString("You can use key to get money",300,110);
			  g.drawString("Yellow key($5)",350,150);
			  g.drawString("Blue key($25)",350,200);
			  g.drawString("Red key($50)",350,250);
			  g.drawString("Exit",350,300);
			  
		  }
		  g2.setColor(Color.magenta);
		  g2.drawLine(250, 130+SelectiveBar*50,498, 130+SelectiveBar*50);
		  g2.drawLine(250,160+SelectiveBar*50, 498, 160+SelectiveBar*50);
		  g2.drawLine(250, 130+SelectiveBar*50, 250, 160+SelectiveBar*50);
		  g2.drawLine(498, 130+SelectiveBar*50, 498, 160+SelectiveBar*50);
		  
		  
   }
   
   @SuppressWarnings("deprecation")
public void saleRed(){
      if(SelectiveBar==3)RedSale.resume();
      else if(red5or8){
        if(SelectiveBar==0){
    	   if(Money<10)return;
    	   Money=Money-10;
    	   yKey++;
       }
       else if(SelectiveBar==1){
    	   if(Money<50)return;
    	   Money=Money-50;
    	   bKey++;
       }
       else if(SelectiveBar==2){
    	   if(Money<100)return;
    	   Money=Money-100;
    	   rKey++;
       }
      }else {
    	  if(SelectiveBar==0){
       	   if(yKey<=0)return;
       	   yKey--; 
       	   Money=Money+5;
       	   
          }
          else if(SelectiveBar==1){
       	   if(bKey<=0)return;
       	   bKey--; 
       	   Money=Money+25;
          }
          else if(SelectiveBar==2){
       	   if(rKey<=0)return;
       	   rKey--;
       	   Money=Money+50;
          }
       }
       HC.repaint();
       
   }
   //Red sale
   
   private boolean isStaff(int s){
	   
	   switch(s){
	   
	   case 0:return WhatStaff(pY-1,pX);
	   case 1:return WhatStaff(pY,pX-1);
	   case 2:return WhatStaff(pY+1,pX);
	   case 3:return WhatStaff(pY,pX+1);
	   default:return true;
	   }
	   
   }
   
   private boolean WhatStaff(int x,int y){
	   int [][] a=m.AllMaps[floor].staffinf;
	   switch(a[x][y]){
	   case 1:ConContent=Staff.getContent(1);DS=new drawStaff(HC);DS.start();return true;
	   case 2:ConContent=Staff.getContent(1);DS=new drawStaff(HC);DS.start();return true;
	   case 3:Store=new drawStore(HC);Store.start(); return true;
	   case 4:ConContent=Staff.getContent(1);DS=new drawStaff(HC);DS.start();return true;
	   case 5:OE=new drawOldEXNPC(HC);OE.start(); return true;
	   case 6:RedSale=new drawRedSale(HC);RedSale.start(); return true;
	   case 7:Store=new drawStore(HC);Store.start(); return true;
	   case 8:RedSale=new drawRedSale(HC);RedSale.start(); return true;
	   case 9:OE=new drawOldEXNPC(HC);OE.start(); return true;
	   case 10:ConContent=Staff.getContent(1);DS=new drawStaff(HC);DS.start();return true;
	   case 11:ConContent=Staff.getContent(1);DS=new drawStaff(HC);DS.start();return true;
	   case 12:ConContent=Staff.getContent(1);DS=new drawStaff(HC);DS.start();return true;
	   default: return true;
	   }
   }
   /*Staff*/
   
   private boolean canMove(int s){
	   int[][] a=m.AllMaps[floor].mapsinf;
	   switch(s){
	   case 0:{if(a[pY-1][pX]==4){return isWall(s);}
	          else if(a[pY-1][pX]==2){return isDoor(s);}
	          else if(a[pY-1][pX]==5){return isMonster(s);}
	          else if(a[pY-1][pX]==3){return isSubstance(s);}
	          else if(a[pY-1][pX]==1){return isStaff(s);}
	          else return false;
	          }
	   case 1:{if(a[pY][pX-1]==4){return isWall(s);}
               else if(a[pY][pX-1]==2){return isDoor(s);}
               else if(a[pY][pX-1]==5){return isMonster(s);}
               else if(a[pY][pX-1]==3){return isSubstance(s);}
               else if(a[pY][pX-1]==1){return isStaff(s);}
	           else return false;
	          }
	   case 2:{if(a[pY+1][pX]==4){return isWall(s);}
               else if(a[pY+1][pX]==2){return isDoor(s);}
               else if(a[pY+1][pX]==5){return isMonster(s);}
               else if(a[pY+1][pX]==3){return isSubstance(s);}
               else if(a[pY+1][pX]==1){return isStaff(s);}
	           else return false;
		      }
	   case 3:{if(a[pY][pX+1]==4){return isWall(s);}
               else if(a[pY][pX+1]==2){return isDoor(s);}
               else if(a[pY][pX+1]==5){return isMonster(s);}
               else if(a[pY][pX+1]==3){return isSubstance(s);}
               else if(a[pY][pX+1]==1){return isStaff(s);}
	           else return false;
		   }
	   default:return true;
	   }   
	   
   }
   
   public void Move(int s){
	   switch(s){
       case 0:if(pY==0||canMove(s))return;/*up*/
	          else {pY=pY-1;return;}
	   case 1:if(pX==0||canMove(s))return; /*left*/
	          else {pX=pX-1;return;}
	   case 2:if(pY==10||canMove(s))return;/*down*/
              else {pY=pY+1;return;}
	   case 3:if(pX==10||canMove(s))return;/*right*/
              else {pX=pX+1;return;}
	   }
	   
   }
   
   
   
 /*print inf*/  
   public void paint(Graphics g) {
	   
	   g.setFont(new Font(null,Font.BOLD ,15));
	   g.setColor(Color.CYAN);
	   g.drawString(""+this.level, 100, 32);
	   g.drawString(""+this.HP, 80, 60); 
	   g.drawString(""+this.attack, 80, 90);  
	   g.drawString(""+this.defence, 80, 120);
	   g.drawString(""+this.Money,80,150);
	   g.drawString(""+this.EX, 80, 180);
	   g.drawString(""+this.yKey, 60, 220);
	   g.drawString(""+this.bKey, 60, 250);
	   g.drawString(""+this.rKey, 60,280);
	}
   
   private void printDetail(){
	 System.out.println("Level is "+this.level);
	 System.out.println("HP is "+this.HP);
	 System.out.println("Attack is "+this.attack);
	 System.out.println("Defence is "+this.defence);
	 System.out.println("EX is "+EX);
	 System.out.println("Money is "+Money);
	 System.out.println("Floor is "+(this.floor+1));
	 System.out.println("rKey is "+this.rKey);
	 System.out.println("yKey is "+this.yKey);

	 System.out.println("X is "+this.pX);
	 System.out.println("Y is "+this.pY);
     System.out.println("------------");
	
}
   class heroFightPanel extends Thread{
		HControlPanel a;
		heroFightPanel (HControlPanel a){
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
