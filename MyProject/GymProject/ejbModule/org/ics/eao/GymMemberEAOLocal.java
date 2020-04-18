package org.ics.eao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;

import org.ics.ejb.Booking;
import org.ics.ejb.GymMember;

@Local
public interface GymMemberEAOLocal {
    public GymMember findByMemberId(long memberId);
    public GymMember createGymMember(GymMember g);
  	public GymMember updateGymMember(GymMember g);      
  	public void deleteGymMember(long memberId);
    public List<GymMember> findByAddress(String address);
    public List<GymMember> findAll();
    public ArrayList<GymMember> getAllGymMembersWithBookingsForTrainingSession(long sessionId);


  	
        


}