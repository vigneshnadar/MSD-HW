package visitor_pattern;

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
		
		private class NodeIterator implements Iterator<Node> 
		{
			private int childrenCount,subNodeCount,currentCount;
			Node n;

			public NodeIterator(Node n){
				if(n.children!=null)
					childrenCount=1;
				else childrenCount=0;

				subNodeCount=n.subNodes.size();
				this.n=n;
			}
			public boolean hasAnotherElement(){
				if((childrenCount > 0) && (currentCount < subNodeCount))
					return true;
				else return false;
			}

			public Node nextElement(){

				if(childrenCount > 0)
					return n.children;

				if(currentCount < subNodeCount)
				{				
					currentCount++;
					return n.subNodes.get(currentCount-1);
				}
				return null;
			}
		}

		public Iterator<Node> iterator()
		{ 
			return new NodeIterator(this);
		}
}
