package web.flatremainder.common.model;

import java.math.BigDecimal;

public class TBL_ARTICLE
{
	private String user_id;

	private String article_cls;

	private BigDecimal rem_id;

	private String title;

	private String content;

	private String category;

	private String importance;

	private String target_datetime;

	private String expired_flg;

	private String favorite_flg;

	private String upd_date;

	private String del_flg;

	public String getUser_id()
	{
		return user_id;
	}

	public void setUser_id(String user_id)
	{
		this.user_id = user_id;
	}

	public String getArticle_cls()
	{
		return article_cls;
	}

	public void setArticle_cls(String article_cls)
	{
		this.article_cls = article_cls;
	}

	public BigDecimal getRem_id()
	{
		return rem_id;
	}

	public void setRem_id(BigDecimal rem_id)
	{
		this.rem_id = rem_id;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public String getCategory()
	{
		return category;
	}

	public void setCategory(String category)
	{
		this.category = category;
	}

	public String getImportance()
	{
		return importance;
	}

	public void setImportance(String importance)
	{
		this.importance = importance;
	}

	public String getTarget_datetime()
	{
		return target_datetime;
	}

	public void setTarget_datetime(String target_datetime)
	{
		this.target_datetime = target_datetime;
	}

	public String getExpired_flg()
	{
		return expired_flg;
	}

	public void setExpired_flg(String expired_flg)
	{
		this.expired_flg = expired_flg;
	}

	public String getFavorite_flg()
	{
		return favorite_flg;
	}

	public void setFavorite_flg(String favorite_flg)
	{
		this.favorite_flg = favorite_flg;
	}

	public String getUpd_date()
	{
		return upd_date;
	}

	public void setUpd_date(String upd_date)
	{
		this.upd_date = upd_date;
	}

	public String getDel_flg()
	{
		return del_flg;
	}

	public void setDel_flg(String del_flg)
	{
		this.del_flg = del_flg;
	}

}
