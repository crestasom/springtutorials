package com.crestasom.dependencyInjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		// ApplicationContext context = new
		// ClassPathXmlApplicationContext("spring.xml");
		ApplicationContext context = new AnnotationConfigApplicationContext();
		Car car = (Car) context.getBean("car");
		// Car car = new Car();

		Tyre t = (Tyre) context.getBean("tyre");
		car.setTyre(t);

		car.drive();
	}
}
