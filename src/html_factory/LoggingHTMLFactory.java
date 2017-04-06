package html_factory;

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
	public Div makeDiv(Map<String,String> attributes,List<Object> listOfNode)
	{
		Div d = new Div(attributes,(List<Node>)(Object)listOfNode);
		System.out.println(d.textualRepresentation());
		return d;
	}
	
	
	public  B makeB(Map<String,String> attributes,String innerText)
	{
		B b = new B(attributes,innerText);
		System.out.println(b.textualRepresentation());
		return b;
	}
	
	public  B makeB(Map<String,String> attributes,Node children)
	{
		B b = new B(attributes,children);
		System.out.println(b.textualRepresentation());
		return b;
	}
	
	@Override
	public B makeB(Map<String,String> attributes,List<Object> listOfNode)
	{
		B b = new B(attributes,(List<Node>)(Object)listOfNode);
		System.out.println(b.textualRepresentation());
		return b;
	}
	
}
