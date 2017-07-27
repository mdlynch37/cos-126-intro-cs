/**********************************************************************
 *  readme.txt template                                             
 *  Hamming Codes
 **********************************************************************/

Name: Murray Lynch
Login: mdlynch
Precept: P04	
OS: OS X
Text editor: DrJava
Hours to complete assignment (optional):



/**********************************************************************
 *  Which simulator did you use to develop your TOY programs?
 *  TOY.java or Visual X-TOY 7.1 (the TOY.jar)?
 **********************************************************************/

Visual X-TOY 7.1

/**********************************************************************
 *  Describe what, if anything, you use each of the registers for
 *  in encode.toy.
 **********************************************************************/
R[1]: content of 1
R[2]:
R[3]:
R[4]:
R[5]:
R[6]:
R[7]:
R[8]:
R[9]: store p3
R[A]: store m1
R[B]: store m2 / store m1+1 (R[A] + R[1]) to test for end of file
R[C]: store m3
R[D]: store m4
R[E]: store p1
R[F]: store p2


/**********************************************************************
 *  Describe what, if anything, you use each of the registers for
 *  in decode.toy.
 **********************************************************************/
R[1]: store m1 (from StdIn)
R[2]: store m2 (from StdIn)
R[3]: store m3 (from StdIn)
R[4]: store m4 (from StdIn)
R[5]: store p1 (from StdIn)
R[6]: store p2 (from StdIn)
R[7]: store p3 (from StdIn)
R[8]: constant of 1
R[9]: store m1+1 (R[A] + R[1]) to test for end of file
R[A]: store calculated p1
R[B]: store calculated p2
R[C]: store calculated p3
R[D]: store R[A] ^ R[5], comparing calculated p1 with given p1
R[E]: store R[B] ^ R[6], comparing calculated p2 with given p2
R[F]: store R[C] ^ R[7], comparing calculated p3 with given p3


/**********************************************************************
 *  If you want to compete for the smallest TOY program, indicate
 *  the size of your decode.toy program in number of non-zero words
 *  of TOY main memory used.
 **********************************************************************/



/**********************************************************************
 *  Did you fill out the midterm evaluation questionnaire?  
 *  For Spring 15, this is at
 *  http://www.cs.princeton.edu/
 *              courses/archive/spring15/cos126/cgi-bin/midtermEval.cgi
 **********************************************************************/

Yes

/**********************************************************************
 *  Did you receive help from classmates, past COS 126 students, or
 *  anyone else?  Please list their names.  ("A Sunday lab TA" or 
 *  "Office hours on Thursday" is ok if you don't know their name.)
 **********************************************************************/

N/A

/**********************************************************************
 *  Describe any serious problems you encountered.                    
 **********************************************************************/

Starting the assignment was incredibly daunting given the newness 
of Hex code and the seeming complexity of the Hamming code method.

/**********************************************************************
 *  List any other comments here.                                     
 **********************************************************************/
