/*************************************************************
Create an object-oriented version of BouncingBall.java that
is capable of simulating any number of Ball instances. The first
program should define the following API:
 
public class Ball
-----------------------------------------------------------------
Ball()       create a ball at (0,0), random velocity, random size
void draw()  draw ball at current position
void move()  move using velocity and unit time increment
 
The second program (shown separately) will be a client 
BouncingBalls that takes a command-line argument N and 
creates/animates N bouncing balls.
 
 *************************************************************
 *  Compilation:  javac Ball.java
 *  Execution:    java Ball
 *  Dependencies: StdDraw.java
 *
 *  Object oriented implementation of a 2-d Ball
 *  Implementation of a 2-d Ball moving in square with coordinates
 *  between -1 and 1. Bounces off the walls upon collision.
 *  Booksite 3.4 
 *************************************************************/
 
public class Ball {
 
   // declare instance variables
   private double px;   // position
   private double py;
   private double vx;   // velocity
   private double vy;
   private double radius;     // radius
 
   // other instance variables? up to you
 
   // constructor
   public Ball() {
       // always start ball position at (0, 0)
       // velocity between 0.15 and -0.15
       px = 0;
       py = 0;
       vx = (Math.random() * 0.3) - 0.15;
       vy = (Math.random() * 0.3) - 0.15;
       radius = (Math.random() * 0.005) + 0.025;
       
 
 
       // initial velocity and size generated randomly
       
 
 
 
 
   }
 
 
   // draw the ball, but not the background
   public void draw() {
       StdDraw.filledCircle(px, py, radius);
  

 
   }
 
 
   // bounce off vertical wall by reflecting x-velocity
   private void bounceOffVerticalWall() {
       if (Math.abs(py + vy) + radius > 1.0) { vy = -vy;}
   }
 
   // bounce off horizontal wall by reflecting y-velocity
   private void bounceOffHorizontalWall() {
        if (Math.abs(px + vx) + radius > 1.0) { vx = -vx;}
   }
 
 
   // move the ball one step, but don't draw it
   public void move() {
       // bounce off wall(s) if you are near the border
       bounceOffVerticalWall();
       bounceOffHorizontalWall();
 
       // update position using unit change in time
       px = px + vx; 
       py = py + vy; 
 
 
   }
 
   // test client to create and animate just 2 balls.
   // this part is already complete.
   public static void main(String[] args) {
      // create and initialize two balls
      Ball b1 = new Ball();
      Ball b2 = new Ball();
 
      // animate them
      StdDraw.setXscale(-1.0, +1.0);
      StdDraw.setYscale(-1.0, +1.0);
      while (true) {
         StdDraw.setPenColor(StdDraw.GRAY);
         StdDraw.filledSquare(0.0, 0.0, 1.0);
         StdDraw.setPenColor(StdDraw.BLACK);
         b1.move();
         b2.move();
         b1.draw();
         b2.draw();
         StdDraw.show(20);
      }
   }
}