package web.flatremainder.domain.F003;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.flatremainder.app.F003.F003_Form;
import web.flatremainder.common.define.ClsId;
import web.flatremainder.config.CommonServics;
import web.flatremainder.domain.F003.model.F003_FindList;
import web.flatremainder.domain.F003.model.F003_Insert;
import web.flatremainder.exception.UpdateException;

@Service
public class F003_ServiceImpl implements F003_Service
{
	@Autowired
	private CommonServics cmnservice;
	
	@Autowired
	private F003_Repository repository;

	public void setSelectBpx(F003_Form form)
	{
		//記事種別（表示）
		form.setArticle_cls_select(cmnservice.createClsSelectbox(false, ClsId.ARTICLECLS.get()));
		//表示期間（表示）
		form.setDisp_period_select(cmnservice.createClsSelectbox(false, ClsId.DISPPERIOD.get()));	
		
		//記事種別（登録）
		form.setIns_article_cls_select(cmnservice.createClsSelectbox(false, ClsId.ARTICLECLS.get()));
		//カテゴリ（登録）
		form.setIns_category_select(cmnservice.createClsSelectbox(true, ClsId.CATEGORY.get()));
		//重要度（登録）
		form.setIns_importance_select(cmnservice.createClsSelectbox(false, ClsId.IMPORTANCE.get()));

	}
	
	@Override
	public void setFirstValue(F003_Form form)
	{
		//表示期間を「前後3日」に
		form.setDisp_period("002");
		
		//記事種別を"001"（リマインダー）
		form.setArticle_cls("001");
		
		//重要度(登録) を"002"
		form.setIns_importance("002");

	}
	


	@Override
	public List<F003_FindList> findAll(String user_id)
	{
		return repository.findAll(user_id);
	}
	
	@Override
	public void insert(F003_Insert entity)
	{
		int result = repository.insert(entity);
		
		if(result != 1)
		{
			throw new UpdateException();
		}
	}




}
