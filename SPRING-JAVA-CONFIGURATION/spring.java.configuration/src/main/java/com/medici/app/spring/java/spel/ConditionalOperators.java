package com.medici.app.spring.java.spel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConditionalOperators {

	@Value("#{2 > 1 ? 'a' : 'b'}") // "a"
	private String ternary;

	public String getTernary() {
		return ternary;
	}

	public void setTernary(String ternary) {
		this.ternary = ternary;
	}

}
