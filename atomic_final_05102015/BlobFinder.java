/***********************************************************
  Names: Rene Chalom, Murray Lynch
  NetIDs: rchalom, mdlynch
  Precept: P04
  Preceptor: Stephen Cook
  
  Dependencies: Picture.java Luminance.java Color.java StdOut.java
  Queue.java Blob.java
  
  Description: Creates data type that stores all blobs from given image
  which includes method that identifies all blobs >= P, blob mass.
  
  ************************************************************/

import java.awt.Color;

public class BlobFinder {
    
    // instance variables
    private double tau; // luminance threshold
    private int width; // of picture
    private int height; // of picture    
    // boolean array, where [i][j] is the index, 
    // takes on values true or false to mark if visited.
    private boolean[][] visited;
    private Picture picture;
    
    private Node first; // tracks first node
    private Node last; // saves traversing list to add new node
    
    // creates Node data type to facilitate non-circular linked list of blobs
    private class Node {
        private Blob blob;
        private Node next;
        
        // constructor method to create node containing blob
        private Node(Blob blob) {
            this.blob = blob;
            next = null;
        }
    }

    // construcotr method that finds all blobs in the picture 
    // using the luminance threshold tau
    public BlobFinder(Picture picture, double tau) {
        // assign instance variables
        width = picture.width();
        height = picture.height();
        this.picture = picture;
        this.tau = tau;
        
        // creates boolean 2d array to track visit to each pixel
        visited = new boolean[width][height];
        
        // nested for loops to examine each pixel of the image,
        // calling recursive method dfs() if specific pixel has not been visited
        // and is above luminance threshold tau
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                // if pixel already visited, move to next pixel and skip recursion
                if (visited[i][j]) continue; 
                
                // check if current pixel is above threshold tau.
                // If it is create new blob and run dfs() to find all other 
                // pixels in that blob
                Color color = picture.get(i, j);
                if (Luminance.lum(color) < tau) {
                    visited[i][j] = true;
                }
                else {
                    Blob newBlob = new Blob();
                    dfs(newBlob, i, j);
                    
                    // add new blob to linked list
                    addNode(newBlob);
                }
            }  
        }
    }
    
    // adds node containing blob to the end of the linked list of nodes
    private void addNode(Blob blob) {
        Node newNode = new Node(blob);
        
        // create first item in list if linked list is empty,
        // otherwise add to end of list without traversing it
        if (first == null) {
            first = newNode;
            last = newNode;
        } 
        else {
            last.next = newNode;
            last = newNode;
        }
    }
    
    // recursive method that locates all foreground pixels in the same blob as 
    // pixel (i, j), using depth-first search
    private void dfs(Blob blob, int i, int j) {
        
        // checks first if pixel is within bounds of frame
        if ((i < 0) || (i > width-1) || (j < 0) || (j > height-1))
            return;
        
        // checks if pixel has already been examined
        if (visited[i][j])
            return;
        
        // checks if pixels meets luminance threshold
        Color color = picture.get(i, j);
        if (Luminance.lum(color) < tau)
            return;
        
        // after passing all checks, add pixel to current blob and mark as visited
        blob.add(i, j);
        visited[i][j] = true;
        
        // recursively call dfs() for up, right, down and left pixels around current
        dfs(blob, i, j+1);
        dfs(blob, i+1, j);
        dfs(blob, i, j-1);
        dfs(blob, i-1, j);
    }
    
    // return all beads with >= P pixels
    public Blob[] getBeads(int P) {
        
        // create new node pointer to track movement through linked list
        Node currentNode = first;
        
        // create queue of beads (of type Blob) because number of beads not known
        // until traversing entire linked list.
        Queue<Blob> queueOfBeads = new Queue<Blob>(); 
        
        // traverse linked list, adding blobs of mass larger than P 
        // to queue of beads.
        do {
            if (currentNode.blob.mass() >= P) {
                queueOfBeads.enqueue(currentNode.blob);
            }
            currentNode = currentNode.next;
        }
        while (currentNode != null);
        
        // create new array of beads from constructed
        int numBeads = queueOfBeads.length();
        Blob[] beads = new Blob[numBeads];
        for (int i = 0; i < numBeads; i++) {
            beads[i] = queueOfBeads.dequeue();
        } 
        return beads; 
    }
    
    // testing method per assigment directions    
    public static void main(String[] args) {  
        int P = Integer.parseInt(args[0]);
        double tau = Double.parseDouble(args[1]);
        String image = args[2];
        
        Picture picture = new Picture(image); 
        
        // create blob finder from image and threshold given in argument
        BlobFinder blobs = new BlobFinder(picture, tau);
        
        // prints out all of the beads with at least P pixels
        Blob[] beads = blobs.getBeads(P);
        
        // print beads with specific format
        StdOut.println(beads.length + " Beads: ");
        
        for (int i = 0; i < beads.length; i++) {
            StdOut.println(beads[i]);
        }
        
        StdOut.println();
        
        // print all of the blobs (P >= 1) to specified format
        Blob[] allBlobs = blobs.getBeads(1);
        
        StdOut.println(allBlobs.length + " Blobs:");
        
        for (int i = 0; i < allBlobs.length; i++) {
            StdOut.println(allBlobs[i]);
        }      
    }   
}