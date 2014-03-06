import java.util.Iterator;

/**
 * Description
 * 
 * @author John Willman,
 * RedID: 809362691
 *
 */
public class ConcreteHeap extends Heap {
	
	private HeapNode rootNode = new NullHeapNode();
	
	private HeapStrategy heapStrat = new MinHeapStrategy();//Heap is a MinHeap by default
	
	/**
	 * Instantiates an empty Heap object
	 */
	public ConcreteHeap() {
		rootNode.setHeapStrategy(heapStrat);
	}

	/**
	 * Create a Heap that operates according to the given strategy.
	 * 
	 * @param strategy
	 */
	public ConcreteHeap(HeapStrategy strategy) {
		rootNode.setHeapStrategy(strategy);
	}
	
	/**
	 * Returns an Iterator for this Heap Collection.
	 * Iterator is of String type.
	 */
	@Override
	public Iterator<String> iterator() {
		Iterator<String> itr = new HeapIterator(getRootNode());
		return itr;
	}

	/**
	 * Return the current number of items contained in this Heap Collection.
	 */
	@Override
	public int size() {
		return getRootNode().getHeapSize();
	}

	/**
	 * Returns a String array containing this Heap Collections items.
	 */
	@Override
	public String[] toArray() {
		String[] heapArray = new String[size()];
		int i = 0;
		
		Iterator<String> heapItr = this.iterator();
		
		while(heapItr.hasNext()) {
			heapArray[i] = heapItr.next();
			i++;
		}
		
		return heapArray;
	}

	/**
	 * Adds a new String value to the Heap. Returns false if add fails.
	 */
	@Override
	public boolean add(String newHeapValue) {
		try {
			rootNode = getRootNode().add(newHeapValue);
		} catch (Exception e) {
			return false;
		}
		
		return true;
	}

	/**
	 * Returns a String representation of the Heap Collection's values.
	 */
	@Override
	public String toString() {
		return getRootNode().toString();
	}
	
	private HeapNode getRootNode() {
		return rootNode;
	}
	
}
