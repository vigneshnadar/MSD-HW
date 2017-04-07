package visitor_pattern;

import java.util.HashMap;
import java.util.Map;

//import visitor_pattern.Iterator;

public class NodeCountVisitor implements NodeVisitor {


	public int HTMLCount,HeadCount,BodyCount,TitleCount,DivCount,BCount;
	Node no;
	public NodeCountVisitor(Node no){
		HTMLCount=0;
		HeadCount=0;
		BodyCount=0;
		TitleCount=0;
		DivCount=0;
		BCount=0;
		this.no=no;
	}

	

//	public void IterateAndVisit(Node n){
//		Iterator<Node> it = n.iterator();
//		Node child=null;
//		while(it.hasAnotherElement())
//		{
//			child=it.nextElement();
//			if (child instanceof Head){
//				visitHead((Head)child);
//			} else if (child instanceof B){
//				visitB((B)child);
//			} else if (child instanceof Body){
//				visitBody((Body)child);
//			}
//		}
//	}
	
	
public void IterateAndVisit(Node n){
		
		Node child=null;
		if(n.children != null){
			child=n.children;
			visitNode(child);
		}
		if(n.subNodes!=null){
			for(int i=0;i<n.subNodes.size();i++)
				visitNode(n.subNodes.get(i));
		}
			
	}
	
	public void visitNode(Node child){
		if (child instanceof Head){
			visitHead((Head)child);
		} else if (child instanceof B){
			visitB((B)child);
		} else if (child instanceof Div){
				visitDiv((Div)child);
		} else if (child instanceof Body){
			visitBody((Body)child);
		} else if (child instanceof Title){
			visitTitle((Title)child);
		} else if (child instanceof HTML){
			visitHTML((HTML)child);
		}
	}
	public void visitHTML(HTML h){
		HTMLCount+=1;
		IterateAndVisit(h);

	}
	public void visitHead(Head h){
		HeadCount+=1;
		IterateAndVisit(h);
	}
	public void visitBody(Body b){
		BodyCount+=1;
		IterateAndVisit(b);
	}
	public void visitTitle(Title t){
		TitleCount+=1;
		IterateAndVisit(t);
	}
	public void visitDiv(Div d){
		DivCount+=1;
		IterateAndVisit(d);
	}
	public void visitB(B b){
		BCount+=1;
		IterateAndVisit(b);
	}
	
	public void report(){
		 System.out.println("DivCount: " + DivCount);
		 System.out.println("BodyCount: " + BodyCount);
		 System.out.println("TitleCount: " + TitleCount);
		 System.out.println("HTML Count: " + HTMLCount);
		 System.out.println("Head Count: " + HeadCount);
		 System.out.println("B Count: " + BCount);
		 }
	
	public static void main(String[] args){
		AbstractHTMLNodeFactory factory = new StandardHTMLNodeFactory();
		//tested innertext and childrem
		Map<String,String> divAtts = new HashMap<String,String>();
		divAtts.put("id", "second");
		divAtts.put("class", "bar");
		Div div = factory.makeDiv(divAtts, "b");
		Map<String,String> noAttributes = new HashMap<String,String>();
		B b = factory.makeB(noAttributes, div);
		HTML html = factory.makeHTML(noAttributes, b);
		//System.out.println(html.textualRepresentation());
		NodeCountVisitor nc = new NodeCountVisitor(html);
		nc.visitHTML(html);
		nc.report();
	}
}
