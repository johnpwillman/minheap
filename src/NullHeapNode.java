
public class NullHeapNode extends HeapNode {

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
		return vhn;
	}

	@Override
	public String getHeapValuesMatchingRegex(String regexToPrint) {
		return "";
	}

	@Override
	public String toString() {
		return "";
	}

}
