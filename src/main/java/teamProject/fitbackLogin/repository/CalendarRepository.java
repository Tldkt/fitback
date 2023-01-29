package teamProject.fitbackLogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import teamProject.fitbackLogin.entity.CalendarEvent;

import java.util.Optional;

public interface CalendarRepository extends JpaRepository {
    Optional<CalendarEvent> findByCategoryIdandDateRange();
}
