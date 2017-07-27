/**************************************************************************
 *** COS 126 ***  Atomic Nature of Matter -- Final Project  **  Readme  ***
 **************************************************************************/

Name: Rene Chalom
Login: rchalom
Precept: P04

Partner's name (if any): Murray Lynch
Partner's login: mdlynch
Partner's precept: P04

Which partner is submitting the program files? I am (Rene).

Hours to complete assignment (optional): 8 hours


/**************************************************************************
 *  The input size N for BeadTracker is the product of the number of      *
 *  pixels per frame and the number of frames. What is the estimated      *
 *  running time (in seconds) of BeadTracker as a function of N? Justify  *
 *  your answer with empirical data and explain how you used it. Your     *
 *  answer should be of the form a*N^b where b is an integer.             *
 **************************************************************************/

HYPOTHESIS: 

Claim: BeadTracker runs in linear time.

While BeadTracker contains a triple nested for loop, increasing 
input size only increases the number of iterations of the outer-most loop. 
The sizes of the two nested loops depend on the number of beads in each image, 
which does not change by much image to image.

Using the approximation,

t = a * N^b

we obtain the following data:

DATA

Source: run_1 images			N	t	b		a10	1.33	0.404149183	0.13320	1.76	0.774188058	0.08840	3.01	0.388432143	0.0752580	3.94	1.102462034	0.04925160	8.46				Average b = 0.667307854
		Estimate of b = 1 [Used in above calculations for a]	
		Average a = 0.086375 

This confirms our hypothesis that the program runs in linear time.

Our estimated expression of the run-time is of the following form:

t = 0.086375 * N ^ 1

NOTE: Our values might suggest an nth root or a logarithmic function, but the 
final data point that yields a b-value > 1, which would likely refute this.
Moreover, theoretically, it does not make sense that adding data to a 
for-loop would result in anything less than a linear increase in runtime. 
The small b-values can be more likely explained by other hardware factors.



/**************************************************************************
 *  Congratulations! Once you submit Atomic, you'll be finished with all  *
 *  of the requirements for this course. As you know, on programming      *
 *  assignments, we provide you with feedback about what may be wrong     *
 *  in your code. For the final project, we've found that some students   *
 *  prefer simply to receive their grade. Please indicate below whether   *
 *  you would like to receive feedback on this code.                      *
 **************************************************************************/

 [ ] Grade only.
 [X] Grade and feedback.

/**************************************************************************
 *  Did you receive help from classmates, past COS 126 students, or       *
 *  anyone else?  Please list their names.  ("A Sunday lab TA" or         *
 *  "Office hours on Thursday" is ok if you don't know their name.)       *
 **************************************************************************/

N/A

/**************************************************************************
 *  Describe any serious problems you encountered.                        *
 **************************************************************************/

None.

/**************************************************************************
 *  List any other comments here.                                         *
 **************************************************************************/

From both of us: 
Thanks for holding such an awesome course with super fun assignments!
