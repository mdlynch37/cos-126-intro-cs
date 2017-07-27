/**********************************************************************
 ***  COS 126  ****  Travelling Salesperson Problem  *****  Readme  ***
 **********************************************************************/

Name: Murray Lynch
Login: mdlynch
Precept: P04

Partner's name (if any): N/A
Partner's login:
Partner's precept:

Which partner is submitting the program files? N/A

Hours to complete assignment (optional): 12


/**********************************************************************
 *  Explain how you implemented the nearest insertion heuristic.      *
 **********************************************************************/

I traversed the linked list, comparing the distance from the current
node to the given point. If a distance was closer than the closest 
recorded distance, nearest was updated. Once the entire list was 
traversed, I inserted the new point after the nearest recorded points.

/**********************************************************************
 *  Explain how you implemented the smallest insertion heuristic.     *
 *  It's sufficient to list only the differences between this         *
 *  heuristic and the nearest insertion heuristic.                    *
 **********************************************************************/

With some arithmetic, for each node I calculated the increase in length
of tour by adding the given point. The node that added the least length
to the tour was tracked, and once the list was traversed, the given point
was inserted after that node.


/**********************************************************************
 *  Explain why it's better to use a circular linked list instead of  *
 *  an array.                                                         *
 **********************************************************************/

Arrays must be declared with a fixed length. This is either restrictive,
limiting the size of list that a program can store, or it wastes memory
by leaving empty pointers for unused array elements.


/**********************************************************************
 *  Fill in the distances computed by your heuristics.                *
 **********************************************************************/

data file      nearest neighbor     smallest increase      extra credit
-----------------------------------------------------------------------
tsp10.txt         1566.1363             1655.7462
tsp100.txt        7389.9297		4887.2190
tsp1000.txt	  27868.7106		17265.6282
usa13509.txt	  77449.9794		45074.7769

/**********************************************************************
 *  Do two timing analyses. Estimate the running time (in seconds)    *
 *  of each heuristic as a function of N, using expressions of the    *
 *  form: a * N^b, where b is an integer.                             *
 *                                                                    *
 *  Explain how you determined each of your answers.                  *
 *                                                                    *
 *  To get your data points, run the two heuristics for N = 10000,    *
 *  and repeatedly double N until the execution time exceeds 60       *
 *  seconds. You may use TSPTimer to help do this, as per the         *
 *  checklist.                                                        *
 *                                                                    *
 *  (If N = 10000 takes over 60 seconds, your code is too slow.       * 
 *  See the checklist for a suggestion on how to fix it.)             *
 **********************************************************************/

N               nearest time (s)          smallest time (s)
------------------------------------------------------------
10000		0.458			  0.729
20000		1.447			  2.763
40000		6.338			  12.902

N		9.885e-10 * N^2.131	  7.591e-10 * N^2.223

80000 est.	27.762			  60.234
80000 actual	58.653			  92.652

Calculated run-time function using N = 20000 and N = 40000 data points for
each heuristic. I determined b using log formula given in precept, then substituted
values to determine a.
Using the run-time functions, I then compared actual run-time to what the
functions predict.


/**********************************************************************
 *  If you and/or your partner did the extra credit,  
 *  please note here who did it (only you, only your partner, both).
 **********************************************************************/

N/A

/**********************************************************************
 *  If you did the extra credit, explain your heuristic, and how
 *  you went about implementing it.
 **********************************************************************/

N/A

/**********************************************************************
 *  Did you receive help from classmates, past COS 126 students, or
 *  anyone else?  Please list their names.  ("A Sunday lab TA" or 
 *  "Office hours on Thursday" is ok if you don't know their name.)
 **********************************************************************/

N/A

/**********************************************************************
 *  Describe any serious problems you encountered.                    
 **********************************************************************/

Numerous strategies were tried to implement the insertSmallest method, the
first of which required removePoint and insertPoint methods because I wanted
to insert a new node, measure the tour length and then remove that node
(for each test!). Not having hints, however, is helpful in developing better
programming thinking.

/**********************************************************************
 *  List any other comments here.                                     
 **********************************************************************/

