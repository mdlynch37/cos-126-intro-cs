/**********************************************************************
 *  readme template
 *  Loops
 **********************************************************************/

Name: Murray Lynch
Login: mdlynch
Precept: P04
OS: OS X
Text editor: DrJava
Hours to complete assignment (optional):

/**********************************************************************
 *  How does the mean squared distance of a random walker grow
 *  as a function of the number of steps N?  Briefly justify your
 *  answer based on computational experiments.  (Describe the 
 *  experiments and/or list several data points.)
 *********************************************************************/

Mean squared distance grows in proportion to the number of steps N.
Or rather, mean squared distance tends toward the number of steps N.

The following are results from RandomWalkers showing this trend:

> java RandomWalkers 160 1000000
mean squared distance = 160.245336
> java RandomWalkers 160 1000000
mean squared distance = 160.107068

> java RandomWalkers 161 1000000
mean squared distance = 160.993608
> java RandomWalkers 161 1000000
mean squared distance = 161.069484

> java RandomWalkers 162 1000000
mean squared distance = 161.951162
> java RandomWalkers 162 1000000
mean squared distance = 161.95139



/**********************************************************************
 *  Did you receive help from classmates, past COS 126 students, or
 *  anyone else?  Please list their names.  ("A Sunday lab TA" or 
 *  "Office hours on Thursday" is ok if you don't know their name.)
 **********************************************************************/

Received a response from a Piazza post titled “Build histogram during 
simulation” on 02/14/15


/**********************************************************************
 *  Describe any serious problems you encountered.                    
 **********************************************************************/

n/a

/**********************************************************************
 *  List any other comments here.                                     
 **********************************************************************/

n/a


