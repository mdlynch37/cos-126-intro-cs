/*************************************************************************
 *  Name: Murray Lynch
 *  Login: mdlynch
 *  Precept: P04
 * 
 *  Compilation:  javac GreatCircle.java
 *  Execution:    java GreatCircle x1 y1 x2 y2
 *
 *  Description: Accepts two coordinates from user in degrees and uses a formula
 *  derived from the spherical law of cosines to calculate the great circle 
 *  distance between them, returning the result in nautical miles.
 *
 *  Dependencies: None.
 * 
 *  % java GreatCircle 40.35 74.65 48.87 -2.33      // Princeton to Paris 
 *  3185.1779271158425 nautical miles  
 *
 *
 *************************************************************************/

public class GreatCircle {

    public static void main(String[] args) {
        //accepts coordinates from user, converting them to radians
        double x1 = Math.toRadians(Double.parseDouble(args[0]));
        double y1 = Math.toRadians(Double.parseDouble(args[1]));
        double x2 = Math.toRadians(Double.parseDouble(args[2]));
        double y2 = Math.toRadians(Double.parseDouble(args[3]));
        
        //calculates distance between coordinates in radians
        double distanceRadian = 60 * Math.acos(Math.sin(x1) * Math.sin(x2) 
                              + Math.cos(x1) * Math.cos(x2) * Math.cos(y1-y2));

        //converts radians to degrees
        double distanceDegree = Math.toDegrees(distanceRadian);
        
        //prints results
        System.out.println(distanceDegree + " nautical miles");
        
    }

}