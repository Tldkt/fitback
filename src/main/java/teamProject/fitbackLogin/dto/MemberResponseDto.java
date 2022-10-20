package teamProject.fitbackLogin.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import teamProject.fitbackLogin.entity.Authority;
import teamProject.fitbackLogin.entity.Member;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberResponseDto {
    private String email;
    private String username;
    private String phone;
    private Authority authority;

    public static MemberResponseDto of(Member member) {
        return MemberResponseDto.builder()
                .email(member.getEmail())
                .username(member.getUsername())
                .phone(member.getPhone())
                .authority(member.getAuthority())
                .build();
    }
}
