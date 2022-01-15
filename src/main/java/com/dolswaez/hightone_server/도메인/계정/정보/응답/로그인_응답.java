package com.dolswaez.hightone_server.도메인.계정.정보.응답;

import com.fasterxml.jackson.annotation.JsonProperty;

public record 로그인_응답(
        @JsonProperty("loginToken") String 로그인_토큰,
        @JsonProperty("refreshToken") String 새로고침_토큰
) {}
