import java.util.AbstractCollection;
import java.util.Iterator;


public abstract class Heap extends AbstractCollection<String> {
	
	public abstract Iterator<String> iterator();
	
	public abstract int size();
	
	public abstract String[] toArray();
	
	public abstract boolean add(String newHeapValue);
	
	public abstract String toString();
}
