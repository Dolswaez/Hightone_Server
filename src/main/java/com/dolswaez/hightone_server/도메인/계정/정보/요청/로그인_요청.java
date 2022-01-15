package com.dolswaez.hightone_server.도메인.계정.정보.요청;

import com.fasterxml.jackson.annotation.JsonProperty;

public record 로그인_요청(
        @JsonProperty("id") String 아이디,
        @JsonProperty("password") String 비밀번호
) {}
