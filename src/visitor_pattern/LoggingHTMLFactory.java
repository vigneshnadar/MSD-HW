package visitor_pattern;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoggingHTMLFactory extends AbstractHTMLNodeFactory{

	
	
	
	public  Div makeDiv(Map<String,String> attributes,String innerText)
	{
		Div d = new Div(attributes,innerText);
		System.out.println(d.textualRepresentation());
		return d;
	}
	public  Div makeDiv(Map<String,String> attributes,Node children)
	{
		Div d = new Div(attributes,children);
		System.out.println(d.textualRepresentation());
		return d;
	}
	
	@Override
	public Div makeDiv(Map<String,String> attributes,List<Node> listOfNode)
	{
		Div d = new Div(attributes,(List<Node>)(Object)listOfNode);
		System.out.println(d.textualRepresentation());
		return d;
	}
	
	
	public B makeB(Map<String,String> attributes,String innerText)
	{
		B b = new B(attributes,innerText);
		System.out.println(b.textualRepresentation());
		return b;
	}
	
	public B makeB(Map<String,String> attributes,Node children)
	{
		B b = new B(attributes,children);
		System.out.println(b.textualRepresentation());
		return b;
	}
	
	@Override
	public B makeB(Map<String,String> attributes,List<Node> listOfNode)
	{
		B b = new B(attributes,(List<Node>)(Object)listOfNode); 
		System.out.println(b.textualRepresentation());
		return b;
	}
	
	
	public  HTML makeHTML(Map<String,String> attributes,String innerText)
	{
		HTML html = new HTML(attributes,innerText);
		System.out.println(html.textualRepresentation());
		return html;
	}
	
	public  HTML makeHTML(Map<String,String> attributes,Node children)
	{
		HTML html = new HTML(attributes,children);
		System.out.println(html.textualRepresentation());
		return html;
	}
	
	@Override
	public HTML makeHTML(Map<String,String> attributes,List<Node> listOfNode)
	{
		HTML html = new HTML(attributes,(List<Node>)(Object)listOfNode); 
		System.out.println(html.textualRepresentation());
		return html;
	}
	
	public  Head makeHead(Map<String,String> attributes,String innerText)
	{
		Head head = new Head(attributes,innerText);
		System.out.println(head.textualRepresentation());
		return head;
	}
	
	public  Head makeHead(Map<String,String> attributes,Node children)
	{
		Head head = new Head(attributes,children);
		System.out.println(head.textualRepresentation());
		return head;
	}
	
	@Override
	public Head makeHead(Map<String,String> attributes,List<Node> listOfNode)
	{
		Head head = new Head(attributes,(List<Node>)(Object)listOfNode); 
		System.out.println(head.textualRepresentation());
		return head;
	}
	
	public  Title makeTitle(Map<String,String> attributes,String innerText)
	{
		Title title = new Title(attributes,innerText);
		System.out.println(title.textualRepresentation());
		return title;
	}
	
	public  Title makeTitle(Map<String,String> attributes,Node children)
	{
		Title title = new Title(attributes,children);
		System.out.println(title.textualRepresentation());
		return title;
	}
	
	public Title makeTitle(Map<String,String> attributes,List<Node> listOfNode)
	{
		Title title = new Title(attributes,(List<Node>)(Object)listOfNode); 
		System.out.println(title.textualRepresentation());
		return title;
	}
	
	
	public Body makeBody(Map<String,String> attributes,String innerText)
	{
		Body body = new Body(attributes,innerText);
		System.out.println(body.textualRepresentation());
		return body;
	}
	
	public  Body makeBody(Map<String,String> attributes,Node children)
	{
		Body body = new Body(attributes,children);
		System.out.println(body.textualRepresentation());
		return body;
	}
	
	@Override
	public Body makeBody(Map<String,String> attributes,List<Node> listOfNode)
	{
		Body body = new Body(attributes,(List<Node>)(Object)listOfNode); 
		System.out.println(body.textualRepresentation());
		return body;
	}
}
