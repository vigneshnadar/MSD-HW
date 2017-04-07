package tests;
import visitor_pattern.*;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

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
		nc.visitHTML(html);
		assertEquals(nc.HTMLCount,1);
		assertEquals(nc.HeadCount,0);
		assertEquals(nc.TitleCount,0);
		assertEquals(nc.BCount,1);
		assertEquals(nc.DivCount,1);
		assertEquals(nc.BodyCount,0);
	}

}