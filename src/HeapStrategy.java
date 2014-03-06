/**
 * HeapStrategy is an interface describing the single method used by
 * all implementing HeapStrategies for changing how the Heap adds
 * values.
 * 
 * @author John Willman,
 * RedID: 809362691
 *
 */
public interface HeapStrategy {
	/**
	 * Method will analyze the current value of a node as well as the
	 * proposed value and return true if the proposed value should be
	 * swapped with the current value.
	 * @param currentValue
	 * @param newValue
	 * @return
	 */
	public boolean valueShouldSwap(String currentValue, String newValue);
}
