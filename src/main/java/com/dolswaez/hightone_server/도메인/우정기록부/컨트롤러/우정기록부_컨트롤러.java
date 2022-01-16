package com.dolswaez.hightone_server.도메인.우정기록부.컨트롤러;

import com.dolswaez.hightone_server.도메인.계정.유틸.로그인_토큰_유틸;
import com.dolswaez.hightone_server.도메인.우정기록부.서비스.우정기록부_서비스;
import com.dolswaez.hightone_server.도메인.우정기록부.서비스.우정기록부_식별코드_서비스;
import com.dolswaez.hightone_server.도메인.우정기록부.정보.요청.우정기록부_작성하기_요청;
import com.dolswaez.hightone_server.도메인.우정기록부.정보.응답.우정기록부_조회하기_응답;
import com.dolswaez.hightone_server.도메인.우정기록부.정보.응답.우정기록부_코드_생성하기_응답;
import com.dolswaez.hightone_server.도메인.우정기록부.정보.응답.우정기록부_코드_식별하기_응답;
import com.dolswaez.hightone_server.도메인.우정기록부.정보.응답.우정기록_작성하기_응답;
import com.dolswaez.hightone_server.도메인.우정기록부.정보.응답.우정기록부_게시하기_응답;
import com.dolswaez.hightone_server.도메인.우정기록부.정보.정보_전달_객체.우정기록_정보;
import com.dolswaez.hightone_server.도메인.우정기록부.정보.정보_전달_객체.우정기록부_정보;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/friendship_record")
@RequiredArgsConstructor
public class 우정기록부_컨트롤러 {
    private final 우정기록부_서비스 우정기록부_서비스;
    private final 우정기록부_식별코드_서비스 우정기록부_식별코드_서비스;

    private final 로그인_토큰_유틸 로그인_토큰_유틸;

    @GetMapping
    public ResponseEntity<우정기록부_조회하기_응답> 우정기록부_조회하기(@RequestHeader(value = HttpHeaders.AUTHORIZATION) String 인증헤더) {
        String 아이디 = 로그인_토큰_유틸.토큰_디코딩(인증헤더);
        우정기록부_정보 우정기록부 = 우정기록부_서비스.우정기록부_가져오기(아이디);
        우정기록부_조회하기_응답 응답 = new 우정기록부_조회하기_응답(우정기록부.인덱스(), 우정기록부.게시자_인덱스(), 우정기록부.우정기록_리스트());
        return ResponseEntity.ok(응답);
    }

    @PostMapping
    public ResponseEntity<우정기록부_게시하기_응답> 우정기록부_게시하기(@RequestHeader(value = HttpHeaders.AUTHORIZATION) String 인증헤더) {
        String 아이디 = 로그인_토큰_유틸.토큰_디코딩(인증헤더);
        우정기록부_정보 우정기록부 = 우정기록부_서비스.우정기록부_게시하기(아이디);
        우정기록부_게시하기_응답 응답 = new 우정기록부_게시하기_응답(우정기록부.인덱스(), 우정기록부.게시자_인덱스(), 우정기록부.우정기록_리스트());
        return ResponseEntity.ok(응답);
    }

    @PostMapping("/{우정기록부_인덱스}")
    public ResponseEntity<우정기록_작성하기_응답> 우정기록_작성하기(@PathVariable Long 우정기록부_인덱스, @RequestBody 우정기록부_작성하기_요청 요청) {
        우정기록_정보 우정기록 = new 우정기록_정보(0L, 요청.작성자_이름(), 요청.성격_리스트(), 요청.친학수(), 요청.내꼭해());
        우정기록 = 우정기록부_서비스.우정기록부_작성하기(우정기록부_인덱스, 우정기록);
        우정기록_작성하기_응답 응답 = new 우정기록_작성하기_응답(
                우정기록.인덱스(),
                우정기록.작성자_이름(),
                우정기록.성격_리스트(),
                우정기록.친학수(),
                우정기록.내꼭해()
        );
        return ResponseEntity.ok(응답);
    }

    @GetMapping("/code")
    public ResponseEntity<우정기록부_코드_생성하기_응답> 우정기록부_코드_생성하기(@RequestHeader(value = HttpHeaders.AUTHORIZATION) String 인증헤더) {
        String 아이디 = 로그인_토큰_유틸.토큰_디코딩(인증헤더);
        우정기록부_서비스.없으면_만들기(아이디);
        String 식별코드 = 우정기록부_식별코드_서비스.식별코드_생성하기(아이디);
        우정기록부_코드_생성하기_응답 응답 = new 우정기록부_코드_생성하기_응답(식별코드);
        return ResponseEntity.ok(응답);
    }

    @GetMapping("/code/{식별코드}")
    public ResponseEntity<우정기록부_코드_식별하기_응답> 우정기록부_코드_식별하기(@PathVariable String 식별코드) {
        String 아이디 = 우정기록부_식별코드_서비스.식별코드로_아이디_가져오기(식별코드);
        우정기록부_정보 우정기록부 = 우정기록부_서비스.우정기록부_가져오기(아이디);
        우정기록부_코드_식별하기_응답 응답 = new 우정기록부_코드_식별하기_응답(우정기록부.인덱스(), 우정기록부.게시자_인덱스(), 우정기록부.우정기록_리스트());
        return ResponseEntity.ok(응답);
    }
}
