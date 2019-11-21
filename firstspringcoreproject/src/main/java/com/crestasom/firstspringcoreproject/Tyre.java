package com.crestasom.firstspringcoreproject;

import org.springframework.stereotype.Component;

@Component
public class Tyre {

	private String brands;

	public Tyre() {

	}

	public Tyre(String brands) {

		this.brands = brands;
	}

	public String getBrands() {
		return brands;
	}

	public void setBrands(String brands) {
		this.brands = brands;
	}

	@Override
	public String toString() {
		// return "Tyre [brands=" + brands + "]";
		return "tyre";
	}

}
