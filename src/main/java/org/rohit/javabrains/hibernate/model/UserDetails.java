package org.rohit.javabrains.hibernate.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity(name="USER_DETAILS")
public class UserDetails {

	@Id @GeneratedValue(strategy= GenerationType.AUTO)
	private long userId;
	private String userName;
	@Embedded
	@JoinTable(name = "USER_ADDRESSES",joinColumns= @JoinColumn(name="USER_ID"))
	@ElementCollection
	private Collection<Address> listOfAddresses = new ArrayList<Address>();
	
	@OneToMany(cascade=CascadeType.PERSIST)
	@JoinTable(name="USER_VEHICLE",joinColumns=@JoinColumn(name="USER_ID"),inverseJoinColumns=@JoinColumn(name="VEHICLE_ID"))
	private Collection<Vehicle> vehicle = new ArrayList<Vehicle>();
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Collection<Address> getListOfAddresses() {
		return listOfAddresses;
	}
	public void setListOfAddresses(Collection<Address> listOfAddresses) {
		this.listOfAddresses = listOfAddresses;
	}
	public Collection<Vehicle> getVehicle() {
		return vehicle;
	}
	public void setVehicle(Collection<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}
		
	
}
