package wordCount.observers;

/**
 * 
 * SubjectI interface
 * @author Smurfette
 *
 */
public interface SubjectI {
	/**
	 * registerObserver method
	 * @param o
	 */
	public void registerObserver(ObserverI o);
	
	/**
	 * removeObserver method
	 * @param o
	 */
	public void removeObserver(ObserverI o);
	
	/**
	 * notifyObservers method
	 */
	public void notifyObservers();
}
