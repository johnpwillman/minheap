import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import org.junit.Test;


public class HeapCollectionTest {

	@Test
	public void testHeapIterator() {
		Heap mh = new ConcreteHeap();
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
			"Method return should print all heap nodes in preorder: "
			+ "run runner runnings swimmer running swimming",
			itrTest.trim().equals(
				"run runner runnings swimmer running swimming"
			)
		);
	}

	@Test
	public void testHeapSize() {
		Heap mh = new ConcreteHeap();
		
		mh.add("run");
		mh.add("runner");
		
		assertTrue("Size of Heap according to size() should be 2", mh.size() == 2);
		
		mh.add("running");
		mh.add("runnings");
		mh.add("swimming");
		
		assertTrue("Size of Heap according to size() should be 5", mh.size() == 5);
		
		mh.add("swimmer");
		
		assertTrue("Size of Heap according to size() should be 6", mh.size() == 6);
	}

	@Test
	public void testHeapToArray() {
		Heap mh = new ConcreteHeap();
		
		mh.add("run");
		mh.add("runner");
		mh.add("running");
		mh.add("runnings");
		mh.add("swimming");
		mh.add("swimmer");
		
		String testArray[] = mh.toArray();
		String itrTest = "";
		
		for (int i = 0; i < mh.size(); i++) {
			itrTest += testArray[i] + " ";
		}
		
		assertTrue(
			"Method return should print all heap nodes in preorder: "
			+ "run runner runnings swimmer running swimming",
			itrTest.trim().equals(
				"run runner runnings swimmer running swimming"
			)
		);
	}

}
