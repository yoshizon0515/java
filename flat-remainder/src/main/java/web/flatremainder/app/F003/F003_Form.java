package web.flatremainder.app.F003;

import java.util.List;

import web.flatremainder.annotation.ModalResettable;
import web.flatremainder.annotation.Resettable;
import web.flatremainder.common.model.SelectBox;
import web.flatremainder.domain.F003.model.F003_FindList;

public class F003_Form
{
	// ユーザID
	@Resettable
	private String user_id;
	
	/** 表示側 */
	// 表示名
	@Resettable
	private String disp_user;

	// 記事種別
	@Resettable
	private String article_cls;
	
	// 記事種別名
	@Resettable
	private String article_cls_nm;


	// 表示期間
	@Resettable
	private String disp_period;

	// リマインダー／メモID
	@Resettable
	private String rem_id;

	// タイトル
	@Resettable
	private String title;

	// 内容
	@Resettable
	private String content;

	// カテゴリ
	@Resettable
	private String category;

	// 重要度
	@Resettable
	private String importance;

	// 指定日時(yyyymmdd hh:mm)
	@Resettable
	private String target_datetime;

	// 期限切れフラグ
	@Resettable
	private String expired_flg;

	// お気に入りフラグ
	@Resettable
	private String favorite_flg;

	// 更新日時
	@Resettable
	private String upd_date;

	// 削除フラグ
	@Resettable
	private String del_flg;
		

	// 記事種別セレクトボックス
	@Resettable
	private List<SelectBox> article_cls_select;

	// 表示期間セレクトボックス
	@Resettable
	private List<SelectBox> disp_period_select;
	
	// 記事種別
	@Resettable
	@ModalResettable
	private String ins_article_cls;

	// カテゴリ
	@Resettable
	@ModalResettable
	private String ins_category;

	// タイトル
	@Resettable
	@ModalResettable
	private String ins_title;
	
	// 内容
	@Resettable
	@ModalResettable
	private String ins_content;

	// 重要度
	@Resettable
	@ModalResettable
	private String ins_importance;

	// 指定日(yyyymmdd)(登録)
	@Resettable
	@ModalResettable
	private String ins_target_date;

	// 指定時間(hh:mm)(登録)
	@Resettable
	@ModalResettable
	private String ins_target_time;

	// お気に入りフラグ
	@Resettable
	@ModalResettable
	private String ins_favorite_flg;

	// 記事種別セレクトボックス
	private List<SelectBox> ins_article_cls_select;

	// 重要度セレクトボックス
	private List<SelectBox> ins_importance_select;

	// カテゴリーセレクトボックス
	private List<SelectBox> ins_category_select;

	//表示用リスト
	private List<F003_FindList> findList;
	
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

	public String getArticle_cls_nm()
	{
		return article_cls_nm;
	}

	public void setArticle_cls_nm(String article_cls_nm)
	{
		this.article_cls_nm = article_cls_nm;
	}

	public String getDisp_period()
	{
		return disp_period;
	}

	public void setDisp_period(String disp_period)
	{
		this.disp_period = disp_period;
	}

	public String getRem_id()
	{
		return rem_id;
	}

	public void setRem_id(String rem_id)
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

	public List<SelectBox> getArticle_cls_select()
	{
		return article_cls_select;
	}

	public void setArticle_cls_select(List<SelectBox> article_cls_select)
	{
		this.article_cls_select = article_cls_select;
	}

	public List<SelectBox> getDisp_period_select()
	{
		return disp_period_select;
	}

	public void setDisp_period_select(List<SelectBox> disp_period_select)
	{
		this.disp_period_select = disp_period_select;
	}

	public List<F003_FindList> getFindList()
	{
		return findList;
	}

	public void setFindList(List<F003_FindList> findList)
	{
		this.findList = findList;
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