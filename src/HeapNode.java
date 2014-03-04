

public abstract class HeapNode {
	
	public HeapNode() {
	}
	
	public abstract boolean isNull();
	
	public abstract HeapNode getLeftChild();
	
	public abstract HeapNode getRightChild();
	
	public abstract String getNodeValue();
	
	public abstract int getHeapHeight();
	
	public abstract int getHeapSize();
	
	public abstract HeapNode add(String insertValue);
	
	public abstract String getHeapValuesMatchingRegex(String regexToPrint);
	
	public abstract String toString();
}
