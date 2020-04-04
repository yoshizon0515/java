package web.flatremainder.util;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

public class DebugUtil
{

	public static void printSql(String sql, MapSqlParameterSource params)
	{

		System.out.println("------------------------");
		System.out.println(sql);

		for (String paramName : params.getParameterNames())
		{

			if (params.getValue(paramName) instanceof String)
			{
				System.out.println(
						String.format("--* SetParameter %s %s String ", paramName, params.getValue(paramName)));

			} else if (params.getValue(paramName) instanceof Integer
					|| params.getValue(paramName) instanceof BigDecimal)
			{
				System.out.println(
						String.format("--* SetParameter %s %s Integer ", paramName, params.getValue(paramName)));

			} else if (params.getValue(paramName) instanceof LocalDate)
			{
				System.out
						.println(String.format("--* SetParameter %s %s DATE ", paramName, params.getValue(paramName)));

			} else if (params.getValue(paramName) instanceof LocalDateTime
					|| "sysdate".equals(params.getValue(paramName).toString().toLowerCase()))
			{
				System.out.println(
						String.format("--* SetParameter %s %s DateTime ", paramName, params.getValue(paramName)));

			}

		}

		System.out.println("------------------------");

	}

}
