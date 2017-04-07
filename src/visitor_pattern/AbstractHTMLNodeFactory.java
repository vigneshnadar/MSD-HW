package visitor_pattern;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractHTMLNodeFactory {

	public abstract Node makeDiv(Map<String,String> attributes,String innerText);
	public abstract Node makeDiv(Map<String,String> attributes,Node children);
	public abstract Node makeDiv(Map<String,String> attributes,List<Node> listOfNode);
	
	public abstract Node makeB(Map<String,String> attributes,String innerText);
	public abstract Node makeB(Map<String,String> attributes,Node children);
	public abstract Node makeB(Map<String,String> attributes,List<Node> listOfNode);
	
	public abstract Node makeHTML(Map<String,String> attributes,String innerText);
	public abstract Node makeHTML(Map<String,String> attributes,Node children);
	public abstract Node makeHTML(Map<String,String> attributes,List<Node> listOfNode);
	
	public abstract Node makeBody(Map<String,String> attributes,List<Node> listOfNode);
	public abstract Node makeBody(Map<String,String> attributes,String innerText);
	public abstract Node makeBody(Map<String,String> attributes,Node children);
	
	
	public abstract Node makeTitle(Map<String,String> attributes,String innerText);
	public abstract Node makeTitle(Map<String,String> attributes,Node children);
	public abstract Node makeTitle(Map<String,String> attributes,List<Node> listOfNode);
	
	public abstract Node makeHead(Map<String,String> attributes,String innerText);
	public abstract Node makeHead(Map<String,String> attributes,Node children);
	public abstract Node makeHead(Map<String,String> attributes,List<Node> listOfNode);
}
