import java.util.Iterator;


public class HeapDecorator extends Heap {
	
	private ConcreteHeap decoratedHeap;
	
	public HeapDecorator(ConcreteHeap heapToDecorate) {
		decoratedHeap = heapToDecorate;
	}

	@Override
	public Iterator<String> iterator() {
		return decoratedHeap.iterator();
	}

	@Override
	public int size() {
		return decoratedHeap.size();
	}

	@Override
	public String[] toArray() {
		return decoratedHeap.toArray();
	}

	@Override
	public boolean add(String newHeapValue) {
		return decoratedHeap.add(newHeapValue);
	}

	@Override
	public String toString() {
		return decoratedHeap.toString();
	}

}
