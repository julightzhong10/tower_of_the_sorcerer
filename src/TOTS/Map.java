package TOTS;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Map extends JPanel {
	
    public int[][] mapsinf;
	
	public  int[][] monsterinf;//5
	public  int[][] staffinf;//1
	public  int[][] doorinf;//2
	public  int[][] substanceinf;//3  
    public  int[][] wallinf;// 4
	
    Map(){
    	this.setOpaque(false);
		this.setSize(352,352);
	}
	Map(int[][] mapsinf,int[][] monsterinf,int[][] staffinf,
			int[][] doorinf,int[][] substanceinf,int[][] wallinf){
		this.mapsinf=mapsinf;
		setMonster(monsterinf);
		setStaff(staffinf);
		setDoor(doorinf);
		setSubstance(substanceinf);
		setWall(wallinf);
		this.setOpaque(false);
		this.setSize(352,352);
	}
	public void setMonster(Monster a){
		int x=a.getX();
		int y=a.getY();
		mapsinf[x][y]=5;
		monsterinf[x][y]=a.getMT();
	}
	public void setStaff(Staff a){
		if(a instanceof Monster)return;
		int x=a.getX();
		int y=a.getY();
		mapsinf[x][y]=1;
		staffinf[x][y]=a.getStaffType();
	}
	public void setDoor(Door a){
		int x=a.getX();
		int y=a.getY();
		mapsinf[x][y]=2;
		doorinf[x][y]=a.getDoorType();
	}
	public void setSubstance(Substance a){
		int x=a.getX();
		int y=a.getY();
		mapsinf[x][y]=3;
		substanceinf[x][y]=a.getSubType();
	}
	public void setWall(Wall a){
		int x=a.getX();
		int y=a.getY();
		mapsinf[x][y]=4;
		wallinf[x][y]=a.getWallType();
	}
	
	
	//set int[][]
	public void setWall(int[][] a){
        for(int i=0;i<11;i++)
        	for(int j=0;j<11;j++)
        		if(a[i][j]!=0)mapsinf[i][j]=4;
		wallinf=a;
	}
	public void setDoor(int[][] a){
        for(int i=0;i<11;i++)
        	for(int j=0;j<11;j++)
        		if(a[i][j]!=0)mapsinf[i][j]=2;
		doorinf=a;
	}
	public void setMonster(int[][] a){
        for(int i=0;i<11;i++)
        	for(int j=0;j<11;j++)
        		if(a[i][j]!=0)mapsinf[i][j]=5;
		monsterinf=a;
	}
	public void setSubstance(int[][] a){
        for(int i=0;i<11;i++)
        	for(int j=0;j<11;j++)
        		if(a[i][j]!=0)mapsinf[i][j]=3;
        substanceinf=a;
	}
	public void setStaff(int[][] a){
        for(int i=0;i<11;i++)
        	for(int j=0;j<11;j++)
        		if(a[i][j]!=0)mapsinf[i][j]=1;
		staffinf=a;
	}
	
	/*draw*/
	
	public void paint(Graphics g) {
		paintWall(g);
		paintDoor(g);
		paintMoster(g);
		paintSubstance(g);
		paintStaff(g);
		
	}
	
	public void paintWall(Graphics g) {
		for(int i=0;i<11;i++){
			for(int j=0;j<11;j++){
				 switch(wallinf[i][j]){
				 case 1:g.drawImage(new ImageIcon("pic/-1.png").getImage(),j*32+192,
							i*32,this);break;
				 case 2:g.drawImage(new ImageIcon("pic/-16.png").getImage(),j*32+192,
							i*32,this);break;
				 case 3:g.drawImage(new ImageIcon("pic/-18.png").getImage(),j*32+192,
							i*32,this);break;
				 case 4:g.drawImage(new ImageIcon("pic/-10.png").getImage(),j*32+192,
							i*32,this);break;
				 case 5:g.drawImage(new ImageIcon("pic/-11.png").getImage(),j*32+192,
							i*32,this);break;
				 case -1:{
					 File imageFile=new File("pic/s.png");
		            BufferedImage bi=null;
			        try {
			          bi = ImageIO.read(imageFile);
			        } catch (IOException e) {}
			        BufferedImage pic1 = bi.getSubimage(0,0,32,32);
			        g.drawImage(pic1,j*32+192,i*32,this);
			        break;
			        }
				 case -2:{
					 File imageFile=new File("pic/s.png");
		            BufferedImage bi=null;
			        try {
			          bi = ImageIO.read(imageFile);
			        } catch (IOException e) {}
			        BufferedImage pic1 = bi.getSubimage(64,0,32,32);
			        g.drawImage(pic1,j*32+192,i*32,this);
			        break;
			        }
				 
							
				 }
	        }
		}
		
	}
	
	int shakeD=0;
	
	public void paintDoor(Graphics g) {
		String address = null;int x = 0,y = 0;
		for(int i=0;i<11;i++){
			for(int j=0;j<11;j++){
				 switch(doorinf[i][j]){
				 case 1:g.drawImage(new ImageIcon("pic/-14.png").getImage(),j*32+192,
							i*32,this);break;
				 case 2:g.drawImage(new ImageIcon("pic/-13.png").getImage(),j*32+192,
							i*32,this);break;
				 case 3:g.drawImage(new ImageIcon("pic/-12.png").getImage(),j*32+192,
							i*32,this);break;
				 case 4:g.drawImage(new ImageIcon("pic/-19.png").getImage(),j*32+192,
							i*32,this);break;
				 case 5:{	File imageFile=new File("pic/floor.png");
				            BufferedImage bi=null;
					    try {
					    bi = ImageIO.read(imageFile);
					    } catch (IOException e) {
						// TODO Auto-generated catch block
						
					   }BufferedImage pic1 = bi.getSubimage(96,0,32,32);
					    g.drawImage(pic1,j*32+192,i*32,this);
					    break;
				 }
				 
				 
				 case 6:{
			     File imageFile=new File("pic/door.png");
                 BufferedImage bi=null;
	             try {
	              bi = ImageIO.read(imageFile);
	            } catch (IOException e) {

		
	           }BufferedImage pic1 = bi.getSubimage(64,0+shakeD,32,32);
	           if(shakeD>=96){doorinf[i][j]=0;shakeD=0;}
	            g.drawImage(pic1,j*32+192,i*32,this);break;}
		 
		        case 7:{
			       File imageFile=new File("pic/door.png");
                   BufferedImage bi=null;
                  try {
                  bi = ImageIO.read(imageFile);
                  } catch (IOException e) {


                  }BufferedImage pic1 = bi.getSubimage(32,0+shakeD,32,32);
                  if(shakeD>=96){doorinf[i][j]=0;shakeD=0;}
                 g.drawImage(pic1,j*32+192,i*32,this);break;}
		 
		        case 8:
			    File imageFile=new File("pic/door.png");
                 BufferedImage bi=null;
                 try {
                    bi = ImageIO.read(imageFile);
                 } catch (IOException e) {

                 }BufferedImage pic1 = bi.getSubimage(0,0+shakeD,32,32);
                 if(shakeD>=96){doorinf[i][j]=0;shakeD=0;}
                 g.drawImage(pic1,j*32+192,i*32,this);break;
			}
				 
				 
	        }
		}
		
		
	}
	
	int shakeM=0;
	public void paintMoster(Graphics g) {
		String address = null;int x = 0,y = 0;
		for(int i=0;i<11;i++){
			for(int j=0;j<11;j++){
				 switch(monsterinf[i][j]){
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
			    BufferedImage pic1 = bi.getSubimage(x+shakeM,y,32,32);
			    g.drawImage(pic1,j*32+192,i*32,this);
				 }
			}
	        }
		}
	
	public void paintStaff(Graphics g) {
		String address = null;int x = 0,y = 0;
		for(int i=0;i<11;i++){
			for(int j=0;j<11;j++){
				 switch(staffinf[i][j]){
				   case 0: address=null;break;
				   case 1:address="pic/NPC1.png"; x=0;y=0;break;
				   case 2:address="pic/NPC1.png"; x=0;y=32;break;
				   case 3:address="pic/NPC2.png"; x=0;y=64;break;
				   case 4:address="pic/NPC1.png"; x=0;y=64;break;
				   case 5:address="pic/NPC1.png"; x=0;y=0;break;
				   case 6:address="pic/NPC1.png"; x=0;y=32;break;
				   case 7:address="pic/NPC2.png"; x=0;y=64;break;
				   case 8:address="pic/NPC1.png"; x=0;y=32;break;
				   case 9:address="pic/NPC1.png"; x=0;y=0;break;
				   case 10:address="pic/NPC1.png"; x=0;y=0;break; 
				   case 11:address="pic/NPC1.png"; x=0;y=32;break;
				   case 12:address="pic/NPC2.png"; x=0;y=96;break;
				   default:address=null;break;
				 }
				 if(address!=null){
				 File imageFile=new File(address);
			        BufferedImage bi=null;
			    try {
			    bi = ImageIO.read(imageFile);
			    } catch (IOException e) { }
			    BufferedImage pic1 = bi.getSubimage(x+shakeM,y,32,32);
			    g.drawImage(pic1,j*32+192,i*32,this);
				 }
			}
	        }
		}
	public void paintSubstance(Graphics g) {
		for(int i=0;i<11;i++){
			for(int j=0;j<11;j++){
				 switch(substanceinf[i][j]){
				 case 1:g.drawImage(new ImageIcon("pic/-4.png").getImage(),j*32+192,
							i*32,this);break;
				 case 2:g.drawImage(new ImageIcon("pic/-2.png").getImage(),j*32+192,
							i*32,this);break;
				 case 3:g.drawImage(new ImageIcon("pic/-3.png").getImage(),j*32+192,
							i*32,this);break;
				 case 4:g.drawImage(new ImageIcon("pic/-7.png").getImage(),j*32+192,
							i*32,this);break;
				 case 5:g.drawImage(new ImageIcon("pic/-8.png").getImage(),j*32+192,
							i*32,this);break;
				 case 6:g.drawImage(new ImageIcon("pic/-5.png").getImage(),j*32+192,
							i*32,this);break;
				 case 7:g.drawImage(new ImageIcon("pic/-6.png").getImage(),j*32+192,
							i*32,this);break;
				 case 8:g.drawImage(new ImageIcon("pic/-20.png").getImage(),j*32+192,
							i*32,this);break;
				 case 9:g.drawImage(new ImageIcon("pic/-25.png").getImage(),j*32+192,
							i*32,this);break;
				 case 10:g.drawImage(new ImageIcon("pic/-21.png").getImage(),j*32+192,
							i*32,this);break;
				 case 11:g.drawImage(new ImageIcon("pic/-26.png").getImage(),j*32+192,
							i*32,this);break;
				 case 12:g.drawImage(new ImageIcon("pic/-22.png").getImage(),j*32+192,
							i*32,this);break;
				 case 13:g.drawImage(new ImageIcon("pic/-27.png").getImage(),j*32+192,
							i*32,this);break;
				 case 14:g.drawImage(new ImageIcon("pic/-23.png").getImage(),j*32+192,
							i*32,this);break;
				 case 15:g.drawImage(new ImageIcon("pic/-28.png").getImage(),j*32+192,
							i*32,this);break;
				 case 16:g.drawImage(new ImageIcon("pic/-24.png").getImage(),j*32+192,
							i*32,this);break;
				 case 17:g.drawImage(new ImageIcon("pic/-29.png").getImage(),j*32+192,
							i*32,this);break;
				 
                 default:break;
							
				/*
				 case 5:{	File imageFile=new File("E:/a/floor.png");
				            BufferedImage bi=null;
					    try {
					    bi = ImageIO.read(imageFile);
					    } catch (IOException e) {
						// TODO Auto-generated catch block
						
					   }BufferedImage pic1 = bi.getSubimage(96,0,32,32);
					    g.drawImage(pic1,j*32,i*32,this);
					    break;
				 }*/
			}
	        }
		}
		}
}

