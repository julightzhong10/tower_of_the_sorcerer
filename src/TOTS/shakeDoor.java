package TOTS;

public class shakeDoor extends Thread {
	HControlPanel a;
	shakeDoor(HControlPanel a){
		this.a=a;
	}
	
	public synchronized void run()
	  {
	    for (int i=0;i<3;i++)
	    {
		      try
		      {
		        Thread.sleep(50L);
		      }
		      catch (Exception localException) {}
          a.hero.getBG().shakeD= a.hero.getBG().shakeD+32;
	      a.repaint();
	    
	    }
	  }
}
