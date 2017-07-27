/*************************************************************************
 * Name:
 * Login:
 * Precept:
 *
 * Description: Reads in an image from a file, and displays the red, green,
 * and blue portions in three separate windows.   
 * 
 * Dependencies: Picture.java
 *
 * Remark: This is Booksite Creative Exercise 3.1.60.
 *************************************************************************/
 
import java.awt.Color;
 
public class ColorSeparation {
   public static void main(String[] args) {
 
      // read in the picture specified by command-line argument
      Picture pic = new Picture(args[0]);
      int width  = pic.width();
      int height = pic.height();
 
      // create three empty pictures of the same dimension
      Picture R = new Picture(width, height); // R
      Picture G = new Picture(width, height); // G
      Picture B = new Picture(width, height); // B
 
      // separate colors
      for (int x = 0; x < width; x++) {
         for (int y = 0; y < height; y++) {
 
            // color value of current pixel
            Color c = pic.get(x, y);
                                              
            int r = c.getRed(); // r
            int g = c.getGreen(); // g
            int b = c.getBlue(); // b
 
            R.set(x, y, new Color(r, 0, 0)); 
            G.set(x, y, new Color(0, g, 0));
            B.set(x, y, new Color(0, 0, b));
         }
      }
 
      // display each one in its own window
      R.show();
      G.show();
      B.show();
   }  
}