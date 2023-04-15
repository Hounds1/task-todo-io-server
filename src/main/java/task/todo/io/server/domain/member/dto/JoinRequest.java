package task.todo.io.server.domain.member.dto;

import lombok.*;
import task.todo.io.server.domain.member.domain.persist.Member;
import task.todo.io.server.domain.member.domain.vo.RoleType;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class JoinRequest {

    private String username;

    private String nickname;

    private String password;


    public Member toEntity() {
        return Member.builder()
                .username(username)
                .nickname(nickname)
                .password(password)
                .activated(true)
                .roleType(RoleType.USER)
                .build();
    }
}
