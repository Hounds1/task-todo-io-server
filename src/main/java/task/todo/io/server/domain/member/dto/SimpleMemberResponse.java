package task.todo.io.server.domain.member.dto;

import lombok.*;
import task.todo.io.server.domain.member.domain.persist.Member;
import task.todo.io.server.domain.member.domain.vo.RoleType;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class SimpleMemberResponse {

    private String username;

    private String nickname;

    private RoleType roleType;

    public static SimpleMemberResponse of(final Member member) {
        return new SimpleMemberResponse(member.getUsername(), member.getNickname(), member.getRoleType());
    }
}
