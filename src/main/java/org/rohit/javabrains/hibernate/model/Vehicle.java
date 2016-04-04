package org.rohit.javabrains.hibernate.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Vehicle {

	@Id @GeneratedValue
	private long vehicleId;
	private String vehicleName;
	
	@ManyToMany(mappedBy="vehicle")
	private Collection<UserDetails> user = new ArrayList<UserDetails>();
	
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	public long getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(long vehicleId) {
		this.vehicleId = vehicleId;
	}
	public Collection<UserDetails> getUser() {
		return user;
	}
	public void setUser(Collection<UserDetails> user) {
		this.user = user;
	}
}
