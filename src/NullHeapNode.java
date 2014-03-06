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

	/**
	 * Null nodes do not have children, so return this null node.
	 */
	@Override
	public HeapNode left() {
		return this;
	}

	/**
	 * Null nodes do not have children, so return this null node.
	 */
	@Override
	public HeapNode right() {
		return this;
	}

	/**
	 * Null nodes do not have value so this returns the empty string.
	 */
	@Override
	public String getValue() {
		return "";
	}
	
	/**
	 * Sets the HeapStrategy for when add is called and a new node
	 * needs the HeapStrategy of the structure.
	 */
	public void setHeapStrategy(HeapStrategy strategy) {
		heapStrat = strategy;
	}

	/**
	 * Height is always zero for null nodes.
	 */
	@Override
	public int height() {
		return 0;
	}

	/**
	 * Size is always zero for null nodes.
	 */
	@Override
	public int size() {
		return 0;
	}

	/**
	 * When add is called, create a new HeapNode with a value and pass
	 * back for assignment as a child in place of this null node.
	 */
	@Override
	public HeapNode add(String insertValue) {
		ValuedHeapNode vhn = new ValuedHeapNode(insertValue);
		vhn.setHeapStrategy(heapStrat);
		return vhn;
	}

	/**
	 * Null nodes have no string value so method returns empty string.
	 */
	@Override
	public String toString() {
		return "";
	}

}
