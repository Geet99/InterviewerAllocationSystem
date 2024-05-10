package model;

public class InterviewAllocation {
    private String candidateName;
    private InterviewType interviewType;
    private String interviewerName;
    private int slot;

    public InterviewAllocation(String candidateName, InterviewType interviewType, String interviewerName, int slot) {
        this.candidateName = candidateName;
        this.interviewType = interviewType;
        this.interviewerName = interviewerName;
        this.slot = slot;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public InterviewType getInterviewType() {
        return interviewType;
    }

    public void setInterviewType(InterviewType interviewType) {
        this.interviewType = interviewType;
    }

    public String getInterviewerName() {
        return interviewerName;
    }

    public void setInterviewerName(String interviewerName) {
        this.interviewerName = interviewerName;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    @Override
    public String toString() {
        return  "{candidateName='" + candidateName + '\'' +
                ", interviewType=" + interviewType +
                ", interviewerName='" + interviewerName + '\'' +
                ", slot=" + slot +
                '}';
    }
}