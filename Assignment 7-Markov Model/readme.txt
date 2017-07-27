/**********************************************************************
 ***  COS 126  ***   Markov Model of Natural Language  ***  Readme  ***
 **********************************************************************/

Name: Murray Lynch
Login: mdlynch
Precept: P04

Partner's name (if any):
Partner's email:
Partner's precept:

Which partner is submitting the program files? N/A

Hours to complete assignment (optional): 10

/**********************************************************************
 * Describe the type parameters of your symbol table and how you used *
 * the symbol table to implement the rand() method.                   *
 **********************************************************************/

Key is type String, used to store strings for each gram.
Value is an integer array used to store the frequency of each letter that
follows the given kgram.

To implement rand() method, I extract int array for specified kgram and 
use double division to convert frequencies into probabilities of each 
character occurring. This double array can be passed to the 
StdRandom.discrete method to determine next character.


/**********************************************************************
 * The main() method we provide in the checklist does not test your   *
 * rand() or gen() methods. Describe how you tested your rand() and   *
 * gen() methods.                                                     *
 **********************************************************************/

To test rand() method, I used mod2 object from provided test code
and looped rand(“fish”) method, incrementing a counter variable whose 
value should indicate the frequency of a chose value, in this case ‘o’.
This counter result should be approximately 1/4 of the loop iterations
based on the input text for mod2.

To test gen(), I used the example provided in the checklist i.e. string
of “abac” making sure ‘b’ and ‘c’ are always followed by ‘a’ etc.


/**********************************************************************
 * Paste two of your favorite, not too long, output fragments here.   *
 * In addition to the pseudo-random text, indicate the order of your  *
 * model and what text file you used.                                 *
 **********************************************************************/

k = 4 textfile = palin.txt
Nice talk.

As for the Bush administan is say a partisanship asident back he whole climate chargest and dear respect? A fear son and when you knows who trying back, even first.
No, and lear, about $700 billing back Obama at thenings and busines that's not too man that it up that is own around as so 



k = 6 textfile = palin.txt
Nice to exert it in working with John McCain-Palin administration would like that supporting to come with me on Saturday, and you rein in Iraq. You said that's an indication needs to be more of my money to the same as McCain has got to win a war.
And he share with bipartisanship that they sit around

/**********************************************************************
 * If you and/or your partner did the extra credit,                   *
 * please note here who did it (only you, only your partner, both).   *
 **********************************************************************/

N/A


/**********************************************************************
 * Did you receive help from classmates, past COS 126 students, or    *
 * anyone else?  Please list their names.  ("A Sunday lab TA" or      *
 * "Office hours on Thursday" is ok if you don't know their name.)    *
 **********************************************************************/

Tuesday office hours with Steven Goldfeder and Victor Yang

/**********************************************************************
 * Describe any serious problems you encountered.                     *
 **********************************************************************/

Not clear at the beginning how to deal with spaces in the text.

/**********************************************************************
 *  List any other comments here.                                     *
 **********************************************************************/

