package web.flatremainder.common.define;

/**
 * 種別ID定義
 *
 */
public enum ClsId
{
	CATEGORY("001"),
	IMPORTANCE("002"),
	DISPPERIOD("003"),
	ARTICLECLS("004");

	private String clsId;

	private ClsId(String clsId)
	{
		this.clsId = clsId;
	}

	public String get()
	{
		return this.clsId;
	}

}
