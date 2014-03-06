import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test methods for MinHeap.java class
 * 
 * @author John Willman
 *
 */
public class MinHeapTest {

	@Test
	public void testMinHeap() {
		Heap mh = new ConcreteHeap();
		
		assertTrue(
			"Heap should have no nodes and be empty",
			mh.toString().equals("")
		);
	}

	@Test
	public void testMinHeapString() {
		Heap mh = new ConcreteHeap();
		mh.add("test string");
		
		assertTrue(
			"Heap should have one node: [test string]",
			mh.toString().equals("[test string]")
		);
	}

	@Test
	public void testInsert() {
		Heap mh = new ConcreteHeap();
		
		mh.add("single insert");
		
		assertTrue(
			"Heap should have one node: [single insert]",
			mh.toString().equals("[single insert]")
		);
		
		mh.add("random insert");
		
		assertTrue(
			"Heap should have two nodes: [random insert] [single insert]",
			mh.toString().equals("[random insert] [single insert]")
		);
	}

	@Test
	public void testPrintHeapStringsInPreOrder() {
		Heap mh = new ConcreteHeap();
		
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

}
