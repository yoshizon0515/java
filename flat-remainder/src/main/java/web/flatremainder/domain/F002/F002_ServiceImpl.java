package web.flatremainder.domain.F002;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.flatremainder.app.F002.F002_Form;
import web.flatremainder.config.CommonServics;

@Service
public class F002_ServiceImpl implements F002_Service
{
	
	@Autowired
	private CommonServics cmnservice;
	
	@Autowired
	private F002_Repository repository;
	
	public void setSelectBpx(F002_Form form)
	{
		//記事種別（登録）
/*		form.setIns_Article_cls_select(cmnservice.createClsSelectbox(false, ClsId.ARTICLECLS.get()));
		//カテゴリ（登録）
		form.setIns_Category_select(cmnservice.createClsSelectbox(true, ClsId.CATEGORY.get()));
		//重要度（登録）
		form.setIns_Importance_select(cmnservice.createClsSelectbox(false, ClsId.IMPORTANCE.get()));
		
*/	}
	
	@Override
	public void setFirstValue(F002_Form form)
	{
		//記事種別を表示画面からの選択値に
		//form.setArticle_cls("");
		//重要度を「普通」に
		//form.setImportance("002");

	}
	
/*	public void insert(F003_Insert entity)
	{
		int result = repository.insert(entity);
		
		if(result != 1)
		{
			throw new UpdateException();
		}
	}
*/
	

}
