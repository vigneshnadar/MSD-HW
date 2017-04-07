package html_factory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class B extends Node {


	String startTag="<b";
	String endTag="</b>";
	String finalText="";

	public B(Map<String,String> attributes,String innerText){
		this.attributes=attributes;
		this.innerText=innerText;

	}

	public B(Map<String,String> attributes,Node children){
		this.attributes=attributes;
		this.children=children;
	}


	public B(Map<String,String> attributes,List<Node> subNodes){
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

	public static void main(String[] args){
		Map<String,String> divAtts = new HashMap<String,String>();
		divAtts.put("id", "second");
		divAtts.put("class", "bar");

		Head div = new Head(divAtts, "b");
		Map<String,String> noAttributes = new HashMap<String,String>();
		B b = new B(noAttributes, div);
		System.out.println(b.textualRepresentation());

	}}
