package com.nineton.calendar.converter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter implements Converter<String, Date> {

	@Override
	public Date convert(String source) {
		if(StringUtils.isNotBlank(source)){
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try {
				return simpleDateFormat.parse(source);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}		
		return null;
	}

}
