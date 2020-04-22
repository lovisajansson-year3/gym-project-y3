package org.ics.facade;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.ics.eao.BookingEAOLocal;
import org.ics.eao.GymMemberEAOLocal;
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

	@EJB
	GymMemberEAOLocal gymMemberEAO;
	@EJB
	TrainingSessionEAOLocal trainingSessionEAO;
	@EJB
	BookingEAOLocal bookingEAO;
    /**
     * Default constructor. 
     */
    public Facade() {
        // TODO Auto-generated constructor stub
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
    public ArrayList<Booking> findAllBookingsForGymMember(GymMember memberId){
    	return bookingEAO.findAllBookingsForGymMember(memberId);
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