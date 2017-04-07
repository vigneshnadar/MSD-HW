package html_factory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StandardHTMLNodeFactory extends AbstractHTMLNodeFactory{

	
	
	
	public  Div makeDiv(Map<String,String> attributes,String innerText)
	{
		return new Div(attributes,innerText);
	}
	public  Div makeDiv(Map<String,String> attributes,Node children)
	{
		return new Div(attributes,children);
	}
	
	@Override
	public Div makeDiv(Map<String,String> attributes,List<Object> listOfNode)
	{
		return new Div(attributes,(List<Node>)(Object)listOfNode);
	}
	
	
	public  B makeB(Map<String,String> attributes,String innerText)
	{
		return new B(attributes,innerText);
	}
	
	public  B makeB(Map<String,String> attributes,Node children)
	{
		return new B(attributes,children);
	}
	
	@Override
	public B makeB(Map<String,String> attributes,List<Object> listOfNode)
	{
		return new B(attributes,(List<Node>)(Object)listOfNode);
	}
	
	
	public  HTML makeHTML(Map<String,String> attributes,String innerText)
	{
		return new HTML(attributes,innerText);
	}
	
	public  HTML makeHTML(Map<String,String> attributes,Node children)
	{
		return new HTML(attributes,children);
	}
	
	public HTML makeHTML(Map<String,String> attributes,List<Node> listOfNode)
	{
		return new HTML(attributes,(List<Node>)(Object)listOfNode);
	}
	
	
	public  Title makeTitle(Map<String,String> attributes,String innerText)
	{
		return new Title(attributes,innerText);
	}
	
	public  Title makeTitle(Map<String,String> attributes,Node children)
	{
		return new Title(attributes,children);
	}
	
	public Title makeTitle(Map<String,String> attributes,List<Object> listOfNode)
	{
		return new Title(attributes,(List<Node>)(Object)listOfNode);
	}
	
	public  Body makeBody(Map<String,String> attributes,String innerText)
	{
		return new Body(attributes,innerText);
	}
	
	public  Body makeBody(Map<String,String> attributes,Node children)
	{
		return new Body(attributes,children);
	}
	
	public Body makeBody(Map<String,String> attributes,List<Object> listOfNode)
	{
		return new Body(attributes,(List<Node>)(Object)listOfNode);
	}
	
	
	public  Head makeHead(Map<String,String> attributes,String innerText)
	{
		return new Head(attributes,innerText);
	}
	
	public  Head makeHead(Map<String,String> attributes,Node children)
	{
		return new Head(attributes,children);
	}
	
	public Head makeHead(Map<String,String> attributes,List<Object> listOfNode)
	{
		return new Head(attributes,(List<Node>)(Object)listOfNode);
	}
	
}
