package web.flatremainder.config;

import java.io.Serializable;

import web.flatremainder.common.model.MST_USER;

public class UserInfomation implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private MST_USER mst_user;

	public void setUserInfomation(MST_USER mst_user)
	{
		this.mst_user = mst_user;
	}

	public void clearUserInfomation()
	{
		this.mst_user = null;
	}

	public boolean hasUserInfo()
	{
		return this.mst_user != null;
	}

	public String getUser_id()
	{
		return this.mst_user.getUser_id();
	}

	public String getNickname()
	{
		return this.mst_user.getNickname();
	}

	public String getLogin_id()
	{
		return this.mst_user.getLogin_id();
	}

	public String getLogin_pass()
	{
		return this.mst_user.getLogin_pass();
	}

	public String getLast_login_date()
	{
		return this.mst_user.getLast_login_date();
	}

	public String getLogin_info_flg()
	{
		return this.mst_user.getLogin_info_flg();
	}

	public String getUpd_date()
	{
		return this.mst_user.getUpd_date();
	}

	public String getDel_flg()
	{
		return this.mst_user.getDel_flg();
	}

}
