package web.flatremainder.util;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import web.flatremainder.common.define.ArticleCls;
import web.flatremainder.common.model.FindList;

public class DateUtil
{

	/**
	 * 登録更新用の年月日日時を返す
	 * @return
	 */
	public static String nowDateTime()
	{
		return LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);

	}

	/**
	 * 登録用の年月日を返す
	 * @return
	 */
	public static String nowDate()
	{
		return LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);
	}
	
	/**
	 * 指定日(yyymmdd)と指定時間(hh:mm)を合わせて指定年月日時
	 * 返却する
	 * 
	 */
	public static Timestamp unionDatetime(String target_date, String target_time)
	{
		
		String re = target_date.replaceAll("/", "-");
		
		String format =String.format("%s %s%s", re, target_time, ":00.000");
		
		Timestamp.valueOf(format);
		
		return Timestamp.valueOf(format);
	}
	
	/** 指定表示期間の場合trueを返す*/
	public static <T extends FindList> boolean dispPeriodcheck(T findList, String disp_period)
	{
		//リマインダー以外は無条件でtrueを返す
		if(ObjectUtil.notEquals(ArticleCls.remainder.cd(), findList.getArticle_cls()))
		{
			return true;
		}
		
		boolean result= false;
		Period period  = Period.between(LocalDateTime.now().toLocalDate(),
				findList.getTarget_datetime_row().toLocalDate());

		switch(disp_period)
		{
			case "001":
				result = (Math.abs(period.getDays()) == 0);
				break;
			case "002":
				result = (Math.abs(period.getDays()) <= 3);
				break;
			case "003":
				result = (Math.abs(period.getDays()) <= 7);
				break;
		}
				
		return result;
		
	}
	
	
	
	
}
