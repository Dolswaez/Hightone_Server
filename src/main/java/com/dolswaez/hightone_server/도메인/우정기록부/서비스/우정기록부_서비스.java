package com.dolswaez.hightone_server.도메인.우정기록부.서비스;

import com.dolswaez.hightone_server.도메인.우정기록부.정보.정보_전달_객체.우정기록_정보;
import com.dolswaez.hightone_server.도메인.우정기록부.정보.정보_전달_객체.우정기록부_정보;

public interface 우정기록부_서비스 {
    우정기록부_정보 우정기록부_게시하기(String 아이디);

    우정기록_정보 우정기록부_작성하기(Long 우정기록부_인덱스, 우정기록_정보 우정기록);

    우정기록부_정보 우정기록부_가져오기(String 아이디);

    void 없으면_만들기(String 아이디);
}
