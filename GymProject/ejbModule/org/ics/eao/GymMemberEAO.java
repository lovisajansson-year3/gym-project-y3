package org.ics.eao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.ics.ejb.Booking;
import org.ics.ejb.GymMember;
import org.ics.ejb.TrainingSession;

/**
 * Session Bean implementation class GymMemberEAOImpl
 */
@Stateless
@LocalBean
public class GymMemberEAO implements GymMemberEAOLocal {
	
	private long memberId;
	private String name;
	private String email;
	private String phoneNumber;
	private String address;
	private Set<Booking> bookings;
	GymMember member;
	
	public GymMember createGymMember(long memberId, String name, String email, String phoneNumber, String address, Set<Booking> bookings) {
		GymMember member1 = new GymMember(this.memberId, this.name, this.email, this.phoneNumber, this.address, this.bookings);
		return member1;
	}

	public long getMemberId() {
		memberId = member.getMemberId();
		return memberId;
		
	}
	public void setMemberId(long memberId) {
		this.memberId = memberId;
	}
	public String getName() {
		name = member.getName();
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		email = member.getEmail();
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		phoneNumber = member.getPhoneNumber();
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		address = member.getAddress();
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Set<Booking> getBookings() {
		bookings = member.getBookings();
		return bookings;
	}
	public void setBookings(Set<Booking> bookings) {
		this.bookings = bookings;
	}


	@PersistenceContext(unitName="LabEJBSql")
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public GymMemberEAO() {
        // TODO Auto-generated constructor stub
    }
    public GymMember findByMemberId(long memberId) {
    	return em.find(GymMember.class, memberId);
    }
    public GymMember createGymMember(GymMember g) {
    	em.persist(g);
    	return g;
    }
    public GymMember updateGymMember(GymMember g) {
    	em.merge(g);
    	return g;
    }
    public void deleteGymMember(long memberId) {
    	GymMember g = this.findByMemberId(memberId);
    	if(g!=null) {
    		em.remove(g);
    	}
    }
    public List<GymMember> findAll(){
		TypedQuery<GymMember> query=
				em.createNamedQuery("GymMember.findAll",GymMember.class);
		List<GymMember> results = query.getResultList();
		return results;
	}
    public List<GymMember> findByAddress(String address){
    	TypedQuery<GymMember> query=
    			em.createNamedQuery("GymMember.findByAddress",GymMember.class);
    	query.setParameter("address", address);
    	List<GymMember>results = query.getResultList();
    	return results;
    }
    public ArrayList<GymMember> getAllGymMembersWithBookingsForTrainingSession(long sessionId) {
    	ArrayList<GymMember> members = new ArrayList<GymMember>();
    	if(em.find(TrainingSession.class, sessionId)!=null) {
    		TrainingSession s = em.find(TrainingSession.class, sessionId);
			if(s.getBookings()!=null) {
				Set<Booking> bookings = s.getBookings();
			    for(Booking temp : bookings) {
			    	members.add(temp.getGymMember());
			    }
			}
    	}
    	return members;
    }
     
    public ArrayList<String> sessionRoom(long memberId){
    	GymMember temp = em.find(GymMember.class, memberId);
    	ArrayList<String> addresses = new ArrayList<String>();
    	Set<Booking> bookings  = temp.getBookings();
    	for(Booking t:bookings) {
    		addresses.add(t.getTrainingSession().getRoomNumber());
    	}
    	return addresses;
    }
    
    
	
}