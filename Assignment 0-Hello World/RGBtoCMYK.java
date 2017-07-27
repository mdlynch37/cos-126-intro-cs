/*************************************************************************
 *  Name: Murray Lynch
 *  Login: mdlynch
 *  Precept: P04
 * 
 *  Compilation:  javac RGBtoCMYK.java
 *  Execution:    java RGBtoCMYK red green blue
 *
 *  Description: Converts RGB format of color to CMYK format from user input
 *
 *  Dependencies: None.
 * 
 *  % java RGBtoCMYK 75 0 130       // indigo
 *  red     = 75
 *  green   = 0 
 *  blue    = 130
 *  cyan    = 0.423076923076923
 *  magenta = 1.0
 *  yellow  = 0.0
 *  black   = 0.4901960784313726
 *
 *
 *************************************************************************/

public class RGBtoCMYK {

    public static void main(String[] args) {
        //initializes integer variables for RGB to data from user input
        int red = Integer.parseInt(args[0]);
        int green = Integer.parseInt(args[1]);
        int blue = Integer.parseInt(args[2]);
        
        //determines white value
        double maxRedGreen = Math.max(red/255.0, green/255.0);
        double white = Math.max(maxRedGreen, blue/255.0);
        
        //converts RGB format to CMYK values
        double cyan = (white-(red/255.0))/white;
        double magenta = (white-(green/255.0))/white;
        double yellow = (white-(blue/255.0))/white;
        double black = 1 - white;
        
        //prints results
        System.out.println("red = " + red);
        System.out.println("green = " + green);
        System.out.println("blue = " + blue);
        System.out.println("cyan = " + cyan);
        System.out.println("magenta = " + magenta);
        System.out.println("yellow = " + yellow);
        System.out.println("black = " + black);
        
    }

}