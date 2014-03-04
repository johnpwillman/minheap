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
		ValuedHeapNode hn = new ValuedHeapNode("testHeapNode");
		
		assertTrue(
			"Heap should be equal to [testHeapNode]",
			hn.getHeapValuesMatchingRegex(".*").equals("[testHeapNode]")
		);
	}

	@Test
	public void testGetHeapHeight() {
		ValuedHeapNode hn = new ValuedHeapNode("testGetHeapHeight");
		
		assertEquals("Height should be 1 on node creation", hn.getHeapHeight(), 1);
		
		hn.add("SecondInsert");

		assertEquals("Height should be 2 after second insert", hn.getHeapHeight(), 2);
		
		hn.add("ThirdInsert");
		
		assertEquals("Height should still be 2 after third insert", hn.getHeapHeight(), 2);
		
		hn.add("FourthInsert");
		
		assertEquals("Height should be 3 after fourth insert", hn.getHeapHeight(), 3);
	}

	@Test
	public void testInsertNode() {
		ValuedHeapNode hn = new ValuedHeapNode("testInsertNode");
		
		assertTrue(
			"Heap should be equal to [testInsertNode]",
			hn.getHeapValuesMatchingRegex(".*").equals("[testInsertNode]")
		);
		
		hn.add("b");
		
		assertTrue(
			"Heap should be equal to [b] [testInsertNode]",
			hn.getHeapValuesMatchingRegex(".*").equals("[b] [testInsertNode]")
		);
		
		hn.add("c");
		
		assertTrue(
			"Heap should be equal to [b] [testInsertNode] [c]",
			hn.getHeapValuesMatchingRegex(".*").equals("[b] [testInsertNode] [c]")
		);
		
		hn.add("z");
		
		assertTrue(
			"Heap should be equal to [b] [testInsertNode] [z] [c]",
			hn.getHeapValuesMatchingRegex(".*").equals("[b] [testInsertNode] [z] [c]")
		);
		
		hn.add("a");
		
		assertTrue(
			"Heap should be equal to [a] [testInsertNode] [z] [b] [c]",
			hn.getHeapValuesMatchingRegex(".*").equals("[a] [testInsertNode] [z] [b] [c]")
		);
	}

	@Test
	public void testPrintHeapInPreorderMatchingRegex() {
		ValuedHeapNode hn = new ValuedHeapNode("lorem");
		
		hn.add("ipsum");
		hn.add("dolor");
		hn.add("sit");
		hn.add("amet");
		
		assertTrue(
			"Heap should be equal to [amet] [lorem] [sit] [dolor] [ipsum] (all words)",
			hn.getHeapValuesMatchingRegex(".*").equals("[amet] [lorem] [sit] [dolor] [ipsum]")
		);
		
		assertTrue(
			"Heap should be equal to [lorem] [dolor] (only words with 'r')",
			hn.getHeapValuesMatchingRegex(".*r.*").equals("[lorem] [dolor]")
		);
		
		assertTrue(
			"Heap should be equal to [sit] (only words beginnning with 's')",
			hn.getHeapValuesMatchingRegex("s.*").equals("[sit]")
		);
	}

}
