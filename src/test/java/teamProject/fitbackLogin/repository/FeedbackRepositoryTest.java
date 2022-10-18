package teamProject.fitbackLogin.repository;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;
import teamProject.fitbackLogin.entity.Feedback;


@ExtendWith(SpringExtension.class)
@SpringBootTest
class FeedbackRepositoryTest {

    @Autowired
    FeedbackRepository repository;

    @Test
    @Transactional
    @Rollback(false)
    public void testFeedback() {
        Feedback feedback = new Feedback(
                null, "aaa","song", "first", "Hello", null
        );

        repository.save(feedback);

        Feedback findFeedback = repository.findByTitle(feedback.getTitle());

        assertEquals(findFeedback.getId(), feedback.getId());
        assertEquals(findFeedback.getUserid(), feedback.getUserid());
        assertEquals(findFeedback, feedback);
    }
}