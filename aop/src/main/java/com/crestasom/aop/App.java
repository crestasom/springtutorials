package com.crestasom.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.crestasom.aop.service.ShapeService;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		ShapeService shapeService = ctx.getBean(ShapeService.class);
		System.out.println(shapeService.getCircle().getName());
		shapeService.getCircle().setName("New Circle");
		((ClassPathXmlApplicationContext) ctx).close();
		shapeService.getCircle().setT(shapeService.getTriangle());
		System.out.println(shapeService.getCircle().getT().getName());

	}
}
