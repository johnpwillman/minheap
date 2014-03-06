import java.util.AbstractCollection;
import java.util.Iterator;

/**
 * Description
 * 
 * @author John Willman,
 * RedID: 809362691
 *
 */
public abstract class Heap extends AbstractCollection<String> {
	
	public abstract Iterator<String> iterator();
	
	public abstract int size();
	
	public abstract String[] toArray();
	
	public abstract boolean add(String newHeapValue);
	
	public abstract String toString();
}
