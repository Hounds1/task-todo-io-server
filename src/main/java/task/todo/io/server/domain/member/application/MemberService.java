package task.todo.io.server.domain.member.application;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import task.todo.io.server.domain.member.domain.persist.Member;
import task.todo.io.server.domain.member.domain.persist.MemberRepository;
import task.todo.io.server.domain.member.dto.SimpleMemberResponse;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public SimpleMemberResponse create(final Member member) {
        existUsername(member.getUsername());
        existNickname(member.getNickname());

        member.setEncodePass(passwordEncoder);
        Member savedMember = memberRepository.save(member);

        return SimpleMemberResponse.of(savedMember);
    }


    public void existUsername(final String username) {
        if (memberRepository.existsByUsername(username)) {
            throw new IllegalStateException("중복 유저네임");
        }
    }

    public void existNickname(final String nickname) {
        if (memberRepository.existsByNickname(nickname)) {
            throw new IllegalStateException("중복 닉네임");
        }
    }
}
