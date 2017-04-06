package visitor_pattern;

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
}
