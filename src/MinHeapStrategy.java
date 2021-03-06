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

	/**
	 * Method will analyze the current value of a node as well as the
	 * proposed value and return true if the proposed value should be
	 * swapped with the current value.
	 * 
	 * Criteria for true: new value comes alphabetically prior to the
	 * current value.
	 * 
	 * @param currentValue
	 * @param newValue
	 * @return
	 */
	@Override
	public boolean valueShouldSwap(String currentValue, String newValue) {
		Collator nodeCollator = Collator.getInstance();
		
		if (nodeCollator.compare(newValue, currentValue) <= 0) {
			return true;
		}
		return false;
	}

}
