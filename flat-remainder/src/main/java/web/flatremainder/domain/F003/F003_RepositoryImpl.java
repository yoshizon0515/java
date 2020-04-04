package web.flatremainder.domain.F003;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import web.flatremainder.domain.F003.model.F003_FindList;
import web.flatremainder.domain.F003.model.F003_Insert;
import web.flatremainder.util.DateUtil;
import web.flatremainder.util.MessageUtil;

@Repository
public class F003_RepositoryImpl implements F003_Repository
{
	
	@Autowired
	private NamedParameterJdbcTemplate db;	
	
	public List<F003_FindList> findAll(String user_id)
	{
		
		BeanPropertyRowMapper<F003_FindList> mapper
		    = new BeanPropertyRowMapper<>(F003_FindList.class);
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		
		StringBuilder sql = new StringBuilder();
		
		sql.append("SELECT ");
		sql.append("ART.USER_ID ");
		sql.append(", ART.ARTICLE_CLS ");
		sql.append(", CLS_ART.CLS_NM AS ARTICLE_CLS_NM ");
		sql.append(", ART.REM_ID ");
		sql.append(", ART.TITLE ");
		sql.append(", ART.CONTENT ");
		sql.append(", CLS_CATE.CLS_NM AS CATEGORY ");
		sql.append(", CLS_IMP.CLS_NM AS IMPORTANCE_NM ");
		sql.append(", ART.IMPORTANCE ");
		sql.append(", ART.TARGET_DATETIME AS TARGET_DATETIME_ROW ");
		sql.append(", TO_CHAR(ART.TARGET_DATETIME, 'YYYY/MM/DD HH24:MI') AS TARGET_DATETIME ");
		sql.append(", ART.EXPIRED_FLG ");
		sql.append(", ART.FAVORITE_FLG ");
		sql.append(", TO_CHAR(ART.UPD_DATE, 'YYYY/MM/DD HH24:MI') AS UPD_DATE ");
		sql.append(", ART.DEL_FLG ");
		sql.append("FROM ");
		sql.append("  TBL_ARTICLE ART ");
		sql.append("  LEFT OUTER JOIN MST_CLS CLS_CATE ");
		sql.append("    ON CLS_CATE.CLS_ID = '001' ");
		sql.append("	AND CLS_CATE.CLS_CD = ART.CATEGORY ");
		sql.append("  LEFT OUTER JOIN MST_CLS CLS_IMP ");
		sql.append("    ON CLS_IMP.CLS_ID = '002' ");
		sql.append("	AND CLS_IMP.CLS_CD = ART.IMPORTANCE ");
		sql.append("  LEFT OUTER JOIN MST_CLS CLS_ART ");
		sql.append("    ON CLS_ART.CLS_ID = '003' ");
		sql.append("	AND CLS_ART.CLS_CD = ART.ARTICLE_CLS ");
		sql.append("WHERE ");
		sql.append("  ART.DEL_FLG  = '0' ");
		sql.append("  AND USER_ID = :user_id ");
		sql.append("ORDER BY ");
		sql.append("  ART.EXPIRED_FLG NULLS FIRST ");
		sql.append("  , ART.TARGET_DATETIME DESC ");
		sql.append("  , ART.REM_ID ");
		

		params.addValue("user_id", user_id);
		
		return db.query(sql.toString(), params, mapper); 
	}
 

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
		
		params.addValue("ins_article_cls", entity.getIns_article_cls());
		params.addValue("user_id", entity.getUser_id());
		params.addValue("ins_title", entity.getIns_title());
		params.addValue("ins_content", entity.getIns_content());
		params.addValue("ins_category", entity.getIns_category());
		params.addValue("ins_importance", entity.getIns_importance());
		params.addValue("ins_target_datetime", entity.getIns_target_datetime());
		params.addValue("ins_favorite_flg", entity.getIns_favorite_flg());
		params.addValue("upd_date", DateUtil.nowDateTime());
		
		return db.update(sql.toString(), params);
		
	}


}
