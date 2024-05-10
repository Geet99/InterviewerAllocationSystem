package service;

import model.InterviewAllocation;
import model.InterviewType;
import model.Interviewee;
import repository.HRInterviewRepository;

import java.util.List;

public class HRInterviewServiceImpl implements HRInterviewService {

    HRInterviewRepository hrInterviewRepository;

    InterviewAllocationStrategy interviewAllocationStrategy;

    public HRInterviewServiceImpl(HRInterviewRepository hrInterviewRepository, InterviewAllocationStrategy interviewAllocationStrategy) {
        this.hrInterviewRepository = hrInterviewRepository;
        this.interviewAllocationStrategy = interviewAllocationStrategy;
    }

    @Override
    public void registerInterviewer(String name, List<InterviewType> preference, int experience, List<Integer> availableSlots) {
        hrInterviewRepository.registerInterviewer(name, preference, experience, availableSlots);
    }

    @Override
    public void registerInterviewee(String name, List<Integer> availableSlots) {
        hrInterviewRepository.registerInterviewee(name, availableSlots);
    }

    @Override
    public void allocateInterviews() {
        interviewAllocationStrategy.allocateInterviews();
    }

    @Override
    public void getInterviewSchedules() {
        List<Interviewee> interviewees = hrInterviewRepository.getInterviewees();
        List<InterviewAllocation> allocations = hrInterviewRepository.getInterviewSchedules();

        System.out.println(allocations);

        for (InterviewAllocation allocation : allocations)
            System.out.println(allocation);

//        for (Interviewee interviewee : interviewees) {
//            InterviewAllocation mcInterview = interviewee.getScheduledInterviews().get(InterviewType.MC);
//            if (mcInterview == null)
//                System.out.println("Cannot allot MC for " + interviewee.getName());
//            else
//                System.out.println(mcInterview);
//
//            InterviewAllocation psdsInterview = interviewee.getScheduledInterviews().get(InterviewType.PSDS);
//            if (psdsInterview == null)
//                System.out.println("Cannot allot PSDS for " + interviewee.getName());
//            else
//                System.out.println(psdsInterview);
//        }
    }
}