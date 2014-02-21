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
	private HeapNode childNode1;
	private HeapNode childNode2;
	
	/**
	 * Creates a HeapNode object with a value
	 * 
	 * @param value	The value of this new node
	 */
	public HeapNode(String value) {
		nodeValue = value;
	}
	
	private void setNodeValue(String value) {
		nodeValue = value;
	}
	
	private String getNodeValue() {
		return nodeValue;
	}
	
	private void setChildNode1(HeapNode newChildNode1) {
		childNode1 = newChildNode1;
	}
	
	private HeapNode getChildNode1() {
		return childNode1;
	}
	
	private void setChildNode2(HeapNode newChildNode2) {
		childNode2 = newChildNode2;
	}
	
	private HeapNode getChildNode2() {
		return childNode2;
	}
	
	/**
	 * Return maximum number of levels from this node down
	 * through its children.
	 * 
	 * @return	The integer representation of this heap's height
	 */
	public int getHeapHeight() {
		int child1Height, child2Height;

		try {
			child1Height = getChildNode1().getHeapHeight();
		} catch (NullPointerException e) {
			child1Height = 0;
		}
		
		try {
			child2Height = getChildNode2().getHeapHeight();
		} catch (NullPointerException e) {
			child2Height = 0;
		}
		
		//Add one to height for recursive call
		return ((child1Height >= child2Height) ? child1Height : child2Height) + 1;
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
			if (getChildNode1().getHeapHeight() <= getChildNode2().getHeapHeight()) {
				getChildNode1().insertNode(insertValue);
			} else {
				getChildNode2().insertNode(insertValue);
			}
		} catch (NullPointerException e) {
			//If we are at the bottom of a heap, insertValue becomes new leaf node
			HeapNode newNode = new HeapNode(insertValue);
			
			if (getChildNode1() == null) {
				setChildNode1(newNode);
			} else {
				setChildNode2(newNode);
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
			preorderString += " " + getChildNode1().printHeapInPreorderMatchingRegex(regexToPrint);
		} catch (NullPointerException e) {
			//This node does not have a childNode1. There is nothing to print.
		}
		
		try {
			preorderString += " " + getChildNode2().printHeapInPreorderMatchingRegex(regexToPrint);
		} catch (NullPointerException e) {
			//This node does not have a childNode2. There is nothing to print.
		}
		
		return preorderString.trim();
	}
}
