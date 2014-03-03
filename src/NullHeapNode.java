
public class NullHeapNode extends HeapNode {

	@Override
	public boolean isNull() {
		return true;
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
	public HeapNode insertNode(String insertValue) {
		ValuedHeapNode vhn = new ValuedHeapNode(insertValue);
		return vhn;
	}

	@Override
	public String getHeapValuesMatchingRegex(String regexToPrint) {
		return "";
	}

}
