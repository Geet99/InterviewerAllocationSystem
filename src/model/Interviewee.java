package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Interviewee {
    private String name;
    private List<Integer> availableSlots;
    public Map<InterviewType, InterviewAllocation> scheduledInterviews;

    public Interviewee(String name, List<Integer> availableSlots) {
        this.name = name;
        this.availableSlots = new ArrayList<>(availableSlots);
        this.scheduledInterviews = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getAvailableSlots() {
        return availableSlots;
    }

    public void setAvailableSlots(List<Integer> availableSlots) {
        this.availableSlots = availableSlots;
    }

    public Map<InterviewType, InterviewAllocation> getScheduledInterviews() {
        return scheduledInterviews;
    }

    public void setScheduledInterviews(Map<InterviewType, InterviewAllocation> scheduledInterviews) {
        this.scheduledInterviews = scheduledInterviews;
    }
}