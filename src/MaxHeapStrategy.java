import java.text.Collator;

/**
 * MaxHeapStrategy is an implementation of HeapStrategy that causes a Heap
 * object to insert values from top to bottom and only swapping values when
 * the new value is greater than the current value of the position in
 * context.
 * 
 * @author John Willman,
 * RedID: 809362691
 *
 */
public class MaxHeapStrategy implements HeapStrategy {

	@Override
	public boolean valueShouldSwap(String currentValue, String newValue) {
		Collator nodeCollator = Collator.getInstance();
		
		if (nodeCollator.compare(newValue, currentValue) > 0) {
			return true;
		}
		return false;
	}

}
