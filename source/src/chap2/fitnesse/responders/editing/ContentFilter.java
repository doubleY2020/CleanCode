package chap2.fitnesse.responders.editing;

public interface ContentFilter
{
	boolean isContentAcceptable(String content, String page);
}
