package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Interviewer {
    private String name;
    private List<InterviewType> preferences;
    private int experience;
    private List<Integer> availableSlots;

    public Interviewer(String name, List<InterviewType> preferences, int experience, List<Integer> availableSlots) {
        this.name = name;
        this.preferences = preferences;
        this.experience = experience;
        this.availableSlots = new ArrayList<>(availableSlots.stream().toList());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<InterviewType> getPreferences() {
        return preferences;
    }

    public void setPreferences(List<InterviewType> preferences) {
        this.preferences = preferences;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public List<Integer> getAvailableSlots() {
        return availableSlots;
    }

    public void setAvailableSlots(List<Integer> availableSlots) {
        this.availableSlots = availableSlots;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Interviewer that = (Interviewer) o;
        return experience == that.experience && Objects.equals(name, that.name) && Objects.equals(preferences, that.preferences);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, preferences, experience, availableSlots);
    }
}