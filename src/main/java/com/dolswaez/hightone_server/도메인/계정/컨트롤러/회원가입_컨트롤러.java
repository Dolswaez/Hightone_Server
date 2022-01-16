package com.dolswaez.hightone_server.도메인.계정.컨트롤러;

import com.dolswaez.hightone_server.도메인.계정.정보.정보_전달_객체.회원가입_정보;
import com.dolswaez.hightone_server.도메인.계정.정보.요청.회원가입_요청;
import com.dolswaez.hightone_server.도메인.계정.정보.응답.회원가입_응답;
import com.dolswaez.hightone_server.도메인.계정.서비스.유저_서비스;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/account/signup")
@RequiredArgsConstructor
public class 회원가입_컨트롤러 {
    private final 유저_서비스 유저_서비스;

    @PostMapping
    public ResponseEntity<회원가입_응답> 회원가입(@RequestBody 회원가입_요청 요청) {
        String 암호화된_비밀번호 = 유저_서비스.비밀번호_암호화(요청.비밀번호());
        회원가입_정보 정보 = new 회원가입_정보(
                요청.이름(), 요청.아이디(), 암호화된_비밀번호, 요청.이메일(),
                요청.학교이름(), 요청.학교(), 요청.학년(), 요청.반(), 요청.번호()
        );
        Long 인덱스 = 유저_서비스.회원가입(정보);
        회원가입_응답 응답 = new 회원가입_응답(
                인덱스,
                정보.이름(), 정보.아이디(), 정보.암호화된_비밀번호(), 정보.이메일(),
                정보.학교이름(), 정보.학교(), 정보.학년(), 정보.반(), 정보.번호()
        );
        return ResponseEntity.ok(응답);
    }
}
