package org.ics.eao;

import javax.ejb.Local;

import org.ics.ejb.TrainingSession;

@Local
public interface TrainingSessionEAOLocal {


    public TrainingSession findBySessionId(long sessionId);
    public TrainingSession createTrainingSession(TrainingSession g);
    public TrainingSession updateTrainingSession(TrainingSession g);
    public void deleteTrainingSession(long sessionId);
    }
