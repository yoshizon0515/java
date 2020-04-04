package web.flatremainder.util;

import java.util.ResourceBundle;

public class MessageUtil
{

	public static String getMessage(String key)
	{
		return ResourceBundle.getBundle("messages").getString(key);
	}

	public static String getMessage(String... keys)
	{

		ResourceBundle rb = ResourceBundle.getBundle("messages");

		StringBuilder sb = new StringBuilder();

		for (String key : keys)
		{
			sb.append(rb.getString(key));
		}

		return sb.toString();

	}

}
