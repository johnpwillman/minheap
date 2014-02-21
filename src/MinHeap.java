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
public class MinHeap {
	
	private HeapNode rootNode;
	
	/**
	 * Instantiates an empty MinHeap object
	 */
	public MinHeap() {
		
	}
	
	/**
	 * Instantiates a MinHeap object with heapRootValue as the value of the root node.
	 * 
	 * @param heapRootValue	The desired value of the root node.
	 */
	public MinHeap(String heapRootValue) {
		insert(heapRootValue);
	}
	
	private HeapNode getRootNode() {
		return rootNode;
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
	
	/**
	 * Print out the values of nodes in this MinHeap in preorder.
	 * Format of output string is "[root] [preorderchild] [etc..]"
	 * 
	 * @return	The String of the preorder representation of this MinHeap
	 */
	public String printHeapStringsInPreOrder() {
		try {
			return getRootNode().printHeapInPreorderMatchingRegex(".*");
		} catch (NullPointerException e) {
			return "[null]";
		}
	}
	
	/**
	 * Print out the values of nodes in this Minheap that end in 'ing' in preorder.
	 * Format of output string is "[root] [preorderchild] [etc..]"
	 * 
	 * @return	The String of nodes whose values end in 'ing' in this MinHeap in preorder.
	 */
	public String printHeapStringsEndingInIngInPreOrder() {
		try {
			return getRootNode().printHeapInPreorderMatchingRegex(".*ing");
		} catch (NullPointerException e) {
			return "[null]";
		}
	}
	
}
