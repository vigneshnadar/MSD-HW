package bit_vector_iterator;


public class BitVector {
	//array to store compact representation of integers
	private int[] words;
	
	private class BitVectorIterator implements Iterator<Integer> 
	{
		private int bitCount=0,currentCount;
		BitVector b;
		
		public BitVectorIterator(BitVector b){
			bitCount=b.size();
			this.b=b;
			currentCount=0;
		}
		
		
		
		public boolean hasAnotherElement(){
			return currentCount < (bitCount-1) ;
		}
		
		 public Integer nextElement(){
			 
			 while(currentCount <= bitCount)
			 {				
				 if(b.get(currentCount))
				 {
					 currentCount++;
					 return currentCount-1;
				 }
				 currentCount++;
				 
			 }
			 return -1;
		 }
	}
	
	
	public Iterator<Integer> iterator()
	{ 
		return new BitVectorIterator(this);
	}


	public BitVector(){
		words = new int[1];

	}
	
	//return the words array
	public int[] getWords(){
		return this.words;
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

	public void handleIndexOverflow(int wordIndex){
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
	}
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

		/* method to check if the integer to be set will cause an index over flow
		if it causes overflow increase size of array */
		handleIndexOverflow(wordIndex);

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
	
	
	public void addAll(BitVector b){ 
		Iterator<Integer> it = b.iterator();
		while(it.hasAnotherElement())
		{
			set(it.nextElement());
		}
	} // Set the bits in the argument BitVector b
	
	//clear the given integer from set
	public void clear(int i){ 
		//in an integer the max bit that can be set is 31st position
		int maxIndex =32;
		//take a module of index with 32 to avoid overflow
		int innerIndex = i % maxIndex;
		/*divide the integer i with 32 to find index of integer
					to be set in words array*/
		int wordIndex = i / maxIndex;

		/* method to check if the integer to be set will cause an index over flow
				if it causes overflow increase size of array */
		handleIndexOverflow(wordIndex);

		System.out.println("inner Index "+innerIndex + "words lenght "+words.length);
		//get the current integer whose bit is to be set
		int currentInt=words[wordIndex];
		//create an integer whose ith bit is set to 1
		int bitToSet = (int)Math.pow(2, innerIndex);	
		//take a complement of the bit to be set
		bitToSet = ~bitToSet;
		/* do an and of current integer represetation and
					the integer representation of the index to be set*/
		words[wordIndex]=(bitToSet & currentInt);
		System.out.println("printing changed integer: "+words[wordIndex]);
	} // Clear the bit at position i.

	//returns the number of integers in the set 
	public int size(){
//		int count=0;
//		for(int i=0;i<words.length;i++)
//		{			
//			// returns the number of one-bits in the binary representation of stored int 
//			count+=Integer.bitCount(words[i]); 
//		}
//		return count;
		return ((words.length * 32)- words.length);
	}

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
		System.out.println(bv.words[0]);
		bv.set(39);
		System.out.println(Math.pow(2, 30));
		System.out.println("parsing "+Integer.parseInt("1000000000000000000000000000001",2));
		System.out.println(bv.words[0]+" "+Integer.toBinaryString(2147483647));
		System.out.println(bv.words[0]+" "+Integer.toBinaryString(bv.words[0]));
		bv.set(2);
//		bv.set(6);
//		bv.set(32);
//		bv.print();
//		System.out.println("check 2: "+bv.get(2)+"check 4 "+bv.get(4)+" check 6: "+bv.get(6)+" "+bv.get(7));
//		bv.clear(2);
//		System.out.println("check 2: "+bv.get(2)+" check 5: "+bv.get(6));
		Iterator<Integer> iter = bv.iterator();
		while(iter.hasAnotherElement())
			System.out.println(iter.nextElement());

	}

}

