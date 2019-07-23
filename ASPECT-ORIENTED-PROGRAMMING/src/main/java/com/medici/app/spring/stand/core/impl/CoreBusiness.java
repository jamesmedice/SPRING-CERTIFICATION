package com.medici.app.spring.stand.core.impl;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Component;

import com.medici.app.spring.stand.core.CoreTransferMarket;
import com.medici.app.spring.stereotype.AspectAnnotation;

@Component
public class CoreBusiness implements CoreTransferMarket {

	@Override
	public void transfer(String accountA, String accountB, Long amount) {
		System.out.println(amount + " Amount has been tranfered from " + accountA + " to " + accountB);
	}

	@Override
	public Double checkBalance(String account) {
		System.out.println("Available balance: 50000");
		return new Double(50000);
	}

	@Override
	public Long withdrawal(String account, Long amount) {
		System.out.println("Withdrawal amount: " + amount);
		return amount;
	}

	@Override
	public void diposite(String account, Long amount) {
		System.out.println(amount + " Amount has been diposited to " + account);
	}

	public Collection showTimes() {
		Collection streamReaderBytes = streamReaderBytes();
		System.out.println(Calendar.getInstance().getTimeInMillis());
		System.out.println(streamReaderBytes.toArray().toString());
		return streamReaderBytes;
	}

	protected Collection streamReaderBytes() {
		return Arrays.asList(Calendar.getInstance().getTimeInMillis(), Calendar.getInstance().getTimeInMillis(), Calendar.getInstance().getTimeInMillis(), Calendar.getInstance().getTimeInMillis());

	}

	@Override
	public Map<Integer, Long> getTimerSeq() {
		Map<Integer, Long> mapped = new TreeMap<>();
		mapped.put(100, Calendar.getInstance().getTimeInMillis());
		mapped.put(102, Calendar.getInstance().getTimeInMillis());
		mapped.put(101, Calendar.getInstance().getTimeInMillis());
		mapped.put(103, Calendar.getInstance().getTimeInMillis());
		return mapped;
	}

}
