package task.todo.io.server.domain.member.domain.persist;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Where;
import org.springframework.security.crypto.password.PasswordEncoder;
import task.todo.io.server.domain.member.domain.vo.RoleType;
import task.todo.io.server.global.common.BaseEntity;

@Entity
@Getter
@DynamicInsert
@DynamicUpdate
@Where(clause = "activated = true")
@Table(name = "member", indexes = {
        @Index(name = "i_username", columnList = "username"),
        @Index(name = "i_nickname", columnList = "nickname")
})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class Member extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String nickname;

    private String password;

    private boolean activated;

    private RoleType roleType;

    public void setEncodePass(final String password, final PasswordEncoder passwordEncoder) {
        this.password = passwordEncoder.encode(password);
    }
}