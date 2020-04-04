package web.flatremainder.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import web.flatremainder.common.model.MST_USER;
import web.flatremainder.common.model.SelectBox;
import web.flatremainder.util.DateUtil;

@Repository
public class CommonRepositoryImpl implements CommonRepository
{
	@Autowired
	private NamedParameterJdbcTemplate db;

	public MST_USER getUserEntityOne(String login_id)
	{

		BeanPropertyRowMapper<MST_USER> mapper = new BeanPropertyRowMapper<>(MST_USER.class);

		MapSqlParameterSource params = new MapSqlParameterSource();

		StringBuilder sql = new StringBuilder();

		sql.append("SELECT ");
		sql.append("  * ");
		sql.append("FROM ");
		sql.append("  MST_USER ");
		sql.append("WHERE ");
		sql.append("  DEL_FLG = '0' ");
		sql.append("  AND LOGIN_ID = :login_id ");

		params.addValue("login_id", login_id);

		return db.queryForObject(sql.toString(), params, mapper);
	}

	public int updLastLogindate(String login_id)
	{
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("login_id", login_id);
		params.addValue("last_login_date", DateUtil.nowDateTime());

		StringBuilder sql = new StringBuilder();

		sql.append("UPDATE MST_USER ");
			
		sql.append("SET ");
		sql.append("  LAST_LOGIN_DATE = TO_TIMESTAMP(:last_login_date, 'YYYY/MM/DD HH24:MI:SS') ");
		sql.append("WHERE ");
		sql.append("  LOGIN_ID = :login_id ");

		// ログイン日付更新
		return db.update(sql.toString(), params);

	}
	
	public List<SelectBox> articleClsSelect(boolean blanks, String clsId)
	{
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		BeanPropertyRowMapper<SelectBox> mapper
			= new BeanPropertyRowMapper<>(SelectBox.class);
		
		StringBuilder sql = new StringBuilder();
		
		sql.append("SELECT ");
		sql.append("  CLS_CD AS VAL, ");
		sql.append("  CLS_NM AS LABEL ");
		sql.append("FROM ");
		sql.append("  MST_CLS ");
		sql.append("WHERE ");
		sql.append("  CLS_ID = :cls_id ");
		sql.append("  AND DEL_FLG = '0' ");
		
		params.addValue("cls_id", clsId);
		
		return db.query(sql.toString(), params, mapper);
	}
	
	
	public void updExpiredFlg(String article_cls)
	{
		StringBuilder sql = new StringBuilder(); 
		MapSqlParameterSource params = new MapSqlParameterSource();
		
		params.addValue("article_cls", article_cls);
		
		sql.append("UPDATE TBL_ARTICLE ");
		sql.append("SET ");
		sql.append("  EXPIRED_FLG = '1' ");
		sql.append("WHERE ");
		sql.append("  TARGET_DATETIME < LOCALTIMESTAMP ");
		sql.append("  AND ARTICLE_CLS = :article_cls ");

		db.update(sql.toString(), params);

	}

	

}



