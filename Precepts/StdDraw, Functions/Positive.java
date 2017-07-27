public class Positive {
   
   public static boolean isPositive (int num) {
       return num>0;
       
       // OR
       /*boolean b;
       
       if (num > 0) {b = true;}
       else {b = false;}
       
       return b;*/
   }
   
   // basic tests
   public static void main (String[] args) {
      StdOut.println("126 is positive? " + isPositive(126));
      StdOut.println("-126 is positive? " + isPositive(-126));
      StdOut.println("0 is positive? " + isPositive(0));
      StdOut.println("1 or -1 is positive? " 
                  + (isPositive(-1) || isPositive(1)));
   }
}