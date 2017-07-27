/***********************************************************
  Names: Rene Chalom, Murray Lynch
  NetIDs: rchalom, mdlynch
  Precept: P04
  Preceptor: Stephen Cook
  
  Dependencies: Math.java StdIn.java
  
  Description: Data is piped through beadTracker to determine 
  estimates of Avogadro's number and the Boltzmann constant, 
  per the Stokes-Einstein relation.
  
  
  ************************************************************/

public class Avogadro {
  public static void main(String[] args) {
    // constants
    double METERS_PER_PIXEL = 0.175 * Math.pow(10, -6);
    int T = 297; // Temperature, in Kelvin
    double VISCOSITY_WATER = 9.135 * Math.pow(10, -4); // in SI Units
    double RADIUS_BEAD = 0.5 * Math.pow(10, -6); // in meters
    double R = 8.31457; // universal gas constant
    
    double sumSquaredRadius = 0.0; // counter 
    int n = 0; // counter of number of beads across trials.
    
    //calculate D, self-diffusion constant, using variance as an estimate
    while (!StdIn.isEmpty()) {
      // convert pixel length to metters
      double r = StdIn.readDouble() * METERS_PER_PIXEL; 
      sumSquaredRadius += r*r;
      n++;
    }
    // formula given
    double D = sumSquaredRadius/(2*n);
    
    // calculate k, Boltzmann constant using Stokes-Einstein relation
    // formula given
    double k = (D * 6 * Math.PI * VISCOSITY_WATER * RADIUS_BEAD)/T;
    
    // Avogadro's number, formula given
    double avogadro = R/k;
    
    System.out.print("Boltzmann = ");
    System.out.printf("%.4e", k);
    System.out.println();
    System.out.print("Avogadro  = ");
    System.out.printf("%.4e", avogadro);
    System.out.println(); // so command line prompt is on next line  
  }
}