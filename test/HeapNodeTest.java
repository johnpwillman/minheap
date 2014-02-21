import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test methods for HeapNode.java class
 * 
 * @author John Willman
 *
 */
public class HeapNodeTest {

	@Test
	public void testHeapNode() {
		HeapNode hn = new HeapNode("testHeapNode");
		
		assertTrue(
			"Heap should be equal to [testHeapNode]",
			hn.printHeapInPreorderMatchingRegex(".*").equals("[testHeapNode]")
		);
	}

	@Test
	public void testGetHeapHeight() {
		HeapNode hn = new HeapNode("testGetHeapHeight");
		
		assertEquals("Height should be 1 on node creation", hn.getHeapHeight(), 1);
		
		hn.insertNode("SecondInsert");

		assertEquals("Height should be 2 after second insert", hn.getHeapHeight(), 2);
		
		hn.insertNode("ThirdInsert");
		
		assertEquals("Height should still be 2 after third insert", hn.getHeapHeight(), 2);
		
		hn.insertNode("FourthInsert");
		
		assertEquals("Height should be 3 after fourth insert", hn.getHeapHeight(), 3);
	}

	@Test
	public void testInsertNode() {
		HeapNode hn = new HeapNode("testInsertNode");
		
		assertTrue(
			"Heap should be equal to [testInsertNode]",
			hn.printHeapInPreorderMatchingRegex(".*").equals("[testInsertNode]")
		);
		
		hn.insertNode("b");
		
		assertTrue(
			"Heap should be equal to [b] [testInsertNode]",
			hn.printHeapInPreorderMatchingRegex(".*").equals("[b] [testInsertNode]")
		);
		
		hn.insertNode("c");
		
		assertTrue(
			"Heap should be equal to [b] [testInsertNode] [c]",
			hn.printHeapInPreorderMatchingRegex(".*").equals("[b] [testInsertNode] [c]")
		);
		
		hn.insertNode("z");
		
		assertTrue(
			"Heap should be equal to [b] [testInsertNode] [z] [c]",
			hn.printHeapInPreorderMatchingRegex(".*").equals("[b] [testInsertNode] [z] [c]")
		);
		
		hn.insertNode("a");
		
		assertTrue(
			"Heap should be equal to [a] [testInsertNode] [z] [b] [c]",
			hn.printHeapInPreorderMatchingRegex(".*").equals("[a] [testInsertNode] [z] [b] [c]")
		);
	}

	@Test
	public void testPrintHeapInPreorderMatchingRegex() {
		HeapNode hn = new HeapNode("lorem");
		
		hn.insertNode("ipsum");
		hn.insertNode("dolor");
		hn.insertNode("sit");
		hn.insertNode("amet");
		
		assertTrue(
			"Heap should be equal to [amet] [lorem] [sit] [dolor] [ipsum] (all words)",
			hn.printHeapInPreorderMatchingRegex(".*").equals("[amet] [lorem] [sit] [dolor] [ipsum]")
		);
		
		assertTrue(
			"Heap should be equal to [lorem] [dolor] (only words with 'r')",
			hn.printHeapInPreorderMatchingRegex(".*r.*").equals("[lorem] [dolor]")
		);
		
		assertTrue(
			"Heap should be equal to [sit] (only words beginnning with 's')",
			hn.printHeapInPreorderMatchingRegex("s.*").equals("[sit]")
		);
	}

}
