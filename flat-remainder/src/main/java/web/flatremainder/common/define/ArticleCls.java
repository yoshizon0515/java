package web.flatremainder.common.define;

public enum ArticleCls
{
	remainder("001"),
	memo("002");
	
	String cd;
	
	private ArticleCls(String cd)
	{
		this.cd = cd;
	}
	
	public String cd()
	{
		return this.cd;
	}
	
}
