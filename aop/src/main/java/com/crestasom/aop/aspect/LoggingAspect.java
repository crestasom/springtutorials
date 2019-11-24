package com.crestasom.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import com.crestasom.aop.model.Triangle;

@Aspect
public class LoggingAspect {

	/**
	 * * means one or more .. means zero or more
	 */
	/*
	 * @Before("allCircleMetthodUsingWithIn()") public void loggingAdvice(JoinPoint
	 * joinPoint) { System.out.println(joinPoint.getTarget()); }
	 */

	/*
	 * @Before("args(name)") public void argsString(String name) {
	 * System.out.println("Method with one string argument invoked. The value is " +
	 * name); }
	 */

	/*
	 * @After("args(name)") public void argsString(String name) {
	 * System.out.println("Method with one string argument invoked. The value is " +
	 * name); }
	 */

	@After("args(triangle)")
	public void argsTriangle(Triangle triangle) {
		System.out.println("Method with one triangle argument invoked. The value is " + triangle.getName());
	}

	@AfterReturning(pointcut = "args(name)", returning = "returnString")
	public void argsString(String name, String returnString) {
		System.out.println("Method with one string argument invoked. The value is " + name + ". The returned value is "
				+ returnString);
	}

	@AfterThrowing(pointcut = "args(String)",throwing = "ex")
	public void argsStringExceptionThrown(RuntimeException ex) {
		System.out.println("Exception is thrown "+ex.getMessage());
	}
	/*
	 * @Before("allGetters()") public void secondAdvice() {
	 * System.out.println("Second Advice Executed"); }
	 * 
	 * @Pointcut("execution(* get*(..))") public void allGetters() { }
	 */
	/*
	 * @Pointcut("execution(* com.crestasom.aop.model.Circle*(..))") public void
	 * allCircleMethod() { }
	 */

	@Pointcut("within(com.crestasom.aop.model.Circle)")
	public void allCircleMetthodUsingWithIn() {

	}
}
