package html;

import java.util.HashMap;
import java.util.Map;

public class Div extends Node {

	public Div(Map<String,String> attributes,String innerText){
		this.attributes=attributes;
		this.innerText=innerText;
		this.startTag="<div";
		this.endTag="</div>";
		this.finalText="";
	}
	//assertEquals(b.textualRepresentation(), "<b><div class=bar id=second>b</div></b>");
	public  String textualRepresentation(){
		finalText=startTag;
		for(String k: attributes.keySet()){
			finalText=finalText+" "+k+"="+attributes.get(k);
		}
		finalText=finalText+">"+innerText+endTag;
		return finalText;
	}
}
