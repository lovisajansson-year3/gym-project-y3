package org.ics.eao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.ics.ejb.Booking;
import org.ics.ejb.GymMember;
import org.ics.ejb.TrainingSession;

/**
 * Session Bean implementation class BookingEAOImpl
 */
@Stateless
@LocalBean
public class BookingEAO implements BookingEAOLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext(unitName="LabEJBSql")
	private EntityManager em;
	public BookingEAO() {
        // TODO Auto-generated constructor stub
    }
	public Booking findByBookingId(long bookingId) {
    	return em.find(Booking.class, bookingId);
    }
    public Booking createBooking(Booking g) {
    	em.persist(g);
    	return g;
    }
    public Booking updateBooking(Booking g) {
    	em.merge(g);
    	return g;
    }
    public void deleteBooking(long bookingId) {
    	Booking g = this.findByBookingId(bookingId);
    	if(g!=null) {
    		em.remove(g);
    	}
    }
    public boolean alreadyExists(long memberId, long sessionId){
    	TypedQuery<Booking> query = 
    			em.createNamedQuery("Booking.alreadyExists", Booking.class);
    	ArrayList<Booking> results = new ArrayList();
    		
    		query.setParameter("memberId", memberId);
    		query.setParameter("sessionId", sessionId);
    		results = (ArrayList<Booking>) query.getResultList();

    		if(results.isEmpty()) {
    			return false;
    		}else {
    		return true;
    		}
    	
    }
    public List<Booking> findAllBookings(){
		TypedQuery<Booking> query=
				em.createNamedQuery("Booking.findAllBookings",Booking.class);
		List<Booking> results = query.getResultList();
		return results;
    }
    public boolean findBookingByMemberId(long memberId){
    	TypedQuery<Booking> query = 
    			em.createNamedQuery("Booking.findBookingByMemberId", Booking.class);
    	ArrayList<Booking> results = new ArrayList();
    		
    		query.setParameter("memberId", memberId);
    		results = (ArrayList<Booking>) query.getResultList();

    		if(results.isEmpty()) {
    			return false;
    		}else {
    		return true;
    		}
    } 
    public boolean findBookingBySessionId(long sessionId){
    	TypedQuery<Booking> query = 
    			em.createNamedQuery("Booking.findBookingBySessionId", Booking.class);
    	ArrayList<Booking> results = new ArrayList();
    		
    		query.setParameter("sessionId", sessionId);
    		results = (ArrayList<Booking>) query.getResultList();

    		if(results.isEmpty()) {
    			return false;
    		}else {
    		return true;
    		}
    }


}