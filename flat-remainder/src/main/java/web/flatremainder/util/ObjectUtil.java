package web.flatremainder.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import web.flatremainder.annotation.Resettable;
import web.flatremainder.common.define.ArtHeadColor;
import web.flatremainder.common.define.ArticleCls;
import web.flatremainder.common.model.FindList;
import web.flatremainder.common.model.MST_USER;

public class ObjectUtil
{

	/**
	 * 文字列が一致した場合falseを返す
	 */
	public static boolean notEquals(String src, String target)
	{
			return !src.equals(target);
	}

	/**
	 * @Resettableアノテーションがついているフィールドを探してnullを代入
	 * @param src
	 * @param type
	 */
	public static void reset(Object src)
	{
		reset(src, Resettable.class);
	}

	public static <T extends Annotation> void reset(Object src, Class<T> type)
	{
		try
		{
			for (Field field : src.getClass().getDeclaredFields())
			{
				field.setAccessible(true);

				if (field.isAnnotationPresent(type))
				{
					if (field.getClass().equals(boolean.class) || field.getClass().equals(Boolean.class))
					{
						field.set(src, false);
					} 
					else if (field.getClass().equals(int.class))
					{
						field.set(src, 0);
					}
					else
					{
						field.set(src, null);
					}

				}

			}
		} 
		catch (RuntimeException | IllegalAccessException e)
		{
			throw new RuntimeException();
		}
	}

	/**
	 * ログインユーザのニックネームを表示。nullであればログインID
	 * 
	 * @param user
	 * @return
	 */
	public static Map<String, String> dispUserNm(MST_USER userinfo) throws Exception
	{	
			if(userinfo == null || !(userinfo instanceof  MST_USER))
			{
				throw new Exception();
			}
		
			Map<String, String> map = new HashMap<>();

			map.put("disp_name", (StringUtils.isEmpty(userinfo.getNickname()) ? userinfo.getLogin_id()
					: userinfo.getNickname()));
			
			return map;
	}
	
	
	public static <T extends FindList> void setArtHeaderColor(T entity)
	{
		
		String color = "";
		
		if(ArticleCls.remainder.cd().equals(entity.getArticle_cls()))
		{
			//リマインダー
			if("1".equals(entity.getExpired_flg()))
			{
				//期限切れ
				color = ArtHeadColor.glay.getColor();
			}
			else
			{
				color = getHeadColrNmForImp(entity.getImportance());
			}

		}
		else
		{
			//メモ
			
			color = getHeadColrNmForImp(entity.getImportance());
			
		}
		
		entity.setHead_color_class(color);
	}
	
	/**
	 * 重要度からカラークラス名を取得
	 * @param importance
	 * @return
//	 */
	public static String getHeadColrNmForImp(String importance)
	{
		
		String result = "";
		
		switch(importance)
		{
		
		 	case "001"://重要度：低い
		 		result = ArtHeadColor.lightBule.getColor();
		 		break;
		 	case "002"://重要度：普通
		 		result = ArtHeadColor.lightGreen.getColor();
		 		break;
		 	case "003"://重要度：重要
		 		result = ArtHeadColor.pink.getColor();
		 		break;
		 	default:
		 		result = ArtHeadColor.glay.getColor();
		 		break;
		}
		
		return result;

	}

}
