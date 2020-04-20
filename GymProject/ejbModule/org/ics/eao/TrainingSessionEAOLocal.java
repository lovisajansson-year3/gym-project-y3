package org.ics.eao;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import org.ics.ejb.TrainingSession;

@Local
public interface TrainingSessionEAOLocal {


    public TrainingSession findBySessionId(long sessionId);
    public TrainingSession createTrainingSession(TrainingSession g);
    public TrainingSession updateTrainingSession(TrainingSession g);
    public void deleteTrainingSession(long sessionId);
    public List<TrainingSession> findAllTrainingSessions();
    public boolean alreadyExists(String instructor, Date startTime);
    }
