package web.flatremainder.domain.F003.model;

import java.sql.Timestamp;

public class F003_Insert
{
	//ユーザID
	private String user_id;
	
	// 記事種別
	private String ins_article_cls;

	// カテゴリ
	private String ins_category;

	// タイトル
	private String ins_title;

	// 内容
	private String ins_content;

	// 重要度
	private String ins_importance;

	// 指定日時(yyyymmdd hh:mm)
	private Timestamp ins_target_datetime;

	// お気に入りフラグ
	private String ins_favorite_flg;

	public String getUser_id()
	{
		return user_id;
	}

	public void setUser_id(String user_id)
	{
		this.user_id = user_id;
	}

	public String getIns_article_cls()
	{
		return ins_article_cls;
	}

	public void setIns_article_cls(String ins_article_cls)
	{
		this.ins_article_cls = ins_article_cls;
	}

	public String getIns_category()
	{
		return ins_category;
	}

	public void setIns_category(String ins_category)
	{
		this.ins_category = ins_category;
	}

	public String getIns_title()
	{
		return ins_title;
	}

	public void setIns_title(String ins_title)
	{
		this.ins_title = ins_title;
	}

	public String getIns_content()
	{
		return ins_content;
	}

	public void setIns_content(String ins_content)
	{
		this.ins_content = ins_content;
	}

	public String getIns_importance()
	{
		return ins_importance;
	}

	public void setIns_importance(String ins_importance)
	{
		this.ins_importance = ins_importance;
	}

	public Timestamp getIns_target_datetime()
	{
		return ins_target_datetime;
	}

	public void setIns_target_datetime(Timestamp ins_target_datetime)
	{
		this.ins_target_datetime = ins_target_datetime;
	}

	public String getIns_favorite_flg()
	{
		return ins_favorite_flg;
	}

	public void setIns_favorite_flg(String ins_favorite_flg)
	{
		this.ins_favorite_flg = ins_favorite_flg;
	}


}
