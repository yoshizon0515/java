package web.flatremainder.app.F005;

import java.math.BigDecimal;
import java.util.List;

import web.flatremainder.annotation.Resettable;
import web.flatremainder.common.model.SelectBox;
import web.flatremainder.domain.F005.model.F005_FindList;

public class F005_Form
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

	// 指定日時(yyyymmdd hh:mm) from
	@Resettable
	private String from_target_date;
	
	//指定日時(yyyymmdd hh:mm) to
	@Resettable
	private String to_target_date;
	
	// 更新日時
	@Resettable
	private String from_upd_date;

	// 更新日時
	@Resettable
	private String to_upd_date;

	// お気に入りフラグ
	@Resettable
	private String favorite_flg;
	// 削除フラグ
	@Resettable
	private String del_flg;
	
	//セレクトリスト番号
	@Resettable
	private BigDecimal selectIndex;
	
	//一覧表示用リスト
	private List<F005_FindList> findList;
	
	
	private List<SelectBox> article_cls_select;
	
	private List<SelectBox> category_select;
	
	private List<SelectBox> importance_select;

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

	public String getFrom_target_date()
	{
		return from_target_date;
	}

	public void setFrom_target_date(String from_target_date)
	{
		this.from_target_date = from_target_date;
	}

	public String getTo_target_date()
	{
		return to_target_date;
	}

	public void setTo_target_date(String to_target_date)
	{
		this.to_target_date = to_target_date;
	}

	public String getFrom_upd_date()
	{
		return from_upd_date;
	}

	public void setFrom_upd_date(String from_upd_date)
	{
		this.from_upd_date = from_upd_date;
	}

	public String getTo_upd_date()
	{
		return to_upd_date;
	}

	public void setTo_upd_date(String to_upd_date)
	{
		this.to_upd_date = to_upd_date;
	}

	public String getFavorite_flg()
	{
		return favorite_flg;
	}

	public void setFavorite_flg(String favorite_flg)
	{
		this.favorite_flg = favorite_flg;
	}

	public String getDel_flg()
	{
		return del_flg;
	}

	public void setDel_flg(String del_flg)
	{
		this.del_flg = del_flg;
	}

	public BigDecimal getSelectIndex()
	{
		return selectIndex;
	}

	public void setSelectIndex(BigDecimal selectIndex)
	{
		this.selectIndex = selectIndex;
	}

	public List<F005_FindList> getFindList()
	{
		return findList;
	}

	public void setFindList(List<F005_FindList> findList)
	{
		this.findList = findList;
	}

	public List<SelectBox> getArticle_cls_select()
	{
		return article_cls_select;
	}

	public void setArticle_cls_select(List<SelectBox> article_cls_select)
	{
		this.article_cls_select = article_cls_select;
	}

	public List<SelectBox> getCategory_select()
	{
		return category_select;
	}

	public void setCategory_select(List<SelectBox> category_select)
	{
		this.category_select = category_select;
	}

	public List<SelectBox> getImportance_select()
	{
		return importance_select;
	}

	public void setImportance_select(List<SelectBox> importance_select)
	{
		this.importance_select = importance_select;
	}
	

}
