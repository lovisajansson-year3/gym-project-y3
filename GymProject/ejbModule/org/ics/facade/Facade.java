package org.ics.facade;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.ics.eao.BookingEAOLocal;
import org.ics.eao.GymMemberEAOLocal;
import org.ics.eao.GymMemberEAO;
import org.ics.eao.TrainingSessionEAOLocal;
import org.ics.ejb.Booking;
import org.ics.ejb.GymMember;
import org.ics.ejb.TrainingSession;

/**
 * Session Bean implementation class Facade
 */
@Stateless
@LocalBean
public class Facade implements FacadeLocal {

	private long memberId;
	public long getMemberId() {
		memberId = memberEAO.getMemberId();
		return memberId;
	}
	public void setMemberId(long memberId) {
		this.memberId = memberId;
	}
	public String getName() {
		name = memberEAO.getName();
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		email = memberEAO.getEmail();
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		phoneNumber = memberEAO.getPhoneNumber();
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		address = memberEAO.getAddress();
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Set<Booking> getBookings() {
		bookings = memberEAO.getBookings();
		return bookings;
	}
	public void setBookings(Set<Booking> bookings) {
		this.bookings = bookings;
	}
	private String name;
	private String email;
	private String phoneNumber;
	private String address;
	private Set<Booking> bookings;
	GymMember member;
	
	@EJB
	GymMemberEAOLocal gymMemberEAO;
	@EJB
	TrainingSessionEAOLocal trainingSessionEAO;
	@EJB
	BookingEAOLocal bookingEAO;
	@EJB
	GymMemberEAO memberEAO;
	
    /**
     * Default constructor. 
     */
    public Facade() {
        // TODO Auto-generated constructor stub
    }
    public GymMember createGymMember() {
    	member = new GymMember(this.memberId, this.name, this.email, this.phoneNumber, this.address, this.bookings);
		return member;
    }
    
    
    public GymMember findByMemberId(long memberId) {
    	return gymMemberEAO.findByMemberId(memberId);
    }
    public GymMember createGymMember(GymMember g) {
    	return gymMemberEAO.createGymMember(g);
    }
  	public GymMember updateGymMember(GymMember g) {
  		return gymMemberEAO.updateGymMember(g);
  	}
  	public void deleteGymMember(long memberId) {
  		gymMemberEAO.deleteGymMember(memberId);
  	}
  	//TrainingSession
  	public TrainingSession findBySessionId(long sessionId) {
    	return trainingSessionEAO.findBySessionId(sessionId);
    }
    public TrainingSession createTrainingSession(TrainingSession g) {
    	return trainingSessionEAO.createTrainingSession(g);
    }
  	public TrainingSession updateTrainingSession(TrainingSession g) {
  		return trainingSessionEAO.updateTrainingSession(g);
  	}
  	public void deleteTrainingSession(long sessionId) {
  		trainingSessionEAO.deleteTrainingSession(sessionId);
  	}
    public boolean alreadyExists(String instructor, Date startTime){
    	return trainingSessionEAO.alreadyExists(instructor, startTime);
    }
	@Override
	public Booking createBooking(Booking g) {
		// TODO Auto-generated method stub
		return bookingEAO.createBooking(g);
	}
	@Override
	public Booking updateBooking(Booking g) {
		// TODO Auto-generated method stub
		return bookingEAO.updateBooking(g);
	}
	@Override
	public void deleteBooking(long bookingId) {
		// TODO Auto-generated method stub
		bookingEAO.deleteBooking(bookingId);
	}
	@Override
	public Booking findByBookingId(long bookingId) {
		// TODO Auto-generated method stub
		return bookingEAO.findByBookingId(bookingId);
	}
	@Override
	public List<GymMember> findByAddress(String address) {
		// TODO Auto-generated method stub
		return gymMemberEAO.findByAddress(address);
	}
	@Override
	public List<GymMember> findAll() {
		// TODO Auto-generated method stub
		return gymMemberEAO.findAll();
	}
    public boolean alreadyExists(long memberId,long sessionId) {
    	return bookingEAO.alreadyExists(memberId,sessionId);
    }
    public ArrayList<GymMember> getAllGymMembersWithBookingsForTrainingSession(long sessionId) {
    	return gymMemberEAO.getAllGymMembersWithBookingsForTrainingSession(sessionId);
    }
    public List<TrainingSession> findAllTrainingSessions() {
		// TODO Auto-generated method stub
		return trainingSessionEAO.findAllTrainingSessions();
	}public List<Booking> findAllBookings() {
		// TODO Auto-generated method stub
		return bookingEAO.findAllBookings();
	}
}