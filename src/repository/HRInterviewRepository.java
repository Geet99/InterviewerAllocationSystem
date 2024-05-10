package repository;

import model.InterviewAllocation;
import model.InterviewType;
import model.Interviewee;
import model.Interviewer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HRInterviewRepository {

    Map<String, Interviewer> interviewers = new HashMap<>();
    Map<String, Interviewee> interviewees = new HashMap<>();
    List<InterviewAllocation> interviewAllocations = new ArrayList<>();

    public void registerInterviewer(String name, List<InterviewType> preference, int experience, List<Integer> availableSlots) {
        if (interviewers.containsKey(name)) {
            System.out.println("Interviewer already exists.");
            return;
        }
        interviewers.put(name, new Interviewer(name, preference, experience, availableSlots));
    }

    public void registerInterviewee(String name, List<Integer> availableSlots) {
        if (interviewees.containsKey(name)) {
            System.out.println("Interviewee already exists.");
            return;
        }
        interviewees.put(name, new Interviewee(name, availableSlots));
    }

    public List<Interviewee> getInterviewees() {
        return interviewees.values().stream().toList();
    }

    public List<InterviewAllocation> getInterviewSchedules() {
        return interviewAllocations;
    }

    public List<Interviewer> getInterviewers() {
        return interviewers.values().stream().toList();
    }

    public void updateInterviewerAvailability(String interviewerName, Integer slot) {
        interviewers.get(interviewerName).getAvailableSlots().remove(slot);
    }
}