import java.util.Iterator;

/**
 * Description
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
