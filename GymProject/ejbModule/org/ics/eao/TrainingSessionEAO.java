package org.ics.eao;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.ics.ejb.GymMember;
import org.ics.ejb.TrainingSession;

/**
 * Session Bean implementation class TrainingSessionEAOImpl
 */
@Stateless
@LocalBean
public class TrainingSessionEAO implements TrainingSessionEAOLocal {

    
    @PersistenceContext(unitName="LabEJBSql")
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public TrainingSessionEAO() {
        // TODO Auto-generated constructor stub
    }
    public TrainingSession findBySessionId(long sessionId) {
    	return em.find(TrainingSession.class, sessionId);
    }
    public TrainingSession createTrainingSession(TrainingSession g) {
    	em.persist(g);
    	return g;
    }
    public TrainingSession updateTrainingSession(TrainingSession g) {
    	em.merge(g);
    	return g;
    }
    public void deleteTrainingSession(long sessionId) {
    	TrainingSession g = this.findBySessionId(sessionId);
    	if(g!=null) {
    		em.remove(g);
    	}
    }    
    public List<TrainingSession> findAllTrainingSessions(){
		TypedQuery<TrainingSession> query=
				em.createNamedQuery("TrainingSession.findAllTrainingSessions",TrainingSession.class);
		List<TrainingSession> results = query.getResultList();
		return results;
    }
    public boolean alreadyExists(String instructor, Date startTime){
		TypedQuery<TrainingSession> query=
				em.createNamedQuery("TrainingSession.alreadyExists",TrainingSession.class);
		query.setParameter("instructor", instructor);
		query.setParameter("startTime", startTime);
		List<TrainingSession> results = query.getResultList();
		for(TrainingSession t : results) {
			System.out.println(t.getSessionId());
		}
		if(results.isEmpty()) {
			return false;
		}else {
		return true;
		}
    }
	

}