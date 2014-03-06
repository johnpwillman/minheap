import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;


public class IngDecoratorTest {

	@Test
	public void testIngDecorator() {
		Heap mh = new IngDecorator(new ConcreteHeap(new MaxHeapStrategy()));
		Iterator<String> itr;
		
		mh.add("run");
		mh.add("runner");
		mh.add("running");
		mh.add("runnings");
		mh.add("swimming");
		mh.add("swimmer");
		
		itr = mh.iterator();
		
		String itrTest = "";
		
		while (itr.hasNext()) {
			itrTest += itr.next() + " ";
		}
		
		assertTrue(
			"Method return should print all heap nodes ending in 'ing' in preorder: "
			+ "swimming running",
			itrTest.trim().equals(
				"swimming running"
			)
		);
		
	}

	@Test
	public void testHeapSize() {
		Heap mh = new IngDecorator(new ConcreteHeap(new MaxHeapStrategy()));
		
		mh.add("run");
		mh.add("runner");
		
		assertTrue("Size of Heap according to size() should be 0", mh.size() == 0);
		
		mh.add("running");
		mh.add("runnings");
		mh.add("swimming");
		
		assertTrue("Size of Heap according to size() should be 2", mh.size() == 2);
		
		mh.add("swimmer");
		
		assertTrue("Size of Heap according to size() should still be 2", mh.size() == 2);
	}

	@Test
	public void testHeapToArray() {
		Heap mh = new IngDecorator(new ConcreteHeap(new MinHeapStrategy()));
		
		mh.add("run");
		mh.add("runner");
		mh.add("running");
		mh.add("runnings");
		mh.add("swimming");
		mh.add("swimmer");
		
		String testArray[] = mh.toArray();
		String arrTest = "";
		
		for (int i = 0; i < mh.size(); i++) {
			arrTest += testArray[i] + " ";
		}
		
		assertTrue(
			"Method return should print all heap nodes in preorder: "
			+ "running swimming",
			arrTest.trim().equals(
				"running swimming"
			)
		);
	}

	@Test
	public void testIngToString() {
		Heap mh = new IngDecorator(new ConcreteHeap(new MinHeapStrategy()));
		
		mh.add("run");
		mh.add("runner");
		mh.add("running");
		mh.add("runnings");
		mh.add("swimming");
		mh.add("swimmer");
		
		assertTrue(
			"Method return should print all heap nodes in preorder: "
			+ "[running] [swimming]",
			mh.toString().equals(
				"[running] [swimming]"
			)
		);
	}

}
