

public abstract class HeapNode {
	
	public HeapNode() {
	}
	
	public abstract boolean isNull();
	
	public abstract int getHeapHeight();
	
	public abstract HeapNode insertNode(String insertValue);
	
	public abstract String printHeapInPreorderMatchingRegex(String regexToPrint);
}
