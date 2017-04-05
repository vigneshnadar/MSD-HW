package html_factory;

import java.util.HashMap;

public class StandardHTMLNodeFactory {

	Node child;
	public B makeB(){
		return new B(new HashMap<String,String>(),child);
	}
	
	public Div makeDiv(){
		return new Div(new HashMap<String,String>(),"b");
	}
}
