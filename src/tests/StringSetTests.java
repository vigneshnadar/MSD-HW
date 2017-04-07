package tests;
import bit_vector_iterator.*;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class StringSetTests {

	@Test
	public void testStringSet(){
		StringSet s = new StringSet();
		s.add("hello");
		s.add("world");
		Iterator<String> it = s.iterator();
		assertEquals(s.size(), 2);
		assertEquals(it.hasAnotherElement(), true);
		assertEquals(it.nextElement(), "hello");
		assertEquals(it.nextElement(), "world");
		System.out.println("size: "+ s.size()+" "+it.hasAnotherElement()+" "+it.nextElement()+" "+it.hasAnotherElement());
		
		//s.remove("hello");
		//Iterator<String> it1 = s.iterator();
		//assertEquals(it1.nextElement(), "world");
		//System.out.println("size: "+ s.size()+" "+it1.hasAnotherElement()+" "+it1.nextElement()+" "+it1.hasAnotherElement());
		
	}
	
	@Test
	public void testStringSetRemove(){
		StringSet s = new StringSet();
		s.add("hello");
		s.add("world");
		System.out.println(s.bitToString);
		s.remove("hello");
		assertEquals(s.size(), 1);
		//System.out.println("remove done");
		System.out.println(s.bitToString);
		Iterator<String> it = s.iterator();
		assertEquals(it.hasAnotherElement(), true);
		assertEquals(it.nextElement(), "world");
		System.out.println("size: "+ s.size()+" "+it.hasAnotherElement()+" "+it.nextElement()+" "+it.hasAnotherElement());
		
		
	}
	
	@Test
	public void testStringSetAddAll(){
		StringSet s = new StringSet();
		s.add("hello");
		s.add("world");
		StringSet s1 = new StringSet();
		s1.addAll(s);
		Iterator<String> it = s1.iterator();
		assertEquals(it.hasAnotherElement(), true);
		assertEquals(it.nextElement(), "hello");
		assertEquals(it.nextElement(), "world");
		System.out.println("size: "+ s.size()+" "+it.hasAnotherElement()+" "+it.nextElement()+" "+it.hasAnotherElement());
		
		
	}

	/*@Test
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
	}*/

}