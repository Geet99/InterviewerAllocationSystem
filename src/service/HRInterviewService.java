package service;

import model.InterviewType;

import java.util.List;

public interface HRInterviewService {

    void registerInterviewer(String name, List<InterviewType> preference, int experience, List<Integer> availableSlots);

    void registerInterviewee(String name, List<Integer> availableSlots);

    void allocateInterviews();

    void getInterviewSchedules();
}