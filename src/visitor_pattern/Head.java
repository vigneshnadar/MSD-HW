package visitor_pattern;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Head extends Node {

	String startTag="<head";
	String endTag="</head>";
	String finalText="";

	public Head(Map<String,String> attributes,String innerText){
		this.attributes=attributes;
		this.innerText=innerText;

	}

	public Head(Map<String,String> attributes,Node children){
		this.attributes=attributes;
		this.children=children;
	}


	public Head(Map<String,String> attributes,List<Node> subNodes){
		this.attributes=attributes;
		this.subNodes=subNodes;
	}
	//assertEquals(b.textualRepresentation(), "<b><div class=bar id=second>b</div></b>");
	public  String textualRepresentation(){
		finalText=startTag;
		for(String k: attributes.keySet()){
			finalText=finalText+" "+k+"="+attributes.get(k);
		}
		
		finalText=finalText+">";
		
		if(children!=null)
			finalText=finalText+children.textualRepresentation();
		
		if(subNodes!=null){
			for(int i=0;i<subNodes.size();i++)
			{
				finalText=finalText+subNodes.get(i).textualRepresentation();
			}
		}

		if(innerText!=null)
			finalText=finalText+innerText;

		finalText=finalText+endTag;
		
		return finalText;
	}
	
	public  String customTextualRepresentation(){
		finalText=startTag;
		for(String k: attributes.keySet()){
			finalText=finalText+" "+k+"="+attributes.get(k);
		}

		finalText=finalText+">";
				
		return finalText;
	}
	
	public Map<String,String> getAttributes(){
		return this.attributes;
	}
	
	public void accept(NodeVisitor v)
	{
		v.visitHead(this);
	}
}
