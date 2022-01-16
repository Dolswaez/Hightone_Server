package com.dolswaez.hightone_server.도메인.계정.유틸;

import com.dolswaez.hightone_server.전역.자바_웹_토큰.유틸.표준_자바_웹_토큰_유틸;
import com.dolswaez.hightone_server.전역.자바_웹_토큰.프로퍼티.자바_웹_토큰_프로퍼티;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class 재발급_토큰_유틸 extends 표준_자바_웹_토큰_유틸<String> {
    private final 자바_웹_토큰_프로퍼티 프로퍼티;

    @Override
    protected LocalDateTime 만료기간_가져오기(LocalDateTime 현재시각) {
        return 현재시각.plusDays(2);
    }

    @Override
    protected Map<String, Object> 클레임_가져오기(String 아이디) {
        Map<String, Object> 클레임 = new HashMap<>();
        클레임.put("id", 아이디);
        return 클레임;
    }

    @Override
    protected String 비밀키_가져오기() {
        return 프로퍼티.getSecret();
    }

    @Override
    protected String 클레임을_통해_정보_가져오기(Claims 클레임) {
        return 클레임.get("id", String.class);
    }
}
