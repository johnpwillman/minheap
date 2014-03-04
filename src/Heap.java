import java.util.AbstractCollection;
import java.util.Iterator;

/**
 * The MinHeap class implements a Min-Heap data structure of Strings where root has the
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
	 * Instantiates an empty MinHeap object
	 */
	public Heap() {
		
	}
	
	/**
	 * Instantiates a MinHeap object with heapRootValue as the value of the root node.
	 * 
	 * @param heapRootValue	The desired value of the root node.
	 */
	public Heap(String heapRootValue) {
		add(heapRootValue);
	}
	
	/* (non-Javadoc)
	 * @see java.util.AbstractCollection#iterator()
	 */
	@Override
	public Iterator<String> iterator() {
		Iterator<String> itr = (Iterator<String>) new HeapIterator(getRootNode());
		return itr;
	}

	/**
	 * 
	 */
	@Override
	public int size() {
		return getRootNode().getHeapSize();
	}

	/* (non-Javadoc)
	 * @see java.util.AbstractCollection#toArray()
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

	/* (non-Javadoc)
	 * @see java.util.AbstractCollection#add(java.lang.Object)
	 */
	public boolean add(String newHeapValue) {
		// TODO Return false if add was unsuccessful
		rootNode = getRootNode().insertNode(newHeapValue);
		return true;
	}

	/* (non-Javadoc)
	 * @see java.util.AbstractCollection#toString()
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
