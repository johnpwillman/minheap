import java.util.Iterator;


public class Driver {

	public static void main(String[] args) {
		System.out.println("hello".toString());
		//Heap mh = new Heap(new MinHeapStrategy());
		Heap mh = new IngDecorator(new ConcreteHeap(new MinHeapStrategy()));
		
		/*
		mh.add("The");
		mh.add("Quick");
		mh.add("Brown");
		mh.add("Fox");
		mh.add("Jumped");
		mh.add("Over");
		mh.add("The");
		mh.add("Lazy");
		mh.add("Dog");
		*/
		
		/*
		mh.add("45");
		mh.add("65");
		mh.add("72");
		mh.add("90");
		mh.add("82");
		mh.add("81");
		mh.add("99");
		mh.add("96");
		//mh.add("95");
		mh.add("50");
		*/

		mh.add("run");
		mh.add("runner");
		mh.add("running");
		mh.add("runnings");
		mh.add("swimming");
		mh.add("swimmer");
		
		/*
		mh.add("lorem");
		mh.add("ipsum");
		mh.add("dolor");
		mh.add("sit");
		mh.add("amet");
		*/
		System.out.println("Heap in preorder: " + mh.toString());
		System.out.println("Heap size: " + mh.size());
		
		Iterator<String> itr = mh.iterator();
		
		while (itr.hasNext()) {
			System.out.println("itr: " + itr.next());
		}
		
		//System.out.println(mh.printHeapStringsEndingInIngInPreOrder());
	}

}
