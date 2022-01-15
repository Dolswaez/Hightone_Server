package com.dolswaez.hightone_server.도메인.계정.정보.데이터_전달_객체;

import com.dolswaez.hightone_server.도메인.계정.정보.종류.학교종류;

public record 회원가입_정보(
        String 이름,
        String 아이디,
        String 암호화된_비밀번호,
        String 이메일,
        학교종류 학교,
        Integer 학년,
        Integer 반,
        Integer 번호
) {}
