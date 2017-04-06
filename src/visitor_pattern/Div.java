package html_factory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Div extends Node {
	
	String startTag="<div";
	String endTag="</div>";
	String finalText="";

	public Div(Map<String,String> attributes,String innerText){
		this.attributes=attributes;
		this.innerText=innerText;
		
	}
	
	public Div(Map<String,String> attributes,Node children){
		this.attributes=attributes;
		this.children=children;
	}
	
	
	public Div(Map<String,String> attributes,List<Node> subNodes){
		this.attributes=attributes;
		this.subNodes=subNodes;
	}
	//assertEquals(b.textualRepresentation(), "<b><div class=bar id=second>b</div></b>");
	public  String textualRepresentation(){
		finalText=startTag;
		for(String k: attributes.keySet()){
			finalText=finalText+" "+k+"="+attributes.get(k);
		}
		finalText=finalText+children.textualRepresentation();
		for(Node n: subNodes)
		{
			finalText=finalText+n.textualRepresentation();
		}
		finalText=finalText+">"+innerText+endTag;
		return finalText;
	}
}
