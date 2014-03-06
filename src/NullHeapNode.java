/**
 * NullHeapNode extends the functions defined in HeapNode in 
 * a such a way as to implement the Null Object Pattern. The
 * methods anticipate the context in which a ValuedHeapNode
 * would call them and returns values which prevent the need
 * for null-checks in the calling object.
 * 
 * @author John Willman,
 * RedID: 809362691
 *
 */
public class NullHeapNode extends HeapNode {
	
	private HeapStrategy heapStrat;

	@Override
	public boolean isNull() {
		return true;
	}

	@Override
	public HeapNode getLeftChild() {
		return this;
	}

	@Override
	public HeapNode getRightChild() {
		return this;
	}

	@Override
	public String getNodeValue() {
		return "";
	}
	
	public void setHeapStrategy(HeapStrategy strategy) {
		heapStrat = strategy;
	}

	@Override
	public int getHeapHeight() {
		return 0;
	}

	@Override
	public int getHeapSize() {
		return 0;
	}

	@Override
	public HeapNode add(String insertValue) {
		ValuedHeapNode vhn = new ValuedHeapNode(insertValue);
		vhn.setHeapStrategy(heapStrat);
		return vhn;
	}

	@Override
	public String toString() {
		return "";
	}

}
