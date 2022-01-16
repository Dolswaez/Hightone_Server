package com.dolswaez.hightone_server.도메인.계정.컨트롤러;

import com.dolswaez.hightone_server.도메인.계정.서비스.유저_서비스;
import com.dolswaez.hightone_server.도메인.계정.정보.정보_전달_객체.로그인_정보;
import com.dolswaez.hightone_server.도메인.계정.정보.정보_전달_객체.로그인_토큰;
import com.dolswaez.hightone_server.도메인.계정.정보.요청.로그인_요청;
import com.dolswaez.hightone_server.도메인.계정.정보.응답.로그인_응답;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/account/login")
@RequiredArgsConstructor
public class 로그인_컨트롤러 {
    private final 유저_서비스 유저_서비스;

    @PostMapping
    public ResponseEntity<로그인_응답> 로그인(@RequestBody 로그인_요청 요청) {
        로그인_정보 정보 = new 로그인_정보(요청.아이디(), 요청.비밀번호());
        로그인_토큰 토큰 = 유저_서비스.로그인(정보);
        로그인_응답 응답 = new 로그인_응답(토큰.로그인_토큰(), 토큰.재발급_토큰());
        return ResponseEntity.ok(응답);
    }
}
