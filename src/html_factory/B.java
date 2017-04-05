package html_factory;

import java.util.HashMap;
import java.util.Map;

public class B extends Node {

//	Map<String,String> divAtts = new HashMap<String,String>();
//	divAtts.put("id", "second");
//	divAtts.put("class", "bar");
//	2
//	Div div = new Div(divAtts, "b");
//	Map<String,String> noAttributes = new HashMap<String,String>();
//	B b = new B(noAttributes, div);
	
	public B(Map<String,String> attributes,Node children){
		this.attributes=attributes;
		this.children=children;
		this.startTag="<b";
		this.endTag="</b>";
		this.finalText="";
	}
	//assertEquals(b.textualRepresentation(), "<b><div class=bar id=second>b</div></b>");
	public  String textualRepresentation(){
		finalText=startTag;
		for(String k: attributes.keySet()){
			finalText=finalText+" "+k+"="+attributes.get(k);
		}
		finalText=finalText+">"+children.textualRepresentation()+endTag;
		return finalText;
	}
	
	
	public static void main(String[] args){
		Map<String,String> divAtts = new HashMap<String,String>();
		divAtts.put("id", "second");
		divAtts.put("class", "bar");
		
		Div div = new Div(divAtts, "b");
		Map<String,String> noAttributes = new HashMap<String,String>();
		B b = new B(noAttributes, div);
		System.out.println(b.textualRepresentation());

}}
