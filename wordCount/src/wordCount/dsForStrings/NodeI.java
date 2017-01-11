package wordCount.dsForStrings;

/**
 * NodeI interface
 * @author Smurfette
 *
 */
public interface NodeI {

	/**
	 * getWord method
	 * @return
	 */
	public String getWord();
	
	/**
	 * getWordCount method
	 * @return
	 */
	public int getWordCount();
	
	/**
	 * setWordCount method
	 * @param cntIn
	 */
	public void setWordCount(int cntIn);
	
	/**
	 * incWordCount method
	 * increase count by 1
	 */
	public void incWordCount();
	
	/**
	 * getLeft method
	 * @return NodeI
	 */
	public NodeI getLeft();
	
	/**
	 * getRight method
	 * @return NodeI
	 */
	public NodeI getRight();
	
	/**
	 * setRight method
	 * @param nodeIn
	 */
	public void setRight(NodeI nodeIn);
	
	/**
	 * setLeft method
	 * @param nodeIn
	 */
	public void setLeft(NodeI nodeIn);
}
