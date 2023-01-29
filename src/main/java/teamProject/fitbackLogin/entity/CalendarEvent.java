package teamProject.fitbackLogin.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CalendarEvent extends BaseTime{
        @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        private Long id;

        private String eventTitle;

        private LocalDate startDate;

        private LocalDate endDate;

        private Member tutor;
        private Student student;
        @Enumerated(EnumType.STRING)
        private EventCategory category;

        @OneToMany(mappedBy = "event", cascade = CascadeType.ALL,
                fetch = FetchType.LAZY, optional = false)
        private Feedback feedback;

        @OneToOne(mappedBy = "event", cascade = CascadeType.ALL,
                fetch = FetchType.LAZY, optional = false)
        private Payday payday;
    }

