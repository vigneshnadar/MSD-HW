package tests;
import html.*;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class HTMLTests {

	@Test
	public void test1(){
	Map<String,String> divAtts = new HashMap<String,String>();
	divAtts.put("id", "second");
	divAtts.put("class", "bar");
	Div div = new Div(divAtts, "b");
	Map<String,String> noAttributes = new HashMap<String,String>();
	B b = new B(noAttributes, div);
	//System.out.println(b.textualRepresentation());
	assertEquals(b.textualRepresentation(), "<b><div id=second class=bar>b</div></b>");
	}
	
	@Test
	public void testHTML(){
		//tested innertext and childrem
		Map<String,String> divAtts = new HashMap<String,String>();
		divAtts.put("id", "second");
		divAtts.put("class", "bar");
		Div div = new Div(divAtts, "b");
		Map<String,String> noAttributes = new HashMap<String,String>();
		HTML html = new HTML(noAttributes, div);
		//System.out.println(html.textualRepresentation());
		assertEquals(html.textualRepresentation(), "<html><div id=second class=bar>b</div></html>");
		
		//test subNodes
		List<Node> subNode = new ArrayList<Node>();
		B b = new B(noAttributes,"testing html");
		subNode.add(div);
		subNode.add(b);
		html = new HTML(divAtts, subNode);
		//System.out.println(html.textualRepresentation());
		assertEquals(html.textualRepresentation(), "<html id=second class=bar><div id=second class=bar>b</div><b>testing html</b></html>");
		
		}
	
	@Test
	public void testHead(){
		//tested innertext and childrem
		Map<String,String> divAtts = new HashMap<String,String>();
		divAtts.put("id", "second");
		divAtts.put("class", "bar");
		Div div = new Div(divAtts, "b");
		Map<String,String> noAttributes = new HashMap<String,String>();
		Head head = new Head(noAttributes, div);
		//System.out.println(head.textualRepresentation());
		assertEquals(head.textualRepresentation(), "<head><div id=second class=bar>b</div></head>");
		
		//test subNodes
		List<Node> subNode = new ArrayList<Node>();
		Title t = new Title(noAttributes,"testing head");
		subNode.add(div);
		subNode.add(t);
		head = new Head(divAtts, subNode);
		//System.out.println(head.textualRepresentation());
		assertEquals(head.textualRepresentation(), "<head id=second class=bar><div id=second class=bar>b</div><title>testing head</title></head>");
		
		}
	
	
	@Test
	public void testTitle(){
		//tested innertext and childrem
		Map<String,String> divAtts = new HashMap<String,String>();
		divAtts.put("id", "second");
		divAtts.put("class", "bar");
		Div div = new Div(divAtts, "b");
		Map<String,String> noAttributes = new HashMap<String,String>();
		Title title = new Title(noAttributes, div);
		//System.out.println(title.textualRepresentation());
		assertEquals(title.textualRepresentation(), "<title><div id=second class=bar>b</div></title>");
		
		//test subNodes
		List<Node> subNode = new ArrayList<Node>();
		B b = new B(noAttributes,"testing head");
		subNode.add(div);
		subNode.add(b);
		title = new Title(divAtts, subNode);
		//System.out.println(title.textualRepresentation());
		assertEquals(title.textualRepresentation(), "<title id=second class=bar><div id=second class=bar>b</div><b>testing head</b></title>");
		
		}
	
	
	@Test
	public void testBody(){
		//tested innertext and childrem
		Map<String,String> divAtts = new HashMap<String,String>();
		divAtts.put("id", "second");
		divAtts.put("class", "bar");
		Div div = new Div(divAtts, "b");
		Map<String,String> noAttributes = new HashMap<String,String>();
		Body body = new Body(noAttributes, div);
		System.out.println(body.textualRepresentation());
		assertEquals(body.textualRepresentation(), "<body><div id=second class=bar>b</div></body>");
		
		//test subNodes
		List<Node> subNode = new ArrayList<Node>();
		Title t = new Title(noAttributes,"testing head");
		subNode.add(div);
		subNode.add(t);
		body = new Body(divAtts, subNode);
		System.out.println(body.textualRepresentation());
		assertEquals(body.textualRepresentation(), "<body id=second class=bar><div id=second class=bar>b</div><title>testing head</title></body>");
		
		}
	


}
