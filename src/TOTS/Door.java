package TOTS;

public class Door {
	private int x;
    private int y;
    private int doorType;//red 1, blue2, yellow 3, s 4,jail 5,ro 6,bo7,yo8, so9, jo10
    
    public void setX(int x){
    	this.x=x;
    }
    public void setY(int y){
    	this.y=y;
    }
    public void setDoorType(int door){
    	this.doorType=door;
    }
    

    public int getX(){
    	return x;
    }
    public int getY(){
    	return y;
    }
    public int getDoorType(){
    	return doorType;
    }
    public static int[][] getDoormap(int floor){
    	switch(floor){
    	   case 1:{
    		        return new int[][]{
    			    {0,0,0,0,0,0,0,0,0,0,0},//1
    	            {0,0,0,0,0,0,0,0,0,0,0},//2
    	            {0,0,0,3,0,0,0,0,0,0,0},//3
    	            {0,0,0,0,0,0,0,0,0,0,0},//4
    	            {0,3,0,0,0,0,0,0,0,0,0},//5
    	            {0,0,0,0,0,3,0,0,0,0,0},//6
    	            {0,0,0,0,0,0,0,0,0,0,0},//7
    	            {0,3,0,0,0,0,0,0,0,0,0},//8
    	            {0,0,0,0,1,0,0,0,0,3,0},
    	            {0,0,0,0,0,0,0,0,0,0,0},
    	            {0,0,0,0,0,0,0,0,0,0,0}};
    	   }
    	   case 2:{return new int[][]{
		    {0,0,0,0,0,0,0,0,0,0,0},//1
            {0,0,0,0,0,0,0,0,0,0,0},//2
            {0,0,0,0,0,0,0,0,0,0,0},//3
            {0,0,0,0,0,0,0,0,0,3,0},//4
            {0,0,0,0,0,0,0,3,0,0,0},//5
            {0,0,3,0,0,3,0,0,3,0,0},//6
            {0,4,0,0,0,0,0,0,0,0,0},//7
            {0,0,3,0,0,2,0,5,0,5,0},//8
            {0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0}};
           
           }
    	   case 3:{
    		   return new int[][]{
    		       {0,0,0,0,0,0,0,0,0,0,0},//1
                   {0,0,0,0,0,0,0,0,0,0,0},//2
                   {0,0,0,0,0,3,0,0,0,0,0},//3
                   {0,3,0,0,0,0,0,0,0,0,0},//4
                   {0,0,0,0,0,0,0,0,0,0,0},//5
                   {0,0,0,0,0,0,0,0,0,0,0},//6
                   {0,0,0,0,0,0,0,0,0,0,0},//7
                   {0,0,0,0,0,0,0,3,0,0,0},//8
                   {0,0,0,0,0,0,0,0,0,0,0},//9
                   {0,0,0,0,0,0,0,0,0,0,0},//10
                   {0,0,0,0,0,0,0,0,0,0,0}};//11
    	   }
    	   case 4:{
    		   return new int[][]{
    		       {0,0,0,0,0,0,0,0,0,0,0},//1
                   {3,0,3,0,0,0,0,0,3,0,3},//2
                   {0,0,0,0,0,5,0,0,0,0,0},//3
                   {0,0,0,0,0,0,0,0,0,0,0},//4
                   {0,0,0,0,0,0,0,0,0,0,0},//5
                   {0,0,0,0,0,1,0,0,0,0,0},//6
                   {0,0,0,0,0,0,0,0,0,0,0},//7
                   {0,0,0,0,0,0,0,0,0,0,0},//8
                   {0,0,0,0,0,2,0,0,0,0,0},//9
                   {0,0,0,0,0,0,0,0,0,0,0},//10
                   {0,0,0,0,0,0,0,0,0,0,0}};
    	   }
    	   case 5:{
    		   return new int[][]{
    		       {0,0,0,0,0,0,0,0,0,0,0},//1
                   {0,0,0,0,0,0,0,0,0,0,0},//2
                   {0,0,0,0,0,0,0,0,3,0,0},//3
                   {0,3,0,0,0,0,0,0,0,0,0},//4
                   {0,0,0,0,0,0,0,0,0,0,0},//5
                   {0,0,0,0,0,0,0,0,0,0,0},//6
                   {0,0,0,0,0,0,0,0,0,0,0},//7
                   {0,0,0,0,0,0,0,0,0,0,0},//8
                   {0,0,0,0,0,3,0,2,0,3,0},//9
                   {0,0,0,0,0,0,0,0,3,0,0},//10
                   {0,0,0,0,0,0,0,0,0,0,0}};//11
    	   }
    	   case 6:{
    		   return new int[][]{
    		       {0,0,0,0,0,0,0,0,0,0,0},//1
                   {0,0,0,0,0,0,0,0,0,0,0},//2
                   {0,0,2,0,2,0,0,0,0,0,0},//3
                   {0,0,0,0,0,0,0,0,0,0,0},//4
                   {0,0,0,1,0,0,0,0,0,3,0},//5
                   {0,0,0,0,0,0,0,0,0,0,0},//6
                   {0,0,0,0,0,0,0,0,0,0,0},//7
                   {0,0,0,3,0,0,0,0,0,0,0},//8
                   {0,0,3,0,3,0,0,0,0,2,0},//9
                   {0,0,0,0,0,0,0,0,0,0,0},//10
                   {0,0,0,0,0,0,3,3,0,0,0}};//11
    	   }
    	   case 7:{
    		   return new int[][]{
    		       {0,0,0,0,0,0,0,0,0,0,0},//1
                   {0,0,0,0,0,2,0,0,0,0,0},//2
                   {0,0,0,0,0,0,0,0,0,0,0},//3
                   {0,0,0,0,0,5,0,0,0,0,0},//4
                   {0,0,2,0,5,0,5,0,2,0,0},//5
                   {0,0,0,0,0,5,0,0,0,0,0},//6
                   {0,0,0,0,0,0,0,0,0,0,0},//7
                   {0,0,0,0,0,2,0,0,0,0,0},//8
                   {0,0,0,0,0,0,0,0,0,0,0},//9
                   {0,0,0,0,0,1,0,0,0,0,0},//10
                   {0,0,0,3,0,0,0,3,0,0,0}};//11
    	   }
    	   case 8:{
    		   return new int[][]{
    		       {0,0,0,0,0,0,0,0,0,0,0},//1
                   {0,0,0,0,0,3,0,3,0,0,0},//2
                   {0,0,0,0,0,0,2,0,0,0,0},//3
                   {0,0,0,0,0,0,0,0,0,0,0},//4
                   {0,0,0,0,0,0,0,0,0,0,0},//5
                   {0,0,0,0,0,0,0,0,0,0,0},//6
                   {0,0,0,0,0,0,0,0,0,0,0},//7
                   {0,0,0,0,0,0,0,0,3,0,0},//8
                   {0,0,0,0,0,0,0,0,0,0,0},//9
                   {0,0,0,0,3,0,0,0,0,0,0},//10
                   {0,0,0,0,0,0,0,0,0,0,0}};//11
    	   }
    	   case 9:{return new int[][]{
		       {0,0,0,0,0,0,0,0,0,0,0},//1
               {0,0,0,3,0,0,0,0,0,3,0},//2
               {0,3,0,0,0,0,0,0,0,0,0},//3
               {0,0,0,0,0,0,0,0,0,0,0},//4
               {0,0,0,1,0,0,0,0,0,0,0},//5
               {0,2,0,0,0,0,0,0,0,0,0},//6
               {0,0,0,0,0,0,0,0,0,0,0},//7
               {0,3,0,0,0,0,0,3,0,0,0},//8
               {0,0,0,0,0,2,0,0,0,0,0},//9
               {0,0,0,0,0,0,0,0,0,3,0},//10
               {0,0,0,3,0,0,0,0,0,0,0}};//11
    		   
    	   }
    	   case 10:{
    		   return new int[][]{
    		       {0,0,0,0,0,0,0,0,0,0,0},//1
                   {0,0,0,0,3,0,3,0,0,0,0},//2
                   {0,0,0,0,0,0,0,0,0,0,0},//3
                   {0,0,0,0,0,0,0,0,0,0,0},//4
                   {0,0,0,0,0,0,0,0,0,0,0},//5
                   {0,0,0,0,0,0,0,3,0,0,0},//6
                   {0,0,0,0,0,0,0,0,3,0,0},//7
                   {0,0,0,0,0,0,0,3,0,0,0},//8
                   {0,0,0,0,0,0,0,0,0,0,0},//9
                   {0,0,0,0,0,1,0,0,0,0,0},//10
                   {0,0,0,0,0,0,0,0,0,0,0}};//11
    	   }
    	   case 11:{
    		   return new int[][]{
    		       {0,0,0,0,0,0,0,0,0,0,0},//1
                   {0,0,0,0,0,0,0,0,0,0,0},//2
                   {0,0,0,0,0,0,0,0,0,0,0},//3
                   {3,0,3,0,3,0,3,0,0,2,0},//4
                   {0,0,0,0,0,0,0,0,0,0,0},//5
                   {3,0,0,2,0,0,0,2,0,0,3},//6
                   {0,0,0,0,0,0,0,0,0,0,0},//7
                   {0,0,0,0,0,0,0,0,0,0,0},//8
                   {0,0,0,0,0,0,0,0,0,0,0},//9
                   {0,0,1,0,0,0,0,0,1,0,0},//10
                   {0,0,0,0,0,0,0,0,0,0,0}};//11
    	   }
    	   case 12:{
    		   return new int[][]{
    		       {0,0,0,0,0,0,0,0,0,0,0},//1
                   {0,0,0,0,0,3,0,0,0,0,0},//2
                   {0,0,0,0,0,0,0,0,0,0,0},//3
                   {0,0,0,0,0,0,0,0,0,0,0},//4
                   {0,0,0,0,0,0,0,0,0,0,0},//5
                   {0,2,0,0,0,0,0,0,0,2,0},//6
                   {0,0,0,0,0,0,0,0,0,0,0},//7
                   {0,0,0,0,0,0,0,0,0,0,0},//8
                   {0,0,3,0,0,0,0,0,3,0,0},//9
                   {0,0,0,0,0,2,0,0,0,0,0},//10
                   {0,0,0,0,0,0,0,0,0,0,0}};//11
    	   }
    	   case 13:{
    		   return new int[][]{
    		       {0,0,0,0,0,0,0,0,0,0,0},//1
                   {0,0,0,0,0,0,3,0,0,0,0},//2
                   {0,0,0,0,0,0,0,0,0,0,0},//3
                   {0,0,1,0,0,0,0,0,0,0,0},//4
                   {0,0,0,0,0,0,0,0,0,0,0},//5
                   {0,0,0,0,0,0,0,0,0,0,0},//6
                   {0,0,0,5,0,0,0,0,0,0,0},//7
                   {0,0,0,0,0,0,0,0,0,0,0},//8
                   {0,0,0,0,0,0,0,0,0,0,0},//9
                   {0,0,0,0,0,0,0,0,0,0,0},//10
                   {0,0,0,0,0,0,0,0,0,3,0}};//11
    	   }
    	   case 14:{
    		   return new int[][]{
    		       {0,0,0,0,0,0,0,0,0,0,0},//1
                   {0,0,0,0,0,0,0,0,0,0,0},//2
                   {0,0,0,0,0,0,0,0,0,0,0},//3
                   {0,0,0,0,0,0,0,0,0,0,0},//4
                   {0,0,0,0,0,5,0,0,0,0,0},//5
                   {0,0,0,0,0,0,0,0,0,0,0},//6
                   {0,0,0,0,0,0,0,0,0,0,0},//7
                   {0,0,0,0,0,0,0,0,0,0,0},//8
                   {0,0,0,0,0,2,0,0,0,0,0},//9
                   {0,0,0,0,2,0,2,0,0,0,0},//10
                   {0,0,0,0,0,0,0,0,0,0,0}};//11
    	   }
    	   case 15:{
    		   return new int[][]{
    		       {0,0,0,0,0,0,0,0,0,0,0},//1
                   {0,0,0,0,0,0,0,0,0,0,0},//2
                   {0,0,0,0,0,0,0,0,0,0,0},//3
                   {0,0,0,0,0,0,0,0,0,0,0},//4
                   {0,0,0,0,0,0,0,0,0,0,0},//5
                   {0,0,0,0,0,0,0,0,0,0,0},//6
                   {0,0,0,0,0,0,0,0,0,0,0},//7
                   {0,0,0,0,0,0,0,0,0,0,0},//8
                   {0,0,0,0,3,0,3,0,0,0,0},//9
                   {0,0,0,0,0,0,0,0,0,0,0},//10
                   {0,0,0,0,0,1,0,0,0,0,0}};//11
    	   }
    	   case 16:{
    		   return new int[][]{
    		       {0,0,0,0,0,0,0,0,0,0,0},//1
                   {0,0,0,0,0,0,0,0,0,0,0},//2
                   {0,0,0,0,0,0,0,0,0,0,0},//3
                   {0,0,0,0,0,1,0,0,0,0,0},//4
                   {0,0,0,0,0,0,0,0,0,0,0},//5
                   {0,0,0,0,0,0,0,0,0,0,0},//6
                   {0,0,0,0,0,0,0,0,0,0,0},//7
                   {0,0,0,0,0,0,0,0,0,0,0},//8
                   {0,0,0,0,0,0,0,0,0,0,0},//9
                   {0,0,0,0,0,0,0,0,0,0,0},//10
                   {0,0,0,0,0,0,0,0,0,0,0}};//11
    	   }
    	   case 17:{
    		   return new int[][]{
    		       {0,0,0,0,0,0,0,0,0,0,0},//1
                   {0,0,0,0,0,0,0,0,0,0,0},//2
                   {0,0,0,0,0,0,0,0,0,0,0},//3
                   {0,0,0,0,0,0,0,0,0,0,0},//4
                   {0,0,0,0,0,0,0,0,0,0,0},//5
                   {0,0,0,0,0,0,0,0,0,0,0},//6
                   {0,0,0,0,0,0,0,0,0,0,0},//7
                   {0,0,0,0,0,0,0,0,0,0,0},//8
                   {0,0,0,0,0,0,0,0,0,0,0},//9
                   {0,0,0,0,0,0,0,0,0,0,0},//10
                   {0,0,0,0,0,0,0,0,0,0,0}};//11
    	   }
    	   default:return null;
       }}
    
}
