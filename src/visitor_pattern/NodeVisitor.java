package visitor_pattern;

public interface NodeVisitor {
void visitHTML(HTML h);
void visitHead(Head h);
void visitBody(Body b);
void visitTitle(Title t);
void visitDiv(Div d);
void visitB(B b);
}
