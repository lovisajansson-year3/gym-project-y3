package org.ics.ejb;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@NamedQueries({
	@NamedQuery(name="Booking.findAllBookingsForGymMember",
	query="SELECT b FROM Booking b WHERE b.gymMember.memberId = :memberId"),
})

@Table(name="Booking")
//@SequenceGenerator(name="BID_SEQ",allocationSize=1)
public class Booking implements Serializable{
	
	private long bookingId;
	private GymMember gymMember;
	private TrainingSession trainingSession;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="bookingId")
	public long getBookingId() {
		return bookingId;
	}
	
	@ManyToOne
	@JoinColumn(name="mId", referencedColumnName="memberId")
	public GymMember getGymMember() {
		return gymMember;
	}
	public void setGymMember(GymMember gymMember) {
		this.gymMember = gymMember;
	}
	
	@ManyToOne
	@JoinColumn(name="tId", referencedColumnName="sessionId")
	public TrainingSession getTrainingSession() {
		return trainingSession;
	}
	public void setTrainingSession(TrainingSession trainingSession) {
		this.trainingSession = trainingSession;
	}
	

	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}
	

}