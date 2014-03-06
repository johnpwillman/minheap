import java.util.Iterator;
import java.util.Stack;

/**
 * HeapIterator is the specific implementation of the Iterator pattern
 * used in these Heap Classes and sub-classes. It utilizes the 
 * underlying implementation of the Heap to create an iterator for the
 * Heap subclasses to return in accordance with the definition of a
 * collection.
 * 
 * @author John Willman,
 * RedID: 809362691
 *
 */
public class HeapIterator implements Iterator<String> {
	
	HeapNode topNode;
	Stack<HeapNode> traversalStack = new Stack<HeapNode>();
	
	/**
	 * Uses the root node of a heap to construct an iterator for the
	 * Collection specification in Java.
	 * @param rootNode
	 */
	public HeapIterator(HeapNode rootNode) {
		topNode = rootNode;
		
		traversalStack.push(topNode);
	}
	
	/**
	 * Returns true as long as there are items left in the Collection
	 * that have not been iterated over.
	 */
	@Override
	public boolean hasNext() {
		if (traversalStack.isEmpty()) {
			return false;
		}
		return true;
	}
	
	/**
	 * Returns the next unaccessed value in the Collection in
	 * preorder. Used in combination with hasNext() to loop
	 * over the entire collection safely.
	 */
	@Override
	public String next() {
		String returnValue = new String();
		
		if (!topNode.isNull()) {
			returnValue = topNode.getValue();
			if (!topNode.right().isNull()) {
				traversalStack.push(topNode.right());
			}
			if (!topNode.left().isNull()) {
				traversalStack.push(topNode.left());
			}
			topNode = traversalStack.peek();
			traversalStack.pop();
		}
		
		return returnValue;
	}
	
	/**
	 * NOT IMPLEMENTED
	 */
	@Override
	public void remove() {
		//Left Unimplemented
		
	}

}
