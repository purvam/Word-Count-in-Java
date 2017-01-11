package wordCount.visitors;

import wordCount.dsForStrings.DataStructureI;
import wordCount.dsForStrings.Node;
import wordCount.dsForStrings.NodeI;
import wordCount.dsForStrings.Tree;
import wordCount.util.FileProcessor;
import wordCount.util.Logger;
import wordCount.util.Logger.DebugLevel;

/**
 * TestVisitor concrete class of DSProcessingVisitorI
 * @author Smurfette
 *
 */
public class TestVisitor implements DSProcessingVisitorI{
	
	private DataStructureI backupTree;
	private FileProcessor origFP;
	private FileProcessor backupFP;

	/**
	 * TestVisitor constructor
	 * @param backupTreeIn
	 * @param origFPIn
	 * @param backupFPIn
	 */
	public TestVisitor(DataStructureI backupTreeIn, FileProcessor origFPIn, FileProcessor backupFPIn){
		DebugLevel db = DebugLevel.CONSTRUCTOR;
		Logger.getUniqueInstance();
		Logger.writeMessage("TestVisitor constructor called.",db);
		

		backupTree = backupTreeIn;
		origFP = origFPIn;
		backupFP = backupFPIn;
	}
	
	@Override
	/**
	 * visit method
	 * @param d
	 * to check if backupVisitor worked
	 * writes both tree data in files
	 */
	public void visit(DataStructureI d) {
		DebugLevel db = DebugLevel.TESTV;
		Logger.getUniqueInstance();
		Logger.writeMessage("TestVisitor's visit called.",db);

		increment(((Tree)d).getRoot());
		
		((Tree)d).writeTreeToFile(d.getRoot(), origFP);
		((Tree)backupTree).writeTreeToFile(backupTree.getRoot(), backupFP);
	}

	/**
	 * increment method
	 * @param prv
	 * recursive method to increase count by 1 of each node
	 */
	public void increment(NodeI prv){
		if(prv != null){
			increment(prv.getLeft());
			prv.incWordCount();
			increment(prv.getRight());
		}
		else{
			return;
		}
	}

}
