package com.dolswaez.hightone_server.도메인.계정.서비스;

public interface 인증코드_관리_서비스 {
    String 인증코드_생성하기(String 이메일);

    String 인증코드로_이메일_가져오기(String 코드);
}
