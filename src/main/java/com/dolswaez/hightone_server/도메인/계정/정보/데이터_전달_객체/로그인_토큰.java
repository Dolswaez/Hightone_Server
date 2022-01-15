package com.dolswaez.hightone_server.도메인.계정.정보.데이터_전달_객체;

public record 로그인_토큰(
        String 로그인_토큰,
        String 재발급_토큰
) {}
