/*************************************************************************
 *  Name: Murray Lynch
 *  Login: mdlynch
 *  Precept: P04
 * 
 *  Compilation:  javac-introcs Sierpinski.java 
 *  Execution:    java-introcs Sierpinski N
 *
 *  Description: Draws the Sierpinski triangle fractal pattern to the order
 *  of N, specified by the user in the command line argument.
 *  
 *  Dependencies: StdDraw.java
 *
 *************************************************************************/

public class Sierpinski 
{
    // class constant for the ratio used for computing the altitude of an
    // equilateral triangle
    private static double ALTITUDE = Math.sqrt(3)/2;
    
    // private method that returns the height of a triangle with side length s
    private static double calcHeight(double s)
    {
        return Math.sqrt(s*s - (s*s)/4);
    }
    
    // draw shaded equilateral triangle with bottom vertex (x, y), side length s
    public static void filledTriangle(double x, double y, double s)
    {
        // arrays used to draw shaded equilateral triangle
        double[] xPoly = new double[3];
        double[] yPoly = new double[3];
        
        // assignment of array values to appropriate coordinates for triangle
        xPoly[0] = x;
        yPoly[0] = y;
        xPoly[1] = x - s/2;
        yPoly[1] = y + calcHeight(s);
        xPoly[2] = x + s/2;
        yPoly[2] = y + calcHeight(s);
            
        // draw shaded triangle
        StdDraw.filledPolygon(xPoly, yPoly);
    }
    
    // draw one triangle, bottom vertex (x, y), side s; recursively call itself 
    // three times to generate the next order Sierpinski triangles above, left
    // and right of current triangle. n is the order
    public static void sierpinski(int n, double x, double y, double s)
    {
        // if order is 0, exit recursion
        if (n == 0) return;
        
        // draw triangle based on coordinates given to this method
        filledTriangle(x, y, s);
        
        // three recursive calls, one for each triangle to the top, left and 
        // right of the triangle draw above in this method
        sierpinski(n-1, x - s/2, y, s/2);
        sierpinski(n-1, x + s/2, y, s/2);
        sierpinski(n-1, x, y + calcHeight(s), s/2);
    }
    
    
    // read order of recursion N as a command-line argument; draw gray outline 
    // triangle with endpoints (0, 0), (1, 0), and (1/2, (3)^-1/2); generate an
    // order-N Sierpinski triangle inside the outline
    public static void main(String[] args) 
    {   
        // accept user data
        int N = Integer.parseInt(args[0]);
        
        // change pen color so that initial unshaded triangle is gray
        StdDraw.setPenColor(StdDraw.GRAY);
        
        // draw triangular frame
        StdDraw.line(0, 0, 1, 0);
        StdDraw.line(1, 0, 0.5, ALTITUDE);
        StdDraw.line(0.5, ALTITUDE, 0, 0);
        
        // set pen back to black, the default, so that shaded triangles are 
        // black
        StdDraw.setPenColor();
        
        // initial call of recursive function
        sierpinski(N, 0.5, 0, 0.5);
    }   
}