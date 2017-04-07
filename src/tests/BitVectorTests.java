package tests;
import bit_vector_iterator.*;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class BitVectorTests {

	@Test
	public void testBitVector(){
		BitVector b = new BitVector();
		b.set(0);
		assertEquals(b.get(0), true);
		b.set(31);
		assertEquals(b.get(31), true);
		b.clear(0);
		assertEquals(b.get(0), false);
		b.set(128);
		assertEquals(b.get(128), true);
		assertEquals(b.get(127), false);
	}

	@Test
	public void testBitVectorIterator(){
		BitVector ba = new BitVector();

		ba.set(0);
		assertEquals(ba.size(), 31);
		ba.set(39);
		assertEquals(ba.size(), 62);
		Iterator<Integer> it = ba.iterator();
		//System.out.println("testing get"+ba.get(0)+" "+ba.get(39)+" "+ba.get(2)+" "+ba.get(31));
		//System.out.println(ba.size()+" "+it.hasAnotherElement() +" "+it.nextElement()+it.hasAnotherElement()+it.nextElement()+it.hasAnotherElement());
		assertEquals(it.hasAnotherElement(), true);
		assertEquals((int)it.nextElement(), 0);
		assertEquals(it.hasAnotherElement(), true);
		assertEquals((int)it.nextElement(), 39);
		//assertEquals(it.hasAnotherElement(), false);
	}
	
	
	@Test
	public void testaddAll(){
		BitVector ba = new BitVector();
		BitVector b = new BitVector();

		ba.set(0);
		ba.set(39);
		b.addAll(ba);
		assertEquals(b.get(0), true);
		assertEquals(b.get(39), true);
		assertEquals(b.get(40), false);
	}

}