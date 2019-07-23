package com.medici.app.spring.stand.core;

import java.util.Map;

public interface CoreTransferMarket {

	void transfer(String accountA, String accountB, Long amount);

	Double checkBalance(String account);

	Long withdrawal(String account, Long amount);

	void diposite(String account, Long amount);

	  Map<Integer, Long> getTimerSeq();
}
