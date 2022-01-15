package com.dolswaez.hightone_server.도메인.계정.서비스;

import com.dolswaez.hightone_server.도메인.계정.정보.데이터_전달_객체.로그인_정보;
import com.dolswaez.hightone_server.도메인.계정.정보.데이터_전달_객체.로그인_토큰;
import com.dolswaez.hightone_server.도메인.계정.정보.데이터_전달_객체.회원가입_정보;
import com.dolswaez.hightone_server.인프라.메일.서비스.메일_송신_서비스;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class 유저_서비스_구현 implements 유저_서비스{
    private static final String 인증메일_제목 = "[우정기록부] 짜잔! 인증코드가 도착했어요!";
    private static final String 인증메일_내용_위치 = "이메일_인증_완료_페이지";

    private final 메일_송신_서비스 메일_송신_서비스;
    private final 인증코드_관리_서비스 인증코드_관리_서비스;
    private final PasswordEncoder 비밀번호_인코더;

    @Override
    public void 인증메일_보내기(String 이메일) {
        String 인증코드 = 인증코드_관리_서비스.인증코드_생성하기(이메일);
        Map<String, String> 이메일_모델값 = new HashMap<>();
        이메일_모델값.put("코드", 인증코드);
        메일_송신_서비스.메일_보내기(이메일, 인증메일_제목, 인증메일_내용_위치, 이메일_모델값);
    }

    @Override
    public String 인증코드_확인하기(String 코드) {
        return 인증코드_관리_서비스.인증코드로_이메일_가져오기(코드);
    }

    @Override
    public Long 회원가입(회원가입_정보 정보) {
        return null;
    }

    @Override
    public String 비밀번호_암호화(String 비밀번호) {
        return 비밀번호_인코더.encode(비밀번호);
    }

    @Override
    public 로그인_토큰 로그인(로그인_정보 정보) {
        return null;
    }
}
