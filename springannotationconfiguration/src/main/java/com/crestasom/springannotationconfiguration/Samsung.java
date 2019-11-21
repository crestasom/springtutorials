package com.crestasom.springannotationconfiguration;

import org.springframework.beans.factory.annotation.Autowired;

public class Samsung {

	@Autowired
	MobileProcessor cpu;

	public MobileProcessor getCpu() {
		return cpu;
	}

	public void setCpu(MobileProcessor cpu) {
		this.cpu = cpu;
	}

	public void config() {
		System.out.println("4gb ram, 16mp");
		cpu.process();
	}

}
