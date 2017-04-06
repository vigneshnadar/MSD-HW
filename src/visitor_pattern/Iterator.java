package visitor_pattern;

public interface Iterator<T> {
	boolean hasAnotherElement();
	 T nextElement();

}
