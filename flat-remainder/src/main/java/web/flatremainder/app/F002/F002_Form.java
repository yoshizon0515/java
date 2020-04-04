package web.flatremainder.app.F002;

import java.util.List;

import web.flatremainder.annotation.Resettable;
import web.flatremainder.common.model.SelectBox;

public class F002_Form
{
	
	/** 登録側 */
	//ユーザID
	@Resettable
	private String user_id;
	
	// 記事種別
	@Resettable
	private String ins_article_cls;

	// カテゴリ
	@Resettable
	private String ins_category;

	// タイトル
	@Resettable
	private String ins_title;

	// 内容
	@Resettable
	private String ins_content;

	// 重要度
	@Resettable
	private String ins_importance;

	// 指定日(yyyymmdd)(登録)
	@Resettable
	private String ins_target_date;

	// 指定時間(hh:mm)(登録)
	@Resettable
	private String ins_target_time;

	// お気に入りフラグ
	@Resettable
	private String ins_favorite_flg;

	// 記事種別セレクトボックス
	@Resettable List<SelectBox> ins_article_cls_select;

	// 重要度セレクトボックス
	private List<SelectBox> ins_importance_select;

	// カテゴリーセレクトボックス
	private List<SelectBox> ins_category_select;

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

	public String getIns_target_date()
	{
		return ins_target_date;
	}

	public void setIns_target_date(String ins_target_date)
	{
		this.ins_target_date = ins_target_date;
	}

	public String getIns_target_time()
	{
		return ins_target_time;
	}

	public void setIns_target_time(String ins_target_time)
	{
		this.ins_target_time = ins_target_time;
	}

	public String getIns_favorite_flg()
	{
		return ins_favorite_flg;
	}

	public void setIns_favorite_flg(String ins_favorite_flg)
	{
		this.ins_favorite_flg = ins_favorite_flg;
	}

	public List<SelectBox> getIns_article_cls_select()
	{
		return ins_article_cls_select;
	}

	public void setIns_article_cls_select(List<SelectBox> ins_article_cls_select)
	{
		this.ins_article_cls_select = ins_article_cls_select;
	}

	public List<SelectBox> getIns_importance_select()
	{
		return ins_importance_select;
	}

	public void setIns_importance_select(List<SelectBox> ins_importance_select)
	{
		this.ins_importance_select = ins_importance_select;
	}

	public List<SelectBox> getIns_category_select()
	{
		return ins_category_select;
	}

	public void setIns_category_select(List<SelectBox> ins_category_select)
	{
		this.ins_category_select = ins_category_select;
	}


}
