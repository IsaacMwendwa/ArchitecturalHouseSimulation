import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class House extends JPanel implements ActionListener
{
	rose[] roseobj; //array of rose flowers
	int x1,y1,x2,y2,width,height;
	int roseflowerseparationdistance=110;
	int newx1,newy1,newwidth,newheight;
	int[] xtri,ytri; //arrays for x co-ordinate and y co-ordinates for the triangle
	int[] xpoly,ypoly; //arrays for x co-ordinate and y co-ordinates for the parallelogram
	int red=0,green=0,blue=0; //it gets the colours i.e. rgb colors at a particular time
	String frontface="(",frontroof="(",sideface="(",sideroof="(";
	
	public House()
	{
		JButton refreshbutton=new JButton("refresh");
		refreshbutton.addActionListener(this); //adding refresh button of House object
		add(refreshbutton,BorderLayout.NORTH);
		initRoseFlowers();
	}
	
	public void initRoseFlowers()
	{
		roseobj=new rose[12]; //12 roseflowers
		for (int i=0;i<12;i++)
		{roseobj[i]=new rose();}
	}
	
	public void getRGBColours()
	{
		//these function for each color of red, green and blue
		//we generate a random number between 0 and 255
		red=(int)(0.0+Math.random()*(255.0-0.0));
		green=(int)(0.0+Math.random()*(255.0-0.0));
		blue=(int)(0.0+Math.random()*(255.0-0.0));
	}
	
	public void drawHouse(Graphics2D obj)
	{	
		frontface=frontroof=sideface=sideroof="(";
		getRGBColours();
		obj.setColor(new Color(red,green,blue));
		frontface+=red+","+green+","+blue+")";
		
		x1=100;
		y1=200;
		xtri=new int[3];
		ytri=new int[3];
		xpoly=new int[4];
		ypoly=new int[4];
		width=(int)(50.0+Math.random()*(200.0-50.0));
		height=(int)(70.0+Math.random()*(300.0-70.0));
		obj.fillRect(x1,y1,width,height);
		x2=(x1+x1+width)/2;
		y2=(int)(width*Math.sin(60))+y1;
		
		//Hut part
		getRGBColours();
		obj.setColor(new Color(red,green,blue));
		frontroof+=red+","+green+","+blue+")";
		//we draw the triangle using a polygon
		xtri[0]=x1;xtri[1]=x1+width; xtri[2]=x2;
		ytri[0]=y1;ytri[1]=y1; ytri[2]=y2;
		//the array matches (xtri[i],ytri[i]) --> for i=0,1,2 which are the points for each triangle
		Polygon triangle=new Polygon(xtri,ytri,3);
		obj.fillPolygon(triangle);
		
		
		//now for the other part
		getRGBColours();
		obj.setColor(new Color(red,green,blue));
		newx1=(x1+width);
		newy1=y1;
		newwidth=(int)(100.0+Math.random()*(300.0-100.0));
		newheight=height;
		sideface+=red+","+green+","+blue+")";
		
		obj.fillRect(newx1,newy1,newwidth,newheight);
		xpoly[0]=x2; xpoly[1]=newx1; xpoly[2]=newx1+newwidth; xpoly[3]=x2+newwidth;
		ypoly[0]=y2; ypoly[1]=newy1; ypoly[2]=newy1; ypoly[3]=y2;
		
		getRGBColours();
		obj.setColor(new Color(red,green,blue));
		sideroof+=red+","+green+","+blue+")";
			
		Polygon parallelogram=new Polygon(xpoly,ypoly,4);
		obj.fillPolygon(parallelogram);	
		
		//shows the details of the house
		displayHouseDetails(obj);
	}	
	
	public void displayHouseDetails(Graphics2D obj)
	{	
	
		
		obj.setColor(new Color(68,144,125));
		//dimensions of the house in 3d as length*width*height;
		obj.drawString("DIMENSIONS USED FOR THE HOUSE",1000,150);
		obj.drawString("length of house: "+width,1000,175); 
		obj.drawString("Width of house: "+newwidth,1000,200);		
		obj.drawString("Height of house: "+height,1000,225);		
		
		//colours used for the house
	
		obj.drawString("COLOURS USED IN THE HOUSE",950,275);
		obj.drawString("Front Face of the House: "+frontface,950,300);	
		obj.drawString("Front Roof of the House: "+frontroof,950,325);
		obj.drawString("Side Face of the House: "+sideface,950,350);	
		obj.drawString("Side roof of the House: "+sideroof,950,375);	
		
	}
	
	public void doDrawing(Graphics g)
	{
		Graphics2D obj=(Graphics2D)g;
		drawHouse(obj);
	}
	
	public void drawRoseFlowers(Graphics g)
	{
		int rosex=10,rosey=400; //represents the roses x co-ordinate and their y co-ordinate	
		//the y co-ordinate is a constant
		
		for (int i=0;i<12;i++)
		{
			//we have 5 roseflowers objects
			roseobj[i].paintRose(g,rosex,rosey);
			rosex+=roseflowerseparationdistance;
		}		
	}
	
	@Override
	public void paintComponent(Graphics g)
	{	
		super.paintComponent(g);
		doDrawing(g);
		drawRoseFlowers(g);
	}
	@Override
	public void actionPerformed(ActionEvent evt)
	{repaint();}
}


public class MainProgram extends JFrame
{
	public MainProgram()
	{
		setSize(1366,768);
		setTitle("Simple House");
		add(new House());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);		
	} 
	public static void main(String [] args)
	{	
		new MainProgram();			
	}
}