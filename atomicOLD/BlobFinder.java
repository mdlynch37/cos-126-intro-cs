/***********************************************************
  * 
  Names: Rene Chalom, Murray Lynch
  NetIDs: rchalom, mdlynch
  Precept: P04
  Preceptor: Stephen Cook
  
  Dependencies: Picture.java Luminance.java Color.java StdOut.java
                Queue.java
  
  Citations: Point.java; Atomic Nature Slideshow
  
  Description: 
  
  ************************************************************/

import java.awt.Color;

public class BlobFinder {
  
  // instance variables
  private double tau;
  private int width; // of picture
  private int height; // of picture    
  // boolean array, where [i][j] is the index, 
  // takes on values true or false to mark if visited.
  private boolean[][] visited;
  private Picture picture;
  
  // instance variables
  private Node first;
  private Node last; // saves traversing list to add new node
  
  private class Node {
    private Blob blob;
    private Node next;
    
    private Node(Blob blob) {
      this.blob = blob;
      next = null;
    }
  }
  
  // adds blob to the end of the linked list of nodes
  private void addBlob(Blob blob) {
    Node newNode = new Node(blob);
    
    // create first item in list if necessary
    if (first == null) {
      first = newNode;
      last = newNode;
    }
    else {
      last.next = newNode;
      last = newNode;
    }
    
    //??? see if first is necessary, could add counter to determine first node or not
  }
  
  
  
  
  // recursive method that locates all foreground pixels in the same blob as 
  // pixel (i, j), using depth-first search
  private void dfs(Blob blob, int i, int j) {
    boolean outOfBounds = false;
    if ((i < 0) || (i > width-1) || (j < 0) || (j > height-1))
      outOfBounds = true;
    
    
    boolean dark = false;
    Color color = picture.get(i, j);
    if (Luminance.lum(color) < tau)
      dark = true;
    
    
    if (outOfBounds || visited[i][j] || dark) return;
    
    // add pixel to current blob and mark as visited
    blob.add(i, j);
    visited[i][j] = true;
    
    dfs(blob, i, j+1);
    dfs(blob, i+1, j);
    dfs(blob, i, j-1);
    dfs(blob, i-1, j);
  }
  
  // find all blobs in the picture using the luminance threshold tau
  public BlobFinder(Picture picture, double tau) {
    width = picture.width();
    height = picture.height();
    this.picture = picture;
    
    visited = new boolean[width][height];
    
    this.tau = tau;
    
    // mark visited pixels
    //private int x; // x-coordinate of original pixel
    //private int y; // y-coordinate of original pixel
    
    // nested for loops to examine each pixel of the image,
    // setting pixels below luminance threshold to black.
    for (int i = 0; i < width; i++) {
      for (int j = 0; i < height; j++) {
        // if pixel already visited, move to next one
        while (visited[i][j]) continue; 
        
        Color color = picture.get(i, j);   //check if nesting methods can save extra lum call???
        if (Luminance.lum(color) < tau) {
          visited[i][j] = true;
        }
        else {
          Blob newBlob = new Blob();
          dfs(newBlob, i, j);
          
          addBlob(newBlob);
        }
      }
      
      
    }
    
  }
  
  // return all beads with >= P pixels
  public Blob[] getBeads(int P) {
    
    Node currentNode = first;
    Queue<Blob> queueOfBeads = new Queue<Blob>(); //??? why does API specifc array return type if we need to use a queue?
    
    do {
      if (currentNode.blob.mass() >= P) {  //??? check for better way
        queueOfBeads.enqueue(currentNode.blob);
      }
      currentNode = currentNode.next;
    }
    while (currentNode != last);
    
    int numBeads = queueOfBeads.length();
    Blob[] beads = new Blob[numBeads];
    
    for (int i = 0; i < numBeads; i++) {
      beads[i] = queueOfBeads.dequeue();
    }
    
    return beads; 
  }
  
  // for testing
  // "Write a main() method in BlobFinder.java that takes an integer P, a double value tau, and the name of a JPEG file as command-line arguments. 
  // It then creates a BlobFinder object using a luminance threshold of tau. 
  // Next, it ; finally, it .
  
  public static void main(String[] args) {
    
    int P = Integer.parseInt(args[0]); //check parsing okay ???
    double tau = Double.parseDouble(args[1]);
    String image = args[2];
    
    Picture picture = new Picture(image); 
    
    BlobFinder blobs = new BlobFinder(picture, tau);
    
    // prints out all of the beads with at least P pixels
    Blob[] beads = blobs.getBeads(P);
    
    for (int i = 0; i < beads.length; i++) {
      StdOut.println(beads[i]);
    }
    
    StdOut.println();
    
    // prints out all of the blobs (beads with at least 1 pixel)
    Blob[] allBlobs = blobs.getBeads(1);
    
    for (int i = 0; i < allBlobs.length; i++) {
      StdOut.println(allBlobs[i]);
    }
    
    
  }
  
  
  
  
}