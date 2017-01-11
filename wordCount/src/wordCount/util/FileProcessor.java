package wordCount.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import wordCount.util.Logger.DebugLevel;

/**
 * 
 * @author Smurfette
 *
 */
public class FileProcessor {
	private BufferedReader br;
	private BufferedWriter bw;
	
	String inputFileName;
	String outputFileName;
	
	/**
	 * toString method
	 * @return String
	 * to make string of object value
	 */
	public String toString(){
		String str = "FileProcessor class toString Method: Input_filename: " + inputFileName + "\n";
		return str;
	}
	
	/**
	 * FileProcessor constructor
	 * @param inputfileIn
	 * @param outputFileIn
	 */
	public FileProcessor(String inputfileIn, String outputFileIn){
		DebugLevel db = DebugLevel.CONSTRUCTOR;
		Logger.getUniqueInstance();
		Logger.writeMessage("FileProcessor constructor called.",db);
		
		inputFileName =inputfileIn;
		outputFileName= outputFileIn;
		try{
			br = new BufferedReader(new FileReader(inputFileName));
			bw= new BufferedWriter(new FileWriter(outputFileName));
		}
		catch(IOException e){
			e.printStackTrace();
			System.exit(-1);
		}
		finally{}
	}

	/**
	 * FileProcessor constructor
	 * @param outputFileIn
	 */
	public FileProcessor(String outputFileIn){
		DebugLevel db = DebugLevel.CONSTRUCTOR;
		Logger.getUniqueInstance();
		Logger.writeMessage("FileProcessor constructor called.",db);
		
		outputFileName= outputFileIn;
		try{
			bw= new BufferedWriter(new FileWriter(outputFileName));
		}
		catch(IOException e){
			e.printStackTrace();
			System.exit(-1);
		}
		finally{}
	}

	
	/**
	 * readNextLine method
	 * @return line
	 * read one line
	 */
	public String readNextLine(){
		String line=null;
		try{
			line=br.readLine();
		}
		catch(IOException e){
			e.printStackTrace();
			System.exit(-1);
		}
		finally{}
		return line;
	}
	
	/**
	 * writeNextLine method
	 * @param str
	 * write one line at a time
	 */
	public void writeNextLine(String str){
		try {
			bw.write(str);
			bw.flush();
		}
		catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		finally{}
	}
	
	/**
	 * finalize method
	 * @override Object class finalize method
	 * close bufferedReader object and bufferedWrited object
	 */
	protected void finalize(){
		try{
			if(br!=null)
				br.close();
			
			if(bw!=null){
				bw.flush();
				bw.close();
			}
		}catch(IOException e){
			e.printStackTrace();
			System.exit(-1);
		}
		finally{}
		
		try {
			super.finalize();
		} catch (Throwable e) {
			e.printStackTrace();
			System.exit(-1);
		}
		finally{}
	}

}

