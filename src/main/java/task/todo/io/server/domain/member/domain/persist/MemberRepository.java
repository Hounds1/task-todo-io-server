package task.todo.io.server.domain.member.domain.persist;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    boolean existsByUsername(final String username);
    boolean existsByNickname(final String nickname);

    Optional<Member> findByUsername(final String username);

    Optional<Member> findByNickname(final String nickname);
}
