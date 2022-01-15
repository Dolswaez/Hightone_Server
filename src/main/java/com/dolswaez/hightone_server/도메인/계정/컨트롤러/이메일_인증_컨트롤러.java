package com.dolswaez.hightone_server.도메인.계정.컨트롤러;

import com.dolswaez.hightone_server.도메인.계정.서비스.유저_서비스;
import com.dolswaez.hightone_server.도메인.계정.정보.요청.인증_메일_송신_요청;
import com.dolswaez.hightone_server.도메인.계정.정보.응답.이메일_인증_응답;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/account/authorize")
@RequiredArgsConstructor
public class 이메일_인증_컨트롤러 {
    private final 유저_서비스 유저_서비스;

    @PostMapping
    public ResponseEntity<?> 인증_메일_송신(@RequestBody 인증_메일_송신_요청 요청) {
        유저_서비스.인증메일_보내기(요청.이메일());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{코드}")
    public ResponseEntity<이메일_인증_응답> 이메일_인증(@PathVariable String 코드) {
        String 이메일_토큰 = 유저_서비스.인증코드_확인(코드);
        이메일_인증_응답 응답 = new 이메일_인증_응답(이메일_토큰);
        return ResponseEntity.ok(응답);
    }
}
