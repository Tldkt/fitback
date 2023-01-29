package teamProject.fitbackLogin.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FeedbackV1 extends BaseTime{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String subject;

    private String contents;

    @OneToOne
    @JoinColumn(name = "event_id", referencedColumnName = "id")
    private CalendarEvent calendarEvent;
}
