package bit_vector_iterator;

import java.util.HashMap;
import java.util.Map;

public class StringSet implements Set<String> {

private BitVector adaptee = new BitVector();
Map<Integer,String> bitToString = new HashMap<Integer,String>();


private class StringSetIterator implements Iterator<String> 
{
	private int bitCount=0,currentCount=0;
	StringSet ss;
	Iterator<Integer> intIter;
	
	public StringSetIterator(StringSet ss){
		bitCount=ss.size();
		intIter=ss.adaptee.iterator();
		this.ss=ss;
	}
	public boolean hasAnotherElement(){
		return intIter.hasAnotherElement() ;
	}
	
	 public String nextElement(){
		 
		 int currentElement=intIter.nextElement();
		 if(bitToString.containsKey(currentElement))
				 return bitToString.get(currentElement);
		 return null;
		 
	 }
}


public void add(String s){
	int index=bitToString.size();
	adaptee.set(index);
	bitToString.put(index, s);
}
//public void addAll(Set<String> s){ ... }
public void remove(String s){ 
	for(Integer i: bitToString.keySet()){
		if(bitToString.get(i).equals(s))
		{
			bitToString.remove(i);
			adaptee.clear(i);
		}
		
	}
}

public int size(){ 
	return bitToString.size();
	
}
public Iterator<String> iterator(){ 
	return new StringSetIterator(this);
}
}
