/************************************************************
 *  Compilation:  javac BouncingBalls.java
 *  Execution:    java BouncingBalls N
 *  Dependencies: Ball.java StdDraw.java
 *  Booksite 3.4
 *  Client to create and animate an array of N bouncing balls 
 ************************************************************/
 
public class BouncingBalls { 
   public static void main(String[] args) {
 
      // number of bouncing balls from command-line argument
      int N = Integer.parseInt(args[0]);
 
      // Set window coordinates between -1 and +1
      StdDraw.setXscale(-1.0, 1.0);
      StdDraw.setYscale(-1.0, 1.0);
 
      // create an array of N random balls
      Ball[] balls = new Ball[N];
      for (int i = 0; i < N; i++)
         balls[i] = new Ball();
 
      // do the animation loop
      while(true) {
         // Gray Background
         StdDraw.setPenColor(StdDraw.GRAY);
         StdDraw.filledSquare(0.0, 0.0, 1.0);
 
         // draw N black balls
         StdDraw.setPenColor(StdDraw.BLACK);
         for (int i = 0; i < N; i++) {
             balls[i].move();
             balls[i].draw();
         }
         StdDraw.show(20);
      }
   }
}
 
/*********************************************************************
Recommended Book Exercises: 3.2.5, 3.2.11 (Point.java code on Booksite)
*********************************************************************/