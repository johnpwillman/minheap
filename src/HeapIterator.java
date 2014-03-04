import java.util.Iterator;
import java.util.Stack;


public class HeapIterator implements Iterator<String> {
	
	HeapNode topNode;
	int numberIterated, size;
	Stack<HeapNode> traversalStack = new Stack<HeapNode>();
	
	public HeapIterator(HeapNode rootNode) {
		topNode = rootNode;
		numberIterated = 0;
		size = topNode.getHeapSize();
		
		traversalStack.push(topNode);
	}

	@Override
	public boolean hasNext() {
		if (numberIterated < size) {
			return true;
		}
		return false;
	}

	@Override
	public String next() {
		String returnValue = new String();
		
		if (!topNode.isNull()) {
			returnValue = topNode.getNodeValue();
			numberIterated++;
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
