package com.crestasom.aop.model;

public class Circle {
	private String name;
	private Triangle t;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("Circle Setter is invoked..");
		throw (new RuntimeException("My own exception"));
		// int a = 10 / 0;
	}

	public String getter(String name) {
		this.name = name;
		System.out.println("Circle Setter1 is invoked..");
		return name;
		// int a = 10 / 0;
	}

	public Triangle getT() {
		return t;
	}

	public void setT(Triangle t) {
		this.t = t;
	}

}
