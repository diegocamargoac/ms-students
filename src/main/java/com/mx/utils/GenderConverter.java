package com.mx.utils;

import com.mx.enums.Gender;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class GenderConverter implements Converter<String, Gender> {

	@Override
	public Gender convert(String source) {
		return Gender.valueOf(source.toUpperCase());
	}
	
}
