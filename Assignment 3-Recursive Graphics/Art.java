/*************************************************************************
 *  Name: Murray Lynch
 *  Login: mdlynch
 *  Precept: P04
 * 
 *  Compilation:  javac-introcs Art.java 
 *  Execution:    java-introcs Art N
 *
 *  Description: Draws art of negative thought pattern that disperses and 
 *  intensifies (as a metaphor for depression) in a pattern to the order
 *  of N, specified by the user in the command line argument.
 *  
 *  Dependencies: StdDraw.java
 *
 *************************************************************************/

public class Art 
{
    // constant initialized to display word (don't worry, it is supposed to be
    // negative as part of the art piece
    private static String WORD = "failure";
    
    // method not specified in assignment that transforms x or y coordinates of
    // points on a square so that they close in on the center of the drawing
    // from the target coordinate
    private static double[] transform(int targetIndex, int n, double[] a)
    {        
        double target = a[targetIndex];
        
        for (int i = 0; i < 4; i++) 
        {
            a[i] = (target+a[i])/(2*n);
        }
        return a;
    }
    
    // overloaded method called for first iteration of pattern
    // does not contain transform method
    public static void drawFourFromCorner(int n)
    {
        // exits if user enters 0 in command line
        if (n == 0) return;
        
        // initializes at starting coordinates for pattern
        double[] x = {-0.9, 0.9, 0.9, -0.9};
        double[] y = {0.9, 0.9, -0.9, -0.9};

            
        // draws each word at the appriopriate coordinate
        for (int i = 0; i < 4; i++) 
        {
            StdDraw.text(x[i], y[i], WORD);
        }
        
        // recursive call for each corner of the drawing
        for (int i = 0; i < 4; i++) 
        {
            drawFourFromCorner(n-1, i);
        }

    }
    // draw one triangle, bottom vertex (x, y), side s; recursively call itself 
    // three times to generate the next order Sierpinski triangles above, left
    // and right of current triangle. n is the order
    public static void drawFourFromCorner(int n, int corner)
    {
        // terminates method when specified depth of recursion has been reached
        if (n == 0) return;
        
        // initializes at starting coordinates for pattern
        double[] x = {-0.9, 0.9, 0.9, -0.9};
        double[] y = {0.9, 0.9, -0.9, -0.9};
        
        // transforms coordinates to form pattern
        x = transform(corner, n, x);
        y = transform(corner, n, y);
            
        // draws each word at the appriopriate coordinate
        for (int i = 0; i < 4; i++) 
        {
            StdDraw.text(x[i], y[i], WORD);
        }
        
        // recursive call for each corner of the drawing
        for (int i = 0; i < 4; i++) 
        {
            drawFourFromCorner(n-1, i);
        }
            
    }
    
    
    // read order of recursion N as a command-line argument; draw gray outline 
    // triangle with endpoints (0, 0), (1, 0), and (1/2, (3)^-1/2); generate an
    // order-N Sierpinski triangle inside the outline
    public static void main(String[] args) 
    {   
        // accept user data
        int N = Integer.parseInt(args[0]);
        
        
        // set pen back to black so that shaded triangles are black
        StdDraw.setPenColor(StdDraw.GRAY);
        
        // set scale
        StdDraw.setXscale(-1, 1);
        StdDraw.setYscale(-1, 1);
        
        // first recursive method call
        drawFourFromCorner(N);
        
    }   
}