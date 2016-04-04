package org.rohit.javabrains.hibernate.model;

import javax.persistence.Entity;

@Entity
public class FourWheeler extends Vehicle {

	private String sterringWheel;

	public String getSterringWheel() {
		return sterringWheel;
	}

	public void setSterringWheel(String sterringWheel) {
		this.sterringWheel = sterringWheel;
	}
	
}
