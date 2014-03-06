import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test methods for HeapNode classes
 * 
 * @author John Willman
 *
 */
public class HeapNodeTest {

	@Test
	public void testValuedHeapNode() {
		HeapNode hn = new ValuedHeapNode("testHeapNode");
		
		assertTrue(
			"Heap should be equal to [testHeapNode]",
			hn.toString().equals("[testHeapNode]")
		);
	}

	@Test
	public void testGetHeapHeight() {
		HeapNode hn = new ValuedHeapNode("testGetHeapHeight");
		hn.setHeapStrategy(new MinHeapStrategy());
		HeapNode nn = new NullHeapNode();
		//nn.setHeapStrategy(new MinHeapStrategy());
		
		assertEquals("Height should be 1 on node creation", hn.height(), 1);
		
		hn.add("SecondInsert");

		assertEquals("Height should be 2 after second insert", hn.height(), 2);
		
		hn.add("ThirdInsert");
		
		assertEquals("Height should still be 2 after third insert", hn.height(), 2);
		
		hn.add("FourthInsert");
		
		assertEquals("Height should be 3 after fourth insert", hn.height(), 3);
		
		
		assertEquals("Height should be 0 for null node", nn.height(), 0);
	}
	
	@Test
	public void testGetHeapSize() {
		HeapNode hn = new ValuedHeapNode("testGetHeapHeight");
		hn.setHeapStrategy(new MinHeapStrategy());
		HeapNode nn = new NullHeapNode();
		
		assertEquals("Size should be 1 on node creation", hn.size(), 1);
		
		hn.add("SecondInsert");

		assertEquals("Size should be 2 after second insert", hn.size(), 2);
		
		hn.add("ThirdInsert");
		
		assertEquals("Size should be 3 after third insert", hn.size(), 3);
		
		hn.add("FourthInsert");

		assertEquals("Height should be 4 after fourth insert", hn.size(), 4);

		assertEquals("Height should be 0 for null node", nn.size(), 0);
	}

	@Test
	public void testAddNode() {
		HeapNode hn = new ValuedHeapNode("testInsertNode");
		hn.setHeapStrategy(new MinHeapStrategy());
		HeapNode nn = new NullHeapNode();
		nn.setHeapStrategy(new MinHeapStrategy());
		
		assertTrue(
			"Heap should be equal to [testInsertNode]",
			hn.toString().equals("[testInsertNode]")
		);
		
		hn.add("b");
		
		assertTrue(
			"Heap should be equal to [b] [testInsertNode]",
			hn.toString().equals("[b] [testInsertNode]")
		);
		
		hn.add("c");
		
		assertTrue(
			"Heap should be equal to [b] [testInsertNode] [c]",
			hn.toString().equals("[b] [testInsertNode] [c]")
		);
		
		hn.add("z");
		
		assertTrue(
			"Heap should be equal to [b] [testInsertNode] [z] [c]",
			hn.toString().equals("[b] [testInsertNode] [z] [c]")
		);
		
		hn.add("a");
		
		assertTrue(
			"Heap should be equal to [a] [testInsertNode] [z] [b] [c]",
			hn.toString().equals("[a] [testInsertNode] [z] [b] [c]")
		);
		
		hn = nn.add("a");
		
		assertTrue(
			"Null node should have changed HeapNode hn to be equal to [a]",
			hn.toString().equals("[a]")
		);
		
		assertTrue(
			"Null node should still have no value",
			nn.toString().equals("")
		);
	}

}
