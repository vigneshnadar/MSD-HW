package visitor_pattern;

public class HTML extends Node {

	//returns the textual respresentation of the code for children at that node
	public  String textualRepresentation(){
		return "h";
	}
}
