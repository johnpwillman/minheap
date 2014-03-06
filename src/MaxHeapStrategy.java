import java.text.Collator;

/**
 * Description
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
