package html;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public abstract class Node {

	//returns the textual respresentation of the code for children at that node
		public abstract String textualRepresentation();
		Map<String,String> attributes;
		Node children;
		List<Node> subNodes;
		public String startTag,endTag,finalText,innerText;
}
