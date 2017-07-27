/*************************************************************************
 * Name: Murray Lynch
 * Login: mdlynch
 * Precept: P04
 * 
 * Description: Class that represents a 2-dimensional N-sided polygon.
 * 
 * Dependencies: StdDraw.java Color.java Math.java
 * 
 *************************************************************************/

import java.awt.Color;

public class Ngon
{
    //instance variables
    private double r; //radius
    private double x; //x-coordinate of center
    private double y; //x-coordinate of center
    private Color c; //color of ngon
    private int n; //number of sides
    private double angle; //angle between two radii (interior angle)
    
    
    //constructor method, does not draw ngon just initializes instance 
    //variables
    public Ngon(int n, double r, double x, double y, Color c)
    {
        this.r = r;
        this.x = x;
        this.y = y;
        this.c = c;
        this.n = n;
        
        angle = 2*Math.PI/n;
    }
    
    //constructor method for testing
    public Ngon(int n, double r)
    {
        this.n = n;
        this.r = r;
        angle = 2*Math.PI/n;
        
        x = 0;
        y = 0;
        c = StdDraw.BLACK;
        
    }
    
    public void drawFilled()
    {
        StdDraw.setPenColor(c);
        
        //construct array of coordinates      
        double[] allXs = new double[n];
        double[] allYs = new double[n];
        
        //calculate coordinates for each point of ngon
        for (int i = 0; i < n; i++)
        {
            allXs[i] = x + r*Math.cos(i*angle);
            allYs[i] = y + r*Math.sin(i*angle);
        }
        
        StdDraw.filledPolygon(allXs, allYs);
    }
    
    public double area()
    {
        return 0.5*(r*r)*(n)*Math.sin(angle);
    }
    
    public Ngon merge(Ngon that)
    {
        if (n != that.n)
            return null;
        
        double radius = this.r + that.r;
        double averageX = (this.x + that.x)/2; //average center
        double averageY = (this.y + that.y)/2; //average center
        
        //average colors
        int red = (this.c.getRed() + that.c.getRed())/2;
        int green = (this.c.getGreen() + that.c.getGreen())/2;
        int blue = (this.c.getBlue() + that.c.getBlue())/2;
        
        Color color = new Color(red, green, blue);
        
        return new Ngon(n, radius, averageX, averageY, color);
    }
    
    //testing main method
    public static void main(String[] args) 
    {
        StdDraw.setXscale(-1, 1); // set scale
        StdDraw.setYscale(-1, 1); // in main()
        Color red = StdDraw.RED;
        Color blue = StdDraw.BLUE;
        Ngon h1 = new Ngon(6, .3, -.6, .6, red);
        Ngon h2 = new Ngon(6, .3, .6, -.6, blue);
        Ngon h3 = h1.merge(h2);
        h1.drawFilled();
        h2.drawFilled();
        h3.drawFilled();
        System.out.println(h3.area());
    }
}
    
   