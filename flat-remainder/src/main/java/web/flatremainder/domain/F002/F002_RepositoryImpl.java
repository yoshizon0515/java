package web.flatremainder.domain.F002;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import web.flatremainder.domain.F003.model.F003_Insert;
import web.flatremainder.util.MessageUtil;

@Repository
public class F002_RepositoryImpl implements F002_Repository
{

	@Autowired
	private NamedParameterJdbcTemplate db;

	public int insert(F003_Insert entity)
	{
		MapSqlParameterSource params
		    = new MapSqlParameterSource();
		StringBuilder sql = new StringBuilder();
		
		sql.append("INSERT ");
		sql.append("INTO TBL_ARTICLE( ");
		sql.append("  USER_ID ");
		sql.append("  , ARTICLE_CLS ");
		sql.append("  , REM_ID ");
		sql.append("  , TITLE ");
		sql.append("  , CONTENT ");
		sql.append("  , CATEGORY ");
		sql.append("  , IMPORTANCE ");
		sql.append("  , TARGET_DATETIME ");
		sql.append("  , EXPIRED_FLG ");
		sql.append("  , FAVORITE_FLG ");
		sql.append("  , UPD_DATE ");
		sql.append("  , DEL_FLG ");
		sql.append(") ");
		sql.append("VALUES ( ");
		sql.append("  :user_id ");
		sql.append("  , :ins_article_cls ");
		sql.append("  , COALESCE( ");
		sql.append("      (SELECT ");
		sql.append("         MAX(REM_ID) + 1 ");
		sql.append("       FROM ");
		sql.append("         TBL_ARTICLE ");
		sql.append("        WHERE ");
		sql.append("          USER_ID = :user_id ");
		sql.append("          AND ARTICLE_CLS = :ins_article_cls ");
		sql.append("    ), 1 ) ");
		sql.append("  , :ins_title ");
		sql.append("  , :ins_content ");
		sql.append("  , :ins_category ");
		sql.append("  , :ins_importance ");
		sql.append("  , :ins_target_datetime ");
		sql.append("  , null ");
		sql.append("  , :ins_favorite_flg ");
		sql.append("  , ").append(String.format(MessageUtil.getMessage("strutil.dateymdhm.format"), ":upd_date"));
		sql.append("  , '0' ");
		sql.append(") ");
		
/*		params.addValue("ins_article_cls", entity.getArticle_cls());
		params.addValue("user_id", entity.getUser_id());
		params.addValue("ins_title", entity.getTitle());
		params.addValue("ins_content", entity.getContent());
		params.addValue("ins_category", entity.getCategory());
		params.addValue("ins_importance", entity.getImportance());
		params.addValue("ins_target_datetime", entity.getTarget_datetime());
		params.addValue("ins_favorite_flg", entity.getFavorite_flg());
		params.addValue("upd_date", DateUtil.nowDateTime());
*/		
		return db.update(sql.toString(), params);
		
	}

}
