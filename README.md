# Word-Count-in-Java

Programmed to populate a tree to count different words from the text file, back up the tree and change backed-up tree as original tree changes.
Implemented Visitor pattern, clone pattern and observer pattern.

From given text input file each word is read and if not present in tree added or the count for that word is incremented using populateVisitor, using tree's insert method.
BackupVisitor creates the deep copy of the tree created by populateVisitor. It uses clone Pattern to achieve this. Observer pattern is used here to change the backup tree as the original tree changes.
WordCountVisitor traverses the tree and counts unique and total no. of words.
