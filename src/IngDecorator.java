import java.util.Iterator;

/**
 * IngDecorator is a decorator extending the HeapDecorator class
 * which modifies the functionality of a ConcreteHeap to deal only
 * with words ending in "ing". It does this by replacing the 
 * standard iterator implementation in ConcreteHeap with an
 * IngFilter iterator.
 * 
 * @author John Willman,
 * RedID: 809362691
 *
 */
public class IngDecorator extends HeapDecorator {
	
	Iterator<String> ingIterator;
	
	public IngDecorator(ConcreteHeap heapToDecorate) {
		super(heapToDecorate);
	}
	
	/**
	 * Returns an iterator over the collection that only deals with
	 * words ending in 'ing' in the structure.
	 */
	@Override
	public Iterator<String> iterator() {
		return new IngFilter(super.iterator());
	}
	
	/**
	 * Returns the number of words ending in 'ing' in the collection.
	 */
	@Override
	public int size() {
		int size = 0;
		
		ingIterator = iterator();
		
		while (ingIterator.hasNext()) {
			ingIterator.next();
			size++;
		}
		
		return size;
	}

	/**
	 * Returns a String Array with an element for each word in the
	 * collection ending in 'ing'.
	 */
	@Override
	public String[] toArray() {
		String[] sArray = new String[size()];
		int index = 0;
		
		ingIterator = iterator();
		
		while (ingIterator.hasNext()) {
			sArray[index] = ingIterator.next();
			index++;
		}
		
		return sArray;
	}

	/**
	 * Returns the string representation of all of the words in the
	 * collection which end in 'ing'.
	 */
	@Override
	public String toString() {
		String heapIngString = "";
		
		ingIterator = iterator();
		
		while (ingIterator.hasNext()) {
			heapIngString += "["+ ingIterator.next() + "] ";
		}
		
		return heapIngString.trim();
	}

}
