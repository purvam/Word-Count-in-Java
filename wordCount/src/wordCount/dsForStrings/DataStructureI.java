package wordCount.dsForStrings;

import wordCount.util.FileProcessor;
import wordCount.visitors.DSProcessingVisitorI;

/**
 * 
 * DataStructureI interface
 * @author Smurfette
 *
 */
public interface DataStructureI {
	/**
	 * accept method
	 * @param v
	 */
	public void accept(DSProcessingVisitorI v);

	/**
	 * insert method
	 * @param strIn
	 */
	public void insert(String strIn);

	/**
	 * traverse method
	 * @param fpIn
	 */
	public void traverse(FileProcessor fpIn);

	/**
	 * getRoot method
	 * @return Node
	 */
	public NodeI getRoot();

	/**
	 * writeTreeToFile method
	 * @param nodeIn
	 * @param fpIn
	 */
	public void writeTreeToFile(NodeI nodeIn, FileProcessor fpIn);
}
