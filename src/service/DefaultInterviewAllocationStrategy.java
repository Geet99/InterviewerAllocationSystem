package service;

import model.InterviewAllocation;
import model.InterviewType;
import model.Interviewee;
import model.Interviewer;
import repository.HRInterviewRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DefaultInterviewAllocationStrategy implements InterviewAllocationStrategy {

    HRInterviewRepository hrInterviewRepository;

    public DefaultInterviewAllocationStrategy(HRInterviewRepository hrInterviewRepository) {
        this.hrInterviewRepository = hrInterviewRepository;
    }

    @Override
    public void allocateInterviews() {
        List<Interviewee> interviewees = hrInterviewRepository.getInterviewees();

        for (Interviewee interviewee : interviewees) {

            List<Interviewer> interviewers = hrInterviewRepository.getInterviewers();

            List<Interviewer> availableMcInterviewers = interviewers.stream()
                    .filter(interviewer -> interviewer.getPreferences().contains(InterviewType.MC) &&
                    interviewer.getAvailableSlots().stream().anyMatch(interviewee.getAvailableSlots()::contains))
                    .toList();

            InterviewAllocation interviewAllocation = null;
            if (availableMcInterviewers.isEmpty()) {
//                interviewee.getScheduledInterviews().put(InterviewType.MC, null);
                hrInterviewRepository.getInterviewSchedules().add(new InterviewAllocation(interviewee.getName(), InterviewType.MC, "", 0));
            }
            else {
                Integer slot = availableMcInterviewers.getFirst().getAvailableSlots().stream().filter(interviewee.getAvailableSlots()::contains).toList().getFirst();
                interviewAllocation = new InterviewAllocation(interviewee.getName(), InterviewType.MC, availableMcInterviewers.get(0).getName(), slot);
                interviewee.setScheduledInterviews(Map.of(InterviewType.MC, interviewAllocation));
                hrInterviewRepository.getInterviewSchedules().add(interviewAllocation);
                hrInterviewRepository.updateInterviewerAvailability(interviewAllocation.getInterviewerName(), slot);
                interviewee.getAvailableSlots().remove(slot);
            }

            InterviewAllocation prevInterviewAllocation = interviewAllocation;
            List<Interviewer> availablePSDSInterviewers = interviewers.stream()
                    .filter(interviewer -> interviewer.getPreferences().contains(InterviewType.PSDS)
                            && interviewer.getAvailableSlots().stream().anyMatch(interviewee.getAvailableSlots()::contains)
                            && (prevInterviewAllocation == null || !interviewer.getName().equals(prevInterviewAllocation.getInterviewerName())))
                    .toList();

            if (availablePSDSInterviewers.isEmpty()) {
//                interviewee.getScheduledInterviews().put(InterviewType.PSDS, null);
                hrInterviewRepository.getInterviewSchedules().add(new InterviewAllocation(interviewee.getName(), InterviewType.PSDS, "", 0));
            }
            else {
                Integer slot = availablePSDSInterviewers.getFirst().getAvailableSlots().stream().filter(interviewee.getAvailableSlots()::contains).toList().getFirst();
                interviewAllocation = new InterviewAllocation(interviewee.getName(), InterviewType.PSDS, availablePSDSInterviewers.get(0).getName(), slot);
                interviewee.setScheduledInterviews(Map.of(InterviewType.PSDS, interviewAllocation));
                hrInterviewRepository.getInterviewSchedules().add(interviewAllocation);
                hrInterviewRepository.updateInterviewerAvailability(interviewAllocation.getInterviewerName(), slot);
                interviewee.getAvailableSlots().remove(slot);
            }
        }
    }
}