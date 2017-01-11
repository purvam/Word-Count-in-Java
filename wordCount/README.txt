CS542 Design Patterns
Fall 2016
Assignment 4 README FILE

Due Date: Wednsday, November 23, 2016
Submission Date: Wednsday, November 23, 2016
Grace Period Used This Project: 0 Days
Grace Period Remaining: 0 Days
Author: Purva M. Myakal
e-mail: pmyakal1@binghamton.edu


PURPOSE:
The purpose of this assignment to learn, how to use visitor, clone and observer
patterns, i.e. to combine different patterns in one project.

DATA STRUCTURE USED:
I used Binary Search Tree as a data structure to store node class objects.
Node class stores word and its count.

LOGIC:
The PopulateVisitor populates the tree. WordCountVisitor counts totalWordCount,
uniqueWordCount, totalCharCount. BackUpVisitor backs up entire tree. TestVisitor
tests if back-up works.
Node implements Clonable, ObserverI, SubjectI interfaces. Clone gives deep copy
of the node. So that, whenever subject node's count changes, only that node's
observers' update are called.


TIME COMPLEXITY:
n = no. of tatal words in file
Worst case complexity: O(n)
average case complexity: O(log(n))

SPACE COMPLETE:
n = no. of tatal words in file
O(n)

PERCENT COMPLETE:
To my knowlegde, the assignment is complete.

PARTS THAT ARE NOT COMPLETE:
None.

BUGS:
None.

FILES:
myakal_purva_assign4
   ---wordCount
     ----- README.txt
     ----- build.xml
     ----- src
        -----wordCount
     	   ----------driver
	        	   ----------Driver.java
           ----------util
	              ----------FileProcessor.java
				  ----------Logger.java
           ----------dsForStrings
	              ----------DataStructureI.java
				  ----------NodeI.java
				  ----------Tree.java
				  ----------Node.java
           ----------visitors
	              ----------DSProcessingVisitorI.java
				  ----------PopulateVisitor.java
				  ----------WordCountVisitor.java
				  ----------BackUpVisitor.java
				  ----------TestVisitor.java
	              ----------WordCountVisitor.java
           ----------observers
				  ----------ObserverI.java
				  ----------SubjectI.java
				  
README.txt : the text file explaining the code.

SAMPLE OUTPUT:
Total time taken by Populate visitor and WordCount visitor: 1.5 milliseconds

Total words: 25
Unique words: 22
Total char: 86

But 2
Every 2
I 2
It 2
Then 2
a 2
are 2
be 3
better 2
comes 2
day 3
exact 2
is 3
luck 2
lucky 2
new 2
rather 2
ready 2
to 2
when 2
would 2
you 2


TO COMPILE:
	ant -buildfile build.xml all 

TO RUN:
	ant -buildfile build.xml run -Darg0=input.txt -Darg1=output.txt -Darg2=origTree.txt -Darg3=backupTree.txt -Darg4=10 -Darg5=0
	
	Where:
		arg0= <input>.txt
		arg1= <output>.txt
		arg2= <to_write_orig_Tree_file>.txt
		arg3= <to_write_backupTree_Tree_file>.txt
		arg4= <NUM_ITERATIONS>
		arg5= <DEBUG_LEVEL_NUM>
	
	where DEBUG_LEVEL_NUM:
		0 = DebugLevel.NOTHING;
		1 = DebugLevel.CONSTRUCTOR;
		2 = DebugLevel.ADD_NODE;
		3 = DebugLevel.POPULATEV;
		4 = DebugLevel.WORDCOUNTV;
		5 = DebugLevel.BACKUPV;
		6 = DebugLevel.TESTV;
		7 = DebugLevel.OBSERVER;				
		8 = DebugLevel.SUBJECT;
		9 = DebugLevel.CLONE;


EXTRA CREDIT:
None.

BIBLIOGRAPHY:
None.

ACKNOWLEDGEMENT:
None.