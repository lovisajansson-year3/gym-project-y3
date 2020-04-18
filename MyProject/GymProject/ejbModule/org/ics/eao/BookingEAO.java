package org.ics.eao;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.ics.ejb.Booking;
import org.ics.ejb.GymMember;

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
    public ArrayList<Booking> findAllBookingsForGymMember(GymMember member){
    	TypedQuery<Booking> query = 
    			em.createNamedQuery("Booking.findAllBookingsForGymMember", Booking.class);
    	ArrayList<Booking> list = new ArrayList();
    	if(member!=null) {
    		query.setParameter("memberId", member.getMemberId());
    		list = (ArrayList<Booking>) query.getResultList();
    	}
    	return list;
    			
    	
    }


}