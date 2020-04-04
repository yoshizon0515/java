package web.flatremainder.config;

import java.util.List;

import web.flatremainder.common.model.MST_USER;
import web.flatremainder.common.model.SelectBox;

public interface CommonRepository
{

	public MST_USER getUserEntityOne(String login_id);

	public int updLastLogindate(String login_id);
	
	public List<SelectBox> articleClsSelect(boolean blanks, String clsId);
	
	public void updExpiredFlg(String article_cls);

}
