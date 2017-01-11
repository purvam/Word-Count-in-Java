package wordCount.driver;

import wordCount.dsForStrings.DataStructureI;
import wordCount.dsForStrings.Tree;
import wordCount.util.FileProcessor;
import wordCount.visitors.BackUpVisitor;
import wordCount.visitors.DSProcessingVisitorI;
import wordCount.visitors.PopulateVisitor;
import wordCount.visitors.TestVisitor;
import wordCount.visitors.WordCountVisitor;
import wordCount.util.Logger;

/**
 * 
 * @author Smurfette
 * Driver class
 *
 */
public class Driver {

	static String INPUT_FILE, OUTPUT_FILE,BACKUP_TREE_FILE, ORIG_TREE_FILE;
	static int NUM_ITERATIONS;
	static int DEBUG_VALUE;

	/**
	 * main method
	 * @param args
	 */
	public static void main(String[] args){
	
		
		if(args.length!=6){
			System.out.println("Wrong number of input arguments.\nTry: <input_filename>.txt <otuput_filename>.txt <orig_tree_filename>.txt <backup_tree_filename>.txt <NUM_ITERATIONS> <DEBUG_VALUE>");
			System.exit(-1);
		}
		
		INPUT_FILE =new String(args[0]);
		OUTPUT_FILE =new String(args[1]);
		BACKUP_TREE_FILE =new String(args[2]);
		ORIG_TREE_FILE = new String(args[3]);
		
		NUM_ITERATIONS=Integer.parseInt(args[4]);
		DEBUG_VALUE = Integer.parseInt(args[5]);
		
		if(NUM_ITERATIONS < 1){
			System.out.println("Wrong number of iterations. Allowed values are greater than 0.");
			System.exit(-1);
		}

		if(DEBUG_VALUE > 9 || DEBUG_VALUE < 0){
			System.out.println("Wrong DEBUG_VALUE. Allowed values are between 0 - 9 [inclusive].");
			System.exit(-1);
		}

		try{
			Logger.getUniqueInstance();
			Logger.setDebugValue(DEBUG_VALUE);
			
			DataStructureI t = null;
			long startTime= System.currentTimeMillis();
			for(int i=0;i< NUM_ITERATIONS;i++){
				
				FileProcessor fp = new FileProcessor(INPUT_FILE, OUTPUT_FILE);
				
				DSProcessingVisitorI populateV = new PopulateVisitor(fp);
				DSProcessingVisitorI wordcntV = new WordCountVisitor(fp);
				t = new Tree();
				
				t.accept(populateV);
				t.accept(wordcntV);
			}
			long endTime = System.currentTimeMillis();
			double totalTime= (double)(endTime - startTime)/NUM_ITERATIONS;
			
			System.out.println("Total time taken by Populate visitor and WordCount visitor: " + totalTime + " milliseconds");
			

			//third
			DSProcessingVisitorI backupV = new BackUpVisitor();
			t.accept(backupV);
			
			DataStructureI bt = ((BackUpVisitor) backupV).getTree();

			FileProcessor backupFP = new FileProcessor(BACKUP_TREE_FILE);
			FileProcessor origFP = new FileProcessor(ORIG_TREE_FILE);
	
			//forth
			DSProcessingVisitorI testV = new TestVisitor(bt,origFP,backupFP);
			t.accept(testV);
			
		}
		catch(Exception e){
			e.printStackTrace();
			System.exit(0);
		}
		finally{}
	}
}
