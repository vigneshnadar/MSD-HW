package html_factory;

import java.util.HashMap;
import java.util.Map;

public abstract class Node {

	//returns the textual respresentation of the code for children at that node
	public abstract String textualRepresentation();
	Map<String,String> attributes;
	Node children;
	String startTag,endTag,finalText,innerText;
}
