package visitor_pattern;

import bit_vector_iterator.BitVector;
import bit_vector_iterator.Iterator;

public class NodeCountVisitor implements NodeVisitor {


	int HTMLCount,HeadCount,BodyCount,TitleCount,DivCount,BCount;
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



	public void IterateAndVisit(Node n){
		
		Node child=null;
		if(n.children != null){
			child=n.children;
			visitNode(child);
		}
			for(int i=0;i<n.subNodes.size();i++)
				visitNode(n.subNodes.get(i));
	}
	
	public void visitNode(Node child){
		if (child instanceof Head){
			visitHead((Head)child);
		} else if (child instanceof B){
			visitB((B)child);
		} else if (child instanceof Body){
			visitBody((Body)child);
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
		 System.out.println("files: " + DivCount);
		 System.out.println("directories: " + BodyCount);
		 System.out.println("links: " + TitleCount);
		 System.out.println("total size: " + HTMLCount);
		 }
}
