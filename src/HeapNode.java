
/**
 * HeapNode is the abstract definition of Node objects used to
 * implement the Heap objects for Assignment 2. 
 * 
 * @author John Willman,
 * RedID: 809362691
 *
 */
public abstract class HeapNode {
	
	public HeapNode() {
	}
	
	public abstract boolean isNull();
	
	public abstract HeapNode getLeftChild();
	
	public abstract HeapNode getRightChild();
	
	public abstract String getNodeValue();
	
	public abstract void setHeapStrategy(HeapStrategy strategy);
	
	public abstract int getHeapHeight();
	
	public abstract int getHeapSize();
	
	public abstract HeapNode add(String insertValue);
	
	public abstract String toString();
}
