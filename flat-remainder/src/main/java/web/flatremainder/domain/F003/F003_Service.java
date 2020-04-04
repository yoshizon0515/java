package web.flatremainder.domain.F003;

import java.util.List;

import web.flatremainder.app.F003.F003_Form;
import web.flatremainder.domain.F003.model.F003_FindList;
import web.flatremainder.domain.F003.model.F003_Insert;

public interface F003_Service
{

	/**
	 * セレクトボックス設定
	 * @param form
	 */
	public void setSelectBpx(F003_Form form);
	
	
	public void setFirstValue(F003_Form form);
	
	/**
	 * リスト検索
	 */
	public List<F003_FindList> findAll(String user_id);
	
	/*
	 *記事登録処理 
	 */
	public void insert(F003_Insert entity);

}
