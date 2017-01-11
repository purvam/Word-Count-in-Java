package wordCount.visitors;

import wordCount.dsForStrings.DataStructureI;
import wordCount.util.FileProcessor;
import wordCount.util.Logger;
import wordCount.util.Logger.DebugLevel;

/**
 * 
 * @author Smurfette
 * PopulateVisitor concrete class of DSProcessingVisitorI
 *
 */
public class PopulateVisitor implements DSProcessingVisitorI{
	public FileProcessor fp;
	
	/**
	 * PopulateVisitor constructor
	 * @param fpIn
	 */
	public PopulateVisitor(FileProcessor fpIn){
		DebugLevel db = DebugLevel.CONSTRUCTOR;
		Logger.getUniqueInstance();
		Logger.writeMessage("PopulateVisitor constructor called.",db);
		

		fp = fpIn;
	}
	
	/**
	 * visit method 
	 * @param d
	 * manipulates DataStructure to populate it
	 * @Override
	 */
	public void visit(DataStructureI d){
		DebugLevel db = DebugLevel.POPULATEV;
		Logger.getUniqueInstance();
		Logger.writeMessage("PopulateVisitor's visit called.",db);
		

		String lineIn;
		lineIn=fp.readNextLine();
		
		while(lineIn!=null){
			
			String [] lineParts=lineIn.split("\\s+");

			for(int i=0;i<lineParts.length;i++){
				if(lineParts[i].length()!=0)
				d.insert(lineParts[i]);
			}
			lineIn=fp.readNextLine();
		}

	}
}
