package html_factory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractHTMLNodeFactory {

	public abstract Div makeDiv(Map<String,String> attributes,String innerText);
	public abstract Div makeDiv(Map<String,String> attributes,Node children);
	public abstract Div makeDiv(Map<String,String> attributes,List<Object> listOfNode);
	
	public abstract B makeB(Map<String,String> attributes,String innerText);
	public abstract B makeB(Map<String,String> attributes,Node children);
	public abstract B makeB(Map<String,String> attributes,List<Object> listOfNode);
	
	public abstract HTML makeHTML(Map<String,String> attributes,String innerText);
	public abstract HTML makeHTML(Map<String,String> attributes,Node children);
	public abstract HTML makeHTML(Map<String,String> attributes,List<Node> listOfNode);
	
	public abstract Body makeBody(Map<String,String> attributes,List<Object> listOfNode);
	public abstract Body makeBody(Map<String,String> attributes,String innerText);
	public abstract Body makeBody(Map<String,String> attributes,Node children);
	
	
	public abstract Title makeTitle(Map<String,String> attributes,String innerText);
	public abstract Title makeTitle(Map<String,String> attributes,Node children);
	public abstract Title makeTitle(Map<String,String> attributes,List<Object> listOfNode);
	
	public abstract Head makeHead(Map<String,String> attributes,String innerText);
	public abstract Head makeHead(Map<String,String> attributes,Node children);
	public abstract Head makeHead(Map<String,String> attributes,List<Object> listOfNode);
}
