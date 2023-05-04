package com.example.dividendpj.web;

import com.example.dividendpj.model.Auth;
import com.example.dividendpj.model.MemberEntity;
import com.example.dividendpj.persist.MemberRepository;
import com.example.dividendpj.security.TokenProvider;
import com.example.dividendpj.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final MemberService memberService;

    private final TokenProvider tokenProvider;

    @PostMapping("/signup") //회원가입
    public ResponseEntity<?> signup(@RequestBody Auth.SignUp request){
        MemberEntity register = this.memberService.register(request);
        return ResponseEntity.ok(register);
    }

    @PostMapping("/signin") //로그인
    public ResponseEntity<?> signin(@RequestBody Auth.SignIn request){
        MemberEntity member = this.memberService.authenticate(request);
        String token = this.tokenProvider.generateToken(member.getUsername(), member.getRoles());
        return ResponseEntity.ok(token);
    }
}
