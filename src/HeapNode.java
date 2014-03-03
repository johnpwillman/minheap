import java.text.Collator;

/**
 * This class creates nodes amenable to the definition of nodes in a Min-Heap
 * provided by Assignment #1. Each node has up to two child nodes of the same
 * type and all child nodes and their child nodes are of a value greater than
 * their parent.
 * 
 * @author John Willman
 * RedID: 809362691
 *
 */
public class HeapNode {
	
	private String nodeValue;
	private HeapNode leftChild;
	private HeapNode rightChild;
	
	/**
	 * Creates a HeapNode object with a value
	 * 
	 * @param value	The value of this new node
	 */
	public HeapNode(String value) {
		nodeValue = value;
	}
	
	public boolean isNull() {
		return false;
	}
	
	private void setNodeValue(String value) {
		nodeValue = value;
	}
	
	private String getNodeValue() {
		return nodeValue;
	}
	
	private void setLeftChild(HeapNode newLeftChild) {
		leftChild = newLeftChild;
	}
	
	private HeapNode getLeftChild() {
		return leftChild;
	}
	
	private void setRightChild(HeapNode newRightChild) {
		rightChild = newRightChild;
	}
	
	private HeapNode getRightChild() {
		return rightChild;
	}
	
	/**
	 * Return maximum number of levels from this node down
	 * through its children.
	 * 
	 * @return	The integer representation of this heap's height
	 */
	public int getHeapHeight() {
		int leftChildHeight, rightChildHeight;

		try {
			leftChildHeight = getLeftChild().getHeapHeight();
		} catch (NullPointerException e) {
			leftChildHeight = 0;
		}
		
		try {
			rightChildHeight = getRightChild().getHeapHeight();
		} catch (NullPointerException e) {
			rightChildHeight = 0;
		}
		
		//Add one to height for recursive call
		return ((leftChildHeight >= rightChildHeight) ? leftChildHeight : rightChildHeight) + 1;
	}
	
	/**
	 * Insert a node at this HeapNode's position on the heap.
	 * If, this node-to-insert's value is less than the value of this
	 * node, the node-to-insert replaces the current node and the
	 * current node is inserted to the child heap of least height.
	 * 
	 * @param insertValue	Value of the node being inserted.
	 */
	public void insertNode(String insertValue) {
		Collator nodeCollator = Collator.getInstance();
		
		String valueSwap;
		
		//The Collator compares strings in true alphabetical, rather than lexicographical, order
		if (nodeCollator.compare(insertValue, getNodeValue()) <= 0) {
			valueSwap = getNodeValue();
			setNodeValue(insertValue);
			insertValue = valueSwap;
		}
		
		try {
			if (getLeftChild().getHeapHeight() <= getRightChild().getHeapHeight()) {
				getLeftChild().insertNode(insertValue);
			} else {
				getRightChild().insertNode(insertValue);
			}
		} catch (NullPointerException e) {
			//If we are at the bottom of a heap, insertValue becomes new leaf node
			HeapNode newNode = new HeapNode(insertValue);
			
			if (getLeftChild() == null) {
				setLeftChild(newNode);
			} else {
				setRightChild(newNode);
			}
		}
	}
	
	/**
	 * Prints out the values of the heap, matching the input REGEX, in preorder.
	 * 
	 * @param regexToPrint	REGEX that is used to choose nodes for printing.
	 * @return				The Preorder list of nodes in this node's heap matching the REGEX
	 */
	public String printHeapInPreorderMatchingRegex(String regexToPrint) {
		String preorderString = new String("");
		
		if (getNodeValue().matches(regexToPrint)) {
			preorderString += "[" + getNodeValue() + "]";
		}
		
		try {
			preorderString += " " + getLeftChild().printHeapInPreorderMatchingRegex(regexToPrint);
		} catch (NullPointerException e) {
			//This node does not have a childNode1. There is nothing to print.
		}
		
		try {
			preorderString += " " + getRightChild().printHeapInPreorderMatchingRegex(regexToPrint);
		} catch (NullPointerException e) {
			//This node does not have a childNode2. There is nothing to print.
		}
		
		return preorderString.trim();
	}
}
