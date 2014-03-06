import java.text.Collator;

/**
 * MinHeapStrategy is an implementation of HeapStrategy that causes a Heap
 * object to insert values from top to bottom and only swapping values when
 * the new value is lower than or equal to the current value of the
 * position in context.
 * 
 * @author John Willman,
 * RedID: 809362691
 *
 */
public class MinHeapStrategy implements HeapStrategy {

	@Override
	public boolean valueShouldSwap(String currentValue, String newValue) {
		Collator nodeCollator = Collator.getInstance();
		
		if (nodeCollator.compare(newValue, currentValue) <= 0) {
			return true;
		}
		return false;
	}

}
