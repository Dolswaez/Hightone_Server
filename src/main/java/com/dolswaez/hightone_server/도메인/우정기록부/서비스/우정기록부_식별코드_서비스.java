package com.dolswaez.hightone_server.도메인.우정기록부.서비스;

public interface 우정기록부_식별코드_서비스 {
    String 식별코드_생성하기(String 아이디);

    String 식별코드로_아이디_가져오기(String 식별코드);
}
