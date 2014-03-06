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
	
	public HeapIterator(HeapNode rootNode) {
		topNode = rootNode;
		
		traversalStack.push(topNode);
	}

	@Override
	public boolean hasNext() {
		if (traversalStack.isEmpty()) {
			return false;
		}
		return true;
	}

	@Override
	public String next() {
		String returnValue = new String();
		
		if (!topNode.isNull()) {
			returnValue = topNode.getNodeValue();
			if (!topNode.getRightChild().isNull()) {
				traversalStack.push(topNode.getRightChild());
			}
			if (!topNode.getLeftChild().isNull()) {
				traversalStack.push(topNode.getLeftChild());
			}
			topNode = traversalStack.peek();
			traversalStack.pop();
		}
		
		return returnValue;
	}

	@Override
	public void remove() {
		//Left Unimplemented
		
	}

}
