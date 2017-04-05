package bit_vector_iterator;

public class Testing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a="1000000000000000000000001000101";
		
		System.out.print("str lengt "+a.length()+" "+Integer.parseInt("00000000000000000000000000000101",2));
		
		 int i = 9;
	      System.out.println("Number = " + i);
	    
	      /* returns the string representation of the unsigned integer value 
	         represented by the argument in binary (base 2) */
	      System.out.println("Binary = " + Integer.toBinaryString(i));

	      // returns the number of one-bits 
	      System.out.println("Number of one bits = " + Integer.bitCount(i)); 
	}

}
