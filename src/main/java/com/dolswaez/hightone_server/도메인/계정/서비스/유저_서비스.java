package com.dolswaez.hightone_server.도메인.계정.서비스;

import com.dolswaez.hightone_server.도메인.계정.정보.정보_전달_객체.로그인_정보;
import com.dolswaez.hightone_server.도메인.계정.정보.정보_전달_객체.로그인_토큰;
import com.dolswaez.hightone_server.도메인.계정.정보.정보_전달_객체.회원가입_정보;

public interface 유저_서비스 {
    void 인증메일_보내기(String 이메일);
    String 인증코드_확인하기(String 코드);

    Long 회원가입(회원가입_정보 정보);

    String 비밀번호_암호화(String 비밀번호);

    로그인_토큰 로그인(로그인_정보 정보);
}
