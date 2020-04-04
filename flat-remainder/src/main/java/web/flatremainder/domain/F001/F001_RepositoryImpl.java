package web.flatremainder.domain.F001;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import web.flatremainder.domain.F001.model.F002_Insert;
import web.flatremainder.util.CryptUtil;
import web.flatremainder.util.DateUtil;
import web.flatremainder.util.MessageUtil;

@Repository
public class F001_RepositoryImpl implements F001_Repository
{
	@Autowired
	private NamedParameterJdbcTemplate db;

	public int insertUser(F002_Insert insertEntity) throws InvalidKeyException,
			NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException,
			BadPaddingException
		{
			MapSqlParameterSource params = new MapSqlParameterSource();

			StringBuilder sql = new StringBuilder();

			sql.append("INSERT ");
			sql.append("INTO MST_USER ( ");
			sql.append("  USER_ID ");
			sql.append("  , NICKNAME ");
			sql.append("  , LOGIN_ID ");
			sql.append("  , LOGIN_PASS ");
			sql.append("  , LAST_LOGIN_DATE ");
			sql.append("  , LOGIN_INFO_FLG ");
			sql.append("  , UPD_DATE ");
			sql.append("  , DEL_FLG ");
			sql.append(") ");
			sql.append(" VALUES ( ");
			sql.append(
					" ( SELECT LTRIM(TO_CHAR(MAX(CAST(USER_ID AS INTEGER)) + 1, '099'))  FROM MST_USER )");
			sql.append("  , :nickname ");
			sql.append("  , :login_id ");
			sql.append("  , :login_pass ");
			sql.append("  , ").append(String.format(MessageUtil.getMessage("strutil.dateymdhm.format"), ":last_login_date"));
			sql.append("  , :login_info_flg ");
			sql.append("  , ").append(String.format(MessageUtil.getMessage("strutil.dateymdhm.format"), ":upd_date"));
			sql.append("  , :del_flg ");
			sql.append(") ");

			params.addValue("login_id", insertEntity.getInsert_id());
			params.addValue("nickname", insertEntity.getNickname());
			params.addValue("login_pass", CryptUtil.encrypt(insertEntity.getInsert_password()));
			params.addValue("last_login_date", DateUtil.nowDateTime());
			params.addValue("login_info_flg", "0");
			params.addValue("upd_date", DateUtil.nowDateTime());
			params.addValue("del_flg", "0");

			return db.update(sql.toString(), params);
		}

}
