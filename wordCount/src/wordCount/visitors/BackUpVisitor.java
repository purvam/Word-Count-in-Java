package wordCount.visitors;

import wordCount.dsForStrings.DataStructureI;
import wordCount.dsForStrings.Node;
import wordCount.dsForStrings.NodeI;
import wordCount.dsForStrings.Tree;
import wordCount.util.Logger;
import wordCount.util.Logger.DebugLevel;

/**
 * BackUpVisitor concrete class of DSProcessingVisitorI
 * @author Smurfette
 *
 */
public class BackUpVisitor implements DSProcessingVisitorI{
	
	DataStructureI backupTree;
	NodeI backupRoot;
	
	/**
	 * BackUpVisitor constructor
	 */
	public BackUpVisitor(){
		DebugLevel db = DebugLevel.CONSTRUCTOR;
		Logger.getUniqueInstance();
		Logger.writeMessage("BackUpVisitor constructor called.",db);
		

		backupTree = new Tree();
	}
	
	
	/**
	 * visit method
	 * @param orig
	 * creates deep copy of DataStructure
	 * @Override
	 */
	public void visit(DataStructureI orig) {
		DebugLevel db = DebugLevel.BACKUPV;
		Logger.getUniqueInstance();
		Logger.writeMessage("BackUpVisitor's visit called.",db);

		
		NodeI origNode = (Node)((Tree) orig).getRoot();
		NodeI root=backupRecur(origNode);
		((Tree)backupTree).setRoot(root);
	}
	
	/**
	 * backupRecur method
	 * @param origNode
	 * @return Node
	 * recursive method to create deep copy of each node and set links
	 */
	public NodeI backupRecur(NodeI origNode){
		if(origNode==null)
			return null;
		
		NodeI backupNode=((Node) origNode).clone();
		
		NodeI left=backupRecur(origNode.getLeft());
		backupNode.setLeft(left);
		
		NodeI right=backupRecur(origNode.getRight());
		backupNode.setRight(right);
		
		return backupNode;
	}
	
	/**
	 * getTree method
	 * @return Tree
	 */
	public Tree getTree(){
		return (Tree) backupTree;
	}
}
