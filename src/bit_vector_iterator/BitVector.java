package bit_vector_iterator;


	public class BitVector {
		private int[] words;
		private char[] bits;
		
		public BitVector(){
			words = new int[2];
			
		}
		public boolean get(int i){ 
			int maxIndex =32;
			int innerIndex = i % maxIndex;
			int wordIndex = i / maxIndex;
			String binaryString = Integer.toBinaryString(words[wordIndex]);
			if(binaryString.charAt(innerIndex)=='1')
			return true; 
			else
				return false;
			} // Determine if the bit at position i is set.
		public void set(int i){ 
			int maxIndex =32;
			int innerIndex = i % maxIndex;
			int wordIndex = i / maxIndex;
		
			
			bits=new char[31];
			for(int j=bits.length-1;j>=0;j--)
				bits[j]='0';
			int x=0;
			int currentInt=words[wordIndex];
			while(currentInt>0){
				bits[x]=(char) (currentInt % 2);
				currentInt=currentInt/2;
				x++;
			}
			bits[innerIndex]='1';
			StringBuilder binaryString = new StringBuilder(new String(bits));
			System.out.println("printing binary"+binaryString);
			words[wordIndex]=Integer.parseInt(binaryString.toString(),2);
			
			
//			//System.out.println("string wal"+Integer.toBinaryString(words[wordIndex]));
//			StringBuilder binaryString = new StringBuilder(Integer.toBinaryString(words[wordIndex]));
//			System.out.println("binary"+binaryString.length());
//			binaryString.setCharAt(innerIndex, '1');
//			words[wordIndex]=Integer.parseInt(binaryString.toString());
				
		} // Set the bit at position i.
		public void clear(int i){ 
//			int maxIndex =32;
//			int innerIndex = i % maxIndex;
//			int wordIndex = i / maxIndex;
//			StringBuilder binaryString = new StringBuilder(Integer.toBinaryString(words[wordIndex]));
//			binaryString.setCharAt(innerIndex, '0');
//			words[wordIndex]=Integer.parseInt(binaryString.toString());
			
			
			
			
			int maxIndex =32;
			int innerIndex = i % maxIndex;
			int wordIndex = i / maxIndex;
			
			bits=new char[31];
			int x=0;
			int currentInt=words[wordIndex];
			while(currentInt>0){
				bits[x]=(char) (currentInt % 2);
				currentInt=currentInt/2;
				x++;
			}
			bits[innerIndex]='0';
			String binaryString = new String(bits);
			words[wordIndex]=Integer.parseInt(binaryString,2);
		} // Clear the bit at position i.
		
		public void print(){
			System.out.println(words);
			for(int i=0;i<words.length;i++){
				System.out.print("final int"+words[i]);
			}
		}
		//public void addAll(BitVector b){ ... } // Set the bits in the argument BitVector b.
		//public Iterator<Integer> iterator(){ throw new Error("unimplemented"); }
		//public int size(){ ... }
		
		public static void main(String[] args){
			BitVector bv = new BitVector();
//			bv.print();
			bv.set(0);
//			//bv.set(1);
//			//bv.set(5);
			bv.print();
			String a="10000000000000000000000000000000";
			
			System.out.print("str lengt "+a.length()+" "+Integer.parseInt("1000000000000000000000000000000",2));
		}
		
		}

