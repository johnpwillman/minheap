import java.util.Iterator;

/**
 * HeapDecorator is an implementation of the abstract Heap collection
 * definition but which operates on the Decorator Design Pattern. It
 * is instantiated by creating an instance of ConcreteHeap and using
 * that to implement its methods. It's main purpose is to serve as a
 * parent class for other decorators that tweak the implementation of
 * ConcreteHeap in some way.
 * 
 * @author John Willman,
 * RedID: 809362691
 *
 */
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
