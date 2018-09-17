package TOTS;

public class shakeMoster extends Thread {
	HControlPanel a;
	shakeMoster(HControlPanel a){
		this.a=a;
	}
	
	public void run()
	  {
	    for (;;)
	    {
		      try
		      {
		        Thread.sleep(100L);
		      }
		      catch (Exception localException) {}

	      if(a.hero.getBG().shakeM<96){a.hero.getBG().shakeM=a.hero.getBG().shakeM+32;}
	      else a.hero.getBG().shakeM=0;
	      a.repaint();
	    }
	  }
}
