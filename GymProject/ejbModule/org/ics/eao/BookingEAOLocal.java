package org.ics.eao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;

import org.ics.ejb.Booking;
import org.ics.ejb.GymMember;
import org.ics.ejb.TrainingSession;

@Local
public interface BookingEAOLocal {
	public Booking findByBookingId(long bookingId);
    public Booking createBooking(Booking g);
    public Booking updateBooking(Booking g);
    public void deleteBooking(long bookingId);
    public boolean alreadyExists(long memberId,long sessionId);
    public List<Booking> findAllBookings();
    public boolean findBookingByMemberId(long memberId);
    public boolean findBookingBySessionId(long sessionId);


}