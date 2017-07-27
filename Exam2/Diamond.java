/*************************************************************************
 * Name: Murray Lynch
 * Login: mdlynch
 * Precept: P04
 * 
 * Description: Class that represents 2-dimensional diamond.
 * 
 * Dependencies: Color.java StdDraw.java
 * 
 *************************************************************************/

import java.awt.Color;

public class Diamond
{
    //constants
    private static final int CORNERS = 4; //number of corners of diamond

    //instance variables
    private double r;
    private double x;
    private double y;
    private Color c;
    
    //constructor method, does not draw diamond just initializes instance 
    //variables
    public Diamond(double r, double x, double y, Color c)
    {
        this.r = r;
        this.x = x;
        this.y = y;
        this.c = c;  
    }
    
    //sets the pen color & draws the diamond using StdDraw
    public void drawFilled()
    {
        StdDraw.setPenColor(c);
        
        //construct array of coordinates, starting at top moving clockwise      
        double[] allXs = {x, x+r, x, x-r};
        double[] allYs = {y+r, y, y-r, y};
        
        StdDraw.filledPolygon(allXs, allYs);
    }
    
    // calculate area of diamond
    public double area()
    {
        return 2*r*r;
    }
    
    public void changeColor(Color color)
    {
        c = color;
    }
    
    //moves center of diamond
    public void move(double deltaX, double deltaY)
    {
        x += deltaX;
        y += deltaY;
    }
    
    //testing main class for diamond object
    public static void main(String[] args) 
    {
        StdDraw.setXscale(-1, 1); // set scale
        StdDraw.setYscale(-1, 1); // in main()
        Color red = StdDraw.RED;
        Diamond d = new Diamond(.5, -.5, .5, red);
        d.drawFilled();
        System.out.println(d.area());
        d.changeColor(StdDraw.BLUE);
        d.move(1, -1);
        d.drawFilled();
        System.out.println(d.area());
    }
}
    
   