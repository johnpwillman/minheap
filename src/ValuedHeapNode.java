
/**
 * ValuedHeapNode is the main object that makes up the tree in
 * our implementation of a Heap. Each node is only aware of its
 * own value and the references to its children. Most of its
 * methods will recursively work their way through its children
 * and thus each node operates as its own sub-tree.
 * 
 * @author John Willman
 * RedID: 809362691
 *
 */
public class ValuedHeapNode extends HeapNode {
	
	private String nodeValue;
	private HeapNode leftChild = new NullHeapNode();
	private HeapNode rightChild = new NullHeapNode();
	
	private HeapStrategy heapStrat;
	
	public ValuedHeapNode() {
	}
	
	/**
	 * Creates a HeapNode object with a value
	 * 
	 * @param value	The value of this new node
	 */
	public ValuedHeapNode(String value) {
		nodeValue = value;
	}
	
	public boolean isNull() {
		return false;
	}
	
	private void setNodeValue(String value) {
		nodeValue = value;
	}
	
	private void setLeftChild(HeapNode newLeftChild) {
		leftChild = newLeftChild;
	}
	
	private void setRightChild(HeapNode newRightChild) {
		rightChild = newRightChild;
	}
	
	public HeapNode left() {
		return leftChild;
	}
	
	public HeapNode right() {
		return rightChild;
	}
	
	public String getValue() {
		return nodeValue;
	}
	
	/**
	 * Sets the strategy of node insertion as specified by the supplied
	 * HeapStrategy.
	 */
	public void setHeapStrategy(HeapStrategy strategy) {
		heapStrat = strategy;
		left().setHeapStrategy(heapStrat);
		right().setHeapStrategy(heapStrat);
	}
	
	/**
	 * Return maximum number of levels from this node down
	 * through its children.
	 * 
	 * @return	The integer representation of this heap's height
	 */
	public int height() {
		int leftChildHeight, rightChildHeight;

		leftChildHeight = left().height();
		
		rightChildHeight = right().height();
		
		//Add one to height for recursive call
		return ((leftChildHeight >= rightChildHeight) ? leftChildHeight : rightChildHeight) + 1;
	}

	/**
	 * Return the number of valued elements in the node (sub)tree where this
	 * node is the root.
	 */
	@Override
	public int size() {
		return 1 + left().size() + right().size();
	}
	
	/**
	 * Insert a node at this HeapNode's position on the heap.
	 * The node swap strategy is determined by the heap's
	 * current HeapStrategy.
	 * 
	 * @param insertValue	Value of the node being inserted.
	 */
	public HeapNode add(String insertValue) {
		HeapNode nodeAfterInsert;
		
		String valueSwap;
		
		if (heapStrat.valueShouldSwap(getValue(), insertValue)) {
			valueSwap = getValue();
			setNodeValue(insertValue);
			insertValue = valueSwap;
		}
		
		if (left().height() <= right().height()) {
			nodeAfterInsert = left().add(insertValue);
			setLeftChild(nodeAfterInsert);
		} else {
			nodeAfterInsert = right().add(insertValue);
			setRightChild(nodeAfterInsert);
		}
		
		return this;
	}

	/**
	 * Returns a preorder string representation of of this node and its
	 * subtrees.
	 */
	@Override
	public String toString() {
		String formattedHeapString;
		
		formattedHeapString = "[" + getValue() + "] " + left().toString();
		formattedHeapString = formattedHeapString.trim() + " " + right().toString();
		formattedHeapString = formattedHeapString.trim();
		
		return formattedHeapString;
	}
}
