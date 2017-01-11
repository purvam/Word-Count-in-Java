package wordCount.visitors;

import wordCount.dsForStrings.DataStructureI;
import wordCount.util.FileProcessor;
import wordCount.util.Logger;
import wordCount.util.Logger.DebugLevel;

/**
 * WordCountVisitor concrete class of DSProcessingVisitorI
 * @author Smurfette
 *
 */
public class WordCountVisitor implements DSProcessingVisitorI {
	public FileProcessor fp;

	/**
	 * WordCountVisitor constructor
	 * @param fpIn
	 */
	public WordCountVisitor(FileProcessor fpIn){
		DebugLevel db = DebugLevel.CONSTRUCTOR;
		Logger.getUniqueInstance();
		Logger.writeMessage("WordCountVisitor constructor called.",db);
		

		fp=fpIn;
	}
	
	/**
	 * visit method
	 * @param d
	 * calculates totalWordCount, uniqueWordCount, totalCharCount from tree 
	 */
	public void visit(DataStructureI d) {
		DebugLevel db = DebugLevel.WORDCOUNTV;
		Logger.getUniqueInstance();
		Logger.writeMessage("WordCountVisitor's visit called.",db);

		d.traverse(fp);
	}
}
