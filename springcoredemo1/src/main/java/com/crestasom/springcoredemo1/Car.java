package com.crestasom.springcoredemo1;

import org.springframework.stereotype.Component;

@Component
public class Car {

	private String name;
	private Tyre tyre;

	public Tyre getTyre() {
		return tyre;
	}

	public void setTyre(Tyre tyre) {
		this.tyre = tyre;
	}

	public Car() {

	}

	public Car(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void run() {
		System.out.println(name + " car is running with " + tyre + " Tyre");
	}

}
