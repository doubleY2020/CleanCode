package chap2.fitnesse.wiki;

public interface XmlizePageCondition
{
	boolean canBeXmlized(WikiPage page) throws Exception;
}
