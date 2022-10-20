package teamProject.fitbackLogin.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import teamProject.fitbackLogin.entity.Feedback;


@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    Feedback findByTitle(String title);
}
