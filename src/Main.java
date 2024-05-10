import model.InterviewType;
import repository.HRInterviewRepository;
import service.DefaultInterviewAllocationStrategy;
import service.HRInterviewService;
import service.HRInterviewServiceImpl;
import service.InterviewAllocationStrategy;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        HRInterviewRepository hrInterviewRepository = new HRInterviewRepository();
        InterviewAllocationStrategy interviewAllocationStrategy = new DefaultInterviewAllocationStrategy(hrInterviewRepository);
        HRInterviewService hrInterviewService = new HRInterviewServiceImpl(hrInterviewRepository, interviewAllocationStrategy);

        hrInterviewService.registerInterviewer("Interviewer1", List.of(), 7, List.of(10));
        hrInterviewService.registerInterviewer("Interviewer2", List.of(InterviewType.MC, InterviewType.PSDS), 6, List.of());
        hrInterviewService.registerInterviewer("Interviewer3", List.of(InterviewType.MC, InterviewType.PSDS), 6, List.of(2, 3, 7));
        hrInterviewService.registerInterviewee("Candidate1", List.of(10, 2, 7, 8));
        hrInterviewService.registerInterviewee("Candidate2", List.of(1, 2, 3, 7, 8));
        hrInterviewService.registerInterviewee("Candidate3", List.of(3));
        hrInterviewService.registerInterviewee("Candidate4", List.of(3, 4));

        hrInterviewService.allocateInterviews();
        hrInterviewService.getInterviewSchedules();

//        hrInterviewService.registerInterviewer("Interviewer1", List.of(InterviewType.MC, InterviewType.PSDS), 7, List.of(1, 2, 3, 4));
//        hrInterviewService.registerInterviewer("Interviewer2", List.of(InterviewType.MC, InterviewType.PSDS), 6, List.of(2, 3, 4));
//        hrInterviewService.registerInterviewee("Candidate1", List.of(1, 2, 3, 7, 8));
//        hrInterviewService.registerInterviewee("Candidate2", List.of(1, 2, 3, 7, 8));
//
//        hrInterviewService.allocateInterviews();
//        hrInterviewService.getInterviewSchedules();
    }
}