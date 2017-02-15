package jp.co.kenshu.form;

import lombok.Data;

@Data
public class Sex {
	public Sex(final String key, final String value, int ageAv) {
		this.key = key;
		this.value = value;
		this.ageAv = ageAv;
	}
	private String key;
	private String value;
	private int ageAv;
}
