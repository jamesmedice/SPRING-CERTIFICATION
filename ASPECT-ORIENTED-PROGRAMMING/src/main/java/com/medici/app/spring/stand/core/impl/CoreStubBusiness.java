package com.medici.app.spring.stand.core.impl;

import java.util.Calendar;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Component;

import com.medici.app.spring.stand.core.CoreSingleMarket;
import com.medici.app.spring.stereotype.AspectAnnotation;

@Caching
@Component
public class CoreStubBusiness implements CoreSingleMarket {

	@Override
	public Map<Integer, Long> getTimerSeq() {
		Map<Integer, Long> mapped = new TreeMap<>();
		mapped.put(100, Calendar.getInstance().getTimeInMillis());
		mapped.put(102, Calendar.getInstance().getTimeInMillis());
		mapped.put(101, Calendar.getInstance().getTimeInMillis());
		mapped.put(103, Calendar.getInstance().getTimeInMillis());
		return mapped;
	}

	public void showMapping() {
		System.out.println(getTimerSeq().values().toString());
	}

	@AspectAnnotation(name = "AspectAnnotation")
	public String sysAspectAnnotation(String arg1) {
		String string = "AspectAnnotation:" + arg1;
		System.out.println(string);
		return string;
	}

}
