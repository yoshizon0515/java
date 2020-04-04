package web.flatremainder.common.model;

public class MST_USER
{
	private String user_id;
	private String nickname;
	private String login_id;
	private String login_pass;
	private String last_login_date;
	private String login_info_flg;
	private String upd_date;
	private String del_flg;

	public String getUser_id()
	{
		return user_id;
	}

	public void setUser_id(String user_id)
	{
		this.user_id = user_id;
	}

	public String getNickname()
	{
		return nickname;
	}

	public void setNickname(String nickname)
	{
		this.nickname = nickname;
	}

	public String getLogin_id()
	{
		return login_id;
	}

	public void setLogin_id(String login_id)
	{
		this.login_id = login_id;
	}

	public String getLogin_pass()
	{
		return login_pass;
	}

	public void setLogin_pass(String login_pass)
	{
		this.login_pass = login_pass;
	}

	public String getLast_login_date()
	{
		return last_login_date;
	}

	public void setLast_login_date(String last_login_date)
	{
		this.last_login_date = last_login_date;
	}

	public String getLogin_info_flg()
	{
		return login_info_flg;
	}

	public void setLogin_info_flg(String login_info_flg)
	{
		this.login_info_flg = login_info_flg;
	}

	public String getUpd_date()
	{
		return upd_date;
	}

	public void setUpd_date(String upd_date)
	{
		this.upd_date = upd_date;
	}

	public String getDel_flg()
	{
		return del_flg;
	}

	public void setDel_flg(String del_flg)
	{
		this.del_flg = del_flg;
	}

}
