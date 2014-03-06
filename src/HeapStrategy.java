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
	public boolean valueShouldSwap(String currentValue, String newValue);
}
