import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Description
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

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}
}
