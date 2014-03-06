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
		
		assertEquals("Height should be 1 on node creation", hn.getHeapHeight(), 1);
		
		hn.add("SecondInsert");

		assertEquals("Height should be 2 after second insert", hn.getHeapHeight(), 2);
		
		hn.add("ThirdInsert");
		
		assertEquals("Height should still be 2 after third insert", hn.getHeapHeight(), 2);
		
		hn.add("FourthInsert");
		
		assertEquals("Height should be 3 after fourth insert", hn.getHeapHeight(), 3);
	}
	
	@Test
	public void testGetHeapSize() {
		HeapNode hn = new ValuedHeapNode("testGetHeapHeight");
		hn.setHeapStrategy(new MinHeapStrategy());
		
		System.out.println(hn.getHeapSize());
		
		assertEquals("Size should be 1 on node creation", hn.getHeapSize(), 1);
		
		hn.add("SecondInsert");

		assertEquals("Size should be 2 after second insert", hn.getHeapSize(), 2);
		
		hn.add("ThirdInsert");
		
		assertEquals("Size should be 3 after third insert", hn.getHeapSize(), 3);
		
		hn.add("FourthInsert");
		
		assertEquals("Height should be 4 after fourth insert", hn.getHeapSize(), 4);
	}

	@Test
	public void testAddNode() {
		ValuedHeapNode hn = new ValuedHeapNode("testInsertNode");
		hn.setHeapStrategy(new MinHeapStrategy());
		
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
	}

}
