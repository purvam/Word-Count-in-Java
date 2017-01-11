package wordCount.dsForStrings;

import java.util.ArrayList;

import wordCount.observers.ObserverI;
import wordCount.observers.SubjectI;
import wordCount.util.Logger;
import wordCount.util.Logger.DebugLevel;

/**
 * Node concrete class of nodeI, Clonable, ObserverI and SubjectI
 * @author Smurfette
 *
 */
public class Node implements NodeI, Cloneable, ObserverI, SubjectI{
	private String word;
	private int wordCount;
	
	private NodeI left;
	private NodeI right;
	
	private ArrayList<ObserverI> observers;
	
	/**
	 * Node constructor
	 * @param wordIn
	 */
	public Node(String wordIn){
		DebugLevel db = DebugLevel.CONSTRUCTOR;
		Logger.getUniqueInstance();
		Logger.writeMessage("Node constructor called.",db);
		

		word = wordIn;
		wordCount =1;
		
		left = null;
		right = null;
		
		observers = new ArrayList<ObserverI>();
	}
	
	/**
	 * getWord method
	 * @return word
	 */
	public String getWord(){
		return word;
	}
	
	/**
	 * getWordCount method
	 * @return wordCount
	 */
	public int getWordCount(){
		return wordCount;
	}
	
	/**
	 * setWordCount method
	 * @param cntIn
	 */
	public void setWordCount(int cntIn){
		wordCount=cntIn;
	}
	
	/**
	 * incWordCount method
	 * increments the wordCount and notifies all the observers registered 
	 */
	public void incWordCount(){
		++wordCount;
		notifyObservers();
	}
	
	/**
	 * getLeft method
	 * @return left node
	 */
	public NodeI getLeft(){
		return left;
	}
	
	/**
	 * getRight method
	 * @return right node
	 */
	public NodeI getRight(){
		return right;
	}
	
	/**
	 * setRight method
	 * @param nodeIn
	 * set the link to right
	 */
	public void setRight(NodeI nodeIn){
		right = nodeIn;
	}
	
	/**
	 * setLeft method
	 * @param nodeIn
	 * set link to left
	 */
	public void setLeft(NodeI nodeIn){
		left = nodeIn;
	}

	
	/**
	 * registerObserver method 
	 * @param o
	 * add the observer in the list of subject
	 * @Override
	 */
	public void registerObserver(ObserverI o) {
		observers.add(o);
	}

	
	/**
	 * removeObserver method
	 * @param o
	 * remove the observer from the list if exists
	 * @Override
	 */
	public void removeObserver(ObserverI o) {
		 int i = observers.indexOf(o);
		 if (i >= 0) {
			 observers.remove(i);
		} 
	}

	
	/**
	 * notifyObservers method
	 * calls the update method on all the observers registered
	 * @Override
	 */
	public void notifyObservers() {
		DebugLevel db = DebugLevel.SUBJECT;
		Logger.getUniqueInstance();
		Logger.writeMessage("Subject notifying observers.",db);
		

		 for (int i = 0; i < observers.size(); i++) {
			 ObserverI obs = (ObserverI)observers.get(i);
			 obs.update(this.getWordCount());
		 }
	}

	
	/**
	 * update method 
	 * @param cntIn
	 * sets the wordCount
	 * @Override
	 */
	public void update(int cntIn) {
		DebugLevel db = DebugLevel.OBSERVER;
		Logger.getUniqueInstance();
		Logger.writeMessage("Observer being updated.",db);
		

		this.setWordCount(cntIn);
	}
	
	/**
	 * clone method
	 * @return Node
	 * makes the exact copy of this Node and returns
	 */
	public NodeI clone(){
		DebugLevel db = DebugLevel.CLONE;
		Logger.getUniqueInstance();
		Logger.writeMessage("Node being cloned.",db);
		

		NodeI n= new Node(this.getWord());
		n.setWordCount(this.getWordCount());
		this.registerObserver((ObserverI) n);
		return n;
	}
}
