/***********************************************************
  * 
  Names: Rene Chalom, Murray Lynch
  NetIDs: rchalom, mdlynch
  Precept: P04
  Preceptor: Stephen Cook
  
  Dependencies: 
  
  Citations: Point.java; Atomic Nature Slideshow
  
  Description: "Traak beads from one image to the next"
  
  ************************************************************/

public class BeadTrackerSlower {
  
  public static void main(String[] args) {
    
    // read-in arguments
    int P = Integer.parseInt(args[0]);
    double tau = Double.parseDouble(args[1]);
    double delta = Double.parseDouble(args[2]);
    
    // Number of read-in images.
    int numImages = args.length - 3;
    
    // Array of Strings for the names
    String[] images = new String[numImages];
    
    for (int i = 0; i < numImages; i++) {
      images[i] = args[i+3];
    }
    
    
    
    
    // make more efficient by not duplicating BlobFinder stuff ???
    for (int i = 0; i < numImages - 1; i++) {
      
      // Load 2 images into pictures.
    Picture a = new Picture(images[i]);
    Picture b = new Picture(images[i+1]);
      
      // Create blobFinders to identify blobs in pictures.
    BlobFinder blobFinderA = new BlobFinder(a, tau);
    BlobFinder blobFinderB = new BlobFinder(b, tau);
    
    // Get Beads
    Blob[] beadsA = blobFinderA.getBeads(P);
    Blob[] beadsB = blobFinderB.getBeads(P);
    
      // Compare t+1 frame (beadsB) to t frame (beadsA)
      for (int j = 0; j < beadsB.length; j++) {
        double min = Double.POSITIVE_INFINITY;
        for (int k = 0; k < beadsA.length; k++) {
          
          double distance = beadsB[j].distanceTo(beadsA[k]);
          if (distance < min) {
            min = distance;
          }
          
        }
        if (min <= delta) {
          System.out.printf("%.4f", min);
          System.out.println();
        }
        
        
      }
      System.out.println();
      
      // update the new picture
      a = b;
      b = new Picture(images[i+1]);
      
    }
    
    
  } 
}