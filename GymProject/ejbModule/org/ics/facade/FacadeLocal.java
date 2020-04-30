package org.ics.facade;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import org.ics.ejb.Booking;
import org.ics.ejb.GymMember;
import org.ics.ejb.TrainingSession;

@Local
public interface FacadeLocal {
	 public GymMember findByMemberId(long memberId);
	    public GymMember createGymMember(GymMember g);
	  	public GymMember updateGymMember(GymMember g);      
	  	public void deleteGymMember(long memberId);
	  	public List<GymMember> findByAddress(String address);
	    public List<GymMember> findAll();
	  	//TrainingSession
	  	public TrainingSession findBySessionId(long sessionId);
	    public TrainingSession createTrainingSession(TrainingSession g);
	    public TrainingSession updateTrainingSession(TrainingSession g);
	    public void deleteTrainingSession(long sessionId);
	    public List<TrainingSession> findAllTrainingSessions();
	    public boolean alreadyExists(String instructor, Date startTime);


	    //Booking
	    public Booking findByBookingId(long bookingId);
	    public Booking createBooking(Booking g);
	    public Booking updateBooking(Booking g);
	    public void deleteBooking(long bookingId);
	    public boolean alreadyExists(String memberId,String sessionId);
	    public ArrayList<GymMember> getAllGymMembersWithBookingsForTrainingSession(long sessionId);
	    public List<Booking> findAllBookings();




}