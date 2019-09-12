import java.awt.*;
import javax.swing.*;

public class rose {

  //declare a constant field for green sepal
  Color sepalColor= Color.magenta;

  //declare instance variables that are attributes of Rose
  //default color is red rose on white background
   Color backGroundColor = Color.white;   
   Color petalColor = Color.red;     

  
  public void sepalColourSelection()
  {
  	/*
  		for the sepals, the colours we have are pink=1, orange=2 magenta=3 magenta=4;
  		magenta has an edge
  	*/ 	
  	int ansa=(int)(1.0+Math.random()*(4.0-1.0));
  	switch(ansa)
  	{
	  	case 1:
		{
			//red
			sepalColor=Color.pink;
			break;
		}
		case 2:
		{
			//pink
			sepalColor=Color.orange;
			break;
		}
		case 3:
		{
			//red
			sepalColor=Color.magenta;
			break;
		}
		case 4:
		{
			//orange
			sepalColor=Color.magenta;
			break;
		}
	}
	
	
  }
  
  public void petalColourSelection()
  {
  	/*
  		for the petal colours we can have red=1, pink=2, violet=3, orange=4, blue=5
  	*/
  	//hence
  	int ansa=(int)(1.0+Math.random()*(5.0-1.0));
  	switch(ansa)
  	{
  		case 1:
  		{
  			//red
  			petalColor=Color.red;
  			break;
  		}
  		case 2:
  		{
  			//pink
  			petalColor=Color.pink;
  			break;
  		}
  		case 3:
  		{
  			//red
  			petalColor=Color.red;
  			break;
  		}
  		case 4:
  		{
  			//orange
  			petalColor=Color.orange;
  			break;
  		}
  		case 5:
  		{
  			//blue
  			petalColor=Color.blue;
  			break;
  		}
  		
  	}
  	
  }
  public void paintGreenSepal(Graphics2D obj,int x,int y ) {
    sepalColourSelection();
    obj.setColor(sepalColor);
    obj.fillOval(x+38,y+138,40,40);
    obj.fillOval(x+68,y+138,40,40);
    obj.fillOval(x+38,y+168,40,40);
    obj.fillOval(x+68,y+168,40,40);
  }

  public void paintPetal(Graphics2D obj,int x,int y ) {

    //draw petal
    petalColourSelection();
    obj.setColor(petalColor);
    obj.fillOval(x+28,y+148,90,50);
    obj.fillOval(x+48,y+128,50,90);  //it is very important

    //petal outline 
    obj.setColor(Color.black); //important to some extent to.
    obj.drawArc(x+50,y+180,25,30,345,150);
    obj.drawArc(x+75,y+180,25,30,160,-105);
    obj.drawArc(x+88,y+163,30,20,230,-105);
    obj.drawArc(x+70,y+150,30,20,290,-120);
    obj.drawArc(x+45,y+140,25,30,345,-120);
    obj.drawArc(x+30,y+168,30,20,50,-70);
  }

  public void paintPedicel( Graphics2D obj,int x,int y ) { //draws the stem of the rose flower

    //draw pedicel
    obj.setColor(Color.green);
    obj.fillRect(x+71,y+218,3,100);
  }

  public void paintLeave(Graphics  g,int x,int y) {
    int[] rightX = {x+73,x+94,x+131,x+104,x+73}, 
          rightY = {y+246,y+216,y+218,y+250,y+246};

    int[] leftX = {x+71,x+55,x+27,x+47,x+71}, 
          leftY= {y+268,y+241,y+245,y+269,y+268};

    //draw right leaf
    g.fillPolygon(rightX,rightY,5);

    //draw left leaf
    g.fillPolygon(leftX,leftY,5);
  } 

  public void paintRose( Graphics g,int x,int y ) {

	Graphics2D obj=(Graphics2D)g;	
   // paintBackGround(g,x,y);
    paintGreenSepal(obj,x,y);
    paintPetal(obj,x,y);
    paintPedicel(obj,x,y); 
   // paintLeave(g,x,y);
  }
}