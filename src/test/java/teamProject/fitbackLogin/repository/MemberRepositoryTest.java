package teamProject.fitbackLogin.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;
import teamProject.fitbackLogin.entity.Member;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static teamProject.fitbackLogin.entity.Authority.ROLE_USER;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository repository;
    private Optional<Member> findEmail;

    @Test
    @Transactional
    @Rollback(false)
    public void testMember() {
        Member member = new Member(
                null, "noonsong@gamil.com", "2020", "김송이", "010-0000-0000", ROLE_USER
        );

        repository.save(member);

        findEmail = repository.findByEmail(member.getEmail());

        assertEquals(findEmail.get().getId(), member.getId());
        assertEquals(findEmail.get().getAuthority(), member.getAuthority());
        assertEquals(findEmail, member);
    }
}