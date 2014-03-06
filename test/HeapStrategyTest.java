import static org.junit.Assert.*;

import org.junit.Test;


public class HeapStrategyTest {

	@Test
	public void testMinHeapStrategy() {
		Heap mh = new ConcreteHeap(new MinHeapStrategy());
		
		mh.add("run");
		mh.add("runner");
		mh.add("running");
		mh.add("runnings");
		mh.add("swimming");
		mh.add("swimmer");
		
		assertTrue(
			"Method return should print all heap nodes in preorder: "
			+ "[run] [runner] [runnings] [swimmer] [running] [swimming]",
			mh.toString().equals(
				"[run] [runner] [runnings] [swimmer] [running] [swimming]"
			)
		);
	}

	@Test
	public void testMaxHeapStrategy() {
		Heap mh = new ConcreteHeap(new MaxHeapStrategy());
		
		mh.add("run");
		mh.add("runner");
		mh.add("running");
		mh.add("runnings");
		mh.add("swimming");
		mh.add("swimmer");
		
		System.out.println(mh.toString());
		
		assertTrue(
			"Method return should print all heap nodes in preorder: "
			+ "[swimming] [swimmer] [run] [running] [runnings] [runner]",
			mh.toString().equals(
				"[swimming] [swimmer] [run] [running] [runnings] [runner]"
			)
		);
	}

}
