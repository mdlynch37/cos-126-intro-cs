/*************************************************************************
 * Name: Murray Lynch
 * Login: mdlynch
 * Precept: P04
 * 
 * Description: Creates ngon art by reading in values for set of ngons
 *  and drawing them in descending order.
 * 
 * Dependencies: StdDraw.java Color.java StdIn.java Ngon.java
 * 
 *************************************************************************/

import java.awt.Color;

public class NgonArt2
{
    //main class that makes ngon art
    public static void main(String[] args) 
    {
        StdDraw.setXscale(-1, 1); // set scale
        StdDraw.setYscale(-1, 1); // in main()
        
        //read in number of ngons from top of textfile
        int N = StdIn.readInt();
        
        //create new array of ngons
        Ngon[] ngons = new Ngon[N];
        
        // reads in properties of ngons from textfile
        // fills array of ngons with arrays
        for (int i = 0; i < N; i++)
        {
            int n = StdIn.readInt();
            double r = StdIn.readDouble();
            double x = StdIn.readDouble();
            double y = StdIn.readDouble();
            int red = StdIn.readInt();
            int green = StdIn.readInt();
            int blue = StdIn.readInt();
            
            Color c = new Color(red, green, blue);
            
            ngons[i] = new Ngon(n, r, x, y, c);
            
        }
        
        // sorts ngons in descending order with insertion method
        for (int i = 1; i < N; i++)
        {
            for (int j = i; j > 0; j--)
            {
                if (ngons[j-1].area() < ngons[j].area())
                {
                    //switches ngons
                    Ngon swap = ngons[j-1];
                    ngons[j-1] = ngons[j];    
                    ngons[j] = swap;
                }
                else break; //breaks out of inner for loop
            }
        }
        
        // draws ngons in array
        for (int i = 0; i < N; i++)
        {
            ngons[i].drawFilled();
            StdDraw.show(10);
        }
    }
}