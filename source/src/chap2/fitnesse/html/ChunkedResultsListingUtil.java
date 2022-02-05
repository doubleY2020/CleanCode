package chap2.fitnesse.html;

public class ChunkedResultsListingUtil
{
	public static String getTableOpenHtml(String id)
	{
		return "<table id=\"" + id + "\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" class=\"dirListing\">";
	}

	public static String getTableCloseHtml()
	{
		return "</table>";
	}
}
