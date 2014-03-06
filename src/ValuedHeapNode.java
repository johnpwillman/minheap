
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
	
	public HeapNode getLeftChild() {
		return leftChild;
	}
	
	public HeapNode getRightChild() {
		return rightChild;
	}
	
	public String getNodeValue() {
		return nodeValue;
	}
	
	public void setHeapStrategy(HeapStrategy strategy) {
		heapStrat = strategy;
		getLeftChild().setHeapStrategy(heapStrat);
		getRightChild().setHeapStrategy(heapStrat);
	}
	
	/**
	 * Return maximum number of levels from this node down
	 * through its children.
	 * 
	 * @return	The integer representation of this heap's height
	 */
	public int getHeapHeight() {
		int leftChildHeight, rightChildHeight;

		leftChildHeight = getLeftChild().getHeapHeight();
		
		rightChildHeight = getRightChild().getHeapHeight();
		
		//Add one to height for recursive call
		return ((leftChildHeight >= rightChildHeight) ? leftChildHeight : rightChildHeight) + 1;
	}

	@Override
	public int getHeapSize() {
		return 1 + getLeftChild().getHeapSize() + getRightChild().getHeapSize();
	}
	
	/**
	 * Insert a node at this HeapNode's position on the heap.
	 * If, this node-to-insert's value is less than the value of this
	 * node, the node-to-insert replaces the current node and the
	 * current node is inserted to the child heap of least height.
	 * 
	 * @param insertValue	Value of the node being inserted.
	 */
	public HeapNode add(String insertValue) {
		HeapNode nodeAfterInsert;
		
		String valueSwap;
		
		//The Collator compares strings in true alphabetical, rather than lexicographical, order
		if (heapStrat.valueShouldSwap(getNodeValue(), insertValue)) {
			valueSwap = getNodeValue();
			setNodeValue(insertValue);
			insertValue = valueSwap;
		}
		
		if (getLeftChild().getHeapHeight() <= getRightChild().getHeapHeight()) {
			nodeAfterInsert = getLeftChild().add(insertValue);
			setLeftChild(nodeAfterInsert);
		} else {
			nodeAfterInsert = getRightChild().add(insertValue);
			setRightChild(nodeAfterInsert);
		}
		
		return this;
	}

	@Override
	public String toString() {
		String formattedHeapString;
		
		formattedHeapString = "[" + getNodeValue() + "] " + getLeftChild().toString();
		formattedHeapString = formattedHeapString.trim() + " " + getRightChild().toString();
		formattedHeapString = formattedHeapString.trim();
		
		return formattedHeapString;
	}
}
