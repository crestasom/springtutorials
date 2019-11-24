package com.crestasom.dependencyInjection;

public class Car {
	String name;
	private Tyre tyre;

	public Tyre getTyre() {
		return tyre;
	}

	public Car() {

	}

	public Car(String name, Tyre tyre) {
		super();
		this.name = name;
		this.tyre = tyre;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTyre(Tyre tyre) {
		this.tyre = tyre;
	}

	public void drive() {
		System.out.println(name + " Car is running with " + tyre);
	}

}
