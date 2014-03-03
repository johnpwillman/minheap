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
		Heap mh = new Heap();
		
		assertTrue(
			"Heap should have no nodes and be null",
			mh.printHeapStringsInPreOrder().equals("[null]")
		);
	}

	@Test
	public void testMinHeapString() {
		Heap mh = new Heap("test string");
		
		assertTrue(
			"Heap should have one node: [test string]",
			mh.printHeapStringsInPreOrder().equals("[test string]")
		);
	}

	@Test
	public void testInsert() {
		Heap mh = new Heap();
		
		mh.insert("single insert");
		
		assertTrue(
			"Heap should have one node: [single insert]",
			mh.printHeapStringsInPreOrder().equals("[single insert]")
		);
		
		mh.insert("random insert");
		
		assertTrue(
			"Heap should have two nodes: [random insert] [single insert]",
			mh.printHeapStringsInPreOrder().equals("[random insert] [single insert]")
		);
	}

	@Test
	public void testPrintHeapStringsInPreOrder() {
		Heap mh = new Heap();
		
		mh.insert("run");
		mh.insert("runner");
		mh.insert("running");
		mh.insert("runnings");
		mh.insert("swimming");
		mh.insert("swimmer");
		
		assertTrue(
			"Method return should print all heap nodes in preorder: "
			+ "[run] [runner] [runnings] [swimmer] [running] [swimming]",
			mh.printHeapStringsInPreOrder().equals(
				"[run] [runner] [runnings] [swimmer] [running] [swimming]"
			)
		);
	}

	@Test
	public void testPrintHeapStringsEndingInIngInPreOrder() {
		Heap mh = new Heap();
		
		mh.insert("run");
		mh.insert("runner");
		mh.insert("running");
		mh.insert("runnings");
		mh.insert("swimming");
		mh.insert("swimmer");
		
		assertTrue(
			"Method return should only print heap nodes that end in 'ing':"
			+ "[running] [swimming]",
			mh.printHeapStringsEndingInIngInPreOrder().equals("[running] [swimming]")
		);
	}

}
