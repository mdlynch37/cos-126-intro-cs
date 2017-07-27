
/*************************************************************************
  *  Name(s)      : Murray Lynch
  *  NetID(s)     : mdlynch
  *  Precept(s)   : P04
  *  
  *  Dependencies: Point.java StdOut.java StdDraw.java
  *
  *  Description: Data type that represents the sequence of points visited in 
  *  a TSP tour, which uses a cicular linked list of nodes. Includes methods to
  *  add points (data type) to tour according to two methods, insert point after
  *  nearest point in the tour and insert point after the point which would make
  *  the tour length increase the least.
  *
  ****************************************************************************/

public class Tour
{
    // instance variable to track the first node in linked list
    private Node first;
    
    // nested class that makes up linked list containing Points
    private class Node 
    {
        private Point p; // item in linked list stores Point data type
        private Node next; // and which node is next in the linked sequence
        
        // constructor method that created node not yet added to list
        private Node(Point p)
        {
            this.p = p; 
            next = null;
        }
    }
    
    // create an empty tour
    public Tour()        
    {
        first = null; // initialize first node to null
    }
    
    // create a 4 point tour a->b->c->d->a
    public Tour(Point a, Point b, Point c, Point d) 
    {
        addPoint(a);
        addPoint(b);
        addPoint(c);
        addPoint(d);
    }

    // adds point to the end of the circular linked list of nodes
    private void addPoint(Point p)
    {
        Node newNode = new Node(p);
        
        // create first item in list if necessary
        if (first == null) 
        {
            first = newNode;
            first.next = first; // make list circular
        }
        else 
        {
            // initialize tracking node pointer at first node
            Node endNode = first; 
            // run through list until the last node
            do    
                endNode = endNode.next;
            while (endNode.next != first);

            // add node to list, maintaining circularity
            endNode.next = newNode;
            newNode.next = first;
        }
    }
    
    // insert node after node given by the argument variable
    // used mainly for another method of implementing insertSmallest that failed
    // 
    private void insertPoint(Point p, Node node)
    {
        // runtime error if node not in list
        if (node.next == null)
            throw new RuntimeException("Node not in list. Point not inserted.");

        // insert new node
        Node newNode = new Node(p);
        newNode.next = node.next;
        node.next = newNode;    
        
        
           
    }
    
    // deletes first node found with value in argument variable
    // used only for another method of implementing insertSmallest that failed
    private void removeNode(Point p)
    {
        // initialize tracking node pointer
        Node current = first;
            do    
            {
                // delete node when found
                if (current.next.p == p)
                {
                    current.next = current.next.next; 
                    break; // exit loop once node is removed
                }
                else current = current.next; // traverse list
            }
            while (current.next != first);         
    }
    
    // print the tour to standard output
    public void show()     
    {
        // special case    
        if (first == null)        
            throw new RuntimeException("No points in tour.");
        
        // initialize tracking node pointer
        Node node = first;    
        // for each node, print its point
        do 
        { 
            StdOut.println(node.p.toString());      
            node = node.next; // traverse list    
        } 
        while (node != first); 
    }
    
    // draw the tour to standard draw
    public void draw()  
    {
        // special case    
        if (first == null)        
            throw new RuntimeException("No points in tour.");
        
        // initialize tracking node pointer
        Node node = first;    
        
        // for each node, draw a line from its point to the following 
        // node's point 
        do 
        {
            node.p.drawTo(node.next.p);
            node = node.next; // traverse list    
        } 
        while (node != first); 
    }
    
    // number of points on tour
    public int size()      
    {        
        if (first == null)
            return 0;
        
        // initialize counter variable
        int count = 0;
        
        // initialize tracking node pointer
        Node node = first;    
        
        // count each node in the list
        do 
        { 
            count++;    
            node = node.next; // traverse list    
        } 
        while (node != first); 
        
        return count;
    }
    
    // return the total distance of the tour
    public double distance() 
    {
        // initialize distance
        double distance = 0;
        
        // initialize tracking node pointer
        Node node = first;    
        do 
        {
            distance += node.p.distanceTo(node.next.p);
            node = node.next; // traverse list    
        } 
        while (node != first); 
        
        return distance;
    }
    
    // insert p using nearest neighbor heuristic
    public void insertNearest(Point p)   
    {
        // if tour is empty, create first node   
        if (first == null)       
            addPoint(p);
        else
        {
            // initialize node pointers
            Node nearest = first;
            Node node = first.next; // tracking node
            
            // initialize distance variable at first distance
            double distance = nearest.p.distanceTo(p);
            
            // check each node in the tour, and if current distance from node
            // is less than recorded shortest distance, replace distance and 
            // nearest node variables with current node.
            do 
            {
                if (node.p.distanceTo(p) < distance)
                {
                    distance = node.p.distanceTo(p);
                    nearest = node;
                }
                node = node.next; // traverse list    
            } 
            while (node != first);  
            
            insertPoint(p, nearest);
        }
        
        
    }
    
    // insert p using smallest increase heuristic
    public void insertSmallest(Point p)  
    {
        // if the tour is empty or contain 1 node, add point
        // saves CPU time by not using size method
        if ((first == null) || (first.next == first))     
            addPoint(p);
        else
        {
            // initialize tracking and smallest node pointers
            Node smallest = first;
            Node node = first;
            
            // calculate first change to compare with stored smallest change
            double currentChange = 
                (node.p.distanceTo(p) + node.next.p.distanceTo(p)) 
                - node.p.distanceTo(node.next.p);
            // initialize smallest change to first current change
            double smallestChange = currentChange;
            
            // compare change to tour length for each node if the new point
            // were added to the tour
            do 
            {   
                if (currentChange < smallestChange)
                {
                    smallestChange = currentChange;
                    smallest = node;
                }
                node = node.next; // traverse list 
                
                // calculate change for next node
                currentChange = 
                    (node.p.distanceTo(p) + node.next.p.distanceTo(p)) 
                    - node.p.distanceTo(node.next.p);
            } 
            while (node != first);  
            
            
            insertPoint(p, smallest);            
        }
    }
    
    // main method for testing 
    public static void main(String[] args) 
    {
        //first test: 4-point constructor method
        // define 4 points forming a square
        Point a = new Point(100.0, 100.0);
        Point b = new Point(500.0, 100.0);
        Point c = new Point(500.0, 500.0);
        Point d = new Point(100.0, 500.0);
        
        // Set up a Tour with those four points
        // The constructor should link a->b->c->d->a
        Tour squareTour = new Tour(a, b, c, d);
        
        // Output the Tour
        squareTour.show();
        
        //test distance and size methods
        StdOut.println("size: " + squareTour.size());
        StdOut.println("distance: " + squareTour.distance());
        
        //test show method
        StdDraw.setXscale(0, 600);
        StdDraw.setYscale(0, 600);
        
        squareTour.draw();
        
        
    }
}