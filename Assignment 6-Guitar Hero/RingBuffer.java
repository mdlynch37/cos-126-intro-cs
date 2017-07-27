
/*************************************************************************
 * Name(s)      : Murray Lynch
 * NetID(s)     : mdlynch
 * Precept(s)   : P04
 *
 * Dependencies : none
 * Description  : This class creates a data type, RingBuffer, which models
 *                a wave for use with the Karplus-Strong algorithm.
 *                This implements a ring buffer feedback mechanism with an
 *                chosen energy decay factor of 0.996 and gentle low-pass filter
 *                with an averaging operation.
 *
 *****************************************************************************/

public class RingBuffer 
{
    private double[] rb;          // items in the buffer
    private int first;            // index for the next dequeue or peek
    private int last;             // index for the next enqueue
    private int size;             // number of items in the buffer

    // create an empty ring buffer, with given max capacity
    public RingBuffer(int capacity) 
    {
        // create new array for buffer of a specified maximum size
        rb = new double[capacity];
        
        // initialize counter instance variables
        first = 0;
        last = 0;
        size = 0;
    }

    // return number of items currently in the buffer
    public int size() 
    {
        return size;
    }

    // is the buffer empty (size equals zero)?
    public boolean isEmpty() 
    {
        return size == 0;
    }

    // is the buffer full (size equals array capacity)?
    public boolean isFull() 
    {
        return size == rb.length;
    }

    // add item x to the end
    public void enqueue(double x) 
    {
        // if the buffer is full, throw a run-time exception
        if (isFull()) 
        {
            throw new RuntimeException("Ring buffer overflow");
        }
        
        // add argument variable to the end of the buffer
        rb[last] = x;
        
        // if the argument variable is assigned to the last element of the
        // buffer array, implement cyclic wrap-around and assign instance 
        // variable, last, to the first element of the array.
        // Else, increment last.
        if (last == rb.length-1)
            last = 0;
        else last++;
        
        // increment buffer size since element was added to the buffer
        size++;
        
    }

    // delete and return item from the front
    public double dequeue() 
    {
        // if the buffer is empty, throw a run-time exception
        if (isEmpty()) 
        {
            throw new RuntimeException("Ring buffer underflow");
        }
        
        // store value from the front of the rign buffer in local variable
        double front = rb[first];
        
        // increment index for the front of the buffer, or implement cyclic 
        // wrap-around by assigning it to the beginning of the buffer array
        // if first was initially at the end of the array 
        if (first == rb.length-1)
            first = 0;
        else first++;
        
        // decrement buffer size since element removed from the buffer
        size--;
        
        return front;
    }

    // return (but do not delete) item from the front
    public double peek() 
    {
        // if the buffer is empty, throw a run-time exception
        if (isEmpty()) 
        {
            throw new RuntimeException("Ring buffer underflow");
        }
        
        return rb[first];
    }

    // a simple test of the constructor and methods in RingBuffer provided by
    // course instructor in assignment template
    public static void main(String[] args) 
    {
        int N = Integer.parseInt(args[0]);
        RingBuffer buffer = new RingBuffer(N);
        for (int i = 1; i <= N; i++) 
        {
            buffer.enqueue(i);
        }
        double t = buffer.dequeue();
        buffer.enqueue(t);
        System.out.println("Size after wrap-around is " + buffer.size());
        while (buffer.size() >= 2) 
        {
            double x = buffer.dequeue();
            double y = buffer.dequeue();
            buffer.enqueue(x + y);
        }
        System.out.println(buffer.peek());
    }

}
