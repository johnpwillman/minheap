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
	
	public Iterator<String> iterator() {
		return new IngFilter(super.iterator());
	}
	
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

	@Override
	public String[] toArray() {
		String[] sArray = new String[size()];
		int index = 0;
		
		ingIterator = iterator();
		
		while (ingIterator.hasNext()) {
			sArray[index] = ingIterator.next();
		}
		
		return sArray;
	}

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
