package org.ics.ejb;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TypedQuery;


@Entity
@NamedQueries({
	@NamedQuery(name="GymMember.findAll",
			query="SELECT g FROM GymMember g"),
	@NamedQuery(name="GymMember.findByAddress",
			query="SELECT g FROM GymMember g WHERE g.address LIKE :address"),})

@Table(name="GymMember")
@SequenceGenerator(name="ID_SEQ", allocationSize=1)
public class GymMember implements Serializable{

	private long memberId;
	private String name;
	private String email;
	private String phoneNumber;
	private String address;
	private Set<Booking> bookings;
	public GymMember () {
	}
	
	public GymMember(long memberId, String name, String email, String phonenumber, String address, Set<Booking> bookings) {
		this.memberId = memberId;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.bookings = bookings;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="memberId")
	public long getMemberId() {
		return memberId;
	}
	public void setMemberId(long memberId) {
		this.memberId=memberId;
	}
	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name="email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name="phoneNumber")
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	@Column(name="address")
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@OneToMany(mappedBy="gymMember", fetch=FetchType.EAGER) 
	public Set<Booking> getBookings() {
		return bookings; 
	}
	public void setBookings(Set<Booking> bookings) { 
		this.bookings = bookings;
		}
	
}