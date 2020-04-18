package org.ics.ejb;

import java.io.Serializable;
import java.sql.Time;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="TrainingSession")
@SequenceGenerator(name="ID_SEQ",allocationSize=1)
public class TrainingSession implements Serializable{
	
	private long sessionId;
	private String instructor;
	private Time startTime;
	private String type;
	private Integer length; 
	private String roomNumber;
	private Set<Booking> bookings;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="sessionId")
	public long getSessionId() {
		return sessionId;
	}
	public void setSessionId(long sessionId) {
		this.sessionId = sessionId;
	}
	@Column(name="instructor")
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	@Column(name="startTime")
	public Time getStartTime() {
		return startTime;
	}
	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}
	@Column(name="type")
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Column(name="length")
	public Integer getLength() {
		return length;
	}
	public void setLength(Integer length) {
		this.length = length;
	}
	@Column(name="roomNumber")
	public String getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	@OneToMany(mappedBy="trainingSession", fetch=FetchType.EAGER) 
	public Set<Booking> getBookings() {
		return bookings; 
		}
	public void setBookings(Set<Booking> bookings) { 
		this.bookings = bookings;
		}

}