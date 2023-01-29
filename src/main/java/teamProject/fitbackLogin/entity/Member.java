package teamProject.fitbackLogin.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Getter
@Builder
@NoArgsConstructor
public class Member extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotEmpty
    private String email;

    @Column
    @NotEmpty
    private String password;

    @Column
    @NotEmpty
    private String username;

    @Column
    @NotEmpty
    private String phone;

    @Enumerated(EnumType.STRING)
    private Authority authority;

    public void setPassword(String password) { this.password = password; }

    @Builder
    public Member(Long id, String email, String password, String username, String phone, Authority authority) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.username=username;
        this.phone=phone;
        this.authority = authority;
    }
}
