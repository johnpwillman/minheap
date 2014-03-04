import java.util.AbstractCollection;
import java.util.Iterator;

/**
 * The Heap class implements a Heap data structure of Strings where root has the
 * smallest value in the heap and each node is smaller than all the values in the heaps
 * of its child nodes. Each node has a maximum of two children.
 * This implementation allows adding of nodes to the heap and printing of the heap's
 * nodes in preorder.
 * This implementation does not allow deletion of nodes.
 * 
 * @author John Willman,
 * RedID: 809362691
 *
 */
public class Heap extends AbstractCollection<String>{
	
	private HeapNode rootNode = new NullHeapNode();
	
	/**
	 * Instantiates an empty Heap object
	 */
	public Heap() {
		
	}
	
	/**
	 * Instantiates a Heap object with heapRootValue as the value of the root node.
	 * 
	 * @param heapRootValue	The desired value of the root node.
	 */
	public Heap(String heapRootValue) {
		add(heapRootValue);
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
	 * Adds a new String value to the Heap.
	 */
	@Override
	public boolean add(String newHeapValue) {
		// TODO Return false if add was unsuccessful
		rootNode = getRootNode().add(newHeapValue);
		return true;
	}

	/**
	 * Returns a String representation of the Heap Collection's values.
	 */
	@Override
	public String toString() {
		//return getRootNode().getHeapValuesMatchingRegex(".*");
		return getRootNode().toString();
	}
	
	private HeapNode getRootNode() {
		return rootNode;
	}
	
}
