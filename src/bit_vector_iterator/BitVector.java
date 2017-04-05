package bit_vector_iterator;


public class BitVector {
	//array to store compact representation of integers
	private int[] words;

	public BitVector(){
		words = new int[1];

	}
	public boolean get(int i){ 
		//in an integer the max bit that can be set is 31st position
		int maxIndex =32;
		//take a module of index with 32 to avoid overflow
		int innerIndex = i % maxIndex;
		/*divide the integer i with 32 to find index of integer
			to be set in words array*/
		int wordIndex = i / maxIndex;
		//check if wordIndex is greater than current size of array
		if(wordIndex >= words.length)
			return false;

		//get the current integer whose bit is to be set
		int currentInt=words[wordIndex];
		//create an integer whose ith bit is set to 1
		int bitToCheck = (int)Math.pow(2, innerIndex);			
		/* do an and of current integer represetation and
			the integer representation of the index to be checked
			if the result is same as bit to be checked then return true*/
		if((bitToCheck & currentInt)== bitToCheck)
			return true;
		else return false;

	} // Determine if the bit at position i is set.


	/*takes an integer i as input
		 sets the respective bit at position i in the 
		 32 bit representation of stored integer*/
	public void set(int i){ 
		//in an integer the max bit that can be set is 31st position
		int maxIndex =32;
		//take a module of index with 32 to avoid overflow
		int innerIndex = i % maxIndex;
		/*divide the integer i with 32 to find index of integer
			to be set in words array*/
		int wordIndex = i / maxIndex;
		//check if wordIndex is greater than current size of array
		if(wordIndex >= words.length)
		{
			//initiliaze a temporary array
			int [] tempArr = new int[words.length];
			//store the current array in a temporary arrau
			tempArr = words.clone();
			//create a new array with increased size
			words = new int[wordIndex+1];
			//copy back the contents from old array
			for(int l=0;l<tempArr.length;l++)
				words[l]=tempArr[l];
		}


		System.out.println("inner Index "+innerIndex + "words lenght "+words.length);
		//get the current integer whose bit is to be set
		int currentInt=words[wordIndex];
		//create an integer whose ith bit is set to 1
		int bitToSet = (int)Math.pow(2, innerIndex);			
		/* do an or of current integer represetation and
			the integer representation of the index to be set*/
		words[wordIndex]=(bitToSet | currentInt);
		System.out.println("printing changed integer: "+words[wordIndex]);


	} 
	public void clear(int i){ 

	} // Clear the bit at position i.

	public void print(){
		System.out.println(words);
		for(int i=0;i<words.length;i++){
			System.out.print("final int: "+words[i]);
		}
	}
	//public void addAll(BitVector b){ ... } // Set the bits in the argument BitVector b.
	//public Iterator<Integer> iterator(){ throw new Error("unimplemented"); }
	//public int size(){ ... }

	public static void main(String[] args){
		BitVector bv = new BitVector();
		//			bv.print();
		bv.set(0);
		bv.set(2);
		bv.set(6);
		bv.set(32);
		//			//bv.set(5);
		bv.print();
		System.out.println("check 2: "+bv.get(2)+" check 5: "+bv.get(33));

	}

}

