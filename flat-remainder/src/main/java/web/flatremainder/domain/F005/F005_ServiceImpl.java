package web.flatremainder.domain.F005;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.flatremainder.app.F005.F005_Form;
import web.flatremainder.common.define.ClsId;
import web.flatremainder.config.CommonServics;

@Service
public class F005_ServiceImpl implements F005_Service
{
	
	
	@Autowired
	private CommonServics cmnservice;
	
	public void setSelectBpx(F005_Form form)
	{

		//記事種別（登録）
		form.setArticle_cls_select(cmnservice.createClsSelectbox(false, ClsId.ARTICLECLS.get()));
		//カテゴリ（登録）
		form.setCategory_select(cmnservice.createClsSelectbox(true, ClsId.CATEGORY.get()));
		//重要度（登録）
		form.setImportance_select(cmnservice.createClsSelectbox(false, ClsId.IMPORTANCE.get()));

	}
	
	@Override
	public void setFirstValue(F005_Form form)
	{
		
		//記事種別を"001"（リマインダー）
		form.setArticle_cls("001");
		
		//重要度(登録) を"002"
		form.setImportance("002");

	}


}
