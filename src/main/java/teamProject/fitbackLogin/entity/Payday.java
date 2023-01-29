package teamProject.fitbackLogin.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Entity
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Payday extends BaseTime{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private int money;

    private String bankAccount;

    @OneToOne
    @JoinColumn(name = "event_id", referencedColumnName = "id")
    private CalendarEvent calendarEvent;
}
