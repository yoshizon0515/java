package web.flatremainder.common.model;

import java.time.LocalDateTime;

public abstract class FindList
{

	private String article_cls;
	
	private LocalDateTime target_datetime_row;
	
	private String disp_period;
	
	private String head_color_class;
	
	private String importance;
	
	private String target_datetime;
	
	private String expired_flg;



	public String getArticle_cls()
	{
		return article_cls;
	}

	public void setArticle_cls(String article_cls)
	{
		this.article_cls = article_cls;
	}

	public LocalDateTime getTarget_datetime_row()
	{
		return target_datetime_row;
	}

	public void setTarget_datetime_row(LocalDateTime target_datetime_row)
	{
		this.target_datetime_row = target_datetime_row;
	}

	public String getDisp_period()
	{
		return disp_period;
	}

	public void setDisp_period(String disp_period)
	{
		this.disp_period = disp_period;
	}

	public String getHead_color_class()
	{
		return head_color_class;
	}

	public void setHead_color_class(String head_color_class)
	{
		this.head_color_class = head_color_class;
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
	
}
