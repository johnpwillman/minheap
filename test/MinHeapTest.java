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
		ConcreteHeap mh = new ConcreteHeap();
		
		assertTrue(
			"Heap should have no nodes and be null",
			mh.toString().equals("[null]")
		);
	}

	@Test
	public void testMinHeapString() {
		ConcreteHeap mh = new ConcreteHeap();
		mh.add("test string");
		
		assertTrue(
			"Heap should have one node: [test string]",
			mh.toString().equals("[test string]")
		);
	}

	@Test
	public void testInsert() {
		ConcreteHeap mh = new ConcreteHeap();
		
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
		ConcreteHeap mh = new ConcreteHeap();
		
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
	public void testPrintHeapStringsEndingInIngInPreOrder() {
		ConcreteHeap mh = new ConcreteHeap();
		
		mh.add("run");
		mh.add("runner");
		mh.add("running");
		mh.add("runnings");
		mh.add("swimming");
		mh.add("swimmer");
		
		assertTrue(
			"Method return should only print heap nodes that end in 'ing':"
			+ "[running] [swimming]",
			mh.toString().equals("[running] [swimming]")
		);
	}

}
