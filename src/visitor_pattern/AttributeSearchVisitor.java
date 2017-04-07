package visitor_pattern;
import bit_vector_iterator.*;
import java.util.HashMap;
import java.util.Map;

//import visitor_pattern.Iterator;

public class AttributeSearchVisitor implements NodeVisitor {


	public int HTMLCount,HeadCount,BodyCount,TitleCount,DivCount,BCount;
	public StringSet s;
	String attributeKey, attributeValue;
	Node no;
	public AttributeSearchVisitor(){
		HTMLCount=0;
		HeadCount=0;
		BodyCount=0;
		TitleCount=0;
		DivCount=0;
		BCount=0;
		this.attributeKey="";
		this.attributeValue="";
		s=new StringSet();
	}

	public String searchAttribute(Node startPoint,String attributeKey,String attributeValue){
		this.attributeKey=attributeKey;
		this.attributeValue=attributeValue;
		startPoint.accept(this);
		return "";
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
		Map<String,String> attrMap = h.getAttributes();
		if(attrMap.containsKey(this.attributeKey))
			if(attrMap.get(this.attributeKey).equalsIgnoreCase(this.attributeValue))
				s.add(h.customTextualRepresentation());
		IterateAndVisit(h);

	}
	public void visitHead(Head h){
		HeadCount+=1;
		Map<String,String> attrMap = h.getAttributes();
		if(attrMap.containsKey(this.attributeKey))
			if(attrMap.get(this.attributeKey).equalsIgnoreCase(this.attributeValue))
				s.add(h.customTextualRepresentation());
		IterateAndVisit(h);
	}
	public void visitBody(Body b){
		BodyCount+=1;
		Map<String,String> attrMap = b.getAttributes();
		if(attrMap.containsKey(this.attributeKey))
			if(attrMap.get(this.attributeKey).equalsIgnoreCase(this.attributeValue))
				s.add(b.customTextualRepresentation());
		IterateAndVisit(b);
	}
	public void visitTitle(Title t){
		TitleCount+=1;
		Map<String,String> attrMap = t.getAttributes();
		if(attrMap.containsKey(this.attributeKey))
			if(attrMap.get(this.attributeKey).equalsIgnoreCase(this.attributeValue))
				s.add(t.customTextualRepresentation());
		IterateAndVisit(t);
	}
	public void visitDiv(Div d){
		DivCount+=1;
		Map<String,String> attrMap = d.getAttributes();
		if(attrMap.containsKey(this.attributeKey))
			if(attrMap.get(this.attributeKey).equalsIgnoreCase(this.attributeValue))
				s.add(d.customTextualRepresentation());
		IterateAndVisit(d);
	}
	public void visitB(B b){
		BCount+=1;
		Map<String,String> attrMap = b.getAttributes();
		if(attrMap.containsKey(this.attributeKey))
			if(attrMap.get(this.attributeKey).equalsIgnoreCase(this.attributeValue))
				s.add(b.customTextualRepresentation());
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
		HTML html = factory.makeHTML(divAtts, b);
		//System.out.println(html.textualRepresentation());
		AttributeSearchVisitor av = new AttributeSearchVisitor();
		av.searchAttribute(html, "id", "second");
		Iterator<String> it = av.s.iterator();
		while(it.hasAnotherElement())
			System.out.println(it.nextElement());
		av.report();
	}
}
