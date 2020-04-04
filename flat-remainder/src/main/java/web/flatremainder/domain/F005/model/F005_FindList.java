package web.flatremainder.domain.F005.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import web.flatremainder.common.model.FindList;

public class F005_FindList extends FindList
{
	
	// ユーザID
	private String user_id;
	
	/** 表示側 */
	// 表示名
	private String disp_user;

	// 記事種別
	private String article_cls;

	//記事ID
	private BigDecimal rem_id;

	// 表示期間
	private String disp_period;

	// タイトル
	private String title;

	// 内容
	private String content;

	// カテゴリ
	private String category;

	// 重要度
	private String importance_nm;

	// 指定日時(yyyymmdd hh:mm)
	private LocalDateTime target_datetime_row;
	
	// 指定日時(yyyymmdd hh:mm)
	private String target_datetime;

	// 期限切れフラグ
	private String expired_flg;

	// お気に入りフラグ
	private String favorite_flg;
	
	//更新日時
	private String upd_date;
	
	//重要度（フラグ値）
	private String importance;
	
	//カード色のクラス名
	private String head_color_class;

	public String getUser_id()
	{
		return user_id;
	}

	public void setUser_id(String user_id)
	{
		this.user_id = user_id;
	}

	public String getDisp_user()
	{
		return disp_user;
	}

	public void setDisp_user(String disp_user)
	{
		this.disp_user = disp_user;
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

	public String getDisp_period()
	{
		return disp_period;
	}

	public void setDisp_period(String disp_period)
	{
		this.disp_period = disp_period;
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

	public String getImportance_nm()
	{
		return importance_nm;
	}

	public void setImportance_nm(String importance_nm)
	{
		this.importance_nm = importance_nm;
	}

	public LocalDateTime getTarget_datetime_row()
	{
		return target_datetime_row;
	}

	public void setTarget_datetime_row(LocalDateTime target_datetime_row)
	{
		this.target_datetime_row = target_datetime_row;
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

	public String getImportance()
	{
		return importance;
	}

	public void setImportance(String importance)
	{
		this.importance = importance;
	}

	public String getHead_color_class()
	{
		return head_color_class;
	}

	public void setHead_color_class(String head_color_class)
	{
		this.head_color_class = head_color_class;
	}

	

}
