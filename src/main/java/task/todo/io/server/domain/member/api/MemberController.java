package task.todo.io.server.domain.member.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import task.todo.io.server.domain.member.application.MemberService;
import task.todo.io.server.domain.member.dto.JoinRequest;
import task.todo.io.server.domain.member.dto.SimpleMemberResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
@Slf4j
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/members")
    public ResponseEntity<SimpleMemberResponse> create(@RequestBody JoinRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(memberService.create(request.toEntity()));
    }
}
