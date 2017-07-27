/***********************************************************
  Names: Rene Chalom, Murray Lynch
  NetIDs: rchalom, mdlynch
  Precept: P04
  Preceptor: Stephen Cook
  
  Dependencies: Math.java
  
  Citations: Point.java; Atomic Nature Slideshow
  
  Description: Creates blob data type that stores mass (number of pixels)
  and center of mass for each blob.
  
  ************************************************************/

public class Blob {
  
  // Instance Variables //
  // Number of Points
  private int mass;
  // Center of Mass
  private double cx;
  private double cy;
  
  // Constructor
  public Blob() {
    mass = 0;
    cx = 0.0;
    cy = 0.0;
    
  }
  
  // add a pixel (i j) to the blob
  public void add(int i, int j) {
    
    // Center of Mass is a weighted average.
    cx = (cx*mass + i)/(mass+1);
    cy = (cy*mass + j)/(mass+1);
    // Increment number of pixels.
    mass++; 
    
  }
  
  // return number of pixels added = its mass
  public int mass() {
    
    return mass;
    
  }
  
  // return distance between ceters of masses of this blob and b
  // Adapted from Point.java
  public double distanceTo(Blob b) {
    
    double dx = this.cx - b.cx;
    double dy = this.cy - b.cy;
    return Math.sqrt(dx*dx + dy*dy);
    
  }
  
  
  // return string containing this blob's mass and center of mass. 
  // format coordinates with 4 digits to right of decimal point
  public String toString() {
    // Taken from Atomic Nature Slideshow
    return String.format("%2d (%8.4f, %8.4f)", mass, cx, cy);
  }
  
  
  
  public static void main(String[] args) {
    
    // Test constructor, add(), mass(), and toString() // 
    
    Blob a = new Blob();
    int i = 0; 
    int j = 0;
    
    // Add 4 points of (0,0) to Blob.
    for (int k = 0; k < 4; k = k + 1) { 
      a.add(i, j);
    }
    
    // Add 5th point, (10, 10).
    a.add(10, 5);
    
    // Test print should produce mass, 5, and the point (2.0000, 1.0000).
    System.out.println(a.toString());
    System.out.println();
    
    // Test distanceTo(Blob b) // 
    
    Blob b = new Blob();
    b.add(5, 5);
    // Distance between (2.0000, 1.0000) and (5.000, 5.000) should be
    // sqrt((5-2)^2 + (5-1)^2) = 5.0.
    System.out.println(a.distanceTo(b));
    
  }
  
}

