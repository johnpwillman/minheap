import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * IngFilter is a filter over a normal String Iterator which operates
 * as though the normal iterator only contained its words ending in 
 * "ing". All other functionality is the same.
 * 
 * @author John Willman,
 * RedID: 809362691
 *
 */
public class IngFilter implements Iterator<String> {
	
	Iterator<String> ingItr;
	String nextIng = "";

	public IngFilter(Iterator<String> input) {
		ingItr = input;
	}
	
	/**
	 * Returns true as long as there are items left in the Collection
	 * that end in 'ing' that have not been iterated over.
	 */
	public boolean hasNext() {
		String testString = "";
		
		while (ingItr.hasNext() && nextIng.isEmpty()) {
			testString = ingItr.next();
			if (testString.toLowerCase().endsWith("ing")) {
				nextIng = testString;
			}
		}
		
		if (!nextIng.isEmpty()) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * Returns the next unaccessed value in the Collection ending
	 * in 'ing' in preorder. Used in combination with hasNext() to
	 * loop over the entire collection safely.
	 */
	public String next() {
		String returnValue;

		if (hasNext()) {
			returnValue = nextIng;
			nextIng = "";
		} else {
			throw new NoSuchElementException();
		}
		
		return returnValue;
	}

	/**
	 * NOT IMPLEMENTED
	 */
	@Override
	public void remove() {
		// Left Unimplemented
		
	}
}
