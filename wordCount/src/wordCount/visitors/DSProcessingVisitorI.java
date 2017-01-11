package wordCount.visitors;

import wordCount.dsForStrings.DataStructureI;

/**
 * 
 * DSProcessingVisitorI interface
 * @author Smurfette
 *
 */
public interface DSProcessingVisitorI {
	
	/**
	 * visit method
	 * @param o
	 */
	public void visit(DataStructureI o);
}
