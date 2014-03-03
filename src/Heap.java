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
public class Heap extends AbstractCollection<Object>{
	
	private HeapNode rootNode;
	
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
		insert(heapRootValue);
	}
	
	/* (non-Javadoc)
	 * @see java.util.AbstractCollection#iterator()
	 */
	@Override
	public Iterator<Object> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see java.util.AbstractCollection#size()
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see java.util.AbstractCollection#toArray()
	 */
	@Override
	public String[] toArray() {
		// TODO Auto-generated method stub
		return super.toArray(new String[0]);
	}

	/* (non-Javadoc)
	 * @see java.util.AbstractCollection#add(java.lang.Object)
	 */
	public boolean add(String e) {
		// TODO Auto-generated method stub
		return super.add(e);
	}

	/* (non-Javadoc)
	 * @see java.util.AbstractCollection#toString()
	 */
	@Override
	public String toString() {
		try {
			return getRootNode().printHeapInPreorderMatchingRegex(".*");
		} catch (NullPointerException e) {
			return "[null]";
		}
	}

	/**
	 * Insert a new node of value newHeapValue into the MinHeap.
	 * 
	 * @param newHeapValue	The value of the new desired node.
	 */
	public void insert(String newHeapValue) {
		try {
			getRootNode().insertNode(newHeapValue);
		} catch (NullPointerException e) {
			rootNode = new HeapNode(newHeapValue);
		}
	}
	
	private HeapNode getRootNode() {
		return rootNode;
	}
	
}
