package com.medici.app.spring.java.spel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("RLogical")
public class RelationalLogicalOperators {

	public int getTotal() {
		return 10000;
	};

	@Value("#{1 == 1}") // true
	private boolean equal;

	@Value("#{1 eq 1}") // true
	private boolean equalAlphabetic;

	@Value("#{1 != 1}") // false
	private boolean notEqual;

	@Value("#{1 ne 1}") // false
	private boolean notEqualAlphabetic;

	@Value("#{1 < 1}") // false
	private boolean lessThan;

	@Value("#{1 lt 1}") // false
	private boolean lessThanAlphabetic;

	@Value("#{1 <= 1}") // true
	private boolean lessThanOrEqual;

	@Value("#{1 le 1}") // true
	private boolean lessThanOrEqualAlphabetic;

	@Value("#{1 > 1}") // false
	private boolean greaterThan;

	@Value("#{1 gt 1}") // false
	private boolean greaterThanAlphabetic;

	@Value("#{1 >= 1}") // true
	private boolean greaterThanOrEqual;

	@Value("#{1 ge 1}") // true
	private boolean greaterThanOrEqualAlphabetic;

	public boolean isEqual() {
		return equal;
	}

	public void setEqual(boolean equal) {
		this.equal = equal;
	}

	public boolean isEqualAlphabetic() {
		return equalAlphabetic;
	}

	public void setEqualAlphabetic(boolean equalAlphabetic) {
		this.equalAlphabetic = equalAlphabetic;
	}

	public boolean isNotEqual() {
		return notEqual;
	}

	public void setNotEqual(boolean notEqual) {
		this.notEqual = notEqual;
	}

	public boolean isNotEqualAlphabetic() {
		return notEqualAlphabetic;
	}

	public void setNotEqualAlphabetic(boolean notEqualAlphabetic) {
		this.notEqualAlphabetic = notEqualAlphabetic;
	}

	public boolean isLessThan() {
		return lessThan;
	}

	public void setLessThan(boolean lessThan) {
		this.lessThan = lessThan;
	}

	public boolean isLessThanAlphabetic() {
		return lessThanAlphabetic;
	}

	public void setLessThanAlphabetic(boolean lessThanAlphabetic) {
		this.lessThanAlphabetic = lessThanAlphabetic;
	}

	public boolean isLessThanOrEqual() {
		return lessThanOrEqual;
	}

	public void setLessThanOrEqual(boolean lessThanOrEqual) {
		this.lessThanOrEqual = lessThanOrEqual;
	}

	public boolean isLessThanOrEqualAlphabetic() {
		return lessThanOrEqualAlphabetic;
	}

	public void setLessThanOrEqualAlphabetic(boolean lessThanOrEqualAlphabetic) {
		this.lessThanOrEqualAlphabetic = lessThanOrEqualAlphabetic;
	}

	public boolean isGreaterThan() {
		return greaterThan;
	}

	public void setGreaterThan(boolean greaterThan) {
		this.greaterThan = greaterThan;
	}

	public boolean isGreaterThanAlphabetic() {
		return greaterThanAlphabetic;
	}

	public void setGreaterThanAlphabetic(boolean greaterThanAlphabetic) {
		this.greaterThanAlphabetic = greaterThanAlphabetic;
	}

	public boolean isGreaterThanOrEqual() {
		return greaterThanOrEqual;
	}

	public void setGreaterThanOrEqual(boolean greaterThanOrEqual) {
		this.greaterThanOrEqual = greaterThanOrEqual;
	}

	public boolean isGreaterThanOrEqualAlphabetic() {
		return greaterThanOrEqualAlphabetic;
	}

	public void setGreaterThanOrEqualAlphabetic(boolean greaterThanOrEqualAlphabetic) {
		this.greaterThanOrEqualAlphabetic = greaterThanOrEqualAlphabetic;
	}

}
