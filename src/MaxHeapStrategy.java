import java.text.Collator;


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
