/*************************************************************************
 *  Name: Murray Lynch
 *  Login: mdlynch
 *  Precept: P04
 * 
 *  Compilation:  javac-introcs NBody.java 
 *  Execution:    java-introcs NBody T t < textfile.txt
 *
 *  Description: 
 *  Runs a 2-dimensional simulation of N number of bodies interacting according 
 *  to Newtownian physics.
 *  Accepts command line arguments, T and dt , T being the total 
 *  length of the simulation in time and dt being the time quantum by which each
 *  frame of the simulation will be draw in increments. Then, reads in textfile 
 *  which includes the number of bodies N, radius of the universe R, and 
 *  positions, velocities, masses and image filenames for each body in the 
 *  universe in the format below:
 *  5
 *  2.50e+11
 *  1.4960e+11  0.0000e+00  0.0000e+00  2.9800e+04  5.9740e+24    earth.gif
 *  2.2790e+11  0.0000e+00  0.0000e+00  2.4100e+04  6.4190e+23     mars.gif
 *  5.7900e+10  0.0000e+00  0.0000e+00  4.7900e+04  3.3020e+23  mercury.gif
 *  0.0000e+00  0.0000e+00  0.0000e+00  0.0000e+00  1.9890e+30      sun.gif
 *  1.0820e+11  0.0000e+00  0.0000e+00  3.5000e+04  4.8690e+24    venus.gif
 *  Then, it outputs the final state of the universe in the same format.
 *
 *  Dependencies: StdIn.java, StdOut.java, StdDraw.java, StdAudio.java
 * 
 *  % java-introcs NBody 157788000.0 25000.0 < planets.txt
 * 
 *  5
 *  2.50e11
 *   1.4925e+11 -1.0467e+10  2.0872e+03  2.9723e+04  5.9740e+24    earth.gif
 *  -1.1055e+11 -1.9868e+11  2.1060e+04 -1.1827e+04  6.4190e+23     mars.gif
 *  -1.1708e+10 -5.7384e+10  4.6276e+04 -9.9541e+03  3.3020e+23  mercury.gif
 *   2.1709e+05  3.0029e+07  4.5087e-02  5.1823e-02  1.9890e+30      sun.gif
 *   6.9283e+10  8.2658e+10 -2.6894e+04  2.2585e+04  4.8690e+24    venus.gif
 *
 *
 *************************************************************************/

public class NBody 
{
    public static void main(String[] args) 
    {        
        double G = 6.67e-11; // gravitational constant
        int FRAMERATE = 40; // framerate of animation

        double t = 0; // current time in universe, initialized at starting time
        double T = Double.parseDouble(args[0]); // length of simulation
        double dt = Double.parseDouble(args[1]); // time quantum increment
        int N = StdIn.readInt(); // number of particles
        double R = StdIn.readDouble(); //radius of the universe
        
        // declaration of parallel arrays storing properties of each particle
        double[] positionX = new double[N];
        double[] positionY = new double[N];
        double[] velocityX = new double[N];
        double[] velocityY = new double[N];
        double[] mass = new double[N];
        String[] imageName = new String[N];
        


        // reads in properties of particles from textfile
        for (int i = 0; i < N; i++)
        {
            positionX[i] = StdIn.readDouble();
            positionY[i] = StdIn.readDouble();
            velocityX[i] = StdIn.readDouble();
            velocityY[i] = StdIn.readDouble();
            mass[i] = StdIn.readDouble();
            imageName[i] = StdIn.readString();
        }

        // set scale of canvas
        StdDraw.setXscale(-R, R);
        StdDraw.setYscale(-R, R);
        
        // loop that iterates each time quantum increment until the simulation
        // length is reached
        while (t < T)
        {
            // declaration of parallel arrays for force vectors, initializing
            // them to 0.0, the default value, at the beginning of each increment
            double[] forceX = new double[N];
            double[] forceY = new double[N];
 
            // outer loop that starts with the first particle in the parallel 
            // arrays and works until the last one, for which the inner loop
            // will not run, continuing on to calculate the last particle's 
            // position from the culmulative force calculated in both loops'
            // previous iterations
            for (int j = 0; j < N; j++)
            {
                // inner loop that compares particle at j with the particle that
                // follows it, k
                for (int k = j+1; k < N; k++)
                {
                    // calculate delta x and y, subtracting positions of j from
                    // those of particle k so that vector force adheres to the
                    // law of attraction in Newton's formula for gravitational
                    // force
                    double dx = positionX[k] - positionX[j];
                    double dy = positionY[k] - positionY[j];
                    
                    // calculates r, the distance between particles k and j
                    // using the pythagorean theorem
                    double r = Math.sqrt(dx*dx + dy*dy);
                    
                    // calculates force between particles j and k
                    double forcejk = (G*mass[j]*mass[k]) / (r*r);
                    
                    // calculates directional force vectors, adding them to the
                    // culmulative force arrays, reversing vector for particle k
                    // because force acts on k in the opposite direction as j.
                    // This is taken from the principle of superposition
                    forceX[j] += (forcejk*dx) / r;
                    forceY[j] += (forcejk*dy) / r;
                    
                    forceX[k] += -((forcejk*dx) / r);
                    forceY[k] += -((forcejk*dy) / r);
                }
                
                // for particle j, calculates acceleration vectors with Newton's
                // second law of motion and j's culmulative force vectors 
                double aX = forceX[j]/mass[j];
                double aY = forceY[j]/mass[j];
                
                // calculates the force vectors' impact on j's velocity over 
                // duration dt
                velocityX[j] += aX * dt;
                velocityY[j] += aY * dt;
                
                // calculates the velocity vectors' impact on j's position over
                // duration dt
                positionX[j] += velocityX[j] * dt;
                positionY[j] += velocityY[j] * dt;  
            }
            
            // draws background over previous canvas image (so no need for clear
            // method), then positions each particle on the canvas
            StdDraw.picture(0, 0, "starfield.jpg");
            for (int l = 0; l < N; l++)
            {
                StdDraw.picture(positionX[l], positionY[l], imageName[l]);
            }
            // turns on animation mode, displaying drawn image for the
            // appropriate number of milliseconds, calculated with constant
            // FRAMERATE given at the top of code
            StdDraw.show(1000/FRAMERATE);
            
            // increment current time t by time quantum dt
            t += dt;    
        }
        
        // outputs final position and velocity of each body in the same format 
        // for textfile input as given in the header
        StdOut.printf("%d\n", N);
        StdOut.printf("%.2e\n", R);
        for (int i = 0; i < N; i++) 
        {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                          positionX[i], positionY[i], velocityX[i], 
                          velocityY[i], mass[i], imageName[i]);
        }
        

    }
}

