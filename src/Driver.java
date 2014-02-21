
public class Driver {

	public static void main(String[] args) {
		MinHeap mh = new MinHeap();
		
		/*
		mh.insert("The");
		mh.insert("Quick");
		mh.insert("Brown");
		mh.insert("Fox");
		mh.insert("Jumped");
		mh.insert("Over");
		mh.insert("The");
		mh.insert("Lazy");
		mh.insert("Dog");
		*/
		
		/*
		mh.insert("45");
		mh.insert("65");
		mh.insert("72");
		mh.insert("90");
		mh.insert("82");
		mh.insert("81");
		mh.insert("99");
		mh.insert("96");
		//mh.insert("95");
		mh.insert("50");
		*/

		mh.insert("run");
		mh.insert("runner");
		mh.insert("running");
		mh.insert("runnings");
		mh.insert("swimming");
		mh.insert("swimmer");
		
		/*
		mh.insert("lorem");
		mh.insert("ipsum");
		mh.insert("dolor");
		mh.insert("sit");
		mh.insert("amet");
		*/
		System.out.println("MinHeap in preorder: " + mh.printHeapStringsInPreOrder());
		
		System.out.println(mh.printHeapStringsEndingInIngInPreOrder());
	}

}
