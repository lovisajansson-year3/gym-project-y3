package org.ics.eao;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

}