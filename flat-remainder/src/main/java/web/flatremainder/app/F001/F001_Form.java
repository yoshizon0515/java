package web.flatremainder.app.F001;

import web.flatremainder.annotation.Resettable;

public class F001_Form
{
	@Resettable
	private String login_id;
	@Resettable
	private String login_pass;
	@Resettable
	private String insert_id;
	@Resettable
	private String insert_password;
	@Resettable
	private String nickname;

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

	public String getInsert_id()
	{
		return insert_id;
	}

	public void setInsert_id(String insert_id)
	{
		this.insert_id = insert_id;
	}

	public String getInsert_password()
	{
		return insert_password;
	}

	public void setInsert_password(String insert_password)
	{
		this.insert_password = insert_password;
	}

	public String getNickname()
	{
		return nickname;
	}

	public void setNickname(String nickname)
	{
		this.nickname = nickname;
	}

}
