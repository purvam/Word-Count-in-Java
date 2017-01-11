package wordCount.dsForStrings;

import wordCount.util.FileProcessor;
import wordCount.util.Logger;
import wordCount.util.Logger.DebugLevel;
import wordCount.visitors.DSProcessingVisitorI;

/**
 * Tree concrete class of DataStructureI
 * @author Smurfette
 *
 */
public class Tree implements DataStructureI{
	private NodeI root;
	private int totalWordCount;
	private int uniqueWordCount;
	private int totalCharCount;
	
	/**
	 * Tree constructor
	 */
	public Tree(){
		DebugLevel db = DebugLevel.CONSTRUCTOR;
		Logger.getUniqueInstance();
		Logger.writeMessage("Tree constructor called.",db);
		
		root= null;
		setTotalWordCount(0);
		setUniqueWordCount(0);
		setTotalCharCount(0);
	}
	
	/**
	 * insert method
	 * @param strIn
	 * add node if doesn't exist already
	 * otherwise update
	 */
	public void insert(String strIn){
		DebugLevel db = DebugLevel.ADD_NODE;
		Logger.getUniqueInstance();
		Logger.writeMessage("Node being added/updated in Tree.",db);
		
		NodeI prv;
		
		if(root==null){
			root = new Node(strIn);
			return;
		}
		
		prv = root;
		
		while(true){
			if((prv.getWord()).compareTo(strIn)==0){	//equal
				prv.incWordCount();
				break;
			}
			
			if((prv.getWord()).compareTo(strIn)<0){	//strIn big
				if(prv.getRight()==null){
					prv.setRight(new Node(strIn));
					break;
				}
				prv= prv.getRight();
			}

			if((prv.getWord()).compareTo(strIn)>0){	//strIn small
				if(prv.getLeft()==null){
					prv.setLeft(new Node(strIn));
					break;
				}
				prv= prv.getLeft();
			}

		}
	}
	
	/**
	 * writeTreeToFile method
	 * @param nodeIn
	 * @param fpIn
	 * writes each node's word and its count to file 
	 */
	public void writeTreeToFile(NodeI nodeIn,FileProcessor fpIn){
		String str="";
		
		if(nodeIn != null){
			writeTreeToFile(nodeIn.getLeft(),fpIn);
			
			str+=nodeIn.getWord()+ " " + nodeIn.getWordCount() + "\n";			
			fpIn.writeNextLine(str);
					
			writeTreeToFile(nodeIn.getRight(),fpIn);
		}
		else{
			return;
		}
	}


	/**
	 * inorder method
	 * @param nodeIn
	 * traverses tree to count totalWordCount, uniqueWordCount and totalCharCount
	 */
	public void inorder(NodeI nodeIn){
		if(nodeIn != null){
			inorder(nodeIn.getLeft());
			
			setTotalWordCount(getTotalWordCount() + nodeIn.getWordCount());
			setTotalCharCount(getTotalCharCount() + ((nodeIn.getWord().length())*nodeIn.getWordCount()));
			setUniqueWordCount(getUniqueWordCount() + 1);
			
			inorder(nodeIn.getRight());
		}
		else{
			return;
		}
	}
	
	/**
	 * traverse method
	 * @param fpIn
	 * writes totalWordCount, uniqueWordCount and totalCharCount to file
	 */
	public void traverse(FileProcessor fpIn){
		setTotalWordCount(0);
		setTotalCharCount(0);
		setUniqueWordCount(0);
		
		inorder(root);
		
		fpIn.writeNextLine("Total words: "+ getTotalWordCount());
		fpIn.writeNextLine("\nUnique words: "+ getUniqueWordCount());
		fpIn.writeNextLine("\nTotal char: "+ getTotalCharCount());
	}
	
	/**
	 * accept method
	 * @param v
	 * @Override
	 * allows visitor to call visit method
	 * used for double dispatch
	 */
	public void accept(DSProcessingVisitorI v){
		v.visit(this);
	}

	/**
	 * getRoot method
	 * @return Node
	 */
	public NodeI getRoot(){
		return root;
	}
	
	/**
	 * setRoot method
	 * @param root2
	 */
	public void setRoot(NodeI root2){
		root= root2;
	}
	
	/**
	 * getTotalCharCount method
	 * @return int
	 */
	public int getTotalCharCount() {
		return totalCharCount;
	}

	/**
	 * setTotalCharCount method
	 * @param totalCharCountIn
	 */
	public void setTotalCharCount(int totalCharCountIn) {
		totalCharCount = totalCharCountIn;
	}

	/**
	 * getUniqueWordCount method
	 * @return int
	 */
	public int getUniqueWordCount() {
		return uniqueWordCount;
	}

	/**
	 * setUniqueWordCount method
	 * @param uniqueWordCountIn
	 */
	public void setUniqueWordCount(int uniqueWordCountIn) {
		uniqueWordCount = uniqueWordCountIn;
	}

	/**
	 * getTotalWordCount method
	 * @return int
	 */
	public int getTotalWordCount() {
		return totalWordCount;
	}

	/**
	 * setTotalWordCount method
	 * @param totalWordCountIn
	 */
	public void setTotalWordCount(int totalWordCountIn) {
		totalWordCount = totalWordCountIn;
	}

}
