package tests;
import visitor_pattern.*;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import bit_vector_iterator.Iterator;

public class HTMLVisitorTests {

	@Test
	public void testVisitor(){
		
		AbstractHTMLNodeFactory factory = new StandardHTMLNodeFactory();
		//tested innertext and childrem
		Map<String,String> divAtts = new HashMap<String,String>();
		divAtts.put("id", "second");
		divAtts.put("class", "bar");
		Div div = factory.makeDiv(divAtts, "b");
		Map<String,String> noAttributes = new HashMap<String,String>();
		B b = factory.makeB(noAttributes, div);
		HTML html = factory.makeHTML(noAttributes, b);
		//System.out.println(html.textualRepresentation());
		NodeCountVisitor nc = new NodeCountVisitor(html);
		html.accept(nc);
		//nc.visitHTML(html);
		assertEquals(nc.HTMLCount,1);
		assertEquals(nc.HeadCount,0);
		assertEquals(nc.TitleCount,0);
		assertEquals(nc.BCount,1);
		assertEquals(nc.DivCount,1);
		assertEquals(nc.BodyCount,0);
	}
	
	

	@Test
	public void testAttributeVisitor(){
		
		AbstractHTMLNodeFactory factory = new StandardHTMLNodeFactory();
		//tested innertext and childrem
		Map<String,String> divAtts = new HashMap<String,String>();
		divAtts.put("id", "second");
		divAtts.put("class", "bar");
		Div div = factory.makeDiv(divAtts, "b");
		Map<String,String> noAttributes = new HashMap<String,String>();
		B b = factory.makeB(noAttributes, div);
		HTML html = factory.makeHTML(divAtts, b);
		//System.out.println(html.textualRepresentation());
		AttributeSearchVisitor av = new AttributeSearchVisitor();
		av.searchAttribute(html, "id", "second");
		Iterator<String> it = av.s.iterator();
		assertEquals(it.nextElement(),"<html id=second class=bar>");
		assertEquals(it.nextElement(),"<div id=second class=bar>");
	}
	

}