/***********************************************************
  Names: Rene Chalom, Murray Lynch
  NetIDs: rchalom, mdlynch
  Precept: P04
  Preceptor: Stephen Cook
  
  Dependencies: BlobFinder.java Blob.java Picture.java

  Description: Analyzes consecutive images to track movement of beads
  across images, taking arguments P, tau, delta and image filenames.
  
  ************************************************************/

public class BeadTracker {
  public static void main(String[] args) {
    int NUM_NON_IMAGE_ARGS = 3; // constant of number of args before image names
      
    // read-in arguments
    int P = Integer.parseInt(args[0]); // min size of bead
    double tau = Double.parseDouble(args[1]); // luminance threshold
    // max distance a bead can move between frames
    double delta = Double.parseDouble(args[2]); 
    
    // Number of read-in images. 
    int numImages = args.length - NUM_NON_IMAGE_ARGS;
    
    // Array of Strings for image names
    String[] images = new String[numImages];
    
    // fill image name array
    for (int i = 0; i < numImages; i++) {
      images[i] = args[i+NUM_NON_IMAGE_ARGS];
    }
    
    // Load the first image. Acquire the beads for this image.
    // Avoids analyzing both images within for loop for efficiency
    Picture a = new Picture(images[0]);
    BlobFinder blobFinderA = new BlobFinder(a, tau);
    Blob[] beadsA = blobFinderA.getBeads(P);
   
    // analyze each image to its following image.
    for (int i = 0; i < numImages - 1; i++) {
      
      // Load the next image. Acquire beads for that image.
      Picture b = new Picture(images[i+1]);
      BlobFinder blobFinderB = new BlobFinder(b, tau);
      Blob[] beadsB = blobFinderB.getBeads(P);
      
      
      // Compare t+1 frame (beadsB) to t frame (beadsA)
      // Outer loop takes each bead from time t+1 (B), comparing to each bead
      // from time t (A) with inner loop.
      for (int j = 0; j < beadsB.length; j++) {
        double min = Double.POSITIVE_INFINITY; // initialize minimum tracker
        
        for (int k = 0; k < beadsA.length; k++) { 
          double distance = beadsB[j].distanceTo(beadsA[k]);
          
          // updates min tracker if necessary
          if (distance < min) {
            min = distance;
          } 
        }
        
        // if min distance is less than delta, we can assume bead in t+1 
        // is the same as bead in t.
        if (min <= delta) {
          System.out.printf("%.4f", min);
          System.out.println();
        }  
      }
      System.out.println(); // spaces between each time period
      
      // Point beadsA to beadsB for next iteration of outer loop
      beadsA = beadsB;
    }
  } 
}