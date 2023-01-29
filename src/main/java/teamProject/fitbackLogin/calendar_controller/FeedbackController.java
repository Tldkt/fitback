package teamProject.fitbackLogin.calendar_controller;

public class FeedbackController {
    void createFeedback() {
        /*
        todo:
          - FeedbackDto.Input.CreateFeedback
          - members/{mem-id}/students/{student-id}/feedbacks
          - validation: member exists, student exists,category=feedback, notnull, dateRange
          - FeedbackDto.Output.CreateFeedbackList
          - list.of(FeedbackInDateRange)
        */
    }

    void updateFeedback() {
        /*
        todo:
            -  FeedbackDto.Input.UpdateFeedback
            - members/{mem-id}/students/{student-id}/feedbacks/{feedback-id}
            - validation: member exists, student exists, notnull, category=feedback, dateRange
            - FeedbackDto.Output.UpdatedFeedbackList
            - list.of(FeedbackInDateRange)
        */
    }

    void deleteFeedback() {
        /*
        todo:
            -  FeedbackDto.Input.DeleteFeedback
            - members/{mem-id}/students/{student-id}/feedbacks/{feedback-id}
            - validation: member exists, student exists, notnull, category=feedback, dateRange
            - FeedbackDto.Output.UpdatedFeedbackList
            - list.of(FeedbackInDateRange)
        */
    }
}
