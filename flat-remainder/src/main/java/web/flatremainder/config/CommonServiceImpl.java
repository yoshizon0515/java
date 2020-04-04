package web.flatremainder.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.flatremainder.common.define.ArticleCls;
import web.flatremainder.common.model.MST_USER;
import web.flatremainder.common.model.SelectBox;
import web.flatremainder.exception.UpdateException;
import web.flatremainder.util.ObjectUtil;

@Service
public class CommonServiceImpl implements CommonServics
{
	@Autowired
	private CommonRepository repository;

	@Override
	public MST_USER getUserEntityOne(String login_id)
	{
		// memo 同じログインIDは登録させない

		try
		{
			return repository.getUserEntityOne(login_id);

		} catch (Exception e)
		{
			return null;
		}
	}

	@Override
	public void updLastLogindate(String login_id)
	{

		int result = repository.updLastLogindate(login_id);
		if (result != 1)
		{
			throw new UpdateException();
		}

	}

	@Override
	public List<SelectBox> createClsSelectbox(boolean blanks, String clsId)
	{
		List<SelectBox> list = repository.articleClsSelect(blanks, clsId);
		
		if(blanks)
		{
			list.add(0, new SelectBox());
		}
		
		return list;
	}
	
	@Override
	public void updExpiredFlg(String article_cls)
	{
		if(ObjectUtil.notEquals(ArticleCls.remainder.cd(), article_cls))
		{
			return;
		}
		
		repository.updExpiredFlg(article_cls);
	}


	

}
