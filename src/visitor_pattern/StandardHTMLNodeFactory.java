package visitor_pattern;

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
	
}
